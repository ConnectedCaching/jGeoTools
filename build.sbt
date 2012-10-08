name := "jGeoTools"

organization := "net.connectedcaching"

version := "0.1-SNAPSHOT"

scalaVersion := "2.9.2"

javacOptions ++= Seq("-encoding", "UTF-8")

libraryDependencies ++= Seq(
	"org.specs2" %% "specs2" % "1.12.1" % "test"
)

crossPaths := false

unmanagedSourceDirectories in Compile <<= Seq(javaSource in Compile).join