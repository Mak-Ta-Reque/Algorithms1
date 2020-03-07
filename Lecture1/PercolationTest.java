import org.junit.jupiter.api.Test;
class PercolationTest {

	@Test
	void test() {
		Percolation percolation = new Percolation(5);
		percolation.open(1, 1);
		percolation.percolates();
	}

}
