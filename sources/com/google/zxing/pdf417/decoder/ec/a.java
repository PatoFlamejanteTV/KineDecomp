package com.google.zxing.pdf417.decoder.ec;

/* compiled from: ModulusPoly.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    private final ModulusGF f19208a;

    /* renamed from: b */
    private final int[] f19209b;

    public a(ModulusGF modulusGF, int[] iArr) {
        if (iArr.length != 0) {
            this.f19208a = modulusGF;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i = 1;
                while (i < length && iArr[i] == 0) {
                    i++;
                }
                if (i == length) {
                    this.f19209b = new int[]{0};
                    return;
                }
                this.f19209b = new int[length - i];
                int[] iArr2 = this.f19209b;
                System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
                return;
            }
            this.f19209b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    int a() {
        return this.f19209b.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int a2 = a(); a2 >= 0; a2--) {
            int a3 = a(a2);
            if (a3 != 0) {
                if (a3 < 0) {
                    sb.append(" - ");
                    a3 = -a3;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (a2 == 0 || a3 != 1) {
                    sb.append(a3);
                }
                if (a2 != 0) {
                    if (a2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(a2);
                    }
                }
            }
        }
        return sb.toString();
    }

    int a(int i) {
        return this.f19209b[(r0.length - 1) - i];
    }
}
