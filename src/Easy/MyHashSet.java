package Easy;

/**
 * @author Dark
 * @date 2019/5/20 9:45
 */

/**
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 * 注意：
 *
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 */
public class MyHashSet {
    int[] data = null;
    public MyHashSet(){
        data = new int[1000001];
        for (int i = 0;i < data.length; i++){
            data[i] = -1;
        }
    }

    public void add(int key){
        data[key] = key;
    }

    public void remove(int key){
        data[key] = -1;
    }

    public boolean contains(int key){
        return data[key] == -1 ? false : true;
    }

//    private boolean[] nums;
//
//    /** Initialize your data structure here. */
//    public MyHashSet() {
//        nums = new boolean[1000001];
//    }
//
//    public void add(int key) {
//        nums[key] = true;
//    }
//
//    public void remove(int key) {
//        nums[key] = false;
//    }
//
//    /** Returns true if this set contains the specified element */
//    public boolean contains(int key) {
//        return nums[key];
//    }
}
