package com.fasterxml.jackson.core.io;

import android.support.v4.internal.view.SupportMenu;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* compiled from: UTF32Reader.java */
/* loaded from: classes.dex */
public class h extends Reader {

    /* renamed from: a */
    protected final c f9784a;

    /* renamed from: b */
    protected InputStream f9785b;

    /* renamed from: c */
    protected byte[] f9786c;

    /* renamed from: d */
    protected int f9787d;

    /* renamed from: e */
    protected int f9788e;

    /* renamed from: f */
    protected final boolean f9789f;

    /* renamed from: g */
    protected char f9790g = 0;

    /* renamed from: h */
    protected int f9791h;
    protected int i;
    protected final boolean j;
    protected char[] k;

    public h(c cVar, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        this.f9784a = cVar;
        this.f9785b = inputStream;
        this.f9786c = bArr;
        this.f9787d = i;
        this.f9788e = i2;
        this.f9789f = z;
        this.j = inputStream != null;
    }

    private void a(int i, int i2) throws IOException {
        int i3 = this.i + i;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + this.f9791h + ", byte #" + i3 + ")");
    }

    private void b() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f9785b;
        if (inputStream != null) {
            this.f9785b = null;
            a();
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this.k == null) {
            this.k = new char[1];
        }
        if (read(this.k, 0, 1) < 1) {
            return -1;
        }
        return this.k[0];
    }

    private void a(int i, int i2, String str) throws IOException {
        int i3 = (this.i + this.f9787d) - 1;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (this.f9791h + i2) + ", byte #" + i3 + ")");
    }

    private boolean a(int i) throws IOException {
        int read;
        this.i += this.f9788e - i;
        if (i > 0) {
            int i2 = this.f9787d;
            if (i2 > 0) {
                byte[] bArr = this.f9786c;
                System.arraycopy(bArr, i2, bArr, 0, i);
                this.f9787d = 0;
            }
            this.f9788e = i;
        } else {
            this.f9787d = 0;
            InputStream inputStream = this.f9785b;
            int read2 = inputStream == null ? -1 : inputStream.read(this.f9786c);
            if (read2 < 1) {
                this.f9788e = 0;
                if (read2 < 0) {
                    if (this.j) {
                        a();
                    }
                    return false;
                }
                b();
                throw null;
            }
            this.f9788e = read2;
        }
        while (true) {
            int i3 = this.f9788e;
            if (i3 >= 4) {
                return true;
            }
            InputStream inputStream2 = this.f9785b;
            if (inputStream2 == null) {
                read = -1;
            } else {
                byte[] bArr2 = this.f9786c;
                read = inputStream2.read(bArr2, i3, bArr2.length - i3);
            }
            if (read < 1) {
                if (read < 0) {
                    if (this.j) {
                        a();
                    }
                    a(this.f9788e, 4);
                    throw null;
                }
                b();
                throw null;
            }
            this.f9788e += read;
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.f9786c == null) {
            return -1;
        }
        if (i2 < 1) {
            return i2;
        }
        if (i >= 0 && i + i2 <= cArr.length) {
            int i7 = i2 + i;
            char c2 = this.f9790g;
            if (c2 != 0) {
                i3 = i + 1;
                cArr[i] = c2;
                this.f9790g = (char) 0;
            } else {
                int i8 = this.f9788e - this.f9787d;
                if (i8 < 4 && !a(i8)) {
                    if (i8 == 0) {
                        return -1;
                    }
                    a(this.f9788e - this.f9787d, 4);
                    throw null;
                }
                i3 = i;
            }
            int i9 = this.f9788e - 4;
            while (true) {
                if (i3 >= i7) {
                    i4 = i3;
                    break;
                }
                int i10 = this.f9787d;
                if (this.f9789f) {
                    byte[] bArr = this.f9786c;
                    int i11 = (bArr[i10] << 8) | (bArr[i10 + 1] & 255);
                    i5 = (bArr[i10 + 3] & 255) | ((bArr[i10 + 2] & 255) << 8);
                    i6 = i11;
                } else {
                    byte[] bArr2 = this.f9786c;
                    i5 = (bArr2[i10] & 255) | ((bArr2[i10 + 1] & 255) << 8);
                    i6 = (bArr2[i10 + 3] << 8) | (bArr2[i10 + 2] & 255);
                }
                this.f9787d += 4;
                if (i6 != 0) {
                    int i12 = i6 & SupportMenu.USER_MASK;
                    int i13 = ((i12 - 1) << 16) | i5;
                    if (i12 > 16) {
                        a(i13, i3 - i, String.format(" (above 0x%08x)", 1114111));
                        throw null;
                    }
                    i4 = i3 + 1;
                    cArr[i3] = (char) ((i13 >> 10) + 55296);
                    i5 = (i13 & 1023) | 56320;
                    if (i4 >= i7) {
                        this.f9790g = (char) i13;
                        break;
                    }
                    i3 = i4;
                }
                i4 = i3 + 1;
                cArr[i3] = (char) i5;
                if (this.f9787d > i9) {
                    break;
                }
                i3 = i4;
            }
            int i14 = i4 - i;
            this.f9791h += i14;
            return i14;
        }
        a(cArr, i, i2);
        throw null;
    }

    private void a() {
        byte[] bArr = this.f9786c;
        if (bArr != null) {
            this.f9786c = null;
            this.f9784a.a(bArr);
        }
    }

    private void a(char[] cArr, int i, int i2) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + "," + i2 + "), cbuf[" + cArr.length + "]");
    }
}
