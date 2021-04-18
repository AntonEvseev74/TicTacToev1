package ru.evant.tictactoev1;

public class Main {

    private static String [] gameField; // Игровое поле. Массив.

    public static void main(String[] args) {

        System.out.println("Крестики - Нолики");
        create(); // Создать игровое поле
        display(); // Отобразить игровое поле в консоли

    }

    /* Отобразить игровое поле в консоли */
    private static void display() {
        for (int i = 1; i <= gameField.length; i++) {
            if (i % 3 == 0) System.out.print(gameField[i - 1] + "\n");
            else System.out.print(gameField[i - 1]);
        }
        System.out.println();
    } // конец метода display()

    /* Создать игровое поле */
    private static void create() {
        gameField = new String[9]; // Создать массив длинной 9. Это 9 ячеек для поля 3 на 3 ячейки.
        for (int i = 1; i <= gameField.length; i++) {
            gameField[i-1] = " _ "; // Заполнить массив начальными символами, обозначающими свободную ячейку.
        }
    } // конец метода create()
} // конец класса Main
