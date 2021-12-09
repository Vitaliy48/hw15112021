package hw6;

public abstract class Animals {
    String name ;
    static  int quantityAnimals;

    public  Animals ( String  name ) {
        this.name = name;
        quantityAnimals++;
    }
    public  abstract  void  run (int i);
    public  abstract  void swimming (int i);
    public  static  int  getQuantityAnimals () {
        return quantityAnimals;
    }
}