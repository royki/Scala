//
// program to demonstrate some of the functionality needed for a calculator:
// label to display a numeric value, text field for input, buttons to use
// text input to change numeric value
//
// some things about the layout are not ideal, but this is meant as a simple
// example
//
import scala.swing._

// current calculator value (a Double)
var value = 0.0

// text display of value
val valueLabel = new Label(value.toString)

// component that allows entering/modifying single line of text
val inputField = new TextField(20)
inputField.horizontalAlignment = Alignment.Right
inputField.text = "0"

// make display match value
def updateLabel() = {
  valueLabel.text = value.toString
}

// do arithmetic using value from input field and current value
// (single higher-order function here so we don't have to duplicate
// code to get input, conver to number, and update display)
def arithmetic(op : (Double, Double) => Double) = {
  try {
    val input = inputField.text.toInt
    value = op(value, input)
    updateLabel()
  }
  catch {
    case e:java.lang.NumberFormatException =>
      inputField.text = "Not a number!"
  }
}

// set value back to zero and clear input field
def clear() = {
  value = 0.0
  inputField.text = "0"
  updateLabel()
}

// panel to group the buttons 
val buttonPanel = new FlowPanel { 
  contents += Button("+") ( arithmetic((x,y) => x+y) )
  contents += Button("-") ( arithmetic((x,y) => x-y) )
  contents += Button("Set") ( arithmetic((x,y) => y) )
  contents += Button("Clear") ( clear )
}

// main layout 
val frame = new MainFrame {
    title = "Calculator Prototype"
    // lay out components vertically
    contents = new BoxPanel(Orientation.Vertical) {
      contents += valueLabel
      contents += inputField
      contents += buttonPanel
    }
    //size = new Dimension(400,400)
    centerOnScreen
}

// start up
frame.visible = true

