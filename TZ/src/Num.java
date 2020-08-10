/*
Задача №1
Имеется массив чисел, получить список вида {число, количество вхождений числа в массив}, список
должен быть отсортирован по количеству вхождений, внутри по возрастания числа. Использовать
можно любой алгоритмический язык.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num {
    public static void main(String[] args) {
        Integer[] numArr = {1, 1, 2, 3, 5, 7, 8, 9, 9, 9, 9, 9, 9}; // Задаем ассив чисел (можно спарсить/ввести вручную)
        Map<Integer, Integer> map = new HashMap<>();
        // Считаем количество вхождений
        Arrays.asList(numArr).forEach(num -> {
            map.put(num, map.getOrDefault(num, 0) + 1);
        });
        // Сортировка по количеству вхождений
        map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
