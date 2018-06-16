object findElement extends App {
	
	def findElement(s: List[String], n: String): String = {
		s.find(x => x == n)
	}
}