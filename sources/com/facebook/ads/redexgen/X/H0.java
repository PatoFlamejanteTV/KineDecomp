package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;

/* loaded from: assets/audience_network.dex */
public class H0 implements InterfaceC0436Gz {
    public static byte[] A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.H0.A00
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
            int r0 = r0 + (-25)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.H0.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{-104, -67, -57, -60, -75, -56, -73, -68, -71, -72, 116, -73, -61, -55, -62, -56, -71, -58, -57, -126, 116, -90, -71, -57, -60, -61, -62, -57, -71, -114, 116, -42, -12, 1, -70, 7, -77, -9, -4, 6, 3, -12, 7, -10, -5, -77, -10, 2, 8, 1, 7, -8, 5, 6, -63};
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0436Gz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A6N(com.facebook.ads.redexgen.X.FN r5) {
        /*
            r4 = this;
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L34
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L13;
                case 4: goto L36;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.FN r5 = (com.facebook.ads.redexgen.X.FN) r5
            if (r5 == 0) goto L11
            r0 = 3
            goto L7
        L11:
            r0 = 4
            goto L7
        L13:
            com.facebook.ads.redexgen.X.FN r5 = (com.facebook.ads.redexgen.X.FN) r5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 0
            r1 = 31
            r0 = 59
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.String r0 = r5.A4M()
            java.lang.StringBuilder r0 = r1.append(r0)
            r0.toString()
            r0 = 4
            goto L7
        L34:
            r0 = 4
            goto L7
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.H0.A6N(com.facebook.ads.redexgen.X.FN):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0436Gz
    public final void A6Z(Exception exc) {
        String str;
        if (!BuildConfigApi.isDebug()) {
            return;
        }
        str = H1.A01;
        Log.e(str, A00(31, 24, 122), exc);
    }
}
