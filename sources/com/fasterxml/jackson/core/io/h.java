package com.fasterxml.jackson.core.io;

import com.facebook.internal.NativeProtocol;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: UTF32Reader.java */
/* loaded from: classes.dex */
public class h extends a {
    protected final boolean g;
    protected char h;
    protected int i;
    protected int j;
    protected final boolean k;

    @Override // com.fasterxml.jackson.core.io.a, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // com.fasterxml.jackson.core.io.a, java.io.Reader
    public /* bridge */ /* synthetic */ int read() throws IOException {
        return super.read();
    }

    public h(c cVar, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        super(cVar, inputStream, bArr, i, i2);
        this.h = (char) 0;
        this.i = 0;
        this.j = 0;
        this.g = z;
        this.k = inputStream != null;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        if (this.c == null) {
            return -1;
        }
        if (i2 >= 1) {
            if (i < 0 || i + i2 > cArr.length) {
                a(cArr, i, i2);
            }
            int i6 = i2 + i;
            if (this.h != 0) {
                i3 = i + 1;
                cArr[i] = this.h;
                this.h = (char) 0;
            } else {
                int i7 = this.e - this.d;
                if (i7 < 4 && !a(i7)) {
                    return -1;
                }
                i3 = i;
            }
            while (true) {
                if (i3 >= i6) {
                    i4 = i3;
                    break;
                }
                int i8 = this.d;
                if (this.g) {
                    i5 = (this.c[i8 + 3] & 255) | (this.c[i8] << 24) | ((this.c[i8 + 1] & 255) << 16) | ((this.c[i8 + 2] & 255) << 8);
                } else {
                    i5 = (this.c[i8 + 3] << 24) | (this.c[i8] & 255) | ((this.c[i8 + 1] & 255) << 8) | ((this.c[i8 + 2] & 255) << 16);
                }
                this.d += 4;
                if (i5 > 65535) {
                    if (i5 > 1114111) {
                        a(i5, i3 - i, "(above " + Integer.toHexString(1114111) + ") ");
                    }
                    int i9 = i5 - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                    i4 = i3 + 1;
                    cArr[i3] = (char) (55296 + (i9 >> 10));
                    i5 = (i9 & 1023) | 56320;
                    if (i4 >= i6) {
                        this.h = (char) i5;
                        break;
                    }
                } else {
                    i4 = i3;
                }
                i3 = i4 + 1;
                cArr[i4] = (char) i5;
                if (this.d >= this.e) {
                    i4 = i3;
                    break;
                }
            }
            int i10 = i4 - i;
            this.i += i10;
            return i10;
        }
        return i2;
    }

    private void a(int i, int i2) throws IOException {
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + this.i + ", byte #" + (this.j + i) + ")");
    }

    private void a(int i, int i2, String str) throws IOException {
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (this.i + i2) + ", byte #" + ((this.j + this.d) - 1) + ")");
    }

    private boolean a(int i) throws IOException {
        this.j += this.e - i;
        if (i > 0) {
            if (this.d > 0) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.c[i2] = this.c[this.d + i2];
                }
                this.d = 0;
            }
            this.e = i;
        } else {
            this.d = 0;
            int read = this.b == null ? -1 : this.b.read(this.c);
            if (read < 1) {
                this.e = 0;
                if (read < 0) {
                    if (!this.k) {
                        return false;
                    }
                    a();
                    return false;
                }
                b();
            }
            this.e = read;
        }
        while (this.e < 4) {
            int read2 = this.b == null ? -1 : this.b.read(this.c, this.e, this.c.length - this.e);
            if (read2 < 1) {
                if (read2 < 0) {
                    if (this.k) {
                        a();
                    }
                    a(this.e, 4);
                }
                b();
            }
            this.e = read2 + this.e;
        }
        return true;
    }
}
