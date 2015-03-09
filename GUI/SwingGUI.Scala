import scala.swing._

//Frame and Dialogue, specific typeof frame -> MainFrame

val frame = new MainFrame {
	title = "My First GUI in Scala"
	contents = Button("Click Me !")(println("Button was Clicked !!! :-)"))
	size = new Dimension(500,500) //java.awt.dimension
	centerOnScreen
}

frame.visible = true


