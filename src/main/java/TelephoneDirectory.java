import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private Map<String, List<Long>> phoneBook;

    public TelephoneDirectory() {
        this.phoneBook = new HashMap<String, List<Long>>();
    }

    public void add(String surname, String phoneNumber) {
    try {
        Long numberOfPhone = Long.parseLong(phoneNumber);

        if (phoneBook.containsKey(surname)) {
            phoneBook.get(surname).add(numberOfPhone);
        } else {
            List<Long> phoneList = new ArrayList<Long>();
            phoneList.add(numberOfPhone);
            phoneBook.put(surname, phoneList);
        }
    } catch (NumberFormatException e) {
        System.out.println("Для контакта " + surname + " введенный формат телефона неверен. Введите цифры без пробелов");
    }
    }

    public void get(String surname) {
        if (phoneBook.containsKey(surname)) {
            System.out.print(surname + ": ");
            System.out.println(phoneBook.get(surname));
        } else {
            System.out.println("Контакта по фамилии " + surname + " не найдено");
        }
    }
}
