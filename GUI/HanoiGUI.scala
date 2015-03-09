import swing._
import java.awt.Color
import java.awt.geom._

val pegs = Array((1 to 5).toList,List[Int](),List[Int]())

var highLightPeg = 0
var highLightCount = 0


val panel = new Panel {
	override def paint(g: Graphics2D) {
		g.setPaint(Color.black)
		g.fill(new Rectangle2D.Double(0,0,size.width,size.height))
		g.setPaint(Color.red)
		for(p <- pegs.indices) {
			val len = pegs(p).length
			for(d <- pegs(p).indices) {
				val diskWidth = pegs(p)(d)*20+20
				if(p==highLightPeg && d < highLightCount) {
					g.setPaint(Color.blue)
				} else {
					g.setPaint(Color.red)
				}
				g.fill(new Rectangle2D.Double(100+p*200-diskWidth/2, 300-20*(len-d),diskWidth,19))
			}
		}
	}
	preferredSize = new Dimension(600,300)
} 

def MoveOneDisk(from: Int, to: Int) {
	require(pegs(to).isEmpty || pegs(from).head < pegs(to).head)
	pegs(to) ::= pegs(from).head
	pegs(from) = pegs(from).tail
	panel.repaint
	// Thread.sleep(500)
}

def MoveStack(n: Int, from: Int, to: Int) {
	highLightPeg = from
	highLightCount = n
	panel.repaint
	Thread.sleep(500)
	if(n==1) MoveOneDisk(from,to)
	else {
		val other = 3-from-to
		MoveStack(n-1,from,other) 
		MoveOneDisk(from,to)
		MoveStack(n-1,other,to)
	}
}

val frame = new MainFrame {
	title = "Tower of Hanoi"
	import BorderPanel.Position._
	contents = new BorderPanel {
		layout += panel -> Center 
		layout += Button("Close") {
			sys.exit(0)
		} -> South 
	}
	centerOnScreen
}

frame.open

println(pegs.mkString(","))
MoveStack(pegs(0).length,0,2)
//MoveOneDisk(0,2)
println(pegs.mkString(","))
