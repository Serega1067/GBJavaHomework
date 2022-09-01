package GBJavaSeminars.GBJavaHomeworkSem3;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Семинар 3. Задачи.
1. Напишите программу, чтобы создать новый список массивов, 
добавить несколько цветов (строку) и вывести коллекцию на экран. 
2. Напишите программу для итерации всех элементов списка цветов 
и добавления к каждому символа '!'. 
3. Напишите программу для вставки элемента в список массивов 
в первой позиции. 
4. Напишите программу для извлечения элемента (по указанному 
индексу) из заданного списка. 
5. Напишите программу для обновления определенного элемента 
массива по заданному элементу. 
6. Напишите программу для удаления третьего элемента из списка 
массивов. 
7. Напишите программу для поиска элемента в списке массивов. 
8. Напишите программу для сортировки заданного списка массивов. 
9. Напишите программу для копирования одного списка массивов 
в другой. 
 */

public class GBJavaHomeworkSem3 {
    public static void main(String[] args) {
        // Задача 1.
        String[] colorArr = new String[] {"black", 
                                          "yellow", 
                                          "green", 
                                          "white", 
                                          "red"};
        ArrayList<String> resultList = creatFillArray(colorArr);

        // Задача 2.
        resultList = iterationAndAddition(resultList);
        System.out.println(resultList);

        // Задача 3.
        resultList.add(1, "blue");
        System.out.println(resultList);

        // Задача 4.
        String elem;
        elem = resultList.get(0);
        System.out.println(elem);

        // Задача 5.

        // Задача 6.
        resultList.remove(2);
        System.out.println(resultList);

        // Задача 7.
        String resultFind = "";
        String findElem = "green!";
        for (Object o : resultList) {
            if (o.equals(findElem)) {
                resultFind = "Yes";
                break;
            }
            else {
                resultFind = "No";
            }
        }
        System.out.println(resultFind);

        // Задача 8.

        // Задача 9.
        ArrayList<String> newResultList = new ArrayList<String>();
        newResultList = (ArrayList<String>) resultList.clone();
        System.out.println(newResultList);

    }

    /**
     * Создаёт массив, заполняет его и выводит в консоль
     * @param arr
     * @return
     */
    static ArrayList<String> creatFillArray(String[] arr) {
        ArrayList<String> colorList = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            colorList.add(arr[i]);
        }
        for (Object o : colorList) {
            System.out.println(o);
        }
        return colorList;
    }

    /**
     * Итерация всех элементов списка цветов и добавления 
     * к каждому символа '!'
     * @param arrList
     * @return
     */
    static ArrayList<String> iterationAndAddition(
                             ArrayList<String> arrList) {
        String temp = "";
        ArrayList<String> newArrList = new ArrayList<String>();
        for (Object o : arrList) {
            temp = o + "!";
            newArrList.add(temp);
        }
        return newArrList;
    }
}
