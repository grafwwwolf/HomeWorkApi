import model.Cat;
import model.Plate;
import service.CatService;

public class Api {

    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat catBarsik = new Cat("Барсик", 5);
        Cat catMurzik = new Cat("Мурзик", 3);
        Cat catBoris = new Cat("Борис", 7);
        plate.info();
        CatService catService = new CatService(catBarsik, catMurzik, catBoris);
        catService.eatToSatiety(plate);
        plate.info();
    }
}
