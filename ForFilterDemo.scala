import java.util.Random;
object ForFilterDemo {
   def main(args: Array[String]) {
        var r = new Random()
        var rand = r.nextInt(100)
        var i = 0
        for(i <- 0 to 10
            if rand % 2 == 0//只保留所有的偶数
        ){
            println(rand)
            rand = r.nextInt(100)
        }
      
   }
}