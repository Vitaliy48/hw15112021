package hw7;

public  class  Main {
    public  static  void  main ( String [] args ) {
        Plate plate = new Plate(100);
        Cat [] cats =  new Cat [] {
            new Cat ("Барсик", 55),
            new Cat ("Васька", 20),
            new Cat ("Фунтик", 15),
            new Cat ("Рыжик", 10),
            new Cat ("Пушок", 5),

        };

        for (int i =  0; i < cats.length; i ++) {
            cats [i].goEat (plate);
        }
        System.out.println ("В тарелке осталось " + plate.getEat () + " еды");

        plate.putEat(50);
        for (int i = 0; i < cats.length; i++) {
            cats [i].goEat (plate);
        }

    }
}