package task.task3;

public class MyLinkedList <T>{
    private Node<T> head;

    public void add(T node){

        if(head == null){
            this.head = new Node<>(node);
        }else {
            Node<T> temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node<>(node));
        }
    }

    public void remove(T searchNode){
        Node<T> temp = head;
        Node<T> node = new Node<>(searchNode);

        if(temp.getValue().equals(node.getValue())) {
            head = head.getNext();
            return;
        }

        while (temp.getNext() != null){
            if(temp.getNext().getValue().equals(node.getValue())){
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }
    }

    public void remove(int index){
        if(index == 0){
            head = head.getNext();
            return;
        }

        int currentIndex = 0;
        Node<T> temp = head;

        while (temp != null){
            if(currentIndex == index - 1){
                temp.setNext(temp.getNext().getNext());
                return;
            }else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public boolean get(T searchNode){
        Node<T> temp = head;
        Node<T> node = new Node<>(searchNode);

        while (temp != null){
            if(temp.getValue().equals(node.getValue())){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public T get(int index){
        Node<T> temp = head;
        int currentIndex = 0;

        while (temp != null){
            if(currentIndex == index){
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void myToString(){
        Node<T> temp = head;
        System.out.print("[ ");
        while (temp != null){
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
        System.out.println("]");
    }

    public int size(){
        int index = 0;
        Node<T> temp = head;

        while (temp != null){
            temp = temp.getNext();
            index++;
        }
        return index;
    }
}
class Node<T>{
    private T node;
    private Node<T> next;

    public Node(T node) {
        this.node = node;
    }

    public T getValue() {
        return node;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}