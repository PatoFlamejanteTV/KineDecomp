package com.facebook.ads.redexgen.X;

import android.content.Context;

/* loaded from: assets/audience_network.dex */
public class JQ extends AbstractRunnableC00351g {
    public static byte[] A01;
    public final /* synthetic */ Context A00;

    static {
        A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.JQ.A01
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
            r0 = r0 ^ r4
            r0 = r0 ^ 75
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JQ.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A01 = new byte[]{102, 87, 87, 106, 78, 73, 116, 67, 76, 113, 66, 85, 84, 78, 72, 73, 67, 71, 68, 97, 85, 119, 96, 99, 118};
    }

    public JQ(Context context) {
        this.A00 = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05() {
        /*
            r9 = this;
            r5 = r9
            r7 = 0
            r8 = 0
            r6 = 0
            r0 = 0
            r4 = -1
            com.facebook.ads.redexgen.X.JR r1 = com.facebook.ads.redexgen.X.JS.A02
            com.facebook.ads.redexgen.X.JR r0 = com.facebook.ads.redexgen.X.JR.A02
            if (r1 != r0) goto L84
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L86;
                case 3: goto L2f;
                case 4: goto L26;
                case 5: goto L1b;
                case 6: goto L11;
                case 7: goto L5b;
                case 8: goto L7a;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.JQ r5 = (com.facebook.ads.redexgen.X.JQ) r5
            android.content.Context r0 = r5.A00
            int r6 = com.facebook.ads.redexgen.X.JS.A04(r0)
            r0 = 7
            goto Ld
        L1b:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 24
            if (r1 < r0) goto L23
            r0 = 6
            goto Ld
        L23:
            r0 = 8
            goto Ld
        L26:
            com.facebook.ads.redexgen.X.JS.A00(r8)
            com.facebook.ads.redexgen.X.JR r0 = com.facebook.ads.redexgen.X.JR.A02
            com.facebook.ads.redexgen.X.JS.A02 = r0
            r0 = 2
            goto Ld
        L2f:
            com.facebook.ads.redexgen.X.JQ r5 = (com.facebook.ads.redexgen.X.JQ) r5
            android.content.Context r3 = r5.A00
            r2 = 16
            r1 = 9
            r0 = 78
            java.lang.String r1 = A01(r2, r1, r0)
            android.content.Context r0 = r5.A00
            java.lang.String r1 = com.facebook.ads.internal.util.process.ProcessUtils.getProcessSpecificName(r1, r0)
            r0 = 0
            android.content.SharedPreferences r7 = r3.getSharedPreferences(r1, r0)
            r2 = 0
            r1 = 16
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            int r8 = r7.getInt(r0, r4)
            if (r8 == r4) goto L59
            r0 = 4
            goto Ld
        L59:
            r0 = 5
            goto Ld
        L5b:
            android.content.SharedPreferences r7 = (android.content.SharedPreferences) r7
            com.facebook.ads.redexgen.X.JS.A00(r6)
            android.content.SharedPreferences$Editor r3 = r7.edit()
            r2 = 0
            r1 = 16
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            android.content.SharedPreferences$Editor r0 = r3.putInt(r0, r6)
            r0.commit()
            com.facebook.ads.redexgen.X.JR r0 = com.facebook.ads.redexgen.X.JR.A02
            com.facebook.ads.redexgen.X.JS.A02 = r0
            r0 = 2
            goto Ld
        L7a:
            com.facebook.ads.redexgen.X.JQ r5 = (com.facebook.ads.redexgen.X.JQ) r5
            android.content.Context r0 = r5.A00
            int r6 = com.facebook.ads.redexgen.X.JS.A02(r0)
            r0 = 7
            goto Ld
        L84:
            r0 = 3
            goto Ld
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JQ.A05():void");
    }
}
