package GBJavaSeminars.GBJavaHomeworkSem2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Задачи.
1. Напишите программу на Java, чтобы найти наименьшее окно в 
строке, содержащей все символы другой строки.
2. Напишите программу на Java, чтобы проверить, являются ли 
две данные строки вращением друг друга.
3. *Напишите программу на Java, чтобы перевернуть строку с 
помощью рекурсии.
4. Дано два числа, например 3 и 56, необходимо составить 
следующие строки:
3 + 56 = 59
3 – 56 = -53
3 * 56 = 168
Используем метод StringBuilder.append().
5. Замените символ “=” на слово “равно”. Используйте методы 
StringBuilder.insert(), StringBuilder.deleteCharAt().
6. *Замените символ “=” на слово “равно”. Используйте методы 
StringBuilder.replace().
7. **Сравнить время выполнения пункати 6 со строкой содержащей 
10000 символов "=" средствами String и StringBuilder.
*/

public class GBJavaHomeworkSem2 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите строку A: ");
        String strA = iScanner.nextLine();
        System.out.printf("Введите подстроку B: ");
        String strB = iScanner.nextLine();
        iScanner.close();

        /**
         * Task 1
         */
        System.out.println(
                "Все наименьшие окна строки A, если они есть: ");
        minWindow(strA, strB);

        /**
         * Task 2
         */
        System.out.println();
        if (searchPalindrom(strA, strB)) {
            System.out.println("Строки являются вращением " +
                               "друг друга");
        } else
            System.out.println("Строки не являются вращением " +
                               "друг друга");

        /**
         * Task 3
         */
        System.out.println();
        System.out.printf("Переворачиваем строку A: %s\n", 
                          reverseStr(strA));
        System.out.printf("Переворачиваем подстроку B: %s\n", 
                          reverseStr(strB));

        /**
         * Task 4
         */
        System.out.println();
        System.out.println("Переводим уравнение в строки: ");
        int a = 3;
        int b = 56;
        System.out.println(compilerMathToStr(a, b, '+'));
        System.out.println(compilerMathToStr(a, b, '-'));
        System.out.println(compilerMathToStr(a, b, '*'));

        /**
         * Task 5
         */
        System.out.println();
        System.out.println("Заменим знак '=' на слово 'равно' " +
                              "с помощью метода StringBuilder.insert(), " +
                              "StringBuilder.deleteCharAt():");
        System.out.println(replacEqual(
                           compilerMathToStr(
                           a, b, '+')));
        System.out.println();

        /**
         * Task 6
         */
        System.out.println("Заменим знак '=' на слово 'равно' " +
                           "с помощью метода StringBuilder.replace():");
        System.out.println(nextReplacEquel(
                           compilerMathToStr(
                           a, b, '-')));
        System.out.println();
    }

    public static void minWindow(String textA, String textB) {
        // 1. Напишите программу на Java, чтобы найти наименьшее 
        // окно в строке, содержащей все символы другой строки.
        Pattern pattern = Pattern.compile(textB);
        Matcher matcher = pattern.matcher(textA);
        while (matcher.find()) {
            System.out.println(textA.substring(matcher.start(), 
                               matcher.end()));
        }
    }

    // 2. Напишите программу на Java, чтобы проверить, 
    // являются ли две данные строки вращением друг друга.
    public static boolean searchPalindrom(String strA, 
                                          String strB) {
        return strA.equals(new StringBuilder(
                               strB).reverse().toString());
    }

    // 3 *Напишите программу на Java, чтобы перевернуть строку 
    // с помощью рекурсии.
    public static String reverseStr(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return reverseStr(str.substring(1)) + 
                          str.charAt(0);
    }

    // 4. Дано два числа, например 3 и 56, необходимо составить 
    // следующие строки:
    // 3 + 56 = 59
    // 3 – 56 = -53
    // 3 * 56 = 168
    // Используем метод StringBuilder.append().
    public static String compilerMathToStr(int num1, 
                                           int num2, 
                                           char sign) {
        StringBuilder mathTask = new StringBuilder();
        mathTask.append(num1).append(" ").append(sign).append(
                                     " ").append(num2).append(" = ");
        switch (sign) {
            case '+':
                mathTask.append(num1 + num2);
                break;
            case '-':
                mathTask.append(num1 - num2);
                break;
            case '*':
                mathTask.append(num1 * num2);
                break;
        }
        return mathTask.toString();
    }

    // 5 Замените символ “=” на слово “равно”. Используйте методы
    // StringBuilder.insert(),
    // StringBuilder.deleteCharAt().
    public static String replacEqual(String mathTask) {
        StringBuilder task = new StringBuilder(mathTask);
        int index = task.indexOf("=");
        return task.deleteCharAt(index).insert(
                                 index, "равно").toString();
    }

    // 6 *Замените символ “=” на слово “равно”. Используйте методы
    // StringBuilder.replace().
    public static String nextReplacEquel(String mathTask) {
        StringBuilder task = new StringBuilder(mathTask);
        int index = task.indexOf("=");
        return task.replace(index, index + 1, "равно").toString();
    }
}