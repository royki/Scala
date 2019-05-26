// In Scala In-built case class has : compenion object; `==` method; `copy` method; `hasCode`
// no need to instantite a object with `new` keyword;
// no need to declare `class` parameter with `val` keyword
// extends Product
// can apply Pattern Match as well

final case class Homosapiens(name: String, age: Int, isMale: Boolean) {
  def isFemale: Boolean = !isMale
}

