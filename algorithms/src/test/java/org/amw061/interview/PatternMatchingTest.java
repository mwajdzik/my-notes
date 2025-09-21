package org.amw061.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PatternMatchingTest {

    private final PatternMatching patternMatching = new PatternMatching();

    @Test
    void matches() {
        assertTrue(patternMatching.matches("ab", "a*b*"));
        assertTrue(patternMatching.matches("aaa", "aaa"));
        assertTrue(patternMatching.matches("aaa", "a*"));
        assertTrue(patternMatching.matches("xaaabyc", "xa*b.c"));
        assertFalse(patternMatching.matches("xafabyc", "xa*b.c"));
        assertTrue(patternMatching.matches("aaabbb", "a*b*"));
        assertTrue(patternMatching.matches("aaa", "a*b*"));
        assertTrue(patternMatching.matches("bbb", "a*b*"));
        assertFalse(patternMatching.matches("ccc", "a*b*"));
        assertFalse(patternMatching.matches("aaabbbc", "a*b*"));
        assertFalse(patternMatching.matches("aaa", ""));
        assertFalse(patternMatching.matches("", "aaa"));
    }
}