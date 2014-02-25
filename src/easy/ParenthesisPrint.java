package easy;
class  ParenthesisPrint

{
	//now let's create a test case
	public static void main(String[] args)
	{
		PrintParenthesis(3,3,"");//test print all valid combinations of 3 groups of parenthesis
	}


	//define method header
	//left and right remains are keeping track of how many remaining parenthesis left for printing
	//currentString is used to keep track of the current printout for each recursive call
	public static void PrintParenthesis(int leftRemain, int rightRemain, String currentString)
	{
		//firstly check if there is need to go further
		if(rightRemain==0)//all printed out
		{	
			System.out.println(currentString);
			return;
		}
		//now coming to the recursive part
		if(leftRemain>0)//more left parenthesis left for printing
		{
			//choice 1, print another left parenthesis
			PrintParenthesis(leftRemain-1, rightRemain, currentString+"(");
			//choice 2, print right parenthesis if valid
			if(leftRemain < rightRemain)//which means more left parenthesis have been used 
				PrintParenthesis(leftRemain, rightRemain-1, currentString+")");
		}
		else//now there are only right parenthesis left
			PrintParenthesis(leftRemain, rightRemain-1, currentString+")");
	}
}


/**
* Please watch at http://www.youtube.com/user/ProgrammingInterview
* Contact: haimenboy@gmail.com
*
* Step by step to crack programming interview questions.
* 1. All questions were searched publicly from Google, Glassdoor, Careercup and StackOverflow.
* 2. All codes were written from scratch and links to download the source files are provided in each video's description. All examples were written in java, and tools I have used include Editplus, Eclipse and IntelliJ.
* 3. All videos were made without using any non-authorized material. All videos are silent sorry. Text comment is provided during coding as additional explanations.
* Thank you very much. 
*/
