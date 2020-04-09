import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public final class Solver {
 // find a solution to the initial board (using the A* algorithm)
    Board previous;
    Board searchNode;
    int toReachGoal;
    public Solver(Board initial) {
        previous  = null;
        searchNode = initial;
        MinPQ<Board> pq = new MinPQ<Board>(new Comparator<Board>() {

            @Override
            public int compare(Board o1, Board o2) {
                // TODO Auto-generated method stub
                if (o1.manhattan() < o2.manhattan())return -1;
                if (o1.manhattan() > o2.manhattan())return +1;
                return 0;
            }
            
        });
        pq.insert(previous);
        pq.insert(previous);
        while (!= null) {
            
        }
        
        
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        
        
    }

    // min number of moves to solve initial board
    public int moves() {
        
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution(){
        
    }

    // test client (see below) 
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
