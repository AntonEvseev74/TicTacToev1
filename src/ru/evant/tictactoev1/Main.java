package ru.evant.tictactoev1;

import java.util.Scanner;

/* Игра Крестики - Нолики */
/* Игровое поле:
    _ _ _
    _ _ _
    _ _ _
    Индексы ячеек игрового поля:
    1 2 3
    4 5 6
    7 8 9
    Символы игроков:
    X - крестик
    O - нолик
 */

public class Main {

    private static String[] gameField;      // Ссылочная переменная на массив. Для игрового поля. Массив.
    private static int input;               // Переменная для пользовательского ввода
    public static final String FREE = " _ ";// Свободная ячейка
    public static final String X = " X ";   // Крестик
    public static final String O = " O ";   // Нолик
    private static boolean checkCell;       // Проверка ячейки. true - свободна, false - не свобона
    private static boolean gameOver;        // Конец игры

    public static void main(String[] args) {

        System.out.println("Крестики - Нолики\nНомера ячеек:\n 1  2  3\n 4  5  6\n 7  8  9\nИгровое поле:");
        create(); // Создать игровое поле
        display(); // Отобразить игровое поле в консоли

        while (!gameOver) {
            game(); // Ход игры. Ходы игроков. Вывод в консоль.
        }

    }  // конец метода main()

    /* Ход игры */
    private static void game() {
        if (!gameOver) {
            moveUser(); // Ход пользователя
            display();  // Отобразить поле
        }
        if (!gameOver) {
            moveAI();   // Ход компьютера
            display();  // Отобразить поле
        }
    }  // конец метода game()

    /* Проверка выигрышных комбинаций, три в ряд */
    private static void checkGameOver() {
        if (gameField[0].equals(X) && gameField[1].equals(X) && gameField[2].equals(X)) gameOver = true;
        if (gameField[0].equals(O) && gameField[1].equals(O) && gameField[2].equals(O)) gameOver = true;

        if (gameField[3].equals(X) && gameField[4].equals(X) && gameField[5].equals(X)) gameOver = true;
        if (gameField[3].equals(O) && gameField[4].equals(O) && gameField[5].equals(O)) gameOver = true;

        if (gameField[6].equals(X) && gameField[7].equals(X) && gameField[8].equals(X)) gameOver = true;
        if (gameField[6].equals(O) && gameField[7].equals(O) && gameField[8].equals(O)) gameOver = true;

        if (gameField[0].equals(X) && gameField[3].equals(X) && gameField[6].equals(X)) gameOver = true;
        if (gameField[0].equals(O) && gameField[3].equals(O) && gameField[6].equals(O)) gameOver = true;

        if (gameField[1].equals(X) && gameField[4].equals(X) && gameField[7].equals(X)) gameOver = true;
        if (gameField[1].equals(O) && gameField[4].equals(O) && gameField[7].equals(O)) gameOver = true;

        if (gameField[2].equals(X) && gameField[5].equals(X) && gameField[8].equals(X)) gameOver = true;
        if (gameField[2].equals(O) && gameField[5].equals(O) && gameField[8].equals(O)) gameOver = true;

        if (gameField[0].equals(X) && gameField[4].equals(X) && gameField[8].equals(X)) gameOver = true;
        if (gameField[0].equals(O) && gameField[4].equals(O) && gameField[8].equals(O)) gameOver = true;

        if (gameField[2].equals(X) && gameField[4].equals(X) && gameField[6].equals(X)) gameOver = true;
        if (gameField[2].equals(O) && gameField[4].equals(O) && gameField[6].equals(O)) gameOver = true;
    } // конец метода checkGameOver()

    /* Ход компьютера */
    private static void moveAI() {
        checkGameOver();
        if (!gameOver) {
            int randomNumber = (int) (Math.random() * 8); // Присвоить пременной случайное число от 0 до 8. Это индексы ячеек игрового поля.
            checkCell = checkCell(randomNumber); // Присвоить переменной значение true - свободная ячейка или false - не свободная ячейка

            if (checkCell)
                gameField[randomNumber] = O; // Если свободна (true). Присвоить ячейке игрового поля значение нолик
            else moveAI(); // Иначе сново запустить ход компьютера
        } else {
            System.out.println("Вы выиграли! Конец игры");
        }
    } // конец метода moveAI()

    /* Ход пользователя */
    private static void moveUser() {
        checkGameOver(); // Проверка окончена ли игра
        if (!gameOver) { // если игра не окончена
            Scanner scanner = new Scanner(System.in);
            System.out.print("Выберите ячейку(введите число от 1 до 9):\n$:/ ");
            if (scanner.hasNextInt()){ // Проверить, является ли ввод пользователя - целым числом
                input = scanner.nextInt(); // Присвоить переменной input значение введенное пользователем
                checkInput(input); // проверить число в диапазоне от 1 до 9
                int indexCell = input - 1; //
                checkCell = checkCell(indexCell); // Присвоить переменной значение true - свободная ячейка или false - не свободная ячейка

                if (checkCell) // если ячейка свободна
                    gameField[indexCell] = X; // Если свободна (true). Присвоить ячейке игрового поля значение крестик
                else moveUser(); // Иначе сново запустить ход пользователя
            } else {
                moveUser();
            }
        } else {
            System.out.println("Выиграл компьютер! Конец игры");
        }
    } // конец метода moveUser()

    /* Проверка пользовательского ввода на корректность */
    private static void checkInput(int userInput) {
        if(userInput > 0 && userInput <= 9) input = userInput;
        else moveUser();
    } // конец метода checkInput()

    /* Проверка ячейки. Свободна или нет. */
    private static boolean checkCell(int indexCell) {
        if (gameField[indexCell].equals(FREE)) return true;
        return false;
    } // конец метода checkCell()

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
            gameField[i - 1] = FREE; // Заполнить массив начальными символами, обозначающими свободную ячейку.
        }
    } // конец метода create()
} // конец класса Main
