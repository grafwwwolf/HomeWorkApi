import java.util.Random;

public class Cat implements Moveable {

    private String name;
    private int maxRun;
    private int maxJump;
    private boolean isFinished;

    public Cat(String name) {
        this.name = name;
        this.maxJump = new Random().nextInt(10) + 2;
        this.maxRun = new Random().nextInt(10) + 4;
    }

    public String getName() {

        return name;
    }

    public int getMaxRun() {

        return maxRun;
    }

    public int getMaxJump() {

        return maxJump;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public void jump() {

        System.out.println(getName() + " jump!");
    }

    @Override
    public void run() {

        System.out.println(getName() + " run!");
    }

    @Override
    public void move(Preventsable obstacle) {
        if (obstacle instanceof Wall) {
            jump();
            if (this.getMaxJump() < ((Wall) obstacle).getHeight()) {
                System.out.println("Кот  " + getName() + " не смог перепрыгнуть");
                setFinished(false);
            } else {
                System.out.println("Кот  " + getName() + " успешно перепрыгнул");
                setFinished(true);
            }
        } else {
            run();
            if (this.getMaxRun() < ((Treadmill) obstacle).getLength()) {
                System.out.println("Кот  " + getName() + " не смог пробежать");
                setFinished(false);
            } else {
                System.out.println("Кот  " + getName() + " успешно пробежал");
                setFinished(true);
            }
        }
    }
}
