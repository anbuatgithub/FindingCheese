package com.meeran.datastructure;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class LinkedListToTree {
	static TreeNode flatten(ListNode head) {
	    if(head==null) return null;
	    List<Integer> values = new LinkedList<Integer>();
	    getListValues(head, values);
	    Collections.sort(values);
	    return createTree(values, 0);
	  }
		
	private static void getListValues(ListNode head, List<Integer> values ) {
		if(head!=null) {
			getTreeValues(head.data, values);
			getListValues(head.next, values);
		}
	}
	
	private static void getTreeValues(TreeNode data, List<Integer> values) {
		if(data!=null) {
			if(!values.contains(data.value)) values.add(data.value);
			getTreeValues(data.left, values);
			getTreeValues(data.right, values);
		}
	}

	private static TreeNode createTree(List<Integer> values, int index) {
        if (index >= values.size()) return null;

        Integer value = values.get(index);
        if (value == null) return null;
        System.out.println("value-->"+value);

        TreeNode tree = new TreeNode(value);

        tree.left = createTree(values, index * 2 + 1);

        tree.right = createTree(values, index * 2 + 2);
        if(tree.left !=null) System.out.println("left->"+tree.left.value);
        if(tree.right !=null) System.out.println("right->"+tree.right.value);
        
        return tree;
    }
	
	private static TreeNode createTree1(List<Integer> values, int index) {
        if (index >= values.size()) return null;
        return new TreeNode(values.get(index), createTree1(values, index*2+1),createTree1(values, index*2+2));
	}
	

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1, null, new TreeNode(2));
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(3, new TreeNode(4), new TreeNode(2));
		TreeNode t4 = new TreeNode(6, null, new TreeNode(5));

		ListNode head = new ListNode(t1, new ListNode(t2, new ListNode(t3, new ListNode(t4))));
		flatten(head);

	}
	
	@Test
	public void exampleList() {
		TreeNode t1 = new TreeNode(1, null, new TreeNode(2));
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(3, new TreeNode(4), new TreeNode(2));
		TreeNode t4 = new TreeNode(6, null, new TreeNode(5));

		ListNode head = new ListNode(t1, new ListNode(t2, new ListNode(t3, new ListNode(t4))));
		TreeNode expected = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
		//Helpers.testFlatten(head, expected);
	}
}

class ListNode {
  public TreeNode data;
  public ListNode next;
  
  ListNode(TreeNode data, ListNode next) {
    this.data = data;
    this.next = next;
  }
  
  ListNode(TreeNode data) {
    this(data, null);
  }
}

class TreeNode {

  public TreeNode left;
  public TreeNode right;
  public int value;
  
  TreeNode(int value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
  
  TreeNode(int value) {
    this(value, null, null);
  }
}
