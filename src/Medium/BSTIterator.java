package Medium;

import Easy.TreeNode;

import java.util.Stack;

/**
 * @author Dark
 * @2019/9/24 14:09
 */
public class BSTIterator {
    Stack<Integer> stack = new Stack();
    public BSTIterator(TreeNode root) {

    }

    public int next() {
        return stack.pop();
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        stack.push(root.val);
        dfs(root.left);
    }
}
