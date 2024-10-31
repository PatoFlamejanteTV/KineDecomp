package com.google.android.gms.common.images;

/* loaded from: classes.dex */
public final class Size {

    /* renamed from: a, reason: collision with root package name */
    private final int f989a;
    private final int b;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f989a == size.f989a && this.b == size.b;
    }

    public int hashCode() {
        return this.b ^ ((this.f989a << 16) | (this.f989a >>> 16));
    }

    public String toString() {
        return this.f989a + "x" + this.b;
    }
}
