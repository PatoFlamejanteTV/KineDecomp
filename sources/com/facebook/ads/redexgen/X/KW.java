package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.util.concurrent.Executor;

/* loaded from: assets/audience_network.dex */
public final class KW {

    @Nullable
    public static KW A02;
    public final KV A00;
    public final KX A01;

    public KW(C0362Ec c0362Ec, Executor executor, C0402Fq c0402Fq) {
        this.A01 = new KX(c0362Ec);
        this.A00 = new KV(executor, c0402Fq, c0362Ec);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A01(com.facebook.ads.redexgen.X.C0362Ec r1, java.util.concurrent.Executor r2, com.facebook.ads.redexgen.X.C0402Fq r3) {
        /*
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0j(r1)
            if (r0 != 0) goto L30
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L32;
                case 3: goto Lb;
                case 4: goto L13;
                case 5: goto L27;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.KW r0 = com.facebook.ads.redexgen.X.KW.A02
            if (r0 != 0) goto L11
            r0 = 4
            goto L7
        L11:
            r0 = 5
            goto L7
        L13:
            com.facebook.ads.redexgen.X.Ec r1 = (com.facebook.ads.redexgen.X.C0362Ec) r1
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            com.facebook.ads.redexgen.X.Fq r3 = (com.facebook.ads.redexgen.X.C0402Fq) r3
            com.facebook.ads.redexgen.X.KW r0 = new com.facebook.ads.redexgen.X.KW
            r0.<init>(r1, r2, r3)
            com.facebook.ads.redexgen.X.KW.A02 = r0
            com.facebook.ads.redexgen.X.KW r0 = com.facebook.ads.redexgen.X.KW.A02
            r0.A00()
            r0 = 2
            goto L7
        L27:
            com.facebook.ads.redexgen.X.Fq r3 = (com.facebook.ads.redexgen.X.C0402Fq) r3
            com.facebook.ads.redexgen.X.KW r0 = com.facebook.ads.redexgen.X.KW.A02
            r0.A02(r3)
            r0 = 2
            goto L7
        L30:
            r0 = 3
            goto L7
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KW.A01(com.facebook.ads.redexgen.X.Ec, java.util.concurrent.Executor, com.facebook.ads.redexgen.X.Fq):void");
    }

    private void A02(C0402Fq c0402Fq) {
        this.A00.A07(c0402Fq);
    }
}
