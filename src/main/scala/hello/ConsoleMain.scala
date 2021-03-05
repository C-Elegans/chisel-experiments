package hello

import org.jline.terminal._

object ConsoleMain {
  def main(args: Array[String]) {
    val term = TerminalBuilder.terminal()
    term.echo(false) // Disable echo (I hope)
    term.enterRawMode()
    val reader = term.reader()
    while (true){
      val c = reader.read()
      println(c)
    }
    println("Hello World")
  }
}
