package lintcode_528;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lenovo on 2017/11/7.
 */


public class Main implements Iterator<Integer> {
    List<Integer> integers;
    int position = 0;

    public Main(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        integers = new ArrayList();
        for (NestedInteger nInt : nestedList) {
            flat(nInt);
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        return integers.get(position++);
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        if (position < integers.size()) return true;
        return false;

    }

    @Override
    public void remove() {
    }

    private void flat(NestedInteger nInt) {
        if (nInt.isInteger()) {
            integers.add(nInt.getInteger());
            return;
        }
        List<NestedInteger> ints = nInt.getList();

        for (NestedInteger nI : ints) {
            flat(nI);
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
