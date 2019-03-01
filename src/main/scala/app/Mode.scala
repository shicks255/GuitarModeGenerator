package app

import scala.collection.SortedMap

case class Mode(name: String, t: String)

object Mode {

  val modes: SortedMap[Int,Mode] = SortedMap(1 -> Mode("Lydian", "Major"),
    2 -> Mode("Ionian", "Major"),
    3 -> Mode("Mixolydian", "Major"),
    4 -> Mode("Dorian", "Minor"),
    5 -> Mode("Aeolian", "Minor"),
    6 -> Mode("Phrygian", "Minor"),
    7 -> Mode("Locrian", "Other"))

}
