import java.util.Random;

public class Treadmill implements Preventsable {

private int length;

    public Treadmill() {
        this.length = new Random().nextInt(10) + 5;
    }

    public int getLength() {
        return length;
    }
}
