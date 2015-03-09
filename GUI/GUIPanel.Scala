import scala.swing._


val textArea = new TextArea

def openFile {
	val chooser = new FileChooser
	if(chooser.showOpenDialog(null)==FileChooser.Result.Approve){
		val source = scala.io.Source.fromFile(chooser.selectedFile)
		textArea.text = source.mkString		
		source.close()
	}	
}

def saveFile {
	val chooser = new FileChooser
	if(chooser.showSaveDialog(null)==FileChooser.Result.Approve){
		val printWriter = new java.io.PrintWriter(chooser.selectedFile)
		printWriter.print(textArea.text)
		printWriter.close()
	}	
}

val frame = new MainFrame {
	title = "GUIPanel in Scala"
	
	//contents = new BoxPanel(Orientation.Vertical){
	//contents = new FlowPanel{
	contents = new GridPanel(2,2){
		contents += new Label("This is a label.")
		contents += Button("Click")()
		contents += new TextField
		contents += new ComboBox(List("a","b","c","d"))
	}
	
	// import BorderPanel.Position._
	// contents = new BorderPanel{
	// 	layout += new Label("This is a label.") -> North
	// 	layout += Button("Click")() -> West
	// 	layout += new TextField -> South
	// 	layout += new ComboBox(List("a","b","c","d")) -> Center
	// }


	menuBar = new MenuBar{
		contents += new Menu("File"){
			contents += new MenuItem(Action("Open"){								
				openFile
				println("File Opened")
			})
			contents += new MenuItem(Action("Save"){		
				saveFile
				println("File Saved")								
			})
			contents += new Separator			
			contents += new MenuItem(Action("Exit"){
				//ToDO	
				sys.exit(0)
			})
		}
	}

	size = new Dimension(500,500) //java.awt.dimension
	centerOnScreen
}

frame.visible = true