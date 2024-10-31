package com.google.zxing;

import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

/* loaded from: classes2.dex */
public final class Dimension {

    /* renamed from: a */
    private final int f18944a;

    /* renamed from: b */
    private final int f18945b;

    public int a() {
        return this.f18945b;
    }

    public int b() {
        return this.f18944a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            if (this.f18944a == dimension.f18944a && this.f18945b == dimension.f18945b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f18944a * 32713) + this.f18945b;
    }

    public String toString() {
        return this.f18944a + FragmentC2201x.f23219a + this.f18945b;
    }
}
