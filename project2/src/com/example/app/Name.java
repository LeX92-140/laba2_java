package com.example.app;

public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name(String firstName) { // Конструктор с одним параметром (например, Клеопатра)
        this.firstName = firstName;
    }

    public Name(String lastName, String firstName) { // Конструктор с двумя параметрами (Фамилия, Имя)
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Name(String lastName, String firstName, String middleName) { // Конструктор с тремя параметрами (Фамилия, Имя, Отчество)
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    @Override
    public String toString() { // Строковое представление в зависимости от заданных параметров
        StringBuilder sb = new StringBuilder();
        if (lastName != null) sb.append(lastName).append(" ");
        if (firstName != null) sb.append(firstName).append(" ");
        if (middleName != null) sb.append(middleName);
        return sb.toString().trim();
    }
}