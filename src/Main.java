import java.util.*;

/*
        * Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут
* повторяющиеся имена с разными телефонами, их необходимо считать,
* как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.*/

public class Main {
    public static void main(String[] args) {


        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Родионов Алексей Викторович", "89452203698");
        addContact(phoneBook, "Иванов Сергей Семенович", "89893659874");
        addContact(phoneBook, "Пушкин Александр Сергеевич", "8329856312");
        addContact(phoneBook, "Пушкин Александр Сергеевич", "89091232585");
        addContact(phoneBook, "Родионов Алексей Викторович", "8587456130");
        addContact(phoneBook, "Родионов Алексей Викторович", "89336547856");
        addContact(phoneBook, "Родионов Алексей Викторович", "89123698541");
        addContact(phoneBook, "Достоевский Федор Михайлович", "8361594286");
        addContact(phoneBook, "Достоевский Федор Михайлович", "89418524598");
        addContact(phoneBook, "Лермонтов Михаил Юрьевич", "89517895263");

        printPhoneBook(phoneBook);

    }

    public static void addContact(HashMap<String, ArrayList<String>> phoneBook, String name, String phoneNumber){
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        }
        else {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public static void printPhoneBook(HashMap<String, ArrayList<String>> phoneBook) {
        HashMap<Integer, ArrayList<String>> sortPhoneBook = new HashMap<>();
        for (String name : phoneBook.keySet()) {
            int numOfNumbers = phoneBook.get(name).size();
            if (sortPhoneBook.containsKey(numOfNumbers)) {
                sortPhoneBook.get(numOfNumbers).add(name);
            }
            else {
                ArrayList<String> names = new ArrayList<>();
                names.add(name);
                sortPhoneBook.put(numOfNumbers, names);
            }
        }
        List<Integer> sortKeys = new ArrayList<>(sortPhoneBook.keySet());
        Collections.sort(sortKeys, Collections.reverseOrder());

        for (int key : sortKeys) {
            ArrayList<String> names = sortPhoneBook.get(key);
            for (String name : names) {
                System.out.println(name + ":" + key + " номер(ов) телефона");
            }

        }

    }

}