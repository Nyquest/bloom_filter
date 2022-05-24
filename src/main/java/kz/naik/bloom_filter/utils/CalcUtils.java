package kz.naik.bloom_filter.utils;

public class CalcUtils {

    /**
     * Вычислить оптимальное кол-во бит
     * @param totalCount общее кол-во элементов
     * @param errorProbability вероятность ошибок
     * @return оптимальное кол-во бит в порции
     */
    public static long optimalBitCount(long totalCount, double errorProbability) {
        return (long) Math.ceil(
                -totalCount * Math.log(errorProbability) / Math.pow(Math.log(2), 2));
    }

    /**
     * Вычислить оптимальное кол-во бит с выравниванием
     * @param totalCount общее кол-во элементов
     * @param errorProbability вероятность ошибок
     * @return оптимальное кол-во бит в порции с выравниванием
     */
    public static long optimalBitCountWithAlignment(long totalCount, double errorProbability) {
        long result = optimalBitCount(totalCount, errorProbability);
        long l = Long.highestOneBit(result);
        return l == totalCount ? totalCount : l << 1;
    }

    /**
     * Расчет кол-ва хэш-функций
     * @param totalCount общее кол-во элементов
     * @param bitArraySize размер битового массив
     * @return минимальное кол-во хэш-функций
     */
    public static long hashFunctionCount(long totalCount, long bitArraySize) {
        return (long) Math.ceil(Math.log(2) * ((double)bitArraySize / totalCount));
    }

    /**
     * Расчет вероятности ошибок
     * @param totalCount общее кол-во элементов
     * @param bitArraySize размер битового массив
     * @param hashFunctionCount кол-во хэш-функций
     * @return вероятность ошибок
     */
    public static double errorProbability(long totalCount, long bitArraySize, long hashFunctionCount) {
        return Math.pow(1 - Math.pow(Math.E, -(double)hashFunctionCount * totalCount / bitArraySize), hashFunctionCount);
    }

}
