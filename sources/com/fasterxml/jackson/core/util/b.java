package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.f;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.math.BigDecimal;
import java.util.ArrayList;

/* compiled from: TextBuffer.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final char[] f442a = new char[0];
    private final BufferRecycler b;
    private char[] c;
    private int d;
    private int e;
    private ArrayList<char[]> f;
    private boolean g = false;
    private int h;
    private char[] i;
    private int j;
    private String k;
    private char[] l;

    public b(BufferRecycler bufferRecycler) {
        this.b = bufferRecycler;
    }

    public void a() {
        if (this.b == null) {
            b();
        } else if (this.i != null) {
            b();
            char[] cArr = this.i;
            this.i = null;
            this.b.a(BufferRecycler.CharBufferType.TEXT_BUFFER, cArr);
        }
    }

    public void b() {
        this.d = -1;
        this.j = 0;
        this.e = 0;
        this.c = null;
        this.k = null;
        this.l = null;
        if (this.g) {
            o();
        }
    }

    public void a(char[] cArr, int i, int i2) {
        this.k = null;
        this.l = null;
        this.c = cArr;
        this.d = i;
        this.e = i2;
        if (this.g) {
            o();
        }
    }

    public void b(char[] cArr, int i, int i2) {
        this.c = null;
        this.d = -1;
        this.e = 0;
        this.k = null;
        this.l = null;
        if (this.g) {
            o();
        } else if (this.i == null) {
            this.i = b(i2);
        }
        this.h = 0;
        this.j = 0;
        c(cArr, i, i2);
    }

    public void a(String str) {
        this.c = null;
        this.d = -1;
        this.e = 0;
        this.k = str;
        this.l = null;
        if (this.g) {
            o();
        }
        this.j = 0;
    }

    private char[] b(int i) {
        return this.b != null ? this.b.a(BufferRecycler.CharBufferType.TEXT_BUFFER, i) : new char[Math.max(i, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED)];
    }

    private void o() {
        this.g = false;
        this.f.clear();
        this.h = 0;
        this.j = 0;
    }

    public int c() {
        if (this.d >= 0) {
            return this.e;
        }
        if (this.l != null) {
            return this.l.length;
        }
        if (this.k != null) {
            return this.k.length();
        }
        return this.h + this.j;
    }

    public int d() {
        if (this.d >= 0) {
            return this.d;
        }
        return 0;
    }

    public char[] e() {
        if (this.d >= 0) {
            return this.c;
        }
        if (this.l != null) {
            return this.l;
        }
        if (this.k != null) {
            char[] charArray = this.k.toCharArray();
            this.l = charArray;
            return charArray;
        }
        if (!this.g) {
            return this.i;
        }
        return g();
    }

    public String f() {
        if (this.k == null) {
            if (this.l != null) {
                this.k = new String(this.l);
            } else if (this.d >= 0) {
                if (this.e < 1) {
                    this.k = "";
                    return "";
                }
                this.k = new String(this.c, this.d, this.e);
            } else {
                int i = this.h;
                int i2 = this.j;
                if (i == 0) {
                    this.k = i2 == 0 ? "" : new String(this.i, 0, i2);
                } else {
                    StringBuilder sb = new StringBuilder(i + i2);
                    if (this.f != null) {
                        int size = this.f.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            char[] cArr = this.f.get(i3);
                            sb.append(cArr, 0, cArr.length);
                        }
                    }
                    sb.append(this.i, 0, this.j);
                    this.k = sb.toString();
                }
            }
        }
        return this.k;
    }

    public char[] g() {
        char[] cArr = this.l;
        if (cArr == null) {
            char[] p = p();
            this.l = p;
            return p;
        }
        return cArr;
    }

    public BigDecimal h() throws NumberFormatException {
        if (this.l != null) {
            return new BigDecimal(this.l);
        }
        if (this.d >= 0) {
            return new BigDecimal(this.c, this.d, this.e);
        }
        if (this.h == 0) {
            return new BigDecimal(this.i, 0, this.j);
        }
        return new BigDecimal(g());
    }

    public double i() throws NumberFormatException {
        return f.a(f());
    }

    public void c(char[] cArr, int i, int i2) {
        if (this.d >= 0) {
            c(i2);
        }
        this.k = null;
        this.l = null;
        char[] cArr2 = this.i;
        int length = cArr2.length - this.j;
        if (length >= i2) {
            System.arraycopy(cArr, i, cArr2, this.j, i2);
            this.j += i2;
            return;
        }
        if (length > 0) {
            System.arraycopy(cArr, i, cArr2, this.j, length);
            i += length;
            i2 -= length;
        }
        do {
            d(i2);
            int min = Math.min(this.i.length, i2);
            System.arraycopy(cArr, i, this.i, 0, min);
            this.j += min;
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    public char[] j() {
        if (this.d >= 0) {
            c(1);
        } else {
            char[] cArr = this.i;
            if (cArr == null) {
                this.i = b(0);
            } else if (this.j >= cArr.length) {
                d(1);
            }
        }
        return this.i;
    }

    public char[] k() {
        this.d = -1;
        this.j = 0;
        this.e = 0;
        this.c = null;
        this.k = null;
        this.l = null;
        if (this.g) {
            o();
        }
        char[] cArr = this.i;
        if (cArr == null) {
            char[] b = b(0);
            this.i = b;
            return b;
        }
        return cArr;
    }

    public int l() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public char[] m() {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.g = true;
        this.f.add(this.i);
        int length = this.i.length;
        this.h += length;
        char[] e = e(Math.min(length + (length >> 1), 262144));
        this.j = 0;
        this.i = e;
        return e;
    }

    public char[] n() {
        char[] cArr = this.i;
        int length = cArr.length;
        this.i = e(length == 262144 ? 262145 : Math.min(262144, (length >> 1) + length));
        System.arraycopy(cArr, 0, this.i, 0, length);
        return this.i;
    }

    public String toString() {
        return f();
    }

    private void c(int i) {
        int i2 = this.e;
        this.e = 0;
        char[] cArr = this.c;
        this.c = null;
        int i3 = this.d;
        this.d = -1;
        int i4 = i2 + i;
        if (this.i == null || i4 > this.i.length) {
            this.i = b(i4);
        }
        if (i2 > 0) {
            System.arraycopy(cArr, i3, this.i, 0, i2);
        }
        this.h = 0;
        this.j = i2;
    }

    private void d(int i) {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        char[] cArr = this.i;
        this.g = true;
        this.f.add(cArr);
        this.h += cArr.length;
        int length = cArr.length;
        int i2 = length >> 1;
        if (i2 >= i) {
            i = i2;
        }
        char[] e = e(Math.min(262144, length + i));
        this.j = 0;
        this.i = e;
    }

    private char[] p() {
        int i;
        if (this.k != null) {
            return this.k.toCharArray();
        }
        if (this.d >= 0) {
            if (this.e < 1) {
                return f442a;
            }
            char[] e = e(this.e);
            System.arraycopy(this.c, this.d, e, 0, this.e);
            return e;
        }
        int c = c();
        if (c < 1) {
            return f442a;
        }
        char[] e2 = e(c);
        if (this.f != null) {
            int size = this.f.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                char[] cArr = this.f.get(i3);
                int length = cArr.length;
                System.arraycopy(cArr, 0, e2, i2, length);
                i2 += length;
            }
            i = i2;
        } else {
            i = 0;
        }
        System.arraycopy(this.i, 0, e2, i, this.j);
        return e2;
    }

    private char[] e(int i) {
        return new char[i];
    }
}
