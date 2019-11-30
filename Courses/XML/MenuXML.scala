/*import xml._

case class Menu(menu: List[BreakFastMenu])
case class BreakFastMenu(food: List[Menu], price: List[Menu], des: List[Menu], cal: List[Menu])
//case class BreakFastMenu(food: String, price: String, des: String, cal: String)

def toMenu(node : Node): Menu = {
	val food = (node \ "food")
	Menu(menuChart.text)
}

def toBreakFastMenu(node: Node): BreakFastMenu = {
	val name = (node \ "name").map(toMenu).toList
	val price = (node \ "price").map(toMenu).toList
	val des = (node \ "description").map(toMenu).toList
	val cal = (node \ "calories").map(toMenu).toList
	BreakFastMenu(name, price, des, cal)
}

val menuXML = XML.loadFile("simple.xml")
val food = (menuXML \ "food").map(toBreakFastMenu).toArray
food.foreach(println)*/

import xml._

case class Food(food: String, price: String, des: String, cal: String)
case class BreakFastMenu(foodItems: List[Food])

def toFood(node : Node): Food = {        
    val name = (node \ "name").text
    val price = (node \ "price").text
    val des = (node \ "description").text
    val cal = (node \ "calories").text
    Food(name, price, des, cal)
}

val menuXML = XML.load("simple.xml")
val breakFastMenu = BreakFastMenu((menuXML \ "food").map(toFood).toList)
breakFastMenu.foodItems.foreach(println)