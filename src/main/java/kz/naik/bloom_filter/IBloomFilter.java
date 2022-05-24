package kz.naik.bloom_filter;

public interface IBloomFilter {
    void saveBits(String value);
    boolean checkBits(String value);
}
