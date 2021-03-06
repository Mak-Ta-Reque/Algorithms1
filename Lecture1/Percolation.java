import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private  final boolean [][] grid;
	private final int  dim;
	private final WeightedQuickUnionUF unionFind;
	private final int bottom;
	private final int top;
	private int nOpenSite = 0;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	if (n <= 0) throw new IllegalArgumentException("n<=0");
    	this.dim = n;
    	grid = new boolean [n][n];
    	unionFind = new WeightedQuickUnionUF(n * n + 2);
    	top = 0;
    	bottom = n * n + 1;
    	
    	
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        
    	if (row <= 0 || col <= 0) throw new IllegalArgumentException(" col or row is less than 1");
    	if (row > dim || col > dim) throw new IllegalArgumentException(" col or row is more than n");
    	if (!grid[row - 1][col - 1]) {
    	    int ufLoc = twoDToOneD(row, col);
    	    grid[row - 1][col - 1] = true;
    	    nOpenSite ++;
    	            
    	    if (row == 1) {
    	        unionFind.union(top, twoDToOneD(row, col));
    	    }
    	    if (row == dim) {
    	        unionFind.union(bottom, twoDToOneD(row, col));
    	    }
    	    if( col > 1 && isOpen(row , col - 1)) {
    	        unionFind.union(twoDToOneD(row, col - 1), ufLoc );
    	    }
    	    if( col < dim && isOpen(row , col + 1)) {  
    	        unionFind.union(twoDToOneD(row, col + 1), ufLoc );
    	    }
    	    
    	    if( row > 1 && isOpen(row - 1, col)) {  
                unionFind.union(twoDToOneD(row  - 1, col), ufLoc );
            }
    	    if( row < dim && isOpen(row + 1, col)) {  
                unionFind.union(twoDToOneD(row  + 1, col), ufLoc );
            }
    	}
  
    }
    
    // 2d to 1d index converter
    
    private int twoDToOneD(int i, int j) {
        return dim*(i - 1) + j;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	if (row <= 0 || col <= 0 ) throw new IllegalArgumentException(" col or row is less than 1");
    	if (row > dim || col > dim ) throw new IllegalArgumentException(" col or row is less than 1");
    	return grid[row - 1][col - 1];
    }
    
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	if (row <= 0 || col <= 0 ) throw new IllegalArgumentException(" col or row is less than 1");
    	if (row > dim || col > dim ) throw new IllegalArgumentException(" col or row is more than n");
    	return unionFind.find(top) == unionFind.find(twoDToOneD(row, col));

    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return nOpenSite;
    }

    // does the system percolate?
    public boolean percolates() {
    	return unionFind.find(bottom) == unionFind.find(top);
    }
    
    // test client (optional)
    public static void main(String[] args) {
    	//Ignore 
    }
}