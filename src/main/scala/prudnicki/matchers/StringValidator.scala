package prudnicki.matchers

trait StringValidator {
  val isEmpty: String => Boolean = (input: String) => input.isEmpty

  val nonEmpty: String => Boolean = (input: String) => input.nonEmpty

  val noLongerThan: Int => String => Boolean = (length: Int) => (input: String) => input.length <= length

  val noShorterThan: Int => String => Boolean = (length: Int) => (input: String) => input.length >= length

  val hasSpecificLength: Int => String => Boolean = (length: Int) => (input: String) => input.length == length

  val startWithUppercase: String => Boolean = (input: String) => input.headOption.exists(_.isUpper)

  val startWithLowercase: String => Boolean = (input: String) => input.headOption.exists(_.isLower)

  val startWithDigit: String => Boolean = (input: String) => input.headOption.exists(_.isDigit)

  val isNumeric: String => Boolean = (input: String) => input.forall(_.isDigit)

  val isAlphabetic: String => Boolean = (input: String) => input.forall(_.isLetter)

  val isAlphanumeric: String => Boolean = (input: String) => input.forall(_.isLetterOrDigit)
}

object StringValidator extends StringValidator
