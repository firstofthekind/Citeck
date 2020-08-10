/*
Задача №3
Написать алгоритм, как в целом числе самый правый ноль превратить в единицу не используя
циклы и рекурсию.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Задаем регулярное выражение для поиска самого правого нуля
        Pattern pattern = Pattern.compile("(0)(?!.*\\1)");
        long num = 1;
        System.out.print("Введите целое число: ");
        // Проверяем целое ли число передано из консоли
        if (sc.hasNextLong()) {
            num = sc.nextLong();
            // Проверяем наличие нуля в числе
            if (Long.toString(num).indexOf("0") != -1) {
                // Сам алгоритм
                Matcher matcher = pattern.matcher(Long.toString(num));
                String result = matcher.replaceAll("1");
                System.out.println(result);
            } else {
                System.out.println("В введеном числе нет нуля");
            }
        } else {
            System.out.println("Вы ввели не целое число");
        }
    }
}
