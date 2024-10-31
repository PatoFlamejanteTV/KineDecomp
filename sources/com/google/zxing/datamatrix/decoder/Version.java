package com.google.zxing.datamatrix.decoder;

/* loaded from: classes2.dex */
public final class Version {

    /* renamed from: a */
    private static final Version[] f19094a = a();

    /* renamed from: b */
    private final int f19095b;

    /* renamed from: c */
    private final int f19096c;

    /* renamed from: d */
    private final int f19097d;

    /* renamed from: e */
    private final int f19098e;

    /* renamed from: f */
    private final int f19099f;

    /* renamed from: g */
    private final b f19100g;

    /* renamed from: h */
    private final int f19101h;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        private final int f19102a;

        /* renamed from: b */
        private final int f19103b;

        /* synthetic */ a(int i, int i2, com.google.zxing.datamatrix.decoder.a aVar) {
            this(i, i2);
        }

        int a() {
            return this.f19102a;
        }

        int b() {
            return this.f19103b;
        }

        private a(int i, int i2) {
            this.f19102a = i;
            this.f19103b = i2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a */
        private final int f19104a;

        /* renamed from: b */
        private final a[] f19105b;

        /* synthetic */ b(int i, a aVar, com.google.zxing.datamatrix.decoder.a aVar2) {
            this(i, aVar);
        }

        a[] a() {
            return this.f19105b;
        }

        int b() {
            return this.f19104a;
        }

        /* synthetic */ b(int i, a aVar, a aVar2, com.google.zxing.datamatrix.decoder.a aVar3) {
            this(i, aVar, aVar2);
        }

        private b(int i, a aVar) {
            this.f19104a = i;
            this.f19105b = new a[]{aVar};
        }

        private b(int i, a aVar, a aVar2) {
            this.f19104a = i;
            this.f19105b = new a[]{aVar, aVar2};
        }
    }

    private Version(int i, int i2, int i3, int i4, int i5, b bVar) {
        this.f19095b = i;
        this.f19096c = i2;
        this.f19097d = i3;
        this.f19098e = i4;
        this.f19099f = i5;
        this.f19100g = bVar;
        int b2 = bVar.b();
        int i6 = 0;
        for (a aVar : bVar.a()) {
            i6 += aVar.a() * (aVar.b() + b2);
        }
        this.f19101h = i6;
    }

    private static Version[] a() {
        return new Version[]{new Version(1, 10, 10, 8, 8, new b(5, new a(1, 3))), new Version(2, 12, 12, 10, 10, new b(7, new a(1, 5))), new Version(3, 14, 14, 12, 12, new b(10, new a(1, 8))), new Version(4, 16, 16, 14, 14, new b(12, new a(1, 12))), new Version(5, 18, 18, 16, 16, new b(14, new a(1, 18))), new Version(6, 20, 20, 18, 18, new b(18, new a(1, 22))), new Version(7, 22, 22, 20, 20, new b(20, new a(1, 30))), new Version(8, 24, 24, 22, 22, new b(24, new a(1, 36))), new Version(9, 26, 26, 24, 24, new b(28, new a(1, 44))), new Version(10, 32, 32, 14, 14, new b(36, new a(1, 62))), new Version(11, 36, 36, 16, 16, new b(42, new a(1, 86))), new Version(12, 40, 40, 18, 18, new b(48, new a(1, 114))), new Version(13, 44, 44, 20, 20, new b(56, new a(1, 144))), new Version(14, 48, 48, 22, 22, new b(68, new a(1, 174))), new Version(15, 52, 52, 24, 24, new b(42, new a(2, 102))), new Version(16, 64, 64, 14, 14, new b(56, new a(2, 140))), new Version(17, 72, 72, 16, 16, new b(36, new a(4, 92))), new Version(18, 80, 80, 18, 18, new b(48, new a(4, 114))), new Version(19, 88, 88, 20, 20, new b(56, new a(4, 144))), new Version(20, 96, 96, 22, 22, new b(68, new a(4, 174))), new Version(21, 104, 104, 24, 24, new b(56, new a(6, 136))), new Version(22, 120, 120, 18, 18, new b(68, new a(6, 175))), new Version(23, 132, 132, 20, 20, new b(62, new a(8, 163))), new Version(24, 144, 144, 22, 22, new b(62, new a(8, 156), new a(2, 155))), new Version(25, 8, 18, 6, 16, new b(7, new a(1, 5))), new Version(26, 8, 32, 6, 14, new b(11, new a(1, 10))), new Version(27, 12, 26, 10, 24, new b(14, new a(1, 16))), new Version(28, 12, 36, 10, 16, new b(18, new a(1, 22))), new Version(29, 16, 36, 14, 16, new b(24, new a(1, 32))), new Version(30, 16, 48, 14, 22, new b(28, new a(1, 49)))};
    }

    public String toString() {
        return String.valueOf(this.f19095b);
    }
}
