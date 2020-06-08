//** Test program for the progression classes */
public class ProgressionTester {
    public static void main(String[] args) {
       // test Progression
       System.out.println("Default progression");
       Progression prog = new Progression();
       prog.printProgression(10);

       // test ArithProgression
       System.out.println("Arithmetic progression with start value 2 and increment 5:");
	     ArithProgression Arithprog = new ArithProgression(2, 5);
	     Arithprog.printProgression(10);

	     // test FibonacciProgression
       System.out.println("Fibonacci progression with start values 4 and 6:");
	     FibProgression Fibonacciprog = new FibProgression(4,6);
	     Fibonacciprog.printProgression(10);
  }
}


