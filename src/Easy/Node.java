package Easy;

import java.util.List;

/**
 * @author Dark
 * @date 2019/5/6 9:16
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
