import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

import java.lang.reflect.Array;

public class Api {

    public static void main(String[] args) {

        String[][] strArray = new String[4][4];
        strArray[0][0] = "1";
        strArray[0][1] = "1";
        strArray[0][2] = "1";
        strArray[0][3] = "1";
        strArray[1][0] = "1";
        strArray[1][1] = "1";
        strArray[1][2] = "20";
        strArray[1][3] = "1";
        strArray[2][0] = "1";
        strArray[2][1] = "1";
        strArray[2][2] = "1";
        strArray[2][3] = "1";
        strArray[3][0] = "1";
        strArray[3][1] = "1";
        strArray[3][2] = "1";
        strArray[3][3] = "-20";
        try {
            sumArray(strArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void sumArray(String[][] twoDimArray) throws MyArraySizeException, MyArrayDataException {

        if (twoDimArray.length != 4 || twoDimArray.length != twoDimArray[0].length) {
            throw new MyArraySizeException("Неверная длина массива. Массив должен иметь длину 4х4");
        }

        int sum = 0;
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray.length; j++) {
                try {
                    sum += Integer.parseInt(twoDimArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке: " + i + ", " + j);
                }
            }
        }
        System.out.println(sum);
    }
}
