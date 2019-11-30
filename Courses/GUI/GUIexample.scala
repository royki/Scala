/* This script will create a window to demonstrate different GUI objects and
 * syntax options with the scala.swing library, which is used to make things like windows,
 * buttons, tabs, scroll bars, etc.
 * 
 * This example window will contain a total of 6 tabs: 4 tabs to show different scala Panels,
 * 1 tab to show the SplitPane, and 1 tab to show UI Components
 */

/* These libraries need to be imported to write GUI code that responds to user input
 * Libraries are actually kept in a hierarchical order -- general libraries at the top,
 * and more specific libraries as you go down. The "."s in a library name traverse this
 * library hierarchy or tree.
 * The _ is used to import ALL libraries at a specific level in the library hierarchy
 */
import scala.swing._
import scala.swing.event._

/* This script is going to show all of the different kinds of panels/panes in different 
 * tabs, so there will be a TabbedPane inside of our MainFrame, and each tab will show
 * a different type of pane/panel (other than the TabbedPane)
 * 
 * The contents for each tab are created here as separate panels, and are added into the 
 * TabbedPane later in the code
 *
 * In most of the examples below, a series of Buttons are placed into each panel to show
 * how the panels/panes layout their contents.
 */

//A BoxPanel places UI elements in either a single row or column, as determined by the 
//Orientation argument.  In this example, everything is placed on a single row.
val box:BoxPanel = new BoxPanel(Orientation.Horizontal) {
  for(i <- 1 to 20) contents += Button(i.toString)({println("Box:Button:"+i)})
}

//A FlowPanel "wraps-around" UI elements based on the window size going from left -> right
//and then top -> bottom as horizontal space runs out.
val flow:FlowPanel = new FlowPanel {
  for(i <- 1 to 20) contents += Button(i.toString)({println("Flow:Button:"+i)})
}

//A GridPanel places UI elements into a grid with the number of rows & columns specified
//as the 2 arguments to the GridPanel constructor. UI elements are added across rows, starting
//from the top-most row
val grid:GridPanel = new GridPanel(5,6) {
  for(i <- 1 to 25) contents += Button(i.toString)({println("Grid:Button:"+i)})
}

//A BorderPanel can contain up to 5 UI elements: 1 in the Center, and 1 each along every
//edge (N, E, S, & W). UI elements are added in 2-Tuples, each containing the UI element 
//first, and then the location to place them second.
val bord:BorderPanel = new BorderPanel() {
  layout += Button("North")({println("Border:North")}) -> BorderPanel.Position.North
  layout += Button("South")({println("Border:South")}) -> BorderPanel.Position.South
  layout += Button("East")({println("Border:East")}) -> BorderPanel.Position.East
  layout += Button("West")({println("Border:West")}) -> BorderPanel.Position.West
  layout += Button("Center")({println("Border:Center")}) -> BorderPanel.Position.Center
}

//SplitPanes contain exactly 2 UI elements with a divider in between.  The constructor takes
//3 arguments: the orientation, the 1st UI element, and then the 2nd UI element. Note here
//that the UI elements are un-named, meaning that they are not given a val/var name, but 
//instead are created with constructor calls within the argument list to the SplitPane
//constructor.  In this case, 2 more BoxPanels containing buttons are made. The 1st BoxPanel
//is created without scroll bars, and the 2nd is placed inside of a ScrollPane, which adds
//scroll bars to this BoxPanel.
val split:SplitPane = new SplitPane(Orientation.Vertical, 
  new BoxPanel(Orientation.Vertical) {  //This is the 1st UI element in the split
    for(i <- 1 to 20)
      contents += Button(i.toString)({println("SplitLeft:Button:"+i)})
  },
  new ScrollPane() {  //This is the 2nd UI element in the split; it's a ScrollPane that contains...
    contents = new BoxPanel(Orientation.Vertical) {  //Another BoxPanel with buttons
      for(i <- 1 to 20)
        contents += Button(i.toString)({println("SplitRight:Scroll:Button"+i)})
    }  
  })

/* The last tab of our example window will show some of the different kinds of lower-level
 * UI elements that can be placed with the scala.swing._ library.
 * Here, these components are created, and these elements are later added to a Panel that
 * will be placed into the last tab
 */
 
//A Label is an un-editable (static) piece of text
val label = new Label("A static label")

