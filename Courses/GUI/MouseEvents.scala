import swing._
import event._
import java.awt.{Color}
import java.awt.geom._

var paths = List[GeneralPath]()
var currentPath = new GeneralPath

val panel = new Panel {
	override def paint(g:Graphics2D) {
		g.setPaint(Color.white)
		g.fill(new Rectangle2D.Double(0,0,size.width, size.height))
		g.setPaint(Color.black)
		for(path <- paths) g.draw(path)
		g.draw(currentPath)
	}
	listenTo(mouse.clicks, mouse.moves, mouse.wheel)
	reactions += {
		case e: MousePressed =>
			currentPath.moveTo(e.point.x, e.point.y)
			println("Press" + e.point)
			repaint
		case e: MouseDragged =>
			currentPath.lineTo(e.point.x, e.point.y)			
			repaint
		case e: MouseReleased =>
			currentPath.lineTo(e.point.x, e.point.y)
			paths ::= currentPath
			currentPath = new GeneralPath
			repaint
	}
	preferredSize = new Dimension(600,600)
}

val frame = new MainFrame {
	title = "Mouse event"
	contents = panel
	centerOnScreen
}

frame.open