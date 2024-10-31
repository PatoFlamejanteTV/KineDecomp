package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public class GF implements InterfaceC00090g {
    public static byte[] A02;
    public final /* synthetic */ C0361Eb A00;
    public final /* synthetic */ GI A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.GF.A02
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
            int r0 = r0 + (-102)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GF.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{-21, -4, -30, -33, -18, -25, -25, -34, -27, -43, -6, 41, 34, 34, 25, 32, -18, -44, -26, 21, 14, 14, 5, 12};
    }

    public GF(GI gi, C0361Eb c0361Eb) {
        this.A01 = gi;
        this.A00 = c0361Eb;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00090g
    public final void A4B(EnumC00100h enumC00100h, JSONObject jSONObject) {
        C0514Ke c0514Ke = new C0514Ke(A00(18, 6, 58));
        c0514Ke.A05(jSONObject);
        c0514Ke.A03(1);
        this.A00.A06().A5W(A00(3, 6, 19), enumC00100h.A02() + 4000, c0514Ke);
        if (BuildConfigApi.isDebug()) {
            String str = A00(10, 8, 78) + enumC00100h + A00(9, 1, 71) + enumC00100h.A02() + A00(0, 3, 92) + jSONObject.toString();
        }
    }
}
