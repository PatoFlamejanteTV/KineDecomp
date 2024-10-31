package com.fasterxml.jackson.core.io;

import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* compiled from: UTF8Writer.java */
/* loaded from: classes.dex */
public final class i extends Writer {

    /* renamed from: a, reason: collision with root package name */
    protected final c f439a;
    OutputStream b;
    byte[] c;
    final int d;
    int f = 0;
    int e = 0;

    public i(c cVar, OutputStream outputStream) {
        this.f439a = cVar;
        this.b = outputStream;
        this.c = cVar.f();
        this.d = this.c.length - 4;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.b != null) {
            if (this.e > 0) {
                this.b.write(this.c, 0, this.e);
                this.e = 0;
            }
            OutputStream outputStream = this.b;
            this.b = null;
            byte[] bArr = this.c;
            if (bArr != null) {
                this.c = null;
                this.f439a.b(bArr);
            }
            outputStream.close();
            int i = this.f;
            this.f = 0;
            if (i > 0) {
                b(i);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        if (this.b != null) {
            if (this.e > 0) {
                this.b.write(this.c, 0, this.e);
                this.e = 0;
            }
            this.b.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        char c;
        if (i2 < 2) {
            if (i2 == 1) {
                write(cArr[i]);
                return;
            }
            return;
        }
        if (this.f > 0) {
            i2--;
            write(a(cArr[i]));
            i++;
        }
        int i3 = this.e;
        byte[] bArr = this.c;
        int i4 = this.d;
        int i5 = i2 + i;
        int i6 = i;
        while (i6 < i5) {
            if (i3 >= i4) {
                this.b.write(bArr, 0, i3);
                i3 = 0;
            }
            int i7 = i6 + 1;
            char c2 = cArr[i6];
            if (c2 < 128) {
                int i8 = i3 + 1;
                bArr[i3] = (byte) c2;
                int i9 = i5 - i7;
                int i10 = i4 - i8;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int i11 = i10 + i7;
                int i12 = i8;
                int i13 = i7;
                while (i13 < i11) {
                    int i14 = i13 + 1;
                    char c3 = cArr[i13];
                    if (c3 >= 128) {
                        i3 = i12;
                        i6 = i14;
                        c = c3;
                    } else {
                        bArr[i12] = (byte) c3;
                        i12++;
                        i13 = i14;
                    }
                }
                int i15 = i12;
                i6 = i13;
                i3 = i15;
            } else {
                i6 = i7;
                c = c2;
            }
            if (c < 2048) {
                int i16 = i3 + 1;
                bArr[i3] = (byte) ((c >> 6) | 192);
                i3 = i16 + 1;
                bArr[i16] = (byte) ((c & '?') | 128);
            } else if (c < 55296 || c > 57343) {
                int i17 = i3 + 1;
                bArr[i3] = (byte) ((c >> '\f') | 224);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((c >> 6) & 63) | 128);
                i3 = i18 + 1;
                bArr[i18] = (byte) ((c & '?') | 128);
            } else {
                if (c > 56319) {
                    this.e = i3;
                    b(c);
                }
                this.f = c;
                if (i6 >= i5) {
                    break;
                }
                int i19 = i6 + 1;
                int a2 = a(cArr[i6]);
                if (a2 > 1114111) {
                    this.e = i3;
                    b(a2);
                }
                int i20 = i3 + 1;
                bArr[i3] = (byte) ((a2 >> 18) | 240);
                int i21 = i20 + 1;
                bArr[i20] = (byte) (((a2 >> 12) & 63) | 128);
                int i22 = i21 + 1;
                bArr[i21] = (byte) (((a2 >> 6) & 63) | 128);
                i3 = i22 + 1;
                bArr[i22] = (byte) ((a2 & 63) | 128);
                i6 = i19;
            }
        }
        this.e = i3;
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        int i2;
        if (this.f > 0) {
            i = a(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i > 56319) {
                b(i);
            }
            this.f = i;
            return;
        }
        if (this.e >= this.d) {
            this.b.write(this.c, 0, this.e);
            this.e = 0;
        }
        if (i < 128) {
            byte[] bArr = this.c;
            int i3 = this.e;
            this.e = i3 + 1;
            bArr[i3] = (byte) i;
            return;
        }
        int i4 = this.e;
        if (i < 2048) {
            int i5 = i4 + 1;
            this.c[i4] = (byte) ((i >> 6) | 192);
            i2 = i5 + 1;
            this.c[i5] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            int i6 = i4 + 1;
            this.c[i4] = (byte) ((i >> 12) | 224);
            int i7 = i6 + 1;
            this.c[i6] = (byte) (((i >> 6) & 63) | 128);
            i2 = i7 + 1;
            this.c[i7] = (byte) ((i & 63) | 128);
        } else {
            if (i > 1114111) {
                b(i);
            }
            int i8 = i4 + 1;
            this.c[i4] = (byte) ((i >> 18) | 240);
            int i9 = i8 + 1;
            this.c[i8] = (byte) (((i >> 12) & 63) | 128);
            int i10 = i9 + 1;
            this.c[i9] = (byte) (((i >> 6) & 63) | 128);
            i2 = i10 + 1;
            this.c[i10] = (byte) ((i & 63) | 128);
        }
        this.e = i2;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        char c;
        if (i2 < 2) {
            if (i2 == 1) {
                write(str.charAt(i));
                return;
            }
            return;
        }
        if (this.f > 0) {
            i2--;
            write(a(str.charAt(i)));
            i++;
        }
        int i3 = this.e;
        byte[] bArr = this.c;
        int i4 = this.d;
        int i5 = i2 + i;
        int i6 = i;
        while (i6 < i5) {
            if (i3 >= i4) {
                this.b.write(bArr, 0, i3);
                i3 = 0;
            }
            int i7 = i6 + 1;
            char charAt = str.charAt(i6);
            if (charAt < 128) {
                int i8 = i3 + 1;
                bArr[i3] = (byte) charAt;
                int i9 = i5 - i7;
                int i10 = i4 - i8;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int i11 = i10 + i7;
                int i12 = i8;
                int i13 = i7;
                while (i13 < i11) {
                    int i14 = i13 + 1;
                    char charAt2 = str.charAt(i13);
                    if (charAt2 >= 128) {
                        i3 = i12;
                        i6 = i14;
                        c = charAt2;
                    } else {
                        bArr[i12] = (byte) charAt2;
                        i12++;
                        i13 = i14;
                    }
                }
                int i15 = i12;
                i6 = i13;
                i3 = i15;
            } else {
                i6 = i7;
                c = charAt;
            }
            if (c < 2048) {
                int i16 = i3 + 1;
                bArr[i3] = (byte) ((c >> 6) | 192);
                i3 = i16 + 1;
                bArr[i16] = (byte) ((c & '?') | 128);
            } else if (c < 55296 || c > 57343) {
                int i17 = i3 + 1;
                bArr[i3] = (byte) ((c >> '\f') | 224);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((c >> 6) & 63) | 128);
                i3 = i18 + 1;
                bArr[i18] = (byte) ((c & '?') | 128);
            } else {
                if (c > 56319) {
                    this.e = i3;
                    b(c);
                }
                this.f = c;
                if (i6 >= i5) {
                    break;
                }
                int i19 = i6 + 1;
                int a2 = a(str.charAt(i6));
                if (a2 > 1114111) {
                    this.e = i3;
                    b(a2);
                }
                int i20 = i3 + 1;
                bArr[i3] = (byte) ((a2 >> 18) | 240);
                int i21 = i20 + 1;
                bArr[i20] = (byte) (((a2 >> 12) & 63) | 128);
                int i22 = i21 + 1;
                bArr[i21] = (byte) (((a2 >> 6) & 63) | 128);
                i3 = i22 + 1;
                bArr[i22] = (byte) ((a2 & 63) | 128);
                i6 = i19;
            }
        }
        this.e = i3;
    }

    private int a(int i) throws IOException {
        int i2 = this.f;
        this.f = 0;
        if (i < 56320 || i > 57343) {
            throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
        }
        return ((i2 - 55296) << 10) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + (i - 56320);
    }

    private void b(int i) throws IOException {
        if (i > 1114111) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (i >= 55296) {
            if (i <= 56319) {
                throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
            }
            throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
        throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
    }
}
