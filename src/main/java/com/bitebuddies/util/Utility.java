package com.bitebuddies.util;

import java.util.Random;

public final class Utility {
    /**
     * Generate a random integer for given min and max values, both inclusive.
     *
     * @param min - Lower bound (inclusive)
     * @param max - Upper bound (inclusive)
     * @return A random integer
     */
    public static int generateRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range, min should be less than or equal to max");
        }

        Random random = new Random();
        // Using nextInt(max - min + 1) + min to include both min and max in the range
        return random.nextInt(max - min + 1) + min;
    }
}
