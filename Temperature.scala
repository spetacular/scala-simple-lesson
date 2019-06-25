object Temperature {
   def main(args: Array[String]) {
        println(display(37))
        println(display(100))
        println(display(50))
   }
   def display(x: Int): String = x match {
      case 0 => "freezing point" 
      case 100 => "boiling point" 
      case x if(x >= 36.5 && x <= 37.5) => "body point"
      case _ => "other point"
   }
}