package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Jo, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0498Jo implements InterfaceC0497Jn {
    public int A00;
    public final InterfaceC0497Jn A01;
    public final InterfaceC0497Jn A02;

    public C0498Jo(InterfaceC0497Jn interfaceC0497Jn, int i, InterfaceC0497Jn interfaceC0497Jn2) {
        this.A01 = interfaceC0497Jn;
        this.A00 = i;
        this.A02 = interfaceC0497Jn2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0497Jn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7r(java.lang.String r3) {
        /*
            r2 = this;
            r1 = r2
            int r0 = r1.A00
            if (r0 <= 0) goto L2b
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L2d;
                case 4: goto L20;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.Jo r1 = (com.facebook.ads.redexgen.X.C0498Jo) r1
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.Jn r0 = r1.A01
            r0.A7r(r3)
            com.facebook.ads.redexgen.X.Jn r0 = r1.A01
            r0.flush()
            int r0 = r1.A00
            int r0 = r0 + (-1)
            r1.A00 = r0
            r0 = 3
            goto L6
        L20:
            com.facebook.ads.redexgen.X.Jo r1 = (com.facebook.ads.redexgen.X.C0498Jo) r1
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.Jn r0 = r1.A02
            r0.A7r(r3)
            r0 = 3
            goto L6
        L2b:
            r0 = 4
            goto L6
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0498Jo.A7r(java.lang.String):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0497Jn
    public final void flush() {
        this.A02.flush();
    }
}
