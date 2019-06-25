object Exampleofsingleton 
{ 
      
    // Varaibles of singleton object 
    var str1 = "Welcome ! MIS"; 
    var str2 = "This is Scala language tutorial"; 
      
    // Method of singleton object 
    def display() 
    { 
        println("Called By Display Method")
        println(str1); 
        println(str2); 
    } 
} 
  
// Singleton object with named as Main 
object SingletonDemo  
{ 
    def main(args: Array[String]) 
    { 
          
        // Calling method of singleton object  
        Exampleofsingleton.display(); 

        println("Called By Property")
        println(Exampleofsingleton.str1);
        println(Exampleofsingleton.str2);
    } 
} 