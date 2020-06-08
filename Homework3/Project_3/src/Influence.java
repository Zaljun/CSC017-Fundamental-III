import java.util.*;

public class Influence {
	// place your code here
	public List<influencer> infList;
	
	// the nested class used to define a influencer
	public static class influencer implements Comparable<influencer>{
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

		@Override                                      // override influencer to compare for sorting
		public int compareTo(influencer o) {
			// TODO Auto-generated method stub
			return (int) ((int) -1*(this.getPower() - o.getPower()));
			
		}
	}

	public Influence(Graph g) {
		// place your code here
		infList = new ArrayList<>();
        Set<Integer> vertices = g.getVertices();

        for(Integer i: vertices){
            int placeHolderSource = i;
            double power = getPower(g, placeHolderSource);
            influencer data = new influencer(placeHolderSource, power);
            
            infList.add(data);
        }
        // sort by power
        Collections.sort(infList);
	}

	public List<influencer> top(int k) {
		// place your code here
		List<influencer> topK = new ArrayList<>();
        for(int i = 0; i < k; i++){
            topK.add(infList.get(i));
        }
        return topK;
	}
	
	// get power 
	public double getPower(Graph g, int source){
        double power = 0;
        // distTo
        HashMap<Integer, Integer> distTo = new HashMap<Integer, Integer>();
        // edgeTo
        //HashMap<Integer, Integer> edgeTo = new HashMap<Integer, Integer>();
        // q
        LinkedList<Integer> queue = new LinkedList<>();
        // visited vertices
        HashSet<Integer> visited = new HashSet<Integer>();
        
        queue.addLast(source);
        distTo.put(source, 0);
        
        while(!queue.isEmpty()){
            int vertice = queue.remove();
            visited.add(vertice);
            
            if(vertice != source){
                power += 1 / Math.pow(2, (distTo.get(vertice) - 1));  // update power 
            }
            
            // go through the list 
            Iterator<Integer> iterator = g.adj(vertice).iterator();
            while(iterator.hasNext()){
                int neighbor = iterator.next();
                
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.addLast(neighbor);
                    distTo.put(neighbor, distTo.get(vertice) + 1);
                }
            }
        }
        return power;
    }
}
