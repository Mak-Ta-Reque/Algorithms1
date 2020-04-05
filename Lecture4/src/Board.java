import edu.princeton.cs.algs4.StdOut;
import java.lang.Math;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

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
                //System.out.println("X " + goalX + " " + "Y " + goalY);
                dist += Math.abs(goalY - j) + Math.abs(goalX-i);             
            }
            
        }
        return dist;
    }

    // is this board the goal board?
    public boolean isGoal() {
        if (hamming() == 0) return true;
        else return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (this == y) return true;
        if (this.getClass() != y.getClass())
            return false;
        Board that = (Board)y;
        if (N != that.N) return false;
        if (this.hamming() != that.hamming()) return false;
        if(this.manhattan() != that.manhattan()) return false;
        for (int i = 0; i < N; i++ ) {
            for (int j = 0; j< N; j++) {
                if(this.tiles[i][j] != that.tiles[i][j]) return false;
            }
        }
        
        
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
        return new Neighbours();
    }

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
        for( Board it : board.neighbors()) {
            System.out.println(it.toString());
        }
        
    }
    
    private class Neighbours implements Iterable<Board>{

        @Override
        public Iterator<Board> iterator() {
            // TODO Auto-generated method stub
           return new NeighbourIterator();
        }
        
    }
    private final class NeighbourIterator implements Iterator<Board>{
        
        
        private final LinkedList<Board> neighbor = new LinkedList<Board>();
        private int zeroX;
        private int zeroY;
        private NeighbourIterator() {
           
            for (int i = 0; i < N; i++) {
                boolean flag = false;
                for (int j = 0; j < N; j++) {
                    if(tiles[i][j] == 0 ) {
                        zeroX = i;
                        zeroY = j;
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    break;
                }
            }
//            for (int i = 0; i <= 1; i++) {
//                for (int j  = 0; j <= 1; j++) {
//                    int n1X = zeroX + j;
//                    int n1Y = zeroY;
//                }
            
            
            System.out.println("x " + zeroX + " " + "y " + zeroY);
            
            int n1X = zeroX +1;
            int n1Y = zeroY;
            System.out.println("x " + n1X + " " + "y " + n1Y);
            addToList(n1X,n1Y);
            
            n1X = zeroX - 1;
            n1Y = zeroY;
            addToList(n1X,n1Y);
            
            n1X = zeroX;
            n1Y = zeroY +1;
            addToList(n1X,n1Y);
            
          
            n1X = zeroX;
            n1Y = zeroY -1;
            addToList(n1X,n1Y);
        }  
            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                
                return neighbor.poll() !=  null;
            }
            @Override
            public Board next() {
                // TODO Auto-generated method stub
                return neighbor.poll() ;
            }
            
            
        
        private void addToList(int i, int j) {
            if(i >= 0 && i < N && j >=0 && j < N) {
                //System.out.println("x " + i + " " + "y " + j);
                int [][] tilesN = Arrays.copyOf(tiles, tiles.length);
                int temp = tilesN[i][j];
                System.out.println("temp " + temp);
                tilesN[i][j] = 0;
                tilesN[zeroX][zeroY] = temp;
                for(int k = 0; k < tiles.length; k++ ) {
                    for (int l = 0; l < tiles.length; l++) {
                        System.out.print(tiles[k][l]);
                    }
                    System.out.println();
                }
                Board board = new Board(tilesN);
                System.out.println(board.toString());
                neighbor.add(board);
            }
        }
        
    }

}