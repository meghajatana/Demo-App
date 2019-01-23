import Dependencies._
import sbt.Keys._
import sbt._

name := "Trial App"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq("com.github.firebase4s" %% "firebase4s" % "0.0.4",
  "com.typesafe" % "config" % "1.3.3",
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test")

