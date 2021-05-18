import java.util.*;

public class Test {
    public static void main(String[] args) {

        //Задание 4.1
        //На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().
        long startTimer;
        SimpleStack stack = new SimpleStack(5);
        TwoSidedLinkedList<Cat> catList = new TwoSidedLinkedList<>();
        catList.add(new Cat(2,"Golf"));
        catList.add(new Cat(5, "Tim"));
        catList.add(new Cat(7, "Fred"));
        catList.add(new Cat(4, "Scot"));
        catList.add(new Cat(15, "Wins"));

        startTimer = System.nanoTime();
        ListIterator<Cat> iteratorForStack = catList.listIterator();
        while (iteratorForStack.hasNext()){
            stack.push(iteratorForStack.next());
        }
        System.out.println("Time SimpleStack method push: " + (System.nanoTime() - startTimer));

        startTimer = System.nanoTime();
        while (!stack.isEmpty())
            System.out.println(stack.pop());

        System.out.println("Time SimpleStack method pop: " + (System.nanoTime() - startTimer));

        //Задание 4.2
        //На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
        //Реализуйте вспомогательные методы.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().
        ListIterator<Cat> iteratorForQueue = catList.listIterator();
        SimpleQueue queue = new SimpleQueue(5);
        startTimer = System.nanoTime();
        while (iteratorForQueue.hasNext()){
            queue.insert(iteratorForQueue.next());
        }

        System.out.println("Time SimpleQueue method insert: " + (System.nanoTime() - startTimer));
        startTimer = System.nanoTime();

        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
        System.out.println("Time SimpleQueue method remove: " + (System.nanoTime() - startTimer));

        //Задание 4.3
        //На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().
        ListIterator<Cat> iteratorForDeque = catList.listIterator();
        Deque<Cat> deque = new LinkedList<>();

        startTimer = System.nanoTime();
        while (iteratorForDeque.hasNext()){
            deque.add(iteratorForDeque.next());
        }
        System.out.println("Time SimpleDeque method add: " + (System.nanoTime() - startTimer));
        System.out.println("Size after add" + deque.size());
        startTimer = System.nanoTime();
        while (!deque.isEmpty()){
            System.out.println(deque.poll());
        }

        System.out.println("Time SimpleDeque method poll: " + (System.nanoTime() - startTimer));

        //Задание 4.4
        //Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime()

        Random rand = new Random();
        LinkedList<Integer> listAfter = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(rand.nextInt(10));
        }
        System.out.println(list);

        startTimer = System.nanoTime();
        PriorityQueue<Integer> prior = new PriorityQueue<>(list);
        System.out.println("Time PriorityQueue constructor: " + (System.nanoTime() - startTimer));

        startTimer = System.nanoTime();
        while (!prior.isEmpty()){
            listAfter.add(prior.poll());
        }
        System.out.println("Time PriorityQueue method poll: " + (System.nanoTime() - startTimer));
        System.out.println(listAfter);

        //Задание 4.5
        //На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().

        //Stack
        StackList<Cat> st = new StackList<>();
        ListIterator<Cat> iteratorForStackList = catList.listIterator();
        startTimer = System.nanoTime();
        while (iteratorForStackList.hasNext()){
            st.push(iteratorForStackList.next());
        }
        System.out.println("Time StackList method push: " + (System.nanoTime() - startTimer));

        startTimer = System.nanoTime();
        while (!st.isEmpty()){
            System.out.println(st.pop() + " - delete");
        }
        System.out.println("Time StackList method pop: " + (System.nanoTime() - startTimer));

        //Queue
        QueueList<Cat> que = new QueueList<>();
        ListIterator<Cat> iteratorForQueueList = catList.listIterator();
        startTimer = System.nanoTime();
        while (iteratorForQueueList.hasNext()){
            que.insert(iteratorForQueueList.next());
        }
        System.out.println("Time QueueList method insert: " + (System.nanoTime() - startTimer));

        startTimer = System.nanoTime();
        while (!que.isEmpty()){
            System.out.println(que.delete() + " - delete");
        }
        System.out.println("Time QueueList method delete: " + (System.nanoTime() - startTimer));
    }
}
