package adt

trait Stack[A] {
	def push(obj: A) 
	def pop(): A
	def peek: A
	def isEmplty:Boolean
}