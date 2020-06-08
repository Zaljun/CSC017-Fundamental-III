/** 
 * A class that represents a text document
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Document {

	private String text;
	
	/** Create a new document from the given text.
	 * Because this class is abstract, this is used only from subclasses.
	 * @param text The text of the document.
	 */
	protected Document(String text)
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
	
	/** This is a helper function that returns the number of syllables
	 * in a word.  You should write this and use it in your 
	 * BasicDocument class.
     *
	 * Just use a loop to loop through the 
	 * characters in the string and write your own logic for counting 
	 * syllables.
	 * 
	 * @param word  The word to count the syllables in
	 * @return The number of syllables in the given word, according to 
	 * this rule: Each contiguous sequence of one or more vowels is a syllable, 
	 *       with the following exception: a lone "e" at the end of a word 
	 *       is not considered a syllable unless the word has no other syllables. 
	 *       You should consider y a vowel.
	 */
	 //method 1 to count syllables using loop. treat word as an array of char
	/*protected int countSyllables(String word)
	{
		// TODO: Implement this method so that you can call it from the 
	    // getNumSyllables method in BasicDocument
	    if(this.getNumWords()==0)
	    return -1;
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
					else 
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
			if(c[c.length-2]!='a'&&c[c.length-2]!='e'&&c[c.length-2]!='i'&&c[c.length-2]!='o'&&c[c.length-2]!='u'&&c[c.length-2]!='y')
			count--;                //which means the 'e' is doubly counted
		}
	    return count;
	}*/
	
	//method 2. reuse getTokens to shrink the work, than substract doubly counted part
	protected int countSyllables(String word)
	{
		// TODO: Implement this method so that you can call it from the 
	    // getNumSyllables method in BasicDocument
	    BasicDocument w = new BasicDocument(word);
	    int count = w.getTokens("([aeiouy]|[AEIOU])+").size();
	    if(word.charAt(word.length()-1)=='e'&&count!=1)
	    {
			if(word.charAt(word.length()-2)!='a'&&word.charAt(word.length()-2)!='e'&&word.charAt(word.length()-2)!='i'&&word.charAt(word.length()-2)!='o'&&word.charAt(word.length()-2)!='u'&&word.charAt(word.length()-2)!='y')
			count--;
		}
	    return count;
	}
	
	/** A method for testing
	 * 
	 * @param doc The Document object to test
	 * @param syllables The expected number of syllables
	 * @param words The expected number of words
	 * @param sentences The expected number of sentences
	 * @return true if the test case passed.  False otherwise.
	 */
	public static boolean testCase(Document doc, int syllables, int words, int sentences)
	{
		System.out.println("Testing text: ");
		System.out.print(doc.getText() + "\n....");
		boolean passed = true;
		int syllFound = doc.getNumSyllables();
		int wordsFound = doc.getNumWords();
		int sentFound = doc.getNumSentences();
		if (syllFound != syllables) {
			System.out.println("\nIncorrect number of syllables.  Found " + syllFound 
					+ ", expected " + syllables);
			passed = false;
		}
		if (wordsFound != words) {
			System.out.println("\nIncorrect number of words.  Found " + wordsFound 
					+ ", expected " + words);
			passed = false;
		}
		if (sentFound != sentences) {
			System.out.println("\nIncorrect number of sentences.  Found " + sentFound 
					+ ", expected " + sentences);
			passed = false;
		}
		System.out.println("FlecshScore: " + doc.getFleschScore());
		if (passed) {
			System.out.println("passed.\n");
		}
		else {
			System.out.println("FAILED.\n");
		}
		return passed;
	}
	
	
	/** Return the number of words in this document */
	public abstract int getNumWords();
	
	/** Return the number of sentences in this document */
	public abstract int getNumSentences();
	
	/** Return the number of syllables in this document */
	public abstract int getNumSyllables();
	
	/** Return the entire text of this document */
	public String getText()
	{
		return this.text;
	}
	
	/** return the Flesch readability score of this document */
	public double getFleschScore()
	{
	    // TODO: Implement this method.
	    if(this.getNumWords()==0) //return 0 if document is empty
	    return 0;
	    double fleschScore = 0;
	    fleschScore = 206.835 - 1.015*(this.getNumWords()/this.getNumSentences()) - 84.6*(this.getNumSyllables()/this.getNumWords());
	    return fleschScore;
	}
	
	
	
}
