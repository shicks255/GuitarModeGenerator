package app

case class GuitarString(name: String, notes: List[Note])

object GuitarString {
  val tones = Iterator.continually(List("a", "a#", "b", "c", "c#", "d", "d#", "e", "f", "f#", "g", "g#")).flatten

  def makeStringNotes(name: String, startingNode: String): GuitarString = {

    val tone = tones.indexWhere(_ == startingNode)
      val string = (0 to 12).map(Note(_,tones.next()))
      GuitarString(name, string.toList)
  }
}

