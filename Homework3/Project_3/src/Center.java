import java.util.*;


public class Center {
	// place your code here
	List<center> centerList;
    HashMap<Integer, Integer> map;
    
	// the nested class used to define a center
	public static class center implements Comparable<center>{
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

		@Override                                   // override to compare by count
		public int compareTo(center o) {
			// TODO Auto-generated method stub
			return -1*(this.getCount() - o.getCount());
		}
	}

	public Center(Graph g) {
		// place your code here
		centerList = new ArrayList<>();
        map = new HashMap<>();
        
        for(Integer u: g.getVertices()){
            map.put(u, 0);
        }
       
        for(Integer src: g.getVertices()){
            BFS(g, src);
        }
        
        for(Integer v: g.getVertices()){
            centerList.add(new center(v, map.get(v)));
        }
        
        Collections.sort(centerList);
		
	}
	
	public void BFS(Graph g, int source){
        // distTo
        HashMap<Integer, Integer> distTo = new HashMap<>();
        // edgeTo
        HashMap<Integer, Integer> edgeTo = new HashMap<>();
        // q
        LinkedList<Integer> queue = new LinkedList<>();
        // visited
        HashSet<Integer> visited = new HashSet<>();
        
        queue.addLast(source);
        visited.add(source);
        distTo.put(source, 0);
        
        while(!queue.isEmpty()){
            int vertex = queue.remove();
            visited.add(vertex);
            
            Iterator<Integer> iterator = g.adj(vertex).iterator();
            while(iterator.hasNext()){
                int neighbor = iterator.next();
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.addLast(neighbor);
                    distTo.put(neighbor, distTo.get(vertex) + 1);
                    edgeTo.put(neighbor, vertex);
                }
            }
        }
        
        for(Integer i: visited){
            if(i != source){
                for(int x = i; x != source; x = edgeTo.get(x)){
                    map.put(x, map.get(x) + 1);
                }
                map.put(source, map.get(source) + 1);
            }
        }
    }

	public List<center> top(int k) {
		// place your code here
		List<center> topK = new ArrayList<>();
        for(int i = 0; i < k; i++){
            topK.add(centerList.get(i));
        }
        return topK;
	}
}
