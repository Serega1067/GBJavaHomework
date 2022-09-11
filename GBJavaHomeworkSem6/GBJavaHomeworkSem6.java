package GBJavaSeminars.GBJavaHomeworkSem6;

import java.util.Set;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Random;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Семинар 6. Задачи
1. Объявить и инициализировать множества HashSet hs, 
LinkedHashSet lhs и TreeSet ts.
2. Добавить в множества по 10 случайных целочисленных ключей.
3. Пройти по множеству hs и, при условии наличия соответствующего 
ключа в множестве lhs, удалить ключ из hs.
4. Пройти по множеству lhs и, при условии отсутствия 
соответствующего ключа в множестве ts, добавит ключ в ts.
5. Объявить и инициализировать множество TreeSet ts1 с 
компаратором Integer (-1 при значении %2==0 ; 0 при == ; 1 при 
значении %2!=0). Заполнить ts1 15 случайными числами и вывести на 
печать.
6. *Объявить и инициализировать множество TreeMap tm с компаратором 
Integer (-1 при значении  %2==0 ; 0 при == ; 1 при значении %2!=0). 
Заполнить tm 15 случайными числами и вывести на печать.
 */

public class GBJavaHomeworkSem6 {
    public static void main(String[] args) {
        // Задача 1
        Set<Integer> hs = new HashSet<Integer>();
        Set<Integer> lhs = new LinkedHashSet<Integer>();
        Set<Integer> ts = new TreeSet<Integer>();

        // Задача 2
        System.out.println("Задачи 1, 2");
        hs = fillSetRandomElem(hs, 10);
        System.out.println("HashSet: ");
        System.out.println(hs);
        lhs = fillSetRandomElem(lhs, 10);
        System.out.println("LinkedHashSet: ");
        System.out.println(lhs);
        ts = fillSetRandomElem(ts, 10);
        System.out.println("TreeSet: ");
        System.out.println(ts);

        // Задача 3
        System.out.println("\nЗадача 3");
        hs = findAndDelEqualsElem(hs, lhs);
        System.out.println(hs);

        // Задача 4
        findAndAddElem(lhs, ts);
        System.out.println("\nЗадача 4");
        System.out.println(ts);

        // Задача 5
        Set<Integer> ts1 = new TreeSet<Integer>(
                           new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                if (t1 == t2) {
                    return 0;
                }
                if (t2 % 2 == 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        ts1 = fillSetRandomElem(ts1, 15);
        System.out.println("\nЗадача 5");
        System.out.println(ts1);

        // Задача 6
        TreeMap<Integer, String> tm = new TreeMap<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer t1, Integer t2) {
                    if (t1 == t2) {
                        return 0;
                    }
                    if (t1 % 2 == 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        );
        for (int i = 0; i < 15; i++) {
            tm.put(new Random().nextInt(15), "");
        }
        System.out.println("\nЗадача 6");
        System.out.println(tm);
    }

    /**
     * Задача 2
     * Метод получает пустой Set и число обозначающее количество 
     * рандомных целых чисел, которые нужно положить в Set и 
     * вернуть
     * @param argSet
     * @param lengthSet
     * @return
     */
    public static Set<Integer> fillSetRandomElem(Set<Integer> argSet, 
                                          int lengthSet) {
        Random r = new Random();
        for (int i = 0; i < lengthSet; i++) {
            argSet.add(r.nextInt(100));
        }
        return argSet;
    }

    /**
     * Задача 3
     * Метод ищет и удаляет из первого Set элементы, которые 
     * есть во втором Set и возвращает изменённый первый Set
     * @param argSet1
     * @param argSet2
     * @return
     */
    public static Set<Integer> findAndDelEqualsElem(Set<Integer> argSet1, 
                         Set<Integer> argSet2) {
        Iterator<Integer> it = argSet1.iterator();
        while (it.hasNext()) {
            if (argSet2.contains(it.next())) {
                it.remove();
            }
        }
        return argSet1;
    }

    /**
     * Задача 4
     * Метод ищет в первом Set элементы, которых нет во втором и
     * добовляет их во второй
     * @param argSet1
     * @param argSet2
     * @return
     */
    public static Set<Integer> findAndAddElem(Set<Integer> argSet1, 
                                       Set<Integer> argSet2) {
        for (Integer item : argSet1) {
            if (! argSet2.contains(item)) {
                argSet2.add(item);
            }
        }
        return argSet2;
    }
}
