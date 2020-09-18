name := "sbt-dsl-plugin"
organization := "com.github.aaabramov"
version := "0.1-SNAPSHOT"

sbtPlugin := true

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test

bintrayPackageLabels := Seq("sbt", "plugin")
bintrayVcsUrl := Some("""git@github.com:com.github.aaabramov/sbt-dsl-plugin.git""")

initialCommands in console := """import aaabramov.sbt.dsl._"""

enablePlugins(SbtPlugin)
enablePlugins(ScriptedPlugin)
// set up 'scripted; sbt plugin for testing sbt plugins
scriptedLaunchOpts ++=
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)

scriptedBufferLog := false

