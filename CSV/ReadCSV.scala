import scala.io.Source

def readCSVLine(src: Source):Array[String] = {
	var c = if(src.hasNext) src.next else ' '
	var ret = List[String]()
	var inQuotes = false
	var cur = ""
	while(src.hasNext && c!=13){
		if(c == ',' && !inQuotes){
			ret ::= cur 
			cur = ""
		} else if(c =='\"'){
			inQuotes = !inQuotes
		} else if(c == '\\'){
			cur += src.next
		} else {
			cur += c
		}
		c = src.next
	}
	ret ::= cur.trim
	ret.reverse.toArray	
}

val source = Source.fromFile("CO050848_5142.csv")
while(source.hasNext){
	println(readCSVLine(source).mkString(", "))	
}