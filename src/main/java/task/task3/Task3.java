package task.task3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        long startTimer;
        long stopTimer;
        Integer[] arr = new Integer[10];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(15);
        }

        //Задание 3.1
        //На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
        startTimer = System.nanoTime();
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        stopTimer = System.nanoTime();
        System.out.print("Time array to arrayList " + (stopTimer - startTimer) + " - ");
        System.out.println(arrayList);
        startTimer = System.nanoTime();
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(arr));
        stopTimer = System.nanoTime();
        System.out.print("Time array to linkedList " + (stopTimer - startTimer) + " - ");
        System.out.println(linkedList);

        //Задание 3.2
        //На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.

        startTimer = System.nanoTime();
        arrayList.add(random.nextInt(15));
        stopTimer = System.nanoTime();
        System.out.print("Time add to arrayList " + (stopTimer - startTimer) + " - ");
        System.out.println(arrayList);
        startTimer = System.nanoTime();
        linkedList.add(random.nextInt(15));
        stopTimer = System.nanoTime();
        System.out.print("Time add to linkedList " + (stopTimer - startTimer) + " - ");
        System.out.println(linkedList);

        startTimer = System.nanoTime();
        arrayList.add(1,5);
        stopTimer = System.nanoTime();
        System.out.print("Time add to index 1 from arrayList " + (stopTimer - startTimer));
        System.out.println(arrayList);
        startTimer = System.nanoTime();
        linkedList.add(1,5);
        stopTimer = System.nanoTime();
        System.out.print("Time add to index 1 from linkedList " + (stopTimer - startTimer) + " - ");
        System.out.println(linkedList);

        startTimer = System.nanoTime();
        arrayList.remove(arrayList.size()/2);
        stopTimer = System.nanoTime();
        System.out.print("Time remove to index size/2 from arrayList " + (stopTimer - startTimer) + " - ");
        System.out.println(arrayList);
        startTimer = System.nanoTime();
        linkedList.remove(linkedList.size()/2);
        stopTimer = System.nanoTime();
        System.out.print("Time remove to index size/2 from linkedList " + (stopTimer - startTimer) + " - ");
        System.out.println(linkedList);

        startTimer = System.nanoTime();
        System.out.print("Random number " + arrayList.get(random.nextInt(arrayList.size())) + " - ");
        stopTimer = System.nanoTime();
        System.out.println("Time get to random index from arrayList " + (stopTimer - startTimer));
        startTimer = System.nanoTime();
        System.out.print("Random number " + linkedList.get(random.nextInt(linkedList.size())) + " - ");
        stopTimer = System.nanoTime();
        System.out.println("Time get to random index from linkedList " + (stopTimer - startTimer));

        //Задание 3.3
        //Реализуйте простой односвязный список и его базовые методы.

        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.myToString();
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get("3"));
        list.remove("1");
        list.remove(0);
        list.myToString();

        //Задание 3.4
        //На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        //Реализуйте список заполненный объектами из вашего класса из задания 1.3

        TwoSidedLinkedList<Integer> tsll = new TwoSidedLinkedList<>();
        for (Integer integer : arr) {
            tsll.add(integer);
        }

        tsll.myToString();
        tsll.remove(random.nextInt(tsll.size()));
        System.out.println(tsll.get(7));
        tsll.myToString();

        TwoSidedLinkedList<Cat> catList = new TwoSidedLinkedList<>();
        catList.add(new Cat(2,"Golf"));
        catList.add(new Cat(5, "Tim"));
        catList.add(new Cat(7, "Fred"));
        catList.add(new Cat(4, "Scot"));
        catList.add(new Cat(15, "Wins"));
        System.out.println(catList.get(0));
        catList.remove(4);
        catList.myToString();

        //Задание 3.5
        //Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime()

        ListIterator<Cat> iterator = catList.listIterator();
        startTimer = System.nanoTime();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        stopTimer = System.nanoTime();
        System.out.println("Time iterator " + (stopTimer - startTimer));

        startTimer = System.nanoTime();
        while (iterator.hasPrevious()){
            System.out.print(iterator.previousIndex() + ": ");
            System.out.println(iterator.previous());
        }
        stopTimer = System.nanoTime();
        System.out.println("Time reverse iterator " + (stopTimer - startTimer));
    }
}
