package prudnicki.matchers

trait IterableValidator {

  def isEmpty[A]: Iterable[A] => Boolean = (input: Iterable[A]) => input.isEmpty

  def nonEmpty[A]: Iterable[A] => Boolean = (input: Iterable[A]) => input.nonEmpty

  def noMoreElementsThan[A]: Int => Iterable[A] => Boolean =
    (noOfElements: Int) => (input: Iterable[A]) => input.toList.length <= noOfElements

  def noLessElementsThan[A]: Int => Iterable[A] => Boolean =
    (noOfElements: Int) => (input: Iterable[A]) => input.toList.length >= noOfElements

  def hasSpecificLength[A]: Int => Iterable[A] => Boolean =
    (length: Int) => (input: Iterable[A]) => input.toList.length == length

  def contains[A]: A => Iterable[A] => Boolean = (elem: A) => (input: Iterable[A]) => input.filter(_ == elem).nonEmpty

  def isEqualTo[A]: Iterable[A] => Iterable[A] => Boolean =
    (firstSeq: Iterable[A]) => (secondSeq: Iterable[A]) => firstSeq == secondSeq

  def containsTheSameElements[A]: Iterable[A] => Iterable[A] => Boolean =
    (first: Iterable[A]) => (second: Iterable[A]) => first.toSeq.diff(second.toSeq).isEmpty && second.toSeq.diff(first.toSeq).isEmpty
}

object IterableValidator extends IterableValidator
