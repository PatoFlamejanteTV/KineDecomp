package com.fasterxml.jackson.core.d;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ByteQuadsCanonicalizer.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final a f9717a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<C0063a> f9718b;

    /* renamed from: c, reason: collision with root package name */
    private final int f9719c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9720d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f9721e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f9722f;

    /* renamed from: g, reason: collision with root package name */
    private int f9723g;

    /* renamed from: h, reason: collision with root package name */
    private int f9724h;
    private int i;
    private int j;
    private int k;
    private String[] l;
    private int m;
    private int n;
    private transient boolean o;
    private boolean p;

    private a(int i, boolean z, int i2, boolean z2) {
        this.f9717a = null;
        this.f9719c = i2;
        this.f9720d = z;
        this.f9721e = z2;
        int i3 = 16;
        if (i >= 16) {
            if (((i - 1) & i) != 0) {
                while (i3 < i) {
                    i3 += i3;
                }
            } else {
                i3 = i;
            }
        }
        this.f9718b = new AtomicReference<>(C0063a.a(i3));
    }

    static int a(int i) {
        int i2 = i >> 2;
        if (i2 < 64) {
            return 4;
        }
        if (i2 <= 256) {
            return 5;
        }
        return i2 <= 1024 ? 6 : 7;
    }

    private final int j() {
        int i = this.f9723g;
        return (i << 3) - i;
    }

    private void k() {
        if (this.k > (this.f9723g >> 1)) {
            int j = (this.m - j()) >> 2;
            int i = this.k;
            if (j <= ((i + 1) >> 7)) {
                double d2 = i;
                double d3 = this.f9723g;
                Double.isNaN(d3);
                if (d2 <= d3 * 0.8d) {
                    return;
                }
            }
            this.o = true;
        }
    }

    private void l() {
        if (this.p) {
            int[] iArr = this.f9722f;
            this.f9722f = Arrays.copyOf(iArr, iArr.length);
            String[] strArr = this.l;
            this.l = (String[]) Arrays.copyOf(strArr, strArr.length);
            this.p = false;
            k();
        }
        if (this.o) {
            m();
        }
    }

    private void m() {
        this.o = false;
        this.p = false;
        int[] iArr = this.f9722f;
        String[] strArr = this.l;
        int i = this.f9723g;
        int i2 = this.k;
        int i3 = i + i;
        int i4 = this.m;
        if (i3 > 65536) {
            a(true);
            return;
        }
        this.f9722f = new int[iArr.length + (i << 3)];
        this.f9723g = i3;
        this.f9724h = i3 << 2;
        int i5 = this.f9724h;
        this.i = i5 + (i5 >> 1);
        this.j = a(i3);
        this.l = new String[strArr.length << 1];
        a(false);
        int[] iArr2 = new int[16];
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7 += 4) {
            int i8 = iArr[i7 + 3];
            if (i8 != 0) {
                i6++;
                String str = strArr[i7 >> 2];
                if (i8 == 1) {
                    iArr2[0] = iArr[i7];
                    a(str, iArr2, 1);
                } else if (i8 == 2) {
                    iArr2[0] = iArr[i7];
                    iArr2[1] = iArr[i7 + 1];
                    a(str, iArr2, 2);
                } else if (i8 != 3) {
                    if (i8 > iArr2.length) {
                        iArr2 = new int[i8];
                    }
                    System.arraycopy(iArr, iArr[i7 + 1], iArr2, 0, i8);
                    a(str, iArr2, i8);
                } else {
                    iArr2[0] = iArr[i7];
                    iArr2[1] = iArr[i7 + 1];
                    iArr2[2] = iArr[i7 + 2];
                    a(str, iArr2, 3);
                }
            }
        }
        if (i6 == i2) {
            return;
        }
        throw new IllegalStateException("Failed rehash(): old count=" + i2 + ", copyCount=" + i6);
    }

    public int h() {
        int i = this.i + 3;
        int i2 = this.f9723g + i;
        int i3 = 0;
        while (i < i2) {
            if (this.f9722f[i] != 0) {
                i3++;
            }
            i += 4;
        }
        return i3;
    }

    public int i() {
        int i = this.f9723g << 3;
        int i2 = 0;
        for (int i3 = 3; i3 < i; i3 += 4) {
            if (this.f9722f[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    public String toString() {
        int d2 = d();
        int f2 = f();
        int h2 = h();
        int g2 = g();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", a.class.getName(), Integer.valueOf(this.k), Integer.valueOf(this.f9723g), Integer.valueOf(d2), Integer.valueOf(f2), Integer.valueOf(h2), Integer.valueOf(g2), Integer.valueOf(d2 + f2 + h2 + g2), Integer.valueOf(i()));
    }

    private void a(C0063a c0063a) {
        int i = c0063a.f9726b;
        C0063a c0063a2 = this.f9718b.get();
        if (i == c0063a2.f9726b) {
            return;
        }
        if (i > 6000) {
            c0063a = C0063a.a(64);
        }
        this.f9718b.compareAndSet(c0063a2, c0063a);
    }

    public static a b() {
        long currentTimeMillis = System.currentTimeMillis();
        return c((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    protected static a c(int i) {
        return new a(64, true, i, true);
    }

    public int d() {
        int i = this.f9724h;
        int i2 = 0;
        for (int i3 = 3; i3 < i; i3 += 4) {
            if (this.f9722f[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    public a e(int i) {
        return new a(this, JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(i), this.f9719c, JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(i), this.f9718b.get());
    }

    public int f() {
        int i = this.i;
        int i2 = 0;
        for (int i3 = this.f9724h + 3; i3 < i; i3 += 4) {
            if (this.f9722f[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    public int g() {
        return (this.m - j()) >> 2;
    }

    private int g(int i) {
        int f2 = f(i);
        int[] iArr = this.f9722f;
        if (iArr[f2 + 3] == 0) {
            return f2;
        }
        int i2 = this.f9724h + ((f2 >> 3) << 2);
        if (iArr[i2 + 3] == 0) {
            return i2;
        }
        int i3 = this.i;
        int i4 = this.j;
        int i5 = i3 + ((f2 >> (i4 + 2)) << i4);
        int i6 = (1 << i4) + i5;
        while (i5 < i6) {
            if (iArr[i5 + 3] == 0) {
                return i5;
            }
            i5 += 4;
        }
        int i7 = this.m;
        this.m = i7 + 4;
        if (this.m >= (this.f9723g << 3)) {
            if (this.f9721e) {
                a();
            }
            this.o = true;
        }
        return i7;
    }

    public boolean c() {
        return !this.p;
    }

    public void e() {
        if (this.f9717a == null || !c()) {
            return;
        }
        this.f9717a.a(new C0063a(this));
        this.p = true;
    }

    private String c(int i, int i2) {
        int i3 = this.i;
        int i4 = this.j;
        int i5 = i3 + ((i >> (i4 + 2)) << i4);
        int[] iArr = this.f9722f;
        int i6 = (1 << i4) + i5;
        while (i5 < i6) {
            int i7 = iArr[i5 + 3];
            if (i2 == iArr[i5] && 1 == i7) {
                return this.l[i5 >> 2];
            }
            if (i7 == 0) {
                return null;
            }
            i5 += 4;
        }
        for (int j = j(); j < this.m; j += 4) {
            if (i2 == iArr[j] && 1 == iArr[j + 3]) {
                return this.l[j >> 2];
            }
        }
        return null;
    }

    public String b(int i, int i2) {
        int f2 = f(a(i, i2));
        int[] iArr = this.f9722f;
        int i3 = iArr[f2 + 3];
        if (i3 == 2) {
            if (i == iArr[f2] && i2 == iArr[f2 + 1]) {
                return this.l[f2 >> 2];
            }
        } else if (i3 == 0) {
            return null;
        }
        int i4 = this.f9724h + ((f2 >> 3) << 2);
        int i5 = iArr[i4 + 3];
        if (i5 == 2) {
            if (i == iArr[i4] && i2 == iArr[i4 + 1]) {
                return this.l[i4 >> 2];
            }
        } else if (i5 == 0) {
            return null;
        }
        return c(f2, i, i2);
    }

    public String d(int i) {
        int f2 = f(b(i));
        int[] iArr = this.f9722f;
        int i2 = iArr[f2 + 3];
        if (i2 == 1) {
            if (iArr[f2] == i) {
                return this.l[f2 >> 2];
            }
        } else if (i2 == 0) {
            return null;
        }
        int i3 = this.f9724h + ((f2 >> 3) << 2);
        int i4 = iArr[i3 + 3];
        if (i4 == 1) {
            if (iArr[i3] == i) {
                return this.l[i3 >> 2];
            }
        } else if (i4 == 0) {
            return null;
        }
        return c(f2, i);
    }

    private final int f(int i) {
        return (i & (this.f9723g - 1)) << 2;
    }

    private a(a aVar, boolean z, int i, boolean z2, C0063a c0063a) {
        this.f9717a = aVar;
        this.f9719c = i;
        this.f9720d = z;
        this.f9721e = z2;
        this.f9718b = null;
        this.k = c0063a.f9726b;
        this.f9723g = c0063a.f9725a;
        this.f9724h = this.f9723g << 2;
        int i2 = this.f9724h;
        this.i = i2 + (i2 >> 1);
        this.j = c0063a.f9727c;
        this.f9722f = c0063a.f9728d;
        this.l = c0063a.f9729e;
        this.m = c0063a.f9730f;
        this.n = c0063a.f9731g;
        this.o = false;
        this.p = true;
    }

    private String a(int i, int i2, int i3, int i4) {
        int i5 = this.i;
        int i6 = this.j;
        int i7 = i5 + ((i >> (i6 + 2)) << i6);
        int[] iArr = this.f9722f;
        int i8 = (1 << i6) + i7;
        while (i7 < i8) {
            int i9 = iArr[i7 + 3];
            if (i2 == iArr[i7] && i3 == iArr[i7 + 1] && i4 == iArr[i7 + 2] && 3 == i9) {
                return this.l[i7 >> 2];
            }
            if (i9 == 0) {
                return null;
            }
            i7 += 4;
        }
        for (int j = j(); j < this.m; j += 4) {
            if (i2 == iArr[j] && i3 == iArr[j + 1] && i4 == iArr[j + 2] && 3 == iArr[j + 3]) {
                return this.l[j >> 2];
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteQuadsCanonicalizer.java */
    /* renamed from: com.fasterxml.jackson.core.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0063a {

        /* renamed from: a, reason: collision with root package name */
        public final int f9725a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9726b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9727c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f9728d;

        /* renamed from: e, reason: collision with root package name */
        public final String[] f9729e;

        /* renamed from: f, reason: collision with root package name */
        public final int f9730f;

        /* renamed from: g, reason: collision with root package name */
        public final int f9731g;

        public C0063a(int i, int i2, int i3, int[] iArr, String[] strArr, int i4, int i5) {
            this.f9725a = i;
            this.f9726b = i2;
            this.f9727c = i3;
            this.f9728d = iArr;
            this.f9729e = strArr;
            this.f9730f = i4;
            this.f9731g = i5;
        }

        public static C0063a a(int i) {
            int i2 = i << 3;
            return new C0063a(i, 0, a.a(i), new int[i2], new String[i << 1], i2 - i, i2);
        }

        public C0063a(a aVar) {
            this.f9725a = aVar.f9723g;
            this.f9726b = aVar.k;
            this.f9727c = aVar.j;
            this.f9728d = aVar.f9722f;
            this.f9729e = aVar.l;
            this.f9730f = aVar.m;
            this.f9731g = aVar.n;
        }
    }

    private String c(int i, int i2, int i3) {
        int i4 = this.i;
        int i5 = this.j;
        int i6 = i4 + ((i >> (i5 + 2)) << i5);
        int[] iArr = this.f9722f;
        int i7 = (1 << i5) + i6;
        while (i6 < i7) {
            int i8 = iArr[i6 + 3];
            if (i2 == iArr[i6] && i3 == iArr[i6 + 1] && 2 == i8) {
                return this.l[i6 >> 2];
            }
            if (i8 == 0) {
                return null;
            }
            i6 += 4;
        }
        for (int j = j(); j < this.m; j += 4) {
            if (i2 == iArr[j] && i3 == iArr[j + 1] && 2 == iArr[j + 3]) {
                return this.l[j >> 2];
            }
        }
        return null;
    }

    public String b(int i, int i2, int i3) {
        int f2 = f(a(i, i2, i3));
        int[] iArr = this.f9722f;
        int i4 = iArr[f2 + 3];
        if (i4 == 3) {
            if (i == iArr[f2] && iArr[f2 + 1] == i2 && iArr[f2 + 2] == i3) {
                return this.l[f2 >> 2];
            }
        } else if (i4 == 0) {
            return null;
        }
        int i5 = this.f9724h + ((f2 >> 3) << 2);
        int i6 = iArr[i5 + 3];
        if (i6 == 3) {
            if (i == iArr[i5] && iArr[i5 + 1] == i2 && iArr[i5 + 2] == i3) {
                return this.l[i5 >> 2];
            }
        } else if (i6 == 0) {
            return null;
        }
        return a(f2, i, i2, i3);
    }

    private String a(int i, int i2, int[] iArr, int i3) {
        int i4 = this.i;
        int i5 = this.j;
        int i6 = i4 + ((i >> (i5 + 2)) << i5);
        int[] iArr2 = this.f9722f;
        int i7 = (1 << i5) + i6;
        while (i6 < i7) {
            int i8 = iArr2[i6 + 3];
            if (i2 == iArr2[i6] && i3 == i8 && a(iArr, i3, iArr2[i6 + 1])) {
                return this.l[i6 >> 2];
            }
            if (i8 == 0) {
                return null;
            }
            i6 += 4;
        }
        for (int j = j(); j < this.m; j += 4) {
            if (i2 == iArr2[j] && i3 == iArr2[j + 3] && a(iArr, i3, iArr2[j + 1])) {
                return this.l[j >> 2];
            }
        }
        return null;
    }

    private int c(int[] iArr, int i) {
        int i2 = this.n;
        int i3 = i2 + i;
        int[] iArr2 = this.f9722f;
        if (i3 > iArr2.length) {
            this.f9722f = Arrays.copyOf(this.f9722f, this.f9722f.length + Math.max(i3 - iArr2.length, Math.min(4096, this.f9723g)));
        }
        System.arraycopy(iArr, 0, this.f9722f, i2, i);
        this.n += i;
        return i2;
    }

    public String b(int[] iArr, int i) {
        if (i < 4) {
            if (i == 1) {
                return d(iArr[0]);
            }
            if (i != 2) {
                return i != 3 ? "" : b(iArr[0], iArr[1], iArr[2]);
            }
            return b(iArr[0], iArr[1]);
        }
        int a2 = a(iArr, i);
        int f2 = f(a2);
        int[] iArr2 = this.f9722f;
        int i2 = iArr2[f2 + 3];
        if (a2 == iArr2[f2] && i2 == i && a(iArr, i, iArr2[f2 + 1])) {
            return this.l[f2 >> 2];
        }
        if (i2 == 0) {
            return null;
        }
        int i3 = this.f9724h + ((f2 >> 3) << 2);
        int i4 = iArr2[i3 + 3];
        if (a2 == iArr2[i3] && i4 == i && a(iArr, i, iArr2[i3 + 1])) {
            return this.l[i3 >> 2];
        }
        return a(f2, a2, iArr, i);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0023 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(int[] r6, int r7, int r8) {
        /*
            r5 = this;
            int[] r0 = r5.f9722f
            r1 = 0
            r2 = 1
            switch(r7) {
                case 4: goto L42;
                case 5: goto L34;
                case 6: goto L26;
                case 7: goto L18;
                case 8: goto Lc;
                default: goto L7;
            }
        L7:
            boolean r6 = r5.b(r6, r7, r8)
            return r6
        Lc:
            r7 = r6[r1]
            int r3 = r8 + 1
            r8 = r0[r8]
            if (r7 == r8) goto L15
            return r1
        L15:
            r8 = r3
            r7 = 1
            goto L19
        L18:
            r7 = 0
        L19:
            int r3 = r7 + 1
            r7 = r6[r7]
            int r4 = r8 + 1
            r8 = r0[r8]
            if (r7 == r8) goto L24
            return r1
        L24:
            r8 = r4
            goto L27
        L26:
            r3 = 0
        L27:
            int r7 = r3 + 1
            r3 = r6[r3]
            int r4 = r8 + 1
            r8 = r0[r8]
            if (r3 == r8) goto L32
            return r1
        L32:
            r8 = r4
            goto L35
        L34:
            r7 = 0
        L35:
            int r3 = r7 + 1
            r7 = r6[r7]
            int r4 = r8 + 1
            r8 = r0[r8]
            if (r7 == r8) goto L40
            return r1
        L40:
            r8 = r4
            goto L43
        L42:
            r3 = 0
        L43:
            int r7 = r3 + 1
            r3 = r6[r3]
            int r4 = r8 + 1
            r8 = r0[r8]
            if (r3 == r8) goto L4e
            return r1
        L4e:
            int r8 = r7 + 1
            r7 = r6[r7]
            int r3 = r4 + 1
            r4 = r0[r4]
            if (r7 == r4) goto L59
            return r1
        L59:
            int r7 = r8 + 1
            r8 = r6[r8]
            int r4 = r3 + 1
            r3 = r0[r3]
            if (r8 == r3) goto L64
            return r1
        L64:
            r6 = r6[r7]
            r7 = r0[r4]
            if (r6 == r7) goto L6b
            return r1
        L6b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.d.a.a(int[], int, int):boolean");
    }

    public String a(String str, int[] iArr, int i) {
        int g2;
        l();
        if (this.f9720d) {
            str = InternCache.instance.intern(str);
        }
        if (i == 1) {
            g2 = g(b(iArr[0]));
            int[] iArr2 = this.f9722f;
            iArr2[g2] = iArr[0];
            iArr2[g2 + 3] = 1;
        } else if (i == 2) {
            g2 = g(a(iArr[0], iArr[1]));
            int[] iArr3 = this.f9722f;
            iArr3[g2] = iArr[0];
            iArr3[g2 + 1] = iArr[1];
            iArr3[g2 + 3] = 2;
        } else if (i != 3) {
            int a2 = a(iArr, i);
            g2 = g(a2);
            this.f9722f[g2] = a2;
            int c2 = c(iArr, i);
            int[] iArr4 = this.f9722f;
            iArr4[g2 + 1] = c2;
            iArr4[g2 + 3] = i;
        } else {
            int g3 = g(a(iArr[0], iArr[1], iArr[2]));
            int[] iArr5 = this.f9722f;
            iArr5[g3] = iArr[0];
            iArr5[g3 + 1] = iArr[1];
            iArr5[g3 + 2] = iArr[2];
            iArr5[g3 + 3] = 3;
            g2 = g3;
        }
        this.l[g2 >> 2] = str;
        this.k++;
        k();
        return str;
    }

    private boolean b(int[] iArr, int i, int i2) {
        int i3 = i2;
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            int i6 = i3 + 1;
            if (iArr[i4] != this.f9722f[i3]) {
                return false;
            }
            if (i5 >= i) {
                return true;
            }
            i4 = i5;
            i3 = i6;
        }
    }

    public int b(int i) {
        int i2 = i ^ this.f9719c;
        int i3 = i2 + (i2 >>> 16);
        int i4 = i3 ^ (i3 << 3);
        return i4 + (i4 >>> 12);
    }

    public int a(int i, int i2) {
        int i3 = i + (i >>> 15);
        int i4 = ((i3 ^ (i3 >>> 9)) + (i2 * 33)) ^ this.f9719c;
        int i5 = i4 + (i4 >>> 16);
        int i6 = i5 ^ (i5 >>> 4);
        return i6 + (i6 << 3);
    }

    public int a(int i, int i2, int i3) {
        int i4 = i ^ this.f9719c;
        int i5 = (((i4 + (i4 >>> 9)) * 31) + i2) * 33;
        int i6 = (i5 + (i5 >>> 15)) ^ i3;
        int i7 = i6 + (i6 >>> 4);
        int i8 = i7 + (i7 >>> 15);
        return i8 ^ (i8 << 9);
    }

    public int a(int[] iArr, int i) {
        if (i >= 4) {
            int i2 = iArr[0] ^ this.f9719c;
            int i3 = i2 + (i2 >>> 9) + iArr[1];
            int i4 = ((i3 + (i3 >>> 15)) * 33) ^ iArr[2];
            int i5 = i4 + (i4 >>> 4);
            for (int i6 = 3; i6 < i; i6++) {
                int i7 = iArr[i6];
                i5 += i7 ^ (i7 >> 21);
            }
            int i8 = i5 * 65599;
            int i9 = i8 + (i8 >>> 19);
            return (i9 << 5) ^ i9;
        }
        throw new IllegalArgumentException();
    }

    private void a(boolean z) {
        this.k = 0;
        this.m = j();
        this.n = this.f9723g << 3;
        if (z) {
            Arrays.fill(this.f9722f, 0);
            Arrays.fill(this.l, (Object) null);
        }
    }

    protected void a() {
        if (this.f9723g <= 1024) {
            return;
        }
        throw new IllegalStateException("Spill-over slots in symbol table with " + this.k + " entries, hash area of " + this.f9723g + " slots is now full (all " + (this.f9723g >> 3) + " slots -- suspect a DoS attack based on hash collisions. You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
    }
}
