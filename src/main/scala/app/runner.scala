package app

import app.Mode.modes
import app.GuitarString._

import scala.io.StdIn.readLine

object runner {

  def main(args: Array[String]): Unit = {

    val x = guitarNeck
    val t = tones
    val estr = eString

//    val selection = promptUser1()

  }

  def promptUser1(): Int = {
    println("Which mode would you like to see")

    val majors = modes.filter(x => x._2.t == "Major")
    val minors = modes.filter(x => x._2.t == "Minor")

    println("Major Modes")
    majors.foreach(x => println("\t" + x._1 + " " + x._2.name))

    println("Minor Modes")
    minors.foreach(x => println("\t" + x._1 + " " + x._2.name))

    println("Other")
    println("\t" + 7 + " " + modes(6).name)

    println("Press q to quit");

    val input = readLine()

    if (input.toLowerCase == "q")
      {
        System.exit(0)
        1 //:todo make monad
      }
    else {
      try {
        val selection = input.toInt
        if (selection < 0 || selection > 7)
          promptUser1()
        else
          input.toInt
      }
      catch {
        case e: Exception => promptUser1()
      }
    }
  }

}
