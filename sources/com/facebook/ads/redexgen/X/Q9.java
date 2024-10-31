package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public class Q9 implements InterfaceC00301b<Bundle> {
    public static byte[] A0C;
    public int A00;
    public int A01;

    @Nullable
    public String A02;

    @Nullable
    public String A03;
    public boolean A04;
    public final C01063z A05;
    public final C0362Ec A06;
    public final InterfaceC0422Gl A07;
    public final LZ A08;
    public final QG A09;
    public final String A0A;

    @Nullable
    public final Map<String, String> A0B;

    static {
        A0A();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.Q9.A0C
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
            r0 = r0 ^ 43
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Q9.A02(int, int, int):java.lang.String");
    }

    public static void A0A() {
        A0C = new byte[]{124, 102, 103, 36, 37, 13, 54, 17, 23, 15, 65, 64, 90, 86, 79, 110, 111, 121, 32, 62, 57, 51, 56, 32, 114, 111, 120, 103, 123, 118, 110, 114, 101, 34, 36, 35, 56, 57, 35, 18, 16, 7, 18, 22, 14, 48, 61, 47, 40, 30, 51, 41, 50, 56, 61, 46, 37, 8, 53, 49, 57, 17, 15, 18, 16, 7, 26, 28, 29, 118, 120, 109, 111, 68, 118, 104, 24, 4, 41, 40, 0, 45, 44, 49, 54, 51, 6, 34, 54, 59, 62, 35, 46, 26, 54, 57, 54, 48, 50, 37, 97, 123, 118, 21, 17, 12, 8, 0, 76, 89, 68, 64, 72, 114, 64, 94, 12, 11, 96, 110, 108, 121, 82, 96, 126, 65, 67, 94, 90, 82, 104, 90, 68, 73, 83, 82, 94, 71, 102, 98, 36, 41, 59, 60, 24, 58, 39, 47, 58, 45, 59, 59, 28, 33, 37, 45, 5, 27, 123, 102, 98, 106};
    }

    public Q9(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, LZ lz, List<C1X> list, String str) {
        this(c0362Ec, interfaceC0422Gl, lz, list, str, null);
    }

    public Q9(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, LZ lz, List<C1X> list, String str, @Nullable Bundle bundle) {
        this(c0362Ec, interfaceC0422Gl, lz, list, str, bundle, null);
    }

    public Q9(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, LZ lz, List<C1X> list, String str, @Nullable Bundle bundle, @Nullable Map<String, String> map) {
        this.A04 = true;
        this.A01 = 0;
        this.A00 = 0;
        this.A02 = null;
        this.A03 = null;
        this.A06 = c0362Ec;
        this.A07 = interfaceC0422Gl;
        this.A08 = lz;
        this.A0A = str;
        this.A0B = map;
        list.add(new QB(this, 0.5d, -1.0d, 2.0d, true));
        list.add(new QC(this, 1.0E-7d, -1.0d, 0.001d, false));
        if (bundle != null) {
            this.A05 = new C01063z(lz.getView(), list, bundle.getBundle(A02(84, 16, 124)), c0362Ec);
            this.A01 = bundle.getInt(A02(140, 18, 99));
            this.A00 = bundle.getInt(A02(45, 18, 119));
        } else {
            this.A05 = new C01063z(lz.getView(), list, c0362Ec);
        }
        this.A09 = new QG(new Handler(), this);
    }

    private final float A00() {
        return K8.A00(this.A06) * this.A08.getVolume();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0034, code lost:            r5 = r5;        r4 = r4;        com.facebook.ads.redexgen.X.K8.A03(r4, r0, r1);        r5.A0D(r4);        r5.A0C(r4);        r5.A0F(r4, r7);        r5.A0E(r4);        r5.A0B(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.String> A04(int r7) {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r0 = 0
            r0 = 0
            r1 = 0
            r1 = 1
            r2 = 0
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.facebook.ads.redexgen.X.LZ r2 = r5.A08
            com.facebook.ads.redexgen.X.QH r3 = r2.getVideoStartReason()
            com.facebook.ads.redexgen.X.QH r2 = com.facebook.ads.redexgen.X.QH.A03
            if (r3 != r2) goto L32
            r2 = 2
        L17:
            switch(r2) {
                case 2: goto L1b;
                case 3: goto L1e;
                case 4: goto L34;
                case 5: goto L2c;
                case 6: goto L2f;
                default: goto L1a;
            }
        L1a:
            goto L17
        L1b:
            r0 = r1
            r2 = 3
            goto L17
        L1e:
            com.facebook.ads.redexgen.X.Q9 r5 = (com.facebook.ads.redexgen.X.Q9) r5
            com.facebook.ads.redexgen.X.LZ r2 = r5.A08
            boolean r2 = r2.A5D()
            if (r2 != 0) goto L2a
            r2 = 4
            goto L17
        L2a:
            r2 = 5
            goto L17
        L2c:
            r1 = 0
            r2 = 4
            goto L17
        L2f:
            r0 = 0
            r2 = 3
            goto L17
        L32:
            r2 = 6
            goto L17
        L34:
            com.facebook.ads.redexgen.X.Q9 r5 = (com.facebook.ads.redexgen.X.Q9) r5
            java.util.HashMap r4 = (java.util.HashMap) r4
            com.facebook.ads.redexgen.X.K8.A03(r4, r0, r1)
            r5.A0D(r4)
            r5.A0C(r4)
            r5.A0F(r4, r7)
            r5.A0E(r4)
            r5.A0B(r4)
            java.util.Map r4 = (java.util.Map) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Q9.A04(int):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A05(QD qd) {
        return A06(qd, this.A08.getCurrentPositionInMillis());
    }

    private Map<String, String> A06(QD qd, int i) {
        Map<String, String> A04 = A04(i);
        A04.put(A02(63, 6, 88), String.valueOf(qd.A00));
        return A04;
    }

    private void A08() {
        this.A07.A5t(this.A0A, A05(QD.A04));
    }

    private void A09() {
        this.A07.A5t(this.A0A, A05(QD.A0A));
    }

    private void A0B(HashMap<String, String> hashMap) {
        if (this.A0B != null) {
            hashMap.putAll(this.A0B);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b6, code lost:            r9 = r9;        r3 = r3.A01();        r9.put(A02(100, 3, 60), java.lang.String.valueOf(r3.A00()));        r9.put(A02(0, 3, 33), java.lang.String.valueOf(r3.A05()));        r9.put(A02(133, 5, 20), java.lang.String.valueOf(r3.A02()));        r9.put(A02(108, 8, 6), java.lang.String.valueOf(r3.A01() * 1000.0d));        r9.put(A02(118, 7, 38), java.lang.String.valueOf(r3.A03() * 1000.0d));     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0123, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0C(java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Q9.A0C(java.util.Map):void");
    }

    private void A0D(Map<String, String> map) {
        map.put(A02(24, 9, 60), String.valueOf(this.A08.A5C()));
        map.put(A02(39, 4, 73), Long.toString(this.A08.getInitialBufferTime()));
    }

    private void A0E(Map<String, String> map) {
        Rect rect = new Rect();
        this.A08.getGlobalVisibleRect(rect);
        map.put(A02(138, 2, 61), String.valueOf(rect.top));
        map.put(A02(76, 2, 67), String.valueOf(rect.left));
        map.put(A02(43, 2, 77), String.valueOf(this.A08.getMeasuredHeight()));
        map.put(A02(116, 2, 87), String.valueOf(this.A08.getMeasuredWidth()));
        WindowManager windowManager = (WindowManager) this.A06.getSystemService(A02(18, 6, 124));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        map.put(A02(7, 3, 76), String.valueOf(displayMetrics.heightPixels));
        map.put(A02(33, 3, 127), String.valueOf(displayMetrics.widthPixels));
    }

    private void A0F(Map<String, String> map, int i) {
        map.put(A02(103, 5, 78), String.valueOf(this.A00 / 1000.0f));
        map.put(A02(158, 4, 36), String.valueOf(i / 1000.0f));
    }

    public final int A0G() {
        return this.A01;
    }

    public final void A0H() {
        this.A05.A03();
        this.A07.A5t(this.A0A, A05(QD.A05));
    }

    public final void A0I() {
        this.A07.A5t(this.A0A, A05(QD.A07));
    }

    public final void A0J() {
        this.A07.A5t(this.A0A, A05(QD.A08));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0K() {
        /*
            r6 = this;
            r5 = r6
            float r0 = r5.A00()
            double r3 = (double) r0
            r1 = 4587366580439587226(0x3fa999999999999a, double:0.05)
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L3c
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L1e;
                case 4: goto L3e;
                case 5: goto L28;
                case 6: goto L32;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.Q9 r5 = (com.facebook.ads.redexgen.X.Q9) r5
            boolean r0 = r5.A04
            if (r0 == 0) goto L1c
            r0 = 3
            goto L10
        L1c:
            r0 = 4
            goto L10
        L1e:
            com.facebook.ads.redexgen.X.Q9 r5 = (com.facebook.ads.redexgen.X.Q9) r5
            r5.A08()
            r0 = 0
            r5.A04 = r0
            r0 = 4
            goto L10
        L28:
            com.facebook.ads.redexgen.X.Q9 r5 = (com.facebook.ads.redexgen.X.Q9) r5
            boolean r0 = r5.A04
            if (r0 != 0) goto L30
            r0 = 6
            goto L10
        L30:
            r0 = 4
            goto L10
        L32:
            com.facebook.ads.redexgen.X.Q9 r5 = (com.facebook.ads.redexgen.X.Q9) r5
            r5.A09()
            r0 = 1
            r5.A04 = r0
            r0 = 4
            goto L10
        L3c:
            r0 = 5
            goto L10
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Q9.A0K():void");
    }

    public final void A0L() {
        this.A06.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.A09);
    }

    public final void A0M() {
        this.A06.getContentResolver().unregisterContentObserver(this.A09);
    }

    public final void A0N(int i) {
        A0Q(i, false, false);
    }

    public final void A0O(int i) {
        A0Q(i, true, false);
        this.A00 = 0;
        this.A01 = 0;
        this.A05.A04();
        this.A05.A03();
    }

    public final void A0P(int i, int i2) {
        A0Q(i, true, false);
        this.A00 = i2;
        this.A01 = i2;
        this.A05.A04();
        this.A05.A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0082, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Q(int r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            r4 = r7
            double r1 = (double) r8
            r5 = 0
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 <= 0) goto L80
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L4b;
                case 3: goto L82;
                case 4: goto L40;
                case 5: goto L23;
                case 6: goto Ld;
                case 7: goto L55;
                case 8: goto L1c;
                case 9: goto L6f;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.Q9 r4 = (com.facebook.ads.redexgen.X.Q9) r4
            int r0 = r4.A00
            int r1 = r8 - r0
            r0 = 5000(0x1388, float:7.006E-42)
            if (r1 < r0) goto L19
            r0 = 7
            goto L9
        L19:
            r0 = 8
            goto L9
        L1c:
            if (r9 == 0) goto L21
            r0 = 9
            goto L9
        L21:
            r0 = 3
            goto L9
        L23:
            com.facebook.ads.redexgen.X.Q9 r4 = (com.facebook.ads.redexgen.X.Q9) r4
            com.facebook.ads.redexgen.X.3z r5 = r4.A05
            int r0 = r4.A01
            int r0 = r8 - r0
            float r1 = (float) r0
            r0 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r0
            double r2 = (double) r1
            float r0 = r4.A00()
            double r0 = (double) r0
            r5.A05(r2, r0)
            r4.A01 = r8
            if (r10 != 0) goto L3e
            r0 = 6
            goto L9
        L3e:
            r0 = 7
            goto L9
        L40:
            com.facebook.ads.redexgen.X.Q9 r4 = (com.facebook.ads.redexgen.X.Q9) r4
            int r0 = r4.A01
            if (r8 <= r0) goto L48
            r0 = 5
            goto L9
        L48:
            r0 = 8
            goto L9
        L4b:
            com.facebook.ads.redexgen.X.Q9 r4 = (com.facebook.ads.redexgen.X.Q9) r4
            int r0 = r4.A01
            if (r8 >= r0) goto L53
            r0 = 3
            goto L9
        L53:
            r0 = 4
            goto L9
        L55:
            com.facebook.ads.redexgen.X.Q9 r4 = (com.facebook.ads.redexgen.X.Q9) r4
            com.facebook.ads.redexgen.X.Gl r2 = r4.A07
            java.lang.String r1 = r4.A0A
            com.facebook.ads.redexgen.X.QD r0 = com.facebook.ads.redexgen.X.QD.A09
            java.util.Map r0 = r4.A06(r0, r8)
            r2.A5t(r1, r0)
            int r0 = r4.A01
            r4.A00 = r0
            com.facebook.ads.redexgen.X.3z r0 = r4.A05
            r0.A04()
            r0 = 3
            goto L9
        L6f:
            com.facebook.ads.redexgen.X.Q9 r4 = (com.facebook.ads.redexgen.X.Q9) r4
            com.facebook.ads.redexgen.X.Gl r2 = r4.A07
            java.lang.String r1 = r4.A0A
            com.facebook.ads.redexgen.X.QD r0 = com.facebook.ads.redexgen.X.QD.A09
            java.util.Map r0 = r4.A06(r0, r8)
            r2.A5t(r1, r0)
            r0 = 3
            goto L9
        L80:
            r0 = 3
            goto L9
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Q9.A0Q(int, boolean, boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00301b
    public final Bundle getSaveInstanceState() {
        A0P(A0G(), A0G());
        Bundle bundle = new Bundle();
        bundle.putInt(A02(140, 18, 99), this.A01);
        bundle.putInt(A02(45, 18, 119), this.A00);
        bundle.putBundle(A02(84, 16, 124), this.A05.getSaveInstanceState());
        return bundle;
    }
}
