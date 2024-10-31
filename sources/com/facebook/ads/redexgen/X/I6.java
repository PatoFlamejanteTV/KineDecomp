package com.facebook.ads.redexgen.X;

import android.R;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.support.annotation.Nullable;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network.dex */
public final class I6 extends RelativeLayout implements QI {
    public static byte[] A08;
    public static final int A09;
    public int A00;
    public ObjectAnimator A01;
    public ProgressBar A02;
    public C1S A03;
    public C1S A04;
    public C1S A05;
    public C1S A06;

    @Nullable
    public C0537Lb A07;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.I6.A08
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
            int r0 = r0 + (-6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.I6.A01(int, int, int):java.lang.String");
    }

    public static void A05() {
        A08 = new byte[]{-107, -105, -108, -116, -105, -118, -104, -104};
    }

    static {
        A05();
        A09 = (int) (6.0f * KE.A01);
    }

    public I6(C0362Ec c0362Ec) {
        this(c0362Ec, A09, -12549889, 0);
    }

    public I6(C0362Ec c0362Ec, int i, int i2, int i3) {
        super(c0362Ec);
        this.A00 = -1;
        this.A06 = new IA(this);
        this.A04 = new I9(this);
        this.A05 = new I8(this);
        this.A03 = new I7(this);
        this.A02 = new ProgressBar(c0362Ec, null, R.attr.progressBarStyleHorizontal);
        A0A(i2, i3);
        this.A02.setMax(10000);
        addView(this.A02, new RelativeLayout.LayoutParams(-1, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        A03();
        this.A01 = ObjectAnimator.ofInt(this.A02, A01(0, 8, 31), 0, 0);
        this.A01.setDuration(0L);
        this.A01.setInterpolator(new LinearInterpolator());
        this.A01.start();
        this.A00 = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        if (this.A01 != null) {
            this.A01.cancel();
            this.A01.setTarget(null);
            this.A01 = null;
            this.A02.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A04() {
        /*
            r9 = this;
            r6 = r9
            r0 = 0
            r0 = 0
            r5 = 0
            r4 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.Lb r1 = r6.A07
            if (r1 != 0) goto L7e
            r1 = 2
        Lb:
            switch(r1) {
                case 2: goto L80;
                case 3: goto L24;
                case 4: goto L1f;
                case 5: goto L15;
                case 6: goto Lf;
                case 7: goto L3c;
                case 8: goto L7b;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r5 <= r4) goto L13
            r1 = 7
            goto Lb
        L13:
            r1 = 2
            goto Lb
        L15:
            com.facebook.ads.redexgen.X.I6 r6 = (com.facebook.ads.redexgen.X.I6) r6
            int r1 = r6.A00
            if (r1 >= r0) goto L1d
            r1 = 6
            goto Lb
        L1d:
            r1 = 2
            goto Lb
        L1f:
            int r0 = r4 * 10000
            int r0 = r0 / r5
            r1 = 5
            goto Lb
        L24:
            com.facebook.ads.redexgen.X.I6 r6 = (com.facebook.ads.redexgen.X.I6) r6
            r6.A03()
            com.facebook.ads.redexgen.X.Lb r1 = r6.A07
            int r4 = r1.getCurrentPositionInMillis()
            com.facebook.ads.redexgen.X.Lb r1 = r6.A07
            int r5 = r1.getDuration()
            if (r5 <= 0) goto L39
            r1 = 4
            goto Lb
        L39:
            r1 = 8
            goto Lb
        L3c:
            com.facebook.ads.redexgen.X.I6 r6 = (com.facebook.ads.redexgen.X.I6) r6
            r8 = 0
            android.widget.ProgressBar r7 = r6.A02
            r3 = 0
            r2 = 8
            r1 = 31
            java.lang.String r3 = A01(r3, r2, r1)
            r1 = 2
            int[] r2 = new int[r1]
            int r1 = r6.A00
            r2[r8] = r1
            r1 = 1
            r2[r1] = r0
            android.animation.ObjectAnimator r1 = android.animation.ObjectAnimator.ofInt(r7, r3, r2)
            r6.A01 = r1
            android.animation.ObjectAnimator r3 = r6.A01
            r2 = 250(0xfa, float:3.5E-43)
            int r1 = r5 - r4
            int r1 = java.lang.Math.min(r2, r1)
            long r1 = (long) r1
            r3.setDuration(r1)
            android.animation.ObjectAnimator r2 = r6.A01
            android.view.animation.LinearInterpolator r1 = new android.view.animation.LinearInterpolator
            r1.<init>()
            r2.setInterpolator(r1)
            android.animation.ObjectAnimator r1 = r6.A01
            r1.start()
            r6.A00 = r0
            r1 = 2
            goto Lb
        L7b:
            r0 = 0
            r1 = 5
            goto Lb
        L7e:
            r1 = 3
            goto Lb
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.I6.A04():void");
    }

    public final void A09() {
        A03();
        this.A02 = null;
        this.A07 = null;
    }

    public final void A0A(int i, int i2) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(i2), new ColorDrawable(i2), new ScaleDrawable(new ColorDrawable(i), 8388611, 1.0f, -1.0f)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        this.A02.setProgressDrawable(layerDrawable);
    }

    @Override // com.facebook.ads.redexgen.X.QI
    public final void A5M(C0537Lb c0537Lb) {
        this.A07 = c0537Lb;
        c0537Lb.getEventBus().A03(this.A04, this.A05, this.A06, this.A03);
    }

    @Override // com.facebook.ads.redexgen.X.QI
    public final void A8U(C0537Lb c0537Lb) {
        c0537Lb.getEventBus().A04(this.A06, this.A05, this.A04, this.A03);
        this.A07 = null;
    }
}
