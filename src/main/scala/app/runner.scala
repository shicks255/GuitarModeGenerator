package app

import app.Mode.modes
import app.GuitarString._

import scala.io.StdIn.readLine

object runner {

  def main(args: Array[String]): Unit = {
    runProgram()
  }

  def runProgram(): Unit = {
    val selection = promptUser1()
    val key = promptUser2()

    val neck = new GuitarNeck

    val modeSelected = Mode.modes(selection)
    val tab = Mode.getNotes(modeSelected, key, neck)
    printTab(tab)

    runProgram()
  }

  def printTab(tab: Array[Array[String]]) = {

    println(List("","00","01","02","03","04","05","06","07","08","09","10","11","12").mkString(" ", " |", " | "))
//    (0 to 41).foreach(_ => print("_"))
//    println("")
    for (x <- tab) {
      val t = x.mkString("|", "|", "|")
      println(t)
    }

  }

  def promptUser2(): String = {
    println("Select a key")

    val key = readLine()

    key.toLowerCase
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
