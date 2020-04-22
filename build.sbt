name := "validation-helper"

lazy val scala213 = "2.13.1"
lazy val scala212 = "2.12.8"
lazy val scala211 = "2.11.12"
lazy val supportedScalaVersions = List(scala213, scala212, scala211)

scalaVersion := scala213

useGpg := true

libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"

lazy val root = (project in file(".")).settings(crossScalaVersions := supportedScalaVersions)