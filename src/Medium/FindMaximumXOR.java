package Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *
 * 你能在O(n)的时间解决这个问题吗？
 *
 * 示例:
 *
 * 输入: [3, 10, 5, 25, 2, 8]
 *
 * 输出: 28
 *
 * 解释: 最大的结果是 5 ^ 25 = 28.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaximumXOR {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int findMaximumXOR(int[] nums) {
        TreeNode root = new TreeNode(-1);
        for (int n : nums) {
            TreeNode node = root;
            for (int i = 31; i >= 0; i--) {
                if ((n &(1 << i)) == 0) {
                    if (node.left == null) {
                        node.left = new TreeNode(0);
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new TreeNode(1);
                    }
                    node = node.right;
                }
            }
            node.left = new TreeNode(n);
        }

        int max = 0;
        for (int n : nums) {
            TreeNode node = root;
            for(int i=31; i>=0; i--) {
                if ((n & (1<<i)) == 0) {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                }
            }
            int nn = node.left.val;
            max = Math.max(max, n ^ nn);
        }
        return max;
    }


    public int findMaximumXOR2(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i++) {
            mask = mask ^ (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            int temp = res | (1 << i);

            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}
