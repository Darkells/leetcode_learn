package Medium;

import java.util.*;

/**
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 * 格式
 *
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 *
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 *
 * 示例 1:
 *
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * 输出: [1]
 * 示例 2:
 *
 * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * 输出: [3, 4]
 * 说明:
 *
 *  根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        // 特判
        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        // 入度数组，每一次要把入度为 1 的结点剔除
        int[] inDegrees = new int[n];

        // 默认为 False，如果剔除，设置为 True
        boolean[] result = new boolean[n];

        // 因为是无向图，所以邻接表拿出一条边，两个结点都要存一下
        // 注意：右边就不要写具体的实现类了，等到实例化的时候再写具体的实现类
        Set<Integer>[] adjs = new Set[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            adjs[i] = new HashSet<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adjs[start].add(end);
            adjs[end].add(start);
            inDegrees[start] += 1;
            inDegrees[end] += 1;
        }
        LinkedList<Integer> queue = new LinkedList<>();

        // 入度为 1 的结点入队
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 1) {
                queue.addLast(i);
            }
        }

        // 注意边界条件 n == 2 和 n == 1 是如何分析出来的
        while (n > 2) {
            int size = queue.size();
            System.out.println(queue);
            // 一次减去这么多
            n -= size;
            for (int i = 0; i < size; i++) {
                int top = queue.removeFirst();
                result[top] = true;
                inDegrees[top] -= 1;
                // 把它和它的邻接结点的入度全部减 1
                Set<Integer> successors = adjs[top];
                for (Integer successor : successors) {
                    inDegrees[successor] -= 1;
                    if (inDegrees[successor] == 1) {
                        queue.addLast(successor);
                    }
                }
            }
        }
        n = result.length;
        for (int i = 0; i < n; i++) {
            if (!result[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
