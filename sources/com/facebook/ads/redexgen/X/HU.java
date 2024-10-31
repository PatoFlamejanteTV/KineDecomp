package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.View;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public class HU implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, InterfaceC02138i {
    public static byte[] A02;
    public final C0362Ec A00;
    public final /* synthetic */ HX A01;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.HU.A02
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
            r0 = r0 ^ 28
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HU.A00(int, int, int):java.lang.String");
    }

    public static void A03() {
        A02 = new byte[]{68, 101, 42, 126, 101, Byte.MAX_VALUE, 105, 98, 42, 110, 107, 126, 107, 42, 120, 111, 105, 101, 120, 110, 111, 110, 38, 42, 122, 102, 111, 107, 121, 111, 42, 111, 100, 121, Byte.MAX_VALUE, 120, 111, 42, 126, 101, Byte.MAX_VALUE, 105, 98, 42, 111, 124, 111, 100, 126, 121, 42, 120, 111, 107, 105, 98, 42, 126, 98, 111, 42, 107, 110, 42, 92, 99, 111, 125, 42, 104, 115, 42, 120, 111, 126, Byte.MAX_VALUE, 120, 100, 99, 100, 109, 42, 108, 107, 102, 121, 111, 42, 99, 108, 42, 115, 101, Byte.MAX_VALUE, 42, 99, 100, 126, 111, 120, 105, 111, 122, 126, 42, 126, 98, 111, 42, 111, 124, 111, 100, 126, 36, 64, 101, 33, 98, 96, 111, 111, 110, 117, 33, 99, 100, 33, 98, 109, 104, 98, 106, 100, 101, 33, 99, 100, 103, 110, 115, 100, 33, 104, 117, 33, 104, 114, 33, 119, 104, 100, 118, 100, 101, 47, 61, 39, 58, 41, 6, 3, 9, 1, 25, 74, 2, 11, 26, 26, 15, 4, 15, 14, 74, 30, 5, 5, 74, 12, 11, 25, 30, 68, 50, 54, 53, 1, 16, 29, 17, 26, 23, 17, 58, 17, 0, 3, 27, 6, 31, 56, 27, 19, 100, 98, 121};
    }

    public HU(HX hx, C0362Ec c0362Ec) {
        this.A01 = hx;
        this.A00 = c0362Ec;
    }

    public /* synthetic */ HU(HX hx, C0362Ec c0362Ec, HJ hj) {
        this(hx, c0362Ec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.String> A01() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            com.facebook.ads.redexgen.X.NS r1 = new com.facebook.ads.redexgen.X.NS
            r1.<init>()
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            com.facebook.ads.redexgen.X.FP r0 = com.facebook.ads.redexgen.X.HX.A0R(r0)
            com.facebook.ads.redexgen.X.NS r1 = r1.A03(r0)
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            com.facebook.ads.redexgen.X.K5 r0 = com.facebook.ads.redexgen.X.HX.A0P(r0)
            com.facebook.ads.redexgen.X.NS r0 = r1.A02(r0)
            java.util.Map r3 = r0.A05()
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            com.facebook.ads.redexgen.X.Hi r0 = com.facebook.ads.redexgen.X.HX.A0M(r0)
            if (r0 == 0) goto L76
            r0 = 2
        L28:
            switch(r0) {
                case 2: goto L2c;
                case 3: goto L4c;
                case 4: goto L5a;
                case 5: goto L78;
                default: goto L2b;
            }
        L2b:
            goto L28
        L2c:
            com.facebook.ads.redexgen.X.HU r4 = (com.facebook.ads.redexgen.X.HU) r4
            java.util.Map r3 = (java.util.Map) r3
            r2 = 156(0x9c, float:2.19E-43)
            r1 = 3
            r0 = 79
            java.lang.String r1 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            com.facebook.ads.redexgen.X.Hi r0 = com.facebook.ads.redexgen.X.HX.A0M(r0)
            int r0 = r0.A04()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r3.put(r1, r0)
            r0 = 3
            goto L28
        L4c:
            com.facebook.ads.redexgen.X.HU r4 = (com.facebook.ads.redexgen.X.HU) r4
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            boolean r0 = com.facebook.ads.redexgen.X.HX.A0m(r0)
            if (r0 == 0) goto L58
            r0 = 4
            goto L28
        L58:
            r0 = 5
            goto L28
        L5a:
            com.facebook.ads.redexgen.X.HU r4 = (com.facebook.ads.redexgen.X.HU) r4
            java.util.Map r3 = (java.util.Map) r3
            r2 = 204(0xcc, float:2.86E-43)
            r1 = 3
            r0 = 22
            java.lang.String r1 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            boolean r0 = com.facebook.ads.redexgen.X.HX.A0m(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r3.put(r1, r0)
            r0 = 5
            goto L28
        L76:
            r0 = 3
            goto L28
        L78:
            java.util.Map r3 = (java.util.Map) r3
            java.util.Map r3 = (java.util.Map) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HU.A01():java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(Map<String, String> map) {
        if (this.A01.A0V != null) {
            this.A01.A0V.A0X(map);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02138i
    public final C0362Ec A4E() {
        return this.A00;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        K5 k5;
        C0362Ec c0362Ec;
        K5 k52;
        C0362Ec c0362Ec2;
        C0362Ec c0362Ec3;
        K5 k53;
        K5 k54;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            k5 = this.A01.A0a;
            if (!k5.A08()) {
                Log.e(A00(184, 20, 104), A00(0, 115, 22));
            }
            c0362Ec = this.A01.A0X;
            int A0C = C0413Gc.A0C(c0362Ec);
            if (A0C >= 0) {
                k53 = this.A01.A0a;
                if (k53.A03() < A0C) {
                    k54 = this.A01.A0a;
                    if (!k54.A07()) {
                        Log.e(A00(184, 20, 104), A00(115, 41, 29));
                        return;
                    } else {
                        Log.e(A00(184, 20, 104), A00(159, 25, 118));
                        return;
                    }
                }
            }
            k52 = this.A01.A0a;
            c0362Ec2 = this.A01.A0X;
            if (k52.A09(c0362Ec2)) {
                if (this.A01.A0V == null) {
                    return;
                }
                this.A01.A0V.A0Y(A01());
                return;
            }
            c0362Ec3 = this.A01.A0X;
            if (C0413Gc.A0n(c0362Ec3)) {
                if (this.A01.A0V != null) {
                    this.A01.A0V.A0b(A01());
                }
                C0486Jb.A00(new HS(this), new HT(this), JJ.A00());
                return;
            }
            A05(A01());
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0067, code lost:            return r5;     */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onLongClick(android.view.View r7) {
        /*
            r6 = this;
            r4 = r6
            r0 = 0
            r1 = 0
            r0 = 0
            r5 = 1
            r3 = 0
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            android.view.View r0 = com.facebook.ads.redexgen.X.HX.A08(r0)
            if (r0 == 0) goto L65
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L50;
                case 3: goto L4c;
                case 4: goto L67;
                case 5: goto L16;
                case 6: goto L13;
                case 7: goto L5e;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            r3 = r5
            r0 = 7
            goto Lf
        L16:
            com.facebook.ads.redexgen.X.HU r4 = (com.facebook.ads.redexgen.X.HU) r4
            r3 = 0
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            com.facebook.ads.redexgen.X.NQ r2 = com.facebook.ads.redexgen.X.HX.A0Q(r0)
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            android.view.View r0 = com.facebook.ads.redexgen.X.HX.A08(r0)
            int r1 = r0.getWidth()
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            android.view.View r0 = com.facebook.ads.redexgen.X.HX.A08(r0)
            int r0 = r0.getHeight()
            r2.setBounds(r3, r3, r1, r0)
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            com.facebook.ads.redexgen.X.NQ r1 = com.facebook.ads.redexgen.X.HX.A0Q(r0)
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            com.facebook.ads.redexgen.X.NQ r0 = com.facebook.ads.redexgen.X.HX.A0Q(r0)
            boolean r0 = r0.A0E()
            if (r0 != 0) goto L4a
            r0 = 6
            goto Lf
        L4a:
            r0 = 7
            goto Lf
        L4c:
            r3 = 0
            r5 = r3
            r0 = 4
            goto Lf
        L50:
            com.facebook.ads.redexgen.X.HU r4 = (com.facebook.ads.redexgen.X.HU) r4
            com.facebook.ads.redexgen.X.HX r0 = r4.A01
            com.facebook.ads.redexgen.X.NQ r0 = com.facebook.ads.redexgen.X.HX.A0Q(r0)
            if (r0 != 0) goto L5c
            r0 = 3
            goto Lf
        L5c:
            r0 = 5
            goto Lf
        L5e:
            com.facebook.ads.redexgen.X.NQ r1 = (com.facebook.ads.redexgen.X.NQ) r1
            r1.A0D(r3)
            r0 = 4
            goto Lf
        L65:
            r0 = 3
            goto Lf
        L67:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HU.onLongClick(android.view.View):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:            return r2;     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.HX r0 = r3.A01
            com.facebook.ads.redexgen.X.K5 r1 = com.facebook.ads.redexgen.X.HX.A0P(r0)
            com.facebook.ads.redexgen.X.HX r0 = r3.A01
            android.view.View r0 = com.facebook.ads.redexgen.X.HX.A08(r0)
            r1.A06(r6, r0, r5)
            com.facebook.ads.redexgen.X.HX r0 = r3.A01
            android.view.View$OnTouchListener r0 = com.facebook.ads.redexgen.X.HX.A07(r0)
            if (r0 == 0) goto L3a
            r0 = 2
        L1a:
            switch(r0) {
                case 2: goto L1e;
                case 3: goto L37;
                case 4: goto L3c;
                case 5: goto L34;
                default: goto L1d;
            }
        L1d:
            goto L1a
        L1e:
            com.facebook.ads.redexgen.X.HU r3 = (com.facebook.ads.redexgen.X.HU) r3
            android.view.View r5 = (android.view.View) r5
            android.view.MotionEvent r6 = (android.view.MotionEvent) r6
            com.facebook.ads.redexgen.X.HX r0 = r3.A01
            android.view.View$OnTouchListener r0 = com.facebook.ads.redexgen.X.HX.A07(r0)
            boolean r0 = r0.onTouch(r5, r6)
            if (r0 == 0) goto L32
            r0 = 3
            goto L1a
        L32:
            r0 = 5
            goto L1a
        L34:
            r2 = 0
            r0 = 4
            goto L1a
        L37:
            r2 = 1
            r0 = 4
            goto L1a
        L3a:
            r0 = 5
            goto L1a
        L3c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HU.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
