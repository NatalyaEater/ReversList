package org.example;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.addFirst(1);
        list.addLast(10);
        list.addFirst(5);
        list.addLast(2);

        System.out.println("Создали список");
        list.print();

        System.out.println("Реверс списка");

        list.revert();
        list.print();
    }
}