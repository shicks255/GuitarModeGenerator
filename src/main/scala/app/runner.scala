package app

import scala.io.StdIn.readLine
import Mode.modes

object runner {

  def main(args: Array[String]) = {

    println("Which mode would you like to see")

    val majors = modes.filter(x => x._2.t == "Major")
    val minors = modes.filter(x => x._2.t == "Minor")

    println("Major Modes")
    majors.foreach(x => println("\t" + x._1 + " " + x._2.name))

    println("Minor Modes")
    minors.foreach(x => println("\t" + x._1 + " " + x._2.name))

    println("Other")
    println("\t" + 7 + " " + modes(6).name)
  }

}
