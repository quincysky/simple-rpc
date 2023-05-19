package quincy.compress;

import extension.SPI;

/**
 * @author quincy
 * @create 2023 - 05 - 18 20:55
 */
@SPI
public interface Compress {

    byte[] compress(byte[] bytes);

    byte[] decompress(byte[] bytes);
}
