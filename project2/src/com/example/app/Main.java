package com.example.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1 - Точки\n");

        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(-5, 8);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("\nЗадание 2 - Имена\n");

        Name n1 = new Name("Клеопатра");
        Name n2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name n3 = new Name("Маяковский", "Владимир");

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        System.out.println("\nЗадание 3 - Линии\n");

        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
        System.out.println("Линия 1 - " + line1);

        Point l2Start = new Point(5, 10);
        Point l2End = new Point(25, 10);
        Line line2 = new Line(l2Start, l2End);
        System.out.println("Линия 2 - " + line2);

        Line line3 = new Line(line1.getStart(), line2.getEnd());
        System.out.println("Линия 3 - " + line3);

        System.out.println("\nМеняем координаты точек");
        line1.getStart().setX(10);
        line1.getStart().setY(20);
        line2.getEnd().setX(100);
        line2.getEnd().setY(200);
        System.out.println("Линия 1 - " + line1);
        System.out.println("Линия 2 - " + line2);
        System.out.println("Линия 3 - " + line3);

        System.out.println("\nМеняем линию 1 чтобы линия 3 не изменилась");
        line1.setStart(new Point(-7, -7));
        System.out.println("Линия 1 - " + line1);
        System.out.println("Линия 3 - " + line3);

        System.out.println("\nЗадания 4 и 5 - Города\n");

        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        A.addConnection(B, 5);
        A.addConnection(D, 6);
        A.addConnection(F, 1);
        F.addConnection(B, 1);
        F.addConnection(E, 2);
        B.addConnection(C, 3);
        B.addConnection(A, 5);
        C.addConnection(D, 4);
        C.addConnection(B, 3);
        E.addConnection(F, 2);
        D.addConnection(A, 6);
        D.addConnection(C, 4);
        D.addConnection(E, 2);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите название города (A–F) - ");
        String input = scanner.nextLine().trim().toUpperCase();
        City selected = switch (input) {
            case "A" -> A;
            case "B" -> B;
            case "C" -> C;
            case "D" -> D;
            case "E" -> E;
            case "F" -> F;
            default -> null;
        };
        if (selected != null) {
            System.out.println("Маршруты из города " + selected.getName() + ":");
            System.out.println(selected);
        } else {
            System.out.println("Такого города нет");
        }

        System.out.println("\nЗадания 6 - Дроби\n");

        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(3, 4);

        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f2 + " - " + f1 + " = " + f2.subtract(f1));
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));

        Fraction result = f1.add(f2).divide(f3).subtract(5);
        System.out.println("\nf1.add(f2).divide(f3).subtract(5) = " + result);

        scanner.close();
    }
}