package com.fasterxml.jackson.core.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: TextBuffer.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    static final char[] f9811a = new char[0];

    /* renamed from: b */
    private final a f9812b;

    /* renamed from: c */
    private char[] f9813c;

    /* renamed from: d */
    private int f9814d;

    /* renamed from: e */
    private int f9815e;

    /* renamed from: f */
    private ArrayList<char[]> f9816f;

    /* renamed from: g */
    private boolean f9817g;

    /* renamed from: h */
    private int f9818h;
    private char[] i;
    private int j;
    private String k;
    private char[] l;

    public e(a aVar) {
        this.f9812b = aVar;
    }

    private void p() {
        this.f9817g = false;
        this.f9816f.clear();
        this.f9818h = 0;
        this.j = 0;
    }

    private char[] q() {
        int i;
        String str = this.k;
        if (str != null) {
            return str.toCharArray();
        }
        int i2 = this.f9814d;
        if (i2 >= 0) {
            int i3 = this.f9815e;
            if (i3 < 1) {
                return f9811a;
            }
            if (i2 == 0) {
                return Arrays.copyOf(this.f9813c, i3);
            }
            return Arrays.copyOfRange(this.f9813c, i2, i3 + i2);
        }
        int o = o();
        if (o < 1) {
            return f9811a;
        }
        char[] d2 = d(o);
        ArrayList<char[]> arrayList = this.f9816f;
        if (arrayList != null) {
            int size = arrayList.size();
            i = 0;
            for (int i4 = 0; i4 < size; i4++) {
                char[] cArr = this.f9816f.get(i4);
                int length = cArr.length;
                System.arraycopy(cArr, 0, d2, i, length);
                i += length;
            }
        } else {
            i = 0;
        }
        System.arraycopy(this.i, 0, d2, i, this.j);
        return d2;
    }

    public void a(String str) {
        this.f9813c = null;
        this.f9814d = -1;
        this.f9815e = 0;
        this.k = str;
        this.l = null;
        if (this.f9817g) {
            p();
        }
        this.j = 0;
    }

    public void b(char[] cArr, int i, int i2) {
        this.f9813c = null;
        this.f9814d = -1;
        this.f9815e = 0;
        this.k = null;
        this.l = null;
        if (this.f9817g) {
            p();
        } else if (this.i == null) {
            this.i = c(i2);
        }
        this.f9818h = 0;
        this.j = 0;
        a(cArr, i, i2);
    }

    public void c(char[] cArr, int i, int i2) {
        this.k = null;
        this.l = null;
        this.f9813c = cArr;
        this.f9814d = i;
        this.f9815e = i2;
        if (this.f9817g) {
            p();
        }
    }

    public String d() {
        if (this.k == null) {
            char[] cArr = this.l;
            if (cArr != null) {
                this.k = new String(cArr);
            } else {
                int i = this.f9814d;
                if (i >= 0) {
                    int i2 = this.f9815e;
                    if (i2 < 1) {
                        this.k = "";
                        return "";
                    }
                    this.k = new String(this.f9813c, i, i2);
                } else {
                    int i3 = this.f9818h;
                    int i4 = this.j;
                    if (i3 == 0) {
                        this.k = i4 != 0 ? new String(this.i, 0, i4) : "";
                    } else {
                        StringBuilder sb = new StringBuilder(i3 + i4);
                        ArrayList<char[]> arrayList = this.f9816f;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                char[] cArr2 = this.f9816f.get(i5);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this.i, 0, this.j);
                        this.k = sb.toString();
                    }
                }
            }
        }
        return this.k;
    }

    public char[] e() {
        this.f9814d = -1;
        this.j = 0;
        this.f9815e = 0;
        this.f9813c = null;
        this.k = null;
        this.l = null;
        if (this.f9817g) {
            p();
        }
        char[] cArr = this.i;
        if (cArr != null) {
            return cArr;
        }
        char[] c2 = c(0);
        this.i = c2;
        return c2;
    }

    public char[] f() {
        char[] cArr = this.i;
        int length = cArr.length;
        int i = (length >> 1) + length;
        if (i > 262144) {
            i = (length >> 2) + length;
        }
        char[] copyOf = Arrays.copyOf(cArr, i);
        this.i = copyOf;
        return copyOf;
    }

    public char[] g() {
        if (this.f9816f == null) {
            this.f9816f = new ArrayList<>();
        }
        this.f9817g = true;
        this.f9816f.add(this.i);
        int length = this.i.length;
        this.f9818h += length;
        this.j = 0;
        int i = length + (length >> 1);
        if (i < 1000) {
            i = 1000;
        } else if (i > 262144) {
            i = 262144;
        }
        char[] d2 = d(i);
        this.i = d2;
        return d2;
    }

    public char[] h() {
        return this.i;
    }

    public char[] i() {
        if (this.f9814d >= 0) {
            f(1);
        } else {
            char[] cArr = this.i;
            if (cArr == null) {
                this.i = c(0);
            } else if (this.j >= cArr.length) {
                e(1);
            }
        }
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public char[] k() {
        if (this.f9814d >= 0) {
            return this.f9813c;
        }
        char[] cArr = this.l;
        if (cArr != null) {
            return cArr;
        }
        String str = this.k;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.l = charArray;
            return charArray;
        }
        if (!this.f9817g) {
            char[] cArr2 = this.i;
            return cArr2 == null ? f9811a : cArr2;
        }
        return a();
    }

    public int l() {
        int i = this.f9814d;
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public void m() {
        if (this.f9812b == null) {
            n();
        } else if (this.i != null) {
            n();
            char[] cArr = this.i;
            this.i = null;
            this.f9812b.a(2, cArr);
        }
    }

    public void n() {
        this.f9814d = -1;
        this.j = 0;
        this.f9815e = 0;
        this.f9813c = null;
        this.k = null;
        this.l = null;
        if (this.f9817g) {
            p();
        }
    }

    public int o() {
        if (this.f9814d >= 0) {
            return this.f9815e;
        }
        char[] cArr = this.l;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.k;
        if (str != null) {
            return str.length();
        }
        return this.f9818h + this.j;
    }

    public String toString() {
        return d();
    }

    private void f(int i) {
        int i2 = this.f9815e;
        this.f9815e = 0;
        char[] cArr = this.f9813c;
        this.f9813c = null;
        int i3 = this.f9814d;
        this.f9814d = -1;
        int i4 = i + i2;
        char[] cArr2 = this.i;
        if (cArr2 == null || i4 > cArr2.length) {
            this.i = c(i4);
        }
        if (i2 > 0) {
            System.arraycopy(cArr, i3, this.i, 0, i2);
        }
        this.f9818h = 0;
        this.j = i2;
    }

    private char[] c(int i) {
        a aVar = this.f9812b;
        if (aVar != null) {
            return aVar.b(2, i);
        }
        return new char[Math.max(i, 1000)];
    }

    public char[] a() {
        char[] cArr = this.l;
        if (cArr != null) {
            return cArr;
        }
        char[] q = q();
        this.l = q;
        return q;
    }

    private void e(int i) {
        if (this.f9816f == null) {
            this.f9816f = new ArrayList<>();
        }
        char[] cArr = this.i;
        this.f9817g = true;
        this.f9816f.add(cArr);
        this.f9818h += cArr.length;
        this.j = 0;
        int length = cArr.length;
        int i2 = length + (length >> 1);
        if (i2 < 1000) {
            i2 = 1000;
        } else if (i2 > 262144) {
            i2 = 262144;
        }
        this.i = d(i2);
    }

    public int a(boolean z) {
        char[] cArr;
        int i = this.f9814d;
        if (i < 0 || (cArr = this.f9813c) == null) {
            if (z) {
                return -com.fasterxml.jackson.core.io.f.b(this.i, 1, this.j - 1);
            }
            return com.fasterxml.jackson.core.io.f.b(this.i, 0, this.j);
        }
        if (z) {
            return -com.fasterxml.jackson.core.io.f.b(cArr, i + 1, this.f9815e - 1);
        }
        return com.fasterxml.jackson.core.io.f.b(cArr, i, this.f9815e);
    }

    public double c() throws NumberFormatException {
        return com.fasterxml.jackson.core.io.f.b(d());
    }

    public void b(String str, int i, int i2) {
        this.f9813c = null;
        this.f9814d = -1;
        this.f9815e = 0;
        this.k = null;
        this.l = null;
        if (this.f9817g) {
            p();
        } else if (this.i == null) {
            this.i = c(i2);
        }
        this.f9818h = 0;
        this.j = 0;
        a(str, i, i2);
    }

    public void a(char c2) {
        if (this.f9814d >= 0) {
            f(16);
        }
        this.k = null;
        this.l = null;
        char[] cArr = this.i;
        if (this.j >= cArr.length) {
            e(1);
            cArr = this.i;
        }
        int i = this.j;
        this.j = i + 1;
        cArr[i] = c2;
    }

    private char[] d(int i) {
        return new char[i];
    }

    public BigDecimal b() throws NumberFormatException {
        char[] cArr;
        char[] cArr2;
        char[] cArr3 = this.l;
        if (cArr3 != null) {
            return com.fasterxml.jackson.core.io.f.a(cArr3);
        }
        int i = this.f9814d;
        if (i >= 0 && (cArr2 = this.f9813c) != null) {
            return com.fasterxml.jackson.core.io.f.a(cArr2, i, this.f9815e);
        }
        if (this.f9818h == 0 && (cArr = this.i) != null) {
            return com.fasterxml.jackson.core.io.f.a(cArr, 0, this.j);
        }
        return com.fasterxml.jackson.core.io.f.a(a());
    }

    public void a(char[] cArr, int i, int i2) {
        if (this.f9814d >= 0) {
            f(i2);
        }
        this.k = null;
        this.l = null;
        char[] cArr2 = this.i;
        int length = cArr2.length;
        int i3 = this.j;
        int i4 = length - i3;
        if (i4 >= i2) {
            System.arraycopy(cArr, i, cArr2, i3, i2);
            this.j += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i, cArr2, i3, i4);
            i += i4;
            i2 -= i4;
        }
        do {
            e(i2);
            int min = Math.min(this.i.length, i2);
            System.arraycopy(cArr, i, this.i, 0, min);
            this.j += min;
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    public long b(boolean z) {
        char[] cArr;
        int i = this.f9814d;
        if (i < 0 || (cArr = this.f9813c) == null) {
            if (z) {
                return -com.fasterxml.jackson.core.io.f.c(this.i, 1, this.j - 1);
            }
            return com.fasterxml.jackson.core.io.f.c(this.i, 0, this.j);
        }
        if (z) {
            return -com.fasterxml.jackson.core.io.f.c(cArr, i + 1, this.f9815e - 1);
        }
        return com.fasterxml.jackson.core.io.f.c(cArr, i, this.f9815e);
    }

    public void b(int i) {
        this.j = i;
    }

    public void a(String str, int i, int i2) {
        if (this.f9814d >= 0) {
            f(i2);
        }
        this.k = null;
        this.l = null;
        char[] cArr = this.i;
        int length = cArr.length;
        int i3 = this.j;
        int i4 = length - i3;
        if (i4 >= i2) {
            str.getChars(i, i + i2, cArr, i3);
            this.j += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = i + i4;
            str.getChars(i, i5, cArr, i3);
            i2 -= i4;
            i = i5;
        }
        while (true) {
            e(i2);
            int min = Math.min(this.i.length, i2);
            int i6 = i + min;
            str.getChars(i, i6, this.i, 0);
            this.j += min;
            i2 -= min;
            if (i2 <= 0) {
                return;
            } else {
                i = i6;
            }
        }
    }

    public String a(int i) {
        this.j = i;
        if (this.f9818h > 0) {
            return d();
        }
        int i2 = this.j;
        String str = i2 == 0 ? "" : new String(this.i, 0, i2);
        this.k = str;
        return str;
    }
}
