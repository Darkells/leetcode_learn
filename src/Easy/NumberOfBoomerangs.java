package Easy;

import java.util.HashMap;

/**
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int result = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    //这里的距离就不做开平方处理
                    double distance = Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2);
                    if (!map.containsKey(distance)){
                        map.put(distance,1);
                    }else{
                        int n = map.get(distance);
                        result += 2 * n;
                        map.put(distance,1 + n);
                    }
                }
            }
            map.clear();
        }
        return result;
    }
}
