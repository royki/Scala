
// declared parameter with `val` to expose the member
final class Human(val name: String, val age: Int, val isMale: Boolean) extends Product with Serializable {

  def isFemale: Boolean = !isMale

  // for `class` name; override default `toString`
  override def toString: String = {
    // s"Human($name, $age, $isMale)"
    s"productPrefix($name, $age, $isMale)"

  }

  // `equals` method
  override def equals(other: Any): Boolean = other match {
    case that: Human if that canEqual this =>
      this.name == that.name &&
        this.age == that.age &&
        this.isMale == that.isMale

    case _ => false
  }

  // Copy
  def copy(name: String = this.name, age: Int = this.age, isMale: Boolean = this.isMale): Human = Human(name, age, isMale)

  // HashCode
  override def hashCode: Int = /*age.hashCode*/
    41 * (41 * (41 + name.hashCode) + age.hashCode) + isMale.hashCode

  // Members declared in scala.Equals
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Human]
  // Members declared in scala.Product
  override def productArity: Int = 3
  override def productElement(n: Int): Any = n match {
    case 0 => name
    case 1 => age
    case 2 => isMale
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = Human.toString

}

// Function3 : extends ((String, Int, Boolean) => Human)
object Human extends ((String, Int, Boolean) => Human) {

  // object instantion with `new`
  override def apply(name: String, age: Int, isMale: Boolean): Human = new Human(name, age, isMale)

  // Companion object
  override def toString: String = "Human"

  // `unapply` for case class
  type Answer[+A] = {
    def isEmpty: Boolean
    def get: A
  }

  // `unapply` retunrs structural type
  // def unapply(human: Human): Answer[(String, Int, Boolean)] =
  def unapply(human: Human): Option[(String, Int, Boolean)] =
    if (human == null)
      None
    else
      Some(
        (
          human.name,
          human.age,
          human.isMale
        )
      )

}

