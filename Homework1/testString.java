
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class testString {
	private String text;
	
	/** Create a new document from the given text.
	 * Because this class is abstract, this is used only from subclasses.
	 * @param text The text of the document.
	 */
	protected testString(String text)
	{
		this.text = text;
	}
	
	/** Returns the tokens that match the regex pattern from the document 
	 * text string.
	 * @param pattern A regular expression string specifying the 
	 *   token pattern desired
	 * @return A List of tokens from the document text that match the regex 
	 *   pattern
	 */
	protected List<String> getTokens(String pattern)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}
	
	public int countSyllables(String word)
	{
		// TODO: Implement this method so that you can call it from the 
	    // getNumSyllables method in BasicDocument
	    int count = 0;
	    String word_lower = word.toLowerCase();
	    char[] c = word_lower.toCharArray();
	    int syl_len = 1;
	    int i = 0;
	    while(i < c.length)
	    {
			if(c[i]=='a'||c[i]=='e'||c[i]=='i'||c[i]=='o'||c[i]=='u'||c[i]=='y')
			{
				for(int j=i+1; j<c.length; j++)
				{
					if(c[j]=='a'||c[j]=='e'||c[j]=='i'||c[j]=='o'||c[j]=='u'||c[j]=='y')
					{
						syl_len++;
					}
					break;
				}
				count++;
				i += syl_len;
			}
			else
			i++;
			syl_len = 1;
		}
		if(c[c.length-1]=='e'&&count!=1) //substract 1 when last char is 'e' 
		{                           //and the previous char is not a vowl and count != 1
			if(c[c.length-2]!='a'||c[c.length-2]!='e'||c[c.length-2]!='i'||c[c.length-2]!='o'||c[c.length-2]!='u'||c[c.length-2]!='y'||c[c.length-2]!='b'||c[c.length-2]!='p'||c[c.length-2]!='t'||c[c.length-2]!='d')
			count--;                //which means the 'e' is doubly counted
		}
	    return count;
	}
	
	public static void main (String[] args) {
		testString tst= new testString("asdbu Hshd? asdh asd. sdsda yesH H.");
		List<String> token = tst.getTokens("([a-z]|[A-Z])+");
		System.out.println(token);
		//System.out.println(tst.getTokens("([a-z]|[A-Z])+"));
		System.out.println(tst.getTokens("([^.?!]+)").size());
		String s = "here";
		System.out.println(s.length()-1);
		System.out.println(s.indexOf('e',s.length()-1));
	}
}

