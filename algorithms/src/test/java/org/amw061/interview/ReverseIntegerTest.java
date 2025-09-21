package org.amw061.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    private final ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    void reverse() {
        assertEquals(4321, reverseInteger.reverse(1234));
        assertEquals(10305, reverseInteger.reverse(50301));
        assertEquals(0, reverseInteger.reverse(0));
        assertEquals(-12, reverseInteger.reverse(-21));
        assertEquals(-1, reverseInteger.reverse(-100));
        assertEquals(987654321, reverseInteger.reverse(123456789));
        assertEquals(987654321987654321L, reverseInteger.reverse(123456789123456789L));
    }
}