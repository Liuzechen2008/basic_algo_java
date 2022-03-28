import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack.
 * Follow Up: Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 * You should delete the sub-stack when it becomes empty. pop, popAt should return -1 when there's no element to pop.
 *
 * @author Zechen Liu
 * @date 2022/03/28
 **/
public class StackOfPlates {
    int capacity;
    List<Deque<Integer>> allPlates;

    public StackOfPlates(int cap) {
        this.capacity = cap;
        allPlates = new LinkedList<>();
    }

    public void push(int val) {
        if (capacity <= 0) {
            return;
        }
        //if no stack or stack is full, new stack
        if (allPlates.isEmpty() || allPlates.get(allPlates.size() - 1).size() == capacity) {
            allPlates.add(new ArrayDeque<>());
        }
        allPlates.get(allPlates.size() - 1).push(val);
    }

    public int pop() {
        if (allPlates.size() == 0) {
            return -1;
        }
        int result = allPlates.get(allPlates.size() - 1).pop();
        //remove empty stack
        if (allPlates.get(allPlates.size() - 1).size() == 0) {
            allPlates.remove(allPlates.size() - 1);
        }
        return result;
    }

    public int popAt(int index) {
        if (index < 0 || index >= allPlates.size() || allPlates.isEmpty()) {
            return -1;
        }
        int result = allPlates.get(index).pop();
        if (allPlates.get(index).size() == 0) {
            allPlates.remove(index);
        }
        return result;
    }
}
