package com.meeran.datastructure;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	
	HashMap<String, ArrayList<String>> adjList = new HashMap<>();
	
	private boolean addVertex(String vertex) {
		if(adjList.get(vertex)==null) {
			adjList.put(vertex, new ArrayList<String>());
			return true;
		}
		return false;
	}
	
	private boolean addEdge(String vertex1, String vertex2) {
		if(adjList.get(vertex1)!=null && adjList.get(vertex2)!=null) {
			adjList.get(vertex1).add(vertex2);
			adjList.get(vertex2).add(vertex1);
			return true;
		}
		return false;
	}
	
	private boolean removeEdge(String vertex1, String vertex2) {
		if(adjList.get(vertex1)!=null && adjList.get(vertex2)!=null) {
			adjList.get(vertex1).remove(vertex2);
			adjList.get(vertex2).remove(vertex1);
			return true;
		}
		return false;
	}
	
	private boolean removeVertex(String vertex) {
		if(adjList.get(vertex)==null) return false;
		for(String otherVertex : adjList.get(vertex)) {
			adjList.get(otherVertex).remove(vertex);
		}
		adjList.remove(vertex);
		return true;
	}
	
	private void printGraph() {
		System.out.println(adjList);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("B", "D");
		graph.addEdge("C", "D");
		
		graph.printGraph();
		
		
		graph.removeVertex("D");
		graph.printGraph();
		
		graph.removeEdge("A", "B");
		graph.printGraph();
	}

}
