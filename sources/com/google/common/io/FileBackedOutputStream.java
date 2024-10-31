package com.google.common.io;

import com.google.common.annotations.Beta;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
/* loaded from: classes2.dex */
public final class FileBackedOutputStream extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final int f2913a;
    private final boolean b;
    private OutputStream c;
    private a d;
    private File e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends ByteArrayOutputStream {
        byte[] a() {
            return this.buf;
        }

        int b() {
            return this.count;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        a(1);
        this.c.write(i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        a(i2);
        this.c.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.c.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        this.c.flush();
    }

    private void a(int i) throws IOException {
        if (this.e == null && this.d.b() + i > this.f2913a) {
            File createTempFile = File.createTempFile("FileBackedOutputStream", null);
            if (this.b) {
                createTempFile.deleteOnExit();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(this.d.a(), 0, this.d.b());
            fileOutputStream.flush();
            this.c = fileOutputStream;
            this.e = createTempFile;
            this.d = null;
        }
    }
}
