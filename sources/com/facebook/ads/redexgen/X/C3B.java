package com.facebook.ads.redexgen.X;

import android.view.View;
import com.facebook.ads.AdError;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.3B, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3B extends AnonymousClass35 {
    public C3B(C0362Ec c0362Ec, AnonymousClass31 anonymousClass31) {
        super(c0362Ec, anonymousClass31);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass35
    public final void A0K() {
        ((AbstractC00311c) this.A02).A0E();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass35
    public final void A0L(C1F c1f, C0402Fq c0402Fq, C0400Fo c0400Fo, Map<String, Object> map) {
        ((C00321d) c1f).A0G(this.A0B, new InterfaceC00481t() { // from class: com.facebook.ads.redexgen.X.3A
            public static byte[] A01;

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
                    byte[] r1 = com.facebook.ads.redexgen.X.C3A.A01
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
                    int r0 = r0 + (-51)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3A.A00(int, int, int):java.lang.String");
            }

            public static void A01() {
                A01 = new byte[]{-84, -47, -42, -41, -43, -56, -60, -48, -125, -52, -48, -45, -43, -56, -42, -42, -52, -46, -47, -125, -55, -52, -43, -56, -57, 119, 114, 122, -89, -90, -91, -90, 121, -37, -38, -75, -38, -33, -32, -34, -47, -51, -39, -62, -43, -48, -47, -37, -83, -48, -72, -37, -45, -45, -43, -38, -45, -75, -39, -36, -34, -47, -33, -33, -43, -37, -38};
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
            public final void A6k(AbstractC00311c abstractC00311c) {
                C3B.this.A06.A0C();
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
            public final void A6l(AbstractC00311c abstractC00311c) {
                C3B.this.A02 = abstractC00311c;
                C3B.this.A0C = false;
                super/*com.facebook.ads.redexgen.X.35*/.A09();
                C3B.this.A06.A0F(abstractC00311c);
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
            public final void A6m(AbstractC00311c abstractC00311c) {
                I5.A05(A00(33, 34, 57), A00(0, 25, 48), A00(25, 8, 15));
                C3B.this.A06.A0D();
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
            public final void A6n(AbstractC00311c abstractC00311c) {
                C3B.this.A06.A0B();
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
            public final void A6o(AbstractC00311c abstractC00311c, View view) {
                C3B.this.A06.A0E(view);
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
            public final void A6p(AbstractC00311c abstractC00311c, AdError adError) {
                C3B.this.A06.A0G(new C0453Hr(adError.getErrorCode(), adError.getErrorMessage()));
            }
        }, map, this.A08, this.A07.A09);
    }
}
