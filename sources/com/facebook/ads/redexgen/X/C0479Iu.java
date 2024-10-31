package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Iu, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0479Iu {
    public static final AtomicReference<InterfaceC0410Fz> A00 = new AtomicReference<>(null);

    public static InterfaceC0410Fz A00() {
        InterfaceC0410Fz errorLogger = A00.get();
        if (errorLogger == null) {
            return new C0478It();
        }
        return errorLogger;
    }

    public static void A01(InterfaceC0410Fz interfaceC0410Fz) {
        A00.set(interfaceC0410Fz);
    }
}
