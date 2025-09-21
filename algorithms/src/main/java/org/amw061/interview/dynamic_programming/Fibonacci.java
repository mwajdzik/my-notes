package org.amw061.interview.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("started...");
        System.out.println(recursive(45));
        System.out.println(dynamicProgrammingBottomUp(45));
        System.out.println(dynamicProgrammingTopDown(45, new HashMap<>()));
    }

    private static int recursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return recursive(n - 2) + recursive(n - 1);
    }

    // Tabulation
    private static int dynamicProgrammingBottomUp(int n) {
        int[] m = new int[n + 1];
        m[1] = m[0] = 1;

        for (int i = 2; i <= n; i++) {
            m[i] = m[i - 2] + m[i - 1];
        }

        return m[n];
    }

    // Memoization
    private static int dynamicProgrammingTopDown(int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int result = dynamicProgrammingTopDown(n - 2, map) + dynamicProgrammingTopDown(n - 1, map);
        map.put(n, result);

        return result;
    }
}
