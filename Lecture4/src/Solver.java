import java.util.Comparator;
import java.util.LinkedList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public final class Solver {
 // find a solution to the initial board (using the A* algorithm
    //private Node lastNode;
    //private boolean solveable = true;
    //private int minMoves = 0;
    private Node goal;
    private MinPQ<Node> minpq = new MinPQ<Node>(new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            // TODO Auto-generated method stub
            if (o1.priority < o2.priority) return -1;
            if (o1.priority > o2.priority) return +1;
            return 0;
            
        }
        
    });
    
    private MinPQ<Node> minpqTwin = new MinPQ<Node>(new Comparator<Node>() {

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
        int move = 0;
        
        //int twinMove = 0;
        //Node twinNode = new Node(initial.twin(), move, null);
        Node current = new Node(initial, move, null);
        minpq.insert(current);
        
        //minpqTwin.insert(twinNode);
        
        //boolean solved = false;
        //boolean twinSolved = false; 
        //Node current = null;
        
        while(!minpq.isEmpty()) {
            current = minpq.delMin();
            if(current.board.isGoal()) {
                goal = current;
                break;
            }
            //Node parent = current.previous;
            //solved = current.board.isGoal();
            
            //Node twinCurrent = minpqTwin.delMin();
            //Node twinParent = twinCurrent.previous;
            //twinSolved = twinCurrent.board.isGoal();
       
            Iterable<Board> neighbours = current.board.neighbors();
            //Iterable<Board> neighboursTwins = twinCurrent.board.neighbors();
            
            for(Board b : neighbours) {
                if(current.previous == null) {
                    Node node = new Node(b, current.move + 1, current);
                    minpq.insert(node);
                }
                else if (!(b.equals(current.previous.board))) {
                    Node node = new Node(b, current.move + 1, current);
                    minpq.insert(node);
                }
                
            }
            
           // for(Board b : neighboursTwins) {
             //   if ( twinParent != null && b.equals(twinParent.board)) {
               //     continue;
                //}
                //Node node = new Node(b, twinCurrent.move + 1, twinCurrent);
               // minpqTwin.insert(node);
            //}
            
            //move = current.move+ 1;
            //twinMove = twinCurrent.move + 1;
            //lastNode = current;
        }
        //solveable = !twinSolved;
        //minMoves = move - 1;
        
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return true;
    }
    
    // min number of moves to solve initial board
    public int moves() {
        //if (!isSolvable()) return -1;
        return goal.move;
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution(){
        LinkedList<Board> sequence = new LinkedList<Board>();
        sequence.add(goal.board);
        while(goal.previous != null) {
            goal = goal.previous; 
            sequence.addFirst(goal.board);
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
        private int distance;
        private Node(Board board, int move, Node previous) {
            this.board = board;
            this.move = move;
            this.previous = previous;
            this.distance =  board.manhattan();
            this.priority = move + this.distance;
        }
        
    }
   
}
