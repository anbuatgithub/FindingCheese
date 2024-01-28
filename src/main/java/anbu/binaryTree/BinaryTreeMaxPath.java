package anbu.binaryTree;

import java.util.*;

public class BinaryTreeMaxPath {
    public static void main(String[] args) {

        BinaryTree one = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);
        BinaryTree three = new BinaryTree(3);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);

        one.left=two;
        one.right=three;

        two.left=four;
        two.right=five;

        three.left=six;
        three.right=seven;

        //List<Integer> maxSumArray = BinaryTree.findMaxSum(one);
        //System.out.println(maxSumArray.get(1));

        BinaryTree b1 = new BinaryTree(1);
        BinaryTree b2 = new BinaryTree(2);
        BinaryTree b3 = new BinaryTree(3);

        b1.left = b2;
        b1.right =b3;

       // System.out.println(b1.maxPathSum());


        BinaryTree t1 = new BinaryTree(1);
        BinaryTree t2 = new BinaryTree(2);
        BinaryTree t3 = new BinaryTree(3);
        BinaryTree t4 = new BinaryTree(4);
        BinaryTree t5 = new BinaryTree(5);
        BinaryTree t6 = new BinaryTree(6);
        BinaryTree t7 = new BinaryTree(7);

        //https://www.algoexpert.io/questions/max-path-sum-in-binary-tree

        t1.left = t2;
        t1.right= t3;

        t2.left = t4;
        t2.right= t5;

        t3.left = t6;
        t3.right = t7;

        System.out.println(t1.maxPathSum());

    }
}


class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    private int max = Integer.MIN_VALUE;

    public BinaryTree(int data) {
        this.value = data;
    }

    public static int maxPathSum3(BinaryTree tree) {
        List<Integer> maxSumArray = findMaxSum(tree);
        return maxSumArray.get(1);
    }

    public static List<Integer> findMaxSum(BinaryTree tree) {
        if (tree == null) {
            return new ArrayList<Integer>(Arrays.asList(0, Integer.MIN_VALUE));
        }
        List<Integer> leftMaxSumArray = findMaxSum(tree.left);
        Integer leftMaxSumAsBranch = leftMaxSumArray.get(0);
        Integer leftMaxPathSum = leftMaxSumArray.get(1);
        List<Integer> rightMaxSumArray = findMaxSum(tree.right);
        Integer rightMaxSumAsBranch = rightMaxSumArray.get(0);
        Integer rightMaxPathSum = rightMaxSumArray.get(1);
        Integer maxChildSumAsBranch =
                Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
        Integer maxSumAsBranch =
                Math.max(maxChildSumAsBranch + tree.value, tree.value);
        Integer maxSumAsRootNode = Math.max(
                leftMaxSumAsBranch + tree.value + rightMaxSumAsBranch, maxSumAsBranch);

        int maxPathSum =
                Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode));
        return new ArrayList<Integer>(Arrays.asList(maxSumAsBranch, maxPathSum));
    }



    public  int maxPathSum(){
        postOrder(this);
        return max;
    }

    private  int postOrder(BinaryTree tree) {
        if(tree ==null){
            return 0;
        }
        int left = Math.max(postOrder(tree.left),0);
        int right = Math.max(postOrder(tree.right),0);
        max = Math.max(max,left+right+tree.value);
        return Math.max(left,right)+ tree.value;
    }


}