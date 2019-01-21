package prudnicki.matchers

import org.scalatest.{MustMatchers, WordSpec}
import PredicateOperators._

class PredicateOperatorsSpec extends WordSpec with MustMatchers {

  "Predicate operations" should {
    "correctly apply and logic for booleans" in {
      (true and true) must be(true)
      (true and false) must be(false)
      (false and true) must be(false)
      (false and false) must be(false)
    }

    "correctly apply or logic for booleans" in {
      (true or true) must be(true)
      (true or false) must be(true)
      (false or true) must be(true)
      (false or false) must be(false)
    }

    "correctly apply and logic for function and boolean" in {
      val fun = (input: String) => input.contains("a")

      (fun("a") and true) must be(true)
      (fun("a") and false) must be(false)
      (true and fun("a")) must be(true)
      (false and fun("a")) must be(false)

      (fun("b") and true) must be(false)
      (fun("b") and false) must be(false)
      (true and fun("b")) must be(false)
      (false and fun("b")) must be(false)
    }

    "correctly apply or logic for function and boolean" in {
      val fun = (input: String) => input.contains("a")

      (fun("a") or true) must be(true)
      (fun("a") or false) must be(true)
      (true or fun("a")) must be(true)
      (false or fun("a")) must be(true)

      (fun("b") or true) must be(true)
      (fun("b") or false) must be(false)
      (true or fun("b")) must be(true)
      (false or fun("b")) must be(false)
    }

    "correctly apply and logic for two functions" in {
      val fun1 = (input: String) => input.contains("a")
      val fun2 = (input: String) => input.contains("b")

      (fun1("a") and fun2("b")) must be(true)
      (fun1("a") and fun2("a")) must be(false)
      (fun1("b") and fun2("b")) must be(false)
      (fun1("b") and fun2("a")) must be(false)
    }

    "correctly apply or logic for two functions" in {
      val fun1 = (input: String) => input.contains("a")
      val fun2 = (input: String) => input.contains("b")

      (fun1("a") or fun2("b")) must be(true)
      (fun1("a") or fun2("a")) must be(true)
      (fun1("b") or fun2("b")) must be(true)
      (fun1("b") or fun2("a")) must be(false)
    }
  }
}
