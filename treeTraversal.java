package first;

import java.util.Queue;
import java.util.LinkedList;

public class treeTraversal {
	public void inorderTraverse(TreeNode root){
		if (root == null) return;
		inorderTraverse(root.left);
		System.out.print(root.val);
		inorderTraverse(root.right);
	}
	public void preorderTraverse(TreeNode root){
		if (root == null) return;		
		System.out.print(root.val);
		preorderTraverse(root.left);
		preorderTraverse(root.right);
	}
	public void postorderTraverse(TreeNode root){
		if (root == null) return;		
		postorderTraverse(root.left);
		postorderTraverse(root.right);
		System.out.print(root.val);
	}
	
	public void levelTraverse(TreeNode root){
		if (root == null) return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()){
			TreeNode node = q.poll();
			System.out.print(node.val);
			if (node.left != null) q.offer(node.left);
			if (node.right != null) q.offer(node.right);
		}
	}
	
	/**
	 * Tree is like:
	 *            4
	 *          /  \
	 *         2    6
	 *        / \  / \
	 *       1  3 5   7 
	 * @param args
	 */
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node4.left = node2;
		node4.right = node6;
		node2.left = node1;
		node2.right = node3;
		node6.left = node5;
		node6.right = node7;
		
		treeTraversal tt = new treeTraversal();
		tt.inorderTraverse(node4);//1234567
		System.out.println();
		tt.preorderTraverse(node4);//4213657
		System.out.println();
		tt.postorderTraverse(node4);//1325764
		System.out.println();
		tt.levelTraverse(node4);//4261357
	}

}
