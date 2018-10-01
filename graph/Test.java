public class Test {
    public static void main(String[] args) {
        MyGraph adjacency = new MyAdjacency();
        for (int i = 0; i < 7; i++) {
            adjacency.addVertex();
        }
        adjacency.addEdge(0, 1);
        adjacency.printGraph();
    }
}