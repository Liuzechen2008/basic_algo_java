import java.util.*;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * @author Zechen Liu
 * @date 2022/04/08
 **/
public class FindWhetherExistsPath {
    public static void main(String[] args) {
        int[][] ns1 = {
                {0, 1},
                {1, 2},
                {2, 1},
        };
        int[][] ns2 = {
                {0, 1},
                {1, 2},
                {2, 1},
                {2, 3},
        };
        System.out.println(findWhetherExistsPath(4, ns1, 0, 3));
        System.out.println(findWhetherExistsPath(4, ns2, 0, 3));
    }

    private static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : graph) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new ArrayList<>());
            }
            map.get(p[0]).add(p[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int st = queue.poll();
                List<Integer> list = map.get(st);
                if (list != null) {
                    for (int num : list) {
                        if (num == target) {
                            return true;
                        }
                        queue.add(num);
                    }
                    map.put(st, null);//avoid self cycles to prevent an endless loop
                }
            }
        }
        return false;
    }
}
