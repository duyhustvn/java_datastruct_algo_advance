import java.util.List;
import java.util.ArrayList;;

public class MyAdjacency extends MyGraph {
    // implement
    private int[][] adjMatrix;
    
    public MyAdjacency() {
        super();
        adjMatrix = new int[0][0];
    }

    public void implementAddEdge(int v, int w) {
        adjMatrix[v][w] = 1;
    }

    public void implementAddVertex() {
        int numVertices = this.getNumVertices();

        if (numVertices >= adjMatrix.length) {
            int[][] newAdjMatrix;
            if (numVertices == 0) {
                newAdjMatrix = new int[1][1];
            } else {
                newAdjMatrix = new int[2 * numVertices][2 * numVertices];
            }
            
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }

        for (int i = 0; i < adjMatrix[numVertices].length; i++) {
            adjMatrix[numVertices][i] = 0;
        }
    }

    public List<Integer> getNeighbors(int v) {
        return new ArrayList<>(1);
    };

    public void printGraph() {
        int numVertices = this.getNumVertices();
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}