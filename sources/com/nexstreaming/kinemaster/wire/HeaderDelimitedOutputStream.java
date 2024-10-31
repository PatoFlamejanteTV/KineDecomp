package com.nexstreaming.kinemaster.wire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class HeaderDelimitedOutputStream extends OutputStream {
    private final OutputStream baseOutputStream;

    public HeaderDelimitedOutputStream(OutputStream outputStream) {
        this.baseOutputStream = outputStream;
    }

    public HeaderDelimitedOutputStream(File file) throws FileNotFoundException {
        this.baseOutputStream = new FileOutputStream(file);
    }

    public void writeInt(int i) throws IOException {
        this.baseOutputStream.write((i >> 24) & 255);
        this.baseOutputStream.write((i >> 16) & 255);
        this.baseOutputStream.write((i >> 8) & 255);
        this.baseOutputStream.write(i & 255);
    }

    public void writeSection(int i, byte[] bArr) throws IOException {
        writeInt(i);
        if (bArr == null) {
            writeInt(0);
        } else {
            writeInt(bArr.length);
            write(bArr);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.baseOutputStream.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.baseOutputStream.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.baseOutputStream.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.baseOutputStream.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.baseOutputStream.flush();
    }
}
