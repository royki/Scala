import swing._
import event._
import java.awt.{Color} 
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File
import java.awt.geom._
import BorderPanel.Position._

val img =  { 
	val i = new BufferedImage(200,200,BufferedImage.TYPE_INT_ARGB)
	val g = i.createGraphics
	g.setPaint(Color.blue)
	g.fillRect(0,0,300,400)
	i
}

for(x <- 1 to 20; y <- 1 to 20) img.setRGB(x,y,0xffff0000)
for(x <- 1 to 20; y <- 1 to 20) img.setRGB(x,y+20,0xff000000 | ((x*10) << 16) | ((y*10) << 8)) 

// val ScalaPic1 = ImageIO.read(new File("Scala1.jgp"))
// val ScalaPic2 = ImageIO.read(new File("Scala2.jgp"))

val pnts = Array.fill(10000)((math.random*500,math.random*500))
var bImg = new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB)

val panel = new Panel {
	override def paint(g:Graphics2D) {
		if(size.width > bImg.getWidth || size.height > bImg.getHeight) {
			bImg = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB)
		}
		val gr = bImg.createGraphics
		g.setPaint(Color.white)
		g.fill(new Rectangle2D.Double(0,0,size.width, size.height))
		g.drawImage(img,150,150,null)
		// g.drawImage(ScalaPic1,0,0,null)
		// g.drawImage(ScalaPic2,300,300,null)		
		g.setPaint(Color.black)
		for((x,y) <- pnts) g.fill(new Ellipse2D.Double(x,y,1,1))
		gr.fill(new Rectangle2D.Double(100,400,300,100))
		g.drawImage(bImg,0,0,null)
	}
	preferredSize = new Dimension(500,500)
}

val frame = new MainFrame {
	title = "Images"
	contents = new BorderPanel {
		layout += panel -> BorderPanel.Position.Center
		layout += Button("Repaint")(panel.repaint) -> BorderPanel.Position.North
	}
	centerOnScreen
}

frame.open