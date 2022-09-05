package GBJavaSeminars.GBJavaHomeworkSem5;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *Семинар 5. Задачи
1. Объявить и инициализировать словарь hashMap<String, String>
2. Добавить в словарь 10 пар "Ключ - Значение". Автор и название 
книги например.
3. Пройти по словарю и добавить к значениям символ "!" 
4. Добавить нового автора и название книги если соответствующего 
ключа не было.
5. Если ключ, указанный в запросе, имеется, вырезать из 
соответствующего ключу значения первое слово.
6. *Пройти по словарю другим, не таким как в пункте 3, методом и 
вывести пары ключ значение в консоль.
7. ** Пройти по словарю другим, не таким как в пункте 3 и 6, 
методом. Добавить к значениям строку "(просмотрен)" и вывести в 
консоль. 
 */

public class GBJavaHomeworkSem5 {
    public static void main(String[] args) {
        // Задача 1
        Map<String, String> listHashMap = 
                                new HashMap<String, String>();
        System.out.println(listHashMap);

        // Задача 2
        listHashMap.put("J. R. R. Tolkien", 
                        "The Lord of the Rings");
        listHashMap.put("J. K. Rowling", 
                        "Harry Potter and the Philosopher's Stone");
        listHashMap.put("George R. R. Martin", 
                        "A Game of Thrones");
        listHashMap.put("Scott Lynch", 
                        "The Lies of Locke Lamora");
        listHashMap.put("John Gwynne", 
                        "Valour");
        listHashMap.put("Sebastien De Castell", 
                        "Knight’s Shadow");
        listHashMap.put("Robert Jordan", 
                        "The Shadow Rising");
        listHashMap.put("Steven Erikson", 
                        "Memories of Ice");
        listHashMap.put("R. F. Kuang", 
                        "The Poppy War");
        listHashMap.put("Josiah Bancroft", 
                        "Senlin Ascends");
        System.out.println(listHashMap);

        // Задача 3
        for (Map.Entry<String, String> pair : 
                                       listHashMap.entrySet()) {
            listHashMap.put(pair.getKey(), pair.getValue() + "!");
        }
        System.out.print(listHashMap);

        // Задача 4
        listHashMap.putIfAbsent("Nicholas Eames", 
                                "Kings of the Wyld");
        System.out.println("\n" + listHashMap);

        // Задача 5
        String strKey = "Nicholas Eames";
        String newStrKey = findChangKey(listHashMap, strKey);
        System.out.println(listHashMap);
        System.out.println(strKey);
        listHashMap.put(newStrKey, 
                        listHashMap.get("Nicholas Eames"));
        listHashMap.remove("Nicholas Eames");
        System.out.println("\n" + listHashMap);

        // Задача 6
        listHashMap.forEach((key,value) -> System.out.println(
                             key + " = " + value));
        System.out.println();

        // Задача 7
        Iterator<Entry<String, String>> it = 
            listHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> strSet = (
                Map.Entry<String, String>) it.next();
                listHashMap.put(strSet.getKey(), 
                                strSet.getValue() + "(просмотрен)");
                System.out.println(strSet.getKey() + 
                                   " = " + 
                                   strSet.getValue());
        }
    }

    /**
     * Задача 5
     * Метод ищет в HashMap ключ если находит убирает из названия 
     * ключа первое слово и возвращает новый ключ
     * @param mapList
     * @param findKey
     * @return
     */
    static String findChangKey(Map<String, String> mapList, 
                               String findKey) {
        if (mapList.containsKey(findKey)) {
            String[] words = findKey.split(" ");
            StringJoiner joiner = new StringJoiner(" ");
            for (int i = 1; i < words.length; i++) {
                joiner.add(words[i]);
            }
            findKey = joiner.toString();
            System.out.println(findKey);
            System.out.println();
        }
        return findKey;
    }
}
