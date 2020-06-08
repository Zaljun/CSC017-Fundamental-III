public class ArithProgression extends Progression{
	protected long step;
	public ArithProgression(){
		//super();
	}
	public ArithProgression(long input_first, long input_step){
		first = input_first;
		step = input_step;
	}
	protected long nextValue() {
	     return cur+=step; 
    }
}
