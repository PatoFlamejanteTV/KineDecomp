package com.google.api.client.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class ByteStreams {
    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.a(inputStream);
        Preconditions.a(outputStream);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                return j;
            }
        }
    }

    public static InputStream a(InputStream inputStream, long j) {
        return new a(inputStream, j);
    }

    /* loaded from: classes.dex */
    private static final class a extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        private long f2529a;
        private long b;

        a(InputStream inputStream, long j) {
            super(inputStream);
            this.b = -1L;
            Preconditions.a(inputStream);
            Preconditions.a(j >= 0, "limit must be non-negative");
            this.f2529a = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(this.in.available(), this.f2529a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i) {
            this.in.mark(i);
            this.b = this.f2529a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f2529a == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.f2529a--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.f2529a == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i, (int) Math.min(i2, this.f2529a));
            if (read != -1) {
                this.f2529a -= read;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.b == -1) {
                throw new IOException("Mark not set");
            }
            this.in.reset();
            this.f2529a = this.b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long skip = this.in.skip(Math.min(j, this.f2529a));
            this.f2529a -= skip;
            return skip;
        }
    }

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

    private ByteStreams() {
    }
}
