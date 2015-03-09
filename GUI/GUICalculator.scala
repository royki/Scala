import scala.swing._
import scala.swing.event._
import BorderPanel.Position._

val textArea = new TextArea

val numPanel = new FlowPanel { 
  	contents += Button("0") ()
  	contents += Button("1") () 
  	contents += Button("2") () 
  	contents += Button("3") () 
  	contents += Button("4") () 
  	contents += Button("5") () 
  	contents += Button("6") () 
  	contents += Button("7") ()
  	contents += Button("8") ()
  	contents += Button("9") ()
}

val operatorPanel = new BoxPanel(Orientation.Horizontal) {
	contents += Button("+") () 
	contents += Button("-") () 
	contents += Button("*") () 
	contents += Button("/") () 
	contents += Button("Clear") () 
}

val frame = new MainFrame {
	title = "Calculator in Scala"	
	contents = new SplitPane(Orientation.Horizontal)
	menuBar = new MenuBar {
		contents += new Menu("View") {
			contents += new MenuItem(Action("Standard") {
				//TODO
			})
		}
			contents += new Menu("Help") {
				contents += new MenuItem(Action("Exit") {
					sys.exit(0)
			})
		}		
	}
	
	contents = new GridPanel(3,0) {		
		contents += new ScrollPane(textArea)
		//contents += new Separator
		contents += numPanel
		contents += operatorPanel
	}
	
	size = new Dimension(400,400)
	centerOnScreen
}

frame.visible = true

