package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

/* renamed from: com.facebook.ads.redexgen.X.28, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass28 extends BroadcastReceiver {
    public static byte[] A03;
    public Context A00;
    public C0538Lc A01;
    public boolean A02 = false;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass28.A03
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
            int r0 = r0 + (-53)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass28.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A03 = new byte[]{-87, -75, -77, 116, -84, -89, -87, -85, -88, -75, -75, -79, 116, -89, -86, -71, 116, -81, -76, -70, -85, -72, -71, -70, -81, -70, -81, -89, -78, 116, -86, -81, -71, -74, -78, -89, -65, -85, -86, -69, -82, -87, -86, -76, -114, -77, -71, -86, -73, -72, -71, -82, -71, -90, -79, -118, -69, -86, -77, -71, 20, 7, 2, 3, 13, -25, 12, 18, 3, 16, 17, 18, 7, 18, -1, 10, -29, 20, 3, 12, 18, -40, -27, -38, -25, -37, -28, -25, -30, -72, -23, -42, -72, -31, -34, -40, -32, -81, -21, -9, -11, -74, -18, -23, -21, -19, -22, -9, -9, -13, -74, -23, -20, -5, -74, -15, -10, -4, -19, -6, -5, -4, -15, -4, -15, -23, -12, -74, -20, -15, -5, -8, -12, -23, 1, -19, -20, -62, -81, -24, -35, -22, -34, -25, -22, -27, -69, -20, -39, -69, -28, -31, -37, -29, -87, -70, -87, -78, -72};
    }

    public AnonymousClass28(C0538Lc c0538Lc, Context context) {
        this.A01 = c0538Lc;
        this.A00 = context;
    }

    public final void A02() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(98, 40, 83) + this.A01.getUniqueId());
        intentFilter.addAction(A00(60, 22, 105) + this.A01.getUniqueId());
        intentFilter.addAction(A00(82, 16, 64) + this.A01.getUniqueId());
        C4F.A00(this.A00).A06(this, intentFilter);
    }

    public final void A03() {
        try {
            C4F.A00(this.A00).A05(this);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:209:0x0226, code lost:            return;     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            Method dump skipped, instructions count: 620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass28.onReceive(android.content.Context, android.content.Intent):void");
    }
}
