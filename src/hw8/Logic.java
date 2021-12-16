package hw8;

import javax.swing.*;
import java.util.Random;

public class Logic {
    static int SIZE = 3;
    static int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Random random = new Random();

    static boolean gameFinished;

    static void go() {
        gameFinished = true;
        printMap();
        if (checkWinLines(DOT_X, DOTS_TO_WIN)) {
            System.out.println(" Поздравляем! Вы выиграли! ");
            return;

        }
        if (isFull()) {
            System.out.println(" Ничья ");
            return;
        }

        aiTurn();
        printMap();
        if (checkWinLines(DOT_O, DOTS_TO_WIN)) {
            System.out.println(" Копьютер победил. ");
            return;
        }
        if (isFull()) {
            System.out.println(" Ничья ");
            return;
        }

        gameFinished = false;
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("   ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + 1 + "  ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf(" %c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn(int x, int y) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            go();
        }
    }


    public static void aiTurn() {
        int x;
        int y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O, DOTS_TO_WIN)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOTS_TO_WIN)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
    }

    public static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkLine(int cy, int cx, int vy, int vx, char c, int dotsToWin) {
        if (cx + vx * (dotsToWin - 1) > SIZE - 1 || cy + vy * (dotsToWin - 1) > SIZE - 1 ||
                cy + vy * (dotsToWin - 1) < 0) {
            return false;
        }

        for (int i = 0; i < dotsToWin; i++) {
            if (map[cy + i * vy][cx + i * vx] != c) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWinLines(char c, int dotsToWin) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, c, dotsToWin) ||
                        checkLine(i, j, 1, 0, c, dotsToWin) ||
                        checkLine(i, j, 1, 1, c, dotsToWin) ||
                        checkLine(i, j, -1, 1, c, dotsToWin)) {
                    return true;
                }
            }
        }
        return false;
    }
}