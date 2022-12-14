import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.Collections;
import java.util.Iterator;

public class ChineseCharsetProvider extends CharsetProvider {
    private static final String GB2312 = "GB2312";
    private static final String BIG5 = "Big5";
    private static final String GBK = "GBK";

    @Override
    public Iterator<Charset> charsets() {
        return Collections.emptyIterator();
    }

    @Override
    public Charset charsetForName(String charsetName) {
        if (GB2312.equalsIgnoreCase(charsetName) || BIG5.equalsIgnoreCase(charsetName))
            return Charset.forName(GBK);
        return Charset.defaultCharset();
    }
}