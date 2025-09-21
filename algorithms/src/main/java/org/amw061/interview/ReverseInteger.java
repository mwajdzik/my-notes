package org.amw061.interview;

public class ReverseInteger {

    public long reverse(long n) {
        long result = 0;

        while (n != 0) {
            result = result * 10 + n % 10;
            n = n / 10;
        }

        return result;
    }
}
