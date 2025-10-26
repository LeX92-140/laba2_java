package com.example.app;

import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> connections;

    public City(String name) { // Конструктор с одним параметром (название города)
        this.name = name;
        this.connections = new HashMap<>();
    }

    public City(String name, Map<City, Integer> connections) { // Конструктор с указанием сразу всех связей
        this.name = name;
        this.connections = new HashMap<>(connections);
    }

    public void addConnection(City city, int cost) { // Добавить связь (путь) к другому городу
        connections.put(city, cost);
    }

    public String getName() { // Получить название города
        return name;
    }

    public Map<City, Integer> getConnections() { // Получить все связи
        return connections;
    }

    @Override
    public String toString() { //Строковое представление города и его маршрутов
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