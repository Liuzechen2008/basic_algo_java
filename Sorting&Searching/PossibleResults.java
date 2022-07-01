import java.util.ArrayList;
import java.util.List;

/**
 * Given a string expression of numbers and operators,
 * return all possible results from computing all the different possible ways to group numbers and operators.
 * You may return the answer in any order.
 *
 * @author Zechen Liu
 * @date 2022/07/01
 **/
public class PossibleResults {
    private static char[] expressionCharArray;

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("73"));//[73]
        System.out.println(diffWaysToCompute("2*3-4*5"));//[-34, -10, -14, -10, 10]
    }

    private static List<Integer> diffWaysToCompute(String expression) {
        expressionCharArray = expression.toCharArray();
        return dfs(0, expressionCharArray.length);
    }

    private static List<Integer> dfs(int first, int last) {
        List<Integer> ans = new ArrayList<>();
        for (int i = first; i < last; i++) {
            if (Character.isDigit(expressionCharArray[i])) {
                continue;
            }
            List<Integer> leftList = dfs(first, i);
            List<Integer> rightList = dfs(i + 1, last);

            for (int left : leftList) {
                for (int right : rightList) {
                    if (expressionCharArray[i] == '+') {
                        ans.add(left + right);
                    } else if (expressionCharArray[i] == '-') {
                        ans.add(left - right);
                    } else {
                        ans.add(left * right);
                    }
                }
            }
        }

        if (ans.isEmpty()) {
            int cur = 0;
            for (int i = first; i < last; i++) {
                cur = cur * 10 + Character.getNumericValue(expressionCharArray[i]);
            }
            ans.add(cur);
        }
        return ans;
    }
}
