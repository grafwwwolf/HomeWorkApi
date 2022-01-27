public interface Moveable extends Jumpable, Runnable {

    void move(Preventsable obstacle);
}
