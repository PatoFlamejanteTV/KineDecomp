package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* loaded from: assets/audience_network.dex */
public final class QF extends RelativeLayout {

    @Nullable
    public M6 A00;
    public WeakReference<H6> A01;
    public final FT A02;

    public QF(C0362Ec c0362Ec, FT ft) {
        super(c0362Ec);
        this.A02 = ft;
        KE.A0L((View) this.A02);
        addView(this.A02.getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public final void A00(QJ qj) {
        addView(qj, new RelativeLayout.LayoutParams(-1, -1));
        this.A00 = (M6) qj;
    }

    public final void A01(QJ qj) {
        KE.A0L(qj);
        this.A00 = null;
    }

    public final boolean A02() {
        return this.A02.A56();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A03(int r3) {
        /*
            r2 = this;
            r1 = 0
            com.facebook.ads.redexgen.X.FT r0 = r2.A02
            int r0 = r0.getCurrentPosition()
            if (r0 <= r3) goto L14
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L16;
                case 4: goto L11;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r1 = 1
            r0 = 3
            goto La
        L11:
            r1 = 0
            r0 = 3
            goto La
        L14:
            r0 = 4
            goto La
        L16:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.QF.A03(int):boolean");
    }

    public int getCurrentPosition() {
        return this.A02.getCurrentPosition();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ((View) this.A02).layout(0, 0, getWidth(), getHeight());
        if (this.A00 != null) {
            this.A00.layout(0, 0, getWidth(), getHeight());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:182:0x0131, code lost:            return;     */
    @Override // android.widget.RelativeLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.QF.onMeasure(int, int):void");
    }

    public void setViewImplInflationListener(H6 h6) {
        this.A01 = new WeakReference<>(h6);
    }
}
