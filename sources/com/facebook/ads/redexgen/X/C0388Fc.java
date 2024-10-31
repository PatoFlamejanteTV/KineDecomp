package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.ValueAnimator;

/* renamed from: com.facebook.ads.redexgen.X.Fc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0388Fc implements Animator.AnimatorListener {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C0387Fb A02;

    public C0388Fc(C0387Fb c0387Fb, int i, int i2) {
        this.A02 = c0387Fb;
        this.A01 = i;
        this.A00 = i2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        this.A02.A07(this.A00, this.A01, false);
        valueAnimator = this.A02.A00;
        if (valueAnimator != null) {
            valueAnimator2 = this.A02.A00;
            valueAnimator2.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:            return;     */
    @Override // android.animation.Animator.AnimatorListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onAnimationEnd(android.animation.Animator r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Fb r2 = r4.A02
            int r1 = r4.A01
            com.facebook.ads.redexgen.X.Fb r0 = r4.A02
            int r0 = com.facebook.ads.redexgen.X.C0387Fb.A00(r0)
            if (r1 != r0) goto L44
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L18;
                case 4: goto L2d;
                case 5: goto L46;
                case 6: goto L40;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.Hy r3 = com.facebook.ads.redexgen.X.EnumC0459Hy.A02
            r0 = 3
            goto L10
        L18:
            com.facebook.ads.redexgen.X.Fc r4 = (com.facebook.ads.redexgen.X.C0388Fc) r4
            com.facebook.ads.redexgen.X.Fb r2 = (com.facebook.ads.redexgen.X.C0387Fb) r2
            com.facebook.ads.redexgen.X.Hy r3 = (com.facebook.ads.redexgen.X.EnumC0459Hy) r3
            com.facebook.ads.redexgen.X.C0387Fb.A03(r2, r3)
            com.facebook.ads.redexgen.X.Fb r0 = r4.A02
            android.animation.ValueAnimator r0 = com.facebook.ads.redexgen.X.C0387Fb.A01(r0)
            if (r0 == 0) goto L2b
            r0 = 4
            goto L10
        L2b:
            r0 = 5
            goto L10
        L2d:
            com.facebook.ads.redexgen.X.Fc r4 = (com.facebook.ads.redexgen.X.C0388Fc) r4
            com.facebook.ads.redexgen.X.Fb r0 = r4.A02
            android.animation.ValueAnimator r0 = com.facebook.ads.redexgen.X.C0387Fb.A01(r0)
            r0.removeAllListeners()
            com.facebook.ads.redexgen.X.Fb r1 = r4.A02
            r0 = 0
            com.facebook.ads.redexgen.X.C0387Fb.A02(r1, r0)
            r0 = 5
            goto L10
        L40:
            com.facebook.ads.redexgen.X.Hy r3 = com.facebook.ads.redexgen.X.EnumC0459Hy.A04
            r0 = 3
            goto L10
        L44:
            r0 = 6
            goto L10
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0388Fc.onAnimationEnd(android.animation.Animator):void");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
