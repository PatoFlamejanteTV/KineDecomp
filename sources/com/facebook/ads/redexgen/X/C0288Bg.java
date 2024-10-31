package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.BatteryManager;
import java.util.HashMap;
import javax.inject.Singleton;

@Singleton
/* renamed from: com.facebook.ads.redexgen.X.Bg, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0288Bg extends C0279Ax {
    public static byte[] A01;
    public final BatteryManager A00;

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0288Bg.A01
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
            r0 = r0 ^ 26
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0288Bg.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{98, 107, 120, 107, 98, Byte.MAX_VALUE, 50, 55, 64, 110, 126, 124, 113, 120, 121, 122, 111, 111, 126, 105, 98, 118, 122, 117, 122, 124, 126, 105};
    }

    public C0288Bg(Context context, AA aa) {
        super(context, aa);
        this.A00 = (BatteryManager) context.getSystemService(A01(14, 14, 1));
    }

    public final InterfaceC0267Al A0G() {
        return new BY(this);
    }

    public final InterfaceC0267Al A0H() {
        return new C0286Be(this);
    }

    public final InterfaceC0267Al A0I() {
        HashMap hashMap = new HashMap();
        hashMap.put(A01(8, 1, 52), 2);
        hashMap.put(A01(5, 1, 4), 3);
        return new C0285Bd(this, hashMap);
    }

    public final InterfaceC0267Al A0J() {
        HashMap hashMap = new HashMap();
        hashMap.put(A01(7, 1, 65), A01(0, 5, 20));
        hashMap.put(A01(6, 1, 91), A01(9, 5, 7));
        return new BT(this, hashMap);
    }

    public final InterfaceC0267Al A0K() {
        return new C0283Bb(this);
    }

    public final InterfaceC0267Al A0L() {
        return new BW(this);
    }

    public final InterfaceC0267Al A0M() {
        return new BZ(this);
    }

    public final InterfaceC0267Al A0N() {
        return new C0287Bf(this);
    }

    public final InterfaceC0267Al A0O() {
        return new BX(this);
    }

    public final InterfaceC0267Al A0P() {
        return new BU(this);
    }

    public final InterfaceC0267Al A0Q() {
        return new C0282Ba(this);
    }

    public final InterfaceC0267Al A0R() {
        return new BV(this);
    }

    public final InterfaceC0267Al A0S() {
        return new C0284Bc(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A0T(int r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r1 >= r0) goto L39
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L3b;
                case 4: goto L17;
                case 5: goto L21;
                case 6: goto L2f;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.Bg r3 = (com.facebook.ads.redexgen.X.C0288Bg) r3
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A04
            com.facebook.ads.redexgen.X.Dr r2 = r3.A07(r0)
            r0 = 3
            goto L9
        L17:
            com.facebook.ads.redexgen.X.Bg r3 = (com.facebook.ads.redexgen.X.C0288Bg) r3
            android.os.BatteryManager r0 = r3.A00
            if (r0 == 0) goto L1f
            r0 = 5
            goto L9
        L1f:
            r0 = 6
            goto L9
        L21:
            com.facebook.ads.redexgen.X.Bg r3 = (com.facebook.ads.redexgen.X.C0288Bg) r3
            android.os.BatteryManager r0 = r3.A00
            int r0 = r0.getIntProperty(r5)
            com.facebook.ads.redexgen.X.Dr r2 = r3.A04(r0)
            r0 = 3
            goto L9
        L2f:
            com.facebook.ads.redexgen.X.Bg r3 = (com.facebook.ads.redexgen.X.C0288Bg) r3
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            com.facebook.ads.redexgen.X.Dr r2 = r3.A07(r0)
            r0 = 3
            goto L9
        L39:
            r0 = 4
            goto L9
        L3b:
            com.facebook.ads.redexgen.X.Dr r2 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r2
            com.facebook.ads.redexgen.X.Dr r2 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0288Bg.A0T(int):com.facebook.ads.redexgen.X.Dr");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0083, code lost:            return r6;     */
    @android.annotation.SuppressLint({"Nullable Dereference"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A0U(java.util.HashMap<java.lang.String, java.lang.Integer> r8) {
        /*
            r7 = this;
            r4 = r7
            r5 = 0
            r3 = 0
            r6 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r1 >= r0) goto L7d
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L38;
                case 3: goto L7f;
                case 4: goto L20;
                case 5: goto Lf;
                case 6: goto L2b;
                case 7: goto L42;
                case 8: goto L69;
                case 9: goto L73;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            java.util.HashMap r8 = (java.util.HashMap) r8
            java.util.Set r0 = r8.keySet()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Iterator r5 = r0.iterator()
            r0 = 6
            goto Lb
        L20:
            com.facebook.ads.redexgen.X.Bg r4 = (com.facebook.ads.redexgen.X.C0288Bg) r4
            android.os.BatteryManager r0 = r4.A00
            if (r0 == 0) goto L28
            r0 = 5
            goto Lb
        L28:
            r0 = 9
            goto Lb
        L2b:
            java.util.Iterator r5 = (java.util.Iterator) r5
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L35
            r0 = 7
            goto Lb
        L35:
            r0 = 8
            goto Lb
        L38:
            com.facebook.ads.redexgen.X.Bg r4 = (com.facebook.ads.redexgen.X.C0288Bg) r4
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A04
            com.facebook.ads.redexgen.X.Dr r6 = r4.A07(r0)
            r0 = 3
            goto Lb
        L42:
            com.facebook.ads.redexgen.X.Bg r4 = (com.facebook.ads.redexgen.X.C0288Bg) r4
            java.util.HashMap r8 = (java.util.HashMap) r8
            java.util.HashMap r3 = (java.util.HashMap) r3
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r2 = r5.next()
            java.lang.String r2 = (java.lang.String) r2
            android.os.BatteryManager r1 = r4.A00
            java.lang.Object r0 = r8.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = r1.getIntProperty(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3.put(r2, r0)
            r0 = 6
            goto Lb
        L69:
            com.facebook.ads.redexgen.X.Bg r4 = (com.facebook.ads.redexgen.X.C0288Bg) r4
            java.util.HashMap r3 = (java.util.HashMap) r3
            com.facebook.ads.redexgen.X.Dr r6 = r4.A0C(r3)
            r0 = 3
            goto Lb
        L73:
            com.facebook.ads.redexgen.X.Bg r4 = (com.facebook.ads.redexgen.X.C0288Bg) r4
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            com.facebook.ads.redexgen.X.Dr r6 = r4.A07(r0)
            r0 = 3
            goto Lb
        L7d:
            r0 = 4
            goto Lb
        L7f:
            com.facebook.ads.redexgen.X.Dr r6 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r6
            com.facebook.ads.redexgen.X.Dr r6 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0288Bg.A0U(java.util.HashMap):com.facebook.ads.redexgen.X.Dr");
    }
}
