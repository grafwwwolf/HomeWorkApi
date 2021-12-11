import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Api {

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5};
        List<Integer> integerList = Arrays.asList(intArray);
        List<String> stringList = new ArrayList<>();
        stringList.add("ара");
        stringList.add("абра");
        stringList.add("азъ");
        stringList.add("бук");
        stringList.add("веди");
        stringList.add("акр");
        stringList.add("арабика");
        stringList.add("Что здесь вообще происходит?");

        //Задание 1. Вызов
        System.out.println(search(6, integerList, (a, b) -> b.indexOf(a)));

        //Задание 2. Вызов
        System.out.println(reverse("Тестовое сообщение", str -> new StringBuilder(str).reverse().toString()));

//        Задание 3, Вызов
        System.out.println(maximum(integerList, list -> Collections.max(list)));

        // Задание 4, вызов
        System.out.println(average(integerList, list -> {
            if (list.size() == 0) {
                return 0.0;
            }
            Integer sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            return sum / (list.size() * 1.0);
        }));
        // Задание 5, вызов
        System.out.println(search(stringList, str -> {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < str.size(); i++) {
                if ((str.get(i).length() == 3) && (str.get(i).charAt(0) == 'а')) {
                    result.add(str.get(i));
                }
            }
            return result;
        }));

    }

    //Задание 1, метод
    public static int search(Integer n, List<Integer> list, BiFunction<Integer, List<Integer>, Integer> biFunction) {
        return biFunction.apply(n, list);
    }

    //Задание 2, метод
    public static String reverse(String s, StringReverse strReverse) {
        return strReverse.reverse(s);
    }

    //Задание 3, метод
    public static Integer maximum(List<Integer> list, MaxNumberFromList retMaxNumber) {
        return retMaxNumber.maxNumber(list);
    }

    //    Задание 4, метод
    public static Double average(List<Integer> list, Function<List<Integer>, Double> function) {
     return function.apply(list);
    }

    //Задание 5, метод
    public static List<String> search(List<String> list, SearchStrList searchList) {
    return searchList.searchStringFromStringList(list);
    }
}