import java.util.*;

public class Influence {
	// place your code here

	// the nested class used to define a influencer
	public static class influencer {
		int source; // the influencer
		double power; // the impact of this influencer

		influencer(int i, double p) {
			source = i;
			power = p;
		}

		int getSource() {
			return source;
		}

		double getPower() {
			return power;
		}
	}

	public Influence(Graph g) {
		// place your code here
	}

	public List<influencer> top(int k) {
		// place your code here
		return null;
	}
}
