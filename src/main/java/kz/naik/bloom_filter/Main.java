package kz.naik.bloom_filter;

import kz.naik.bloom_filter.utils.RandomUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import static kz.naik.bloom_filter.utils.OutUtils.__;

public class Main {

    static String FILE_NAME = "iin_20m.txt";
    static int TEST_COUNT = 10_000_000;
    static int PORTION_SIZE = 1_000_000;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
//        IBloomFilter bloomFilter = new GoogleBloomFilter(20_000_000, 0.01);
        IBloomFilter bloomFilter = new MyBloomFilter();
        int num = 0;
        Set<String> set = new HashSet<>();

        try(FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                if(++num % PORTION_SIZE == 0) {
                    __("load", num);
                }
                set.add(line);
                bloomFilter.saveBits(line);
            }
        }

        int errors = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            if((i + 1) % PORTION_SIZE == 0) {
                __("test", i + 1);
            }
            String randomIin = RandomUtils.getRandomIin();
            if (bloomFilter.checkBits(randomIin)) {
                if(!set.contains(randomIin)) {
                    ++errors;
                }
            }
        }
        __("errors", errors);
        __("errors in percent", (double) errors / TEST_COUNT);
    }

}
