package app

import scala.collection.SortedMap
import Note.tones

case class Mode(name: String, t: String)

object Mode {

  val modes: SortedMap[Int,Mode] = SortedMap(1 -> Mode("Lydian", "Major"),
    2 -> Mode("Ionian", "Major"),
    3 -> Mode("Mixolydian", "Major"),
    4 -> Mode("Dorian", "Minor"),
    5 -> Mode("Aeolian", "Minor"),
    6 -> Mode("Phrygian", "Minor"),
    7 -> Mode("Locrian", "Other"))


  def getNotesFromPatternAndKey(pattern: List[String], key: String) = {
    var starting = tones.indexWhere(_ == key)

    pattern.zipWithIndex.map(s => {
      val x = (tones(starting), (s._2+1).toString)

      if (s._1 == "w") starting += 2 else starting += 1

      if (starting >= tones.length)
        starting -= tones.length
      x
    })
  }

  def getNotes(mode: Mode, key: String, neck: GuitarNeck) = {

    val pattern :List[String] = mode.name match {
      case "Lydian" => lydian
      case "Ionian" => ionian
      case "Mixolydian" => mixolydian
      case "Dorian" => dorian
      case "Aeolian" => aeolian
      case "Phrygian" => phrygian
      case "Locrian" => locrian
      case _ => List("")
    }

    val tab: Array[Array[String]] = Array.ofDim[String](6,14)
    val notesInThisModeKey = getNotesFromPatternAndKey(pattern, key)
    val notesMap = notesInThisModeKey.toMap

    var counter = 0
    for (string <- neck.guitarNeck) {

      tab(counter)(0) = string.name

      string.notes.zipWithIndex.foreach(x => {
        val toPrint: String = notesMap.getOrElse[String](x._1.tone, "-")
        tab(counter)(x._2 + 1) = " " + toPrint + " "
      })
      counter += 1
    }

    tab
  }

  /**
    * Lydian Mode
    * w-w-w-h-w-w-h
    * @param neck
    */
  def lydian() = {
    List("w","w","w","h","w","w","h")
  }

  /**
    * Ionian Mode
    * w-w-h-w-w-w-h
    */
  def ionian = {
    List("w","w","h","w","w","w","h")
  }

  /**
    * Mixolydian Mode
    * w-w-h-w-w-h-w
    */
  def mixolydian = {
    List("w","w","h","w","w","h","w")
  }

  /**
    * Dorian Mode
    * w-h-w-w-w-h-w
    */
  def dorian = {
    List("w","h","w","w","w","h","w")
  }

  /**
    * Aeolian Mode
    * w-h-w-w-h-w-w
    */
  def aeolian = {
    List("w","h","w","w","h","w","w")
  }

  /**
    * Phrygian Mode
    * h-w-w-w-h-w-w
    */
  def phrygian = {
    List("h","w","w","w","h","w","w")
  }

  /**
    * Locarian Mode
    * h-w-w-h-w-w-w
    */
  def locrian = {
    List("h","w","w","h","w","w","w")
  }



}
