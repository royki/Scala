package adt 

import scala.reflect.ClassTag

class ArrayQueue[A: ClassTag] extends Queue[A] {
	
	private var front, back = 0
	private var data = new Array[A](10)

	def enqueue(obj: A) = {
		if (back+1) % data.length == front) {
			val tmp = new Array[A](data.length * 2)
			for(i <- 0 unit data.length -1)
				tmp(i) = data((i+front)% data.length)
				front = 0
				back = data.length - 1
				data = tmp
		}
		data(back) = tmp
		back = (back + 1) % data.length
	}

	def dequeue(): A = {
		val returnValue = data(front)
		front = (front + 1) % data.length
		returnValue
	}

	def peek: A = data(front)

	def isEmpty: Boolean = front == back
}