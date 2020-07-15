object Literals extends App {

  println("-" * 50)

  {
    // val a: Byte = 127
    val a: Byte = 0x7F // 0x7f // 127
    println(a)

    val b: Long = 9223372036854775807L // Long.MaxValue
    println(b)

    val c: Char = 65 // 'A' // 0x41 // 0x0041 // '\u0041'
    println(c)
    println(c.toInt)
    // val c: Char = '\u0ffff'
    // println(Char.MaxValue: Int)
    // println(Char.MaxValue.toInt)
    // println(Char.MaxValue.toHexString)
    // println(Char.MaxValue.toBinaryString)

    val d: Float = 0.5f // 0.5 // 0.5F
    println(d)

    val e: Double = 0.6 // 0.6d // 0.6D
    println(e)

    val f: Boolean = true
    println(f)

    val g: String = """Hello Scala"""
    println(g)

    // val h: Symbol = 'Coucou // println('Coucou)
    val h = Symbol("Coucou")
    println(h)

    println("Line Feed (LF)")
    println("Hello\nScala")
    println()

    println("Form Feed (FF)")
    println("Hello\fScala")
    println()

    println("Horizontal Tab (HT)")
    println("Hello\tScala")
    println()

    println("Backspace (BS)")
    println("Hello\bScala")
    println()

    println("Carriage Return (CR)")
    println("Hello\rScala")
    println("Hello1234\rScala")
    println("Hello1234\u001b[2K\rScala")
    println()

    println("Double Quote (\"\")")
    println("Hello \"S\"cala")
    println()

    println("Backslace (\\)")
    println("Hello \\Scala")
    println()

    println("Raw String")
    println {
      """|hello\n\t\r""\"
			|scala""".stripMargin
    }
    println()

    val i: Int => Int = x => x + 1 // Function Literal
    println(i(10))
    println()

    // Instead of Using any name, we can use "_", as a wildcard; then we don't need to use twice the wildcard.
    // x => x + 1 is same as _ + 1
    val j: Int => Int = _ + 1
    println(j(12))
    println()

    val k: (Int, Int) => Boolean =
      (left, right) => left == right

    println(k(12, 13))
    println()

    val syntacticsuger_of_k: (Int, Int) => Boolean =
      _ == _
    println(syntacticsuger_of_k(4, 4))

  }
  //   {
  def now: String = {
    val formatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")
    java.time.LocalDateTime.now.format(formatter)
  }

  def inOneLine(in: String): String = {
    val clearLine = "\u001b[2K"
    val carriageReturn = "\r"

    clearLine + carriageReturn + in
  }

  /*var i = 0
		while(i < 5) {
			Thread.sleep(1 * 1000)
			print(inOneLine(now))
			i += 1
		}*/
  //   }
  println("-" * 50)
}
