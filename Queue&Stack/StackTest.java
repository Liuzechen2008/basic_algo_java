/**
 * @author Zechen Liu
 * @date 2022/03/28
 **/
public class StackTest {
    public static void main(String[] args) {
        StackOfPlates stack = new StackOfPlates(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.popAt(0));
        System.out.println(stack.popAt(0));
        System.out.println(stack.popAt(0));
    }
}
