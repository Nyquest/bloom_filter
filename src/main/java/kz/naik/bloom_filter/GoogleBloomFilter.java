package kz.naik.bloom_filter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.StandardCharsets;

@SuppressWarnings("UnstableApiUsage") // BloomFilter в Beta-реализации
public class GoogleBloomFilter implements IBloomFilter{

    private final BloomFilter<String> bloomFilter;

    public GoogleBloomFilter(int expectedInsertions, double fpp) {
        bloomFilter = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), expectedInsertions, fpp);
    }

    @Override
    public void saveBits(String value) {
        bloomFilter.put(value);
    }

    @Override
    public boolean checkBits(String value) {
        return bloomFilter.mightContain(value);
    }
}
