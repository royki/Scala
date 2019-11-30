import scala.collection.JavaConversions._
import java.io._

object SystemApp extends App {
	
	// val environmentVars = System.getenv()
	// for((k,v) <- environmentVars) println(s"key: $k, value: $v")

	// val properties = System.getProperties()
	// for((k,v) <- properties) println(s"key: $k, value: $v")
	def SystemInfo() {
		def userDomain = System.getenv("USERDOMAIN")
		val userName = System.getenv("USERNAME")
		val serverName = System.getenv("LOGONSERVER")
		val osName = System.getenv("OS")

		println(userDomain, userName, serverName, osName)
	}
	
	SystemInfo()

	def runCommand(cmd: Seq[String]): (Int, String, String) = {
		import sys.process._
		val stdoutStream = new ByteArrayOutputStream
		val stderrStream = new ByteArrayOutputStream
		val stdoutWriter = new PrintWriter(stdoutStream)
		val stderrWriter = new PrintWriter(stderrStream)
		val exitValue = cmd.!(ProcessLogger(stdoutWriter.println, stderrWriter.println))
		stdoutWriter.close()		
		stderrWriter.close()
		(exitValue, stdoutStream.toString, stderrStream.toString)
	}
	runCommand(Seq("tasklist"))
}