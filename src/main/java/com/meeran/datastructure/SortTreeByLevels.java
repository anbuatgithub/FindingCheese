package com.meeran.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class SortTreeByLevels {
	public static List<Integer> treeByLevels(Node node) {
		// off ya go!
		if (node == null) return new LinkedList<>();
		List<Integer> treeValList = new LinkedList<>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			treeValList.add(currentNode.value);
			if (currentNode.left != null) queue.add(currentNode.left);
			if (currentNode.right != null) queue.add(currentNode.right);
		}
		return treeValList;
	}

	@Test
	public void nullTest() {
		assertEquals(Arrays.asList(), SortTreeByLevels.treeByLevels(null));
	}

	@Test
	public void basicTest() {
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6),
				SortTreeByLevels.treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2),
						new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1)));
	}
}