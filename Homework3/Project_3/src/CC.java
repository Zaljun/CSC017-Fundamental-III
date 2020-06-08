import java.util.*;


public class CC {
	// place your code here
	public List<cc> ccList;
    // boolean array for visited position
    public boolean[] visited;
    // vertice list
    public int[] vertice;
    // size of vertice
    public int[] sizeV;
    // size of cc
    public int sizeC;
    // id of cc
    public int id = 1;
    
	// the nested class used to define a connected component
	public static class cc implements Comparable<cc>{
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

		@Override
		public int compareTo(cc o) {
			// TODO Auto-generated method stub
			return -1*(this.getSize() - o.getSize());
		}
	}

	public CC(Graph g) {
		// place your code here
		ccList  = new ArrayList<>();
        visited = new boolean[Collections.max(g.getVertices()) + 1];
        vertice = new int[Collections.max(g.getVertices()) + 1];
        sizeV   = new int[Collections.max(g.getVertices()) + 1];
        
        for(Integer source: g.getVertices()){
            if(!visited[source]){
                DFS(g, source);
                sizeC++;
            }
        }
        
        for(Integer vertex: g.getVertices()){
            cc data = new cc(vertex + 1, sizeV[vertex]);
            ccList.add(data);
        }
        
        Collections.sort(ccList);
	}
	
	public void DFS(Graph g, int src){
        visited[src] = true;
        vertice[src] = sizeC;
        
        sizeV[sizeC]++;
        
        for(Integer neighbor: g.adj(src)){
            if(!visited[neighbor]){
                DFS(g, neighbor);
            }
        }
    }

	public int count() {
		// place your code here
		return sizeC;
	}

	public List<cc> top(int k) {
		// place your code here
		List<cc> topK = new ArrayList<>();
		
        for(int i = 0; i < k; i++){
            topK.add(ccList.get(i));
        }
        
        return topK;
	}
}
