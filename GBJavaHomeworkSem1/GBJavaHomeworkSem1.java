package GBJavaSeminars.GBJavaHomeworkSem1;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

/*
Задачи.
1. Выбросить случайное целое число и сохранить в i.
2. Посчитать и сохранить в n номер старшего значащего 
бита выпавшего числа.
3. Найти все кратные n числа большие i и сохранить в массив m1.
4. Найти все некратные n числа меньшие i и сохранить в массив m2.
5. Сохранить оба массива в файлы с именами m1 и m2 соответственно.
Пункты реализовать в методе main.
*Пункты реализовать в разных методах.
**Реализовать один из пунктов рекурсией.
*/

public class GBJavaHomeworkSem1 {
    public static void main(String[] args) {
        // Задача 1. Выбросить случайное целое число и сохранить в i.
        short i = randomNumber();
        System.out.println("Случайное целое число: " + i);
        
        // Задача 2. Посчитать и сохранить в n номер старшего 
        // значащего бита выпавшего числа.
        short n = 0;
        n = findLenByteNum(i);
        System.out.println("Номер старшего бита: " + n);

        // 3. Найти все кратные n числа большие i и сохранить в 
        // массив m1.
        int count1 = 0;
        int lenArrays[] = new int[2];
        lenArrays = countLenArrayMaxValue(i, n);
        int[] m1 = new int[lenArrays[0]];
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1[count1] = j;
                count1++;
            }
        }

        // 4. Найти все некратные n числа меньшие i и сохранить в 
        // массив m2.
        int[] m2 = new int[lenArrays[1]];
        int count2 = 0;
        for (int k = Short.MIN_VALUE; k < i; k++) {
            if (k % n != 0) {
                m2[count2] = k;
                count2++;
            }
        }

        // 5. Сохранить оба массива в файлы с именами m1 и m2 
        // соответственно.
        recordInFile(m1, "GBJavaSeminars/GBJavaHomeworkSem1/m1.txt");
        recordInFile(m2, "GBJavaSeminars/GBJavaHomeworkSem1/m2.txt");
    }

    static short randomNumber() {
        // Метод возвращает случайное целое число
        Random r = new Random();
        short result = (short)r.nextInt();

        return result;
    }

    static short findLenByteNum(short number) {
        // Ищет номер старшего бита числа
        short count = 0;
        while (number != 0) {
            count++;
            number /= 2;
        }
        return count;
    }

    static int[] countLenArrayMaxValue(short numI, short numN) {
        // Подсчёт и вывод длины двух массивов
        int[] lenArr = new int[2];
        short maxNum = Short.MAX_VALUE;
        short minNum = Short.MIN_VALUE;
        while (minNum != maxNum) {
            if (minNum >= numI && minNum % numN == 0) {
                lenArr[0] = lenArr[0] + 1;
            }
            if (minNum < numI && minNum % numN != 0) {
                lenArr[1] = lenArr[1] + 1;
            }
            minNum++;
        }
        return lenArr;
    }

    static void recordInFile(int[] arr, String fileName) {
        // Запись массива в файл
        try (FileWriter fw = new FileWriter(fileName, false)) {
            for (int i = 0; i < arr.length; i++) {
                  fw.write(arr[i] + " ");
            }
            fw.flush();
            fw.close();
            System.out.println("Данные записанны в файл " + 
                                fileName);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
