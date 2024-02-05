package com.leetcode._21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    Solution solution;

    SolutionTest() {
        solution = new Solution();
    }

    @Test
    public void withBothEmptyLists() {
        ListNode res = solution.mergeTwoLists(ListHelpers.fromArray(null), ListHelpers.fromArray(null));

        assertTrue(ListHelpers.Eq(ListHelpers.fromArray(null), res));
    }

    @Test
    public void withOneEmptyList() {
        ListNode res = solution.mergeTwoLists(ListHelpers.fromArray(null), ListHelpers.fromArray(new int[] {0}));

        assertTrue(ListHelpers.Eq(ListHelpers.fromArray(new int[] {0}), res));
    }

    @Test
    public void withBothNonEmptyLists() {
        ListNode res = solution.mergeTwoLists(ListHelpers.fromArray(new int[] {1, 2, 4}), ListHelpers.fromArray(new int[] {1, 3, 4}));

        assertTrue(ListHelpers.Eq(ListHelpers.fromArray(new int[] {1, 1, 2, 3, 4, 4}), res));
    }

    // Testing helpers
    @Nested
    class ListHelpersTest {
        @Nested
        class FromArrayTest {
            @Test
            public void withEmptyArray() {
                assertNull(ListHelpers.fromArray(new int[] {}));
            }

            @Test
            public void withNullArray() {
                assertNull(ListHelpers.fromArray(null));
            }

            @Test
            public void withNonEmptyArray() {
                ListNode list = new ListNode(1, new ListNode(2, new ListNode(3)));

                assertTrue(ListHelpers.Eq(list, ListHelpers.fromArray(new int[] {1, 2, 3})));
            }
        }

        @Nested
        class EqTest {
            @Test
            public void withBothEmptyList() {
                assertTrue(ListHelpers.Eq(null, null));
            }

            @Test
            public void whenOnlyLeftListIsNull() {
                assertFalse(ListHelpers.Eq(null, new ListNode(1)));
            }

            @Test
            public void whenOnlyRightListIsNull() {
                assertFalse(ListHelpers.Eq(new ListNode(1), null));
            }

            @Test 
            public void whenListsHaveDifferentElements() {
                assertFalse(ListHelpers.Eq(new ListNode(1, new ListNode(2)), new ListNode(1, new ListNode(3))));
            }

            @Test
            public void whenListsHaveDifferntLength() {
                assertFalse(ListHelpers.Eq(new ListNode(1, new ListNode(2)), new ListNode(1)));
            }

            @Test
            public void whenListsHaveSimilarElements() {
                assertTrue(ListHelpers.Eq(new ListNode(1, new ListNode(2)), new ListNode(1, new ListNode(2))));
            }
        }
    }
}

// Helpers

class ListHelpers {
    static ListNode fromArray(int[] nums) {
        if (nums == null) {
            return null;
        }

        ListNode head = null, prev = null;

        for(int num : nums) {
            ListNode curr = new ListNode(num);
            if (prev == null) {
                head = curr;
            } else {
                prev.next = curr;
            }

            prev = curr;
        }
        return head;
    }

    static boolean Eq(ListNode list1, ListNode list2) {
        if (list1 == list2) { // Either both of them are null or they point to the same list.
            return true;
        }

        if (list1 == null || list2 == null) {
            return false;
        }

        return (list1.val == list2.val && Eq(list1.next, list2.next));
    }
}