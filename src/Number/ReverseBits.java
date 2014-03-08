package Number;

public class ReverseBits {
	static int swapBits(int x, int i, int j) {
		  int lo = ((x >> i) & 1);
		  int hi = ((x >> j) & 1);
		  if ((lo ^ hi) == 1) {
		    x ^= ((1 << i) | (1 << j));
		  }
		  return x;
		}

	static int reverseXor(int x) {
		int n = Integer.bitCount(x);
		for (int i = 0; i < n / 2; i++) {
			x = swapBits(x, i, n - i - 1);
		}
		return x;
	}
	
	
}
