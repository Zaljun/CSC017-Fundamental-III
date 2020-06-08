public class FibProgression extends Progression{
	protected long second;
	protected long prev;
	public FibProgression(){
		second = 1;
		prev = second - first;
	}
	public FibProgression(long input_first,long input_second){
		first = input_first;
		second = input_second;
		prev = second - first;
	}
	protected long nextValue() {
	     long temp = prev;
	     prev = cur;
	     cur += temp;
	     return cur;
    }
}
