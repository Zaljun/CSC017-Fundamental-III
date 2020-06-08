import java.util.*;


public class Ego {
	// place your code here
	public List<egonet> egoList;
	
	// the nested class used to define a egonet
	public static class egonet implements Comparable<egonet>{
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

		@Override                           // override to compare by edge
		public int compareTo(egonet o) {
			// TODO Auto-generated method stub
			return -1*(this.getG().getE() - o.getG().getE());
		}
	}

	public Ego(Graph g) {
		// place your code here
		egoList = new ArrayList<>();
		int[] arrVertice = toArray(g.getVertices());
		for(int i = 0; i < arrVertice.length; i++){
			
            int center = arrVertice[i];
            int[] arrNeighbor = toArray(g.adj(center));
            
            Graph graph = new Graph();
            graph.addVertex(center);
            
            for(int j = 0; j < arrNeighbor.length; j++){
                graph.addVertex(arrNeighbor[j]);
                graph.addEdge(center, arrNeighbor[j]);
                graph.addEdge(arrNeighbor[j], center);
            }
            
            for(Integer v: g.adj(center)){
                for(Integer w: g.adj(v)){
                    if(g.adj(w).contains(w)){
                        graph.addEdge(w, v);
                    }
                }
            }
            
            egonet insertElement = new egonet(center, graph);
            
            egoList.add(insertElement);             // insert to list
        }
		
        Collections.sort(egoList);         // sort
	}

	public List<egonet> top(int k) {
		// place your code here
		List<egonet> topK = new ArrayList<>();
        for(int i = 0; i < k; i++){
            topK.add(egoList.get(i));
        }
        return topK;
	}
	
	public int[] toArray(Set<Integer> set){
        int[] arr = new int[set.size()];
        int i = 0;
        // insert every element
        for(Integer val : set){
            arr[i++] = val;
        }
        return arr;
    }
}
