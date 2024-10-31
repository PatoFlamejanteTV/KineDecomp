package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ax, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0279Ax {
    public static byte[] A03;
    public final Context A00;
    public final Intent A01;
    public final AA A02;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0279Ax.A03
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
            int r0 = r0 + (-112)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0279Ax.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A03 = new byte[]{17, 30, 20, 34, 31, 25, 20, -34, 25, 30, 36, 21, 30, 36, -34, 17, 19, 36, 25, 31, 30, -34, -14, -15, 4, 4, -11, 2, 9, 15, -13, -8, -15, -2, -9, -11, -12};
    }

    public C0279Ax(Context context, AA aa) {
        this.A00 = context;
        this.A02 = aa;
        this.A01 = this.A00.registerReceiver(null, new IntentFilter(A00(0, 37, 64)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:            return r3;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.E7 A02() {
        /*
            r5 = this;
            r4 = r5
            r2 = 0
            r3 = 0
            com.facebook.ads.redexgen.X.AA r0 = r4.A02
            com.facebook.ads.redexgen.X.Dp r1 = r0.A0a()
            com.facebook.ads.redexgen.X.Dp r0 = com.facebook.ads.redexgen.X.EnumC0349Dp.A0F
            if (r1 != r0) goto L3d
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L30;
                case 3: goto L3f;
                case 4: goto L26;
                case 5: goto L1b;
                case 6: goto L12;
                case 7: goto L33;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.lang.String r2 = (java.lang.String) r2
            com.facebook.ads.redexgen.X.E7 r3 = new com.facebook.ads.redexgen.X.E7
            r3.<init>(r2)
            r0 = 3
            goto Le
        L1b:
            r2 = 37
            r1 = 0
            r0 = 115(0x73, float:1.61E-43)
            java.lang.String r2 = A00(r2, r1, r0)
            r0 = 6
            goto Le
        L26:
            com.facebook.ads.redexgen.X.Ax r4 = (com.facebook.ads.redexgen.X.C0279Ax) r4
            android.content.Context r0 = r4.A00
            if (r0 != 0) goto L2e
            r0 = 5
            goto Le
        L2e:
            r0 = 7
            goto Le
        L30:
            r3 = 0
            r0 = 3
            goto Le
        L33:
            com.facebook.ads.redexgen.X.Ax r4 = (com.facebook.ads.redexgen.X.C0279Ax) r4
            android.content.Context r0 = r4.A00
            java.lang.String r2 = r0.getPackageName()
            r0 = 6
            goto Le
        L3d:
            r0 = 4
            goto Le
        L3f:
            com.facebook.ads.redexgen.X.E7 r3 = (com.facebook.ads.redexgen.X.E7) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0279Ax.A02():com.facebook.ads.redexgen.X.E7");
    }

    public final AbstractC0351Dr A03(float f) {
        return new C0355Dv(SystemClock.elapsedRealtime(), A02(), f);
    }

    public final AbstractC0351Dr A04(int i) {
        return new C0357Dx(SystemClock.elapsedRealtime(), A02(), i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A05(int r8, java.util.HashMap<java.lang.String, java.lang.String> r9) {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r4 = 0
            r3 = 0
            android.content.Intent r0 = r6.A01
            if (r0 == 0) goto L61
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L50;
                case 3: goto L44;
                case 4: goto L21;
                case 5: goto L17;
                case 6: goto Ld;
                case 7: goto L63;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.Ax r6 = (com.facebook.ads.redexgen.X.C0279Ax) r6
            java.util.HashMap r5 = (java.util.HashMap) r5
            com.facebook.ads.redexgen.X.Dr r4 = r6.A0C(r5)
            r0 = 7
            goto L9
        L17:
            com.facebook.ads.redexgen.X.Ax r6 = (com.facebook.ads.redexgen.X.C0279Ax) r6
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            com.facebook.ads.redexgen.X.Dr r4 = r6.A07(r0)
            r0 = 7
            goto L9
        L21:
            com.facebook.ads.redexgen.X.Ax r6 = (com.facebook.ads.redexgen.X.C0279Ax) r6
            java.util.HashMap r9 = (java.util.HashMap) r9
            java.util.HashMap r5 = (java.util.HashMap) r5
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r2 = r3.next()
            java.lang.String r2 = (java.lang.String) r2
            android.content.Intent r1 = r6.A01
            java.lang.Object r0 = r9.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r1.getIntExtra(r0, r8)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5.put(r2, r0)
            r0 = 3
            goto L9
        L44:
            java.util.Iterator r3 = (java.util.Iterator) r3
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L4e
            r0 = 4
            goto L9
        L4e:
            r0 = 6
            goto L9
        L50:
            java.util.HashMap r9 = (java.util.HashMap) r9
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.Set r0 = r9.keySet()
            java.util.Iterator r3 = r0.iterator()
            r0 = 3
            goto L9
        L61:
            r0 = 5
            goto L9
        L63:
            com.facebook.ads.redexgen.X.Dr r4 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r4
            com.facebook.ads.redexgen.X.Dr r4 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0279Ax.A05(int, java.util.HashMap):com.facebook.ads.redexgen.X.Dr");
    }

    public final AbstractC0351Dr A06(long j) {
        return new E0(SystemClock.elapsedRealtime(), A02(), j);
    }

    public final AbstractC0351Dr A07(E5 e5) {
        return new C0354Du(SystemClock.elapsedRealtime(), A02(), new E6(e5));
    }

    public final AbstractC0351Dr A08(String str) {
        return new E9(SystemClock.elapsedRealtime(), A02(), str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A09(java.lang.String r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            android.content.Intent r0 = r2.A01
            if (r0 == 0) goto L25
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L27;
                case 4: goto L1b;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Ax r2 = (com.facebook.ads.redexgen.X.C0279Ax) r2
            java.lang.String r4 = (java.lang.String) r4
            android.content.Intent r0 = r2.A01
            java.lang.String r0 = r0.getStringExtra(r4)
            com.facebook.ads.redexgen.X.Dr r1 = r2.A08(r0)
            r0 = 3
            goto L7
        L1b:
            com.facebook.ads.redexgen.X.Ax r2 = (com.facebook.ads.redexgen.X.C0279Ax) r2
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            com.facebook.ads.redexgen.X.Dr r1 = r2.A07(r0)
            r0 = 3
            goto L7
        L25:
            r0 = 4
            goto L7
        L27:
            com.facebook.ads.redexgen.X.Dr r1 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r1
            com.facebook.ads.redexgen.X.Dr r1 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0279Ax.A09(java.lang.String):com.facebook.ads.redexgen.X.Dr");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A0A(java.lang.String r4, int r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            android.content.Intent r0 = r2.A01
            if (r0 == 0) goto L25
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L27;
                case 4: goto L1b;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Ax r2 = (com.facebook.ads.redexgen.X.C0279Ax) r2
            java.lang.String r4 = (java.lang.String) r4
            android.content.Intent r0 = r2.A01
            int r0 = r0.getIntExtra(r4, r5)
            com.facebook.ads.redexgen.X.Dr r1 = r2.A04(r0)
            r0 = 3
            goto L7
        L1b:
            com.facebook.ads.redexgen.X.Ax r2 = (com.facebook.ads.redexgen.X.C0279Ax) r2
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            com.facebook.ads.redexgen.X.Dr r1 = r2.A07(r0)
            r0 = 3
            goto L7
        L25:
            r0 = 4
            goto L7
        L27:
            com.facebook.ads.redexgen.X.Dr r1 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r1
            com.facebook.ads.redexgen.X.Dr r1 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0279Ax.A0A(java.lang.String, int):com.facebook.ads.redexgen.X.Dr");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A0B(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            android.content.Intent r0 = r2.A01
            if (r0 == 0) goto L25
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L27;
                case 4: goto L1b;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Ax r2 = (com.facebook.ads.redexgen.X.C0279Ax) r2
            java.lang.String r4 = (java.lang.String) r4
            android.content.Intent r0 = r2.A01
            boolean r0 = r0.getBooleanExtra(r4, r5)
            com.facebook.ads.redexgen.X.Dr r1 = r2.A0F(r0)
            r0 = 3
            goto L7
        L1b:
            com.facebook.ads.redexgen.X.Ax r2 = (com.facebook.ads.redexgen.X.C0279Ax) r2
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            com.facebook.ads.redexgen.X.Dr r1 = r2.A07(r0)
            r0 = 3
            goto L7
        L25:
            r0 = 4
            goto L7
        L27:
            com.facebook.ads.redexgen.X.Dr r1 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r1
            com.facebook.ads.redexgen.X.Dr r1 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0279Ax.A0B(java.lang.String, boolean):com.facebook.ads.redexgen.X.Dr");
    }

    public final AbstractC0351Dr A0C(HashMap<String, Integer> hashMap) {
        return new C0356Dw(SystemClock.elapsedRealtime(), A02(), hashMap);
    }

    public final AbstractC0351Dr A0D(List<InterfaceC0292Bk> list) {
        return new C0359Dz(SystemClock.elapsedRealtime(), A02(), list, E8.A03);
    }

    public final AbstractC0351Dr A0E(List<String> resultList) {
        return new C0359Dz(SystemClock.elapsedRealtime(), A02(), resultList, E8.A0C);
    }

    public final AbstractC0351Dr A0F(boolean z) {
        return new C0352Ds(SystemClock.elapsedRealtime(), A02(), z);
    }
}
