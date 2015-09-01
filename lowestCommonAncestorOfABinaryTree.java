package first;

public class lowestCommonAncestorOfABinaryTree {
	/**
	 * bottom up O(n)
	 * (1)if find LCA, then return LCA
	 * (2)if only find A, then return A
	 * (3)if only find B, then return B
	 * (4)else return null
	 * Note, a node can be its parent itself
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null){//both not null, must be root
            return root;
        }
        else if (left != null){//right is null, must be in left
            return left;
        }
        else if (right != null){//left is null, must be in right
            return right;
        }
        else{//no LCA in this subtree with current root
            return null;
        }
    }

}
