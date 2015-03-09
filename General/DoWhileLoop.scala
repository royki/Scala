var currentValue = 0.0
var option = ""

do{
	println("Select one of the following options: +, -, *, /, clear, quit")
	println("Current Value =" +currentValue)
	option = readLine.trim
	option match {
	
		case "+" => 
			println("Enter value to add")
			currentValue += readDouble
		case "-" => 
			println("Enter value to subtract")
			currentValue -= readDouble
		case "*" => 
			println("Enter value to multiply")
			currentValue *= readDouble
		case "/" => 
			println("Enter value to divide")
			currentValue /= readDouble
		case "clear" => 		
			currentValue = 0
		case "quit" => 
		case _ => 
			println("This is not a valid enter")
	}

}while(option != "quit")