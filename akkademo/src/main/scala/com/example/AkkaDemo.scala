package com.example;
import akka.actor.{Actor,ActorSystem,Props}

class HelloActor extends Actor {
  def receive = {
    case "how are you" => println("fine thank you")
    case _       => println("huh?")
  }
}

object AkkaDemo extends App {
  val system = ActorSystem("HelloSystem")
  // default Actor constructor
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  helloActor ! "how are you"
  helloActor ! "Bonjour"
}