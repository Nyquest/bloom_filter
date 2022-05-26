package kz.naik.bloom_filter;

import kz.naik.bloom_filter.utils.CalcUtils;

import static kz.naik.bloom_filter.utils.OutUtils.__;

public class OptimalCalc {

    static final int TOTAL_COUNT = 20_000_000;
    static final double ERROR_PROBABILITY = 0.01;

    public static void main(String[] args) {

        long optimalBitCount = CalcUtils.optimalBitCount(TOTAL_COUNT, ERROR_PROBABILITY); // 191_701_168
        long optimalBitCountWithAlignment = CalcUtils.optimalBitCountWithAlignment(TOTAL_COUNT, ERROR_PROBABILITY); // 268_435_456
        long hashFunctionCount = CalcUtils.hashFunctionCount(TOTAL_COUNT, optimalBitCountWithAlignment); // 10
        double errorProbability = CalcUtils.errorProbability(TOTAL_COUNT, optimalBitCountWithAlignment, 12); // 0.0018
        __("optimalBitCount", optimalBitCount);
        __("optimalBitCountWithAlignment", optimalBitCountWithAlignment);
        __("hashFunctionCount", hashFunctionCount);
        __("errorProbability", errorProbability);
    }

}
