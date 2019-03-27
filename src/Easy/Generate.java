package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dark
 * @date 2019/3/27 23:24
 */

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //生成numRows行的list来存放数组
        for (int i = 0;i < numRows;i++){
            //子数组
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0;j <= i;j++){
                //特殊情况 第一行和第二行 下标分别为0、1
                if(j == 0 || j == i){
                    //数组里加 1
                    list.add(1);
                }else{
                    //其他情况就左右数字相加
                    list.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
                }
            }
            res.add(list);
        }
        return res;
    }
}
