package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.support.annotation.Nullable;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Fg, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0392Fg implements InterfaceC0452Hp {
    public int A00;

    @Nullable
    public ValueAnimator A01;
    public EnumC0459Hy A02 = EnumC0459Hy.A04;
    public final int A03;
    public final int A04;
    public final View A05;

    public C0392Fg(View view, int i, int i2, int i3) {
        this.A05 = view;
        this.A03 = i;
        this.A00 = i2;
        this.A04 = i3;
    }

    private ValueAnimator A00(int i, int i2, View view) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(this.A03);
        ofInt.addUpdateListener(new C0393Fh(this, view));
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A07(boolean r5) {
        /*
            r4 = this;
            r3 = r4
            if (r5 == 0) goto L47
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L49;
                case 4: goto L2b;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.Fg r3 = (com.facebook.ads.redexgen.X.C0392Fg) r3
            com.facebook.ads.redexgen.X.Hy r0 = com.facebook.ads.redexgen.X.EnumC0459Hy.A05
            r3.A02 = r0
            int r2 = r3.A00
            int r1 = r3.A04
            android.view.View r0 = r3.A05
            android.animation.ValueAnimator r0 = r3.A00(r2, r1, r0)
            r3.A01 = r0
            android.animation.ValueAnimator r1 = r3.A01
            com.facebook.ads.redexgen.X.Fi r0 = new com.facebook.ads.redexgen.X.Fi
            r0.<init>(r3)
            r1.addListener(r0)
            android.animation.ValueAnimator r0 = r3.A01
            r0.start()
            r0 = 3
            goto L4
        L2b:
            com.facebook.ads.redexgen.X.Fg r3 = (com.facebook.ads.redexgen.X.C0392Fg) r3
            android.view.View r0 = r3.A05
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            int r0 = r3.A04
            r1.height = r0
            android.view.View r0 = r3.A05
            r0.setLayoutParams(r1)
            android.view.View r0 = r3.A05
            com.facebook.ads.redexgen.X.KE.A0J(r0)
            com.facebook.ads.redexgen.X.Hy r0 = com.facebook.ads.redexgen.X.EnumC0459Hy.A04
            r3.A02 = r0
            r0 = 3
            goto L4
        L47:
            r0 = 4
            goto L4
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0392Fg.A07(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A08(boolean r5) {
        /*
            r4 = this;
            r3 = r4
            android.view.View r0 = r3.A05
            com.facebook.ads.redexgen.X.KE.A0O(r0)
            if (r5 == 0) goto L47
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L49;
                case 4: goto L30;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.Fg r3 = (com.facebook.ads.redexgen.X.C0392Fg) r3
            com.facebook.ads.redexgen.X.Hy r0 = com.facebook.ads.redexgen.X.EnumC0459Hy.A03
            r3.A02 = r0
            int r2 = r3.A04
            int r1 = r3.A00
            android.view.View r0 = r3.A05
            android.animation.ValueAnimator r0 = r3.A00(r2, r1, r0)
            r3.A01 = r0
            android.animation.ValueAnimator r1 = r3.A01
            com.facebook.ads.redexgen.X.GW r0 = new com.facebook.ads.redexgen.X.GW
            r0.<init>(r3)
            r1.addListener(r0)
            android.animation.ValueAnimator r0 = r3.A01
            r0.start()
            r0 = 3
            goto L9
        L30:
            com.facebook.ads.redexgen.X.Fg r3 = (com.facebook.ads.redexgen.X.C0392Fg) r3
            android.view.View r0 = r3.A05
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            int r0 = r3.A00
            r1.height = r0
            android.view.View r0 = r3.A05
            r0.setLayoutParams(r1)
            com.facebook.ads.redexgen.X.Hy r0 = com.facebook.ads.redexgen.X.EnumC0459Hy.A02
            r3.A02 = r0
            r0 = 3
            goto L9
        L47:
            r0 = 4
            goto L9
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0392Fg.A08(boolean):void");
    }

    public final void A09(int i) {
        this.A00 = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0452Hp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A3A(boolean r3, boolean r4) {
        /*
            r2 = this;
            r1 = r2
            if (r4 == 0) goto L16
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L18;
                case 4: goto Lf;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.Fg r1 = (com.facebook.ads.redexgen.X.C0392Fg) r1
            r1.A07(r3)
            r0 = 3
            goto L4
        Lf:
            com.facebook.ads.redexgen.X.Fg r1 = (com.facebook.ads.redexgen.X.C0392Fg) r1
            r1.A08(r3)
            r0 = 3
            goto L4
        L16:
            r0 = 4
            goto L4
        L18:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0392Fg.A3A(boolean, boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0452Hp
    public final EnumC0459Hy A4x() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0452Hp
    public final void cancel() {
        if (this.A01 != null) {
            this.A01.cancel();
        }
    }
}
