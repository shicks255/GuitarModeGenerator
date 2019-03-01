package app

import scala.collection.immutable.ListMap

case class GuitarString(name: String, notes: List[Note])

object GuitarString {
//  val tones = scala.collection.mutable.LinkedList("a", "a#", "b", "c", "c#", "d", "d#", "e", "f", "f#", "g", "g#")
  val tones = Iterator.continually(List("a", "a#", "b", "c", "c#", "d", "d#", "e", "f", "f#", "g", "g#")).flatten

  val eString = makeStringNotes("e", "d#")
  val bString = makeStringNotes("b", "a#")
  val gString = makeStringNotes("g", "f#")
  val dString = makeStringNotes("d", "c#")
  val aString = makeStringNotes("a", "g#")
  val eStringBig = makeStringNotes("E", "d#")

  val guitarNeck: ListMap[String, GuitarString] = ListMap("e" -> eString,
    "b" -> bString,
    "g" -> gString,
    "d" -> dString,
    "a" -> aString,
    "E" -> eStringBig)

  def makeStringNotes(name: String, startingNode: String): GuitarString = {

    val tone = tones.indexWhere(_ == startingNode)
      val string = (0 to 12).map(Note(_,tones.next()))
      GuitarString("", string.toList)
  }
}

