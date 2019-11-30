import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

object SimpleActorExample extends App {
	
	class SimpleActor extends Actor {
		def receive = {
			case s:String => println("String ", +s) 
			case i:Int => println("Number ", +i)
			case _ => println("No match")  
		}

		def foo = println("Normal method ")
	}

	val system = ActorSystem("SimpleActorSystem")
	val actor = system.actorOf(Props[SimpleActor],"SimpleActor")
	// waiting to receive a msg
	actor ! "Hi there"	
	actor ! 69
	// actor ! #@#
	system.terminate()
}