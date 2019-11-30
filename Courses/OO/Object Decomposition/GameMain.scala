import swing._
import event._
import java.awt.Color
import java.awt.geom._
import java.awt.Graphics2D

object GameMain {
	
	private var enemies = List[Enemy]()
	private var bombs = List[Bomb]()
	private var time = 0

	private val gamePanel = new Panel {
		override def paint(g: Graphics2D) {
			g.setPaint(Color.white)
			g.fillRect(0, 0, size.width, size.height)
			
			//draw enemies
			g.setPaint(Color.blue)
			enemies.foreach(_.draw(g))
			
			//draw player
			g.setPaint(Color.green)
			g.fill(new Ellipse2D.Double(playerX, playerY, 40, 40))
			
			//draw bombs
			g.setPaint(Color.red)
			bombs.foreach(_.draw(g))
		}

		preferredSize = new Dimension(600,600)

		var pressedX = 0
		var pressedY = 0
		var pressedTime = 0

		//placing bomb
		listenTo(mouse.clicks)
		reactions += {
			case e: MousePressed => 
				pressedX = e.point.x
				pressedY = e.point.y
				pressedTime = time
				println("MousePressed at" +time)
			case e: MouseReleased => 
				bombs ::= new Bomb(pressedX, pressedY, 3+time-pressedTime)
				println("MouseReleased at" +time)
				repaint
		}
	}

	private val frame = new MainFrame {
		title = "Game"
		contents = gamePanel
		centerOnScreen
	}

	def playerX: Double = 0.5*(gamePanel.size.width-20)
	def playerY: Double = 0.5*(gamePanel.size.height-20)
	
	
	val timer = new javax.swing.Timer(100, Swing.ActionListener(e => {
		//Place new enemies
		if(math.random < 0.02) {
			println("Making Enemy")
			enemies ::= new Enemy(0,0)
		}
		//Remove exploded enemies
		enemies = enemies.filterNot(_.killedBy(bombs))

		//Remove spent bombs
		bombs = bombs.filterNot(_.spent)

		//Move enemies
		enemies.foreach(_.move(playerX, playerY))

		time += 1
		gamePanel.repaint
	}))

	def main(args: Array[String]): Unit = {
	 	frame.open 
	 	timer.start
	}	
}