package hw6;

public class Cat extends Animals {
    static  int quantityCat;

    public Cat (String  name) {
        super (name);
        quantityCat++;
    }
    @Override
    public  void  run (int  i) {
        if (i <=  200 ) {
            System.out.println (name + " " +"пробежал" + " " + i +  "м");
        } else {
            System.out.println (name + " " + "может пробежать не больше 200м" );
        }
    }
    @Override
    public  void  swimming (int  i) {
        if (true) {
            System.out.println (name + " " + "не умеет плавать");
        }
    }
    public static int getQuantityCat () {
                return quantityCat;
    }
}