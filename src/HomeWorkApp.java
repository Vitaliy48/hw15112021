public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(checkingNumbers(5, 20));
        positiveNumberOrNegative(5);
        System.out.println(checkingNumber(5));
        WordNumber("Java",5);
        System.out.print(leapYear(2015));
    }
    public static boolean checkingNumbers(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }
    public static void positiveNumberOrNegative(int a) {
        if (a >= 0) {
            System.out.println("положительное");
        } else {
            System.out.println("отрицательное");
        }
    }
    public static boolean checkingNumber(int a) {
        if (a<0) {
           return true;
        }
           return false;
        }
    public static void WordNumber(String string, int a) {
        for (int j = 0; j < a; j++) {
            System.out.print(string + " ");
        }
        System.out.println();
    }
    public static boolean leapYear(int a) {
        return ((a % 100 != 0) && (a % 4 == 0) && (a % 400 == 0));
    }

}
