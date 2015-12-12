package first;

public class lowestCommonAncestorOfABinarySearchTree3 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) {
            return root;
        } else if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }

}