//A TextField is a user-editable (changeable) single line of text
//It contains a data field called "text" that is a String containing the text shown
//This can change if the user types into this TextField. It can be changed or referred to
//later through dot notation.
val txtField = new TextField { text = "Default text for the field" }

//A TextArea is similar to a TextField, but can span multiple lines of text
val txtArea = new TextArea()
txtArea.text = "Log of triggered events:"

//A CheckBox is a simple toggle (true/false) with a label attached to it. The label is given
//as a String argument to the constructor. Whether the box is checked or not is in the 
//data field called "selected" -- this can be assigned to, or read from, using dot notation
val cb1 = new CheckBox("An initially unselected CheckBox")
val cb2 = new CheckBox("An initially selected CheckBox")
cb2.selected = true

//A Slider is a "line with a handle" that the user can manipulate to choose a value. The 
//important data fields of a slider are min, max, and value. When the user moves the handle
//the field "value" will change, and can be accessed later with dot notation.
val slider = new Slider { min = 0; max = 100; value = 25 }

val fruit = Array("Apples","Bananas","Cherries") //An example Collection used below

//A ComboBox is a list of items that the user can select 1 or more of. It takes a collection
//of strings (eg. Array[String]) as an argument to the constructor to determine the items
//in the list
val combo = new ComboBox(fruit)

//A ListView is a "drop down" list that enables the user to select exactly 1 item. It is
//constructed similarly to a ComboBox
val list = new ListView(fruit)

//A RadioButton is a label with a (usually) circular indicator next to the label. These
//are most commonly used to allow a user to select 1 of a group of items. However, 
//RadioButtons can stand-alone, similar to a CheckBox. In order to limit the user to selecting
//a single button out of a set of RadioButtons, they need to be placed into a ButtonGroup.
//A ButtonGroup has a data field called "buttons" that is a collection containing all of
//the related RadioButtons, and causes only 1 to be selected at a time.
val btnGrp = new ButtonGroup {
  for(f <- fruit) buttons += new RadioButton(f)
}

/* Using the UI components made above, this section creates a SplitPane whose left side 
 * contains all of the UI elements inside of a BoxPanel. Here, the UI pieces are added
 * to the contents collection using the ++= operator.  Recall that ++ is used to concatenate
 * two Arrays together, and that is what this operator is doing here; so the right side
 * of the ++= operator should be a collection, rather than a single UI element.  We could
 * add each element separately using the += operator.
 *
 * The right side of the SplitPane contains a single TextArea that will be used to show 
 * the "events" that a user generates from the elements on the left
 */
val components:SplitPane = new SplitPane(Orientation.Vertical, 
  new BoxPanel(Orientation.Vertical) {
    contents ++= List(label,txtField,cb1,cb2,slider,combo,list)
    contents ++= btnGrp.buttons
  },
  new ScrollPane() {
    contents = txtArea
  })

/* The MainFrame of this script contains a TabbedPane as its 1 UI element, and this TabbedPane
 * contains tabs to hold each of the panes/panels created above.
 *
 * In order to "monitor" the user's interaction with these UI elements, this window uses the
 * "listenTo" method of the MainFrame to add UI elements that we want to monitor.
 * When user interaction occurs, this creates "events" that can be reacted to. The data field
 * of MainFrame called "reactions" contains code blocks for how to respond to the events
 * generated. In this case, we are processing all events in the same way, by simply appending
 * the type of event that occurred to the TextArea contained in the right side of the SplitPane
 * on the last tab.
 */
val frame = new MainFrame {
  title = "Gui Examples"
  preferredSize = new Dimension(800,600)
  contents = new TabbedPane() {
    pages += new TabbedPane.Page("BoxPanel",box)
    pages += new TabbedPane.Page("BorderPanel",bord)
    pages += new TabbedPane.Page("FlowPanel",flow)
    pages += new TabbedPane.Page("GridPanel",grid)
    pages += new TabbedPane.Page("SplitPane",split)
    pages += new TabbedPane.Page("Components",components)
  }
  listenTo(txtField,cb1,cb2,slider,combo.selection,list.selection)
  for(button <- btnGrp.buttons) listenTo(button)
  reactions += {
    case e:Event => txtArea.text += "\n"+e.getClass
  }
}

frame.visible = true




