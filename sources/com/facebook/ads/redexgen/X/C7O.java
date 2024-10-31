package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.7O, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C7O {
    public static byte[] A09;
    public C7N A01;
    public C7X A04;
    public final /* synthetic */ C01807a A08;
    public final ArrayList<C7Z> A05 = new ArrayList<>();
    public ArrayList<C7Z> A02 = null;
    public final ArrayList<C7Z> A06 = new ArrayList<>();
    public final List<C7Z> A07 = Collections.unmodifiableList(this.A05);
    public int A03 = 2;
    public int A00 = 2;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C7O.A09
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
            int r0 = r0 + (-90)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A04(int, int, int):java.lang.String");
    }

    public static void A05() {
        A09 = new byte[]{-7, -6, -25, -6, -21, -64, -43, -13, -2, -2, -9, -10, -78, 5, -11, 4, -13, 2, -78, 8, -5, -9, 9, -78, 9, -5, 6, -6, -78, -13, 0, -78, -5, 0, 8, -13, -2, -5, -10, -78, 8, -5, -9, 9, -64, -78, -37, 0, 8, -13, -2, -5, -10, -78, 8, -5, -9, 9, 5, -78, -11, -13, 0, 0, 1, 6, -78, -12, -9, -78, 4, -9, 7, 5, -9, -10, -78, -8, 4, 1, -1, -78, 5, -11, 4, -13, 2, -66, -78, 6, -6, -9, 11, -78, 5, -6, 1, 7, -2, -10, -78, 4, -9, -12, 1, 7, 0, -10, -78, -8, 4, 1, -1, -78, 4, -9, -11, 11, -11, -2, -9, 4, -78, 2, 1, 1, -2, -64, -23, -18, 32, 69, 58, 70, 69, 74, 64, 74, 75, 60, 69, 58, 80, -9, 59, 60, 75, 60, 58, 75, 60, 59, 5, -9, 32, 69, 77, 56, 67, 64, 59, -9, 64, 75, 60, 68, -9, 71, 70, 74, 64, 75, 64, 70, 69, -9, -88, -17, -26, -26, -13, -27, -12, -70, 15, 4, 28, 18, 24, 23, -61, 12, 17, 7, 8, 27, -61, 22, 11, 18, 24, 15, 7, -61, 17, 18, 23, -61, 5, 8, -61, -48, -44, -61, 4, 9, 23, 8, 21, -61, 24, 17, 11, 12, 7, 12, 17, 10, -61, 4, -61, 25, 12, 8, 26, -35, -56, -65, -49, -34, -51, -36, -36, -47, -48, -116, -37, -34, -116, -51, -32, -32, -51, -49, -44, -47, -48, -116, -30, -43, -47, -29, -33, -116, -39, -51, -27, -116, -38, -37, -32, -116, -50, -47, -116, -34, -47, -49, -27, -49, -40, -47, -48, -102, -116, -43, -33, -65, -49, -34, -51, -36, -90, -29, 8, -3, 9, 8, 13, 3, 13, 14, -1, 8, -3, 19, -70, -2, -1, 14, -1, -3, 14, -1, -2, -56, -70, -29, 8, 16, -5, 6, 3, -2, -70, 16, 3, -1, 17, -70, 2, 9, 6, -2, -1, 12, -70, -5, -2, -5, 10, 14, -1, 12, -70, 10, 9, 13, 3, 14, 3, 9, 8, -19, 6, 9, -71, -3, -2, 13, -6, -4, 1, -2, -3, -71, 15, 2, -2, 16, -71, 12, 1, 8, 14, 5, -3, -71, -5, -2, -71, 11, -2, 6, 8, 15, -2, -3, -71, -1, 11, 8, 6, -71, -21, -2, -4, 18, -4, 5, -2, 11, -17, 2, -2, 16, -71, -5, -2, -1, 8, 11, -2, -71, 2, 13, -71, -4, -6, 7, -71, -5, -2, -71, 11, -2, -4, 18, -4, 5, -2, -3, -45, -71, -32, -27, -41, 0, 43, 28, 36, -41, 26, 38, 44, 37, 43, -15, -53, -55, -40, -70, -51, -55, -37, -86, -45, -42, -76, -45, -41, -51, -40, -51, -45, -46, -91, -46, -56, -72, -35, -44, -55, -124, -42, -55, -40, -39, -42, -46, -55, -56, -124, -59, -124, -38, -51, -55, -37, -124, -40, -52, -59, -40, -124, -51, -41, -124, -51, -53, -46, -45, -42, -55, -56, -110, -124, -67, -45, -39, -124, -47, -39, -41, -40, -124, -57, -59, -48, -48, -124, -41, -40, -45, -44, -83, -53, -46, -45, -42, -51, -46, -53, -124, -58, -55, -54, -45, -42, -55, -124, -42, -55, -40, -39, -42, -46, -51, -46, -53, -124, -40, -52, -51, -41, -124, -38, -51, -55, -37, -110, -36, -38, -23, -53, -34, -38, -20, -69, -28, -25, -59, -28, -24, -34, -23, -34, -28, -29, -74, -29, -39, -55, -18, -27, -38, -107, -25, -38, -23, -22, -25, -29, -38, -39, -107, -42, -107, -21, -34, -38, -20, -107, -20, -35, -34, -40, -35, -107, -39, -28, -38, -24, -107, -29, -28, -23, -107, -35, -42, -21, -38, -107, -42, -107, -53, -34, -38, -20, -67, -28, -31, -39, -38, -25, -60, -30, -23, -39, -34, -41, -112, -28, -33, -112, -30, -43, -45, -23, -45, -36, -43, -112, -47, -34, -112, -39, -41, -34, -33, -30, -43, -44, -112, -26, -39, -43, -25, -112, -40, -33, -36, -44, -43, -30, -98, -112, -55, -33, -27, -112, -29, -40, -33, -27, -36, -44, -112, -42, -39, -30, -29, -28, -112, -45, -47, -36, -36, -112, -29, -28, -33, -32, -71, -41, -34, -33, -30, -39, -34, -41, -58, -39, -43, -25, -104, -26, -39, -43, -25, -103, -112, -46, -43, -42, -33, -30, -43, -112, -45, -47, -36, -36, -39, -34, -41, -112, -30, -43, -45, -23, -45, -36, -43, -98, -44, -7, 1, -20, -9, -12, -17, -85, -12, -1, -16, -8, -85, -5, -6, -2, -12, -1, -12, -6, -7, -85, -87, -14, -4, -54, -3, -3, -22, -20, -15, -18, -19, -61};
    }

    public C7O(C01807a c01807a) {
        this.A08 = c01807a;
    }

    private final View A00(int i, boolean z) {
        return A0I(i, z, Long.MAX_VALUE).A0H;
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x00f3, code lost:            return r9;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C7Z A01(int r13) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A01(int):com.facebook.ads.redexgen.X.7Z");
    }

    private final C7Z A02(int i, boolean z) {
        C7O c7o = this;
        int layoutIndex = 0;
        int scrapCount = 0;
        C7Z vh = null;
        int i2 = 0;
        C7Z c7z = null;
        View view = null;
        int size = c7o.A05.size();
        int i3 = 0;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    if (i3 >= size) {
                        c = 11;
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    c7o = c7o;
                    c7z = c7o.A05.get(i3);
                    if (!c7z.A0i()) {
                        c = 4;
                        break;
                    } else {
                        c = '\n';
                        break;
                    }
                case 4:
                    c7z = c7z;
                    if (c7z.A0I() != i) {
                        c = '\n';
                        break;
                    } else {
                        c = 5;
                        break;
                    }
                case 5:
                    c7z = c7z;
                    if (!c7z.A0b()) {
                        c = 6;
                        break;
                    } else {
                        c = '\n';
                        break;
                    }
                case 6:
                    c7o = c7o;
                    if (!c7o.A08.A0s.A09) {
                        c = 7;
                        break;
                    } else {
                        c = '\b';
                        break;
                    }
                case 7:
                    c7z = c7z;
                    if (!c7z.A0c()) {
                        c = '\b';
                        break;
                    } else {
                        c = '\n';
                        break;
                    }
                case '\b':
                    c7z = c7z;
                    c7z.A0T(32);
                    c = '\t';
                    break;
                case '\t':
                    return c7z;
                case '\n':
                    i3++;
                    c = 2;
                    break;
                case 11:
                    if (!z) {
                        c = '\f';
                        break;
                    } else {
                        c = 16;
                        break;
                    }
                case '\f':
                    c7o = c7o;
                    view = c7o.A08.A01.A08(i);
                    if (view == null) {
                        c = 16;
                        break;
                    } else {
                        c = '\r';
                        break;
                    }
                case '\r':
                    c7o = c7o;
                    view = view;
                    vh = C01807a.A05(view);
                    c7o.A08.A01.A0G(view);
                    i2 = c7o.A08.A01.A07(view);
                    if (i2 != -1) {
                        c = 15;
                        break;
                    } else {
                        c = 14;
                        break;
                    }
                case 14:
                    throw new IllegalStateException(A04(184, 52, 73) + vh + c7o.A08.A17());
                case 15:
                    c7o = c7o;
                    view = view;
                    vh = vh;
                    c7o.A08.A01.A0C(i2);
                    c7o.A0W(view);
                    vh.A0T(8224);
                    c7z = vh;
                    c = '\t';
                    break;
                case 16:
                    c7o = c7o;
                    scrapCount = c7o.A06.size();
                    layoutIndex = 0;
                    c = 17;
                    break;
                case 17:
                    if (layoutIndex >= scrapCount) {
                        c = 23;
                        break;
                    } else {
                        c = 18;
                        break;
                    }
                case 18:
                    c7o = c7o;
                    c7z = c7o.A06.get(layoutIndex);
                    if (!c7z.A0b()) {
                        c = 19;
                        break;
                    } else {
                        c = 22;
                        break;
                    }
                case 19:
                    c7z = c7z;
                    if (c7z.A0I() != i) {
                        c = 22;
                        break;
                    } else {
                        c = 20;
                        break;
                    }
                case 20:
                    if (!z) {
                        c = 21;
                        break;
                    } else {
                        c = '\t';
                        break;
                    }
                case 21:
                    c7o = c7o;
                    c7o.A06.remove(layoutIndex);
                    c = '\t';
                    break;
                case 22:
                    layoutIndex++;
                    c = 17;
                    break;
                case 23:
                    c7z = null;
                    c = '\t';
                    break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x011a, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C7Z A03(long r8, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A03(long, int, boolean):com.facebook.ads.redexgen.X.7Z");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A06() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r2.A06
            int r0 = r0.size()
            int r1 = r0 + (-1)
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L1e;
                case 5: goto L2f;
                case 6: goto L3a;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r1 < 0) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 4
            goto Lb
        L15:
            com.facebook.ads.redexgen.X.7O r2 = (com.facebook.ads.redexgen.X.C7O) r2
            r2.A07(r1)
            int r1 = r1 + (-1)
            r0 = 2
            goto Lb
        L1e:
            com.facebook.ads.redexgen.X.7O r2 = (com.facebook.ads.redexgen.X.C7O) r2
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r2.A06
            r0.clear()
            boolean r0 = com.facebook.ads.redexgen.X.C01807a.A0q()
            if (r0 == 0) goto L2d
            r0 = 5
            goto Lb
        L2d:
            r0 = 6
            goto Lb
        L2f:
            com.facebook.ads.redexgen.X.7O r2 = (com.facebook.ads.redexgen.X.C7O) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            com.facebook.ads.redexgen.X.6Z r0 = r0.A02
            r0.A02()
            r0 = 6
            goto Lb
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A06():void");
    }

    private final void A07(int i) {
        A0d(this.A06.get(i), true);
        this.A06.remove(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0063, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(android.view.ViewGroup r7, boolean r8) {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r4 = 0
            r0 = 0
            r3 = 4
            int r0 = r7.getChildCount()
            int r2 = r0 + (-1)
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L2e;
                case 4: goto L21;
                case 5: goto L1d;
                case 6: goto L10;
                case 7: goto L63;
                case 8: goto L3c;
                case 9: goto L58;
                case 10: goto L4a;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            if (r8 != 0) goto L14
            r0 = 7
            goto Lc
        L14:
            r0 = 8
            goto Lc
        L17:
            if (r2 < 0) goto L1b
            r0 = 3
            goto Lc
        L1b:
            r0 = 6
            goto Lc
        L1d:
            int r2 = r2 + (-1)
            r0 = 2
            goto Lc
        L21:
            com.facebook.ads.redexgen.X.7O r5 = (com.facebook.ads.redexgen.X.C7O) r5
            android.view.View r4 = (android.view.View) r4
            r1 = r4
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r0 = 1
            r5.A08(r1, r0)
            r0 = 5
            goto Lc
        L2e:
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            android.view.View r4 = r7.getChildAt(r2)
            boolean r0 = r4 instanceof android.view.ViewGroup
            if (r0 == 0) goto L3a
            r0 = 4
            goto Lc
        L3a:
            r0 = 5
            goto Lc
        L3c:
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            int r0 = r7.getVisibility()
            if (r0 != r3) goto L47
            r0 = 9
            goto Lc
        L47:
            r0 = 10
            goto Lc
        L4a:
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            int r0 = r7.getVisibility()
            r7.setVisibility(r3)
            r7.setVisibility(r0)
            r0 = 7
            goto Lc
        L58:
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r0 = 0
            r7.setVisibility(r0)
            r7.setVisibility(r3)
            r0 = 7
            goto Lc
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A08(android.view.ViewGroup, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A09(com.facebook.ads.redexgen.X.C7Z r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            boolean r0 = r0.A1h()
            if (r0 == 0) goto L49
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1d;
                case 4: goto L25;
                case 5: goto L31;
                case 6: goto L4b;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            android.view.View r1 = r4.A0H
            int r0 = com.facebook.ads.redexgen.X.C5B.A00(r1)
            if (r0 != 0) goto L1b
            r0 = 3
            goto Lb
        L1b:
            r0 = 4
            goto Lb
        L1d:
            android.view.View r1 = (android.view.View) r1
            r0 = 1
            com.facebook.ads.redexgen.X.C5B.A09(r1, r0)
            r0 = 4
            goto Lb
        L25:
            android.view.View r1 = (android.view.View) r1
            boolean r0 = com.facebook.ads.redexgen.X.C5B.A0E(r1)
            if (r0 != 0) goto L2f
            r0 = 5
            goto Lb
        L2f:
            r0 = 6
            goto Lb
        L31:
            com.facebook.ads.redexgen.X.7O r2 = (com.facebook.ads.redexgen.X.C7O) r2
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            android.view.View r1 = (android.view.View) r1
            r0 = 16384(0x4000, float:2.2959E-41)
            r4.A0T(r0)
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            com.facebook.ads.redexgen.X.7c r0 = r0.A09
            com.facebook.ads.redexgen.X.4e r0 = r0.A0A()
            com.facebook.ads.redexgen.X.C5B.A0A(r1, r0)
            r0 = 6
            goto Lb
        L49:
            r0 = 6
            goto Lb
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A09(com.facebook.ads.redexgen.X.7Z):void");
    }

    private void A0A(C7Z c7z) {
        if (c7z.A0H instanceof ViewGroup) {
            A08((ViewGroup) c7z.A0H, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0033, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0B(com.facebook.ads.redexgen.X.C7Z r3) {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.7a r0 = r1.A08
            com.facebook.ads.redexgen.X.7P r0 = r0.A07
            if (r0 == 0) goto L31
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L18;
                case 4: goto L24;
                case 5: goto L33;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7O r1 = (com.facebook.ads.redexgen.X.C7O) r1
            com.facebook.ads.redexgen.X.7a r0 = r1.A08
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            if (r0 == 0) goto L16
            r0 = 3
            goto L8
        L16:
            r0 = 3
            goto L8
        L18:
            com.facebook.ads.redexgen.X.7O r1 = (com.facebook.ads.redexgen.X.C7O) r1
            com.facebook.ads.redexgen.X.7a r0 = r1.A08
            com.facebook.ads.redexgen.X.7W r0 = r0.A0s
            if (r0 == 0) goto L22
            r0 = 4
            goto L8
        L22:
            r0 = 5
            goto L8
        L24:
            com.facebook.ads.redexgen.X.7O r1 = (com.facebook.ads.redexgen.X.C7O) r1
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            com.facebook.ads.redexgen.X.7a r0 = r1.A08
            com.facebook.ads.redexgen.X.7k r0 = r0.A0t
            r0.A0B(r3)
            r0 = 5
            goto L8
        L31:
            r0 = 2
            goto L8
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0B(com.facebook.ads.redexgen.X.7Z):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000c. Please report as an issue. */
    private final boolean A0C(C7Z c7z) {
        C7O c7o = this;
        boolean z = true;
        char c = c7z.A0c() ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    c7o = c7o;
                    z = c7o.A08.A0s.A07();
                    c = 3;
                case 3:
                    return z;
                case 4:
                    c7z = c7z;
                    c = c7z.A03 >= 0 ? (char) 5 : (char) 6;
                case 5:
                    c7o = c7o;
                    c7z = c7z;
                    c = c7z.A03 >= c7o.A08.A04.A0C() ? (char) 6 : (char) 7;
                case 6:
                    throw new IndexOutOfBoundsException(A04(293, 60, 64) + c7z + c7o.A08.A17());
                case 7:
                    c7o = c7o;
                    c = !c7o.A08.A0s.A07() ? '\b' : '\n';
                case '\b':
                    c7o = c7o;
                    c7z = c7z;
                    c = c7o.A08.A04.A03(c7z.A03) != c7z.A0H() ? '\t' : '\n';
                case '\t':
                    z = false;
                    c = 3;
                case '\n':
                    c7o = c7o;
                    c = c7o.A08.A04.A0A() ? (char) 11 : (char) 3;
                case 11:
                    c7o = c7o;
                    c7z = c7z;
                    c = c7z.A0K() != c7o.A08.A04.A04(c7z.A03) ? '\f' : (char) 3;
                case '\f':
                    z = false;
                    c = 3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0D(com.facebook.ads.redexgen.X.C7Z r13, int r14, int r15, long r16) {
        /*
            r12 = this;
            r2 = r12
            r0 = 0
            r0 = 0
            r5 = 0
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            r13.A08 = r0
            int r7 = r13.A0H()
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            long r8 = r0.getNanoTime()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10 = r16
            int r0 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r0 == 0) goto L69
            r0 = 2
        L1f:
            switch(r0) {
                case 2: goto L5b;
                case 3: goto L58;
                case 4: goto L6b;
                case 5: goto L29;
                case 6: goto L23;
                case 7: goto L55;
                default: goto L22;
            }
        L22:
            goto L1f
        L23:
            com.facebook.ads.redexgen.X.7Z r13 = (com.facebook.ads.redexgen.X.C7Z) r13
            r13.A04 = r15
            r0 = 7
            goto L1f
        L29:
            com.facebook.ads.redexgen.X.7O r2 = (com.facebook.ads.redexgen.X.C7O) r2
            com.facebook.ads.redexgen.X.7Z r13 = (com.facebook.ads.redexgen.X.C7Z) r13
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            r0.A09(r13, r14)
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            long r0 = r0.getNanoTime()
            com.facebook.ads.redexgen.X.7N r4 = r2.A01
            int r3 = r13.A0H()
            long r0 = r0 - r8
            r4.A05(r3, r0)
            r2.A09(r13)
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            com.facebook.ads.redexgen.X.7W r0 = r0.A0s
            boolean r0 = r0.A07()
            if (r0 == 0) goto L53
            r0 = 6
            goto L1f
        L53:
            r0 = 7
            goto L1f
        L55:
            r5 = 1
            r0 = 4
            goto L1f
        L58:
            r5 = 0
            r0 = 4
            goto L1f
        L5b:
            com.facebook.ads.redexgen.X.7O r2 = (com.facebook.ads.redexgen.X.C7O) r2
            com.facebook.ads.redexgen.X.7N r6 = r2.A01
            boolean r0 = r6.A0A(r7, r8, r10)
            if (r0 != 0) goto L67
            r0 = 3
            goto L1f
        L67:
            r0 = 5
            goto L1f
        L69:
            r0 = 5
            goto L1f
        L6b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0D(com.facebook.ads.redexgen.X.7Z, int, int, long):boolean");
    }

    public final int A0E() {
        return this.A05.size();
    }

    public final View A0F(int i) {
        return this.A05.get(i).A0H;
    }

    public final View A0G(int i) {
        return A00(i, false);
    }

    public final C7N A0H() {
        if (this.A01 == null) {
            this.A01 = new C7N();
        }
        return this.A01;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001b. Please report as an issue. */
    @Nullable
    public final C7Z A0I(int i, boolean z, long j) {
        boolean z2;
        C7O c7o = this;
        ViewGroup.LayoutParams layoutParams = null;
        int i2 = 0;
        int offsetPosition = 0;
        C7Z c7z = null;
        boolean z3 = false;
        View view = null;
        C01596e c01596e = null;
        C01807a c01807a = null;
        long j2 = 0;
        boolean z4 = false;
        C7Z c7z2 = null;
        boolean z5 = false;
        C7Z c7z3 = null;
        char c = i >= 0 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    c7o = c7o;
                    c = i >= c7o.A08.A0s.A03() ? (char) 3 : (char) 4;
                case 3:
                    C7O c7o2 = c7o;
                    throw new IndexOutOfBoundsException(A04(745, 22, 49) + i + A04(236, 1, 70) + i + A04(434, 14, 93) + c7o2.A08.A0s.A03() + c7o2.A08.A17());
                case 4:
                    c7o = c7o;
                    z4 = false;
                    c7z = null;
                    c = c7o.A08.A0s.A07() ? (char) 5 : (char) 7;
                case 5:
                    c7o = c7o;
                    c7z = c7o.A01(i);
                    c = c7z != null ? (char) 6 : (char) 22;
                case 6:
                    z4 = true;
                    c = 7;
                case 7:
                    c = c7z == null ? '\b' : (char) 15;
                case '\b':
                    c7o = c7o;
                    c7z = c7o.A02(i, z);
                    c = c7z != null ? '\t' : (char) 15;
                case '\t':
                    c7o = c7o;
                    c7z = c7z;
                    c = !c7o.A0C(c7z) ? '\n' : (char) 21;
                case '\n':
                    c = !z ? (char) 11 : (char) 14;
                case 11:
                    c7z = c7z;
                    c7z.A0T(4);
                    c = c7z.A0d() ? '\f' : (char) 19;
                case '\f':
                    c7o = c7o;
                    c7z = c7z;
                    c7o.A08.removeDetachedView(c7z.A0H, false);
                    c7z.A0S();
                    c = '\r';
                case '\r':
                    c7o = c7o;
                    c7z = c7z;
                    c7o.A0b(c7z);
                    c = 14;
                case 14:
                    c7z = null;
                    c = 15;
                case 15:
                    c = c7z == null ? (char) 16 : '%';
                case 16:
                    c7o = c7o;
                    offsetPosition = c7o.A08.A00.A0D(i);
                    c = offsetPosition >= 0 ? (char) 17 : (char) 18;
                case 17:
                    c7o = c7o;
                    c = offsetPosition >= c7o.A08.A04.A0C() ? (char) 18 : (char) 23;
                case 18:
                    C7O c7o3 = c7o;
                    throw new IndexOutOfBoundsException(A04(130, 46, 125) + i + A04(176, 8, 38) + offsetPosition + A04(128, 2, 102) + A04(0, 6, 44) + c7o3.A08.A0s.A03() + c7o3.A08.A17());
                case 19:
                    c7z = c7z;
                    c = c7z.A0i() ? (char) 20 : '\r';
                case 20:
                    c7z = c7z;
                    c7z.A0O();
                    c = '\r';
                case 21:
                    z4 = true;
                    c = 15;
                case 22:
                    z4 = false;
                    c = 7;
                case 23:
                    c7o = c7o;
                    i2 = c7o.A08.A04.A03(offsetPosition);
                    c = c7o.A08.A04.A0A() ? (char) 24 : (char) 26;
                case 24:
                    c7o = c7o;
                    c7z = c7o.A03(c7o.A08.A04.A04(offsetPosition), i2, z);
                    c = c7z != null ? (char) 25 : (char) 26;
                case 25:
                    c7z = c7z;
                    c7z.A03 = offsetPosition;
                    z4 = true;
                    c = 26;
                case 26:
                    c = c7z == null ? (char) 27 : '3';
                case 27:
                    c7o = c7o;
                    c = c7o.A04 != null ? (char) 28 : '3';
                case 28:
                    c7o = c7o;
                    view = c7o.A04.A00(c7o, i, i2);
                    c = view != null ? (char) 29 : '3';
                case 29:
                    c7o = c7o;
                    view = view;
                    c7z = c7o.A08.A16(view);
                    c = c7z == null ? (char) 30 : (char) 31;
                case 30:
                    throw new IllegalArgumentException(A04(561, 74, 27) + c7o.A08.A17());
                case 31:
                    c7z = c7z;
                    c = c7z.A0h() ? ' ' : '3';
                case ' ':
                    throw new IllegalArgumentException(A04(448, 113, 10) + c7o.A08.A17());
                case '!':
                    c7o = c7o;
                    c7z = c7o.A08.A04.A05(c7o.A08, i2);
                    z2 = C01807a.A1D;
                    c = z2 ? '\"' : '$';
                case '\"':
                    c7z = c7z;
                    c01807a = C01807a.A07(c7z.A0H);
                    c = c01807a != null ? '#' : '$';
                case '#':
                    c7z = c7z;
                    c01807a = c01807a;
                    c7z.A09 = new WeakReference<>(c01807a);
                    c = '$';
                case '$':
                    c7o = c7o;
                    c7o.A01.A06(i2, c7o.A08.getNanoTime() - j2);
                    c = '%';
                case '%':
                    c = z4 ? '&' : '*';
                case '&':
                    c7o = c7o;
                    c = !c7o.A08.A0s.A07() ? '\'' : '*';
                case '\'':
                    c = c7z.A0k(8192) ? '(' : '*';
                case '(':
                    c7o = c7o;
                    c7z.A0U(0, 8192);
                    c = c7o.A08.A0s.A0C ? ')' : '*';
                case ')':
                    c7o = c7o;
                    c7o.A08.A1b(c7z, c7o.A08.A05.A07(c7o.A08.A0s, c7z, C6U.A00(c7z) | 4096, c7z.A0L()));
                    c = '*';
                case '*':
                    c7o = c7o;
                    z3 = false;
                    c = c7o.A08.A0s.A07() ? '+' : 'A';
                case '+':
                    c = c7z.A0a() ? ',' : 'A';
                case ',':
                    c7z.A04 = i;
                    c = '-';
                case '-':
                    layoutParams = c7z.A0H.getLayoutParams();
                    c = layoutParams == null ? '.' : '>';
                case '.':
                    c7o = c7o;
                    c01596e = (C01596e) c7o.A08.generateDefaultLayoutParams();
                    c7z.A0H.setLayoutParams(c01596e);
                    c = '/';
                case '/':
                    c01596e = c01596e;
                    c01596e.A00 = c7z;
                    c = z4 ? '0' : '=';
                case '0':
                    c = z3 ? '1' : '=';
                case '1':
                    z5 = true;
                    c = '2';
                case '2':
                    c01596e = c01596e;
                    c01596e.A02 = z5;
                    c7z3 = c7z;
                    c = ';';
                case '3':
                    c = c7z == null ? '4' : '7';
                case '4':
                    c7o = c7o;
                    c7z = c7o.A0H().A03(i2);
                    c = c7z != null ? '5' : '7';
                case '5':
                    c7z = c7z;
                    c7z.A0Q();
                    c = C01807a.A1B ? '6' : '7';
                case '6':
                    c7o = c7o;
                    c7z = c7z;
                    c7o.A0A(c7z);
                    c = '7';
                case '7':
                    c7z2 = c7z;
                    c = c7z2 == null ? '8' : '<';
                case '8':
                    c7o = c7o;
                    j2 = c7o.A08.getNanoTime();
                    c = j != Long.MAX_VALUE ? '9' : '!';
                case '9':
                    c7o = c7o;
                    c = !c7o.A01.A0B(i2, j2, j) ? ':' : '!';
                case ':':
                    c7z3 = null;
                    c = ';';
                case ';':
                    return c7z3;
                case '<':
                    c7z = c7z2;
                    c = '%';
                case '=':
                    z5 = false;
                    c = '2';
                case '>':
                    c7o = c7o;
                    layoutParams = layoutParams;
                    c = !c7o.A08.checkLayoutParams(layoutParams) ? '?' : '@';
                case '?':
                    c7o = c7o;
                    layoutParams = layoutParams;
                    c01596e = (C01596e) c7o.A08.generateLayoutParams(layoutParams);
                    c7z.A0H.setLayoutParams(c01596e);
                    c = '/';
                case '@':
                    layoutParams = layoutParams;
                    c01596e = (C01596e) layoutParams;
                    c = '/';
                case 'A':
                    c = c7z.A0a() ? 'B' : 'D';
                case 'B':
                    c = !c7z.A0g() ? 'C' : 'D';
                case 'C':
                    c = c7z.A0b() ? 'D' : '-';
                case 'D':
                    c7o = c7o;
                    z3 = c7o.A0D(c7z, c7o.A08.A00.A0D(i), i, j);
                    c = '-';
            }
        }
    }

    public final List<C7Z> A0J() {
        return this.A07;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x007e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0K() {
        /*
            r8 = this;
            r6 = r8
            r7 = 0
            r0 = 0
            r0 = 0
            r5 = 0
            r4 = 0
            r3 = 0
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r6.A06
            int r2 = r0.size()
            r1 = 0
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L58;
                case 3: goto L47;
                case 4: goto L2a;
                case 5: goto L24;
                case 6: goto L13;
                case 7: goto L5e;
                case 8: goto L6a;
                case 9: goto L76;
                case 10: goto L35;
                case 11: goto L7e;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.7O r6 = (com.facebook.ads.redexgen.X.C7O) r6
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r6.A05
            java.lang.Object r0 = r0.get(r5)
            com.facebook.ads.redexgen.X.7Z r0 = (com.facebook.ads.redexgen.X.C7Z) r0
            r0.A0M()
            int r5 = r5 + 1
            r0 = 5
            goto Lf
        L24:
            if (r5 >= r4) goto L28
            r0 = 6
            goto Lf
        L28:
            r0 = 7
            goto Lf
        L2a:
            com.facebook.ads.redexgen.X.7O r6 = (com.facebook.ads.redexgen.X.C7O) r6
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r6.A05
            int r4 = r0.size()
            r5 = 0
            r0 = 5
            goto Lf
        L35:
            com.facebook.ads.redexgen.X.7O r6 = (com.facebook.ads.redexgen.X.C7O) r6
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r6.A02
            java.lang.Object r0 = r0.get(r7)
            com.facebook.ads.redexgen.X.7Z r0 = (com.facebook.ads.redexgen.X.C7Z) r0
            r0.A0M()
            int r7 = r7 + 1
            r0 = 9
            goto Lf
        L47:
            com.facebook.ads.redexgen.X.7O r6 = (com.facebook.ads.redexgen.X.C7O) r6
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r6.A06
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.7Z r0 = (com.facebook.ads.redexgen.X.C7Z) r0
            r0.A0M()
            int r1 = r1 + 1
            r0 = 2
            goto Lf
        L58:
            if (r1 >= r2) goto L5c
            r0 = 3
            goto Lf
        L5c:
            r0 = 4
            goto Lf
        L5e:
            com.facebook.ads.redexgen.X.7O r6 = (com.facebook.ads.redexgen.X.C7O) r6
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r6.A02
            if (r0 == 0) goto L67
            r0 = 8
            goto Lf
        L67:
            r0 = 11
            goto Lf
        L6a:
            com.facebook.ads.redexgen.X.7O r6 = (com.facebook.ads.redexgen.X.C7O) r6
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r6.A02
            int r3 = r0.size()
            r7 = 0
            r0 = 9
            goto Lf
        L76:
            if (r7 >= r3) goto L7b
            r0 = 10
            goto Lf
        L7b:
            r0 = 11
            goto Lf
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0K():void");
    }

    public final void A0L() {
        this.A05.clear();
        if (this.A02 != null) {
            this.A02.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0039, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0M() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r0 = 0
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r4.A06
            int r2 = r0.size()
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L16;
                case 4: goto L2e;
                case 5: goto L35;
                case 6: goto L39;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            if (r1 >= r2) goto L14
            r0 = 3
            goto Lc
        L14:
            r0 = 6
            goto Lc
        L16:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r4.A06
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.7Z r0 = (com.facebook.ads.redexgen.X.C7Z) r0
            android.view.View r0 = r0.A0H
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            com.facebook.ads.redexgen.X.6e r3 = (com.facebook.ads.redexgen.X.C01596e) r3
            if (r3 == 0) goto L2c
            r0 = 4
            goto Lc
        L2c:
            r0 = 5
            goto Lc
        L2e:
            com.facebook.ads.redexgen.X.6e r3 = (com.facebook.ads.redexgen.X.C01596e) r3
            r0 = 1
            r3.A01 = r0
            r0 = 5
            goto Lc
        L35:
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0M():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x005d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0N() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.7a r0 = r4.A08
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            if (r0 == 0) goto L5a
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L3d;
                case 3: goto L32;
                case 4: goto Lf;
                case 5: goto L22;
                case 6: goto L16;
                case 7: goto L4e;
                case 8: goto L52;
                case 9: goto L5d;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r2 >= r1) goto L13
            r0 = 5
            goto Lb
        L13:
            r0 = 9
            goto Lb
        L16:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            r0 = 6
            r3.A0T(r0)
            r0 = 0
            r3.A0Y(r0)
            r0 = 7
            goto Lb
        L22:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r4.A06
            java.lang.Object r3 = r0.get(r2)
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            if (r3 == 0) goto L30
            r0 = 6
            goto Lb
        L30:
            r0 = 7
            goto Lb
        L32:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r4.A06
            int r1 = r0.size()
            r2 = 0
            r0 = 4
            goto Lb
        L3d:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7a r0 = r4.A08
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            boolean r0 = r0.A0A()
            if (r0 == 0) goto L4b
            r0 = 3
            goto Lb
        L4b:
            r0 = 8
            goto Lb
        L4e:
            int r2 = r2 + 1
            r0 = 4
            goto Lb
        L52:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            r4.A06()
            r0 = 9
            goto Lb
        L5a:
            r0 = 8
            goto Lb
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0N():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x004f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0O() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.7a r0 = r4.A08
            com.facebook.ads.redexgen.X.6g r0 = r0.A06
            if (r0 == 0) goto L4d
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L43;
                case 3: goto L2f;
                case 4: goto L28;
                case 5: goto L17;
                case 6: goto Le;
                case 7: goto L40;
                case 8: goto L4f;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            r4.A07(r3)
            int r3 = r3 + (-1)
            r0 = 4
            goto La
        L17:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r4.A06
            int r1 = r0.size()
            int r0 = r4.A00
            if (r1 <= r0) goto L25
            r0 = 6
            goto La
        L25:
            r0 = 8
            goto La
        L28:
            if (r3 < 0) goto L2c
            r0 = 5
            goto La
        L2c:
            r0 = 8
            goto La
        L2f:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            int r0 = r4.A03
            int r0 = r0 + r2
            r4.A00 = r0
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r4.A06
            int r0 = r0.size()
            int r3 = r0 + (-1)
            r0 = 4
            goto La
        L40:
            r2 = 0
            r0 = 3
            goto La
        L43:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7a r0 = r4.A08
            com.facebook.ads.redexgen.X.6g r0 = r0.A06
            int r2 = r0.A00
            r0 = 3
            goto La
        L4d:
            r0 = 7
            goto La
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0O():void");
    }

    public final void A0P() {
        this.A05.clear();
        A06();
    }

    public final void A0Q(int i) {
        this.A03 = i;
        A0O();
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x003c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0R(int r6, int r7) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r0 = 0
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r4.A06
            int r2 = r0.size()
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L2c;
                case 4: goto L22;
                case 5: goto L14;
                case 6: goto L10;
                case 7: goto L3c;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L14:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            r0 = 1
            r3.A0W(r7, r0)
            r0 = 6
            goto Lc
        L1c:
            if (r1 >= r2) goto L20
            r0 = 3
            goto Lc
        L20:
            r0 = 7
            goto Lc
        L22:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = r3.A03
            if (r0 < r6) goto L2a
            r0 = 5
            goto Lc
        L2a:
            r0 = 6
            goto Lc
        L2c:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r4.A06
            java.lang.Object r3 = r0.get(r1)
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            if (r3 == 0) goto L3a
            r0 = 4
            goto Lc
        L3a:
            r0 = 6
            goto Lc
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0R(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0079, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0S(int r10, int r11) {
        /*
            r9 = this;
            r7 = r9
            r6 = 0
            r0 = 0
            r5 = 0
            r8 = 0
            r4 = 0
            r3 = 0
            r2 = 0
            r1 = 0
            if (r10 >= r11) goto L76
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L33;
                case 3: goto L38;
                case 4: goto L2c;
                case 5: goto L1b;
                case 6: goto L10;
                case 7: goto L43;
                case 8: goto L4f;
                case 9: goto L53;
                case 10: goto L5f;
                case 11: goto L69;
                case 12: goto L71;
                case 13: goto L79;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.7Z r8 = (com.facebook.ads.redexgen.X.C7Z) r8
            int r0 = r8.A03
            if (r0 < r2) goto L18
            r0 = 7
            goto Lc
        L18:
            r0 = 8
            goto Lc
        L1b:
            com.facebook.ads.redexgen.X.7O r7 = (com.facebook.ads.redexgen.X.C7O) r7
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r7.A06
            java.lang.Object r8 = r0.get(r4)
            com.facebook.ads.redexgen.X.7Z r8 = (com.facebook.ads.redexgen.X.C7Z) r8
            if (r8 == 0) goto L29
            r0 = 6
            goto Lc
        L29:
            r0 = 8
            goto Lc
        L2c:
            if (r4 >= r3) goto L30
            r0 = 5
            goto Lc
        L30:
            r0 = 13
            goto Lc
        L33:
            r2 = r10
            r5 = r11
            r6 = -1
            r0 = 3
            goto Lc
        L38:
            com.facebook.ads.redexgen.X.7O r7 = (com.facebook.ads.redexgen.X.C7O) r7
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r7.A06
            int r3 = r0.size()
            r4 = 0
            r0 = 4
            goto Lc
        L43:
            com.facebook.ads.redexgen.X.7Z r8 = (com.facebook.ads.redexgen.X.C7Z) r8
            int r0 = r8.A03
            if (r0 <= r5) goto L4c
            r0 = 8
            goto Lc
        L4c:
            r0 = 9
            goto Lc
        L4f:
            int r4 = r4 + 1
            r0 = 4
            goto Lc
        L53:
            com.facebook.ads.redexgen.X.7Z r8 = (com.facebook.ads.redexgen.X.C7Z) r8
            int r0 = r8.A03
            if (r0 != r10) goto L5c
            r0 = 10
            goto Lc
        L5c:
            r0 = 11
            goto Lc
        L5f:
            com.facebook.ads.redexgen.X.7Z r8 = (com.facebook.ads.redexgen.X.C7Z) r8
            int r0 = r11 - r10
            r8.A0W(r0, r1)
            r0 = 8
            goto Lc
        L69:
            com.facebook.ads.redexgen.X.7Z r8 = (com.facebook.ads.redexgen.X.C7Z) r8
            r8.A0W(r6, r1)
            r0 = 8
            goto Lc
        L71:
            r2 = r11
            r5 = r10
            r6 = 1
            r0 = 3
            goto Lc
        L76:
            r0 = 12
            goto Lc
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0S(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x004c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0T(int r7, int r8) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r0 = 0
            r3 = 0
            r0 = 0
            int r2 = r7 + r8
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r5.A06
            int r0 = r0.size()
            int r1 = r0 + (-1)
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L38;
                case 3: goto L28;
                case 4: goto L24;
                case 5: goto L1a;
                case 6: goto L14;
                case 7: goto L3f;
                case 8: goto L4c;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            if (r4 >= r2) goto L18
            r0 = 7
            goto L10
        L18:
            r0 = 4
            goto L10
        L1a:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r4 = r3.A03
            if (r4 < r7) goto L22
            r0 = 6
            goto L10
        L22:
            r0 = 4
            goto L10
        L24:
            int r1 = r1 + (-1)
            r0 = 2
            goto L10
        L28:
            com.facebook.ads.redexgen.X.7O r5 = (com.facebook.ads.redexgen.X.C7O) r5
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r5.A06
            java.lang.Object r3 = r0.get(r1)
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            if (r3 != 0) goto L36
            r0 = 4
            goto L10
        L36:
            r0 = 5
            goto L10
        L38:
            if (r1 < 0) goto L3c
            r0 = 3
            goto L10
        L3c:
            r0 = 8
            goto L10
        L3f:
            com.facebook.ads.redexgen.X.7O r5 = (com.facebook.ads.redexgen.X.C7O) r5
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            r0 = 2
            r3.A0T(r0)
            r5.A07(r1)
            r0 = 4
            goto L10
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0T(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0059, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0U(int r6, int r7, boolean r8) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            r3 = 0
            int r2 = r6 + r7
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r4.A06
            int r0 = r0.size()
            int r1 = r0 + (-1)
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L39;
                case 3: goto L29;
                case 4: goto L1f;
                case 5: goto L17;
                case 6: goto L13;
                case 7: goto L40;
                case 8: goto L4b;
                case 9: goto L59;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            int r1 = r1 + (-1)
            r0 = 2
            goto Lf
        L17:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = -r7
            r3.A0W(r0, r8)
            r0 = 6
            goto Lf
        L1f:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = r3.A03
            if (r0 < r2) goto L27
            r0 = 5
            goto Lf
        L27:
            r0 = 7
            goto Lf
        L29:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r4.A06
            java.lang.Object r3 = r0.get(r1)
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            if (r3 == 0) goto L37
            r0 = 4
            goto Lf
        L37:
            r0 = 6
            goto Lf
        L39:
            if (r1 < 0) goto L3d
            r0 = 3
            goto Lf
        L3d:
            r0 = 9
            goto Lf
        L40:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = r3.A03
            if (r0 < r6) goto L49
            r0 = 8
            goto Lf
        L49:
            r0 = 6
            goto Lf
        L4b:
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            r0 = 8
            r3.A0T(r0)
            r4.A07(r1)
            r0 = 6
            goto Lf
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0U(int, int, boolean):void");
    }

    public final void A0V(View view) {
        C7Z A05 = C01807a.A05(view);
        A05.A0F = null;
        A05.A0G = false;
        A05.A0O();
        A0b(A05);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000f. Please report as an issue. */
    public final void A0W(View view) {
        C7O c7o = this;
        C7Z A05 = C01807a.A05(view);
        char c = !A05.A0k(12) ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    A05 = A05;
                    c = A05.A0f() ? (char) 3 : (char) 4;
                case 3:
                    c7o = c7o;
                    A05 = A05;
                    c = c7o.A08.A1p(A05) ? (char) 4 : '\b';
                case 4:
                    A05 = A05;
                    c = A05.A0b() ? (char) 5 : (char) 11;
                case 5:
                    A05 = A05;
                    c = !A05.A0c() ? (char) 6 : (char) 11;
                case 6:
                    c7o = c7o;
                    c = !c7o.A08.A04.A0A() ? (char) 7 : (char) 11;
                case 7:
                    throw new IllegalArgumentException(A04(6, 122, 56) + c7o.A08.A17());
                case '\b':
                    c7o = c7o;
                    c = c7o.A02 == null ? '\t' : '\n';
                case '\t':
                    c7o = c7o;
                    c7o.A02 = new ArrayList<>();
                    c = '\n';
                case '\n':
                    c7o = c7o;
                    A05 = A05;
                    A05.A0X(c7o, true);
                    c7o.A02.add(A05);
                    c = '\f';
                case 11:
                    c7o = c7o;
                    A05 = A05;
                    A05.A0X(c7o, false);
                    c7o.A05.add(A05);
                    c = '\f';
                case '\f':
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0045, code lost:            r3.A0b(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0X(android.view.View r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            com.facebook.ads.redexgen.X.7Z r2 = com.facebook.ads.redexgen.X.C01807a.A05(r5)
            boolean r0 = r2.A0e()
            if (r0 == 0) goto L43
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L30;
                case 3: goto L24;
                case 4: goto L1d;
                case 5: goto L45;
                case 6: goto L11;
                case 7: goto L3c;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            boolean r0 = r2.A0i()
            if (r0 == 0) goto L1b
            r0 = 7
            goto Ld
        L1b:
            r0 = 5
            goto Ld
        L1d:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            r2.A0S()
            r0 = 5
            goto Ld
        L24:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            boolean r0 = r2.A0d()
            if (r0 == 0) goto L2e
            r0 = 4
            goto Ld
        L2e:
            r0 = 6
            goto Ld
        L30:
            com.facebook.ads.redexgen.X.7O r3 = (com.facebook.ads.redexgen.X.C7O) r3
            android.view.View r5 = (android.view.View) r5
            com.facebook.ads.redexgen.X.7a r1 = r3.A08
            r0 = 0
            r1.removeDetachedView(r5, r0)
            r0 = 3
            goto Ld
        L3c:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            r2.A0O()
            r0 = 5
            goto Ld
        L43:
            r0 = 3
            goto Ld
        L45:
            com.facebook.ads.redexgen.X.7O r3 = (com.facebook.ads.redexgen.X.C7O) r3
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            r3.A0b(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0X(android.view.View):void");
    }

    public final void A0Y(C2E c2e, C2E c2e2, boolean z) {
        A0P();
        A0H().A08(c2e, c2e2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Z(com.facebook.ads.redexgen.X.C7N r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.7N r0 = r2.A01
            if (r0 == 0) goto L2e
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L13;
                case 4: goto L1f;
                case 5: goto L30;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7O r2 = (com.facebook.ads.redexgen.X.C7O) r2
            com.facebook.ads.redexgen.X.7N r0 = r2.A01
            r0.A04()
            r0 = 3
            goto L6
        L13:
            com.facebook.ads.redexgen.X.7O r2 = (com.facebook.ads.redexgen.X.C7O) r2
            com.facebook.ads.redexgen.X.7N r4 = (com.facebook.ads.redexgen.X.C7N) r4
            r2.A01 = r4
            if (r4 == 0) goto L1d
            r0 = 4
            goto L6
        L1d:
            r0 = 5
            goto L6
        L1f:
            com.facebook.ads.redexgen.X.7O r2 = (com.facebook.ads.redexgen.X.C7O) r2
            com.facebook.ads.redexgen.X.7N r1 = r2.A01
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            com.facebook.ads.redexgen.X.2E r0 = r0.getAdapter()
            r1.A07(r0)
            r0 = 5
            goto L6
        L2e:
            r0 = 3
            goto L6
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0Z(com.facebook.ads.redexgen.X.7N):void");
    }

    public final void A0a(C7X c7x) {
        this.A04 = c7x;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d7, code lost:            if (r0 != false) goto L29;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0b(com.facebook.ads.redexgen.X.C7Z r8) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0b(com.facebook.ads.redexgen.X.7Z):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:            r3 = r3;        r3.A0F = null;        r3.A0G = false;        r3.A0O();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0c(com.facebook.ads.redexgen.X.C7Z r3) {
        /*
            r2 = this;
            r1 = r2
            boolean r0 = com.facebook.ads.redexgen.X.C7Z.A0C(r3)
            if (r0 == 0) goto L22
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L24;
                case 4: goto L17;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7O r1 = (com.facebook.ads.redexgen.X.C7O) r1
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r1.A02
            r0.remove(r3)
            r0 = 3
            goto L8
        L17:
            com.facebook.ads.redexgen.X.7O r1 = (com.facebook.ads.redexgen.X.C7O) r1
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r1.A05
            r0.remove(r3)
            r0 = 3
            goto L8
        L22:
            r0 = 4
            goto L8
        L24:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            r0 = 0
            com.facebook.ads.redexgen.X.C7Z.A01(r3, r0)
            r0 = 0
            com.facebook.ads.redexgen.X.C7Z.A0F(r3, r0)
            r3.A0O()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0c(com.facebook.ads.redexgen.X.7Z):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:            r5 = r5;        r5.A08 = r2;        r3.A0H().A09(r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0d(com.facebook.ads.redexgen.X.C7Z r5, boolean r6) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            r2 = 0
            r1 = 16384(0x4000, float:2.2959E-41)
            com.facebook.ads.redexgen.X.C01807a.A0i(r5)
            boolean r0 = r5.A0k(r1)
            if (r0 == 0) goto L31
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L2b;
                case 4: goto L22;
                case 5: goto L33;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            r2 = 0
            r0 = 0
            r5.A0U(r0, r1)
            android.view.View r0 = r5.A0H
            com.facebook.ads.redexgen.X.C5B.A0A(r0, r2)
            r0 = 3
            goto L10
        L22:
            com.facebook.ads.redexgen.X.7O r3 = (com.facebook.ads.redexgen.X.C7O) r3
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            r3.A0B(r5)
            r0 = 5
            goto L10
        L2b:
            if (r6 == 0) goto L2f
            r0 = 4
            goto L10
        L2f:
            r0 = 5
            goto L10
        L31:
            r0 = 3
            goto L10
        L33:
            com.facebook.ads.redexgen.X.7O r3 = (com.facebook.ads.redexgen.X.C7O) r3
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            r5.A08 = r2
            com.facebook.ads.redexgen.X.7N r0 = r3.A0H()
            r0.A09(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7O.A0d(com.facebook.ads.redexgen.X.7Z, boolean):void");
    }
}
