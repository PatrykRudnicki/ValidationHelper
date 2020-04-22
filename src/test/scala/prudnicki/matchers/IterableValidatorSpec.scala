package prudnicki.matchers

import org.scalatest.{MustMatchers, WordSpec}
import IterableValidator._

class IterableValidatorSpec extends WordSpec with MustMatchers {

  "Iterable validator" should {
    "validate empty sequence" in {
      isEmpty(Seq("test")) mustBe false
      isEmpty(Seq.empty) mustBe true
    }

    "validate non empty sequece" in {
      nonEmpty(Seq("test")) mustBe true
      nonEmpty(Seq.empty) mustBe false
    }

    "validate no more elements in the sequence" in {
      noMoreElementsThan(5)(Seq.fill(5)("test")) mustBe true
      noMoreElementsThan(5)(Seq.fill(4)("test")) mustBe true
      noMoreElementsThan(5)(Seq.fill(6)("test")) mustBe false
    }

    "validate no less elements in the sequence" in {
      noLessElementsThan(5)(Seq.fill(5)("test")) mustBe true
      noLessElementsThan(5)(Seq.fill(6)("test")) mustBe true
      noLessElementsThan(5)(Seq.fill(4)("test")) mustBe false
    }

    "validate specific length of the sequence" in {
      hasSpecificLength(0)(Seq.empty) mustBe true
      hasSpecificLength(5)(Seq.fill(5)("test")) mustBe true
      hasSpecificLength(2)(Seq.fill(5)("test")) mustBe false
    }

    "validate if sequence contains element" in {
      contains("test")(Seq("test", "test1")) mustBe true
      contains("test")(Seq("test1", "test2")) mustBe false
    }

    "validate if the sequence is equal to another sequence" in {
      val testSeq = Seq("test1", "test2")
      isEqualTo(testSeq)(testSeq) mustBe true
      isEqualTo(testSeq)(Seq.empty) mustBe false
    }

    "validate if the sequence contains the same element" in {
      val firstSeq = Seq("test1", "test2")
      val secondSeq = Seq("test2", "test1")
      containsTheSameElements(firstSeq)(secondSeq) mustBe true
      containsTheSameElements(firstSeq)(secondSeq :+ "test3") mustBe false
    }
  }
}
