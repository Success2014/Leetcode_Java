package first;
import java.util.Queue;
import java.util.LinkedList;

public class invertBinaryTree {
	/**
	 * Recursive
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
	/**
	 * Iterative
	 * @param root
	 * @return
	 */
	public TreeNode invertTreeIter(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
	
	public static void main(String[] args) {
		invertBinaryTree ibt = new invertBinaryTree();
		TreeNode nd1 = new TreeNode(1);
		TreeNode nd2 = new TreeNode(2);
		TreeNode nd3 = new TreeNode(3);
		TreeNode nd4 = new TreeNode(4);
		TreeNode nd5 = new TreeNode(5);
		nd1.left = nd2;
		nd1.right = nd3;
		nd2.left = nd4;
		nd2.right = nd5;
		ibt.invertTreeIter(nd1);
	}

}
