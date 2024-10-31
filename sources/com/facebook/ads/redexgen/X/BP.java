package com.facebook.ads.redexgen.X;

import java.util.List;

/* loaded from: assets/audience_network.dex */
public class BP implements InterfaceC0267Al {
    public final /* synthetic */ BR A00;
    public final /* synthetic */ List A01;

    public BP(BR br, List list) {
        this.A00 = br;
        this.A01 = list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0086, code lost:            r0 = r5.A00.A03((java.util.HashMap<java.lang.Integer, com.facebook.ads.redexgen.X.BQ>) r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0092, code lost:            return r0;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A44() {
        /*
            r9 = this;
            r5 = r9
            r0 = 0
            r6 = 0
            r4 = 0
            r7 = 0
            r0 = 0
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r2 = 0
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L70;
                case 3: goto L5c;
                case 4: goto L45;
                case 5: goto L37;
                case 6: goto L11;
                case 7: goto L7f;
                case 8: goto L83;
                case 9: goto L86;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.BP r5 = (com.facebook.ads.redexgen.X.BP) r5
            java.util.HashMap r3 = (java.util.HashMap) r3
            com.facebook.ads.redexgen.X.BR r0 = r5.A00
            android.media.AudioManager r0 = com.facebook.ads.redexgen.X.BR.A01(r0)
            int r8 = r0.getStreamVolume(r6)
            com.facebook.ads.redexgen.X.BR r0 = r5.A00
            android.media.AudioManager r0 = com.facebook.ads.redexgen.X.BR.A01(r0)
            int r0 = r0.getStreamMaxVolume(r6)
            com.facebook.ads.redexgen.X.BQ r1 = new com.facebook.ads.redexgen.X.BQ
            r1.<init>(r7, r8, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r3.put(r0, r1)
            r0 = 7
            goto Ld
        L37:
            com.facebook.ads.redexgen.X.BP r5 = (com.facebook.ads.redexgen.X.BP) r5
            com.facebook.ads.redexgen.X.BR r0 = r5.A00
            android.media.AudioManager r0 = com.facebook.ads.redexgen.X.BR.A01(r0)
            int r7 = r0.getStreamMinVolume(r6)
            r0 = 6
            goto Ld
        L45:
            com.facebook.ads.redexgen.X.Dl r4 = (com.facebook.ads.redexgen.X.C0345Dl) r4
            java.lang.Object r0 = r4.A01()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r6 = r0.intValue()
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 28
            if (r1 < r0) goto L59
            r0 = 5
            goto Ld
        L59:
            r0 = 8
            goto Ld
        L5c:
            com.facebook.ads.redexgen.X.BP r5 = (com.facebook.ads.redexgen.X.BP) r5
            java.util.List r0 = r5.A01
            java.lang.Object r4 = r0.get(r2)
            com.facebook.ads.redexgen.X.Dl r4 = (com.facebook.ads.redexgen.X.C0345Dl) r4
            boolean r0 = r4.A02()
            if (r0 == 0) goto L6e
            r0 = 4
            goto Ld
        L6e:
            r0 = 7
            goto Ld
        L70:
            com.facebook.ads.redexgen.X.BP r5 = (com.facebook.ads.redexgen.X.BP) r5
            java.util.List r0 = r5.A01
            int r0 = r0.size()
            if (r2 >= r0) goto L7c
            r0 = 3
            goto Ld
        L7c:
            r0 = 9
            goto Ld
        L7f:
            int r2 = r2 + 1
            r0 = 2
            goto Ld
        L83:
            r7 = -1
            r0 = 6
            goto Ld
        L86:
            com.facebook.ads.redexgen.X.BP r5 = (com.facebook.ads.redexgen.X.BP) r5
            java.util.HashMap r3 = (java.util.HashMap) r3
            com.facebook.ads.redexgen.X.BR r0 = r5.A00
            com.facebook.ads.redexgen.X.Dr r0 = com.facebook.ads.redexgen.X.BR.A02(r0, r3)
            com.facebook.ads.redexgen.X.Dr r0 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.BP.A44():com.facebook.ads.redexgen.X.Dr");
    }
}
