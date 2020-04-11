import java.util.Comparator;
import java.util.LinkedList;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public final class Solver {
 // find a solution to the initial board (using the A* algorithm)
    private int minmove;
    private boolean solveable = true;
    private Board unsolvableBoard;
    private MinPQ<Node> minpq = new MinPQ<Node>(new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            // TODO Auto-generated method stub
            if (o1.priority < o2.priority) return -1;
            if (o1.priority > o2.priority) return +1;
            return 0;
            
        }
        
    });
    
    public Solver(Board initial) {
        if(initial == null) throw new  NullPointerException();
        undsolveable(initial.dimension());
        Node init = new Node(initial, 0, null);
        minpq.insert(init);
        while(!minpq.isEmpty()) { 
            Node temp = minpq.min();
            if (temp.board.equals(unsolvableBoard)) {
                solveable = false;
            }
            if (temp.board.isGoal() || !solveable ) break;
            Node parent = minpq.delMin();
            Iterable<Board> neighbours = parent.board.neighbors();
            for(Board b : neighbours) {
                Node node = new Node(b, 1, parent);
                minpq.insert(node);
            }
            minmove ++;
        }
        
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        
        return solveable;
    }
    private void undsolveable(int N) {
        int [][] tiles = new int [N][N];
        int temp = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++ ) {
                tiles[i][j] = temp ++;              
            }
            
        }
        tiles[N-1][N-1] = 0;
        int last = tiles[N-1][N-2];
        tiles[N-1][N-2] = tiles[N-1][N-3];
        tiles[N-1][N-3] = last;
        unsolvableBoard = new Board(tiles); 
    }
    
    // min number of moves to solve initial board
    public int moves() {
        return minmove;
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution(){
        Node goal = minpq.delMin();
        LinkedList<Board> sequence = new LinkedList<Board>();
        sequence.add(goal.board);
        while(goal.previous != null) {
            goal = goal.previous; 
            sequence.add(goal.board);
        }
        return sequence;
        
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
    
    private class Node{
        private Board board;
        private int move;
        private Node previous;
        private int priority;
        private Node(Board board, int move, Node previous) {
            this.board = board;
            this.move = move;
            this.previous = previous;
            this.priority = move + board.manhattan();
        }
        
    }
   
}
