import java.util.Arrays;

public class Api {

    static final int size = 10000001;
    static final int h = size / 2;

    public static void main(String[] args) {

        testCountMethod();
        try {
            testCountMethodInTreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void testCountMethod() {
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static void testCountMethodInTreads() throws InterruptedException {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[size - h];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        Thread firstTread = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread secondTread = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, size - h);

        firstTread.start();
        secondTread.start();

        firstTread.join();
        secondTread.join();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, size - h);

        System.out.println(System.currentTimeMillis() - startTime);
    }
}
