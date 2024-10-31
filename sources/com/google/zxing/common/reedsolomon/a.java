package com.google.zxing.common.reedsolomon;

/* compiled from: GenericGFPoly.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    private final GenericGF f19089a;

    /* renamed from: b */
    private final int[] f19090b;

    public a(GenericGF genericGF, int[] iArr) {
        if (iArr.length != 0) {
            this.f19089a = genericGF;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i = 1;
                while (i < length && iArr[i] == 0) {
                    i++;
                }
                if (i == length) {
                    this.f19090b = new int[]{0};
                    return;
                }
                this.f19090b = new int[length - i];
                int[] iArr2 = this.f19090b;
                System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
                return;
            }
            this.f19090b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int[] a() {
        return this.f19090b;
    }

    int b() {
        return this.f19090b.length - 1;
    }

    boolean c() {
        return this.f19090b[0] == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int b2 = b(); b2 >= 0; b2--) {
            int a2 = a(b2);
            if (a2 != 0) {
                if (a2 < 0) {
                    sb.append(" - ");
                    a2 = -a2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b2 == 0 || a2 != 1) {
                    int c2 = this.f19089a.c(a2);
                    if (c2 == 0) {
                        sb.append('1');
                    } else if (c2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(c2);
                    }
                }
                if (b2 != 0) {
                    if (b2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b2);
                    }
                }
            }
        }
        return sb.toString();
    }

    int a(int i) {
        return this.f19090b[(r0.length - 1) - i];
    }

    public a[] b(a aVar) {
        if (this.f19089a.equals(aVar.f19089a)) {
            if (!aVar.c()) {
                a b2 = this.f19089a.b();
                int b3 = this.f19089a.b(aVar.a(aVar.b()));
                a aVar2 = b2;
                a aVar3 = this;
                while (aVar3.b() >= aVar.b() && !aVar3.c()) {
                    int b4 = aVar3.b() - aVar.b();
                    int c2 = this.f19089a.c(aVar3.a(aVar3.b()), b3);
                    a a2 = aVar.a(b4, c2);
                    aVar2 = aVar2.a(this.f19089a.b(b4, c2));
                    aVar3 = aVar3.a(a2);
                }
                return new a[]{aVar2, aVar3};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public a c(a aVar) {
        if (this.f19089a.equals(aVar.f19089a)) {
            if (!c() && !aVar.c()) {
                int[] iArr = this.f19090b;
                int length = iArr.length;
                int[] iArr2 = aVar.f19090b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i = 0; i < length; i++) {
                    int i2 = iArr[i];
                    for (int i3 = 0; i3 < length2; i3++) {
                        int i4 = i + i3;
                        iArr3[i4] = GenericGF.a(iArr3[i4], this.f19089a.c(i2, iArr2[i3]));
                    }
                }
                return new a(this.f19089a, iArr3);
            }
            return this.f19089a.b();
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    a a(a aVar) {
        if (this.f19089a.equals(aVar.f19089a)) {
            if (c()) {
                return aVar;
            }
            if (aVar.c()) {
                return this;
            }
            int[] iArr = this.f19090b;
            int[] iArr2 = aVar.f19090b;
            if (iArr.length > iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr3[i] = GenericGF.a(iArr[i - length], iArr2[i]);
            }
            return new a(this.f19089a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public a a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f19089a.b();
        }
        int length = this.f19090b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f19089a.c(this.f19090b[i3], i2);
        }
        return new a(this.f19089a, iArr);
    }
}
