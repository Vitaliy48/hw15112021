package hw7;

public  class  Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat (String  name, int  appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public String getName() {
        return name;
    }
    public int getAppetite() {
        return appetite;
    }
    public boolean getSatiety() {
        return satiety;
    }
    public void goEat (Plate plate) {
        if  (satiety) {
            System.out.println ("Кот "  + name + " сыт...");
            return;
        }
        if (plate.lowerEat(appetite)){
            satiety = true;
            System.out.println ("Кот "  + name + " съел " + appetite);
        }else {
            System.out.println ("Коту " + name +  " нужно " + appetite + " еды, но в тарелке " + plate.getQuantityEat() +  " еды.");
        }
    }
}