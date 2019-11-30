import swing._
import event._
import java.awt.Color
import java.awt.geom._
import java.awt.image.BufferedImage
import actors._

val numValues = if(args.length < 1) 300 else args(0).toInt
val nums = Array.fill(numValues)(math.random)
val values = Array.fill(3)(nums.map(x=> x))

val images = for( i <- 1 to 3) yield {
	new BufferedImage(numValues,200,BufferedImage.TYPE_INT_ARGB)
}

val panel = new Panel {
	override def paint(g: Graphics2D) {
		for(i <- images.indices) g.drawImage(images(i),0,i*200, null)
	}
	preferredSize = new Dimension(numValues,600)
}

def renderValues(img:BufferedImage, arr:Array[Double], j:Int, min:Int = -1) {
	val g = img.createGraphics
	g.setPaint(Color.black)
	g.fill(new Rectangle2D.Double(0,0,img.getWidth,img.getHeight))
	g.setPaint(Color.white)
	for( i <- arr.indices) {
		g.draw(new Line2D.Double(i,200,i,200-190*arr(i)))
	}
	g.setPaint(Color.red) // red is keeping track of j
	g.draw(new Line2D.Double(j,0,j,10))
	g.setPaint(Color.blue) // blue is traking the min
	g.draw(new Line2D.Double(min,0,min,10))
	panel.repaint
	Thread.sleep(30)
}	

def bubble_Sort(arr: Array[Double]) {
	for(i <- 0 until arr.length-1) { // n-1 times
		for(j <- 0 until arr.length-1 -i) { // n-1, n-2, n-3....
			if(arr(j) > arr(j+1)) {
				val temp = arr(j)
				arr(j) = arr(j+1)
				arr(j+1) = temp
			}
			renderValues(images(0),arr,j)
		}
	}
}

def selection_Sort(arr: Array[Double]) {
	for( i <- 0 until arr.length-1) {
		var min = i
		for( j <- i+1 until arr.length) {
			if(arr(j) < arr(min))			
				min = j
			renderValues(images(1),arr,j,min)
		}
		if(min!=i) { // n or n-1 times-> in worst case 
			val temp = arr(i)
			arr(i) = arr(min)
			arr(min) = temp
		}
	}
}

def insertion_Sort(arr: Array[Double]) {
	for( i <- 1 until arr.length) {
		val temp = arr(i)
		var j = i-1
		while(j> -1 && arr(j) > temp) {
			arr(j+1) = arr(j)
			j -= 1
		}
		renderValues(images(2),arr,j)
		arr(j+1) = temp
	}
}

val frame = new MainFrame {
	title = "Visualization of Sorting"
	import BorderPanel.Position._
	contents = new BorderPanel {
		layout += panel -> Center 
		layout += Button("Close") {
			sys.exit(0)
		} -> South 
	}
	centerOnScreen
}
Actor.actor(bubble_Sort(values(0)))
Actor.actor(selection_Sort(values(1)))
Actor.actor(insertion_Sort(values(2)))
frame.open