package New2024.Daily;

public class Daily0221 {

    int pos = 0, in = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pos = postorder.length;
        in = inorder.length - 1;
        return preOrder(inorder, postorder, Integer.MAX_VALUE);
    }

    public TreeNode preOrder(int[] ins, int[] post, int stop) {

        if (pos == 0) {
            return null;
        }

        if (ins[in] == stop) {
            --in;
            return null;
        }
        int val = post[--pos];
        TreeNode node = new TreeNode(val);
        node.right = preOrder(ins, post, val);
        node.left = preOrder(ins, post, stop);
        return node;
    }
}
