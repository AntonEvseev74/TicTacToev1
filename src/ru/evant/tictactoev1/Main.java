package ru.evant.tictactoev1;

import java.util.Scanner;

/* Игра Крестики - Нолики */
/* Игровое поле:
    _ _ _  1 2 3
    _ _ _  4 5 6
    _ _ _  7 8 9
 */

public class Main {

    private static String [] gameField; // Ссылочная переменная на массив. Для игрового поля. Массив.
    private static Scanner scanner;     // Ссылочная переменная для получения пользовательского ввода.

    public static void main(String[] args) {

        System.out.println("Крестики - Нолики");
        create(); // Создать игровое поле
        display(); // Отобразить игровое поле в консоли

        game(); // Ход игры. Ходы игроков. Вывод в консоль.

    }

    /* Ход игры */
    private static void game() {
        moveUser(); // Ход пользователя
        display();  // Отобразить поле
        moveAI();   // Ход компьютера
        display();  // Отобразить поле
    }

    private static void moveAI() {
        int randomNumber = (int) (Math.random() * 8); // Присвоить пременной случайное число от 0 до 8. Это индексы ячеек игрового поля.
        gameField[randomNumber] = " O "; // Присвоить ячейке игрового поля значение нолик
    }

    /* Ход пользователя */
    private static void moveUser() {
        scanner = new Scanner(System.in);
        System.out.println("Выберите ячейку(введите число от 1 до 9):\n$:/ ");
        int input = scanner.nextInt(); // Присвоить переменной input значение введенное пользователем
        input = input - 1;
        gameField[input] = " X "; // Присвоить ячейке игрового поля значение крестик
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
