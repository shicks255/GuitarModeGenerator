package app

import app.GuitarString.makeStringNotes

class GuitarNeck {

  val guitarNeck: List[GuitarString] = List(
    makeStringNotes("e", "d#"),
    makeStringNotes("b", "a#"),
    makeStringNotes("g", "f#"),
    makeStringNotes("d", "c#"),
    makeStringNotes("a", "g#"),
    makeStringNotes("E", "d#"))

}
