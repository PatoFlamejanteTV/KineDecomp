package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.Ny, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0611Ny extends AbstractC0605Ns {
    public static final int A02 = Resources.getSystem().getDisplayMetrics().widthPixels;
    public final View A00;
    public final boolean A01;

    public C0611Ny(C0610Nx c0610Nx, C2T c2t, boolean z) {
        super(c0610Nx, c2t, true);
        this.A01 = z;
        this.A00 = c0610Nx.A02();
        A0e();
        if (this.A01) {
            addView(c0610Nx.A02(), new RelativeLayout.LayoutParams(-1, -1));
        } else {
            FrameLayout frameLayout = new FrameLayout(c0610Nx.A05());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(2, getAdDetailsView().getId());
            frameLayout.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            layoutParams2.setMargins(AbstractC0604Nr.A05, 0, AbstractC0604Nr.A05, 0);
            frameLayout.addView(this.A00, layoutParams2);
            addView(frameLayout);
        }
        getAdDetailsView().bringToFront();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x001f, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A04() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A01
            if (r0 == 0) goto L1d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L17;
                case 4: goto L1f;
                case 5: goto L1a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Ny r2 = (com.facebook.ads.redexgen.X.C0611Ny) r2
            boolean r0 = super.A04()
            if (r0 == 0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 5
            goto L7
        L17:
            r1 = 1
            r0 = 4
            goto L7
        L1a:
            r1 = 0
            r0 = 4
            goto L7
        L1d:
            r0 = 5
            goto L7
        L1f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0611Ny.A04():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x001f, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A07() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A01
            if (r0 == 0) goto L1d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L17;
                case 4: goto L1f;
                case 5: goto L1a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Ny r2 = (com.facebook.ads.redexgen.X.C0611Ny) r2
            boolean r0 = super.A04()
            if (r0 == 0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 5
            goto L7
        L17:
            r1 = 1
            r0 = 4
            goto L7
        L1a:
            r1 = 0
            r0 = 4
            goto L7
        L1d:
            r0 = 5
            goto L7
        L1f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0611Ny.A07():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0605Ns, com.facebook.ads.redexgen.X.AbstractC0604Nr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Z(com.facebook.ads.redexgen.X.C2L r12, java.lang.String r13, double r14, @android.support.annotation.Nullable android.os.Bundle r16) {
        /*
            r11 = this;
            r5 = r11
            r0 = 0
            r0 = 0
            r7 = r13
            r6 = r12
            r10 = r16
            r8 = r14
            super.A0Z(r6, r7, r8, r10)
            boolean r0 = r5.A01
            if (r0 != 0) goto L43
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L1e;
                case 4: goto L45;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r1 = 0
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 <= 0) goto L1c
            r0 = 3
            goto L10
        L1c:
            r0 = 4
            goto L10
        L1e:
            com.facebook.ads.redexgen.X.Ny r5 = (com.facebook.ads.redexgen.X.C0611Ny) r5
            r4 = 0
            int r1 = com.facebook.ads.redexgen.X.C0611Ny.A02
            int r0 = com.facebook.ads.redexgen.X.AbstractC0604Nr.A05
            int r0 = r0 * 2
            int r1 = r1 - r0
            double r2 = (double) r1
            double r2 = r2 / r8
            int r1 = (int) r2
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r0 = -1
            r2.<init>(r0, r1)
            r0 = 17
            r2.gravity = r0
            int r1 = com.facebook.ads.redexgen.X.AbstractC0604Nr.A05
            int r0 = com.facebook.ads.redexgen.X.AbstractC0604Nr.A05
            r2.setMargins(r1, r4, r0, r4)
            android.view.View r0 = r5.A00
            r0.setLayoutParams(r2)
            r0 = 4
            goto L10
        L43:
            r0 = 4
            goto L10
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0611Ny.A0Z(com.facebook.ads.redexgen.X.2L, java.lang.String, double, android.os.Bundle):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A0b() {
        return this.A01;
    }
}
