package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.5B, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5B {
    public static final AnonymousClass50 A00;

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            A00 = new AnonymousClass59() { // from class: com.facebook.ads.redexgen.X.5A
            };
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            A00 = new AnonymousClass59();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            A00 = new AnonymousClass58();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            A00 = new AnonymousClass57();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            A00 = new AnonymousClass55();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            A00 = new AnonymousClass54();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            A00 = new AnonymousClass53();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            A00 = new AnonymousClass52();
        } else if (Build.VERSION.SDK_INT >= 15) {
            A00 = new AnonymousClass51();
        } else {
            A00 = new AnonymousClass50();
        }
    }

    public static int A00(View view) {
        return A00.A03(view);
    }

    public static int A01(View view) {
        return A00.A04(view);
    }

    public static int A02(View view) {
        return A00.A05(view);
    }

    public static int A03(View view) {
        return A00.A06(view);
    }

    public static Display A04(@NonNull View view) {
        return A00.A07(view);
    }

    public static C5Y A05(View view, C5Y c5y) {
        return A00.A08(view, c5y);
    }

    public static C5Y A06(View view, C5Y c5y) {
        return A00.A09(view, c5y);
    }

    public static void A07(View view) {
        A00.A0A(view);
    }

    public static void A08(@NonNull View view) {
        A00.A0B(view);
    }

    public static void A09(View view, int i) {
        A00.A0C(view, i);
    }

    public static void A0A(View view, C01114e c01114e) {
        A00.A0D(view, c01114e);
    }

    public static void A0B(View view, InterfaceC01194m interfaceC01194m) {
        A00.A0E(view, interfaceC01194m);
    }

    public static void A0C(View view, Runnable runnable) {
        A00.A0F(view, runnable);
    }

    public static void A0D(View view, Runnable runnable, long j) {
        A00.A0G(view, runnable, j);
    }

    public static boolean A0E(View view) {
        return A00.A0J(view);
    }

    public static boolean A0F(View view) {
        return A00.A0H(view);
    }
}
