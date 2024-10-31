package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Booleans {
    private Booleans() {
    }

    public static int a(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }
}
