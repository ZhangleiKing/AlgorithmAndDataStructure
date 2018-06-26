package dataStructure.binaryTree;

import java.util.Stack;

public class InOrder {

    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null || !stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            if(stack.size() > 0) {
                TreeNode node = stack.pop();
                System.out.println(node.val);
                root = node.right;
            }
        }
    }

    public static void main(String[] args) {
        inOrder(TreeFactory.getTree());
    }
}
