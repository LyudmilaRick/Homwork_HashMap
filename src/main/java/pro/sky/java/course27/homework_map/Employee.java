package pro.sky.java.course27.homework_map;

import java.util.Objects;

public class Employee {
    private final String lastName;       // Фамилия
    private final String firstName;      // Имя


    /**
     * Конструктор нового экземпляра класса  Полное имя (Ф.И.).
     *
     * @param lastName  // Фамилия
     * @param firstName // Имя
     */
    public Employee(String lastName, String firstName) {
        this.firstName = normalize(firstName);
        this.lastName = normalize(lastName);
        // Переменные класса неизменяемые,
        // можно сразу вычислить следующие значения.
        // name = String.join(" ", this.lastName, this.firstName).trim();
        //hash = name.hashCode();
    }

    /**
     * Нормализовать строку имени.
     * Значение {@code null} заменяестся на пустую строку.
     * Убираются лишние пробелы из имени.
     * Все символы, кроме первого, преобразуются в нижний регистр.
     * Первый символ имени преобразуется верхний регистр.
     *
     * @param str Исходная строка имени.
     * @return Нормализованная строка имени.
     */
    protected final String normalize(String str) {
        if (str == null || str.isEmpty()) {
            return " ";
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }
        String res = str.replace(" ", "");
        return Character.toUpperCase(res.charAt(0)) + res.substring(1).toLowerCase();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return String.join(" ", lastName, firstName).trim();
    }

    @Override
    public String toString() {
        return String.join(" ", lastName, firstName).trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return lastName.equals(employee.lastName) && firstName.equals(employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }

}

