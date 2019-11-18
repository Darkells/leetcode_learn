package test;

import java.util.Arrays;

public class PrintToMaxOfDigits {

    public void printToMaxOfDigits(int n) {
        if (n <= 0) {
            System.out.println("输入的n没有意义");
            return;
        }

        char[] number = new char[n];
        Arrays.fill(number, '0');

//        while(!incrementNumber(number)) {
//            printNumber(number);
//        }

        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, 0);
        }
    }


    //利用递归实现1到最大的n位数的全排列
    public void printToMaxOfNDigitsRecursively(char[] number, int n, int index) {
        if(index == n - 1){
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, index + 1);
        }
    }

    private boolean incrementNumber(char[] number) {
        boolean isOverflow = false; //判断是否溢出
        int nTakeOver = 0; //判断是否进位
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0 ; --i) {
            int nSum = number[i] - '0' + nTakeOver; //取到第i位的字符转换为数字 +进位符
            if(i == nLength - 1){ //末尾自加1
                ++nSum;
            }
            if(nSum >= 10){
                if(i == 0){
                    isOverflow = true;
                }else{
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            }else{
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;
    }

    private void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if(isBeginning0 && number[i]!='0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

}
