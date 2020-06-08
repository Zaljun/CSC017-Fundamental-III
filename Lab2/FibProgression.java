/**
 * A class for numeric progressions.
 */
public class FibProgression {

    /** First value of the progression.  */
    private long first;
    
    private long second;

    /** Current value of the progression.  */
    private long cur;

    /** Default constructor.  */
    public FibProgression(int first_input, int second_input) {
	     first = first_input;
	     second = second_input;
    }
    public FibProgression() {
	     first = 1;
	     second = 1;
    }
    /** Resets the progression to the first value.
     *
     * @return first value
     */
    private long firstValue() {
	     cur = first;
	      return cur;
    }
    
    private long secondValue(){
		cur = second;
		return cur;
	}

    /** Advances the progression to the next value.
     *
     * @return next value of the progression
     */
    private long nextValue() {
	     return move();
    }
    
    private long move(){
		cur = first + second;
		first = second;
		second = cur;
		return cur;
	}

    /** Prints the first n values of the progression.
     *
     * @param n number of values to print
     */
     public void printProgression(int n) {
	      System.out.print(firstValue()+" ");
	      System.out.print(secondValue());
        for (int i = 3; i <= n; i++)
          System.out.print(" " + nextValue());
          move();
	      System.out.println(); // ends the line
     }
}
