package org.amw061.interview;

public class PatternMatching {

    public boolean matches(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        boolean[][] t = new boolean[n + 1][m + 1];

        // empty string matches empty pattern
        t[0][0] = true;

        // to deal with patterns like a*, a*b*
        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                t[0][j] = t[0][j - 2];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // if characters match or ., use the calculated value for a substring
                if (pattern.charAt(j - 1) == text.charAt(i - 1) || pattern.charAt(j - 1) == '.') {
                    t[i][j] = t[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    t[i][j] = t[i][j - 2];
                    if (pattern.charAt(j - 2) == text.charAt(i - 1) || pattern.charAt(j - 2) == '.') {
                        t[i][j] = t[i][j] || t[i - 1][j];
                    }
                } else {
                    t[i][j] = false;
                }
            }
        }

        return t[n][m];
    }
}
