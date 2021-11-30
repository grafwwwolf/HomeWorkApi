import java.util.*;

public class Api {

    public static void main(String[] args) {

        String[] wordsArray = {"Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять", "Один", "Три", "Пять", "Семь", "Девять", "Один", "Пять", "Девять", "Один", "Пять"};
        uniqueListFromStringArray(wordsArray);

        TelephoneDirectory pBook = new TelephoneDirectory();
        pBook.add("Кузнецов", "89279272727");
        pBook.add("Иванов", "89777777777");
        pBook.add("Кузнецов", "89999999999");
        pBook.add("Кузнецов", "89993333333");
        pBook.get("Кузнецов");
        pBook.get("Иванов");
        pBook.get("Сидоров");

    }

    public static void uniqueListFromStringArray(String[] stringArray) {
        Set<String> uniqueSet = new HashSet<String>();
        uniqueSet.addAll(Arrays.asList(stringArray));
        System.out.println("Список уникальных слов:");
        for (String str: uniqueSet) {
            System.out.println(str);
        }
        System.out.println("--------------------------------------");
        for (String str: uniqueSet) {
            countingWordsIn(str, stringArray);
        }
    }

    public static void countingWordsIn(String word, String[] stringArray) {
        int count = 0;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(word)) {
                count++;
            }
        }
        System.out.println("Слово: \"" + word + "\" встречается " + count + " раз.");
    }
}

