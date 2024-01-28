package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MaxSumTree {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	static int maxSum(TreeNode root) {
      if(root==null) return 0;
      int sum=root.value;
      while(root!=null){
        if(root.left==null && root.right==null){
          break;
        }else if(root.left==null && root.right!=null){
          sum+=root.right.value;
          root=root.right;
        }else if(root.left!=null && root.right==null){
          sum+=root.left.value;
          root=root.left;
        }else{
          if(Math.abs(root.left.value)>=Math.abs(root.right.value)){
            sum+=root.left.value;
            root=root.left;
          }else{
            sum+=root.right.value;
            root=root.right;
          }
        }
        
      }
      return sum;
    }
	
	@Test
	public void testMaxSumTree() {
		/* Construct the following tree
		        1
		      /   \
		     /     \
		    2       3
		   / \     / \
		  8   4   5   6
		     /   / \   \
		   10   7   9   5
		*/
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.right.left = new TreeNode(10);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(9);
		root.right.right.right = new TreeNode(5);
		assertEquals(15, maxSum(root));
		
		/**
		 *      5
		 *    /   \
		 *  -22    11
		 *  / \    / \
		 * 9  50  9   2
		 */
		
		root = new TreeNode(5);
		root.left = new TreeNode(-22);
		root.right = new TreeNode(11);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(50);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(2);
		assertEquals(33, maxSum(root));
	}

}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.value = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.value = val;
		this.left = left;
		this.right = right;
	}
}
