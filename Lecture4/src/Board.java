import edu.princeton.cs.algs4.StdOut;
import java.lang.Math;

public final class Board {

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    private final int [][] tiles;
    private final int N;
    
    public Board(int[][] tiles) {
        this.N = tiles.length;
        this.tiles = tiles;
        
    }
                                           
    // string representation of this board
    public String toString() {
        StringBuilder outString =  new StringBuilder(tiles.length + "\n");
        for(int []row : tiles) {
            for(int elm : row) {
                outString.append( elm + " ");
            }
            outString.append("\n");
        }
        return outString.toString();
        
    }

    // board dimension n
    public int dimension() {
        return tiles.length;
    }

    // number of tiles out of place
    public int hamming() {
        int temp = 1;
        int N = tiles.length;
        int distance = 0;
        for (int i = 0; i < N; i++) {
            
            for (int j = 0; j < tiles.length; j++ ) {
                if ( temp > N*N -1) break;
                if ( (temp ++ != tiles[i][j]) ) {
                    distance ++;
                };
                
            }
            
        }
        return distance;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int dist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++ ) {
                int tile = tiles[i][j];
                if(tile == 0) continue;
                int goalX = (tile -1) / N;
                int goalY = (tile -1) - (N * goalX);
                System.out.println("X " + goalX + " " + "Y " + goalY);
                dist += Math.abs(goalY - j) + Math.abs(goalX-i);
                //System.out.println(uniq_dist);
            }
            
        }
        return dist;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards
//    public Iterable<Board> neighbors(){
//        return new Iterable<Board>();
//    }

    // a board that is obtained by exchanging any pair of tiles
//    public Board twin() {
//        
//    }

    // unit testing (not graded)
    public static void main(String[] args) {
        
        int [] [] item = {{8, 1, 3},{4,0,2},{7,6,5}};
        
        Board board = new Board(item);
        System.out.println(board.toString());
        System.out.println(board.hamming());
        System.out.println(board.manhattan());
    }

}