ThisBuild / scalaVersion := "2.12.8"

ThisBuild / triggeredMessage := Watched.clearWhenTriggered

ThisBuild / autoStartServer := false

ThisBuild / scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-language:implicitConversions",
  "-language:higherKinds"
)

ThisBuild / shellPrompt := (_ => fancyPrompt(name.value))

def fancyPrompt(projectName: String): String =
  s"""|
      |[info] Welcome to the ${cyan(projectName)} project!
      |sbt> """.stripMargin

def cyan(projectName: String): String =
  scala.Console.CYAN + projectName + scala.Console.RESET

lazy val `fp-library` =
  project
    .in(file("./1-fp-library"))
    .settings(shellPrompt := (_ => fancyPrompt(name.value)))

lazy val `application-library` =
  project
    .in(file("./2-application-library"))
    .settings(shellPrompt := (_ => fancyPrompt(name.value)))
    .dependsOn(`fp-library`)

lazy val `end-of-the-world` =
  project
    .in(file("./3-end-of-the-world"))
    .settings(shellPrompt := (_ => fancyPrompt(name.value)))
    .dependsOn(`application-library`)

addCommandAlias("ll", "projects")

addCommandAlias("cd", "project")

addCommandAlias("root", "project monads")

addCommandAlias("lib", "project fp-library")

addCommandAlias("app", "project application-library")

addCommandAlias("main", "project end-of-the-world")
