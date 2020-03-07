import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int [][] grid ;
	private int dim;
	private boolean check_id [];
	private WeightedQuickUnionUF UF;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	dim = n;
    	if (n<=0) throw new IllegalArgumentException("n<=0");
    	grid = new int [n][n];
    	check_id = new boolean [n*n];
    	int temp = 0;
    	for(int i = 0; i < n; i++) {
    		
    		for(int j = 0; j < n; j++ ) {
    			grid[i][j] = i + j + temp;

    		}
    		temp += n-1;
   
    	}
    	UF = new WeightedQuickUnionUF(n*n+1);
    	
    	for (int i = 1; i < n; i++) {
    		UF.union(0, i);
    		UF.union(n*n , n*n - i);
    	}
    	
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	if (row <= 0 || col <= 0 ) throw new IllegalArgumentException(" col or row is less than 1");
    	if (row > dim || col > dim ) throw new IllegalArgumentException(" col or row is more than n");
    	row = row - 1;
    	col = col - 1;
    	int id = grid [row][col];
    	if (!check_id[id]) {
    		// Four cases for corner 
    		
    		if(col ==0 && row == 0) {
    			connect(id, row, col+1);
    			connect(id, row + 1, col);
    			return;
    		}
    		if(col ==dim-1 && row == dim-1) {
    			connect(id, row, col-1);
    			connect(id, row - 1, col);
    			return;
    		}
    		if(col ==dim-1 && row == 0) {
    			connect(id, row + 1, col);
    			connect(id, row, col -1);
    			return;
    		}
    		if(col == 0 && row == dim - 1) {
    			connect(id, row - 1, col);
    			connect(id, row, col + 1);
    			return;
    		}
    		if (col==0)  {
    			int id_r  = grid [row][col+1];
            	if (check_id[id_r]) {
            		UF.union(id, id_r);
        		}
            	int id_t  = grid [row -1][col];
            	if (check_id[id_t]) {
            		UF.union(id, id_t);
        		}
            	int id_b = grid [row + 1][col];
            	if (check_id[id_b]) {
            		UF.union(id, id_b);
        		}
            	check_id [id] = true;
            	return;
    		}
    		
    		if (col == dim-1) {
        		// no right object
    			int id_l  = grid [row][col-1];
            	if (check_id[id_l]) {
            		UF.union(id, id_l);
        		}
            	
            	int id_t  = grid [row -1][col];
            	if (check_id[id_t]) {
            		UF.union(id, id_t);
        		}
            	int id_b = grid [row + 1][col];
            	if (check_id[id_b]) {
            		UF.union(id, id_b);
        		}
            	check_id [id] = true;
            	return;
        	}
    		
    		if (row == 0) {
    			int id_l  = grid [row][col-1];
            	if (check_id[id_l]) {
            		UF.union(id, id_l);
        		}
            	int id_r  = grid [row][col+1];
            	if (check_id[id_r]) {
            		UF.union(id, id_l);
        		}
            	int id_b = grid [row + 1][col];
            	if (check_id[id_b]) {
            		UF.union(id, id_b);
        		}
            	check_id [id] = true;
            	return;
    			
    		}
    		
    		if (row == dim - 1) {
    			int id_l  = grid [row][col-1];
            	if (check_id[id_l]) {
            		UF.union(id, id_l);
        		}
            	int id_r  = grid [row][col+1];
            	if (check_id[id_r]) {
            		UF.union(id, id_l);
        		}
            	int id_t  = grid [row -1][col];
            	if (check_id[id_t]) {
            		UF.union(id, id_t);
        		}
            	check_id [id] = true;
            	return;
    
    		}
    		
    		
    		int id_l  = grid [row][col-1] ;
        	if (check_id[id_l]) {
        		UF.union(id, id_l);
    		}
        	int id_r  = grid [row][col+1] ;
        	if (check_id[id_r]) {
        		UF.union(id, id_l);
    		}
        	int id_t  = grid [row -1][col] ;
        	if (check_id[id_t]) {
        		UF.union(id, id_t);
    		}
        	int id_b = grid [row + 1][col] ;
        	if (check_id[id_b]) {
        		UF.union(id, id_b);
    		}
        	check_id [id] = true;

    	}
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	if (row <= 0 || col <= 0 ) throw new IllegalArgumentException(" col or row is less than 1");
    	if (row > dim || col > dim ) throw new IllegalArgumentException(" col or row is less than 1");
    	return check_id [grid [row - 1][col - 1]] ;
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	if (row <= 0 || col <= 0 ) throw new IllegalArgumentException(" col or row is less than 1");
    	if (row > dim || col > dim ) throw new IllegalArgumentException(" col or row is more than n");
    	int id = grid [row - 1][col - 1];
    	if (UF.connected(id, 0) && UF.connected(id, dim*dim -1)  ) {
    		return true;
    	}
    	
    	return false ;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	int sum = 0;
    	for (int i = 0; i < check_id.length; i++) {
    		if (check_id[i]) {
    			sum += 1;

    		}
    	}
    	return sum;
    }

    // does the system percolate?
    public boolean percolates() {
    	return UF.connected(0, dim * dim);
    }
    
    private void connect(int id, int row, int col) {
    	int id_side  = grid [row][col];
    	if (check_id[id_side]) {
    		UF.union(id, id_side);
		}
    	check_id [id] = true;
    }

    // test client (optional)
    public static void main(String[] args) {
    	
    }
}