package com.example.app;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) { // Конструктор точки с координатами
        this.x = x;
        this.y = y;
    }

    public double getX() { // Геттеры и сеттеры
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() { // Возвращает строковое представление точки
        return "{" + x + ";" + y + "}";
    }
}