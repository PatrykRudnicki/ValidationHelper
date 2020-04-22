package prudnicki.matchers

trait StringValidator {
  val isEmpty: String => Boolean = _.isEmpty

  val nonEmpty: String => Boolean = _.nonEmpty

  val noLongerThan: Int => String => Boolean = (length: Int) => (input: String) => input.length <= length

  val noShorterThan: Int => String => Boolean = (length: Int) => (input: String) => input.length >= length

  val hasSpecificLength: Int => String => Boolean = (length: Int) => (input: String) => input.length == length

  val startWithUppercase: String => Boolean = _.headOption.exists(_.isUpper)

  val startWithLowercase: String => Boolean = _.headOption.exists(_.isLower)

  val startWithDigit: String => Boolean = _.headOption.exists(_.isDigit)

  val isNumeric: String => Boolean = _.forall(_.isDigit)

  val isAlphabetic: String => Boolean = _.forall(_.isLetter)

  val isAlphanumeric: String => Boolean = _.forall(_.isLetterOrDigit)

  val isPalindrome: String => Boolean = (input: String) => input == input.reverse
}

object StringValidator extends StringValidator
