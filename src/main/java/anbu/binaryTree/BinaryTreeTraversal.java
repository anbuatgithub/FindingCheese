package anbu.binaryTree;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode twenty = new TreeNode(20);
        TreeNode thirty = new TreeNode(30);
        TreeNode forty = new TreeNode(40);
        TreeNode fifty = new TreeNode(50);
        TreeNode sixty = new TreeNode(60);
        TreeNode seventy = new TreeNode(70);
        TreeNode eighty = new TreeNode(80);
        TreeNode ninety = new TreeNode(90);
        TreeNode hundred = new TreeNode(100);
        TreeNode onetwenty = new TreeNode(120);


        eighty.left = forty;
        eighty.right = onetwenty;

        forty.left = twenty;
        forty.right = sixty;

        onetwenty.left = hundred;

        twenty.right = thirty;

        sixty.left = fifty;
        sixty.right = seventy;

        hundred.left = ninety;

        //printin binary tree using preorder, ininorder, postorder
        //eighty.preOrder();
       // eighty.inOrder();
        eighty.postOrder();


        TreeNode node80= new TreeNode(80);
        node80.insert(40);
        node80.insert(120);
        node80.insert(20);
        node80.insert(30);
        node80.insert(60);
        node80.insert(50);
        node80.insert(70);
        node80.insert(100);
        node80.insert(90);

       // eighty.inOrder();

        //System.out.println(eighty.contains(50));


    }
}


class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }


    public void preOrder() {
        System.out.println(this.data);

        if (left != null) {
            left.preOrder();

        }

        if (right != null) {
            right.preOrder();
        }
    }


    public void inOrder() {

        if (left != null) {
            left.inOrder();
        }

        System.out.println(this.data);

        if (right != null) {
            right.inOrder();
        }

    }

    public void postOrder() {
        if (left != null) {
            left.postOrder();
        }

        if (right != null) {
            right.postOrder();
        }

        System.out.println(this.data);

    }

    public void insert(int value) {
        if (value <= data) {
            if(left == null ){
                left = new TreeNode(value);
            }else{
                left.insert(value);
            }

        } else {
            if(right == null ){
                right = new TreeNode(value);
            }else{
                right.insert(value);
            }
        }

    }

    public Boolean contains(int i) {
        if (data == i) {
            return true;
        } else if(i <data){
            if(left == null){
                return false;
            }else{
                return left.contains(i);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(i);
            }

        }

    }
}