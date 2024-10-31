package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;

/* renamed from: com.facebook.ads.redexgen.X.Jz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class ViewOnSystemUiVisibilityChangeListenerC0509Jz implements View.OnSystemUiVisibilityChangeListener {
    public int A00;

    @Nullable
    public Window A01;
    public final View A03;
    public EnumC0508Jy A02 = EnumC0508Jy.A02;
    public final Runnable A04 = new C0506Jw(this);

    public ViewOnSystemUiVisibilityChangeListenerC0509Jz(View view) {
        this.A03 = view;
        this.A03.setOnSystemUiVisibilityChangeListener(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A00(int r5, boolean r6) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            android.view.Window r0 = r3.A01
            if (r0 != 0) goto L38
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L3a;
                case 3: goto Lb;
                case 4: goto L19;
                case 5: goto L22;
                case 6: goto L2d;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Jz r3 = (com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz) r3
            android.view.Window r0 = r3.A01
            android.view.WindowManager$LayoutParams r2 = r0.getAttributes()
            if (r6 == 0) goto L17
            r0 = 4
            goto L7
        L17:
            r0 = 6
            goto L7
        L19:
            android.view.WindowManager$LayoutParams r2 = (android.view.WindowManager.LayoutParams) r2
            int r0 = r2.flags
            r0 = r0 | r5
            r2.flags = r0
            r0 = 5
            goto L7
        L22:
            com.facebook.ads.redexgen.X.Jz r3 = (com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz) r3
            android.view.WindowManager$LayoutParams r2 = (android.view.WindowManager.LayoutParams) r2
            android.view.Window r0 = r3.A01
            r0.setAttributes(r2)
            r0 = 2
            goto L7
        L2d:
            android.view.WindowManager$LayoutParams r2 = (android.view.WindowManager.LayoutParams) r2
            int r1 = r2.flags
            r0 = r5 ^ (-1)
            r1 = r1 & r0
            r2.flags = r1
            r0 = 5
            goto L7
        L38:
            r0 = 3
            goto L7
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz.A00(int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0052, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A02(boolean r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r3 = 0
            com.facebook.ads.redexgen.X.Jy r1 = com.facebook.ads.redexgen.X.EnumC0508Jy.A02
            com.facebook.ads.redexgen.X.Jy r0 = r5.A02
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L50
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L52;
                case 3: goto L3f;
                case 4: goto L3b;
                case 5: goto L2c;
                case 6: goto L12;
                case 7: goto L19;
                case 8: goto L47;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            if (r7 == 0) goto L16
            r0 = 7
            goto Le
        L16:
            r0 = 8
            goto Le
        L19:
            com.facebook.ads.redexgen.X.Jz r5 = (com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz) r5
            android.os.Handler r4 = (android.os.Handler) r4
            java.lang.Runnable r0 = r5.A04
            r4.removeCallbacks(r0)
            java.lang.Runnable r2 = r5.A04
            r0 = 2000(0x7d0, double:9.88E-321)
            r4.postDelayed(r2, r0)
            r0 = 8
            goto Le
        L2c:
            com.facebook.ads.redexgen.X.Jz r5 = (com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz) r5
            android.view.View r0 = r5.A03
            android.os.Handler r4 = r0.getHandler()
            if (r4 == 0) goto L38
            r0 = 6
            goto Le
        L38:
            r0 = 8
            goto Le
        L3b:
            r3 = r3 | 7
            r0 = 5
            goto Le
        L3f:
            r3 = 3840(0xf00, float:5.381E-42)
            if (r7 != 0) goto L45
            r0 = 4
            goto Le
        L45:
            r0 = 5
            goto Le
        L47:
            com.facebook.ads.redexgen.X.Jz r5 = (com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz) r5
            android.view.View r0 = r5.A03
            r0.setSystemUiVisibility(r3)
            r0 = 2
            goto Le
        L50:
            r0 = 3
            goto Le
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz.A02(boolean):void");
    }

    public final void A03() {
        this.A01 = null;
    }

    public final void A04(Window window) {
        this.A01 = window;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05(com.facebook.ads.redexgen.X.EnumC0508Jy r7) {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r4 = 134217728(0x8000000, float:3.85186E-34)
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r2 = 1
            r0 = 0
            r5.A02 = r7
            int[] r1 = com.facebook.ads.redexgen.X.C0507Jx.A00
            com.facebook.ads.redexgen.X.Jy r0 = r5.A02
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L3d;
                default: goto L1a;
            }
        L1a:
            r0 = 2
        L1b:
            switch(r0) {
                case 2: goto L1f;
                case 3: goto L3f;
                case 4: goto L2f;
                default: goto L1e;
            }
        L1e:
            goto L1b
        L1f:
            com.facebook.ads.redexgen.X.Jz r5 = (com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz) r5
            r1 = 0
            r5.A00(r3, r1)
            r5.A00(r4, r1)
            android.view.View r0 = r5.A03
            r0.setSystemUiVisibility(r1)
            r0 = 3
            goto L1b
        L2f:
            com.facebook.ads.redexgen.X.Jz r5 = (com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz) r5
            r0 = 0
            r5.A00(r3, r2)
            r5.A00(r4, r2)
            r5.A02(r0)
            r0 = 3
            goto L1b
        L3d:
            r0 = 4
            goto L1b
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz.A05(com.facebook.ads.redexgen.X.Jy):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0021, code lost:            return;     */
    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onSystemUiVisibilityChange(int r3) {
        /*
            r2 = this;
            r1 = r2
            int r0 = r1.A00
            r0 = r0 ^ r3
            r1.A00 = r3
            r0 = r0 & 2
            if (r0 == 0) goto L1f
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L17;
                case 4: goto L21;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r0 = r3 & 2
            if (r0 != 0) goto L15
            r0 = 3
            goto Lb
        L15:
            r0 = 4
            goto Lb
        L17:
            com.facebook.ads.redexgen.X.Jz r1 = (com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz) r1
            r0 = 1
            r1.A02(r0)
            r0 = 4
            goto Lb
        L1f:
            r0 = 4
            goto Lb
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ViewOnSystemUiVisibilityChangeListenerC0509Jz.onSystemUiVisibilityChange(int):void");
    }
}
