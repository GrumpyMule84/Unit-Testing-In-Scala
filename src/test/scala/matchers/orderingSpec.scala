package matchers

import com.h2.services.Currency
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class orderingSpec extends AnyFlatSpec with Matchers{

  behavior of "Currency conversion cost comparison"

  it should "report equal costs for two values of 10 USD" in {
    val tenUSD1: Currency = "10 USD"
    val tenUSD3: Currency = "10 USD"

    tenUSD1.costInDollars.amount should be  >= tenUSD3.costInDollars.amount
  }

}
