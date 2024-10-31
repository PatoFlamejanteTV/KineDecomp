package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.2F, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C2F extends C2E<C0533Kx> {
    public static final int A05 = (int) (4.0f * KE.A01);

    @Nullable
    public C2D A00;
    public final List<HX> A01;
    public final int A02;
    public final C0362Ec A03;
    public final AnonymousClass29 A04 = new AnonymousClass29() { // from class: com.facebook.ads.redexgen.X.2A
        @Override // com.facebook.ads.redexgen.X.AnonymousClass29
        public final void A03() {
            C2D c2d;
            C2D c2d2;
            c2d = C2F.this.A00;
            if (c2d == null) {
                return;
            }
            c2d2 = C2F.this.A00;
            c2d2.A6J();
        }
    };

    public C2F(L7 l7, List<HX> list, C0362Ec c0362Ec) {
        this.A03 = c0362Ec;
        this.A02 = l7.getChildSpacing();
        this.A01 = list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:            r2 = r2;        r2.setMargins(r3, 0, r4, 0);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.ViewGroup.MarginLayoutParams A01(int r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = 0
            r0 = 0
            android.view.ViewGroup$MarginLayoutParams r2 = new android.view.ViewGroup$MarginLayoutParams
            r1 = -2
            r0 = -1
            r2.<init>(r1, r0)
            if (r7 != 0) goto L40
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L22;
                case 4: goto L1a;
                case 5: goto L42;
                case 6: goto L14;
                case 7: goto L3a;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.2F r5 = (com.facebook.ads.redexgen.X.C2F) r5
            int r4 = r5.A02
            r0 = 5
            goto L10
        L1a:
            com.facebook.ads.redexgen.X.2F r5 = (com.facebook.ads.redexgen.X.C2F) r5
            int r0 = r5.A02
            int r4 = r0 * 2
            r0 = 5
            goto L10
        L22:
            com.facebook.ads.redexgen.X.2F r5 = (com.facebook.ads.redexgen.X.C2F) r5
            java.util.List<com.facebook.ads.redexgen.X.HX> r0 = r5.A01
            int r0 = r0.size()
            int r0 = r0 + (-1)
            if (r7 < r0) goto L30
            r0 = 4
            goto L10
        L30:
            r0 = 6
            goto L10
        L32:
            com.facebook.ads.redexgen.X.2F r5 = (com.facebook.ads.redexgen.X.C2F) r5
            int r0 = r5.A02
            int r3 = r0 * 2
            r0 = 3
            goto L10
        L3a:
            com.facebook.ads.redexgen.X.2F r5 = (com.facebook.ads.redexgen.X.C2F) r5
            int r3 = r5.A02
            r0 = 3
            goto L10
        L40:
            r0 = 7
            goto L10
        L42:
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            r0 = 0
            r2.setMargins(r3, r0, r4, r0)
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2F.A01(int):android.view.ViewGroup$MarginLayoutParams");
    }

    @Override // com.facebook.ads.redexgen.X.C2E
    public final int A0C() {
        return this.A01.size();
    }

    public final void A0F(ImageView imageView, final int i) {
        final HX hx = this.A01.get(i);
        HY adCoverImage = hx.getAdCoverImage();
        if (adCoverImage != null) {
            NR A04 = new NR(imageView, this.A03).A04();
            A04.A06(new C2B() { // from class: com.facebook.ads.redexgen.X.2C
                @Override // com.facebook.ads.redexgen.X.C2B
                public final void A6h(boolean z) {
                    AnonymousClass29 anonymousClass29;
                    if (i == 0) {
                        HX hx2 = hx;
                        anonymousClass29 = C2F.this.A04;
                        hx2.A1P(anonymousClass29);
                    }
                    hx.A1S(z, true);
                }
            });
            A04.A07(adCoverImage.getUrl());
        }
    }

    public final void A0G(C2D c2d) {
        this.A00 = c2d;
    }

    @Override // com.facebook.ads.redexgen.X.C2E
    /* renamed from: A0H, reason: merged with bridge method [inline-methods] */
    public void A0E(C0533Kx c0533Kx, int i) {
        c0533Kx.A0l().setLayoutParams(A01(i));
    }
}
