package task.task3;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class TwoSidedLinkedList<E>{
    private ToSidedNode<E> head;
    private ToSidedNode<E> last;
    private int size;


    public ToSidedNode<E> getHead() {
        return head;
    }

    public ToSidedNode<E> getLast() {
        return last;
    }

    public void add(E node){
        ToSidedNode<E> newNode = new ToSidedNode<>(node);
        this.last = newNode;

        if(head == null){
            this.head = newNode;
        } else {
            ToSidedNode<E> temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrevious(temp);
        }
        size++;
    }

    public void remove(E searchNode){
        ToSidedNode<E> temp = head;
        ToSidedNode<E> node = new ToSidedNode<>(searchNode);

        if(temp.getValue().equals(node.getValue())) {
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return;
        }

        while (temp.getNext() != null){
            if(temp.getNext().getValue().equals(node.getValue())){
                temp.setNext(temp.getNext().getNext());
                temp.getNext().setPrevious(temp);
                size--;
                return;
            }
            temp = temp.getNext();
        }
    }

    public void remove(int index) {
        if (size / 2 > index) {
            if (index == 0) {
                head = head.getNext();
                head.setPrevious(null);
                size--;
                return;
            }

            int currentIndex = 0;
            ToSidedNode<E> temp = head;

            while (temp != null) {
                if (currentIndex == index - 1) {
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().setPrevious(temp);
                    size--;
                    return;
                } else {
                    temp = temp.getNext();
                    currentIndex++;
                }
            }
        } else {
            if (index == size - 1) {
                last = last.getPrevious();
                last.setNext(null);
                size--;
                return;
            }

            int currentIndex = size - 1;
            ToSidedNode<E> temp = last;

            while (temp != null) {
                if (currentIndex == index + 1) {
                    temp.setPrevious(temp.getPrevious().getPrevious());
                    temp.getPrevious().setNext(temp);
                    size--;
                    return;
                } else {
                    temp = temp.getPrevious();
                    currentIndex--;
                }
            }
        }
    }

    public boolean get(E searchNode){
        ToSidedNode<E> temp = head;
        ToSidedNode<E> node = new ToSidedNode<>(searchNode);

        while (temp != null){
            if(temp.getValue().equals(node.getValue())){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public E get(int index){
        if(size/2 > index){
            ToSidedNode<E> temp = head;
            int currentIndex = 0;

            while (temp != null){
                if(currentIndex == index){
                    return temp.getValue();
                } else {
                    temp = temp.getNext();
                    currentIndex++;
                }
            }
        } else {
            ToSidedNode<E> temp = last;
            int currentIndex = size - 1;

            while (temp != null){
                if(currentIndex == index){
                    return temp.getValue();
                } else {
                    temp = temp.getPrevious();
                    currentIndex--;
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public void myToString(){
        ToSidedNode<E> temp = head;
        System.out.print("[ ");
        while (temp != null){
            System.out.print(temp.getValue() + "  ");
            temp = temp.getNext();
        }
        System.out.println("]");
    }

    public int getSize() {
        return size;
    }

    public int size(){
        return getSize();
    }


    public ListIterator<E> listIterator(){
        return new MyListIterator<>(this);
    }
}

class ToSidedNode<E>{
    private E toSidedNode;
    private ToSidedNode<E> next;
    private ToSidedNode<E> previous;

    public ToSidedNode(E toSidedNode) {
        this.toSidedNode = toSidedNode;
    }

    public E getValue() {
        return toSidedNode;
    }

    public ToSidedNode<E> getNext() {
        return next;
    }

    public void setNext(ToSidedNode<E> next) {
        this.next = next;
    }

    public ToSidedNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(ToSidedNode<E> previous) {
        this.previous = previous;
    }
}

class MyListIterator<E> implements ListIterator<E> {
    private ToSidedNode<E> next;
    private ToSidedNode<E> last;
    private ToSidedNode<E> lastReturned;
    private int nextIndex;
    private int count;
    TwoSidedLinkedList<E> list;

    MyListIterator (TwoSidedLinkedList<E> list){
        this.list = list;
        this.next = list.getHead();
        this.last = list.getLast();
    }

    @Override
    public boolean hasNext() {
        return nextIndex < list.getSize();
    }

    @Override
    public E next() {
        if (!hasNext())
            throw new NoSuchElementException();

        lastReturned = next;
        next = next.getNext();
        nextIndex++;
        return lastReturned.getValue();
    }

    @Override
    public boolean hasPrevious() {
        return nextIndex > 0;
    }

    @Override
    public E previous() {
        if (!hasPrevious())
            throw new NoSuchElementException();
        lastReturned = last;
        last = last.getPrevious();
        nextIndex--;
        return lastReturned.getValue();
    }

    @Override
    public int nextIndex() {
        return nextIndex;
    }

    @Override
    public int previousIndex() {
        return nextIndex - 1;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(E e) {

    }

    @Override
    public void add(E e) {

    }
}
