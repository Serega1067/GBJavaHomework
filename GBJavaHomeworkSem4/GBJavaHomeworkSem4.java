package GBJavaSeminars.GBJavaHomeworkSem4;

import java.util.LinkedList;
import java.util.Random;

/**
 * Семинар 4. Задачи.
1. Объявить и инициализировать связанный список в 10000 элементов 
случайным числом от -1024 до 1024.
2. Пройти по списку и удалить все отрицательные элементы.
3. Скопировать в переменные и удалить из списка первый и второй 
элементы, сложить переменные, результат сохранить в начало списка. 
4. Реализовать пункт №3 для всего списка.
5. Измерить время исполнения пунктов №2 и №3. 
6. *Реализовать пункты с первого по пятый но с ArrayList. 
Сравнить время исполнения.
7. **Оптимизировать реализацию заданий так, чтобы время выполнения 
LinkedList и ArrayList были наименьшим.
 */

public class GBJavaHomeworkSem4 {
    public static void main(String[] args) {
        // Задача 1
        LinkedList<Integer> resultLinkedList = 
                            new LinkedList<Integer>();
        resultLinkedList = createFillLinkedList();
        System.out.println("Task 1: ");
        System.out.println(resultLinkedList);

        // Задача 2
        long timeStart1 = System.currentTimeMillis();
        resultLinkedList = delNegativeNum(resultLinkedList);
        long timeFinish1 = System.currentTimeMillis();
        System.out.println("\nTask 2: ");
        System.out.println(resultLinkedList);
        System.out.println("Время работы программы " + 
                           (timeFinish1 - timeStart1) + " msc");

        // Задача 3
        long timeStart2 = System.currentTimeMillis();
        resultLinkedList = sumAndDelTwoElemList(resultLinkedList);
        long timeFinish2 = System.currentTimeMillis();
        System.out.println("\nTask 3: ");
        System.out.println(resultLinkedList);
        System.out.println("Время работы программы " + 
                           (timeFinish2 - timeStart2) + " msc");

        // Задача 4
        long timeStart3 = System.currentTimeMillis();
        resultLinkedList = sumAndDelTwoElemAllList(
                           resultLinkedList);
        long timeFinish3 = System.currentTimeMillis();
        System.out.println("\nTask 4: ");
        System.out.println(resultLinkedList);
        System.out.println("Время работы программы " + 
                           (timeFinish3 - timeStart3) + " msc");
        
        // Задача 5
        System.out.println();
        System.out.println("Время работы программы к задачи 2 " + 
                           (timeFinish1 - timeStart1) + " msc");
        System.out.println("Время работы программы к задачи 3 " + 
                           (timeFinish2 - timeStart2) + " msc");
        System.out.println("Время работы программы к задачи 4 " + 
                           (timeFinish3 - timeStart3) + " msc");
        
        // Задача 6
    }

    /**
     * Задача 1
     * Обьявляет и заполняет LinkedList случайными элементами 
     * в диапазоне (-1024; 1024)
     * @return
     */
    static LinkedList<Integer> createFillLinkedList() {
        LinkedList<Integer> tempList = new LinkedList<Integer>();
        Random r = new Random();
        Random b = new Random();
        for (int i = 0; i <= 10000; i++) {
            if (b.nextBoolean()) {
                tempList.add(r.nextInt(1024));
            } else {
                tempList.add(r.nextInt(1024) * -1);
            }
        }
        return tempList;
    }

    /**
     * Задача 2
     * Проходит по списку и удаляет все отрецательные элементы
     * @param numList
     * @return
     */
    static LinkedList<Integer> delNegativeNum(
                               LinkedList<Integer> numList) {
        numList.removeIf(n -> n < 0);
        return numList;
    }
    
    /**
     * Задача 3
     * Метод берёт первый и второй элемент списка складывает их
     * и результат записывает в начало этого же списка
     * @param numList
     * @return
     */
    static LinkedList<Integer> sumAndDelTwoElemList(
                               LinkedList<Integer> numList) {
        int num1 = numList.pollFirst();
        int num2 = numList.pollFirst();
        // System.out.println(num1);
        // System.out.println(num2);
        numList.offerFirst(num1 + num2);
        // System.out.println(numList);
        return numList;
    }

    /**
     * Задача 4
     * Метод берёт по два элемента списка по порядку складывает 
     * и результат записывает в тот же список по порядку
     * @param numList
     * @return
     */
    static LinkedList<Integer> sumAndDelTwoElemAllList(
                               LinkedList<Integer> numList) {
        int tempNum = 0;
        int count = 0;
        if (numList.size() % 2 != 0) {
            numList.offer(0);
        }

        // Вариант 1
        // LinkedList<Integer> resultNumList = 
                            // new LinkedList<Integer>();
        // for (int i = 0; i < numList.size() - 1; i = i + 2) {
        //     resultNumList.add(numList.get(i) + numList.get(i + 1));
        // }
        // System.out.println(resultNumList);

        // Вариант 2
        while (count != numList.size()) {
            tempNum = numList.get(count);
            numList.remove(count);
            tempNum = tempNum + numList.get(count);
            numList.set(count, tempNum);
            count++;
        }
        return numList;
    }
}
