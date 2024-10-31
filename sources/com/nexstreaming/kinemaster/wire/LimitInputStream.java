package com.nexstreaming.kinemaster.wire;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class LimitInputStream extends InputStream {
    private final InputStream baseStream;
    private long bytesRemaining;
    private final long maxLength;

    public static LimitInputStream fromStreamWithFourCCAndSizeHeader(InputStream inputStream) throws IOException {
        return new LimitInputStream(inputStream, readInt(inputStream), readInt(inputStream));
    }

    private static int readInt(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if (read == -1 || read2 == -1 || read3 == -1 || read4 == -1) {
            throw new IOException("Unexpected end of file");
        }
        return ((read & 255) << 24) | ((read2 & 255) << 16) | ((read3 & 255) << 8) | (read4 & 255);
    }

    public LimitInputStream(InputStream inputStream, long j) {
        this.bytesRemaining = 0L;
        this.baseStream = inputStream;
        this.maxLength = j;
        this.bytesRemaining = j;
    }

    private LimitInputStream(InputStream inputStream, long j, int i) {
        this.bytesRemaining = 0L;
        this.baseStream = inputStream;
        this.maxLength = j;
        this.bytesRemaining = j;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bytesRemaining < 1) {
            return -1;
        }
        int read = this.baseStream.read();
        if (read >= 0) {
            this.bytesRemaining--;
            return read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.bytesRemaining < 1) {
            return -1;
        }
        if (this.bytesRemaining < i2) {
            i2 = (int) this.bytesRemaining;
        }
        int read = this.baseStream.read(bArr, i, i2);
        if (read > 0) {
            this.bytesRemaining -= read;
            return read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (this.bytesRemaining < 1) {
            return -1L;
        }
        if (this.bytesRemaining < j) {
            j = this.bytesRemaining;
        }
        long skip = this.baseStream.skip(j);
        if (skip > 0) {
            this.bytesRemaining -= skip;
            return skip;
        }
        return skip;
    }
}
