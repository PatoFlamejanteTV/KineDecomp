package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* compiled from: UTF8Writer.java */
/* loaded from: classes.dex */
public final class i extends Writer {

    /* renamed from: a */
    private final c f9792a;

    /* renamed from: b */
    private OutputStream f9793b;

    /* renamed from: c */
    private byte[] f9794c;

    /* renamed from: d */
    private final int f9795d;

    /* renamed from: e */
    private int f9796e = 0;

    /* renamed from: f */
    private int f9797f;

    public i(c cVar, OutputStream outputStream) {
        this.f9792a = cVar;
        this.f9793b = outputStream;
        this.f9794c = cVar.d();
        this.f9795d = this.f9794c.length - 4;
    }

    protected static void b(int i) throws IOException {
        throw new IOException(c(i));
    }

    public static String c(int i) {
        if (i > 1114111) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627";
        }
        if (i < 55296) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output";
        }
        if (i <= 56319) {
            return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")";
        }
        return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")";
    }

    protected int a(int i) throws IOException {
        int i2 = this.f9797f;
        this.f9797f = 0;
        if (i >= 56320 && i <= 57343) {
            return ((i2 - 55296) << 10) + 65536 + (i - 56320);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char c2) throws IOException {
        append(c2);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.f9793b;
        if (outputStream != null) {
            int i = this.f9796e;
            if (i > 0) {
                outputStream.write(this.f9794c, 0, i);
                this.f9796e = 0;
            }
            OutputStream outputStream2 = this.f9793b;
            this.f9793b = null;
            byte[] bArr = this.f9794c;
            if (bArr != null) {
                this.f9794c = null;
                this.f9792a.b(bArr);
            }
            outputStream2.close();
            int i2 = this.f9797f;
            this.f9797f = 0;
            if (i2 <= 0) {
                return;
            }
            b(i2);
            throw null;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this.f9793b;
        if (outputStream != null) {
            int i = this.f9796e;
            if (i > 0) {
                outputStream.write(this.f9794c, 0, i);
                this.f9796e = 0;
            }
            this.f9793b.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c2) throws IOException {
        write(c2);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0025, code lost:            continue;     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(char[] r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.i.write(char[], int, int):void");
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        int i2;
        if (this.f9797f > 0) {
            i = a(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i <= 56319) {
                this.f9797f = i;
                return;
            } else {
                b(i);
                throw null;
            }
        }
        int i3 = this.f9796e;
        if (i3 >= this.f9795d) {
            this.f9793b.write(this.f9794c, 0, i3);
            this.f9796e = 0;
        }
        if (i < 128) {
            byte[] bArr = this.f9794c;
            int i4 = this.f9796e;
            this.f9796e = i4 + 1;
            bArr[i4] = (byte) i;
            return;
        }
        int i5 = this.f9796e;
        if (i < 2048) {
            byte[] bArr2 = this.f9794c;
            int i6 = i5 + 1;
            bArr2[i5] = (byte) ((i >> 6) | 192);
            i2 = i6 + 1;
            bArr2[i6] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            byte[] bArr3 = this.f9794c;
            int i7 = i5 + 1;
            bArr3[i5] = (byte) ((i >> 12) | 224);
            int i8 = i7 + 1;
            bArr3[i7] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i8] = (byte) ((i & 63) | 128);
            i2 = i8 + 1;
        } else if (i <= 1114111) {
            byte[] bArr4 = this.f9794c;
            int i9 = i5 + 1;
            bArr4[i5] = (byte) ((i >> 18) | 240);
            int i10 = i9 + 1;
            bArr4[i9] = (byte) (((i >> 12) & 63) | 128);
            int i11 = i10 + 1;
            bArr4[i10] = (byte) (((i >> 6) & 63) | 128);
            i2 = i11 + 1;
            bArr4[i11] = (byte) ((i & 63) | 128);
        } else {
            b(i);
            throw null;
        }
        this.f9796e = i2;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0029, code lost:            continue;     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(java.lang.String r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.i.write(java.lang.String, int, int):void");
    }
}
