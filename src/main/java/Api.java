import model.Cat;
import model.Plate;

public class Api {

    public static void main(String[] args) {
        Plate plate = new Plate(0);
        Cat catBarsik = new Cat("Барсик", 5);
        Cat catMurzik = new Cat("Мурзик", 3);
        Cat catBoris = new Cat("Борис", 7);
        Cat [] catsArray = {catBarsik, catMurzik, catBoris};
        plate.info();
        for (int i = 0; i < catsArray.length; i++) {
        catsArray[i].eatToSatiety(plate);
        }
        plate.info();
    }
}
