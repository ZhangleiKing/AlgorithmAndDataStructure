package dataStructure.binaryTree.nonRecursive;

import java.util.Stack;

public class PreOrder {

    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null || !stack.isEmpty()) {
            while(root!=null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            if(stack.size() > 0) {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
    }

    public static void main(String[] args) {
        preOrder(TreeFactory.getTree());
    }
}
