import java.awt.{Graphics2D,Color}
import java.awt.geom._


class Enemy(private var x: Double, private var y: Double) {
	
	def draw(g: Graphics2D) {
		g.setPaint(Color.blue)
		g.fill(new Ellipse2D.Double(x-2, y-2, 4, 4))
	}

	def move(ex: Double, ey: Double) {
		val dx = ex-x
		val dy = ey-y
		val len = math.sqrt(dx*dx+dy*dy)
		x += dx/len
		y += dy/len
	}

	def killedBy(bombs: List[Bomb]): Boolean = {
		bombs.exists(_.hits(x,y))		
	}
}