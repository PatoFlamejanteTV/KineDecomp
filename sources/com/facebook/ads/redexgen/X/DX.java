package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;

/* loaded from: assets/audience_network.dex */
public final class DX extends C0279Ax {
    public static byte[] A01;
    public final TelephonyManager A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.DX.A01
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
            r0 = r0 ^ 89
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DX.A04(int, int, int):java.lang.String");
    }

    public static void A05() {
        A01 = new byte[]{63, 39, 32, 33, 42};
    }

    public DX(Context context, AA aa) {
        super(context, aa);
        this.A00 = (TelephonyManager) context.getSystemService(A04(0, 5, 22));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0004. Please report as an issue. */
    public static int A01(CellInfo cellInfo) {
        int i = 0;
        char c = cellInfo == null ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new NullPointerException();
                case 3:
                    c = Build.VERSION.SDK_INT >= 18 ? (char) 4 : (char) 14;
                case 4:
                    cellInfo = cellInfo;
                    c = cellInfo instanceof CellInfoCdma ? (char) 5 : (char) 7;
                case 5:
                    cellInfo = cellInfo;
                    i = ((CellInfoCdma) cellInfo).getCellSignalStrength().getLevel();
                    c = 6;
                case 6:
                    return i;
                case 7:
                    cellInfo = cellInfo;
                    c = cellInfo instanceof CellInfoGsm ? '\b' : '\t';
                case '\b':
                    cellInfo = cellInfo;
                    i = ((CellInfoGsm) cellInfo).getCellSignalStrength().getLevel();
                    c = 6;
                case '\t':
                    cellInfo = cellInfo;
                    c = cellInfo instanceof CellInfoLte ? '\n' : (char) 11;
                case '\n':
                    cellInfo = cellInfo;
                    i = ((CellInfoLte) cellInfo).getCellSignalStrength().getLevel();
                    c = 6;
                case 11:
                    cellInfo = cellInfo;
                    c = cellInfo instanceof CellInfoWcdma ? '\f' : '\r';
                case '\f':
                    cellInfo = cellInfo;
                    i = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getLevel();
                    c = 6;
                case '\r':
                    throw new UnsupportedOperationException(cellInfo.getClass().getSimpleName());
                case 14:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public final InterfaceC0267Al A0G() {
        return new DN(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final InterfaceC0267Al A0H() {
        return new DO(this);
    }

    public final InterfaceC0267Al A0I() {
        return new DS(this);
    }

    public final InterfaceC0267Al A0J() {
        return new DT(this);
    }

    public final InterfaceC0267Al A0K() {
        return new DR(this);
    }

    public final InterfaceC0267Al A0L() {
        return new DQ(this);
    }

    public final InterfaceC0267Al A0M() {
        return new DW(this);
    }

    public final InterfaceC0267Al A0N() {
        return new DK(this);
    }

    public final InterfaceC0267Al A0O() {
        return new DU(this);
    }

    public final InterfaceC0267Al A0P() {
        return new DV(this);
    }

    public final InterfaceC0267Al A0Q() {
        return new DL(this);
    }

    public final InterfaceC0267Al A0R() {
        return new DM(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final InterfaceC0267Al A0S() {
        return new DP(this);
    }
}
