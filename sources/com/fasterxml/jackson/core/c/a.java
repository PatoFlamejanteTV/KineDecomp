package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BytesToNameCanonicalizer.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    protected final a f426a;
    protected final AtomicReference<b> b;
    protected final boolean c;
    protected int d;
    protected int e;
    protected int f;
    protected int[] g;
    protected c[] h;
    protected C0025a[] i;
    protected int j;
    protected int k;
    private final int l;
    private transient boolean m;
    private boolean n;
    private boolean o;
    private boolean p;

    private a(int i, boolean z, int i2) {
        int i3 = 16;
        this.f426a = null;
        this.l = i2;
        this.c = z;
        if (i < 16) {
            i = 16;
        } else if (((i - 1) & i) != 0) {
            while (i3 < i) {
                i3 += i3;
            }
            i = i3;
        }
        this.b = new AtomicReference<>(e(i));
    }

    private a(a aVar, boolean z, int i, b bVar) {
        this.f426a = aVar;
        this.l = i;
        this.c = z;
        this.b = null;
        this.d = bVar.f428a;
        this.f = bVar.b;
        this.g = bVar.c;
        this.h = bVar.d;
        this.i = bVar.e;
        this.j = bVar.f;
        this.k = bVar.g;
        this.e = bVar.h;
        this.m = false;
        this.n = true;
        this.o = true;
        this.p = true;
    }

    private b e(int i) {
        return new b(0, i - 1, new int[i], new c[i], null, 0, 0, 0);
    }

    public static a a() {
        long currentTimeMillis = System.currentTimeMillis();
        return a((((int) (currentTimeMillis >>> 32)) + ((int) currentTimeMillis)) | 1);
    }

    protected static a a(int i) {
        return new a(64, true, i);
    }

    public a a(boolean z, boolean z2) {
        return new a(this, z2, this.l, this.b.get());
    }

    public void b() {
        if (this.f426a != null && c()) {
            this.f426a.a(new b(this));
            this.n = true;
            this.o = true;
            this.p = true;
        }
    }

    private void a(b bVar) {
        int i = bVar.f428a;
        b bVar2 = this.b.get();
        if (i > bVar2.f428a) {
            if (i > 6000 || bVar.h > 63) {
                bVar = e(64);
            }
            this.b.compareAndSet(bVar2, bVar);
        }
    }

    public boolean c() {
        return !this.n;
    }

    public static c d() {
        return d.b();
    }

    public c b(int i) {
        int c = c(i);
        int i2 = this.f & c;
        int i3 = this.g[i2];
        if ((((i3 >> 8) ^ c) << 8) == 0) {
            c cVar = this.h[i2];
            if (cVar == null) {
                return null;
            }
            if (cVar.a(i)) {
                return cVar;
            }
        } else if (i3 == 0) {
            return null;
        }
        int i4 = i3 & 255;
        if (i4 <= 0) {
            return null;
        }
        C0025a c0025a = this.i[i4 - 1];
        if (c0025a != null) {
            return c0025a.a(c, i, 0);
        }
        return null;
    }

    public c a(int i, int i2) {
        int c = i2 == 0 ? c(i) : b(i, i2);
        int i3 = this.f & c;
        int i4 = this.g[i3];
        if ((((i4 >> 8) ^ c) << 8) == 0) {
            c cVar = this.h[i3];
            if (cVar == null) {
                return null;
            }
            if (cVar.a(i, i2)) {
                return cVar;
            }
        } else if (i4 == 0) {
            return null;
        }
        int i5 = i4 & 255;
        if (i5 > 0) {
            C0025a c0025a = this.i[i5 - 1];
            if (c0025a != null) {
                return c0025a.a(c, i, i2);
            }
        }
        return null;
    }

    public c a(int[] iArr, int i) {
        if (i < 3) {
            return a(iArr[0], i >= 2 ? iArr[1] : 0);
        }
        int b2 = b(iArr, i);
        int i2 = this.f & b2;
        int i3 = this.g[i2];
        if ((((i3 >> 8) ^ b2) << 8) == 0) {
            c cVar = this.h[i2];
            if (cVar == null || cVar.a(iArr, i)) {
                return cVar;
            }
        } else if (i3 == 0) {
            return null;
        }
        int i4 = i3 & 255;
        if (i4 > 0) {
            C0025a c0025a = this.i[i4 - 1];
            if (c0025a != null) {
                return c0025a.a(b2, iArr, i);
            }
        }
        return null;
    }

    public c a(String str, int[] iArr, int i) {
        int b2;
        if (this.c) {
            str = InternCache.instance.intern(str);
        }
        if (i < 3) {
            b2 = i == 1 ? c(iArr[0]) : b(iArr[0], iArr[1]);
        } else {
            b2 = b(iArr, i);
        }
        c a2 = a(b2, str, iArr, i);
        a(b2, a2);
        return a2;
    }

    public int c(int i) {
        int i2 = this.l ^ i;
        int i3 = i2 + (i2 >>> 15);
        return i3 ^ (i3 >>> 9);
    }

    public int b(int i, int i2) {
        int i3 = (((i >>> 15) ^ i) + (i2 * 33)) ^ this.l;
        return i3 + (i3 >>> 7);
    }

    public int b(int[] iArr, int i) {
        if (i < 3) {
            throw new IllegalArgumentException();
        }
        int i2 = iArr[0] ^ this.l;
        int i3 = (((i2 + (i2 >>> 9)) * 33) + iArr[1]) * 65599;
        int i4 = (i3 + (i3 >>> 15)) ^ iArr[2];
        int i5 = i4 + (i4 >>> 17);
        for (int i6 = 3; i6 < i; i6++) {
            int i7 = (i5 * 31) ^ iArr[i6];
            int i8 = i7 + (i7 >>> 3);
            i5 = i8 ^ (i8 << 7);
        }
        int i9 = (i5 >>> 15) + i5;
        return i9 ^ (i9 << 9);
    }

    private void a(int i, c cVar) {
        int i2;
        if (this.n) {
            h();
        }
        if (this.m) {
            e();
        }
        this.d++;
        int i3 = i & this.f;
        if (this.h[i3] == null) {
            this.g[i3] = i << 8;
            if (this.o) {
                j();
            }
            this.h[i3] = cVar;
        } else {
            if (this.p) {
                i();
            }
            this.j++;
            int i4 = this.g[i3];
            int i5 = i4 & 255;
            if (i5 == 0) {
                if (this.k <= 254) {
                    i2 = this.k;
                    this.k++;
                    if (i2 >= this.i.length) {
                        k();
                    }
                } else {
                    i2 = g();
                }
                this.g[i3] = (i4 & (-256)) | (i2 + 1);
            } else {
                i2 = i5 - 1;
            }
            C0025a c0025a = new C0025a(cVar, this.i[i2]);
            this.i[i2] = c0025a;
            this.e = Math.max(c0025a.a(), this.e);
            if (this.e > 255) {
                d(255);
            }
        }
        int length = this.g.length;
        if (this.d > (length >> 1)) {
            int i6 = length >> 2;
            if (this.d > length - i6) {
                this.m = true;
            } else if (this.j >= i6) {
                this.m = true;
            }
        }
    }

    private void e() {
        int i;
        int max;
        int i2 = 0;
        this.m = false;
        this.o = false;
        int length = this.g.length;
        int i3 = length + length;
        if (i3 > 65536) {
            f();
            return;
        }
        this.g = new int[i3];
        this.f = i3 - 1;
        c[] cVarArr = this.h;
        this.h = new c[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            c cVar = cVarArr[i5];
            if (cVar != null) {
                i4++;
                int hashCode = cVar.hashCode();
                int i6 = this.f & hashCode;
                this.h[i6] = cVar;
                this.g[i6] = hashCode << 8;
            }
        }
        int i7 = this.k;
        if (i7 == 0) {
            this.e = 0;
            return;
        }
        this.j = 0;
        this.k = 0;
        this.p = false;
        C0025a[] c0025aArr = this.i;
        this.i = new C0025a[c0025aArr.length];
        int i8 = 0;
        int i9 = i4;
        while (i8 < i7) {
            int i10 = i9;
            C0025a c0025a = c0025aArr[i8];
            while (c0025a != null) {
                int i11 = i10 + 1;
                c cVar2 = c0025a.f427a;
                int hashCode2 = cVar2.hashCode();
                int i12 = this.f & hashCode2;
                int i13 = this.g[i12];
                if (this.h[i12] == null) {
                    this.g[i12] = hashCode2 << 8;
                    this.h[i12] = cVar2;
                    max = i2;
                } else {
                    this.j++;
                    int i14 = i13 & 255;
                    if (i14 == 0) {
                        if (this.k <= 254) {
                            i = this.k;
                            this.k++;
                            if (i >= this.i.length) {
                                k();
                            }
                        } else {
                            i = g();
                        }
                        this.g[i12] = (i13 & (-256)) | (i + 1);
                    } else {
                        i = i14 - 1;
                    }
                    C0025a c0025a2 = new C0025a(cVar2, this.i[i]);
                    this.i[i] = c0025a2;
                    max = Math.max(i2, c0025a2.a());
                }
                c0025a = c0025a.b;
                i2 = max;
                i10 = i11;
            }
            i8++;
            i9 = i10;
        }
        this.e = i2;
        if (i9 != this.d) {
            throw new RuntimeException("Internal error: count after rehash " + i9 + "; should be " + this.d);
        }
    }

    private void f() {
        this.d = 0;
        this.e = 0;
        Arrays.fill(this.g, 0);
        Arrays.fill(this.h, (Object) null);
        Arrays.fill(this.i, (Object) null);
        this.j = 0;
        this.k = 0;
    }

    private int g() {
        C0025a[] c0025aArr = this.i;
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        int i4 = this.k;
        while (i3 < i4) {
            int a2 = c0025aArr[i3].a();
            if (a2 >= i) {
                a2 = i;
            } else {
                if (a2 == 1) {
                    return i3;
                }
                i2 = i3;
            }
            i3++;
            i = a2;
        }
        return i2;
    }

    private void h() {
        int[] iArr = this.g;
        int length = this.g.length;
        this.g = new int[length];
        System.arraycopy(iArr, 0, this.g, 0, length);
        this.n = false;
    }

    private void i() {
        C0025a[] c0025aArr = this.i;
        if (c0025aArr == null) {
            this.i = new C0025a[32];
        } else {
            int length = c0025aArr.length;
            this.i = new C0025a[length];
            System.arraycopy(c0025aArr, 0, this.i, 0, length);
        }
        this.p = false;
    }

    private void j() {
        c[] cVarArr = this.h;
        int length = cVarArr.length;
        this.h = new c[length];
        System.arraycopy(cVarArr, 0, this.h, 0, length);
        this.o = false;
    }

    private void k() {
        C0025a[] c0025aArr = this.i;
        int length = c0025aArr.length;
        this.i = new C0025a[length + length];
        System.arraycopy(c0025aArr, 0, this.i, 0, length);
    }

    private static c a(int i, String str, int[] iArr, int i2) {
        if (i2 < 4) {
            switch (i2) {
                case 1:
                    return new d(str, i, iArr[0]);
                case 2:
                    return new e(str, i, iArr[0], iArr[1]);
                case 3:
                    return new f(str, i, iArr[0], iArr[1], iArr[2]);
            }
        }
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr2[i3] = iArr[i3];
        }
        return new g(str, i, iArr2, i2);
    }

    protected void d(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.d + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BytesToNameCanonicalizer.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f428a;
        public final int b;
        public final int[] c;
        public final c[] d;
        public final C0025a[] e;
        public final int f;
        public final int g;
        public final int h;

        public b(int i, int i2, int[] iArr, c[] cVarArr, C0025a[] c0025aArr, int i3, int i4, int i5) {
            this.f428a = i;
            this.b = i2;
            this.c = iArr;
            this.d = cVarArr;
            this.e = c0025aArr;
            this.f = i3;
            this.g = i4;
            this.h = i5;
        }

        public b(a aVar) {
            this.f428a = aVar.d;
            this.b = aVar.f;
            this.c = aVar.g;
            this.d = aVar.h;
            this.e = aVar.i;
            this.f = aVar.j;
            this.g = aVar.k;
            this.h = aVar.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BytesToNameCanonicalizer.java */
    /* renamed from: com.fasterxml.jackson.core.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0025a {

        /* renamed from: a, reason: collision with root package name */
        protected final c f427a;
        protected final C0025a b;
        private final int c;

        C0025a(c cVar, C0025a c0025a) {
            this.f427a = cVar;
            this.b = c0025a;
            this.c = c0025a == null ? 1 : c0025a.c + 1;
        }

        public int a() {
            return this.c;
        }

        public c a(int i, int i2, int i3) {
            if (this.f427a.hashCode() == i && this.f427a.a(i2, i3)) {
                return this.f427a;
            }
            for (C0025a c0025a = this.b; c0025a != null; c0025a = c0025a.b) {
                c cVar = c0025a.f427a;
                if (cVar.hashCode() == i && cVar.a(i2, i3)) {
                    return cVar;
                }
            }
            return null;
        }

        public c a(int i, int[] iArr, int i2) {
            if (this.f427a.hashCode() == i && this.f427a.a(iArr, i2)) {
                return this.f427a;
            }
            for (C0025a c0025a = this.b; c0025a != null; c0025a = c0025a.b) {
                c cVar = c0025a.f427a;
                if (cVar.hashCode() == i && cVar.a(iArr, i2)) {
                    return cVar;
                }
            }
            return null;
        }
    }
}
