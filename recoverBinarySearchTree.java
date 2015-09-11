package first;

/**
 * http://huntfor.iteye.com/blog/2077665
 * http://blog.sina.com.cn/s/blog_eb52001d0102v1z3.html
 * @author Neo
 *
 */
public class recoverBinarySearchTree {
	TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        //traverse to find these two nodes
        traverse(root);
        //swap 
        int tmp = secondElement.val;        
        secondElement.val = firstElement.val;
        firstElement.val = tmp;
        /*TreeNode tmp = new TreeNode(secondElement.val);
        secondElement.val = firstElement.val;
        firstElement.val = tmp.val;*/
    }
    public void traverse(TreeNode root){
        if (root == null){
            return;
        }
        traverse(root.left);
        if (firstElement == null && lastElement.val > root.val){
            firstElement = lastElement;
        }
        if (firstElement != null && lastElement.val > root.val){
            secondElement = root;
        }
        lastElement = root;
        traverse(root.right);
    }
    
    public static void main (String[] args){
    	recoverBinarySearchTree rbst = new recoverBinarySearchTree();
    	TreeNode node0 = new TreeNode(0);
    	TreeNode node1 = new TreeNode(1);
    	node0.left = node1;
    	rbst.recoverTree(node0);
    	System.out.println(node1.val);
    	System.out.println(node0.val);
    }

}
