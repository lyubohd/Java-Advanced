package javaOOP.InterfacesAndAbstractionLab.p03_SayHello;

public interface Person {
    String getName();

    default String sayHello() {
       return "Hello";
    }
}
