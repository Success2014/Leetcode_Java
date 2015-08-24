package first;

import java.util.List;
import java.util.ArrayList;

public class binaryTreePaths {
	public List<String> binaryTreePathsC(TreeNode root) {
        List<String> res = new ArrayList<String>();
        String path = "";
        if (root != null) {
            dfs(root, res, path);
        }
        return res;
        
    }
    public void dfs(TreeNode node, List<String> res, String path){
        if (node.left == null && node.right ==null) res.add(path + Integer.toString(node.val));
        if (node.left != null) dfs(node.left, res, path + Integer.toString(node.val) + "->");
        if (node.right != null) dfs(node.right, res, path + Integer.toString(node.val) + "->");
        
    }

}
