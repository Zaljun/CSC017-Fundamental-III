import java.util.*;


public class Diameter {
	// place your code here
	public List<Integer> diameterList;
	
	// comparator to compare by diameter
	class sortByDiameter implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            return b.compareTo(a);
        }
    }

	public Diameter(Graph g) {
		// place your code here
        diameterList = new ArrayList<>();
        Set<Integer> setOfVertices = g.getVertices();
        
        for(Integer source: setOfVertices){
            diameterList.add(findD(g, source));
        }
        
        Collections.sort(diameterList, new sortByDiameter());
	}
	
	public int findD(Graph g, int source){
		HashMap<Integer, Integer> distTo = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int largest = -1;
       
        queue.addLast(source);
        distTo.put(source, 0);
         
        while(!queue.isEmpty()){
            int vertice = queue.remove();
            for(Integer i: g.adj(vertice)){
                if(!distTo.containsKey(i)){
                    queue.addLast(i);
                    distTo.put(i, 1 + distTo.get(vertice));
                }
            }
        }
        
        for(Integer j: g.getVertices()){
            if(distTo.get(j) > largest){
                largest = distTo.get(j);
            }
        }
        
        return largest;
    }

	public int getDiameter() {
		// place your code here
		return diameterList.get(0);
	}
	
	
}
