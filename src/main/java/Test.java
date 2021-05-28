import java.util.Arrays;
import java.util.Random;

public class Test {
    //Задание 6.1
    //Приведите пример использования древовидной структуры.
    // PDF использует древовидную структуру
    //Задание 6.2
    //Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
    //Задание 6.3
    //Реализуйте методы поиска и вставки узла в дерево.
    //Задание 6.4
    //Реализуйте базовые методы обхода дерева и метода дисплей.
    //Реализуйте поиск максимума и минимума.
    //Задание 6.5
    //Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
    //Задание 6.6
    //Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
    //Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
    //Задание 6.7
    //Приведите пример сбалансированного дерева и его применения.
    //Ассоциативный массив

    public static void main(String[] args) {
        long startTimer;
        MyTree myTree = new MyTree();
        myTree.insert(new Cat(4,2,"Golf"));
        myTree.insert(new Cat(2,5, "Tim"));
        myTree.insert(new Cat(1,7, "Fred"));
        myTree.insert(new Cat(3,4, "Scot"));

        startTimer = System.nanoTime();
        System.out.println(myTree.max().toString());
        System.out.println("Time method max " + (System.nanoTime() - startTimer));
        startTimer = System.nanoTime();
        System.out.println(myTree.min().toString());
        System.out.println("Time method min " + (System.nanoTime() - startTimer));
        startTimer = System.nanoTime();
        System.out.println(myTree.find(2).toString());
        System.out.println("Time method find " + (System.nanoTime() - startTimer));
        startTimer = System.nanoTime();
        myTree.delete(2);
        System.out.println("Time method delete " + (System.nanoTime() - startTimer));
        startTimer = System.nanoTime();
        myTree.display();
        System.out.println("Time method display " + (System.nanoTime() - startTimer));

        int[] arr;
        Random rand = new Random();
        arr = new int[10];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(10);
        }

        System.out.println(Arrays.toString(arr));
        HeapSort arrSort = new HeapSort();
        startTimer = System.nanoTime();
        arrSort.sort(arr);
        System.out.println("Time HeapSort  " + (System.nanoTime() - startTimer));

        System.out.println(Arrays.toString(arr));
    }
}
