package prudnicki.matchers

import org.scalatest.{MustMatchers, WordSpec}
import StringValidator._

class StringValidatorSpec extends WordSpec with MustMatchers {

  "String validator" should {
    "validate empty string" in {
      isEmpty("") mustBe true
      isEmpty("Non empty string") mustBe false
    }

    "validate non empty string" in {
      nonEmpty("") mustBe false
      nonEmpty("Non empty string") mustBe true
    }

    "validate maximum length of the string" in {
      noLongerThan(1)("a") mustBe true
      noLongerThan(1)("ab") mustBe false
    }

    "validate minimum length of the string" in {
      noShorterThan(1)("") mustBe false
      noShorterThan(1)("a") mustBe true
    }

    "validate specific length of the string" in {
      hasSpecificLength(2)("ab") mustBe true
      hasSpecificLength(1)("ab") mustBe false
    }

    "validate uppercase as a first character of the string" in {
      startWithUppercase("Abc") mustBe true
      startWithUppercase("abc") mustBe false
    }

    "validate lowercase as a first character of the string" in {
      startWithLowercase("abc") mustBe true
      startWithLowercase("Abc") mustBe false
    }

    "validate digit as a first character of the string" in {
      startWithDigit("abc") mustBe false
      startWithDigit("1abc") mustBe true
    }

    "validate string contains only numeric characters" in {
      isNumeric("abc") mustBe false
      isNumeric("1a2b3c") mustBe false
      isNumeric("123") mustBe true
    }

    "validate string contains only alphabetic characters" in {
      isAlphabetic("AbCd") mustBe true
      isAlphabetic("abcd") mustBe true
      isAlphabetic("ABCD") mustBe true
      isAlphabetic("12abc") mustBe false
    }

    "validate string contains only alphanumeric characters" in {
      isAlphanumeric("123abc") mustBe true
      isAlphanumeric("1@3a$c") mustBe false
    }
  }
}
