package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Dark
 * @2019/8/16 15:30
 */
public class RestoreIpAddresses {
    public static List<String> restoreIpAddresses(String s) {
        //还是先暴力遍历吧，或者叫迭代法
        int n = s.length();
        List<String> ret = new ArrayList<String>();
        if(n<4){
            return ret;
        }
        for(int i=0; i <= n-4&&i < 3 ; i++){
            for(int j=i+1; j <= n-3&&j < i+4; j++){
                for(int k = j+1; k <= n-2&&k < j+4;k++){
                    StringBuilder sb = new StringBuilder();
                    String temp1 = s.substring(0,i+1);
                    String temp2 = s.substring(i+1,j+1);
                    String temp3 = s.substring(j+1,k+1);
                    String temp4 = s.substring(k+1);
                    if(isOk(temp1)&&isOk(temp2)&&isOk(temp3)&&isOk(temp4)){
                        sb.append(temp1).append(".").append(temp2).append(".").append(temp3).append(".").append(temp4);
                        ret.add(sb.toString());
                    }
                }
            }
        }
        return ret;

    }
    private static boolean isOk(String s){
        int n = s.length();
        if(n>3){
            return false;
        }
        if(n > 1&&s.startsWith("0")){
            return false;
        }
        if(n==3){
            if(Integer.parseInt(s)>255){
                return false;
            }
        }
        return true;
    }
}
