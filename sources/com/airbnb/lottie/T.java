package com.airbnb.lottie;

/* compiled from: GradientColor.java */
/* loaded from: classes.dex */
public class T {

    /* renamed from: a */
    private final float[] f7710a;

    /* renamed from: b */
    private final int[] f7711b;

    public T(float[] fArr, int[] iArr) {
        this.f7710a = fArr;
        this.f7711b = iArr;
    }

    public int[] a() {
        return this.f7711b;
    }

    public float[] b() {
        return this.f7710a;
    }

    public int c() {
        return this.f7711b.length;
    }

    public void a(T t, T t2, float f2) {
        if (t.f7711b.length == t2.f7711b.length) {
            for (int i = 0; i < t.f7711b.length; i++) {
                this.f7710a[i] = C0676ua.b(t.f7710a[i], t2.f7710a[i], f2);
                this.f7711b[i] = S.a(f2, t.f7711b[i], t2.f7711b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + t.f7711b.length + " vs " + t2.f7711b.length + ")");
    }
}
