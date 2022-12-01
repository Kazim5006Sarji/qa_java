package com.example;

public class Example {
    public static void main(String[] args) {
        Predator feline = new Feline();
        Lion lion = new Lion(feline);
        try {
            System.out.println(lion.getFood());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
