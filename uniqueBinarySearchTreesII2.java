package first;
import java.util.List;
import java.util.ArrayList;

public class uniqueBinarySearchTreesII2 {
	public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end){
            res.add(null);
            return res;
        }
        
        for (int i = start; i <= end; i++){
            List<TreeNode> lefts = helper(start, i - 1);
            List<TreeNode> rights = helper(i + 1, end);
            for (TreeNode left: lefts){
                for (TreeNode right: rights){
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
