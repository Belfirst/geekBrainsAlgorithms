import java.util.Arrays;
import java.util.Random;

public class Test {
    public static long showTime(long delay) throws InterruptedException {

        System.out.println("Time from the start of the program: " + System.currentTimeMillis());
        Thread.sleep(delay);
        return showTime(delay);
    }

    public static long showTimeWhitOut(long delay) throws InterruptedException {

        System.out.println("Time from the start of the program whit out: " + System.currentTimeMillis());
        if(delay > 10000){
            System.out.println("Exiting recursion");
            return delay;
        }

        Thread.sleep(delay);
        return showTimeWhitOut(delay + delay);
    }

    public static void main(String[] args) {

        long start;
        //Задание 5.1
        //Приведите пример использования рекурсии.
        // Где-то слышал что хаккеры на 98 венде делали отаки,
        // бесконечное открытие окон, используя как раз рекурсивные методы.

        //Задание 5.2
        //Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
        System.out.println("---------------Task 5.2-------------");
        Thread thread = new Thread(() -> {
            try {
             showTime(2000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
        });
        thread.setDaemon(true);// только для токого чтоб вам вечно на него несмотреть)))
        thread.start();

        try {
            showTimeWhitOut(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Задание 5.3
        //Приведите пример изображающий стек вызова и стек вызова с рекурсией.
        // ну в исключениях есть стек вызовов
        // а с рекурсией факториал

        //Задание 5.4
        //Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
        //Оцените два алгоритма с помощью базового метода System.nanoTime().

        System.out.println("---------------Task 5.4-------------");
        start = System.nanoTime();
        System.out.println("Result: " + powWhitFor(2, 4));
        System.out.println("Runtime using loop: " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println("Result: " + powWhitRecursion(2,4));
        System.out.println("Runtime using recursion: " + (System.nanoTime() - start));

        //Задание 5.5
        //Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
        //Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime()
        // и сравните с обычным двоичным поиском.

        System.out.println("---------------Task 5.5-------------");
        Random random = new Random();
        int key = random.nextInt(10);
        int[] arr = new int[10];
        int[] arrForSortMerge;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }

        System.out.println("Random key " + key);
        System.out.println("Random array " + Arrays.toString(arr));
        arrForSortMerge = Arrays.copyOf(arr,arr.length);

        start = System.nanoTime();
        Arrays.sort(arr);
        long timeSort = System.nanoTime() - start;
        System.out.println("Sort array " + Arrays.toString(arr));

        start = System.nanoTime();
        System.out.println("Index: " + binarySearch(arr, key));
        long timeBinarySearch = System.nanoTime() - start;


        start = System.nanoTime();
        System.out.println("Index: " + recursionBinarySearch(arr,key,0,arr.length - 1));
        long timeRecursionBinarySearch = System.nanoTime() - start;
        System.out.println("Runtime binarySearch: " + timeBinarySearch);
        System.out.println("Runtime recursionBinarySearch: " + timeRecursionBinarySearch);
        if(timeBinarySearch > timeRecursionBinarySearch) System.out.println("timeRecursionBinarySearch fasted");
        else System.out.println("timeBinarySearch fasted");

        //Задание 5.6
        //На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
        //Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime()
        //  и сравните с сортировкой методом sort().

        System.out.println("---------------Task 5.6-------------");
        start = System.nanoTime();
        System.out.println("Sort merge array " + Arrays.toString(sortMerge(arrForSortMerge)));
        long timeSortMerge = System.nanoTime() - start;
        System.out.println("Runtime sort(): " + timeSort);
        System.out.println("Runtime sortMerge: " + timeSortMerge);
        if(timeSort > timeSortMerge) System.out.println("Sort Merge faster");
        else System.out.println("Sort faster");

    }

    public static double powWhitFor(int x,int n){
        double result = 1;

        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    public static double powWhitRecursion(int x, int n){
        if(n == 1){
            return x;
        } else {
            return x * powWhitRecursion(x, n - 1);
        }
    }

    public  static int binarySearch(int[] arr, int elementToSearch){
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex)/2;

            if(arr[middleIndex] == elementToSearch){
                return middleIndex;
            }
            else if(arr[middleIndex] < elementToSearch){
                firstIndex = middleIndex + 1;
            } else if(arr[middleIndex] > elementToSearch){
                lastIndex = middleIndex - 1;
            }
        }
        return arr.length;
    }

    public static int recursionBinarySearch(int[] array, int elementToSearch,  int low, int last){
        if(low > last)
            return array.length;
        int middle = (low + last)/2;
        if(array[middle] == elementToSearch){
            return middle;
        } else if(array[middle] < elementToSearch){
            return recursionBinarySearch(array,elementToSearch,low + 1,last);
        } else {
            return recursionBinarySearch(array,elementToSearch,low,last-1);
        }
    }

    static int[] sortMerge(int[] arr){
        if(arr.length < 2) return arr;
        int middle = arr.length/2;
        return merge(sortMerge(Arrays.copyOfRange(arr,0,middle)),
                sortMerge(Arrays.copyOfRange(arr,middle,arr.length)));
    }

    public static int[] merge(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if(aIndex == a.length){
                System.arraycopy(b,bIndex,result,++i,b.length - bIndex);
                break;
            }
            if(bIndex == b.length){
                System.arraycopy(a, aIndex,result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }

}
