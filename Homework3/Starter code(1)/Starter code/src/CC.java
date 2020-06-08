import java.util.*;

public class CC {
	// place your code here

	// the nested class used to define a connected component
	public static class cc {
		int id; // the id of the component
		int size; // the size of the component

		cc(int i, int s) {
			id = i;
			size = s;
		}

		int getId() {
			return id;
		}

		int getSize() {
			return size;
		}
	}

	public CC(Graph g) {
		// place your code here
	}

	public int count() {
		// place your code here
		return 0;
	}

	public List<cc> top(int k) {
		// place your code here
		return null;
	}
}
