# Проект java/ Лабораторная работа №2. Выполнил Денисов Алексей ИТ-13

# Описание проекта
Проект представляет собой реализацию 6 задач по объектно-ориентированному программированию на Java. Каждая задача реализована в виде отдельного класса с использованием принципов ООП: инкапсуляция, композиция, агрегация. В проекте используются 6 классов (Point, Name, Line, City, Fraction, Main), каждый из которых содержит свойства, конструкторы, методы и переопределенный метод toString().

## Структура проекта
### Задание 1: Точка координат
```java
public class Point {
    private double x;
    private double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
```
**Описание:** Класс Point представляет точку на двумерной плоскости с координатами x и y. Конструктор принимает координаты, метод toString() возвращает строковое представление в формате "{X;Y}".

**Вход:** Создание точек (1,2), (3,4), (-5,8)
**Вывод:** 
{1.0;2.0}
{3.0;4.0}
{-5.0;8.0}

### Задание 2: Имена
```java
public class Name {
    private String lastName;
    private String firstName;
    private String middleName;
    
    public Name(String firstName) {
        this.firstName = firstName;
    }
    
    public Name(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (lastName != null) sb.append(lastName).append(" ");
        if (firstName != null) sb.append(firstName).append(" ");
        if (middleName != null) sb.append(middleName);
        return sb.toString().trim();
    }
}
```
**Описание:** Класс Name представляет ФИО человека с поддержкой необязательных параметров. Имеет три конструктора для разного количества параметров. Метод toString() формирует строку только из заданных параметров.

**Вход:** "Клеопатра", "Пушкин Александр Сергеевич", "Маяковский Владимир"
**Вывод:** 
Клеопатра
Пушкин Александр Сергеевич
Маяковский Владимир

### Задание 3: Прямая
```java
public class Line {
    private Point start;
    private Point end;
    
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
```
**Описание:** Класс Line представляет линию на плоскости, состоящую из начальной и конечной точек (объектов Point). Метод toString() возвращает описание линии с координатами точек.

**Вход:** Точки (1,3)-(23,8), (5,10)-(25,10)
**Вывод:** 
Линия от {1.0;3.0} до {23.0;8.0}
Линия от {5.0;10.0} до {25.0;10.0}

### Задания 4-5: Города
```java
public class City {
    private String name;
    private Map<City, Integer> connections;
    
    public City(String name) {
        this.name = name;
        this.connections = new HashMap<>();
    }
    
    public City(String name, Map<City, Integer> connections) {
        this.name = name;
        this.connections = new HashMap<>(connections);
    }
    
    public void addConnection(City city, int cost) {
        connections.put(city, cost);
    }
    
    @Override
    public String toString() {
        if (connections.isEmpty()) {
            return name + " (нет путей)";
        }
        StringBuilder sb = new StringBuilder(name + " → ");
        connections.forEach((city, cost) ->
            sb.append(city.name)
              .append("(")
              .append(cost)
              .append(") ")
        );
        return sb.toString().trim();
    }
}
```
**Описание:** Класс City представляет город с маршрутами к другим городам. Имеет два конструктора - с названием и с названием + связями. Метод addConnection() добавляет путь к другому городу с указанием стоимости. Метод toString() показывает все маршруты из города.

**Вход:** Создание городов A-F с маршрутами
**Вывод:** 
A → B(5) D(6) F(1)
B → C(3) A(5)
C → D(4) B(3)
D → A(6) C(4) E(2)
E → F(2)
F → B(1) E(2)

### Задание 6: Дроби
```java
public class Fraction {
    private int numerator;
    private int denominator;
    
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }
    
    public Fraction add(Fraction other) {
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
    
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```
**Описание:** Класс Fraction представляет математическую дробь с операциями сложения, вычитания, умножения и деления. Автоматически сокращает дроби после операций. Метод simplify() сокращает дробь, gcd() вычисляет наибольший общий делитель.

**Вход:** Дроби 1/3, 2/3, 3/4
**Вывод:** 
1/3 + 2/3 = 1/1
2/3 - 1/3 = 1/3
1/3 * 2/3 = 2/9
1/3 / 2/3 = 1/2
f1.add(f2).divide(f3).subtract(5) = -13/3

## Заключение
Проект демонстрирует практическое применение принципов объектно-ориентированного программирования в Java. Реализованы различные сущности с инкапсуляцией данных, конструкторами для разных сценариев использования и переопределенным методом toString() для удобного вывода информации. Главный класс Main обеспечивает дружественный интерфейс для демонстрации работы всех классов с проверкой ввода данных.
