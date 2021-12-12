package hw6;

public  class  Dog  extends   Animals{
    static  int quantityDog;

    public  Dog (String  name) {
        super (name);
        quantityDog ++;
    }

    @Override
    public void run (int  i) {
        if (i <=  500 ) {
            System.out.println (name + " " +"пробежал" + " " + i + "м");
        } else {
            System.out.println (name + " " +"может пробежать максимум 500м");
        }
    }
    @Override
    public void swimming (int i) {
        if (i <=  10) {
            System.out.println (name + " " + "проплыл" + " " + i + "м");
        } else {
            System.out.println (name + " " + "может проплыть не больше 10м");
        }
    }

    public  static  int  getQuantityDog () {
        return quantityDog;
    }
}
