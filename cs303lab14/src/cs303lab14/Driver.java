package cs303lab14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;


public class Driver {
public static void main(String[] args) {
		
		testTinyDG();
		testMediumDG();
		testLargeDG();
		testXtraLargeDG();
	}
	public static void testTinyDG() {
		FileReader r;
		try {
			System.out.println("\ntestTinyDG\n");
			r = new FileReader(new File("tinyDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			WeightedGraph g = new WeightedGraph(bf);
	
			
			long now = System.nanoTime();
			DijkstraAlgorithm A = new DijkstraAlgorithm(g, 0);
			now = System.nanoTime() - now;
			now = now/ 1000;
			
			System.out.println("Time taken: "+now+" Microseconds\n");
			
			for(int i = 0; i < g.V; i++){
				double dist = A.distnace(i);
				Stack<Edge> z = A.pathTo(i);
				String s = "";
				s += i + ": " + dist + " | ";
				for(int j = z.size()-1; j >= 0; j--){
					s += z.get(j).v + " -> ";
				}
				s += i;
				System.out.println(s);
			}
			 //print in microseconds
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testMediumDG() {
		FileReader r;
		try {
			System.out.println("\nmediumDG\n");
			r = new FileReader(new File("mediumDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			WeightedGraph g = new WeightedGraph(bf);
			
			long now = System.nanoTime();
			DijkstraAlgorithm mst = new DijkstraAlgorithm(g, 0);
			now = System.nanoTime() - now;
		
			

			System.out.println("Time taken: " + now /1000 + "Microseconds\n"); //print in microseconds
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testLargeDG() {
		FileReader r;
		try {
			System.out.println("\ntestLargeDG\n");
			r = new FileReader(new File("largeDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			WeightedGraph g = new WeightedGraph(bf);
			
			long now = System.nanoTime();
			DijkstraAlgorithm mst = new DijkstraAlgorithm(g, 0);
			now = System.nanoTime() - now;
			System.out.println("Time taken: " + now/1000 + "Microseconds\n"); //print in microseconds
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testXtraLargeDG() {
		FileReader r;
		try {
			System.out.println("\ntestXtraLargeDG\n");
			r = new FileReader(new File("XtraLargeDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			WeightedGraph g = new WeightedGraph(bf);
			
			
			long now = System.nanoTime();
			DijkstraAlgorithm mst = new DijkstraAlgorithm(g, 0);
			now = System.nanoTime() - now;
			
			System.out.println("Time taken: " + now/1000+ "Microseconds\n"); //print in microseconds
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
