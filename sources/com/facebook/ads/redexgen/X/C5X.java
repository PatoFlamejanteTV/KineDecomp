package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* renamed from: com.facebook.ads.redexgen.X.5X, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5X {
    public static final C5U A00;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            A00 = new C5V() { // from class: com.facebook.ads.redexgen.X.5W
                public static byte[] A00;

                static {
                    A01();
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public static java.lang.String A00(int r2, int r3, int r4) {
                    /*
                        r0 = 0
                        r0 = 0
                        byte[] r1 = com.facebook.ads.redexgen.X.C5W.A00
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
                        r0 = r0 ^ r4
                        r0 = r0 ^ 101(0x65, float:1.42E-43)
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5W.A00(int, int, int):java.lang.String");
                }

                public static void A01() {
                    A00 = new byte[]{61, 53, 36, 56, 63, 52, 112, 63, 62, 30, 53, 35, 36, 53, 52, 3, 51, 34, 63, 60, 60, 17, 51, 51, 53, 32, 36, 53, 52, 89, 81, 64, 92, 91, 80, 20, 91, 90, 122, 81, 71, 64, 81, 80, 100, 70, 81, 114, 88, 93, 90, 83, 90, 82, 67, 95, 88, 83, 23, 88, 89, 121, 82, 68, 67, 82, 83, 103, 69, 82, 100, 84, 69, 88, 91, 91, 27, 95, 84, 94, 72, 27, 85, 84, 79, 27, 82, 86, 75, 87, 94, 86, 94, 85, 79, 27, 82, 85, 79, 94, 73, 93, 90, 88, 94, 27, 89, 102, 106, 120, 95, 110, 125, 106, 97, 123, 76, 96, 98, Byte.MAX_VALUE, 110, 123, 42, 34, 51, 47, 40, 35, 103, 40, 41, 20, 51, 40, 55, 9, 34, 52, 51, 34, 35, 20, 36, 53, 40, 43, 43, 107, 99, 114, 110, 105, 98, 38, 105, 104, 72, 99, 117, 114, 99, 98, 64, 106, 111, 104, 97, 31, 23, 6, 26, 29, 22, 82, 29, 28, 33, 6, 19, 0, 6, 60, 23, 1, 6, 23, 22, 33, 17, 0, 29, 30, 30, 7, 15, 30, 2, 5, 14, 74, 5, 4, 36, 15, 25, 30, 15, 14, 57, 9, 24, 5, 6, 6, 87, 104, 100, 118, 81, 96, 115, 100, 111, 117, 33};
                }

                @Override // com.facebook.ads.redexgen.X.C5U
                public final void A02(ViewParent viewParent, View view) {
                    try {
                        viewParent.onStopNestedScroll(view);
                    } catch (AbstractMethodError e) {
                        Log.e(A00(106, 16, 106), A00(214, 11, 100) + viewParent + A00(76, 30, 94) + A00(122, 25, 34), e);
                    }
                }

                @Override // com.facebook.ads.redexgen.X.C5U
                public final void A03(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
                    try {
                        viewParent.onNestedScroll(view, i, i2, i3, i4);
                    } catch (AbstractMethodError e) {
                        Log.e(A00(106, 16, 106), A00(214, 11, 100) + viewParent + A00(76, 30, 94) + A00(193, 21, 15), e);
                    }
                }

                @Override // com.facebook.ads.redexgen.X.C5U
                public final void A04(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
                    try {
                        viewParent.onNestedPreScroll(view, i, i2, iArr);
                    } catch (AbstractMethodError e) {
                        Log.e(A00(106, 16, 106), A00(214, 11, 100) + viewParent + A00(76, 30, 94) + A00(52, 24, 82), e);
                    }
                }

                @Override // com.facebook.ads.redexgen.X.C5U
                public final void A05(ViewParent viewParent, View view, View view2, int i) {
                    try {
                        viewParent.onNestedScrollAccepted(view, view2, i);
                    } catch (AbstractMethodError e) {
                        Log.e(A00(106, 16, 106), A00(214, 11, 100) + viewParent + A00(76, 30, 94) + A00(0, 29, 53), e);
                    }
                }

                @Override // com.facebook.ads.redexgen.X.C5U
                public final boolean A06(ViewParent viewParent, View view, float f, float f2) {
                    try {
                        return viewParent.onNestedPreFling(view, f, f2);
                    } catch (AbstractMethodError e) {
                        Log.e(A00(106, 16, 106), A00(214, 11, 100) + viewParent + A00(76, 30, 94) + A00(29, 23, 81), e);
                        return false;
                    }
                }

                @Override // com.facebook.ads.redexgen.X.C5U
                public final boolean A07(ViewParent viewParent, View view, float f, float f2, boolean z) {
                    try {
                        return viewParent.onNestedFling(view, f, f2, z);
                    } catch (AbstractMethodError e) {
                        Log.e(A00(106, 16, 106), A00(214, 11, 100) + viewParent + A00(76, 30, 94) + A00(147, 20, 99), e);
                        return false;
                    }
                }

                @Override // com.facebook.ads.redexgen.X.C5U
                public final boolean A08(ViewParent viewParent, View view, View view2, int i) {
                    try {
                        return viewParent.onStartNestedScroll(view, view2, i);
                    } catch (AbstractMethodError e) {
                        Log.e(A00(106, 16, 106), A00(214, 11, 100) + viewParent + A00(76, 30, 94) + A00(167, 26, 23), e);
                        return false;
                    }
                }
            };
        } else if (Build.VERSION.SDK_INT >= 19) {
            A00 = new C5V();
        } else {
            A00 = new C5U();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x001c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A00(android.view.ViewParent r1, android.view.View r2, int r3) {
        /*
            boolean r0 = r1 instanceof com.facebook.ads.redexgen.X.InterfaceC01184l
            if (r0 == 0) goto L1a
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L9;
                case 4: goto Lf;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            if (r3 != 0) goto Ld
            r0 = 4
            goto L5
        Ld:
            r0 = 2
            goto L5
        Lf:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            android.view.View r2 = (android.view.View) r2
            com.facebook.ads.redexgen.X.5U r0 = com.facebook.ads.redexgen.X.C5X.A00
            r0.A02(r1, r2)
            r0 = 2
            goto L5
        L1a:
            r0 = 3
            goto L5
        L1c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5X.A00(android.view.ViewParent, android.view.View, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x001c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A01(android.view.ViewParent r1, android.view.View r2, int r3, int r4, int r5, int r6, int r7) {
        /*
            boolean r0 = r1 instanceof com.facebook.ads.redexgen.X.InterfaceC01184l
            if (r0 == 0) goto L1a
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L9;
                case 4: goto Lf;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            if (r7 != 0) goto Ld
            r0 = 4
            goto L5
        Ld:
            r0 = 2
            goto L5
        Lf:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            android.view.View r2 = (android.view.View) r2
            com.facebook.ads.redexgen.X.5U r0 = com.facebook.ads.redexgen.X.C5X.A00
            r0.A03(r1, r2, r3, r4, r5, r6)
            r0 = 2
            goto L5
        L1a:
            r0 = 3
            goto L5
        L1c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5X.A01(android.view.ViewParent, android.view.View, int, int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x001e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A02(android.view.ViewParent r1, android.view.View r2, int r3, int r4, int[] r5, int r6) {
        /*
            boolean r0 = r1 instanceof com.facebook.ads.redexgen.X.InterfaceC01184l
            if (r0 == 0) goto L1c
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L1e;
                case 3: goto L9;
                case 4: goto Lf;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            if (r6 != 0) goto Ld
            r0 = 4
            goto L5
        Ld:
            r0 = 2
            goto L5
        Lf:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            android.view.View r2 = (android.view.View) r2
            int[] r5 = (int[]) r5
            com.facebook.ads.redexgen.X.5U r0 = com.facebook.ads.redexgen.X.C5X.A00
            r0.A04(r1, r2, r3, r4, r5)
            r0 = 2
            goto L5
        L1c:
            r0 = 3
            goto L5
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5X.A02(android.view.ViewParent, android.view.View, int, int, int[], int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x001e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A03(android.view.ViewParent r1, android.view.View r2, android.view.View r3, int r4, int r5) {
        /*
            boolean r0 = r1 instanceof com.facebook.ads.redexgen.X.InterfaceC01184l
            if (r0 == 0) goto L1c
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L1e;
                case 3: goto L9;
                case 4: goto Lf;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            if (r5 != 0) goto Ld
            r0 = 4
            goto L5
        Ld:
            r0 = 2
            goto L5
        Lf:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            android.view.View r2 = (android.view.View) r2
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.5U r0 = com.facebook.ads.redexgen.X.C5X.A00
            r0.A05(r1, r2, r3, r4)
            r0 = 2
            goto L5
        L1c:
            r0 = 3
            goto L5
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5X.A03(android.view.ViewParent, android.view.View, android.view.View, int, int):void");
    }

    public static boolean A04(ViewParent viewParent, View view, float f, float f2) {
        return A00.A06(viewParent, view, f, f2);
    }

    public static boolean A05(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return A00.A07(viewParent, view, f, f2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0032, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A06(android.view.ViewParent r2, android.view.View r3, android.view.View r4, int r5, int r6) {
        /*
            r1 = 0
            boolean r0 = r2 instanceof com.facebook.ads.redexgen.X.InterfaceC01184l
            if (r0 == 0) goto L30
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L32;
                case 4: goto L19;
                case 5: goto L1f;
                case 6: goto L2d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            android.view.ViewParent r2 = (android.view.ViewParent) r2
            android.view.View r3 = (android.view.View) r3
            android.view.View r4 = (android.view.View) r4
            r0 = r2
            com.facebook.ads.redexgen.X.4l r0 = (com.facebook.ads.redexgen.X.InterfaceC01184l) r0
            boolean r1 = r0.onStartNestedScroll(r3, r4, r5, r6)
            r0 = 3
            goto L6
        L19:
            if (r6 != 0) goto L1d
            r0 = 5
            goto L6
        L1d:
            r0 = 6
            goto L6
        L1f:
            android.view.ViewParent r2 = (android.view.ViewParent) r2
            android.view.View r3 = (android.view.View) r3
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.redexgen.X.5U r0 = com.facebook.ads.redexgen.X.C5X.A00
            boolean r1 = r0.A08(r2, r3, r4, r5)
            r0 = 3
            goto L6
        L2d:
            r1 = 0
            r0 = 3
            goto L6
        L30:
            r0 = 4
            goto L6
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5X.A06(android.view.ViewParent, android.view.View, android.view.View, int, int):boolean");
    }
}
