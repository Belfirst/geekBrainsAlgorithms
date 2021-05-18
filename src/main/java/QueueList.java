public class QueueList<T>{
    private final MyLinkedList<T> queue;
    public QueueList(){
        queue = new MyLinkedList<>();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(T cat){
        queue.add(cat);
    }

    public T delete(){
        return queue.remove();
    }
}
