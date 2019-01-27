ThisBuild / organization := "io.github.patrykrudnicki"

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/PatrykRudnicki/ValidationHelper"),
    "scm:git@github.com:PatrykRudnicki/ValidationHelper.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "1",
    name  = "Patryk Rudnicki",
    email = "patrudnicki@gmail.com",
    url   = url("https://github.com/PatrykRudnicki/ValidationHelper")
  )
)

ThisBuild / description := "Validation helper"
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/PatrykRudnicki/ValidationHelper"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true