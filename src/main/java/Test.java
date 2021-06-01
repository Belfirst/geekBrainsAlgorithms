import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //Задание 8.1
        //Приведите пример использование хеш-таблиц.
        //hashMap
        //Задание 8.2
        //Приведите примеры ключей и коллизий.
        //ключ - int, String, char...
        //колизия - два одинаковых числа могут дать одинаковый хеш
        //Задание 8.3
        //Приведите примеры популярных и эффективных хеш-функций.
        //хеширование основанное на деление, на умножение,хеширование строк переменной длинны, универсальное хеширование,идеальное хеширование
        //Задание 8.4
        //На основе данных массива из задания 2.3 реализуйте хеш-таблицу с помощью открытой адресации, а конкретнее метода линейного пробирования
        Cat cat;
        int size = 50;
        int key;
        Random random = new Random();
        HashTable hashTable = new HashTable(size);

        int[] randArr = new int[15];
        for (int i = 0; i < 15; i++) {
            randArr[i] = random.nextInt(99);
        }

        for (int i = 0; i < 15; i++) {
            cat = new Cat(randArr[i]);
            hashTable.insert(cat);
        }

        key = random.nextInt(99);
        cat = new Cat(key);
        hashTable.insert(cat);


        System.out.print("insert: ");
        hashTable.display();
        hashTable.delete(key);
        System.out.print("delete: ");
        hashTable.display();
        System.out.print("find: ");
        System.out.println(hashTable.find(60));

        //Задание 8.5
        //Перестройте программный код задания 8.4 из алгоритма линейного пробирования в алгоритм двойного хеширования.
        //Сравните отличительные черты двух алгоритмов.

        DoubleHashTable dht = new DoubleHashTable(size);

        for (int i = 0; i < 15; i++) {
            cat = new Cat(randArr[i]);
            dht.insert(cat);
        }

        key = random.nextInt(99);
        cat = new Cat(key);
        dht.insert(cat);

        System.out.print("insert: ");
        dht.display();
        dht.delete(key);
        System.out.print("delete: ");
        dht.display();
    }
}
