package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: com.facebook.ads.redexgen.X.50, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass50 {
    public static Field A00;
    public static boolean A01;
    public static Field A02;
    public static Field A03;
    public static boolean A04;
    public static boolean A05;
    public static byte[] A06;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass50.A06
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
            int r0 = r0 + (-66)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass50.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A06 = new byte[]{31, -1, 27, 32, 9, 27, 22, 38, 26, 28, -16, 18, 18, 20, 34, 34, 24, 17, 24, 27, 24, 35, 40, -13, 20, 27, 20, 22, 16, 35, 20, 14, 0, 5, -5, 6, 14, -10, -42, -14, -9, -47, -18, -14, -16, -15, -3};
    }

    static {
        A02();
        A01 = false;
    }

    private final long A00() {
        return ValueAnimator.getFrameDelay();
    }

    public int A03(View view) {
        return 0;
    }

    public int A04(View view) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A05(android.view.View r7) {
        /*
            r6 = this;
            r0 = 0
            r5 = 0
            r0 = 0
            r4 = 1
            boolean r0 = com.facebook.ads.redexgen.X.AnonymousClass50.A04
            if (r0 != 0) goto L41
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 9: goto L2a;
                case 16: goto L44;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            java.lang.Class<android.view.View> r3 = android.view.View.class
            r2 = 37
            r1 = 10
            r0 = 71
            java.lang.String r0 = A01(r2, r1, r0)     // Catch: java.lang.NoSuchFieldException -> L25
            java.lang.reflect.Field r0 = r3.getDeclaredField(r0)     // Catch: java.lang.NoSuchFieldException -> L25
            com.facebook.ads.redexgen.X.AnonymousClass50.A02 = r0     // Catch: java.lang.NoSuchFieldException -> L25
            java.lang.reflect.Field r1 = com.facebook.ads.redexgen.X.AnonymousClass50.A02     // Catch: java.lang.NoSuchFieldException -> L25
            r0 = 1
            r1.setAccessible(r0)     // Catch: java.lang.NoSuchFieldException -> L25
        L25:
            com.facebook.ads.redexgen.X.AnonymousClass50.A04 = r4
            r0 = 9
            goto L9
        L2a:
            java.lang.reflect.Field r0 = com.facebook.ads.redexgen.X.AnonymousClass50.A02
            if (r0 == 0) goto L3d
            java.lang.reflect.Field r0 = com.facebook.ads.redexgen.X.AnonymousClass50.A02     // Catch: java.lang.Exception -> L3d
            java.lang.Object r0 = r0.get(r7)     // Catch: java.lang.Exception -> L3d
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Exception -> L3d
            int r5 = r0.intValue()     // Catch: java.lang.Exception -> L3d
            r0 = 16
            goto L9
        L3d:
            r5 = 0
            r0 = 16
            goto L9
        L41:
            r0 = 9
            goto L9
        L44:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass50.A05(android.view.View):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A06(android.view.View r7) {
        /*
            r6 = this;
            r0 = 0
            r5 = 0
            r0 = 0
            r4 = 1
            boolean r0 = com.facebook.ads.redexgen.X.AnonymousClass50.A05
            if (r0 != 0) goto L40
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 9: goto L29;
                case 16: goto L43;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            java.lang.Class<android.view.View> r3 = android.view.View.class
            r2 = 0
            r1 = 9
            r0 = 112(0x70, float:1.57E-43)
            java.lang.String r0 = A01(r2, r1, r0)     // Catch: java.lang.NoSuchFieldException -> L24
            java.lang.reflect.Field r0 = r3.getDeclaredField(r0)     // Catch: java.lang.NoSuchFieldException -> L24
            com.facebook.ads.redexgen.X.AnonymousClass50.A03 = r0     // Catch: java.lang.NoSuchFieldException -> L24
            java.lang.reflect.Field r1 = com.facebook.ads.redexgen.X.AnonymousClass50.A03     // Catch: java.lang.NoSuchFieldException -> L24
            r0 = 1
            r1.setAccessible(r0)     // Catch: java.lang.NoSuchFieldException -> L24
        L24:
            com.facebook.ads.redexgen.X.AnonymousClass50.A05 = r4
            r0 = 9
            goto L9
        L29:
            java.lang.reflect.Field r0 = com.facebook.ads.redexgen.X.AnonymousClass50.A03
            if (r0 == 0) goto L3c
            java.lang.reflect.Field r0 = com.facebook.ads.redexgen.X.AnonymousClass50.A03     // Catch: java.lang.Exception -> L3c
            java.lang.Object r0 = r0.get(r7)     // Catch: java.lang.Exception -> L3c
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Exception -> L3c
            int r5 = r0.intValue()     // Catch: java.lang.Exception -> L3c
            r0 = 16
            goto L9
        L3c:
            r5 = 0
            r0 = 16
            goto L9
        L40:
            r0 = 9
            goto L9
        L43:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass50.A06(android.view.View):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.Display A07(android.view.View r5) {
        /*
            r4 = this;
            r1 = 0
            boolean r0 = r4.A0I(r5)
            if (r0 == 0) goto L2a
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L2c;
                case 4: goto L27;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            android.view.View r5 = (android.view.View) r5
            android.content.Context r3 = r5.getContext()
            r2 = 31
            r1 = 6
            r0 = 85
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.Object r0 = r3.getSystemService(r0)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r1 = r0.getDefaultDisplay()
            r0 = 3
            goto L8
        L27:
            r1 = 0
            r0 = 3
            goto L8
        L2a:
            r0 = 4
            goto L8
        L2c:
            android.view.Display r1 = (android.view.Display) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass50.A07(android.view.View):android.view.Display");
    }

    public C5Y A08(View view, C5Y c5y) {
        return c5y;
    }

    public C5Y A09(View view, C5Y c5y) {
        return c5y;
    }

    public void A0A(View view) {
        view.postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void A0B(View view) {
        if (view instanceof InterfaceC01144h) {
            ((InterfaceC01144h) view).stopNestedScroll();
        }
    }

    public void A0C(View view, int i) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:            r3.setAccessibilityDelegate(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0D(android.view.View r3, @android.support.annotation.Nullable com.facebook.ads.redexgen.X.C01114e r4) {
        /*
            r2 = this;
            r1 = 0
            if (r4 != 0) goto L13
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L15;
                case 4: goto Lb;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            r1 = 0
            r0 = 3
            goto L4
        Lb:
            com.facebook.ads.redexgen.X.4e r4 = (com.facebook.ads.redexgen.X.C01114e) r4
            android.view.View$AccessibilityDelegate r1 = r4.A00()
            r0 = 3
            goto L4
        L13:
            r0 = 4
            goto L4
        L15:
            android.view.View r3 = (android.view.View) r3
            r3.setAccessibilityDelegate(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass50.A0D(android.view.View, com.facebook.ads.redexgen.X.4e):void");
    }

    public void A0E(View view, InterfaceC01194m interfaceC01194m) {
    }

    public void A0F(View view, Runnable runnable) {
        view.postDelayed(runnable, A00());
    }

    public void A0G(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, A00() + j);
    }

    public boolean A0H(View view) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A0I(android.view.View r3) {
        /*
            r2 = this;
            r1 = 0
            android.os.IBinder r0 = r3.getWindowToken()
            if (r0 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass50.A0I(android.view.View):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004b, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0J(android.view.View r7) {
        /*
            r6 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            r5 = 1
            r4 = 0
            boolean r0 = com.facebook.ads.redexgen.X.AnonymousClass50.A01
            if (r0 == 0) goto L49
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L4b;
                case 3: goto L13;
                case 14: goto Le;
                case 15: goto L46;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r4 = 0
            r5 = r4
            r0 = 15
            goto La
        L13:
            java.lang.reflect.Field r0 = com.facebook.ads.redexgen.X.AnonymousClass50.A00
            if (r0 != 0) goto L34
            java.lang.Class<android.view.View> r3 = android.view.View.class
            r2 = 9
            r1 = 22
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r0 = A01(r2, r1, r0)     // Catch: java.lang.Throwable -> L30
            java.lang.reflect.Field r0 = r3.getDeclaredField(r0)     // Catch: java.lang.Throwable -> L30
            com.facebook.ads.redexgen.X.AnonymousClass50.A00 = r0     // Catch: java.lang.Throwable -> L30
            java.lang.reflect.Field r1 = com.facebook.ads.redexgen.X.AnonymousClass50.A00     // Catch: java.lang.Throwable -> L30
            r0 = 1
            r1.setAccessible(r0)     // Catch: java.lang.Throwable -> L30
            goto L34
        L30:
            com.facebook.ads.redexgen.X.AnonymousClass50.A01 = r5
            r0 = 2
            goto La
        L34:
            java.lang.reflect.Field r0 = com.facebook.ads.redexgen.X.AnonymousClass50.A00     // Catch: java.lang.Throwable -> L42
            java.lang.Object r0 = r0.get(r7)     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L3f
            r0 = 15
            goto La
        L3f:
            r0 = 14
            goto La
        L42:
            com.facebook.ads.redexgen.X.AnonymousClass50.A01 = r5
            r0 = 2
            goto La
        L46:
            r4 = r5
            r0 = 2
            goto La
        L49:
            r0 = 3
            goto La
        L4b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass50.A0J(android.view.View):boolean");
    }
}
