package kz.naik.bloom_filter.utils;

import java.util.Random;

public class RandomUtils {

    public static final Random random = new Random();

    public static String getRandomIin() {
        char[] arr = new char[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('0' + random.nextInt(10));
        }
        return new String(arr);
    }
}
