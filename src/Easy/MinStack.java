package Easy;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
//题目的意思就是创建这个栈出来
public class MinStack {
    private int min_val = Integer.MIN_VALUE;
    private Stack<Integer> s = new Stack<>();

    public MinStack(){}

    public void push(int x){
        if (x <= min_val){
            s.push(min_val);
            min_val = x;
        }
        s.push(x);
    }

    public void pop(){
        if (s.pop() == min_val){
            min_val = s.pop();
        }
    }

    public int top(){
        return s.peek();
    }

    public int getMin(){
        return min_val;
    }
}
