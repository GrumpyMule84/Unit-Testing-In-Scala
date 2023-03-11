package assertions

import com.h2.entities.Dollars
import org.scalatest.flatspec.AnyFlatSpec

class DollarsSpec extends AnyFlatSpec {

  behavior of "A Dollar"

  it should "Create a correct Dollar object for the number 10 as input" in {
    val tenDollars = Dollars(10)

    assert("$10" === tenDollars.toString)
  }
  it should "Correctly identify that $10 > $5" in {
    val tenDollars = Dollars(10)
    val fiveDollars = Dollars(5)

    assert(tenDollars > fiveDollars)
  }
  it should "Correctly identify that $2 < $5" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assert(twoDollars < fiveDollars)
  }
  it should "successfully add $2 amount" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assertResult("$7") {
      (fiveDollars + twoDollars).toString
    }
  }
  it should "successfully subtract $2 amount" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assertResult("$3") {
      (fiveDollars - twoDollars).toString
    }
  }
  it should "successfully identify that $4 == $4" in {
    val fourDollars = Dollars(4)

    assertResult(true) {
      fourDollars === fourDollars
    }
  }
  it should "throw an exception if an invalid number is passed into Dollars" in {
    assertThrows[ArithmeticException] {
      Dollars(10 / 0)
    }
  }
  it should "not process asserts if there is no data entry" in {
    val dollars: List[Dollars] = List.empty // this passes the assert test without the assume

    assume(dollars.nonEmpty, "The dollars list is empty")

    dollars.foreach { d =>
      assert(d.amount > 0)
    }
  }
}
