package first;
import java.util.*;
public class uniqueBinarySearchTreesII3 {
	public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    public ArrayList<TreeNode> dfs(int start, int end) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> lefts = dfs(start, i - 1);
            ArrayList<TreeNode> rights = dfs(i + 1, end);
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
