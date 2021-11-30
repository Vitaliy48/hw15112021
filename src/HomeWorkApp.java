import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {

    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("Поздравляем! Вы выиграли!");
                break;
            }
            printMap();
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил");
                break;
            }
            printMap();
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }
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
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();

        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("input X,Y");
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        int x, y;
        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
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

    /*public static boolean checkWin(char c) {
        if (map [0][0] == c && map [0][1] == c && map [0][2] == c) {return true;}
        if (map [1][0] == c && map [1][1] == c && map [1][2] == c) {return true;}
        if (map [2][0] == c && map [2][1] == c && map [2][2] == c) {return true;}

        if (map [0][0] == c && map [1][0] == c && map [2][0] == c) {return true;}
        if (map [0][1] == c && map [1][1] == c && map [2][1] == c) {return true;}
        if (map [0][2] == c && map [1][2] == c && map [2][2] == c) {return true;}

        if (map [0][0] == c && map [1][1] == c && map [2][2] == c) {return true;}
        if (map [0][2] == c && map [1][1] == c && map [2][0] == c) {return true;}

        return false;
    }*/

    public static boolean checkLine(int y, int x, int dy, int dx,char c) {
        if (x + dx * (DOTS_TO_WIN -  1 ) > SIZE -  1  ||
                y + dy * (DOTS_TO_WIN -  1 ) > SIZE -  1  ||
                y + dy * (DOTS_TO_WIN -  1 ) <  0 ) {
            return false;
        }

        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[y + i * dy][x + i * dx] != c)
            return false;
        }
        return true;
    }

    public static boolean checkWin(char c) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, c))
                    return true;
                if (checkLine(i, j, 1, 0, c))
                    return true;
                if (checkLine(i, j, 1, 1, c))
                    return true;
                if (checkLine(i, j, -1, 1, c))
                    return true;
            }
        }
        return false;
    }
}



