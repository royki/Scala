import swing._
import java.awt.Color
import java.awt.geom._

/*val maze = Array(Array(0,-1, 0, 0, 0, 0, 0, 0, 0),
				 Array(0,-1, 0,-1, 0,-1, 0,-1, 0),
				 Array(0,-1, 0,-1, 0,-1, 0,-1, 0),
				 Array(0,-1, 0,-1, 0,-1, 0,-1, 0),
				 Array(0, 0, 0, 0, 0,-1,-1,-1, 0),
				 Array(0,-1, 0,-1,-1,-1, 0, 0, 0),
				 Array(0,-1, 0,-1, 0,-1,-1,-1, 0),
				 Array(0,-1, 0, 0, 0,-1, 0, 0, 0),
				 Array(0,-1,-1,-1, 0,-1, 0,-1,-1),
				 Array(0, 0, 0, 0, 0,-1, 0, 0, 0))*/

val maze = Array(Array(0,-1, 0, 0, 0, 0, 0, 0, 0),
				 Array(0,-1, 0, 0, 0, 0, 0,-1, 0),
				 Array(0,-1, 0, 0, 0, 0, 0,-1, 0),
				 Array(0,-1, 0, 0, 0, 0, 0,-1, 0),
				 Array(0, 0, 0, 0, 0,-1,-1,-1, 0),
				 Array(0,-1, 0, 0, 0,-1, 0, 0, 0),
				 Array(0,-1, 0, 0, 0,-1,-1,-1, 0),
				 Array(0,-1, 0, 0, 0,-1, 0, 0, 0),
				 Array(0,-1,-1,-1, 0,-1, 0,-1,-1),
				 Array(0, 0, 0, 0, 0,-1, 0, 0, 0))

val panel = new Panel {
	override def paint(g: Graphics2D) {
		for(i <- maze.indices; j <- maze(i).indices) {
			g.setPaint(if(maze(i)(j) == 0) Color.white else
					   if(maze(i)(j) == -1) Color.black else
					   if(maze(i)(j) > 0) new Color(20+5*maze(i)(j) min 256,0,0) else
					   Color.red)
			g.fill(new Rectangle2D.Double(i*size.width/maze.length, j*size.height/maze.length, size.width/maze.length, size.height/maze(i).length))
		}
	}
	preferredSize = new Dimension(500,500)
} 


def ShortestPath(maze: Array[Array[Int]], x: Int, y: Int, ex: Int, ey: Int): Int = {
	if(x == ex && y == ey) 0
	else if( x < 0 || x >= maze.length || y < 0 || y >= maze(x).length || maze(x)(y) < 0) {
		1000000000 // not -1 or Int.MaxValue
	} else {
		maze(x)(y) = -2
		panel.repaint
		Thread.sleep(20)
	    val ret = (ShortestPath(maze, x+1, y, ex, ey) min 
				ShortestPath(maze, x-1, y, ex, ey) min
				ShortestPath(maze, x, y+1, ex, ey) min 
				ShortestPath(maze, x, y-1, ex, ey)) + 1
 	    	maze(x)(y) = 0
 	    	ret
	}
}

def ShortestPath2(maze: Array[Array[Int]], x: Int, y: Int, ex: Int, ey: Int, steps: Int): Int = {
	if(x == ex && y == ey) 0
	else if( x < 0 || x >= maze.length || y < 0 || y >= maze(x).length || maze(x)(y) < 0) {
		1000000000 // not -1 or Int.MaxValue
	} else if(maze(x)(y) > 0 && maze(x)(y) <= steps) {
		1000000000
	} else {
		maze(x)(y) = steps
		panel.repaint
		Thread.sleep(20)
	    val ret = (ShortestPath2(maze, x+1, y, ex, ey, steps+1) min 
				ShortestPath2(maze, x-1, y, ex, ey, steps+1) min
				ShortestPath2(maze, x, y+1, ex, ey, steps+1) min 
				ShortestPath2(maze, x, y-1, ex, ey, steps+1)) + 1
 	    	maze(x)(y) = 0
 	    	ret
	}
}


val frame = new MainFrame {
	title = "Visualisation of Maze"
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

//println(ShortestPath(maze,0,0,9,9))
println(ShortestPath2(maze,0,0,9,9,1))

// 100 Squares = numberOfSteps
// 2^numberOfSteps = 2^100 ~ 2^10 ~ 10^30
// 10^21 seconds
// 1 year ~ 3*10^7 seconds
// 3*10^13 years