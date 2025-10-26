package com.example.app;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) { // Конструктор с числителем и знаменателем
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private void simplify() { // Сокращение дроби
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) { // переносим знак
            numerator *= -1;
            denominator *= -1;
        }
    }

    private int gcd(int a, int b) { // Наибольший общий делитель
        return b == 0 ? a : gcd(b, a % b);
    }

    public Fraction add(Fraction other) { // Операции с дробями
        int num = numerator * other.denominator + other.numerator * denominator;
        int den = denominator * other.denominator;
        return new Fraction(num, den);
    }

    public Fraction subtract(Fraction other) {
        int num = numerator * other.denominator - other.numerator * denominator;
        int den = denominator * other.denominator;
        return new Fraction(num, den);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(numerator * other.numerator, denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        return new Fraction(numerator * other.denominator, denominator * other.numerator);
    }

    public Fraction subtract(int integer) { // Вычитание целого числа
        return subtract(new Fraction(integer, 1));
    }

    @Override
    public String toString() { // Строковое представление дроби
        return numerator + "/" + denominator;
    }
}