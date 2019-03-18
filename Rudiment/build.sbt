version  := "0.0.1"
organization := "com"
scalaVersion := "2.12.8"
triggeredMessage := Watched.clearWhenTriggered

libraryDependencies ++= Seq(
	"org.scalactic" %% "scalactic" % "3.0.5",
	"org.scalatest" %% "scalatest" % "3.0.5" % "test",
	"org.pegdown"  %   "pegdown" % "1.6.0" % "test"
)

testOptions in Test ++=  Seq(
	Tests.Argument(TestFrameworks.ScalaTest, "-oSD"),
	Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)

// addCommandAlias("testc", ";clean;coverage;test;coverageReport")

// coverageExcludedPackages := "Main"