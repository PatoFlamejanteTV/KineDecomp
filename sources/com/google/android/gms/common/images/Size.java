package com.google.android.gms.common.images;

import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

/* loaded from: classes.dex */
public final class Size {

    /* renamed from: a */
    private final int f11030a;

    /* renamed from: b */
    private final int f11031b;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f11030a == size.f11030a && this.f11031b == size.f11031b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f11031b;
        int i2 = this.f11030a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public final String toString() {
        int i = this.f11030a;
        int i2 = this.f11031b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append(FragmentC2201x.f23219a);
        sb.append(i2);
        return sb.toString();
    }
}
