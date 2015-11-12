package first;
import java.util.*;
public class binarySearchTreeIterator2 {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode root;

    public binarySearchTreeIterator2(TreeNode root) {
        this.root = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || root != null;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = new TreeNode(Integer.MIN_VALUE);
        while (hasNext()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                node = stack.pop();
                root = node.right;
                break;
            }
        }
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */