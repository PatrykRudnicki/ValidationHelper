package prudnicki.matchers

trait PredicateOperators {
  implicit class PredicateOpsForFunctions[A](first: A => Boolean) {
    def and(second: A => Boolean): A => Boolean = (arg: A) => first(arg) && second(arg)

    def and(second: Boolean): A => Boolean = (arg: A) => first(arg) && second

    def or(second: A => Boolean): A => Boolean = (arg: A) => first(arg) || second(arg)

    def or(second: Boolean): A => Boolean = (arg: A) => first(arg) || second
  }

  implicit class PredicateOpsForBooleans[A](first: Boolean) {
    def and(second: A => Boolean): A => Boolean = (arg: A) => first && second(arg)

    def and(second: Boolean): Boolean = first && second

    def or(second: A => Boolean): A => Boolean = (arg: A) => first || second(arg)

    def or(second: Boolean): Boolean = first || second
  }
}

object PredicateOperators extends PredicateOperators
