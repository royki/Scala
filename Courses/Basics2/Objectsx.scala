

object Objectsx extends App{

case class Movie(val name: String, val year: Short)

	def academyAwardBestMoviesForYear(x: Short) = {
		x  match {
			case 1930 => Some(new Movie("All Quiet", 1930))
			case 1931 => Some(new Movie("Camarron", 1931))
			case 1932 => Some(new Movie("Grande", 1932))
			case _ => None
		}		
	}

	val a = academyAwardBestMoviesForYear(1932).get.name
	println(a)

	/*(a, b) match {
		case (0,0) => 
		case (0,1) => 
		case (1,0) => 
		case (1,1) => 
		case (1,n) if n%2 == 0 =>
		case (1,n) if n%2 == 1 =>
		case _ => 
	}*/
	readInt match {
		case 1 => println(1)
		case 2 => println(2)
		case _ => println(n)
	}
}
