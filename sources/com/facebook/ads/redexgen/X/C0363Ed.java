package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Ed, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0363Ed {
    public static final AtomicReference<C0365Ef> A00 = new AtomicReference<>();

    @Nullable
    public static C0365Ef A00() {
        return A00.get();
    }

    public static void A01(C0365Ef c0365Ef) {
        if (c0365Ef == null) {
            return;
        }
        A00.set(c0365Ef);
    }
}
