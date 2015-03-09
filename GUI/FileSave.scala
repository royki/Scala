import scala.swing._

//Test to save the file

val textArea = new TextArea

//Frame and Dialogue, specific typeof frame -> MainFrame
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
	title = "My First GUI in Scala"
	contents = textArea
	//contents = Button("Click Me !")(println("Button was Clicked !!! :-)"))
	menuBar = new MenuBar{
		contents += new Menu("File"){
			contents += new MenuItem(Action("Open"){								
				openFile
				println("File Opened")
			})
			contents += new MenuItem(Action("Save"){		
				println("File Saved")				
				saveFile
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


