object phFormat extends App {
	def solution(s: String): Unit =  {
		val phoneNumbers = """(123) 555-5847"""

		val phoneRegex = """\((\d{3})\) ((\d{3})-(\d{3}))""".r

		for (m <- phoneRegex.findAllIn(phoneNumbers).matchData) {
			 println(m.group(1)+"-"+m.group(3)+"-"+m.group(4))
		}		
	}		
}