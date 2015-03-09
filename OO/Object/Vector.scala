class Vect3(var x: Double, var y: Double, var z: Double) {
	def +(v: Vect3) = Vect3(x+v.x, y+v.y, z+v.z)
	def -(v: Vect3) = Vect3(x-v.x, y-v.y, z-v.z)
	def dot(v: Vect3) = x*v.x + y*v.y + z*v.z
	def cross(v: Vect3) = Vect3(
							y*v.z - z*v.y, 
							z*v.z - x*v.z,
							x*v.y - y*v.x)
	def unary_-() = Vect3(-x, -y, -z)

	def apply(index: Int): Double = index match {
		case 0 => x
		case 1 => y
		case 2 => z
	}

	def update(index: Int, value: Double): Unit = index match {
		case 0 => x = value
		case 1 => y = value
		case 2 => z = value
	}

	def printForm: String = "("+x+", "+y+", "+z+")"
}

//Companion Object - has the access the private data from the class
// the class also can access the private data from companion object as well
object Vect3 {
	
	def apply(x: Double, y: Double, z: Double) = new Vect3(x,y,z)
	
	def main(args: Array[String]) {
		  		
		val v1 = Vect3(1,2,4)
		val v2 = Vect3(2,3,5)
		println("+ " + (v1+v2).printForm)
		println("- " + (v1-v2).printForm)
		println("dot " + (v1 dot v2))
		println("cross " + (v1 cross v2).printForm)
		println("unary_ " + (-v1).printForm)
		println(v1(0)) // v1(0) expands to v1.apply
		v1(1) = 10   // v1(1) = 10 expands to v1.update(1,10)
		println(v1(1))
	}
}