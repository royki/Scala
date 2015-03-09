def match(arg: Any)  {
	arg match {
		case 42 => print("Any to match Integer")
		case "Mark" => print("Any to match String")
		case (a,b) => print("It is a tuple to match Any" + a + "and" + b)
		case x:Double => print("Any match to double" + x)
		case i:Int => print("Any match to Integer")
		case _ => print("Default Match") 
	}
	
}