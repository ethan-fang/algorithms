package Number;

public class Palindrome {
	public static class NumberHolder {
		int y;

		public NumberHolder(int y) {
			this.y = y;
		}
	}

	public static boolean isPalindrome(int x, NumberHolder holder) {
		System.out.println("X is " + x + " y is " + holder.y);
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		if (isPalindrome(x / 10, holder) && (x % 10 == holder.y % 10)) {
			holder.y /= 10;
			System.out.println("X is " + x + " y is " + holder.y);
			return true;
		} else {
			return false;
		}
	}

	static boolean isPalindrome1(int x) {
		if (x < 0)
			return false;
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
		while (x != 0) {
			int l = x / div;
			int r = x % 10;
			if (l != r)
				return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}

	public static boolean isPalindrome(int x) {
		return isPalindrome(x, new NumberHolder(x));
	}
	
	static boolean isPalindrome3(int x) {
	    if(x < 0) return false;
	    int a = x, b = 0;
	    while(a > b) {
	        b = b * 10 + a % 10;
	        a /= 10;
	    }
	    if(a == 0) return (x == b);
	    return (a == b) || a == (b / 10);
	}

	public static void main(String[] args) {
		int value = 101;
		System.out.println(value + " is palindrome " + isPalindrome3(value));
	}

	public static boolean checkPalindrome2(int a) {
		int x = a;
		int y = 0;
		for (; a > 0; a = a / 10) {
			y = y * 10 + a % 10;
		}
		return (x == y);
	}

}
