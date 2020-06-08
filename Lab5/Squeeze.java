public class Squeeze
{
	public static String squeeze(String s)
	{
		String[] split = s.split(" +");
		String output = "";
		for(int i=0; i< split.length;i++)
		{
			if(split[i]!=" ")
			output += split[i]+" ";
			//System.out.println(split[i]);
			//System.out.println(split.length);
		}
		return  output;
	}
	/*public static String squeeze(String s)
	{
		String output = s.replaceAll(" +"," ");
		return output;
	}*/
	
	public static void main(String[] args)
	{
		System.out.println(squeeze("this is     a     test"));
	}
}

