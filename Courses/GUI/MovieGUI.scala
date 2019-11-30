import scala.swing._
import scala.swing.event._
import BorderPanel.Position._
import scala.io.Source

case class Movie(title: String, year: Int, rating: String, description: String)

var movies = Array[Movie]()
var selectedIndex = -1

val movieList = new ListView(movies.map(_.title)) {
	listenTo(selection)
	reactions += {
		case e:SelectionChanged => 
		selectedIndex = selection.leadIndex
		val movie = movies(selectedIndex)
		titleField.text = movie.title
		yearField.text = movie.year.toString
		ratingComboBox.selection.item = movie.rating
		descriptionArea.text = movie.description
		//println(selection.leadIndex)
	}
}
val titleField: TextField = new TextField {
	listenTo(this)
	reactions += {
		case e: EditDone => 
			//val index => movieList.selection.leadIndex
			movies(selectedIndex) = movies(selectedIndex).copy(title = text)
			movieList.listData = movies.map(_.title)
	}
}
val yearField = new TextField {
	listenTo(this)
	reactions += {
		case e: EditDone => 
			//val index => movieList.selection.leadIndex
			movies(selectedIndex) = movies(selectedIndex).copy(year = text.toInt)			
	}
}
val ratingComboBox = new ComboBox(List("G","PG","PG-13","R","NC-17","NR")) {
	listenTo(selection)
	reactions += {
		case e: SelectionChanged => 
			movies(selectedIndex) = movies(selectedIndex).copy(rating = selection.item)
	}
}
val descriptionArea = new TextArea {
	listenTo(this)
	reactions += {
		case e: FocusLost => 
			//val index => movieList.selection.leadIndex
			movies(selectedIndex) = movies(selectedIndex).copy(description = text)			
	}
}

def OpenFIle {
	val chooser = new FileChooser
	if(chooser.showOpenDialog(movieList)==FileChooser.Result.Approve) {
		val source = Source.fromFile(chooser.selectedFile)
		val lines = source.getLines
		movies = Array.fill(lines.next.toInt) {			
			val title = lines.next
			val year = lines.next.toInt
			val rating = lines.next
			var desc = ""			
			var line = lines.next
			while(line!="."){
				desc += line+"\n"
				line = lines.next
			}
			Movie(title,year,rating,desc)
		}
		source.close()
		movieList.listData = movies.map(_.title)
	}
}

def SaveFIle {
	val chooser = new FileChooser
	if(chooser.showOpenDialog(movieList)==FileChooser.Result.Approve){
		val pw = new java.io.PrintWriter(chooser.selectedFile)
		pw.println(movies.length)
		for(m <- movies){
			pw.println(m.title)
			pw.println(m.year)
			pw.println(m.rating)
			pw.println(m.description)
			pw.println(".")
		}
		pw.close()
	}
}

val frame = new MainFrame {
	title = "Movie Data"
	contents = new SplitPane (Orientation.Horizontal,
		new ScrollPane (movieList),
			new BorderPanel {			
				layout += new GridPanel(3,1){
					contents += new BorderPanel {
						layout += new Label("Title") -> West
						layout += titleField -> Center
					}
				contents += new BorderPanel {
					layout += new Label("Year") -> West
					layout += yearField -> Center
				}				
				contents += ratingComboBox
			} -> North
			layout += new ScrollPane(descriptionArea) -> Center
		}
	)
	menuBar = new MenuBar{
		contents += new Menu("File") {
			contents += new MenuItem(Action("Open")(OpenFIle))
			contents += new MenuItem(Action("Save")(SaveFIle))
			contents += new Separator
			contents += new MenuItem(Action("Exit")(sys.exit(0)))			
		}
	}
	size = new Dimension(800,600)
	centerOnScreen()
}

frame.visible = true