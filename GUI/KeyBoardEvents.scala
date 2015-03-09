import swing._
import event._
import java.awt.{Color}
import java.awt.geom._

var paths = List[GeneralPath]()
var currentPath = new GeneralPath

//val artImage = javax.imageio.ImageIO.read(new java.io.File("akka.png"))
var playerX = 0
var playerY = 0
val playerSize = 20
var dots = Array.fill(30)(new java.awt.Point(100+util.Random.nextInt(300),100+util.Random.nextInt(300)))

var leftDown = false
var rightDown = false
var upDown = false
var downDown = false
var drawing = true

val panel = new Panel {
	override def paint(g:Graphics2D) {
		g.setPaint(Color.white)
		g.fill(new Rectangle2D.Double(0,0,size.width, size.height))
		g.setPaint(Color.black)
		for(path <- paths) g.draw(path)
		g.draw(currentPath)
		g.setPaint(Color.blue)
		g.fill(new Rectangle2D.Double(playerX,playerY,playerSize,playerSize))		
		//g.drawImage(artImage,playerX,playerY,null)
		g.setPaint(Color.green)
		for(p <- dots) {
			g.fill(new Ellipse2D.Double(p.x-2, p.y-2,5,5))
		}
	}
	listenTo(mouse.clicks, mouse.moves, mouse.wheel, keys)
	reactions += {
		case e: MousePressed =>
		requestFocus
			if(drawing) {
				currentPath.moveTo(e.point.x, e.point.y)
				//println("Press" + e.point)
				repaint
			}
		case e: MouseDragged =>
			if(drawing) {
				currentPath.lineTo(e.point.x, e.point.y)			
				repaint
			}
		case e: MouseReleased =>
			if(drawing) {
				currentPath.lineTo(e.point.x, e.point.y)
				paths ::= currentPath
				currentPath = new GeneralPath
				repaint
			}
		case e: MouseEntered => 
			requestFocus
		case e: KeyPressed => 
			//println("key pressed")
			e.key match {
				case Key.Up => upDown = true					
					/*if(paths.forall(!_.intersects(playerX,playerY-1,playerSize,playerSize))){
						playerY -= 10
					}					
					repaint*/
				case Key.Down => downDown = true
					/*if(paths.forall(!_.intersects(playerX,playerY+1,playerSize,playerSize))){
						playerY += 10
					}
					repaint*/
				case Key.Left => leftDown =  true
					/*if(paths.forall(!_.intersects(playerX-1,playerY,playerSize,playerSize))){
						playerX -= 10
					}
					repaint*/
				case Key.Right => rightDown = true
					/*if(paths.forall(!_.intersects(playerX+1,playerY,playerSize,playerSize))){
						playerX += 10
					}						
					repaint*/
			}
			case e: KeyReleased => 
			//println("key pressed")
			e.key match {
				case Key.Up => 	upDown = false										
				case Key.Down => downDown = false					
				case Key.Left => leftDown =  false					
				case Key.Right => rightDown = false					
				case _ => 
			}	
	}
	preferredSize = new Dimension(600,600)
}

def allowMove(x: Double, y: Double, width: Double, height: Double): Boolean = {
	paths.forall(!_.intersects(x,y,width,height))
}

val timer = new javax.swing.Timer(50, Swing.ActionListener( e => {
	for(p <- dots) {
		val x = p.x+util.Random.nextInt(3)-1
		val y = p.y+util.Random.nextInt(3)-1
		if(allowMove(x,y,5,5)) {
			p.x = x
			p.y = y
		}
	}

	if(upDown && allowMove(playerX,playerY-1,playerSize,playerSize)){
		playerY -= 10
	}					
	if(downDown && allowMove(playerX,playerY+1,playerSize,playerSize)){
						playerY += 10
	}
	if(leftDown && allowMove(playerX-1,playerY,playerSize,playerSize)){
						playerX -= 10
	}
	if(rightDown && allowMove(playerX+1,playerY,playerSize,playerSize)){
						playerX += 10
	}
	val pBounds = new Rectangle2D.Double(playerX,playerY,playerSize,playerSize)
	dots = dots.filter(p => !pBounds.intersects(p.x,p.y,5,5))
	panel.repaint
}))

val frame = new MainFrame {
	title = "Mouse event"
	import BorderPanel.Position._
	contents = new BorderPanel {
		layout += panel -> Center
		layout += Button("Start") {
			drawing = false
			timer.start	
			panel.requestFocus		
		} -> North
	}
	centerOnScreen
}
frame.open
panel.requestFocus
