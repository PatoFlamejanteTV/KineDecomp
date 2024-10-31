package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.Context;

/* renamed from: com.facebook.ads.redexgen.X.8N, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C8N {
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.InterfaceC00050c A00(android.content.Context r3, com.facebook.ads.redexgen.X.InterfaceC0367Eh r4) {
        /*
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ef r0 = A07(r3)
            com.facebook.ads.redexgen.X.0i r1 = r4.A4h(r0)
            if (r1 == 0) goto L20
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L22;
                case 4: goto L19;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.0i r1 = (com.facebook.ads.redexgen.X.InterfaceC00110i) r1
            com.facebook.ads.redexgen.X.0c r2 = r1.A5v()
            r0 = 3
            goto Ld
        L19:
            com.facebook.ads.redexgen.X.0y r2 = new com.facebook.ads.redexgen.X.0y
            r2.<init>()
            r0 = 3
            goto Ld
        L20:
            r0 = 4
            goto Ld
        L22:
            java.lang.Object r2 = (java.lang.Object) r2
            com.facebook.ads.redexgen.X.0c r2 = (com.facebook.ads.redexgen.X.InterfaceC00050c) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8N.A00(android.content.Context, com.facebook.ads.redexgen.X.Eh):com.facebook.ads.redexgen.X.0c");
    }

    public static C0362Ec A01(Activity activity) {
        return new C0362Ec(activity, A08(), A00(activity, A08()));
    }

    public static C0362Ec A02(Context context) {
        return new C0362Ec(context, A08(), new C00270y());
    }

    public static C0362Ec A03(Context context) {
        return new C0362Ec(context, A08(), A00(context, A08()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C0362Ec A04(android.content.Context r3) {
        /*
            r2 = 0
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0Z(r3)
            if (r0 == 0) goto L29
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L2b;
                case 4: goto L21;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            android.content.Context r3 = (android.content.Context) r3
            com.facebook.ads.redexgen.X.Ec r2 = new com.facebook.ads.redexgen.X.Ec
            com.facebook.ads.redexgen.X.Eh r1 = A08()
            com.facebook.ads.redexgen.X.Eh r0 = A08()
            com.facebook.ads.redexgen.X.0c r0 = A00(r3, r0)
            r2.<init>(r3, r1, r0)
            r0 = 3
            goto L8
        L21:
            android.content.Context r3 = (android.content.Context) r3
            com.facebook.ads.redexgen.X.Ec r2 = A02(r3)
            r0 = 3
            goto L8
        L29:
            r0 = 4
            goto L8
        L2b:
            com.facebook.ads.redexgen.X.Ec r2 = (com.facebook.ads.redexgen.X.C0362Ec) r2
            com.facebook.ads.redexgen.X.Ec r2 = (com.facebook.ads.redexgen.X.C0362Ec) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8N.A04(android.content.Context):com.facebook.ads.redexgen.X.Ec");
    }

    public static C0362Ec A05(Context context) {
        return new C0362Ec(context, A08(), A00(context, A08()));
    }

    public static C0364Ee A06(Context context) {
        return new C0364Ee(context, A08(), A08().A4h(A07(context)));
    }

    public static C0365Ef A07(Context context) {
        return new C0365Ef(context, A08());
    }

    public static synchronized InterfaceC0367Eh A08() {
        GI A01;
        synchronized (C8N.class) {
            A01 = GI.A01();
        }
        return A01;
    }
}
