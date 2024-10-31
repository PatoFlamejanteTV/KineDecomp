package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.util.Log;
import javax.annotation.Nullable;

/* loaded from: assets/audience_network.dex */
public final class D1 extends C0279Ax {
    public static byte[] A07;
    public static final String A08;
    public final Context A00;

    @Nullable
    public final PackageInfo A01;

    @Nullable
    public final PackageManager A02;
    public final AA A03;

    @Nullable
    public final ActivityInfo[] A04;

    @Nullable
    public final ServiceInfo[] A05;

    @Nullable
    public final String[] A06;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.D1.A07
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
            int r0 = r0 + (-71)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D1.A06(int, int, int):java.lang.String");
    }

    public static void A07() {
        A07 = new byte[]{-35, -7, 3, 3, -7, -2, -9, -80, -32, -15, -13, -5, -15, -9, -11, -80, -32, -11, 2, -3, -7, 3, 3, -7, -1, -2, 3};
    }

    static {
        A07();
        A08 = D1.class.getSimpleName();
    }

    public D1(Context context, AA aa) {
        super(context, aa);
        this.A00 = context;
        this.A03 = aa;
        this.A01 = A02(context);
        this.A02 = context.getPackageManager();
        this.A04 = A08(context);
        this.A05 = A0A(context);
        this.A06 = A0C(context);
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private PackageInfo A02(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(A08, A06(0, 27, 73), e);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private ActivityInfo[] A08(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(A08, A06(0, 27, 73), e);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private ServiceInfo[] A0A(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(A08, A06(0, 27, 73), e);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private String[] A0C(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(A08, A06(0, 27, 73), e);
            return null;
        }
    }

    public final InterfaceC0267Al A0G() {
        return new C0333Cz(this);
    }

    public final InterfaceC0267Al A0H() {
        return new C0332Cy(this);
    }

    public final InterfaceC0267Al A0I() {
        return new D0(this);
    }

    public final InterfaceC0267Al A0J() {
        return new C0331Cx(this);
    }

    public final InterfaceC0267Al A0K() {
        return new C0326Cs(this);
    }

    public final InterfaceC0267Al A0L() {
        return new C0322Co(this);
    }

    public final InterfaceC0267Al A0M() {
        return new C0327Ct(this);
    }

    public final InterfaceC0267Al A0N() {
        return new C0330Cw(this);
    }

    public final InterfaceC0267Al A0O() {
        return new C0328Cu(this);
    }

    public final InterfaceC0267Al A0P() {
        return new C0329Cv(this);
    }

    public final InterfaceC0267Al A0Q() {
        return new C0325Cr(this);
    }

    public final InterfaceC0267Al A0R() {
        return new C0324Cq(this);
    }

    public final InterfaceC0267Al A0S() {
        return new C0323Cp(this);
    }

    public final InterfaceC0267Al A0T() {
        return new C0320Cm(this);
    }

    public final InterfaceC0267Al A0U() {
        return new C0319Cl(this);
    }

    public final InterfaceC0267Al A0V() {
        return new C0321Cn(this);
    }

    public final InterfaceC0267Al A0W() {
        return new C0317Cj(this);
    }

    public final InterfaceC0267Al A0X() {
        return new C0316Ci(this);
    }

    public final InterfaceC0267Al A0Y() {
        return new C0318Ck(this);
    }
}
