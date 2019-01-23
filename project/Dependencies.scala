import sbt._

object Dependencies {

  val scalaTestVersion = "3.0.5"
  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % "test"

  

  val typesafeConfig = "com.typesafe" % "config" % "1.3.3"

 

  val firebaseAdmin = "com.google.firebase" % "firebase-admin" % "6.6.0"
  val json4s = "org.json4s" %% "json4s-native" % "3.6.3"
 

  val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.2.3"
}
