public class SimpleQueue {
    private final int maxSize;
    private final Cat[] catsOnQueue;
    private int front;
    private int rear;
    private int items;

    public SimpleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.catsOnQueue = new Cat[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insert(Cat cat){
        if(rear == maxSize - 1){
            rear = -1;
        }
        catsOnQueue[++rear] = cat;
        items++;
    }

    public Cat remove(){
        Cat cat = catsOnQueue[front++];
        if(front == maxSize) front = 0;
        items--;
        return cat;
    }

    public Cat peek(){
        return catsOnQueue[front];
    }

    public boolean isEmpty(){
        return (items == 0);
    }

    public boolean isFull(){
        return (items == maxSize);
    }

    public int size(){
        return items;
    }
}
