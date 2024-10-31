package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.support.annotation.Nullable;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Fb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0387Fb implements InterfaceC0452Hp {
    public static byte[] A06;

    @Nullable
    public ValueAnimator A00;
    public EnumC0459Hy A01 = EnumC0459Hy.A04;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    static {
        A05();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0387Fb.A06
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
            int r0 = r0 + (-123)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0387Fb.A04(int, int, int):java.lang.String");
    }

    public static void A05() {
        A06 = new byte[]{14, -1, 18, 14, -35, 9, 6, 9, 12};
    }

    public C0387Fb(View view, int i, int i2, int i3) {
        this.A02 = i;
        this.A05 = view;
        this.A04 = i2;
        this.A03 = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            r3 = r5;        r3.A01 = r1;        r3.A00 = android.animation.ObjectAnimator.ofInt((android.widget.TextView) r3.A05, A04(0, 9, 31), r6, r7);        r3.A00.setEvaluator(new android.animation.ArgbEvaluator());        r3.A00.setDuration(r3.A02);        r3.A00.addListener(new com.facebook.ads.redexgen.X.C0388Fc(r3, r6, r7));        r3.A00.start();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(int r6, int r7) {
        /*
            r5 = this;
            r1 = 0
            int r0 = r5.A04
            if (r6 != r0) goto L12
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L14;
                case 4: goto Le;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.Hy r1 = com.facebook.ads.redexgen.X.EnumC0459Hy.A03
            r0 = 3
            goto L6
        Le:
            com.facebook.ads.redexgen.X.Hy r1 = com.facebook.ads.redexgen.X.EnumC0459Hy.A05
            r0 = 3
            goto L6
        L12:
            r0 = 4
            goto L6
        L14:
            r3 = r5
            com.facebook.ads.redexgen.X.Fb r3 = (com.facebook.ads.redexgen.X.C0387Fb) r3
            com.facebook.ads.redexgen.X.Hy r1 = (com.facebook.ads.redexgen.X.EnumC0459Hy) r1
            r3.A01 = r1
            android.view.View r4 = r3.A05
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2 = 0
            r1 = 9
            r0 = 31
            java.lang.String r2 = A04(r2, r1, r0)
            r0 = 2
            int[] r1 = new int[r0]
            r0 = 0
            r1[r0] = r6
            r0 = 1
            r1[r0] = r7
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofInt(r4, r2, r1)
            r3.A00 = r0
            android.animation.ValueAnimator r1 = r3.A00
            android.animation.ArgbEvaluator r0 = new android.animation.ArgbEvaluator
            r0.<init>()
            r1.setEvaluator(r0)
            android.animation.ValueAnimator r2 = r3.A00
            int r0 = r3.A02
            long r0 = (long) r0
            r2.setDuration(r0)
            android.animation.ValueAnimator r1 = r3.A00
            com.facebook.ads.redexgen.X.Fc r0 = new com.facebook.ads.redexgen.X.Fc
            r0.<init>(r3, r6, r7)
            r1.addListener(r0)
            android.animation.ValueAnimator r0 = r3.A00
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0387Fb.A06(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0033, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A07(int r4, int r5, boolean r6) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r6 == 0) goto L31
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L26;
                case 3: goto L33;
                case 4: goto L15;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L2d;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.Fb r2 = (com.facebook.ads.redexgen.X.C0387Fb) r2
            com.facebook.ads.redexgen.X.Hy r1 = (com.facebook.ads.redexgen.X.EnumC0459Hy) r1
            r2.A01 = r1
            r0 = 3
            goto L5
        L11:
            com.facebook.ads.redexgen.X.Hy r1 = com.facebook.ads.redexgen.X.EnumC0459Hy.A02
            r0 = 6
            goto L5
        L15:
            com.facebook.ads.redexgen.X.Fb r2 = (com.facebook.ads.redexgen.X.C0387Fb) r2
            android.view.View r0 = r2.A05
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setTextColor(r5)
            int r0 = r2.A03
            if (r5 != r0) goto L24
            r0 = 5
            goto L5
        L24:
            r0 = 7
            goto L5
        L26:
            com.facebook.ads.redexgen.X.Fb r2 = (com.facebook.ads.redexgen.X.C0387Fb) r2
            r2.A06(r4, r5)
            r0 = 3
            goto L5
        L2d:
            com.facebook.ads.redexgen.X.Hy r1 = com.facebook.ads.redexgen.X.EnumC0459Hy.A04
            r0 = 6
            goto L5
        L31:
            r0 = 4
            goto L5
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0387Fb.A07(int, int, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x002a, code lost:            r3.A07(r1, r2, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x002f, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0452Hp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A3A(boolean r5, boolean r6) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            if (r6 == 0) goto L28
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L22;
                case 3: goto La;
                case 4: goto L1c;
                case 5: goto L2a;
                case 6: goto L10;
                case 7: goto L16;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            if (r6 == 0) goto Le
            r0 = 4
            goto L6
        Le:
            r0 = 6
            goto L6
        L10:
            com.facebook.ads.redexgen.X.Fb r3 = (com.facebook.ads.redexgen.X.C0387Fb) r3
            int r2 = r3.A03
            r0 = 5
            goto L6
        L16:
            com.facebook.ads.redexgen.X.Fb r3 = (com.facebook.ads.redexgen.X.C0387Fb) r3
            int r1 = r3.A04
            r0 = 3
            goto L6
        L1c:
            com.facebook.ads.redexgen.X.Fb r3 = (com.facebook.ads.redexgen.X.C0387Fb) r3
            int r2 = r3.A04
            r0 = 5
            goto L6
        L22:
            com.facebook.ads.redexgen.X.Fb r3 = (com.facebook.ads.redexgen.X.C0387Fb) r3
            int r1 = r3.A03
            r0 = 3
            goto L6
        L28:
            r0 = 7
            goto L6
        L2a:
            com.facebook.ads.redexgen.X.Fb r3 = (com.facebook.ads.redexgen.X.C0387Fb) r3
            r3.A07(r1, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0387Fb.A3A(boolean, boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0452Hp
    public final EnumC0459Hy A4x() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0452Hp
    public final void cancel() {
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
