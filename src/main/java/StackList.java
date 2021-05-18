public class StackList<T>{
    private final MyLinkedList<T> list;

    public StackList() {
        list = new MyLinkedList<>();
    }

    public void push(T cat){
        list.insert(cat);
    }

    public T pop() {
        return list.delete();
    }

    public boolean isEmpty(){
        return list.isEmptyForStack();
    }
}
