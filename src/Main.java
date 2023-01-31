import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Задание 1
//Напишите метод findMinMax, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
//Данный метод принимает на вход 3 элемента:
//Stream<? extends T> stream,
//Comparator<? super T> order,
//BiConsumer<? super T, ? super T> minMaxConsumer
//Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
//minMaxConsumer.accept(min, max);
//Если стрим не содержит элементов, то вызовите:
//minMaxConsumer.accept(null, null);

        List<Integer> number = new ArrayList<>();
        number.add(5);
        number.add(3);
        number.add(8);
        number.add(2);
        number.add(9);
        number.add(14);
        number.add(23);
        number.add(21);
        Stream<Integer> numberStream = number.stream();

        findMinMax(numberStream, Integer::compareTo,
                (x,y) -> System.out.println("Минимальное число stream: " + x + " " + ", максимальное число stream: " + y));


//    Задание 2
//Реализуйте метод, который принимает на вход список целых чисел и определяет количество
//четных и выводит их в консоль. Решать именно с применением Stream API.

        evenNumbersAndQuantity(number);

    }
    public static  <T> void findMinMax (Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List <T> arrayList;
        T max = null;
        T min = null;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
        minMaxConsumer.accept(min, max);
    }

    public static void evenNumbersAndQuantity(List<Integer> list) {
        System.out.println("Количество четных чисел: " + list.stream()
                .filter(x -> x%2==0)
                .count());
    }
}