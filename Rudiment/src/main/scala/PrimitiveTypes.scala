object PrimitiveTypes extends App {

  println("-" * 50)

  // val a: Byte = 1 // 1 Bytes

  // val b: Short = 2 // 2 Bytes
  // val c: Char = 'c' // 2 Bytes

  // val d: Int = 4 // 4 Bytes
  // val e: Long = 8 // 8 Bytes

  // val f: Float = 0.4f // 4 Bytes
  // val g: Double = 0.8 // 8 Bytes

  // val h: Boolean = true // false

  // val i: Unit = {} // {}

  // println(a)
  // println(b)
  // println(c)
  // println(d)
  // println(e)
  // println(f)
  // println(g)
  // println(h)
  // println(i)
  // println(8.toOctalString)
  // println(16.toHexString)

  {
    def signedBits(n: Long): Int = unsignedBits(n) + 1
    def unsignedBits(n: Long): Int = n.toBinaryString.size //toBinary(n).size

    def unsignedBits2(n: Long): Int = {
      @scala.annotation.tailrec
      def loop(x: Long, accu: Int): Int = {
        if (x <= 1)
          1 + accu
        else loop(x    = x / 2, accu = 1 + accu)
      }
      loop(n, 0)
    }

    def toBinary(n: Long): String = {
      @scala.annotation.tailrec
      def loop(x: Long, accu: String): String = {
        // if(x == 0)
        if (x <= 1)
          (x % 2).toString + accu
        else loop(x    = x / 2, accu = (x % 2).toString + accu)
      }
      /*
				if(n == 0)
				"0"
				else
				loop(n, "")
				*/
      loop(n, "")
    }
    // println(toBinary(0))
    // println(toBinary(1))
    // println(toBinary(2))
    // println(toBinary(3))
    // println(toBinary(4))
    // println(toBinary(75))
    // println(75.toBinaryString)
    // println(unsignedBits(75))
    // println(unsignedBits(4))
    // println(signedBits(4))

    def rendered(`type`: String, min: Long, max: Long, bits: Int): String = {
      val bytes = bits / 8

      s"${`type`}\thas $bits\t binary digits(bits), which is $bytes bytes with \tpossible values(min and max): $min to $max"
    }

    def renderedSigned(`type`: String, min: Long, max: Long): String =
      rendered(`type`, min, max, signedBits(max))

    def renderedUnSigned(`type`: String, min: Long, max: Long): String =
      rendered(`type`, min, max, unsignedBits(max))

    def renderedFloating(`type`: String, min: Double, max: Double): String =
      s"${renderedFirstHalf(`type`)} $min to $max"

    def renderedFirstHalf(`type`: String): String =
      s"${`type`}\t\t\t\t\t\t\t\tpossible values:"

    println(renderedSigned("Byte ", Byte.MinValue, Byte.MaxValue))
    println()
    println(renderedSigned("Short ", Short.MinValue, Short.MaxValue))
    println(renderedUnSigned("Char ", Char.MinValue, Char.MaxValue))
    println()
    println(renderedSigned("Int ", Int.MinValue, Int.MaxValue))
    println(renderedSigned("Long ", Long.MinValue, Long.MaxValue))
    println
    println(renderedFloating("Float ", Float.MinValue, Float.MaxValue))
    println(renderedFloating("Double ", Double.MinValue, Double.MaxValue))
    println()
    println(s"${renderedFirstHalf("Unit")}, ${()} and {}")

  }

  println("-" * 50)

}
