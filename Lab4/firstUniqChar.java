public class firstUniqChar {
	public int SolutionFirstUniqChar(String s) 
	{
		char[] cArray = s.toCharArray();
		int index = 0;
		int count = 0;
		while(index < cArray.length)
		{
			for(int j = 0; j < cArray.length; j++)
			{
				if(cArray[index] == cArray[j])
				{
					count++;
				}
			}
			if(count == 1)
			{
				break;
			}
			count = 0;
			index++;
		}
		return index;
	}
	public static void main(String args[]) {
		firstUniqChar test = new firstUniqChar();
		System.out.println(test.SolutionFirstUniqChar("ilovehofstra"));
		System.out.println(test.SolutionFirstUniqChar("abracadabra"));
	}
}
