package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class FileBackedOutputStream extends OutputStream {

    /* renamed from: a */
    private OutputStream f15969a;

    /* renamed from: b */
    private a f15970b;

    /* renamed from: c */
    private File f15971c;

    /* loaded from: classes2.dex */
    public static class a extends ByteArrayOutputStream {
        int getCount() {
            throw null;
        }
    }

    private void a(int i) throws IOException {
        if (this.f15971c != null) {
            return;
        }
        this.f15970b.getCount();
        throw null;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f15969a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        this.f15969a.flush();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        a(1);
        this.f15969a.write(i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        a(i2);
        this.f15969a.write(bArr, i, i2);
    }
}
