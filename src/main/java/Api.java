

public class Api {

    public static void main(String[] args) {

//        задание 1
        PrinterClassForHomeWork printer = new PrinterClassForHomeWork();

        new Thread(() -> printer.printA()).start();
        new Thread(() -> printer.printB()).start();
        new Thread(() -> printer.printC()).start();

    }
}
