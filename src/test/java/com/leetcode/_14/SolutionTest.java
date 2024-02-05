package com.leetcode._14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;;

public class SolutionTest {
    
    Solution s;

    SolutionTest() {
        s = new Solution();
    }

    @Nested
    public class CommonPrefixTest {

        @Test
        public void shouldReturnFullInputString() {
            assertEquals("abcd", s.commonPrefix("abcd", "abcd"));
        }

        @Test
        public void shouldReturnFirstInputString() {
            assertEquals("abcd", s.commonPrefix("abcd", "abcde"));
        }

        @Test
        public void shouldReturnSecondInputString() {
            assertEquals("abcd", s.commonPrefix("abcde", "abcd"));
        }

        @Test
        public void shouldReturnEmptyString() {
            assertEquals("", s.commonPrefix("", "abcd"));
        }

    }

    @Nested
    public class LongestCommonPrefix {

        @Test
        @DisplayName("with single string it returns the full string as common prefix")
        public void singleString() {
            assertEquals("abcd", s.longestCommonPrefix(new String[]{ "abcd" }));
        }

        @Test
        @DisplayName("with multiple strings when they have common prefrix it returns only the common prefix substring")
        public void multipleStringWithCommonPrefix() {
            assertEquals("fl", s.longestCommonPrefix(new String[]{ "flower","flow","flight" }));
        }

        @Test
        @DisplayName("with multiple strings when they don't have common prefrix it returns empty string")
        public void multipleStringWithoutCommonPrefix() {
            assertEquals("", s.longestCommonPrefix(new String[]{ "dog","racecar","car" }));
        }
    }
}
