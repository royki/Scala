package adt 

trait Queue[A] {
	def enqueue(obj: A)
	def dequeue(): A
	def peek: A
	def isEmpty: Boolean
}