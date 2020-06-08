import java.util.*;

public class Ego {
	// place your code here

	// the nested class used to define a egonet
	public static class egonet {
		int center; // center of the egonet
		Graph G; // subgraph that represents the egonet

		egonet(int c, Graph g) {
			center = c;
			G = g;
		}

		int getCenter() {
			return center;
		}

		Graph getG() {
			return G;
		}
	}

	public Ego(Graph g) {
		// place your code here
	}

	public List<egonet> top(int k) {
		// place your code here
		return null;
	}
}
