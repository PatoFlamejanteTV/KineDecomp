package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: com.facebook.ads.redexgen.X.5q, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5q {
    public static byte[] A02;
    public static final C01355e A03;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int A00 = -1;
    public final AccessibilityNodeInfo A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A08(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C5q.A02
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
            int r0 = r0 + (-21)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5q.A08(int, int, int):java.lang.String");
    }

    public static void A09() {
        A02 = new byte[]{-118, 126, -52, -79, -9, 0, -12, 6, 4, -14, -13, -3, -10, -53, -79, -83, -81, -64, -75, -69, -70, -53, -81, -72, -79, -83, -66, -53, -83, -81, -81, -79, -65, -65, -75, -82, -75, -72, -75, -64, -59, -53, -78, -69, -81, -63, -65, 112, 114, -125, 120, 126, 125, -114, 114, -124, -125, -98, -96, -79, -90, -84, -85, -68, -93, -84, -96, -78, -80, -70, -97, -30, -18, -19, -13, -28, -19, -13, -61, -28, -14, -30, -15, -24, -17, -13, -24, -18, -19, -71, -97, 123, 125, -114, -125, -119, -120, -103, -118, -116, Byte.MAX_VALUE, -112, -125, -119, -113, -115, -103, 123, -114, -103, -121, -119, -112, Byte.MAX_VALUE, -121, Byte.MAX_VALUE, -120, -114, -103, -127, -116, 123, -120, -113, -122, 123, -116, -125, -114, -109, 119, 92, -84, -99, -97, -89, -99, -93, -95, -118, -99, -87, -95, 118, 92, -51, -78, -9, 0, -13, -12, -2, -9, -10, -52, -78, -50, -77, 9, -4, -8, 10, -36, -9, -51, -77, -96, -94, -77, -88, -82, -83, -66, -81, -79, -92, -75, -88, -82, -76, -78, -66, -89, -77, -84, -85, -66, -92, -85, -92, -84, -92, -83, -77, Byte.MIN_VALUE, -126, -109, -120, -114, -115, -98, -113, Byte.MIN_VALUE, -110, -109, -124, -110, 119, -67, -58, -70, -52, -54, -68, -69, -111, 119, 96, 98, 115, 104, 110, 109, 126, 114, 100, 107, 100, 98, 115, -39, -89, -116, -49, -44, -47, -49, -41, -51, -50, -40, -47, -90, -116, -100, -127, -68, 106, 79, -94, -108, -101, -108, -110, -93, -108, -109, 105, 79, 111, 113, -126, 119, 125, 124, -115, 124, 115, -122, -126, -115, 118, -126, 123, 122, -115, 115, 122, 115, 123, 115, 124, -126, 106, 108, 125, 114, 120, 119, -120, 124, 108, 123, 120, 117, 117, -120, 107, 106, 108, 116, Byte.MIN_VALUE, 106, 123, 109, 121, 123, -116, -127, -121, -122, -105, -122, 125, -112, -116, -105, 121, -116, -105, -123, -121, -114, 125, -123, 125, -122, -116, -105, Byte.MAX_VALUE, -118, 121, -122, -115, -124, 121, -118, -127, -116, -111, 111, 113, -126, 119, 125, 124, -115, 113, 122, 119, 113, 121, -75, -102, -18, -33, -14, -18, -76, -102, -65, -92, -25, -20, -23, -25, -17, -23, -24, -66, -92, -69, -67, -50, -61, -55, -56, -39, -51, -65, -50, -39, -51, -65, -58, -65, -67, -50, -61, -55, -56, 97, 99, 116, 105, 111, 110, Byte.MAX_VALUE, 117, 110, 107, 110, 111, 119, 110, 100, 73, -117, -104, -98, -105, -115, -100, 114, -105, 124, -116, -101, -114, -114, -105, 99, 73, 117, 119, -120, 125, -125, -126, -109, 119, Byte.MIN_VALUE, 121, 117, -122, -109, -121, 121, Byte.MIN_VALUE, 121, 119, -120, 125, -125, -126, -79, -106, -26, -41, -23, -23, -19, -27, -24, -38, -80, -106, -104, -102, -85, -96, -90, -91, -74, -93, -90, -91, -98, -74, -102, -93, -96, -102, -94, -126, 103, -86, -77, -80, -86, -78, -88, -87, -77, -84, -127, 103, -65, -92, -16, -13, -14, -21, -57, -16, -19, -25, -17, -27, -26, -16, -23, -66, -92, Byte.MIN_VALUE, -126, -109, -120, -114, -115, -98, Byte.MIN_VALUE, -126, -126, -124, -110, -110, -120, -127, -120, -117, -120, -109, -104, -98, -123, -114, -126, -108, -110, -100, -127, -44, -60, -45, -48, -51, -51, -62, -61, -51, -58, -101, -127, -71, -69, -52, -63, -57, -58, -41, -69, -60, -67, -71, -54, -41, -66, -57, -69, -51, -53, -50, -77, -10, -1, -12, 6, 6, -31, -12, 0, -8, -51, -77, -48, -46, -29, -40, -34, -35, -18, -30, -46, -31, -34, -37, -37, -18, -43, -34, -31, -26, -48, -31, -45, -71, -98, -32, -19, -13, -20, -30, -15, -57, -20, -50, -33, -16, -29, -20, -14, -72, -98, -71, -69, -52, -63, -57, -58, -41, -69, -57, -56, -47};
    }

    static {
        A09();
        if (Build.VERSION.SDK_INT >= 24) {
            A03 = new C01415l() { // from class: com.facebook.ads.redexgen.X.5m
            };
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            A03 = new C01415l();
            return;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            A03 = new C01405k();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            A03 = new C01395j();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            A03 = new C01385i();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            A03 = new C5h();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            A03 = new C01375g();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A03 = new C01365f();
        } else {
            A03 = new C01355e();
        }
    }

    public C5q(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.A01 = accessibilityNodeInfo;
    }

    private final int A00() {
        return this.A01.getActions();
    }

    public static C5q A01(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C5q(accessibilityNodeInfo);
    }

    private final CharSequence A02() {
        return this.A01.getClassName();
    }

    private final CharSequence A03() {
        return this.A01.getContentDescription();
    }

    private final CharSequence A04() {
        return this.A01.getPackageName();
    }

    private final CharSequence A05() {
        return this.A01.getText();
    }

    private final String A06() {
        return A03.A02(this.A01);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x013e, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A07(int r2) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5q.A07(int):java.lang.String");
    }

    private final void A0A(Rect rect) {
        this.A01.getBoundsInParent(rect);
    }

    private final void A0B(Rect rect) {
        this.A01.getBoundsInScreen(rect);
    }

    private final boolean A0C() {
        return this.A01.isCheckable();
    }

    private final boolean A0D() {
        return this.A01.isChecked();
    }

    private final boolean A0E() {
        return this.A01.isClickable();
    }

    private final boolean A0F() {
        return this.A01.isEnabled();
    }

    private final boolean A0G() {
        return this.A01.isFocusable();
    }

    private final boolean A0H() {
        return this.A01.isFocused();
    }

    private final boolean A0I() {
        return this.A01.isLongClickable();
    }

    private final boolean A0J() {
        return this.A01.isPassword();
    }

    private final boolean A0K() {
        return this.A01.isScrollable();
    }

    private final boolean A0L() {
        return this.A01.isSelected();
    }

    public final AccessibilityNodeInfo A0M() {
        return this.A01;
    }

    public final void A0N(int i) {
        this.A01.addAction(i);
    }

    public final void A0O(CharSequence charSequence) {
        this.A01.setClassName(charSequence);
    }

    public final void A0P(Object obj) {
        A03.A03(this.A01, ((C01435n) obj).A00);
    }

    public final void A0Q(Object obj) {
        A03.A04(this.A01, ((C01445o) obj).A00);
    }

    public final void A0R(boolean z) {
        this.A01.setScrollable(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0064, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r0 = 0
            r0 = 1
            r1 = 0
            if (r4 != r6) goto L62
            r1 = 2
        L9:
            switch(r1) {
                case 2: goto L64;
                case 3: goto L22;
                case 4: goto L2a;
                case 5: goto L10;
                case 6: goto Ld;
                case 7: goto L30;
                case 8: goto L41;
                case 9: goto L2d;
                case 10: goto L4c;
                case 11: goto L5f;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r0 = 0
            r1 = 2
            goto L9
        L10:
            com.facebook.ads.redexgen.X.5q r4 = (com.facebook.ads.redexgen.X.C5q) r4
            java.lang.Object r6 = (java.lang.Object) r6
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r1 = r6.getClass()
            if (r2 == r1) goto L20
            r1 = 6
            goto L9
        L20:
            r1 = 7
            goto L9
        L22:
            java.lang.Object r6 = (java.lang.Object) r6
            if (r6 != 0) goto L28
            r1 = 4
            goto L9
        L28:
            r1 = 5
            goto L9
        L2a:
            r0 = 0
            r1 = 2
            goto L9
        L2d:
            r0 = 0
            r1 = 2
            goto L9
        L30:
            com.facebook.ads.redexgen.X.5q r4 = (com.facebook.ads.redexgen.X.C5q) r4
            java.lang.Object r6 = (java.lang.Object) r6
            r3 = r6
            com.facebook.ads.redexgen.X.5q r3 = (com.facebook.ads.redexgen.X.C5q) r3
            android.view.accessibility.AccessibilityNodeInfo r1 = r4.A01
            if (r1 != 0) goto L3e
            r1 = 8
            goto L9
        L3e:
            r1 = 10
            goto L9
        L41:
            com.facebook.ads.redexgen.X.5q r3 = (com.facebook.ads.redexgen.X.C5q) r3
            android.view.accessibility.AccessibilityNodeInfo r1 = r3.A01
            if (r1 == 0) goto L4a
            r1 = 9
            goto L9
        L4a:
            r1 = 2
            goto L9
        L4c:
            com.facebook.ads.redexgen.X.5q r4 = (com.facebook.ads.redexgen.X.C5q) r4
            com.facebook.ads.redexgen.X.5q r3 = (com.facebook.ads.redexgen.X.C5q) r3
            android.view.accessibility.AccessibilityNodeInfo r2 = r4.A01
            android.view.accessibility.AccessibilityNodeInfo r1 = r3.A01
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L5d
            r1 = 11
            goto L9
        L5d:
            r1 = 2
            goto L9
        L5f:
            r0 = 0
            r1 = 2
            goto L9
        L62:
            r1 = 3
            goto L9
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5q.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int hashCode() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            android.view.accessibility.AccessibilityNodeInfo r0 = r2.A01
            if (r0 != 0) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1a;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 0
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.5q r2 = (com.facebook.ads.redexgen.X.C5q) r2
            android.view.accessibility.AccessibilityNodeInfo r0 = r2.A01
            int r1 = r0.hashCode()
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5q.hashCode():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x01de, code lost:            r4 = r4;        r4.append(A08(230, 1, 103));     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x01f2, code lost:            return r4.toString();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5q.toString():java.lang.String");
    }
}
