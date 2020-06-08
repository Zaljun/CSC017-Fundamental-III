public class TopLetter
{
	static char getMostFrequentChar(String s)
	{
		int freq[] = new int[256];
		int max = 0;
		int index=0;
		for(int i = 0; i < s.length(); i ++)
            freq[(int)(s.charAt(i))] ++;
        for(int m = 0; m < 256; m ++)
        {
			if(freq[m]>=max)
			max = freq[m];
		}
		for(int m = 0; m < 256; m ++)
        {
			if(freq[m]==max)
			index = m;
		}
		return (char)(index);
	}
	public static void main(String[] args)
	{
		String str1 = "abeacadabra";
		String str2 = "Supercalifragilisticeexpialidocious";
		System.out.println(getMostFrequentChar(str1));
		System.out.println(getMostFrequentChar(str2));
	}
}
