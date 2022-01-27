package service;

import model.Cat;
import model.Plate;

public class CatService {
    private Cat[] catsArray;

    public CatService(Cat... catsArray) {
        this.catsArray = catsArray;
    }

    public void eatToSatiety(Plate plate) {
        for (Cat cat : catsArray) {
            while (!cat.isSatiety()) {
                if (plate.getFood() < cat.getAppetite()) {
                    plate.decreaseFood(cat.getAppetite());
                    plate.addFood(10);
                } else {
                    plate.decreaseFood(cat.getAppetite());
                    cat.setSatiety(true);
                    System.out.println(cat.getName() + " поел и теперь сытый.");
                }
            }
        }
    }

    public void eat(Plate plate) {
        for (Cat cat : catsArray) {
            if (plate.getFood() < cat.getAppetite()) {
                plate.decreaseFood(cat.getAppetite());
                System.out.println(cat.getName() + " голоден");
            } else {
                plate.decreaseFood(cat.getAppetite());
                cat.setSatiety(true);
                System.out.println(cat.getName() + " поел и теперь сытый.");
            }
        }
    }
}