package Interview;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijikstraAlgorithm {
	public static class Node{
		int vertex;
		int distance;
		
		Node(int vertex,int distance){
			this.vertex=vertex;
			this.distance=distance;
		}
	}
		
		public static Map<Integer, Integer> dijikstra(Map<Integer,Map<Integer,Integer>> graph, int source ){
			Map<Integer ,Integer> distance=new HashMap<>();
			
			PriorityQueue<Node> pq= new PriorityQueue<>(Comparator.comparingInt(node-> node.distance));
			
			for(Integer vertex: graph.keySet()) {
				distance.put(vertex, Integer.MAX_VALUE);
			}
			distance.put(source, 0);
			pq.add(new Node(source,0));
			
			while(!pq.isEmpty()) {
				Node current=pq.poll();
				int currentvertex=current.vertex;
				int currentdistance=current.distance;
				
				if(currentdistance>distance.get(currentvertex)) {
					continue;
				}
				for(Map.Entry<Integer, Integer> neighbourentry:graph.getOrDefault(currentvertex, Collections.emptyMap()).entrySet()) {
					int neighbor=neighbourentry.getKey();
					int weight=neighbourentry.getValue();
					int newdistance=currentdistance+weight;
					
					if(newdistance< distance.get(neighbor)){
						distance.put(neighbor, newdistance);
						pq.add(new Node(neighbor,newdistance));
						
						
					}
						
				}
			}
			return distance;
		}
	
	public static void main(String[] args) {
		Map<Integer, Map<Integer,Integer>> graph=new HashMap<>();
		graph.put(0, Map.of(1,4,2,1));
		graph.put(1, Map.of(3,1));
		graph.put(2, Map.of(1,2,3,5));
		graph.put(3, Collections.emptyMap());
		
		int source=0;
		Map<Integer,Integer> shortestPaths=dijikstra(graph, source);
		for(Map.Entry<Integer, Integer> entry:shortestPaths.entrySet()) {
			System.out.println("vertex" +entry.getKey()+":"+entry.getValue());
		}
		
		
	}

}

