package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;

/* compiled from: CharsToNameCanonicalizer.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final b f429a = new b();
    protected b b;
    protected final boolean c;
    protected final boolean d;
    protected String[] e;
    protected a[] f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected boolean k;
    private final int l;

    public static b a() {
        long currentTimeMillis = System.currentTimeMillis();
        return a((((int) (currentTimeMillis >>> 32)) + ((int) currentTimeMillis)) | 1);
    }

    protected static b a(int i) {
        return f429a.f(i);
    }

    private b() {
        this.d = true;
        this.c = true;
        this.k = true;
        this.l = 0;
        this.j = 0;
        d(64);
    }

    private void d(int i) {
        this.e = new String[i];
        this.f = new a[i >> 1];
        this.i = i - 1;
        this.g = 0;
        this.j = 0;
        this.h = e(i);
    }

    private static int e(int i) {
        return i - (i >> 2);
    }

    private b(b bVar, boolean z, boolean z2, String[] strArr, a[] aVarArr, int i, int i2, int i3) {
        this.b = bVar;
        this.d = z;
        this.c = z2;
        this.e = strArr;
        this.f = aVarArr;
        this.g = i;
        this.l = i2;
        int length = strArr.length;
        this.h = e(length);
        this.i = length - 1;
        this.j = i3;
        this.k = false;
    }

    public b a(boolean z, boolean z2) {
        String[] strArr;
        a[] aVarArr;
        int i;
        int i2;
        int i3;
        synchronized (this) {
            strArr = this.e;
            aVarArr = this.f;
            i = this.g;
            i2 = this.l;
            i3 = this.j;
        }
        return new b(this, z, z2, strArr, aVarArr, i, i2, i3);
    }

    private b f(int i) {
        return new b(null, true, true, this.e, this.f, this.g, i, this.j);
    }

    private void a(b bVar) {
        if (bVar.c() > 12000 || bVar.j > 63) {
            synchronized (this) {
                d(64);
                this.k = false;
            }
        } else if (bVar.c() > c()) {
            synchronized (this) {
                this.e = bVar.e;
                this.f = bVar.f;
                this.g = bVar.g;
                this.h = bVar.h;
                this.i = bVar.i;
                this.j = bVar.j;
                this.k = false;
            }
        }
    }

    public void b() {
        if (d() && this.b != null) {
            this.b.a(this);
            this.k = false;
        }
    }

    public int c() {
        return this.g;
    }

    public boolean d() {
        return this.k;
    }

    public int e() {
        return this.l;
    }

    public String a(char[] cArr, int i, int i2, int i3) {
        int i4;
        String a2;
        if (i2 < 1) {
            return "";
        }
        if (!this.d) {
            return new String(cArr, i, i2);
        }
        int b = b(i3);
        String str = this.e[b];
        if (str != null) {
            if (str.length() == i2) {
                int i5 = 0;
                while (str.charAt(i5) == cArr[i + i5] && (i5 = i5 + 1) < i2) {
                }
                if (i5 == i2) {
                    return str;
                }
            }
            a aVar = this.f[b >> 1];
            if (aVar != null && (a2 = aVar.a(cArr, i, i2)) != null) {
                return a2;
            }
        }
        if (!this.k) {
            f();
            this.k = true;
            i4 = b;
        } else if (this.g >= this.h) {
            g();
            i4 = b(a(cArr, i, i2));
        } else {
            i4 = b;
        }
        String str2 = new String(cArr, i, i2);
        if (this.c) {
            str2 = InternCache.instance.intern(str2);
        }
        this.g++;
        if (this.e[i4] == null) {
            this.e[i4] = str2;
            return str2;
        }
        int i6 = i4 >> 1;
        a aVar2 = new a(str2, this.f[i6]);
        this.f[i6] = aVar2;
        this.j = Math.max(aVar2.c(), this.j);
        if (this.j > 255) {
            c(255);
            return str2;
        }
        return str2;
    }

    public int b(int i) {
        return ((i >>> 15) + i) & this.i;
    }

    public int a(char[] cArr, int i, int i2) {
        int i3 = this.l;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = cArr[i4] + (i3 * 33);
            i4++;
            i3 = i5;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public int a(String str) {
        int length = str.length();
        int i = this.l;
        int i2 = 0;
        while (i2 < length) {
            int charAt = str.charAt(i2) + (i * 33);
            i2++;
            i = charAt;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    private void f() {
        String[] strArr = this.e;
        int length = strArr.length;
        this.e = new String[length];
        System.arraycopy(strArr, 0, this.e, 0, length);
        a[] aVarArr = this.f;
        int length2 = aVarArr.length;
        this.f = new a[length2];
        System.arraycopy(aVarArr, 0, this.f, 0, length2);
    }

    private void g() {
        int length = this.e.length;
        int i = length + length;
        if (i > 65536) {
            this.g = 0;
            Arrays.fill(this.e, (Object) null);
            Arrays.fill(this.f, (Object) null);
            this.k = true;
            return;
        }
        String[] strArr = this.e;
        a[] aVarArr = this.f;
        this.e = new String[i];
        this.f = new a[i >> 1];
        this.i = i - 1;
        this.h = e(i);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            String str = strArr[i4];
            if (str != null) {
                i3++;
                int b = b(a(str));
                if (this.e[b] == null) {
                    this.e[b] = str;
                } else {
                    int i5 = b >> 1;
                    a aVar = new a(str, this.f[i5]);
                    this.f[i5] = aVar;
                    i2 = Math.max(i2, aVar.c());
                }
            }
        }
        int i6 = length >> 1;
        int i7 = 0;
        int i8 = i3;
        int i9 = i2;
        while (i7 < i6) {
            int i10 = i9;
            for (a aVar2 = aVarArr[i7]; aVar2 != null; aVar2 = aVar2.b()) {
                i8++;
                String a2 = aVar2.a();
                int b2 = b(a(a2));
                if (this.e[b2] == null) {
                    this.e[b2] = a2;
                } else {
                    int i11 = b2 >> 1;
                    a aVar3 = new a(a2, this.f[i11]);
                    this.f[i11] = aVar3;
                    i10 = Math.max(i10, aVar3.c());
                }
            }
            i7++;
            i9 = i10;
        }
        this.j = i9;
        if (i8 != this.g) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this.g + " entries; now have " + i8 + ".");
        }
    }

    protected void c(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.g + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CharsToNameCanonicalizer.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f430a;
        private final a b;
        private final int c;

        public a(String str, a aVar) {
            this.f430a = str;
            this.b = aVar;
            this.c = aVar == null ? 1 : aVar.c + 1;
        }

        public String a() {
            return this.f430a;
        }

        public a b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public String a(char[] cArr, int i, int i2) {
            String str = this.f430a;
            a aVar = this.b;
            while (true) {
                if (str.length() == i2) {
                    int i3 = 0;
                    while (str.charAt(i3) == cArr[i + i3] && (i3 = i3 + 1) < i2) {
                    }
                    if (i3 == i2) {
                        return str;
                    }
                }
                if (aVar != null) {
                    str = aVar.a();
                    aVar = aVar.b();
                } else {
                    return null;
                }
            }
        }
    }
}
