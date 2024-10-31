package com.google.zxing;

/* loaded from: classes2.dex */
public class ResultPoint {

    /* renamed from: a */
    private final float f18962a;

    /* renamed from: b */
    private final float f18963b;

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f18962a == resultPoint.f18962a && this.f18963b == resultPoint.f18963b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f18962a) * 31) + Float.floatToIntBits(this.f18963b);
    }

    public final String toString() {
        return "(" + this.f18962a + ',' + this.f18963b + ')';
    }
}
