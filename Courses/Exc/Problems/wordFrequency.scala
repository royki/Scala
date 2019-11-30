object wordFrequency extends App {
	
	def wordFrequency(dict: List[String]): List[(String, Int)] = dict match {		
		case Nil => Nil
		case _ => dict.groupBy(x => x).map(y => (y._1, y._2.length)).toList
	}
}