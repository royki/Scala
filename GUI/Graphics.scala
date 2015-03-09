import swing._
import event._
import BorderPanel.Position._
import java.awt.geom._
import java.awt.{Color, LinearGradientPaint, MultipleGradientPaint, BasicStroke, Font}

var rectangleColors = Array(Color.red, Color.blue, Color.green)
var currentColor = 1
var clipX = 0
var clipY = 0

val drawPanel = new Panel {
	override def paint(g: Graphics2D) {
		g.setPaint(Color.white)
		g.fill(new Rectangle2D.Double(0,0,size.width, size.height))
		//g.setPaint(Color.red)
		//g.setClip(new Ellipse2D.Double(clipX,clipY,100,100))
		g.setPaint(rectangleColors(currentColor))
		g.fill(new Rectangle2D.Double(100,100,100,100))
		g.setPaint(new LinearGradientPaint(300,200,350,200,Array(0.0f,0.5f,1.0f),
			Array(Color.green,Color.blue,Color.magenta),
			MultipleGradientPaint.CycleMethod.REPEAT))
		g.fill(new Ellipse2D.Double(300,200,100,200))
		g.setStroke(new BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND,5,Array(10f,5f,5f,5f),0f))
		g.draw(new Rectangle2D.Double(50,250,150,100))
		g.setFont(new Font(Font.MONOSPACED,Font.BOLD,20))
		g.setTransform(AffineTransform.getRotateInstance(math.Pi/6,20,20))
		g.translate(100,0)
		g.setPaint(Color.black)
		g.drawString("Painting with Scala And Java Graphics",0,20)
	}
	preferredSize = new Dimension(500,500)
}

val frame = new MainFrame {
	title = "Graphics in Scala"
	contents = new BorderPanel {
		layout += Button("Click to close") {sys.exit(0)} -> South
		layout += Button("Click to draw color") {
			currentColor = (currentColor+1) % rectangleColors.length
			drawPanel.repaint					
		} -> North		
		layout += drawPanel -> Center
		/*layout += new GridPanel(1,4) {
			contents += Button("Up") {clipY -= 10; drawPanel.repaint}
			contents += Button("Down") {clipY += 10; drawPanel.repaint}
			contents += Button("Left") {clipX -= 10; drawPanel.repaint}
			contents += Button("Right") {clipY += 10; drawPanel.repaint}
		} -> South*/
	}
	centerOnScreen
}

frame.open