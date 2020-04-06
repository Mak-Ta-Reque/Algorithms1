import java.lang.Math;
import java.util.LinkedList;

public final class Board {

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    private final int [][] tiles;
    private final int N;
    private final int zeroX;
    private final int zeroY;
 
    public  Board(int[][] tiles) {
        this.N = tiles.length;
        int [][] tilesT = new int [ this.N][ this.N]  ;
        int X = N-1 ; int Y = N -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tilesT[i][j] = tiles[i][j] ;
                if(tiles[i][j] == 0 ) {
                    X = i;
                    Y = j;
                    
                    
                }
            }
            
            
        }
        zeroX = X;
        zeroY = Y;
        this.tiles = tilesT;
        
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
    private void addToList(int i, int j, LinkedList<Board> neighbor) {
        if(i >= 0 && i < N && j >=0 && j < N) {
            //System.out.println("x " + i + " " + "y " + j);
            
            int [][] tilesN = new int [N][N];
            for(int k = 0; k < N; k++ ) {
                for (int l = 0; l < N; l++) {
                    tilesN[k][l] = tiles[k][l] ;
                }
            }
            
            int temp = tilesN[i][j];
            //System.out.println("temp " + temp);
            tilesN[i][j] = 0;
            tilesN[zeroX][zeroY] = temp;
            
            Board board = new Board(tilesN);
            //System.out.println(board.toString());
            neighbor.add(board);
        }
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
        final LinkedList<Board> neighbor = new LinkedList<Board>();
        //return new Neighbours();
        int n1X = zeroX +1;
        int n1Y = zeroY;
        //System.out.println("x " + n1X + " " + "y " + n1Y);
        addToList(n1X,n1Y,neighbor);
        
        n1X = zeroX - 1;
        n1Y = zeroY;
        addToList(n1X,n1Y,neighbor);
        
        n1X = zeroX;
        n1Y = zeroY +1;
        addToList(n1X,n1Y,neighbor);
        
      
        n1X = zeroX;
        n1Y = zeroY -1;
        addToList(n1X,n1Y,neighbor);
        return neighbor;
        
      
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        Board bb = new Board(tiles);
        
        if (bb.tiles[0][0] == 0) {
            exch(bb.tiles, 1, 0, 1, 1);
        } else if (bb.tiles[0][1] == 0) {
            exch(bb.tiles, 1, 0, 1, 1);
        } else {
            exch(bb.tiles, 0, 0, 0, 1);
        }
        return bb;
    }
    private void exch(int[][] matrix, int i, int j, int p, int q) {
        int tmp = matrix[i][j];  
        matrix[i][j] = matrix[p][q]; 
        matrix[p][q] = tmp;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        
        int [] [] item = {{0, 5, 1},{4,8,2},{7,6,3}};
        
        Board board = new Board(item);
        System.out.println(board.toString());
        
        System.out.println(board.twin().toString());
        //System.out.println(board.hamming());
        //System.out.println(board.manhattan());
        for( Board it : board.neighbors()) {
            
            System.out.println(it.toString());
            
        }
        
    }

}