package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec{
  behavior of "An email"

  it should "return an email object for a valid email string" in {
    val email = Email("cam@hotmail.com")

    assert(email.localPart === "cam")
    assert(email.domain === "hotmail.com")
  }
  it should "return a new email for a new email string" in {
    val email1 = Email("cam@hotmail.com")
    val email2 = Email("steve@yahoo.com")

    assertResult(false) {
      email1 === email2
    }
  }
  it should "not accept an email with no @ symbol" in {

    assertThrows[IllegalArgumentException] {
      val email = Email("camhotmail.com")
    }
  }
  it should "not accept an email with multiple @ symbols" in {

    assertThrows[IllegalArgumentException] {
      val email = Email("cam@h@hotmail.com")
    }
  }
  it should "intercept the correct message when an exception is thrown for multiple '@'" in {
    val exception = intercept[IllegalArgumentException] {Email("cam@h@hotmail.com")}

    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("invalid email: should not contain '@' symbol more than once"))
    }
  it should "intercept the correct message when an exception is thrown for no '@'" in {
    val exception = intercept[IllegalArgumentException] {Email("camhotmail.com")}

    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("invalid email: does not contain '@' symbol"))
  }

}
