package dataStructure.binaryTree;

/**
 * Created by Vincent on 2018/6/25.
 */
public class TreeFactory {

    public static TreeNode getTree() {
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(3);
        TreeNode r = new TreeNode(8);
        TreeNode tmpl = l, tmpr = r;
        root.left = l;
        root.right = r;
        l = new TreeNode(2);
        r = new TreeNode(4);
        tmpl.left = l;
        tmpl.right = r;
        tmpl = l;
        l = new TreeNode(1);
        tmpl.left = l;
        l = new TreeNode(7);
        r = new TreeNode(9);
        tmpr.left = l;
        tmpr.right = r;
        tmpr = r;
        r = new TreeNode(10);
        tmpr.right = r;
        return root;
    }

    public static void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        inOrder(getTree());
    }
}
