import java.util.Arrays;


public class StringMatching {

	
	public static void main(String[] args) {

		String s = "abcaabacbacbacabcabc";
		String p = "cbacbac";
		

		finsmatch(s, p);
	}

	//O((n − m)(m + 2))
	static void finsmatch(String s, String p) {
		System.out.println("find string " + s + " and pattern " + p);
		
		int slen = s.length();
		int plen = p.length();
		
		for (int i = 0; i < slen - plen + 1; i++) {
			int pi = 0;
			int si = pi + i;
			while (pi < plen && s.charAt(si) == p.charAt(pi)) {
				pi++;
				si++;
			}
			if (pi == p.length()) {
				System.out.println("Found position " + i);
				return;
			}
		}
		System.out.println("Can not find position");
	}
}
