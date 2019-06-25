abstract class Animal(iname:String)
{
    val name:String = iname;
    def eat 
    def move(){
        println("All Animals Can Move");
    }
    def display(){
        println("Hello "+name)
    }
}

class Dog(iname:String) extends Animal(iname:String) 
{
    def eat(){
        println("Dog Eats Bones");
    }
    override def move(){
        println("Dog is An Animal, So Dog can move");
    }
    def display(msg:String){
        println("Hello "+name+" "+msg)
    }
}

object InheritDemo
{
    def main(args: Array[String])  
    { 
       val dog = new Dog("Teddy");
       dog.eat();
       dog.move();
       dog.display("Welcome!")
    } 
}