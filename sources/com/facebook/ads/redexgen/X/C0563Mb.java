package com.facebook.ads.redexgen.X;

import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;

@TargetApi(12)
/* renamed from: com.facebook.ads.redexgen.X.Mb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0563Mb implements QI {
    public View A00;

    @Nullable
    public C0537Lb A01;

    @Nullable
    public NA A02;
    public boolean A03;
    public final Handler A04;
    public final AbstractC02238s A05;
    public final AbstractC02198o A06;
    public final AbstractC02178m A07;
    public final QY A08;
    public final boolean A09;
    public final boolean A0A;

    public C0563Mb(View view, NA na) {
        this(view, na, false);
    }

    public C0563Mb(View view, NA na, boolean z) {
        this(view, na, z, false);
    }

    public C0563Mb(View view, @Nullable NA na, boolean z, boolean z2) {
        this.A06 = new C0653Pp(this);
        this.A07 = new PA(this);
        this.A05 = new P9(this);
        this.A08 = new C0599Nm(this);
        this.A03 = true;
        this.A04 = new Handler();
        this.A09 = z;
        this.A0A = z2;
        A08(view, na);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        this.A00.animate().alpha(0.0f).setDuration(500L).setListener(new NV(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(int i, int i2) {
        this.A04.removeCallbacksAndMessages(null);
        this.A00.clearAnimation();
        this.A00.setAlpha(i);
        this.A00.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(AnimatorListenerAdapter animatorListenerAdapter) {
        this.A00.setVisibility(0);
        this.A00.animate().alpha(1.0f).setDuration(500L).setListener(animatorListenerAdapter);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A08(android.view.View r4, com.facebook.ads.redexgen.X.NA r5) {
        /*
            r3 = this;
            r2 = r3
            r2.A02 = r5
            r2.A00 = r4
            android.view.View r0 = r2.A00
            r0.clearAnimation()
            com.facebook.ads.redexgen.X.NA r0 = com.facebook.ads.redexgen.X.NA.A03
            if (r5 != r0) goto L35
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L37;
                case 4: goto L24;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.Mb r2 = (com.facebook.ads.redexgen.X.C0563Mb) r2
            android.view.View r1 = r2.A00
            r0 = 0
            r1.setAlpha(r0)
            android.view.View r1 = r2.A00
            r0 = 8
            r1.setVisibility(r0)
            r0 = 3
            goto Lf
        L24:
            com.facebook.ads.redexgen.X.Mb r2 = (com.facebook.ads.redexgen.X.C0563Mb) r2
            android.view.View r1 = r2.A00
            r0 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r0)
            android.view.View r1 = r2.A00
            r0 = 0
            r1.setVisibility(r0)
            r0 = 3
            goto Lf
        L35:
            r0 = 4
            goto Lf
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0563Mb.A08(android.view.View, com.facebook.ads.redexgen.X.NA):void");
    }

    public final void A0F() {
        this.A03 = false;
        A07(null);
    }

    public final boolean A0G() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.QI
    public final void A5M(C0537Lb c0537Lb) {
        this.A01 = c0537Lb;
        c0537Lb.getEventBus().A03(this.A06, this.A07, this.A08, this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.QI
    public final void A8U(C0537Lb c0537Lb) {
        A06(1, 0);
        c0537Lb.getEventBus().A04(this.A05, this.A08, this.A07, this.A06);
        this.A01 = null;
    }
}
