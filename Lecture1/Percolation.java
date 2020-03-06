import java.util.Arrays;

public class Percolation {
	private int [][] grid ;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	
    	if (n<=0) throw new IllegalArgumentException("n<=0");
    	grid = new int [n][n];
    	System.out.println();
    	int temp = 0;
    	for(int i = 0; i < n; i++) {
    		
    		for(int j = 0; j < n; j++ ) {
    			grid[i][j] = i + temp;
    			temp ++;
    			System.out.println(grid[i][j]);
    		}
   
    	}
    	System.out.println(Arrays.toString(grid));
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
   
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	return false ;
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	return false ;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return 0;
    }

    // does the system percolate?
    public boolean percolates() {
    	return false ;
    }

    // test client (optional)
    public static void main(String[] args) {
    	
    }
}