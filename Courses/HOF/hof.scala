def halfMaker(value: Int): Double = value.toDouble/2
def addFive(value: Int): Int = value + 5

def processRange(s: Int, e: Int, processor: Int => AnyVal): Unit = {
	for(i <- s to e) {
		println(processor(i))
	}
}

def moneyTras(money: Double, providerFee: Double => Double): Double = {
	money + 10 + providerFee(money)
}

println(moneyTras(100, (m: Double) => m/10))

def doubleValue1 = (x: Int) => x * x
def doubleValue2(x: Int):Int = x * x

def doubleListValue1 = List(2,12,4,1).map(x => doubleValue1(x))
def doubleListValue2 = List(2,12,4,1).map(x => doubleValue2(x))

def doubleListValue = List(2,12,4,1).map(x => x * x)
