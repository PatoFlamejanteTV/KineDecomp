package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.widget.EdgeEffect;

/* renamed from: com.facebook.ads.redexgen.X.68, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass68 {
    public static final AnonymousClass66 A00;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            A00 = new AnonymousClass66() { // from class: com.facebook.ads.redexgen.X.67
                @Override // com.facebook.ads.redexgen.X.AnonymousClass66
                public final void A00(EdgeEffect edgeEffect, float f, float f2) {
                    edgeEffect.onPull(f, f2);
                }
            };
        } else {
            A00 = new AnonymousClass66();
        }
    }

    public static void A00(EdgeEffect edgeEffect, float f, float f2) {
        A00.A00(edgeEffect, f, f2);
    }
}
