package cs303lab14;

import java.util.Stack;

public class DijkstraAlgorithm {
	
	private double[] distance; // distance of shortest path 
	private Edge[] edge;		// last edge on shortest path 
	
	private IndexMinPQ<Double> priQ; // priroty queue of vertices 
	
	
	public DijkstraAlgorithm(WeightedGraph G, int s){
		distance = new double[G.V];
		edge = new Edge[G.V];
		
		for(int v = 0; v< G.V; v++)
			distance[v] = Double.POSITIVE_INFINITY;
		distance[s]= 0.0;
		
		priQ = new IndexMinPQ<Double>(G.V);
		priQ.insert(s,distance[s]);
		while(!priQ.isEmpty()){
			int i = priQ.delMin();
			for(Edge e : G.adjw[i])
			rest(e);
		}
		
	}
	private void rest(Edge e){
		int v = e.v, w = e.w;
		if(distance[w] > distance[v]+ e.weight){
			distance [w] = distance [v] + e.weight;
			edge[w] = e;
			if(priQ.contains(w)) priQ.decreaseKey(w, distance[w]);
			else
				priQ.insert(w, distance[w]);
		}
	}
	public double distnace (int v){
		return distance [v];
		
	}
	public boolean hasPathTo(int v){
		return distance[v] < Double.POSITIVE_INFINITY;
		
	}
	public Stack<Edge> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Edge> path = new Stack<>();
		for(Edge e = edge[v]; e != null; e = edge[e.v]){
			path.push(e);
		}
		return path;
	}
}
