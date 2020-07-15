version  := "0.0.1"
organization := "com"
scalaVersion := "2.13.2"
triggeredMessage := Watched.clearWhenTriggered

libraryDependencies ++= Seq(
	"org.scalactic" %% "scalactic" % "3.1.0",
	"org.scalatest" %% "scalatest" % "3.1.0" % "test",
	"org.pegdown"  %   "pegdown" % "1.6.0" % "test"
)

testOptions in Test ++=  Seq(
	Tests.Argument(TestFrameworks.ScalaTest, "-oSD"),
	Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)

scalacOptions ++= Seq ("-deprecation" /*, "-Xprint:typer", "-Xlint"*/) // build flag `-Xlint`

// reColors := Resolver.noColors

// addCommandAlias("testc", ";clean;coverage;test;coverageReport")

// coverageExcludedPackages := "Main"