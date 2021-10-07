package model;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        if (plate.getFood() < appetite) {
            plate.decreaseFood(appetite);
            System.out.println(name + " голоден");
            return;
        } else {
            plate.decreaseFood(appetite);
            satiety = true;
            System.out.println(name + " поел и теперь сытый.");
        }
    }

    public void eatToSatiety(Plate plate) {
        while (!satiety) {
            if (plate.getFood() < appetite) {
                plate.decreaseFood(appetite);
                plate.addFood(10);
            } else {
                plate.decreaseFood(appetite);
                satiety = true;
                System.out.println(name + " поел и теперь сытый.");
            }
        }
    }
}
