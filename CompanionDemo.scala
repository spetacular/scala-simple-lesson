// Companion class 
class CompanionDemo 
{ 
      
    // Variables of Companion class 
    var str1 = "MIS"; 
    var str2 = "Tutorial of Companion object"; 
    private var str3 = "Hello MIS"
      
    // Method of Companion class 
    def show() 
    { 
        println(str1); 
        println(str2); 
    } 

    private def mis()
    {
        println("In mis method")
        println(str3)
    }
} 
  
// Companion object 
object CompanionDemo
{ 
    def main(args: Array[String])  
    { 
        var obj = new CompanionDemo(); 
        obj.show(); 
        println(obj.str3);
        obj.mis();
    } 
} 