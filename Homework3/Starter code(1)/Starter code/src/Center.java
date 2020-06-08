import java.util.*;

public class Center {
	// place your code here

	// the nested class used to define a center
	public static class center {
		int id; // the center
		int count; // the betweenness centrality

		center(int i, int c) {
			id = i;
			count = c;
		}

		int getId() {
			return id;
		}

		int getCount() {
			return count;
		}
	}

	public Center(Graph g) {
		// place your code here
	}

	public List<center> top(int k) {
		// place your code here
		return null;
	}
}
