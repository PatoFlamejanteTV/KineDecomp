package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.19, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass19 extends AnonymousClass16 {
    public static byte[] A02;
    public Map<String, String> A00;
    public final Uri A01;

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass19.A02
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
            int r0 = r0 + (-20)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass19.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{-126, Byte.MAX_VALUE, -124, -127};
    }

    public AnonymousClass19(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, String str, Uri uri, Map<String, String> map) {
        super(c0362Ec, interfaceC0422Gl, str, null, true);
        this.A01 = uri;
        this.A00 = map;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass16
    public final void A0B() {
        A0C(this.A00, null);
    }

    public final Uri A0D() {
        return Uri.parse(this.A01.getQueryParameter(A01(0, 4, 2)));
    }
}
