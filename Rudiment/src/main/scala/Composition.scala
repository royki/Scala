object Composition extends App {

	println("-" * 50)

	{
		// val a: Byte = 1 // 1 byte // 8 bits
		// val b: Short = a // 2 byte // 16 bits
		// val c: Int = b // 4 byte // 32 bits
		// val d: Long = c // 8 byte // 64 bits

		// val e: Float = d // 4 byte // 32 bits
		// val f: Double = e // 8 byte // 64 bits

		// val maxLong: Long = Long.MaxValue
		// val someFloat: Float = maxLong

		// println(" " + maxLong)
		// println(someFloat)
		// println(" " + someFloat.toLong)
		// println(maxLong == someFloat.toLong)

		def a: Byte = b.toByte
		def b: Short = c.toShort
		def c: Int = d.toInt
		def d: Long = e.toLong

		def e: Float = f.toFloat
		def f: Double = Double.MaxValue

		println("Byte\t"+ a)
		println("Short\t"+ b)
		println("Int\t"+ c)
		println("Long\t"+ d)
		println("Float\t"+ e)
		println("Double\t"+ f)

		def isEven(x: Int): Boolean = x % 2 == 0
		def isOdd(x: Int): Boolean = x % 2 !=0

		/*var i = 0
		while(i <= 10){
			if(isOdd(i))
			println(i)
			i += 1
		}*/

		/*1 to 10 foreach { i =>
			if(isOdd(i))
			println(i)
		}*/

		// println(1 to 10: Range.Inclusive)
		// println(1 until 11: Range)
		// println
		// 'a' to 'e' foreach println
		// println
		// println('A' + 1 : Char)

		/*var secondsInMinute = 60
		50 to 60 foreach { i =>
			println(i % secondsInMinute)
		}*/

		/*0 to 12 foreach { i =>
			println(i + "\t" + scala.math.pow(i,2))
		}*/

		/*1 to 10 foreach { i =>
			println(scala.util.Random.nextInt(i))
		}*/

		def random(x: Int): Int = scala.util.Random.nextInt(x)

		def randomZeroOrOne: Int = random(2)

		/*def randomBoolean2: Boolean =
		if(random(2) == 1)
		true
		else
		false*/

		/*def randomBoolean: Boolean =
		random(2) == 1

		1 to 10 foreach { _ =>
			println(randomBoolean)
		}*/

		val x: Int => Int = _ + 5
		val y: Int => Int = _ / 2

		println(x(y(20))) // (20 /2 ) + 5 = 15
		println(y(x(15))) // (15 + 5 ) / 2 = 10

		def rightThenLeft(left: Int => Int, right: Int => Int): Int => Int =
			input => left(right(input))

		val xThenY = rightThenLeft(x, y)
		println(xThenY(20))

		// compose in-built in scala
		val xThenY_compose = x compose y
		println(xThenY_compose(20))

		// andThen in-built in scala
		val xThenY_andThen = y andThen x
		println(xThenY_andThen(20))

		def leftThenRigth(left: Int => Int, right: Int => Int): Int => Int =
			input => right(left(input))

		val yThenX = leftThenRigth(x, y)
		println(yThenX(15))

		// compose in-built in scala
		val yThenX_compose = y compose x
		println(yThenX_compose(15))

		// andThen in-built in scala
		val yThenX_andThen = x andThen y
		println(yThenX_andThen(15))
	}

	println("-" * 50)
}