package first;
import java.util.*;
public class treeTraversal2 {
	public void inorderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraverse(root.left);
		System.out.print(root.val);
		inorderTraverse(root.right);
	}
	
	public void stackInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				TreeNode temp = stack.pop();
				System.out.print(temp.val);
				root = temp.right;
			}
		}
	}
	
	public void preorderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val);
		preorderTraverse(root.left);
		preorderTraverse(root.right);
		
	}
	
	public void stackPreorder(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val);
			if (node.right != null) {
				stack.push(node.right);
			} 
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}	
	
	public void postorderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		postorderTraverse(root.left);
		postorderTraverse(root.right);
		System.out.print(root.val);
	}
	
	public void stackPostorder(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curt = stack.peek();
			if (prev == null || curt == prev.left || curt == prev.right) {//traverse down
				if (curt.left != null) {
					stack.push(curt.left);
				} else if (curt.right != null) {
					stack.push(curt.right);
				} else {//leaf
					System.out.print(curt.val);
					stack.pop();
				}
			} else if (curt.left == prev) { // traverse from left
				if (curt.right != null) {
					stack.push(curt.right);
				} else { // no right child
					System.out.print(curt.val);
					stack.pop();
				}
			} else if (curt.right == prev) { // traverse from right
				System.out.print(curt.val);
				stack.pop();
			}
			
			prev = curt;
		}
	}
	
	public void levelTraverse(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0 ; i < size; i++) {
				TreeNode node = queue.poll();
				System.out.print(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			System.out.print(" ");
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
		/*
		 *     4
		 *    /
		 *   5
		 *    \
		 *     6
		 */
		/*node4.left = node5;
		node5.right = node6;*/
		
		treeTraversal2 tt = new treeTraversal2();
		System.out.print("Inorder Rcur: ");tt.inorderTraverse(node4);//1234567
		System.out.println();		
		System.out.print("Inorder Iter: ");tt.stackInorder(node4);//1234567
		System.out.println();
		System.out.print("Preorder Rcur: ");tt.preorderTraverse(node4);//4213657
		System.out.println();
		System.out.print("Preorder Iter: "); tt.stackPreorder(node4);//4213657
		System.out.println();
		System.out.print("Postorder Rcur: ");tt.postorderTraverse(node4);//1325764
		System.out.println();		 
		System.out.print("Postorder Iter: ");tt.stackPostorder(node4);//1325764
		//System.out.println();
		//System.out.print("Postorder Iter: ");tt.twoStackPostorder(node4);//1325764
		System.out.println();
		System.out.print("Level Iter: ");tt.levelTraverse(node4);//4261357
	}

}
