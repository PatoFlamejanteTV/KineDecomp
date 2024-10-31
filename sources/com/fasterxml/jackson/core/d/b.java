package com.fasterxml.jackson.core.d;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CharsToNameCanonicalizer.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final b f9732a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<C0064b> f9733b;

    /* renamed from: c, reason: collision with root package name */
    private final int f9734c;

    /* renamed from: d, reason: collision with root package name */
    private final int f9735d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9736e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f9737f;

    /* renamed from: g, reason: collision with root package name */
    private a[] f9738g;

    /* renamed from: h, reason: collision with root package name */
    private int f9739h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private BitSet m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CharsToNameCanonicalizer.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f9740a;

        /* renamed from: b, reason: collision with root package name */
        public final a f9741b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9742c;

        public a(String str, a aVar) {
            this.f9740a = str;
            this.f9741b = aVar;
            this.f9742c = aVar != null ? 1 + aVar.f9742c : 1;
        }

        public String a(char[] cArr, int i, int i2) {
            if (this.f9740a.length() != i2) {
                return null;
            }
            int i3 = 0;
            while (this.f9740a.charAt(i3) == cArr[i + i3]) {
                i3++;
                if (i3 >= i2) {
                    return this.f9740a;
                }
            }
            return null;
        }
    }

    private b(int i) {
        this.f9732a = null;
        this.f9734c = i;
        this.f9736e = true;
        this.f9735d = -1;
        this.l = false;
        this.k = 0;
        this.f9733b = new AtomicReference<>(C0064b.a(64));
    }

    private static int e(int i) {
        return i - (i >> 2);
    }

    private void e() {
        String[] strArr = this.f9737f;
        this.f9737f = (String[]) Arrays.copyOf(strArr, strArr.length);
        a[] aVarArr = this.f9738g;
        this.f9738g = (a[]) Arrays.copyOf(aVarArr, aVarArr.length);
    }

    private void f() {
        String[] strArr = this.f9737f;
        int length = strArr.length;
        int i = length + length;
        if (i > 65536) {
            this.f9739h = 0;
            this.f9736e = false;
            this.f9737f = new String[64];
            this.f9738g = new a[32];
            this.j = 63;
            this.l = false;
            return;
        }
        a[] aVarArr = this.f9738g;
        this.f9737f = new String[i];
        this.f9738g = new a[i >> 1];
        this.j = i - 1;
        this.i = e(i);
        int i2 = 0;
        int i3 = 0;
        for (String str : strArr) {
            if (str != null) {
                i2++;
                int a2 = a(a(str));
                String[] strArr2 = this.f9737f;
                if (strArr2[a2] == null) {
                    strArr2[a2] = str;
                } else {
                    int i4 = a2 >> 1;
                    a aVar = new a(str, this.f9738g[i4]);
                    this.f9738g[i4] = aVar;
                    i3 = Math.max(i3, aVar.f9742c);
                }
            }
        }
        int i5 = length >> 1;
        for (int i6 = 0; i6 < i5; i6++) {
            for (a aVar2 = aVarArr[i6]; aVar2 != null; aVar2 = aVar2.f9741b) {
                i2++;
                String str2 = aVar2.f9740a;
                int a3 = a(a(str2));
                String[] strArr3 = this.f9737f;
                if (strArr3[a3] == null) {
                    strArr3[a3] = str2;
                } else {
                    int i7 = a3 >> 1;
                    a aVar3 = new a(str2, this.f9738g[i7]);
                    this.f9738g[i7] = aVar3;
                    i3 = Math.max(i3, aVar3.f9742c);
                }
            }
        }
        this.k = i3;
        this.m = null;
        int i8 = this.f9739h;
        if (i2 != i8) {
            throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", Integer.valueOf(i8), Integer.valueOf(i2)));
        }
    }

    public static b a() {
        long currentTimeMillis = System.currentTimeMillis();
        return b((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    protected static b b(int i) {
        return new b(i);
    }

    public b c(int i) {
        return new b(this, i, this.f9734c, this.f9733b.get());
    }

    public void d() {
        b bVar;
        if (c() && (bVar = this.f9732a) != null && this.f9736e) {
            bVar.a(new C0064b(this));
            this.l = true;
        }
    }

    public int b() {
        return this.f9734c;
    }

    public boolean c() {
        return !this.l;
    }

    private void a(C0064b c0064b) {
        int i = c0064b.f9743a;
        C0064b c0064b2 = this.f9733b.get();
        if (i == c0064b2.f9743a) {
            return;
        }
        if (i > 12000) {
            c0064b = C0064b.a(64);
        }
        this.f9733b.compareAndSet(c0064b2, c0064b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharsToNameCanonicalizer.java */
    /* renamed from: com.fasterxml.jackson.core.d.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0064b {

        /* renamed from: a, reason: collision with root package name */
        final int f9743a;

        /* renamed from: b, reason: collision with root package name */
        final int f9744b;

        /* renamed from: c, reason: collision with root package name */
        final String[] f9745c;

        /* renamed from: d, reason: collision with root package name */
        final a[] f9746d;

        public C0064b(int i, int i2, String[] strArr, a[] aVarArr) {
            this.f9743a = i;
            this.f9744b = i2;
            this.f9745c = strArr;
            this.f9746d = aVarArr;
        }

        public static C0064b a(int i) {
            return new C0064b(0, 0, new String[i], new a[i >> 1]);
        }

        public C0064b(b bVar) {
            this.f9743a = bVar.f9739h;
            this.f9744b = bVar.k;
            this.f9745c = bVar.f9737f;
            this.f9746d = bVar.f9738g;
        }
    }

    protected void d(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.f9739h + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }

    private b(b bVar, int i, int i2, C0064b c0064b) {
        this.f9732a = bVar;
        this.f9734c = i2;
        this.f9733b = null;
        this.f9735d = i;
        this.f9736e = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i);
        this.f9737f = c0064b.f9745c;
        this.f9738g = c0064b.f9746d;
        this.f9739h = c0064b.f9743a;
        this.k = c0064b.f9744b;
        int length = this.f9737f.length;
        this.i = e(length);
        this.j = length - 1;
        this.l = true;
    }

    public String a(char[] cArr, int i, int i2, int i3) {
        if (i2 < 1) {
            return "";
        }
        if (!this.f9736e) {
            return new String(cArr, i, i2);
        }
        int a2 = a(i3);
        String str = this.f9737f[a2];
        if (str != null) {
            if (str.length() == i2) {
                int i4 = 0;
                while (str.charAt(i4) == cArr[i + i4]) {
                    i4++;
                    if (i4 == i2) {
                        return str;
                    }
                }
            }
            a aVar = this.f9738g[a2 >> 1];
            if (aVar != null) {
                String a3 = aVar.a(cArr, i, i2);
                if (a3 != null) {
                    return a3;
                }
                String a4 = a(cArr, i, i2, aVar.f9741b);
                if (a4 != null) {
                    return a4;
                }
            }
        }
        return a(cArr, i, i2, i3, a2);
    }

    private String a(char[] cArr, int i, int i2, a aVar) {
        while (aVar != null) {
            String a2 = aVar.a(cArr, i, i2);
            if (a2 != null) {
                return a2;
            }
            aVar = aVar.f9741b;
        }
        return null;
    }

    private String a(char[] cArr, int i, int i2, int i3, int i4) {
        if (this.l) {
            e();
            this.l = false;
        } else if (this.f9739h >= this.i) {
            f();
            i4 = a(a(cArr, i, i2));
        }
        String str = new String(cArr, i, i2);
        if (JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(this.f9735d)) {
            str = InternCache.instance.intern(str);
        }
        this.f9739h++;
        String[] strArr = this.f9737f;
        if (strArr[i4] == null) {
            strArr[i4] = str;
        } else {
            int i5 = i4 >> 1;
            a aVar = new a(str, this.f9738g[i5]);
            int i6 = aVar.f9742c;
            if (i6 > 100) {
                a(i5, aVar);
            } else {
                this.f9738g[i5] = aVar;
                this.k = Math.max(i6, this.k);
            }
        }
        return str;
    }

    private void a(int i, a aVar) {
        BitSet bitSet = this.m;
        if (bitSet == null) {
            this.m = new BitSet();
            this.m.set(i);
        } else if (bitSet.get(i)) {
            if (!JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(this.f9735d)) {
                this.f9736e = false;
            } else {
                d(100);
                throw null;
            }
        } else {
            this.m.set(i);
        }
        this.f9737f[i + i] = aVar.f9740a;
        this.f9738g[i] = null;
        this.f9739h -= aVar.f9742c;
        this.k = -1;
    }

    public int a(int i) {
        int i2 = i + (i >>> 15);
        int i3 = i2 ^ (i2 << 7);
        return (i3 + (i3 >>> 3)) & this.j;
    }

    public int a(char[] cArr, int i, int i2) {
        int i3 = this.f9734c;
        int i4 = i2 + i;
        while (i < i4) {
            i3 = (i3 * 33) + cArr[i];
            i++;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public int a(String str) {
        int length = str.length();
        int i = this.f9734c;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i * 33) + str.charAt(i2);
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
