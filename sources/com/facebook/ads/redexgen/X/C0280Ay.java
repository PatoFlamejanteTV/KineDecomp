package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Ay, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0280Ay extends C0279Ax {
    public static byte[] A04;

    @Nullable
    public ConfigurationInfo A00;
    public final ActivityManager.RunningAppProcessInfo A01;
    public final ActivityManager A02;
    public final Context A03;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0280Ay.A04
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
            int r0 = r0 + (-78)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0280Ay.A04(int, int, int):java.lang.String");
    }

    public static void A05() {
        A04 = new byte[]{-53, -51, -34, -45, -32, -45, -34, -29};
    }

    public C0280Ay(Context context, AA aa) {
        super(context, aa);
        this.A03 = context;
        this.A02 = (ActivityManager) this.A03.getSystemService(A04(0, 8, 28));
        if (this.A02 != null) {
            this.A00 = this.A02.getDeviceConfigurationInfo();
        }
        this.A01 = new ActivityManager.RunningAppProcessInfo();
    }

    public final InterfaceC0267Al A0G() {
        return new C0276Au(this);
    }

    public final InterfaceC0267Al A0H() {
        return new C0277Av(this);
    }

    public final InterfaceC0267Al A0I() {
        return new C0272Aq(this);
    }

    public final InterfaceC0267Al A0J() {
        return new C0273Ar(this);
    }

    public final InterfaceC0267Al A0K() {
        return new C0274As(this);
    }

    public final InterfaceC0267Al A0L() {
        return new C0271Ap(this);
    }

    public final InterfaceC0267Al A0M() {
        return new C0275At(this);
    }

    public final InterfaceC0267Al A0N() {
        return new C0270Ao(this);
    }

    public final InterfaceC0267Al A0O() {
        return new C0278Aw(this);
    }

    public final InterfaceC0267Al A0P() {
        return new C0268Am(this);
    }

    public final InterfaceC0267Al A0Q() {
        return new C0269An(this);
    }
}
