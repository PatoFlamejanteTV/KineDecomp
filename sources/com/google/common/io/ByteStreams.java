package com.google.common.io;

import com.google.common.annotations.Beta;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

@Beta
/* loaded from: classes2.dex */
public final class ByteStreams {
    private ByteStreams() {
    }

    public static void a(InputStream inputStream, byte[] bArr) throws IOException {
        a(inputStream, bArr, 0, bArr.length);
    }

    public static void a(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (b(inputStream, bArr, i, i2) != i2) {
            throw new EOFException();
        }
    }

    public static int b(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        return i3;
    }
}
