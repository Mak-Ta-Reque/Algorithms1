import edu.princeton.cs.algs4.StdOut;

public final class Board {

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    private final int [][] tiles;
    
    public Board(int[][] tiles) {
        this.tiles = tiles;
    }
                                           
    // string representation of this board
    public String toString() {
        String outString =  Integer.toString(tiles.length) + "\n";
        StdOut.println(tiles.length);
        for(int []row : tiles) {
            for(int elm : row) {
                outString += Integer.toString(elm) + " ";
            }
            outString += "\n";
        }
        return outString;
        
    }

    // board dimension n
    public int dimension() {
        
    }

    // number of tiles out of place
    public int hamming() {
        
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        
    }

    // is this board the goal board?
    public boolean isGoal() {
        
    }

    // does this board equal y?
    public boolean equals(Object y) {
        
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
        
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        
    }

}