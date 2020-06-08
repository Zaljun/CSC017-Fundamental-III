/**
 * A class for numeric progressions.
 */
public class ArithProgression {

    /** First value of the progression.  */
    private long first;

    /** Current value of the progression.  */
    private long cur;
    
    //increment 
    private long inc;

    /** Default constructor.  */
    public ArithProgression() {
	     cur = first = 0;
    }
    
    //constructor with parameters
    public ArithProgression(int first_input, int increment_input){
		first = first_input;
		inc = increment_input;
	}

    /** Resets the progression to the first value.
     *
     * @return first value
     */
    private long firstValue() {
	      cur = first;
	     return cur;
	     //return first;
    }

    /** Advances the progression to the next value.
     *
     * @return next value of the progression
     */
    private long nextValue() {
	     return cur+=inc; // default next value
    }

    /** Prints the first n values of the progression.
     *
     * @param n number of values to print
     */
     public void printProgression(int n) {
	      System.out.print(firstValue());
        for (int i = 2; i <= n; i++)
          System.out.print(" " + nextValue());
	      System.out.println(); // ends the line
     }
}
