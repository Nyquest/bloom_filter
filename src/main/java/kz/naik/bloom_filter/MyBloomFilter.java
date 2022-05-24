package kz.naik.bloom_filter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

public class MyBloomFilter implements IBloomFilter{

    private final BitSet bitSet;
    private final MessageDigest digest = MessageDigest.getInstance("SHA-384");

    public MyBloomFilter() throws NoSuchAlgorithmException {
        bitSet = new BitSet(1 << 28);
    }

    public void saveBits(String value) {
        byte[] digest = digest(value);
        for (int i = 0; i + 3 < digest.length; i += 4) {
            this.bitSet.set(bitsToInt(digest, i));
        }
    }

    public boolean checkBits(String value) {
        byte[] digest = digest(value);
        for (int i = 0; i + 3 < digest.length; i += 4) {
            if(!this.bitSet.get(bitsToInt(digest, i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * переводим четыре байта в число
     * @param digest массив байт
     * @param position позиция, от которой берутся 4 байта
     * @return число
     */
    private int bitsToInt(byte[] digest, int position) {
        return ((((1 << 4) - 1)) & digest[position]) << 24 // берем половину байта и смещаем его на 24 позиции влево
                | (0xff & digest[position + 1]) << 16 // берем следующий целый байт и смещаем его на 16 позиций влево
                | (0xff & digest[position + 2]) << 8 // берем следующий целый байт и смещаем его на 8 позиций влево
                | (0xff & digest[position + 3]); // берем следующий целый байт без каких-либо смещений
    }

    private byte[] digest(String value) {
        return this.digest.digest(value.getBytes(StandardCharsets.UTF_8));
    }

}
