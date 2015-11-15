package first;

public class convertSortedListToBinarySearchTree2 {
	private ListNode list;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = findLength(head);
        list = head;
        return helper(0, len - 1);
    }
    public TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = helper(start, mid - 1);
        TreeNode root = new TreeNode(list.val);
        root.left = left;
        list = list.next;
        TreeNode right = helper(mid + 1, end);
        root.right = right;
        return root;
    }
    public int findLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

}
