import scala.util.control.Breaks;
object BreakDemo {
   def main(args: Array[String]) {
      var i = 0;
      val numList = List(1,2,3,4);

      val loop = new Breaks;
      loop.breakable {
         for( i <- numList){
            println( "第" + i + "次" );
            if( i == 3 ){
               loop.break;
            }
         }
      }
      println( "事不过三" );
   }
}