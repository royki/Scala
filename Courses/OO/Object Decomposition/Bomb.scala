import java.awt.{Graphics2D,Color}
import java.awt.geom.Ellipse2D

class Bomb(private var x: Double, private var y: Double, size: Double) {
	
	private var delay = 20
	//private var detonated = false

	def draw(g: Graphics2D) {
		g.setPaint(Color.red)
		delay -= 1
		//if(delay < 0 ) detonated = true
		if(delay < 1) {
			g.fill(new Ellipse2D.Double(x-size, y-size, 2*size, 2*size))
		} else {
			g.fill(new Ellipse2D.Double(x-1, y-1, 2, 2))
		}	
	}

	def spent: Boolean = {
		delay < -5
	}

	def hits(px: Double, py: Double): Boolean = {
		delay < 1 && {
			val dx = x-px
			val dy = y-py
			val dist = math.sqrt(dx*dx+dy*dy)
			dist <= size
		}
	}
}