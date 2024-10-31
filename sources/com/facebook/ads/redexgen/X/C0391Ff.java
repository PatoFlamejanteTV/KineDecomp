package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;

/* renamed from: com.facebook.ads.redexgen.X.Ff, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0391Ff extends AnimatorListenerAdapter {
    public final /* synthetic */ C0389Fd A00;

    public C0391Ff(C0389Fd c0389Fd) {
        this.A00 = c0389Fd;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:            return;     */
    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onAnimationCancel(android.animation.Animator r4) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Fd r0 = r2.A00
            boolean r0 = com.facebook.ads.redexgen.X.C0389Fd.A06(r0)
            if (r0 == 0) goto L4f
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L1d;
                case 4: goto L3c;
                case 5: goto L51;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.Ff r2 = (com.facebook.ads.redexgen.X.C0391Ff) r2
            com.facebook.ads.redexgen.X.Fd r0 = r2.A00
            android.view.View r0 = com.facebook.ads.redexgen.X.C0389Fd.A00(r0)
            com.facebook.ads.redexgen.X.KE.A0J(r0)
            r0 = 3
            goto Lc
        L1d:
            com.facebook.ads.redexgen.X.Ff r2 = (com.facebook.ads.redexgen.X.C0391Ff) r2
            com.facebook.ads.redexgen.X.Fd r0 = r2.A00
            android.view.View r1 = com.facebook.ads.redexgen.X.C0389Fd.A00(r0)
            r0 = 0
            r1.setAlpha(r0)
            com.facebook.ads.redexgen.X.Fd r1 = r2.A00
            com.facebook.ads.redexgen.X.Hy r0 = com.facebook.ads.redexgen.X.EnumC0459Hy.A04
            com.facebook.ads.redexgen.X.C0389Fd.A03(r1, r0)
            com.facebook.ads.redexgen.X.Fd r0 = r2.A00
            android.view.ViewPropertyAnimator r0 = com.facebook.ads.redexgen.X.C0389Fd.A01(r0)
            if (r0 == 0) goto L3a
            r0 = 4
            goto Lc
        L3a:
            r0 = 5
            goto Lc
        L3c:
            com.facebook.ads.redexgen.X.Ff r2 = (com.facebook.ads.redexgen.X.C0391Ff) r2
            r1 = 0
            com.facebook.ads.redexgen.X.Fd r0 = r2.A00
            android.view.ViewPropertyAnimator r0 = com.facebook.ads.redexgen.X.C0389Fd.A01(r0)
            r0.setListener(r1)
            com.facebook.ads.redexgen.X.Fd r0 = r2.A00
            com.facebook.ads.redexgen.X.C0389Fd.A02(r0, r1)
            r0 = 5
            goto Lc
        L4f:
            r0 = 3
            goto Lc
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0391Ff.onAnimationCancel(android.animation.Animator):void");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewPropertyAnimator viewPropertyAnimator;
        ViewPropertyAnimator viewPropertyAnimator2;
        this.A00.A01 = EnumC0459Hy.A02;
        viewPropertyAnimator = this.A00.A00;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator2 = this.A00.A00;
            viewPropertyAnimator2.setListener(null);
            this.A00.A00 = null;
        }
    }
}
