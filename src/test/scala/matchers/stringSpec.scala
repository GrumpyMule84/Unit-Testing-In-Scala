package matchers

import com.h2.services.CustomerService
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class stringSpec extends AnyFlatSpec with Matchers {
  val customerService = new CustomerService {}

  behavior of "Customer service for strings"

  it should "match the first name of the customer with the start of the email" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1982/12/12")

    val customerID = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerID).get

    customer.email.toString should startWith (customer.first.toLowerCase)
  }

  it should "include 'letters @ . com' in order" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1982/12/12")

    val customerID = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerID).get

    customer.email.toString should include regex "[a-z]+[@.]com"
  }

  it should "fullyMatch date of birth format" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1982/12/12")

    val customerID = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerID).get

    customer.dateOfBirth.toString should fullyMatch regex """[0-9]{4}-[0-9]{2}-[0-9]{2}"""
  }
}
