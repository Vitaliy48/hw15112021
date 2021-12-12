package hw6;

public class Main {
    public static void main ( String [] args ) {
        Cat acat = new Cat ("Barsik");
        Cat bcat = new Cat ("Murzik");
        Dog adog = new Dog ("Tuzik");
        Dog bdog = new Dog ("Rex");

        adog.run (150);
        acat.run (50);
        bdog.run(500);
        bcat.run(200);

        adog.swimming(15);
        acat.swimming (0);
        bdog.swimming(5);
        bcat.swimming(7);

        System.out.println (Animals.getQuantityAnimals ());
        System.out.println (Cat.getQuantityCat ());
        System.out.println (Dog.getQuantityDog ());
    }
}