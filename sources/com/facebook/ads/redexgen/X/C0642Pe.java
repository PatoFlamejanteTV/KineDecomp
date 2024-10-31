package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Pe, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0642Pe extends C2E<C0644Pg> {
    public static final int A05 = (int) (250.0f * KE.A01);
    public int A00 = 0;
    public boolean A01 = false;
    public final int A02;
    public final C0362Ec A03;
    public final List<String> A04;

    public C0642Pe(C0362Ec c0362Ec, List<String> list, int i) {
        this.A04 = list;
        this.A02 = i;
        this.A03 = c0362Ec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C2E
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C0644Pg A0D(ViewGroup viewGroup, int i) {
        return new C0644Pg(new C0643Pf(this.A03));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x006a, code lost:            r9 = r9;        r2 = r2;        r2.setMargins(r5, 0, r4, 0);        r9.A0l().setLayoutParams(r2);        r9.A0l().A00(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0082, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C2E
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0E(com.facebook.ads.redexgen.X.C0644Pg r9, int r10) {
        /*
            r8 = this;
            r6 = r8
            r5 = 0
            r0 = 0
            r7 = 0
            r0 = 0
            r4 = 0
            r0 = 0
            r0 = 0
            java.util.List<java.lang.String> r0 = r6.A04
            java.lang.Object r3 = r0.get(r10)
            java.lang.String r3 = (java.lang.String) r3
            android.view.ViewGroup$MarginLayoutParams r2 = new android.view.ViewGroup$MarginLayoutParams
            r1 = -2
            r0 = -1
            r2.<init>(r1, r0)
            int r1 = r6.A00
            r0 = 2
            if (r1 != r0) goto L67
            r0 = 2
        L1d:
            switch(r0) {
                case 2: goto L37;
                case 3: goto L33;
                case 4: goto L42;
                case 5: goto L30;
                case 6: goto L21;
                case 7: goto L49;
                case 8: goto L6a;
                case 9: goto L52;
                case 10: goto L59;
                case 11: goto L5f;
                default: goto L20;
            }
        L20:
            goto L1d
        L21:
            com.facebook.ads.redexgen.X.Pe r6 = (com.facebook.ads.redexgen.X.C0642Pe) r6
            int r0 = r6.A0C()
            int r0 = r0 + (-1)
            if (r10 < r0) goto L2d
            r0 = 7
            goto L1d
        L2d:
            r0 = 9
            goto L1d
        L30:
            r5 = r7
            r0 = 6
            goto L1d
        L33:
            int r7 = com.facebook.ads.redexgen.X.C0642Pe.A05
            r0 = 4
            goto L1d
        L37:
            com.facebook.ads.redexgen.X.Pe r6 = (com.facebook.ads.redexgen.X.C0642Pe) r6
            boolean r0 = r6.A01
            if (r0 == 0) goto L3f
            r0 = 3
            goto L1d
        L3f:
            r0 = 11
            goto L1d
        L42:
            if (r10 != 0) goto L46
            r0 = 5
            goto L1d
        L46:
            r0 = 10
            goto L1d
        L49:
            com.facebook.ads.redexgen.X.Pe r6 = (com.facebook.ads.redexgen.X.C0642Pe) r6
            int r0 = r6.A02
            int r4 = r0 * 4
            r0 = 8
            goto L1d
        L52:
            com.facebook.ads.redexgen.X.Pe r6 = (com.facebook.ads.redexgen.X.C0642Pe) r6
            int r4 = r6.A02
            r0 = 8
            goto L1d
        L59:
            com.facebook.ads.redexgen.X.Pe r6 = (com.facebook.ads.redexgen.X.C0642Pe) r6
            int r5 = r6.A02
            r0 = 6
            goto L1d
        L5f:
            com.facebook.ads.redexgen.X.Pe r6 = (com.facebook.ads.redexgen.X.C0642Pe) r6
            int r0 = r6.A02
            int r7 = r0 * 4
            r0 = 4
            goto L1d
        L67:
            r0 = 11
            goto L1d
        L6a:
            com.facebook.ads.redexgen.X.Pg r9 = (com.facebook.ads.redexgen.X.C0644Pg) r9
            java.lang.String r3 = (java.lang.String) r3
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            r0 = 0
            r2.setMargins(r5, r0, r4, r0)
            com.facebook.ads.redexgen.X.Pf r0 = r9.A0l()
            r0.setLayoutParams(r2)
            com.facebook.ads.redexgen.X.Pf r0 = r9.A0l()
            r0.A00(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0642Pe.A0E(com.facebook.ads.redexgen.X.Pg, int):void");
    }

    @Override // com.facebook.ads.redexgen.X.C2E
    public final int A0C() {
        return this.A04.size();
    }

    public final void A0F(int i, boolean z) {
        this.A00 = i;
        this.A01 = z;
    }
}
