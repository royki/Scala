version := "0.0.1"
organization := "com"
scalaVersion := "2.13.1"
watchTriggeredMessage := Watch.clearScreenOnTrigger

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.8",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "org.pegdown" % "pegdown" % "1.6.0" % "test"
)

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-oSD"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)

addCommandAlias("testc", ";clean;coverage;test;coverageReport")

coverageExcludedPackages := "Main"
