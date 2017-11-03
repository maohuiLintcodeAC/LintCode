package lintcode_612;

import java.util.*;

/**
 *
 设计一个数据结构实现在平均 O(1) 的复杂度下执行以下所有的操作。

 insert(val): 如果这个元素不在set中，则插入。

 remove(val): 如果这个元素在set中，则从set中移除。

 getRandom: 随机从set中返回一个元素。每一个元素返回的可能性必须相同。
 * Created by hooyee on 2017/10/25.
 */
public class Main {
    private HashMap<Integer, Integer> dataMap;
    private ArrayList<Integer> dataList;

    public Main() {
        dataMap = new HashMap<>();
        dataList = new ArrayList<>();
    }

    public boolean insert(int val) {
        // write your code here
        if (dataMap.containsKey(val)) {
            return false;
        }
        dataList.add(val);
        // key为数据，value记录数据的索引
        dataMap.put(val, dataList.size() - 1);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!dataMap.containsKey(val)) {
            return false;
        }
        int index = dataMap.get(val);
        // 将list中的对应元素删除，并将最后一个元素填补过来
        // 若只有一个元素则不需要执行填补操作
        if (dataList.size() > 1) {
            dataList.set(index, dataList.get(dataList.size() - 1));
            dataMap.put(dataList.get(index), index);
        }
        dataList.remove(dataList.size() - 1);
        // 在map中删除对应元素，并将list中最后一个元素在map中对应的value值改变
        dataMap.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        int length = dataList.size();
        if (length == 0) return -1;
        Random random = new Random();
        int i = random.nextInt(length);
        System.out.println("random: " + i);
        return dataList.get(i);
    }

    public static void main(String[] args) {

          Main obj = new Main();
          boolean param = obj.insert(1);
          boolean f = obj.remove(1);
          int f1 = obj.getRandom();

          System.out.println(param);
          System.out.println(f);
          System.out.println(f1);

    }
}

