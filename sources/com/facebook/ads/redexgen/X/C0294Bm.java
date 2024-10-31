package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Bm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0294Bm extends C0279Ax {
    public static byte[] A01;

    @Nullable
    public final BluetoothAdapter A00;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0294Bm.A01
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
            int r0 = r0 + (-122)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0294Bm.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A01 = new byte[]{90, 103, 93, 107, 104, 98, 93, 39, 105, 94, 107, 102, 98, 108, 108, 98, 104, 103, 39, 59, 69, 78, 62, 77, 72, 72, 77, 65};
    }

    public C0294Bm(Context context, AA aa) {
        super(context, aa);
        this.A00 = A04(context) ? BluetoothAdapter.getDefaultAdapter() : null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A04(android.content.Context r4) {
        /*
            r3 = 0
            r2 = 0
            r1 = 28
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r2 = A02(r2, r1, r0)
            int r1 = android.os.Process.myPid()
            int r0 = android.os.Process.myUid()
            int r0 = r4.checkPermission(r2, r1, r0)
            if (r0 != 0) goto L23
            r0 = 2
        L19:
            switch(r0) {
                case 2: goto L1d;
                case 3: goto L25;
                case 4: goto L20;
                default: goto L1c;
            }
        L1c:
            goto L19
        L1d:
            r3 = 1
            r0 = 3
            goto L19
        L20:
            r3 = 0
            r0 = 3
            goto L19
        L23:
            r0 = 4
            goto L19
        L25:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0294Bm.A04(android.content.Context):boolean");
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final InterfaceC0267Al A0G() {
        return new C0289Bh(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final InterfaceC0267Al A0H() {
        return new C0290Bi(this);
    }

    @SuppressLint({"MissingPermission"})
    public final InterfaceC0267Al A0I() {
        return new C0291Bj(this);
    }
}
