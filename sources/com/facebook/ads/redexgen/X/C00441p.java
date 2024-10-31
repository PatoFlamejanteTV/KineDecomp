package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.AdError;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.1p, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00441p extends AbstractC00431o implements C1M {
    public static byte[] A0C;
    public long A00;
    public AnonymousClass26 A01;
    public AnonymousClass27 A02;
    public C2I A03;
    public C0362Ec A04;
    public C0432Gv A05;
    public IY A06;
    public String A07;

    @Nullable
    public String A08;
    public String A09;
    public final String A0A = UUID.randomUUID().toString();
    public final AtomicBoolean A0B = new AtomicBoolean();

    static {
        A05();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C00441p.A0C
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
            r0 = r0 ^ 75
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00441p.A01(int, int, int):java.lang.String");
    }

    public static void A05() {
        A0C = new byte[]{1, 22, 4, 18, 1, 23, 22, 23, 37, 26, 23, 22, 28, 50, 23, 55, 18, 7, 18, 49, 6, 29, 23, 31, 22, 94, 24, 25, 26, 21, 18, 21, 8, 21, 19, 18, 18, 13, 1, 19, 48, 29, 20, 1, 117, 98, 112, 102, 117, 99, 98, 99, 88, 113, 110, 99, 98, 104, 28, 30, 30, 24, 17, 24, 15, 18, 16, 24, 9, 24, 15, 34, 15, 18, 9, 28, 9, 20, 18, 19, 42, 61, 41, 45, 61, 43, 44, 12, 49, 53, 61, 110, 108, 123, 122, 123, 120, 119, 112, 123, 122, 81, 108, 119, 123, 112, 106, Byte.MAX_VALUE, 106, 119, 113, 112, 85, 123, 103, 65, 90, 93, 69, 65, 81, 125, 80, 96, 119, 101, 115, 96, 118, 65, 119, 96, 100, 119, 96, 71, 64, 94, 28, 25, 12, 25, 68, 75, 78, 66, 73, 83, 115, 72, 76, 66, 73, 83, 79, 66, 64, 70, 78, 70, 77, 87, 106, 71, 67, 75, 74, 71, 79, 90, 71, 65, 64, 106, 79, 90, 79};
    }

    private void A03() {
        C4F.A00(this.A04).A06(this.A02, this.A02.A00());
    }

    private void A04() {
        if (this.A02 != null) {
            try {
                C4F.A00(this.A04).A05(this.A02);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(android.content.Intent r6) {
        /*
            r5 = this;
            r3 = r5
            int r1 = r3.A00
            r0 = -1
            if (r1 == r0) goto L5e
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L29;
                case 4: goto L60;
                case 5: goto L3e;
                case 6: goto L4c;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.1p r3 = (com.facebook.ads.redexgen.X.C00441p) r3
            com.facebook.ads.redexgen.X.Ec r0 = r3.A04
            android.content.ContentResolver r4 = r0.getContentResolver()
            r2 = 58
            r1 = 22
            r0 = 54
            java.lang.String r1 = A01(r2, r1, r0)
            r0 = 0
            int r1 = android.provider.Settings.System.getInt(r4, r1, r0)
            r0 = 1
            if (r1 == r0) goto L27
            r0 = 3
            goto L7
        L27:
            r0 = 5
            goto L7
        L29:
            com.facebook.ads.redexgen.X.1p r3 = (com.facebook.ads.redexgen.X.C00441p) r3
            android.content.Intent r6 = (android.content.Intent) r6
            r2 = 91
            r1 = 24
            r0 = 85
            java.lang.String r1 = A01(r2, r1, r0)
            int r0 = r3.A00
            r6.putExtra(r1, r0)
            r0 = 4
            goto L7
        L3e:
            com.facebook.ads.redexgen.X.1p r3 = (com.facebook.ads.redexgen.X.C00441p) r3
            com.facebook.ads.redexgen.X.Ec r0 = r3.A04
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0T(r0)
            if (r0 != 0) goto L4a
            r0 = 6
            goto L7
        L4a:
            r0 = 4
            goto L7
        L4c:
            android.content.Intent r6 = (android.content.Intent) r6
            r2 = 91
            r1 = 24
            r0 = 85
            java.lang.String r1 = A01(r2, r1, r0)
            r0 = 6
            r6.putExtra(r1, r0)
            r0 = 4
            goto L7
        L5e:
            r0 = 5
            goto L7
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00441p.A06(android.content.Intent):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x002f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.IY r1 = r2.A06
            com.facebook.ads.redexgen.X.IY r0 = com.facebook.ads.redexgen.X.IY.A0B
            if (r1 != r0) goto L2d
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L2f;
                case 4: goto L13;
                case 5: goto L1f;
                case 6: goto L26;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.1p r2 = (com.facebook.ads.redexgen.X.C00441p) r2
            r2.A09(r4)
            r0 = 3
            goto L8
        L13:
            com.facebook.ads.redexgen.X.1p r2 = (com.facebook.ads.redexgen.X.C00441p) r2
            com.facebook.ads.redexgen.X.IY r1 = r2.A06
            com.facebook.ads.redexgen.X.IY r0 = com.facebook.ads.redexgen.X.IY.A0A
            if (r1 != r0) goto L1d
            r0 = 5
            goto L8
        L1d:
            r0 = 6
            goto L8
        L1f:
            com.facebook.ads.redexgen.X.1p r2 = (com.facebook.ads.redexgen.X.C00441p) r2
            r2.A08(r4)
            r0 = 3
            goto L8
        L26:
            com.facebook.ads.redexgen.X.1p r2 = (com.facebook.ads.redexgen.X.C00441p) r2
            r2.A09(r4)
            r0 = 3
            goto L8
        L2d:
            r0 = 4
            goto L8
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00441p.A07(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(boolean r9) {
        /*
            r8 = this;
            r6 = r8
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.1n r5 = new com.facebook.ads.redexgen.X.1n
            r5.<init>()
            com.facebook.ads.redexgen.X.EV r4 = new com.facebook.ads.redexgen.X.EV
            com.facebook.ads.redexgen.X.Ec r0 = r6.A04
            r4.<init>(r0)
            com.facebook.ads.redexgen.X.2t r3 = new com.facebook.ads.redexgen.X.2t
            com.facebook.ads.redexgen.X.2I r7 = r6.A03
            r2 = 44
            r1 = 14
            r0 = 76
            java.lang.String r0 = A01(r2, r1, r0)
            r3.<init>(r6, r7, r0, r4)
            boolean r0 = r3.A08()
            if (r0 == 0) goto L58
            r0 = 2
        L28:
            switch(r0) {
                case 2: goto L2c;
                case 3: goto L5a;
                case 4: goto L4b;
                default: goto L2b;
            }
        L2b:
            goto L28
        L2c:
            com.facebook.ads.redexgen.X.1p r6 = (com.facebook.ads.redexgen.X.C00441p) r6
            com.facebook.ads.redexgen.X.EV r4 = (com.facebook.ads.redexgen.X.EV) r4
            com.facebook.ads.redexgen.X.2t r3 = (com.facebook.ads.redexgen.X.C00742t) r3
            com.facebook.ads.redexgen.X.Gv r2 = new com.facebook.ads.redexgen.X.Gv
            com.facebook.ads.redexgen.X.2I r0 = r6.A03
            java.lang.String r1 = r0.A0P()
            com.facebook.ads.redexgen.X.Ec r0 = r6.A04
            com.facebook.ads.redexgen.X.Gl r0 = r0.A05()
            r2.<init>(r1, r0)
            r4.A0W(r2)
            r3.A07()
            r0 = 3
            goto L28
        L4b:
            com.facebook.ads.redexgen.X.1p r6 = (com.facebook.ads.redexgen.X.C00441p) r6
            com.facebook.ads.redexgen.X.1n r5 = (com.facebook.ads.redexgen.X.C00421n) r5
            com.facebook.ads.redexgen.X.Ec r1 = r6.A04
            com.facebook.ads.redexgen.X.2I r0 = r6.A03
            com.facebook.ads.redexgen.X.C00802z.A02(r1, r0, r9, r5)
            r0 = 3
            goto L28
        L58:
            r0 = 4
            goto L28
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00441p.A08(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A09(final boolean r12) {
        /*
            r11 = this;
            r10 = r11
            r9 = 0
            r0 = 0
            r0 = 0
            r8 = 0
            com.facebook.ads.redexgen.X.EV r7 = new com.facebook.ads.redexgen.X.EV
            com.facebook.ads.redexgen.X.Ec r0 = r10.A04
            r7.<init>(r0)
            com.facebook.ads.redexgen.X.Gv r0 = r10.A05
            r7.A0W(r0)
            com.facebook.ads.redexgen.X.2t r6 = new com.facebook.ads.redexgen.X.2t
            com.facebook.ads.redexgen.X.2I r3 = r10.A03
            r2 = 44
            r1 = 14
            r0 = 76
            java.lang.String r0 = A01(r2, r1, r0)
            r6.<init>(r10, r3, r0, r7)
            boolean r0 = r6.A08()
            if (r0 == 0) goto L86
            r0 = 2
        L29:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L88;
                case 4: goto L34;
                case 5: goto L51;
                case 6: goto L5e;
                default: goto L2c;
            }
        L2c:
            goto L29
        L2d:
            com.facebook.ads.redexgen.X.2t r6 = (com.facebook.ads.redexgen.X.C00742t) r6
            r6.A07()
            r0 = 3
            goto L29
        L34:
            com.facebook.ads.redexgen.X.1p r10 = (com.facebook.ads.redexgen.X.C00441p) r10
            com.facebook.ads.redexgen.X.2I r9 = r10.A03
            com.facebook.ads.redexgen.X.2h r9 = (com.facebook.ads.redexgen.X.C00622h) r9
            r8 = r10
            com.facebook.ads.redexgen.X.2L r0 = r9.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            java.lang.String r0 = r0.A07()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L4f
            r0 = 5
            goto L29
        L4f:
            r0 = 6
            goto L29
        L51:
            com.facebook.ads.redexgen.X.1p r10 = (com.facebook.ads.redexgen.X.C00441p) r10
            com.facebook.ads.redexgen.X.1p r8 = (com.facebook.ads.redexgen.X.C00441p) r8
            com.facebook.ads.redexgen.X.26 r1 = r10.A01
            com.facebook.ads.AdError r0 = com.facebook.ads.AdError.INTERNAL_ERROR
            r1.A7V(r8, r0)
            r0 = 3
            goto L29
        L5e:
            com.facebook.ads.redexgen.X.1p r10 = (com.facebook.ads.redexgen.X.C00441p) r10
            com.facebook.ads.redexgen.X.EV r7 = (com.facebook.ads.redexgen.X.EV) r7
            com.facebook.ads.redexgen.X.2h r9 = (com.facebook.ads.redexgen.X.C00622h) r9
            com.facebook.ads.redexgen.X.1p r8 = (com.facebook.ads.redexgen.X.C00441p) r8
            com.facebook.ads.redexgen.X.AnonymousClass30.A02(r7, r9)
            com.facebook.ads.redexgen.X.1l r5 = new com.facebook.ads.redexgen.X.1l
            r5.<init>(r12)
            com.facebook.ads.redexgen.X.EP r4 = new com.facebook.ads.redexgen.X.EP
            java.lang.String r3 = r9.A0T()
            r2 = 44
            r1 = 14
            r0 = 76
            java.lang.String r0 = A01(r2, r1, r0)
            r4.<init>(r3, r0)
            r7.A0P(r5, r4)
            r0 = 3
            goto L29
        L86:
            r0 = 4
            goto L29
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00441p.A09(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC00431o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0A() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.2I r0 = r2.A03
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
            r1 = -1
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.1p r2 = (com.facebook.ads.redexgen.X.C00441p) r2
            com.facebook.ads.redexgen.X.2I r0 = r2.A03
            int r1 = r0.A0I()
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00441p.A0A():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00eb, code lost:            return r6;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC00431o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0B() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00441p.A0B():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0122, code lost:            r3 = r3;        r3.A02 = new com.facebook.ads.redexgen.X.AnonymousClass27(r3.A0A, r3, r9);        r3.A03();        r3.A07(r11);     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0135, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0C(com.facebook.ads.redexgen.X.C0362Ec r8, com.facebook.ads.redexgen.X.AnonymousClass26 r9, java.util.Map<java.lang.String, java.lang.Object> r10, boolean r11, @android.support.annotation.Nullable java.lang.String r12, @android.support.annotation.Nullable java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00441p.A0C(com.facebook.ads.redexgen.X.Ec, com.facebook.ads.redexgen.X.26, java.util.Map, boolean, java.lang.String, java.lang.String):void");
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final String A4V() {
        return this.A03.A0P();
    }

    @Override // com.facebook.ads.redexgen.X.C1M
    public final void A6H() {
        this.A0B.set(true);
        this.A01.A7S(this);
    }

    @Override // com.facebook.ads.redexgen.X.C1M
    public final void A6I() {
        this.A01.A7V(this, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final void onDestroy() {
        A04();
    }
}
