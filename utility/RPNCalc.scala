package utility

import adt._

object RPNCalc extends App {
	// 2+3*5 => 2 3 + 5 *

	def apply(args: Seq[String]): Double = {
		val stack = new ArrayStack[Double]()
		for(arg <- args; if arg.nonEmpty) arg match {
			case "+" => stack.push(stack.pop() + stack.pop))
			case "*" => stack.push(stack.pop() * stack.pop))
			case "-" =>
				val tmp = stack.pop() 
				stack.push(stack.pop() - tmp)
			case "/" =>
				val tmp = stack.pop() 
				stack.push(stack.pop() * tmp)
			case x => stack.push(x.toDouble)
		}
		stack.pop()
	}
}

object RPNCalc extends App {
	
	def apply(args:Seq[String]): Double = {
		val stack = new ArrayStack[Double]()
		for(arg <- args; if arg.nonEmpty) arg match {
			case "+" => stack.push(stack.pop() + stack.pop())
			case x => stack.push(x.toDouble)
		}
		stack.pop()
	}
}