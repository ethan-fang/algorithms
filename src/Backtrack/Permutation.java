package Backtrack;

public class Permutation extends Backtrack {

	public Permutation() {

		super(new int[] {0, 1, 2});
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isASolution(int k, Object input) {
		return k == Integer.parseInt(input.toString());
	}

	@Override
	public void processSolution(int k, Object input) {
		System.out.println("");
		System.out.println("------------");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + ",");
		}
	}

	@Override
	public int constructCandidates(int k, Object input, int[] c) {
		int nCandidates = 0;
		boolean[] inSet = new boolean[MAX_CANDIDATES];
		for (int i = 0; i < k; i++) {
			inSet[a[i]] = true;
		}
		int allItems = a.length;
		for (int i = 0; i < allItems; i++) {
			if (!inSet[i]) {
				c[nCandidates] = i;
				nCandidates++;
			}
		}
		return nCandidates;
	}

	@Override
	public void makeMove(int k, Object input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unmakeMove(int k, Object input) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Permutation p = new Permutation();
		p.backtract(-1, p.a.length - 1);
		
	}
}
