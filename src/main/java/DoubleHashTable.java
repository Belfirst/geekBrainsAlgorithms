import java.util.Arrays;

public class DoubleHashTable {
    private Cat[] hashArr;
    private int size;
    private final Cat EMPTY;
    private int full;
    private int step;
    private final double REHASH_SIZE = 0.75;

    public DoubleHashTable(int size){
        this.size = size;
        EMPTY = new Cat(-1);
        hashArr = new Cat[size];
        this.step = (int)Math.ceil(0.2 * size);
    }

    private void increaseTable(){
        Cat[] oldHashArr = Arrays.copyOf(hashArr,size);
        this.size = size * 2;
        this.step = (int)Math.ceil(0.2 * size);
        hashArr = new Cat[size];
        full = 0;
        for (Cat cat : oldHashArr) {
            if (cat != null) {
                insert(cat);
            }
        }
    }

    private void reHash(){
        Cat[] oldHashArr = Arrays.copyOf(hashArr,size);

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
        return step - key % step;
    }

    public void insert(Cat cat)
    {
        if (full + 1 > REHASH_SIZE * size) {
            increaseTable();
        }
        int key = cat.getAge();
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        int i = 0;
        while (hashArr[hashVal] != null && hashArr[hashVal].getAge()!= -1)
        {
            if(i > size) increaseTable();
            hashVal += stepSize;
            hashVal %= size;
            i++;
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
