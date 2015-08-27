package first;

public class convertSortedListToBinarySearchTree {
	/**
	 * Use in order traversal. First construct the left part, then the root, at lat the right part.
	 * You can use simple case to verify, e.g., input is [0]. 
	 */	
	ListNode list;
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null){
            p = p.next;
            n++;
        }
        list = head;
        return dfs(0, n-1);
        
    }
    
    public TreeNode dfs(int start, int end){
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode leftChild = dfs(start, mid - 1);//will first get to the left most leaf
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = dfs(mid + 1, end);
        return parent;
    }

}
