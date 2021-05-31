public class Graph {
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;

    public Graph()
    {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++)
        {
            for (int j = 0; j < MAX_VERTS; j++)
            {
                adjMat[i][j] = 0;
            }
        }
    }

    private int getAdjUnvesitedVertex(int ver)
    {
        for (int i = 0; i < size; i++)
        {
            if (adjMat[ver][i] == 1 && !vertexList[i].wasVisited)
            {
                return i;
            }
        }

        return -1;
    }

    public void addVertex(char label)
    {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex)
    {
        System.out.println(vertexList[vertex].label);
    }

    public void dfs(int f)
    {
        vertexList[f].wasVisited = true;

        for (int i = 0; i < size; i++)
        {
            int v = getAdjUnvesitedVertex(f);
            if (!vertexList[i].wasVisited && v != -1 && i == v)
            {
                fullDisplayVertex(f, v);
                dfs(i);
            }
        }
    }

    public void clear(){
        for (int i = 0; i < size; i++)
        {
            vertexList[i].wasVisited = false;
        }
    }

    public void bfs(int v)
    {
        int[] queue = new int[size];
        int qH = 0;
        int qT = 0;

        vertexList[v].wasVisited = true;
        queue[qT++] = v;
        displayVertex(v);

        int v2;
        while (qH < qT)
        {
            v = queue[qH++];

            for (int i = 0; i < size; i++)
            {
                v2 = getAdjUnvesitedVertex(v);
                if (v2 != -1 && !vertexList[v2].wasVisited)
                {
                    vertexList[v2].wasVisited = true;
                    displayVertex(v2);
                    queue[qT++] = v2;
                }
            }
        }
        clear();
    }

    public void fullDisplayVertex(int vertex1, int vertex2)
    {
        System.out.println("Вершины " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
    }
}
