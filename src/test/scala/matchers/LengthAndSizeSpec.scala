package matchers

import com.h2.services.CustomerService

import java.util.UUID

class LengthAndSizeSpec extends UnitSpec {
  val customerService: CustomerService = new CustomerService {}

  behavior of "CustomerService for length"

  it should "return correct length for customer's first and last name" in {
    val (first, last, email, datOfBirth) = ("John", "Smith", "john@smith.com", "1983/12/21")

    val customerID = customerService.createNewCustomer(first, last, email, datOfBirth)
    val customer = customerService.getCustomer(customerID).get

    customer.first should have length first.length
    customer.last should have length last.length
  }
  behavior of "CustomerService for size"

  it should "return the correct number of customers" in {
    val newCustomers: Seq[(String, String, String, String)] = List(
      ("John", "Smith", "john@smith.com", "1983/12/21"),
      ("Jack", "Sprat", "jack@sprat.com", "1972/05/04")
    )

    val customerIDs: Seq[UUID] = newCustomers.map(newCustomer =>
    customerService.createNewCustomer(newCustomer._1, newCustomer._2, newCustomer._3, newCustomer._4))

    customerIDs should have size 2
  }

}
