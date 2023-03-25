package matchers

import com.h2.services.Currency

class containerSpec extends UnitSpec {

  behavior of "Currencies in a wallet"

  it should "contain a currency that is added to the List wallet" in {
    val oneUSD: Currency = "1 USD"
    val twoEuro: Currency = "2 EUR"
    val threeCad: Currency = "3 CAD"

    val wallet = List(oneUSD, twoEuro, threeCad)

    wallet should contain (twoEuro)
  }

  it should "contain a currency that is added to the Set wallet" in {
    val oneUSD: Currency = "1 USD"
    val twoEuro: Currency = "2 EUR"
    val threeCad: Currency = "3 CAD"

    val wallet = Set(oneUSD, twoEuro, threeCad)

    wallet should contain(twoEuro)
  }

  it should "contain a currency that is added to the Map wallet" in {
    val oneUSD: Currency = "1 USD"
    val twoEuro: Currency = "2 EUR"
    val threeCad: Currency = "3 CAD"

    val wallet: Map[String, Currency] = Map(
      "USD" -> oneUSD,
      "Euro" -> twoEuro,
      "CAD" -> threeCad
    )
    wallet should contain ("USD" -> oneUSD)
  }

  it should "contain a oneOf a currency that is added to the wallet" in {
    val oneUSD: Currency = "1 USD"
    val twoEuro: Currency = "2 EUR"
    val threeCad: Currency = "3 CAD"
    val tenPounds: Currency = "10 POU"

    val wallet: Set[Currency] = Set(oneUSD, twoEuro, threeCad)

    wallet should contain oneOf (oneUSD, tenPounds)

  }
}
