package com.android.sugar.commonutils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @ClassName: IOUtils
 * @Description:
 * @author: SugarT
 * @date: 16/7/19 下午2:38
 */
public class IOUtils {

    private IOUtils() {
        throw new AssertionError();
    }

    /**
     * Close closable object and wrap {@link IOException} with {@link RuntimeException}
     *
     * @param closeable closeable object
     */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new RuntimeException("IOException occurred. ", e);
            }
        }
    }

    /**
     * Close closable and hide possible {@link IOException}
     *
     * @param closeable closeable object
     */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // Ignored
            }
        }
    }
}
