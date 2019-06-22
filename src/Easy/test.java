package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import Easy.LargeGroupPositions.*;

public class test{

    public static void main(String[] args){
        int[] A = {1,2,0,0};
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp += A[i] * Math.pow(10,A.length - 1 - i);
        }
        System.out.println(temp);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}


class Parent {
    Parent() {
        System.out.println("调用父类的Parent()构造方法");
    }
}

class SubParent extends Parent {
    SubParent() {
        System.out.println("调用子类的构造方法");
    }
}
