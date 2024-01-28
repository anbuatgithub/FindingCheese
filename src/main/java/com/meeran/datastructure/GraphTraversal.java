package com.meeran.datastructure;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;


class GraphTr{
	List<List<Integer>> graphArr;
	int node;
	
	GraphTr(int node){
		this.node=node;
		graphArr = new ArrayList<>();
		for(int i=0; i<node; i++)graphArr.add(new ArrayList<Integer>());
	}
	
	void addedges(int a, int b) {
		graphArr.get(a).add(b);
	}
}

class PrintGraph{
	void printGraphDFT(GraphTr graph, int start){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int current = stack.peek();
			stack.pop();
			System.out.print(current+" ");
			for(int x: graph.graphArr.get(current))stack.push(x);
		}
	}
	
	void printGraphBFT(GraphTr graph, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int current = queue.peek();
			queue.remove();
			System.out.print(current+" ");
			for(int x: graph.graphArr.get(current))queue.add(x);
		}
	}
}

/*
 
 0-->1 -->3 -->5
 |
 2-->4
 */

public class GraphTraversal{
	public static void main(String args[]) {
		GraphTr graph = new GraphTr(6);
		
		graph.addedges(0, 1);
		graph.addedges(1, 3);
		graph.addedges(0, 2);
		graph.addedges(2, 4);
		graph.addedges(3, 5);
		
		PrintGraph printGraph = new PrintGraph();
		
		System.out.print("Print the GraphTr in Deapth First Traversal : ");
		printGraph.printGraphDFT(graph, 0);
		System.out.print("\nPrint the GraphTr in Breadth First Traversal : ");
		printGraph.printGraphBFT(graph, 0);
		
	}
}