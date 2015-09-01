package first;

public class LowestCommonAncestorOfABinarySearchTree {
	/**
	 * O(logn)
	 * Compare p, q to root.
	 * If one is larger than root, the other is smaller than root, then return root.
	 * If both larger than root, must be in the right subtree.
	 * If both smaller than root, must be in the left subtree.
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        
        if ((p.val < root.val && root.val < q.val) || (p.val > root.val && root.val > q.val)){
            return root;
        }
        
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        
        throw new IllegalArgumentException("No");
    }
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
        
        
    }

}
