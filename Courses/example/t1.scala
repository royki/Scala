object t1 extends App {
	abstract class Buffer {
		type T 
		val element: T
	}

	abstract class SeqBuffer {
		type T
		val element: Seq[T]
		def length = element.length
	}

	def newIntBuffer(e1: Int) = new Buffer {
		type T = Int
		val element = e1
	}

	def newIntBuffer(e1: Int*) = new SeqBuffer {
		type T = Int
		val element = e1
	}

	println(newIntBuffer(1).element)
  	println(newIntBuffer(1, 2, 3).length)
}