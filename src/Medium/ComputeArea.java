package Medium;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 *
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 *
 *
 *
 * 示例:
 *
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/10/3 16:12
 */
public class ComputeArea {
    /**
     *
     * @param A     x1
     * @param B     y1
     * @param C     x2
     * @param D     y2
     * @param E     x3
     * @param F     y3
     * @param G     x4
     * @param H     y4
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //两矩形不重叠
        if(E>C || A>G) return (C-A)*(D-B)+(G-E)*(H-F);

        if(F>D || H<B) return (C-A)*(D-B)+(G-E)*(H-F);
        int length = Math.min(C,G) - Math.max(A,E);
        int width = Math.min(D,H) - Math.max(B,F);
        return (C-A)*(D-B)+(G-E)*(H-F)-length * width;
    }
}
