package kz.naik.bloom_filter;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemoryTest {

    static final int SIZE = 20_000_000;

    public static void main(String[] args) throws Exception {
        System.out.println("Java version: " + ManagementFactory.getRuntimeMXBean().getVmVersion());
//        storageInStringArrayList();
//        storageInStringHashSet();
//        storageInLongHashSet();
//        storageInLongArrayList();
//        storageInLongArray();
        storageInMyBloomFilter();
//        storageInGoogleBloomFilter();
    }

    static void pause() throws IOException {
        System.out.println("Press enter...");
        System.in.read();
    }

    static void storageInStringArrayList() throws IOException {
        List<String> list = new ArrayList<>();
        for (long l = 100_000_000_000L; l < 100_000_000_000L + SIZE; l++) {
            list.add(String.valueOf(l));
        }
        System.out.println("list.size: " + list.size());
        pause();
    }

    static void storageInStringHashSet() throws IOException {
        Set<String> set = new HashSet<>();
        for (long l = 100_000_000_000L; l < 100_000_000_000L + SIZE; l++) {
            set.add(String.valueOf(l));
        }
        System.out.println("set.size: " + set.size());
        pause();
    }

    static void storageInLongHashSet() throws IOException {
        Set<Long> set = new HashSet<>();
        for (long l = 0; l < SIZE; l++) {
            set.add(l);
        }
        System.out.println("set.size: " + set.size());
        pause();
    }

    static void storageInLongArrayList() throws IOException {
        List<Long> list = new ArrayList<>();
        for (long l = 0; l < SIZE; l++) {
            list.add(l);
        }
        System.out.println("list.size: " + list.size());
        pause();
    }

    static void storageInLongArray() throws IOException {
        long[] arr = new long[SIZE];
        for (long l = 0; l < SIZE; l++) {
            arr[(int) l] = l;
        }
        System.out.println("array.length: " + arr.length);
        pause();
    }

    static void storageInMyBloomFilter() throws IOException, NoSuchAlgorithmException {
        IBloomFilter bloomFilter = new MyBloomFilter();
        for (long l = 100_000_000_000L; l < 100_000_000_000L + SIZE; l++) {
            bloomFilter.saveBits(String.valueOf(l));
        }
        pause();
    }

    static void storageInGoogleBloomFilter() throws IOException {
        IBloomFilter bloomFilter = new GoogleBloomFilter(20_000_000, 0.01);
        for (long l = 100_000_000_000L; l < 100_000_000_000L + SIZE; l++) {
            bloomFilter.saveBits(String.valueOf(l));
        }
        pause();
    }
}
