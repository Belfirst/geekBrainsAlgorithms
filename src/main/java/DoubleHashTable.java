import java.util.Arrays;

public class DoubleHashTable {
    private Cat[] hashArr;
    private int size;
    private final Cat EMPTY;
    private int full;
    final int CONSTANT;

    public DoubleHashTable(int size){
        this.size = size;
        EMPTY = new Cat(-1);
        hashArr = new Cat[size];
        CONSTANT = 10;
    }

    private void increaseTable(){
        Cat[] oldHashArr = Arrays.copyOf(hashArr,size);
        this.size = getPrime(size);
        System.out.println(size);
        hashArr = new Cat[size];
        for (Cat cat : oldHashArr) {
            if (cat != null) {
                insert(cat);
            }
        }

    }

    private int getPrime(int min)
    {
        for (int i = min + 1; true; i++)
        {
            if (isPrime(i))
            {
                return i;
            }
        }
    }

    private boolean isPrime(int n)
    {
        for (int j = 2; (j * j <= n); j++)
        {
            if (n % j == 0)
            {
                return false;
            }
        }
        return true;
    }

    public void display()
    {
        System.out.print("[ ");
        for (int i = 0; i < size; i++)
        {
            if (hashArr[i] != null)
            {
                System.out.print(hashArr[i].getAge() + " ");
            }
            else
            {
                System.out.print("*** ");
            }
        }
        System.out.println("]");
    }

    public int hashFunc(int key)
    {
        return key % size;
    }

    public int hashFuncDouble(int key)
    {
        return CONSTANT - key % CONSTANT;
    }

    public void insert(Cat cat)
    {
        if (full == size) {
            increaseTable();
        }
        int key = cat.getAge();
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getAge()!= -1)
        {
            hashVal += stepSize;
            hashVal %= size;
        }
        hashArr[hashVal] = cat;
        full++;
    }

    public Cat delete(int key)
    {
        int count = 0;
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null)
        {
            if (count == size) {
                System.out.println("number not found");
                return null;
            }
            if (hashArr[hashVal].getAge() == key)
            {
                Cat temp = hashArr[hashVal];
                hashArr[hashVal] = EMPTY;
                full--;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= size;
            count++;
        }
        return null;
    }

    public Cat find(int key){

        int count = 0;
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null){
            if (count == size) {
                return null;
            }
            if(hashArr[hashVal].getAge() == key){
                return hashArr[hashVal];
            }
            hashVal += stepSize;
            hashVal %= size;
            count++;
        }
        return null;
    }
}
