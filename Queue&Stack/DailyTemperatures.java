import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * @author Zechen Liu
 * @date 2022/04/07
 **/
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] ans = dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println(Arrays.toString(ans));// [1,1,4,2,1,1,0,0]
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
