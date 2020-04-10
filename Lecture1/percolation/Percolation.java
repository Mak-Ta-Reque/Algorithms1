package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private  final int [][] grid;
	private final int  dim;
	private boolean [] checkId;
	private final WeightedQuickUnionUF unionFind;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	dim = n;
    	if (n <= 0) throw new IllegalArgumentException("n<=0");
    	grid = new int [n][n];
    	checkId = new boolean [n*n];
    	int temp = 0;
    	
    	for(int i = 0; i < n; i++) {
    	    
    		for(int j = 0; j < n; j++) {
    			grid[i][j] = i + j + temp;

    		}
    		temp += n-1;
   
    	}
    	unionFind = new WeightedQuickUnionUF(n * n+1);
    	
    	for (int i = 1; i < n; i++) {
    		unionFind.union(0, i);
    		unionFind.union(n * n, n * n - i);
    	}
    	
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        
    	if (row <= 0 || col <= 0) throw new IllegalArgumentException(" col or row is less than 1");
    	
    	if (row > dim || col > dim) throw new IllegalArgumentException(" col or row is more than n");
    	row = row - 1;
    	col = col - 1;
    	int id = grid [row][col];
    	
    	if (!checkId[id]) {
    		// Four cases for corner 
    		
    		if(col == 0 && row == 0) {
    			connect(id, row, col+1);
    			connect(id, row + 1, col);
    			return;
    		}
    		
    		if(col == dim - 1 && row == dim - 1) {
    			connect(id, row, col-1);
    			connect(id, row - 1, col);
    			return;
    		}
    		
    		if(col == dim - 1 && row == 0) {
    			connect(id, row + 1, col);
    			connect(id, row, col - 1);
    			return;
    		}
    		
    		if(col == 0 && row == dim - 1) {
    			connect(id, row - 1, col);
    			connect(id, row, col + 1);
    			return;
    		}
    		
    		if (col == 0) {
    			int idR  = grid [row][col+1];
    			
            	if (checkId[idR]) {
            		unionFind.union(id, idR);
        		}
            	int idT  = grid [row -1][col];
            	
            	if (checkId[idT]) {
            		unionFind.union(id, idT);
        		}
            	int idB = grid [row + 1][col];
            	
            	if (checkId[idB]) {
            		unionFind.union(id, idB);
        		}
            	checkId [id] = true;
            	return;
    		}
    		
    		if (col==dim - 1) {
        		// no right object
    			int idL  = grid [row][col-1];
    			
            	if (checkId[idL]){
            		unionFind.union(id, idL);
        		}
            	
            	int idT  = grid [row -1][col];
            	
            	if (checkId[idT]) {
            		unionFind.union(id, idT);
        		}
            	int idB = grid [row + 1][col];
            	
            	if (checkId[idB]) {
            		unionFind.union(id, idB);
        		}
            	checkId [id] = true;
            	return;
        	}
    		
    		if (row == 0) {
    			int idL  = grid [row][col - 1];
            	if (checkId[idL]) {
            		unionFind.union(id, idL);
        		}
            	
            	int idR = grid [row][col + 1];
            	if (checkId[idR]) {
            		unionFind.union(id, idL);
        		}
            	
            	int idB = grid [row + 1][col];
            	
            	if (checkId[idB]) {
            		unionFind.union(id, idB);
        		}
            	
            	checkId [id] = true;
            	return;
    		}
    		
    		if (row==dim - 1) {
    			int idL = grid [row][col-1];
    			
            	if (checkId[idL]) {
            		unionFind.union(id, idL);
        		}
            	
            	int idR = grid [row][col+1];
            	
            	if (checkId[idR]) {
            		unionFind.union(id, idL);
        		}
            	
            	int idT = grid [row -1][col];
            	
            	if (checkId[idT]) {
            		unionFind.union(id, idT);
        		}
            	
            	checkId [id] = true;
            	return;
    		}
    		
    		int idL = grid [row][col - 1];
    		
        	if (checkId[idL]) {
        		unionFind.union(id, idL);
    		}
        	
        	int id_r = grid [row][col + 1];
        	if (checkId[id_r]) {
        		unionFind.union(id, idL);
    		}
        	
        	int idT = grid [row - 1][col];
        	
        	if (checkId[idT]) {
        		unionFind.union(id, idT);
    		}
        	
        	int idB = grid [row + 1][col];
        	
        	if (checkId[idB]) {
        		unionFind.union(id, idB);
    		}
        	
        	checkId[id] = true;
    	}
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	if (row <= 0 || col <= 0 ) throw new IllegalArgumentException(" col or row is less than 1");
    	if (row > dim || col > dim ) throw new IllegalArgumentException(" col or row is less than 1");
    	return checkId[grid[row - 1][col - 1]];
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	if (row <= 0 || col <= 0 ) throw new IllegalArgumentException(" col or row is less than 1");
    	
    	if (row > dim || col > dim ) throw new IllegalArgumentException(" col or row is more than n");
    	
    	int id = grid[row - 1][col - 1];
    	return unionFind.connected(0 , id) || unionFind.connected(dim *dim , id);

    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	int sum = 0;
    	for (int i = 0; i < checkId.length; i++){
    		if (checkId[i]){
    			sum += 1;
    		}
    	}
    	return sum;
    }

    // does the system percolate?
    public boolean percolates() {
    	return unionFind.connected(0, dim * dim);
    }
    
    private void connect(int id, int row, int col) {
    	int id_side  = grid[row][col];
    	if (checkId[id_side]) {
    		unionFind.union(id, id_side);
		}
    	checkId[id] = true;
    }

    // test client (optional)
    public static void main(String[] args) {
    	//Ignore 
    }
}