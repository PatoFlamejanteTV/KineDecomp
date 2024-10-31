package com.facebook.ads.redexgen.X;

import android.view.View;

/* loaded from: assets/audience_network.dex */
public class O0 implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ O3 A00;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.O0.A01
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            int r0 = r0 - r4
            int r0 = r0 + (-43)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.O0.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{0, 12, 10, -53, 3, -2, 0, 2, -1, 12, 12, 8, -53, -2, 1, 16, -53, 6, 11, 17, 2, 15, 16, 17, 6, 17, 6, -2, 9, -53, 3, 6, 11, 6, 16, 5, -4, -2, 0, 17, 6, 19, 6, 17, 22};
    }

    public O0(O3 o3) {
        this.A00 = o3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AnonymousClass81 anonymousClass81;
        C0537Lb c0537Lb;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.A05 = false;
            if (!this.A00.getAdInfo().A0M()) {
                anonymousClass81 = this.A00.A08;
                anonymousClass81.A3b(A00(0, 45, 114));
            } else {
                c0537Lb = this.A00.A0A;
                c0537Lb.A0P(QE.A05);
            }
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
