package hw7;

public class Plate {
    private int eat;

    public Plate (int  eat) {
        this.eat = eat;
    }
    public int getEat() {
        return eat;
    }

    public void putEat (int eat) {
        if (eat > 0) {
            this.eat += eat;
            System.out.println("Добавили " + eat + " в тарелке " + this.eat + " еды");
        }
    }

    public boolean lowerEat (int i) {
        if (eat - i >= 0 ) {
            eat -= i;
            return true ;
        }
        return false;
    }
    public int getQuantityEat () {
        return eat;
    }
}