package Graph;

public class Floyd extends Graph{

	public Floyd(boolean directed) {
		super(directed);
		// TODO Auto-generated constructor stub
	}
	
	
	private class Matrix {
		int[][] weight;
		
		public Matrix() {
			weight = new int[max][max];
		}
	}
	
	//Loop through a matrix
//1, ... n
	//1,1 -> 1,1 1,2 1,3 1,4 ... 1.n
	//2,1 -> 1,1 1,2 1,3 1,4 ... 1.n

}
