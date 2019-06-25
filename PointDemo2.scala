import java.io._

class Point(val xc: Int, val yc: Int) {
   var x: Int = xc
   var y: Int = yc
//    demo for same main and auxiliary constructors  
   // def this(xc: Int, yc: Int){
   //     this(xc,yc)
   //     println("Auxiliary constructor")
   // }
 
   def this(){//if no params,set (0,0)
       this(0,0)
       println("Auxiliary constructor")
   }

   def this(xc: Int){//if no params,set (0,0)
       this(xc,0)
       println("Auxiliary constructor")
   }


   def move(dx: Int, dy: Int) {
      x = x + dx
      y = y + dy
      println ("Point x location : " + x);
      println ("Point y location : " + y);
   }
   println("Main Constructor");//this is main constructor too
}

object PointDemo2 {
   def main(args: Array[String]) {
      val pt1 = new Point(10, 20);
      // Move to a new location
      pt1.move(10, 10);

      val pt2 = new Point();
      // Move to a new location
      pt2.move(10, 10);
   }
}