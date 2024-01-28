package anbu.binaryTree;

public class ValidBinaryTree {

    public static BST prev=null;
    public static boolean val=true;

    public static void main(String[] args) {




        BST ten = new BST(10);
        BST five = new BST(5);
        BST fifteen = new BST(15);
        BST two = new BST(2);
        BST five2 = new BST(6);

        BST one = new BST(1);
        BST thirteen = new BST(13);
        BST twentyTwo = new BST(22);
        BST forteen = new BST(14);

        ten.left = five;
        ten.right = fifteen;

        five.left = two;
        five.right = five2;

        two.left = one;
        fifteen.left = thirteen;
        fifteen.right = twentyTwo;
        thirteen.right = forteen;

        System.out.println(validateBST(ten, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    public static Boolean validateBST(BST tree, int min, int max) {
        if (tree == null) {
            return true;
        }
        if (tree.value < min || tree.value >= max) {
            return false;
        }
        Boolean isLeftValid = validateBST(tree.left,min,tree.value);
        Boolean isRightValid = validateBST(tree.right,tree.value,max);
        return isLeftValid && isRightValid;
    }



    public static boolean validateBst(BST root) {
        prev = null;
        validateBst1(root);
        return val;
    }
    public static void validateBst1(BST root) {
        if (root != null) {
            validateBst1(root.left);
            if (prev != null && root.value < prev.value)
                val = false;
            prev = root;
            validateBst1(root.right);
        }

    }

}




