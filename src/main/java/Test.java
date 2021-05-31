public class Test {
    public static void main(String[] args)
    {
        //Задание 7.1
        //Приведите пример графа.
        // Электрические схемы, лабиринт, любая логистика
        //Реализуйте базовые методы графа.
        //Задание 7.3
        long start;
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');

        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 4); //DE

        graph.displayVertex(4);
        graph.displayVertex(2);

        //Задание 7.3
        //В программный код из задания 7.2 добавьте реализацию метода обхода в глубину.
        //Выполните оценку времени с помощью System.nanoTime().
        start = System.nanoTime();
        graph.dfs(0);
        System.out.println("Time method dfs: " + (System.nanoTime() - start));

        graph.clear();

        //Задание 7.4
        //В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
        //Выполните оценку времени с помощью System.nanoTime().
        start = System.nanoTime();
        graph.bfs(0);
        System.out.println("Time method bfs: " + (System.nanoTime() - start));
    }
}
