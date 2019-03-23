package Easy;

/**
 * @author Dark
 * @date 2019/3/22 16:18
 */
public class MySqrt {
    public static int mySqrt(int x){
        if (x == 0)
            return 0;
        if (x <= 3){
            return 1;
        }
        for(long i = 1;i <= (x/2)+1;i++){
            if((i*i) > x){
                return (int)i - 1;
            }else if((i*i) == x){
                return (int)i;
            }
        }
        return 0;
    }

    public static void main(String[] args){

    }
}
