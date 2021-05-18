public class SimpleStack {
    private final int maxSize;
    private final Cat[] catsOnStack;
    private int top;

    public SimpleStack(int size) {
        this.maxSize = size;
        this.catsOnStack = new Cat[this.maxSize];
        this.top = -1;
    }

    public void push(Cat cat){
        this.catsOnStack[++this.top] = cat;
    }

    public Cat pop(){
        return this.catsOnStack[this.top--];
    }

    public Cat peek(){
        return this.catsOnStack[this.top];
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize - 1);
    }
}
