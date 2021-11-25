import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {


        int[] arrs = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] == 0) {
                arrs[i] = 1;
            } else {
                arrs[i] = 0;
            }
            System.out.print(arrs[i] + "  ");
        }
        System.out.println();


        int[] arrs2 = new int[100];
        for (int i = 0; i < arrs2.length; i++) {
            arrs2[i] = i;
            System.out.print(arrs2[i] + "  ");
        }
        System.out.println();


        int[] arrs3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrs3.length; i++) {
            if (arrs3[i] < 6) {
                arrs3[i] *= 2;
            }
            System.out.print(arrs3[i] + "  ");
        }
        System.out.println();

        int[][] arrs4 = new int[3][3];
        for (int i = 0; i < arrs4.length; i++) {
            for (int j = 0; j < arrs4[i].length; j++) {
                if (i == j) {
                    arrs4[i][j] = 1;
                }
                if (i + j == arrs4.length - 1) {
                    arrs4[i][j] = 1;
                }
                System.out.printf(" % 2d ", arrs4[i][j]);
            }
            System.out.println();
        }

        public static int[] arrs5 ( int len, int initialValue){  // не могу понять где у меня тут ошибка,подскуажите пожалуста!
            int[] arrs5 = new int[len];
            for (int i = 0; i < arrs5.length; i++) {
                arrs5[i] = initialValue;
            }
            return arrs5;
        }
    }
}




