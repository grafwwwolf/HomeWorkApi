import java.util.Random;

public class Wall implements Preventsable {

    private int height;

    public Wall() {
        this.height = new Random().nextInt(10) + 2;
    }

    public int getHeight() {
        return height;
    }
}
