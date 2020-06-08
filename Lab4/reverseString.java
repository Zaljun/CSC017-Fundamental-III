public class reverseString {
	public String SolutionReverseString(String s) {
		char[] cArray = s.toCharArray();
		int len = cArray.length;
		for(int i=0; i<(int)(len/2); i++)
		{
			char swap = cArray[i];
		    cArray[i] = cArray[len-i-1];
		    cArray[len-i-1] = swap;
		}
		return new String(cArray);
	}
	public static void main(String args[]) {
		reverseString test = new reverseString();
		System.out.println(test.SolutionReverseString("hello"));
		System.out.println(test.SolutionReverseString("A man, a plan, a canal: Panama"));
	}
}

//int i = 0
//j = len -1
//swap A[i], A[j]
//i++, j--

//string builder

//reccursion
//string left = reverse(0,len/2)
//string right =reverse(len/2,right)
//return right + left
//base case: len<=1, return char
