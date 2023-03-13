package matchers

import com.h2.services.Currency
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class equalitySpec extends AnyFlatSpec with Matchers{

  behavior of "Currency Equals"
  it should "match two 10 dollar currencies using the 'should' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should equal (currency2)
  }

}
