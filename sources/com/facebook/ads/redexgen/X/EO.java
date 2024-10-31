package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;

/* loaded from: assets/audience_network.dex */
public class EO implements C0X {
    public static byte[] A01;
    public final /* synthetic */ C0365Ef A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.EO.A01
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
            int r0 = r0 + (-106)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EO.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-27, -23, -35, -29, -31};
    }

    public EO(C0365Ef c0365Ef) {
        this.A00 = c0365Ef;
    }

    @Override // com.facebook.ads.redexgen.X.C0X
    public final void A5Q(Throwable th) {
        this.A00.A06().A5W(A00(0, 5, 18), C0512Kc.A1E, new C0514Ke(th));
    }

    @Override // com.facebook.ads.redexgen.X.C0X
    public final void A5Z(Throwable th) {
        this.A00.A06().A5W(A00(0, 5, 18), C0512Kc.A1G, new C0514Ke(th));
    }

    @Override // com.facebook.ads.redexgen.X.C0X
    public final void A7z(String str, int i, @Nullable String str2, @Nullable Integer num, @Nullable Long l, AnonymousClass08 anonymousClass08) {
        EY.A05(this.A00, anonymousClass08.A06, anonymousClass08.A08, anonymousClass08.A09, anonymousClass08.A07, anonymousClass08.A03, i, str2, num, l, null);
    }

    @Override // com.facebook.ads.redexgen.X.C0X
    public final void A80(String str, boolean z, AnonymousClass08 anonymousClass08) {
        EY.A04(this.A00, new EX(anonymousClass08.A06, anonymousClass08.A08, anonymousClass08.A07, anonymousClass08.A03, str), z);
    }
}
