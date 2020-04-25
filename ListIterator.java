// Time Complexity : O(n) for craeting a queue, O(1) for both operations
// Space Complexity : O(n) for queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ListIterator {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
     class NestedIterator implements Iterator<Integer> {
        Queue<Integer> q;
        public NestedIterator(List<NestedInteger> nestedList) {
            q = new LinkedList<>();
            addAll(nestedList);
        }

        private void addAll(List<NestedInteger> nestedList){
            for(NestedInteger n : nestedList){
                if(n.isInteger()){
                    q.add(n.getInteger());
                } else {
                    addAll(n.getList());
                }
            }
        }
        @Override
        public Integer next() {
            return !q.isEmpty() ? q.poll() : -1;
        }

        @Override
        public boolean hasNext() {
            return !q.isEmpty();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
