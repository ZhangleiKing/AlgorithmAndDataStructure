package dataStructure.binaryTree.nonRecursive;

import java.util.Stack;

public class PostOrder {

    /**
     * 对于后序遍历，只有当左孩子和右孩子都已经被访问后，才能访问root
     * @param root
     */
    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if(tmp.left==null && tmp.right==null) {
                System.out.println(tmp.val);
            }else {
                stack.push(tmp);
                if(tmp.right != null) {
                    stack.push(tmp.right);
                    tmp.right = null;
                }
                if(tmp.left != null) {
                    stack.push(tmp.left);
                    tmp.left = null;
                }
            }
        }
    }

    public static void postOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();//output用于存储后序遍历的路径
        while(root!=null || stack.size()>0) {
            if(root!=null) {
                stack.push(root);
                output.push(root);
                root = root.right;
            }else {
                root = stack.pop();
                root = root.left;
            }
        }

        while(output.size()>0) {
            System.out.println(output.pop().val);
        }
    }


    public static void main(String[] args) {
        postOrder2(TreeFactory.getTree());
    }
}
