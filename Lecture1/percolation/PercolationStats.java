import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
	
    // perform independent trials on an n-by-n grid
    private final double threshold [];
	private final int trials;
	private final static double sdConstant = 1.96;
    public PercolationStats(int n, int trials) {
		this.trials = trials;
    	threshold = new double [trials];
    	
    	if (n<=0) throw new IllegalArgumentException("n<=0");
    	
    	if (trials<=0) throw new IllegalArgumentException("trails<=0");
    	
    	for (int i = 0; i < trials; i++) {
    	    double t = threshold(n);
    		threshold[i] = t;
    	}
   	}

    // sample mean of percolation threshold
    public double mean() {
    	return StdStats.mean(threshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
    	return StdStats.stddev(threshold);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
    	return mean() - (sdConstant * stddev())/Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
    	return mean() + (sdConstant * stddev())/Math.sqrt(trials);
    }
    
    private double threshold(int n) {
    	Percolation percolation = new Percolation(n);
    	while(!percolation.percolates()){
    		int x = StdRandom.uniform(1,n + 1);
    		int y = StdRandom.uniform(1,n + 1);
    		percolation.open(x, y);
    	}
    	double th = percolation.numberOfOpenSites() / (n * n * 1.0);
    	return th;
    }

   // test client (see below)
   public static void main(String[] args) {
	   int n = Integer.parseInt(args[0]);
	   int trials = Integer.parseInt(args[1]);
	   PercolationStats ptestPercolationStats = new PercolationStats(n, trials);
	   StdOut.println("mean:           =        " + ptestPercolationStats.mean());
	   StdOut.println("sd:           =        " + ptestPercolationStats.stddev());
	   StdOut.println("95% Cnfidence intervel     =   [" + ptestPercolationStats.confidenceLo() +
			   " , "+ ptestPercolationStats.confidenceHi() + "]");
	   
			   
   }

}