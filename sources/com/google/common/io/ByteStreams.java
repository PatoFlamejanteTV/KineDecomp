package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class ByteStreams {

    /* renamed from: a */
    private static final OutputStream f15957a = new a();

    private ByteStreams() {
    }

    public static void a(InputStream inputStream, byte[] bArr) throws IOException {
        b(inputStream, bArr, 0, bArr.length);
    }

    public static void b(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int a2 = a(inputStream, bArr, i, i2);
        if (a2 == i2) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + a2 + " bytes; " + i2 + " bytes expected");
    }

    @CanIgnoreReturnValue
    public static int a(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        Preconditions.a(inputStream);
        Preconditions.a(bArr);
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
