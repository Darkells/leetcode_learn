package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 *
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 *
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：N = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 *
 * 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 *  
 *
 * 提示：
 *
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * 不存在花园有 4 条或者更多路径可以进入或离开。
 * 保证存在答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flower-planting-with-no-adjacent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GardenNoAdj {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[][] topo = new int[N+1][3] ;
        for( int[] cur : paths ){
            int temp = 0 ;
            while( topo[cur[0]][temp] != 0 ) temp++ ;
            topo[cur[0]][temp] = cur[1] ;
            temp = 0 ;
            while( topo[cur[1]][temp] != 0 ) temp++ ;
            topo[cur[1]][temp] = cur[0] ;
        }
        int[] res1 = new int[N+1] ;
        int[] res = new int[N] ;
        for( int i = 1 ; i <= N ; i++ ){
            int temp = 1 ;
            while( res1[topo[i][0]] == temp || res1[topo[i][1]] == temp || res1[topo[i][2]] == temp ) temp++ ;
            res1[i] = temp ;
        }
        for( int i = 0 ; i < N ; i++ ) res[i] = res1[i+1] ;
        return res ;
    }

    public int[] gardenNoAdj2(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++)
            graph.put(i, new HashSet<>());
        for (int[] path: paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            for (int adj: graph.get(i))
                used[res[adj]] = true;
            for (int j = 1; j <= 4; j++)
                if (!used[j])
                    res[i] = j;
        }
        return res;
    }
}
