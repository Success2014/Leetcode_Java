package first;
import java.util.*;
public class binaryTreePaths2 {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        String path = "";
        if (root == null) {
            return res;
        }
        dfs(root, res, path);
        return res;
    }
    public void dfs(TreeNode root, List<String> res, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, res, path + root.val + "->");
        }
        if (root.right != null) {
            dfs(root.right, res, path + root.val + "->");
        }
    }

}
