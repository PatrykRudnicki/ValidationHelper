package prudnicki.matchers

import org.scalatest.{MustMatchers, WordSpec}
import StringValidator._

class StringValidatorSpec extends WordSpec with MustMatchers {

  "String validation" should {
    "validate empty string" in {
      isEmpty("") must be(true)
      isEmpty("Non empty string") must be(false)
    }

    "validate non empty string" in {
      nonEmpty("") must be(false)
      nonEmpty("Non empty string") must be(true)
    }

    "validate maximum length of the string" in {
      noLongerThan(1)("a") must be(true)
      noLongerThan(1)("ab") must be(false)
    }

    "validate minimum length of the string" in {
      noShorterThan(1)("") must be(false)
      noShorterThan(1)("a") must be(true)
    }

    "validate specific length of the string" in {
      hasSpecificLength(2)("ab") must be(true)
      hasSpecificLength(1)("ab") must be(false)
    }

    "validate uppercase as a first character of the string" in {
      startWithUppercase("Abc") must be(true)
      startWithUppercase("abc") must be(false)
    }

    "validate lowercase as a first character of the string" in {
      startWithLowercase("abc") must be(true)
      startWithLowercase("Abc") must be(false)
    }

    "validate digit as a first character of the string" in {
      startWithDigit("abc") must be(false)
      startWithDigit("1abc") must be(true)
    }

    "validate string contains only numeric characters" in {
      isNumeric("abc") must be(false)
      isNumeric("1a2b3c") must be(false)
      isNumeric("123") must be(true)
    }

    "validate string contains only alphabetic characters" in {
      isAlphabetic("AbCd") must be(true)
      isAlphabetic("abcd") must be(true)
      isAlphabetic("ABCD") must be(true)
      isAlphabetic("12abc") must be(false)
    }

    "validate string contains only alphanumeric characters" in {
      isAlphanumeric("123abc") must be(true)
      isAlphanumeric("1@3a$c") must be(false)
    }
  }

}
