package easy;

public class Sqrt {
	public static void main(String[] args) {
		System.out.println("sqrt(0.34)=" + sqrt(0.34));
	}

	// define method header
	public static double sqrt(double a) {
		// firstly check if a is non-negative value
		if (a < 0)
			return -1;
		// also check if a==0 or a==1 because in these two cases sqrt(a) = a
		if (a == 0 || a == 1)
			return a;

		// now start the core part of the code
		double precision = 0.00001;// define the precision, so we stop when
									// precision is achieved
		double start = 0;
		double end = a;
		// we define these two start/end values because usually 0<sqrt(a)<a
		// however, if a<1; then 0<a<sqrt(a)
		if (a < 1)
			end = 1;

		// define a loop to continue if the precision is not yet achieved
		while (end - start > precision) {
			double mid = (start + end) / 2;
			double midSqr = mid * mid;
			if (midSqr == a)
				return mid;// we find the exact sqrt value!
			else if (midSqr < a)
				start = mid;// we shift our focus to bigger half
			else
				end = mid;// shift focus to smaller half
		}

		// if we did not find exact sqrt value, we return the approxiated value
		// with the defined precision
		return (start + end) / 2;
	}
}

/**
 * Please watch at http://www.youtube.com/user/ProgrammingInterview Contact:
 * haimenboy@gmail.com
 * 
 * Step by step to crack programming interview questions. 1. All questions were
 * searched publicly from Google, Glassdoor, Careercup and StackOverflow. 2. All
 * codes were written from scratch and links to download the source files are
 * provided in each video's description. All examples were written in java, and
 * tools I have used include Editplus, Eclipse and IntelliJ. 3. All videos were
 * made without using any non-authorized material. All videos are silent sorry.
 * Text comment is provided during coding as additional explanations. Thank you
 * very much.
 */
