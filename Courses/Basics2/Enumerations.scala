object EnumerationsInScala extends Enumeration {
	// val red = 0
	// val green = 1
	// val yellow = 2

	val red, green, yellow = Value
}

class StreetLight(private var _color: EnumerationsInScala.Value) {
	def color = _color

	import EnumerationsInScala._

	def cycle: Unit = _color = color match {
		case red => green
		case green => yellow
		case yellow => red
	}
}

