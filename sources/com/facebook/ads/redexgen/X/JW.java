package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.support.annotation.VisibleForTesting;

/* loaded from: assets/audience_network.dex */
public final class JW {
    public float A00;
    public boolean A01;
    public boolean A02;
    public final Handler A03;
    public final JV A04;

    public JW(int i, JV jv) {
        this(i, jv, new Handler());
    }

    @VisibleForTesting
    public JW(int i, JV jv, Handler handler) {
        this.A02 = false;
        this.A00 = i;
        this.A04 = jv;
        this.A03 = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A01() {
        /*
            r3 = this;
            r2 = r3
            float r1 = r2.A00
            r0 = 1048576000(0x3e800000, float:0.25)
            float r1 = r1 - r0
            r2.A00 = r1
            com.facebook.ads.redexgen.X.JV r1 = r2.A04
            float r0 = r2.A00
            r1.A7K(r0)
            float r1 = r2.A00
            r0 = 0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 > 0) goto L34
            r0 = 2
        L17:
            switch(r0) {
                case 2: goto L1b;
                case 3: goto L25;
                case 4: goto L36;
                default: goto L1a;
            }
        L1a:
            goto L17
        L1b:
            com.facebook.ads.redexgen.X.JW r2 = (com.facebook.ads.redexgen.X.JW) r2
            boolean r0 = r2.A01
            if (r0 != 0) goto L23
            r0 = 3
            goto L17
        L23:
            r0 = 4
            goto L17
        L25:
            com.facebook.ads.redexgen.X.JW r2 = (com.facebook.ads.redexgen.X.JW) r2
            r0 = 1
            r2.A01 = r0
            com.facebook.ads.redexgen.X.JV r0 = r2.A04
            r0.A6O()
            r0 = 0
            r2.A02 = r0
            r0 = 4
            goto L17
        L34:
            r0 = 4
            goto L17
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JW.A01():void");
    }

    public final float A03() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A04() {
        /*
            r3 = this;
            r2 = 0
            float r1 = r3.A00
            r0 = 0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 > 0) goto L13
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L15;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r2 = 1
            r0 = 3
            goto L9
        L10:
            r2 = 0
            r0 = 3
            goto L9
        L13:
            r0 = 4
            goto L9
        L15:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JW.A04():boolean");
    }

    public final boolean A05() {
        return this.A02;
    }

    public final boolean A06() {
        if (!A05()) {
            return false;
        }
        this.A02 = false;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x005a, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A07() {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r4 = 1
            boolean r0 = r5.A04()
            if (r0 == 0) goto L58
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L35;
                case 3: goto L2a;
                case 4: goto L1e;
                case 5: goto L11;
                case 6: goto Le;
                case 7: goto L5a;
                case 8: goto L3f;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r4 = 0
            r0 = 7
            goto La
        L11:
            com.facebook.ads.redexgen.X.JW r5 = (com.facebook.ads.redexgen.X.JW) r5
            boolean r0 = r5.A05()
            if (r0 == 0) goto L1b
            r0 = 6
            goto La
        L1b:
            r0 = 8
            goto La
        L1e:
            com.facebook.ads.redexgen.X.JW r5 = (com.facebook.ads.redexgen.X.JW) r5
            boolean r0 = r5.A04()
            if (r0 != 0) goto L28
            r0 = 5
            goto La
        L28:
            r0 = 6
            goto La
        L2a:
            com.facebook.ads.redexgen.X.JW r5 = (com.facebook.ads.redexgen.X.JW) r5
            r5.A01 = r4
            com.facebook.ads.redexgen.X.JV r0 = r5.A04
            r0.A6O()
            r0 = 4
            goto La
        L35:
            com.facebook.ads.redexgen.X.JW r5 = (com.facebook.ads.redexgen.X.JW) r5
            boolean r0 = r5.A01
            if (r0 != 0) goto L3d
            r0 = 3
            goto La
        L3d:
            r0 = 4
            goto La
        L3f:
            com.facebook.ads.redexgen.X.JW r5 = (com.facebook.ads.redexgen.X.JW) r5
            r5.A02 = r4
            com.facebook.ads.redexgen.X.JV r1 = r5.A04
            float r0 = r5.A00
            r1.A7K(r0)
            android.os.Handler r3 = r5.A03
            com.facebook.ads.redexgen.X.JU r2 = new com.facebook.ads.redexgen.X.JU
            r2.<init>(r5)
            r0 = 250(0xfa, double:1.235E-321)
            r3.postDelayed(r2, r0)
            r0 = 7
            goto La
        L58:
            r0 = 4
            goto La
        L5a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JW.A07():boolean");
    }
}
