import mill._
import scalalib._

object hello extends ScalaModule {
  def scalaVersion = "2.12.2"

  def ivyDeps = Agg(
    ivy"org.jline:jline:3.14.1",
    ivy"edu.berkeley.cs::chisel3:3.4.2",
    ivy"edu.berkeley.cs::chiseltest:0.3.2",
  )

  def scalacOptions = Seq(
    "-Xsource:2.11",
    "-language:reflectiveCalls",
    "-deprecation",
    "-feature",
    "-Xcheckinit"
  )

  def scalacPluginIvyDeps = Agg(
    ivy"edu.berkeley.cs:::chisel3-plugin:3.4.2",
    ivy"org.scalamacros:::paradise:2.1.1",
  )

  object test extends Tests {
    def testFrameworks = Seq("org.scalatest.tools.Framework")
  }
}
