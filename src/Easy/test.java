package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import Easy.LargeGroupPositions.*;

public class test{

    public static void main(String[] args){
        String a = "123";
        String b = "123";
        System.out.println(a == b);
        System.out.println(a.equals(b));
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
