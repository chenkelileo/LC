package com.leo.jakeclass;

import java.util.ArrayList;
import java.util.List;

class Animal {
    String name;

    public Animal() {
        this.name = "Default Name";
    }

    // This is called a one argument constructor.
    public Animal(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal.name);

        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(name -> System.out.print(name + " "));
        int value = 22;
        assert value >= 20 : " Underweight";
        System.out.println("value is "+value);
    }
}