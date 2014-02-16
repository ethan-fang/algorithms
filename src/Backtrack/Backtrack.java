package Backtrack;

public abstract class Backtrack {

	public int[] a;
	
	public static final int MAX_CANDIDATES = 10;
	
	public boolean finished;
	
	public Backtrack(int[] a) {
		this.a = a;
		
		
	}
	
	public void backtract(int k, Object input) {
		int[] c = new int[MAX_CANDIDATES];
		int nCandidates = 0;
		
		if (isASolution(k, input)) {
			processSolution(k, input);
		} else {
			k = k + 1;
			nCandidates = constructCandidates(k, input, c);
			for (int i = 0; i < nCandidates; i++) {
				a[k] = c[i];
				makeMove(k, input);
				backtract(k, input);
				unmakeMove(k, input);
				if (finished) return;
			}
		}
		
	}
	
	public abstract boolean isASolution(int k, Object input);
	public abstract void processSolution(int k, Object input);
	public abstract int constructCandidates(int k, Object input, int[] c);
	
	public abstract void makeMove(int k, Object input);
	public abstract void unmakeMove(int k, Object input);
}
