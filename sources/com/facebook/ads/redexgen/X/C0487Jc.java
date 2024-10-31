package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;

/* renamed from: com.facebook.ads.redexgen.X.Jc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0487Jc {
    public static byte[] A00;
    public static final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0487Jc.A00
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
            r0 = r0 ^ 42
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0487Jc.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{16, 28, 30, 93, 21, 18, 16, 22, 17, 28, 28, 24, 93, 1, 22, 18, 16, 7, 93, 33, 22, 18, 16, 7, 50, 16, 7, 26, 5, 26, 7, 10, 88, 84, 86, 21, 78, 85, 82, 79, 66, 8, 95, 21, 75, 87, 90, 66, 94, 73, 21, 110, 85, 82, 79, 66, 107, 87, 90, 66, 94, 73, 122, 88, 79, 82, 77, 82, 79, 66, 30, 36, 119, 2, 57, 62, 35, 46, 119, 54, 39, 39, 109, 119, 101, 71, 72, 1, 82, 6, 66, 67, 82, 67, 84, 75, 79, 72, 67, 6, 79, 64, 6, 71, 86, 86, 6, 79, 85, 6, 115, 72, 79, 82, 95, 8};
    }

    static {
        A01();
        A01 = C0487Jc.class.getSimpleName();
    }

    @SuppressLint({"CatchGeneralException"})
    public static boolean A02() {
        try {
            Class.forName(A00(0, 32, 89));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean A03() {
        try {
            Class.forName(A00(32, 38, 17));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0019, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A04(int r3, int r4) {
        /*
            r2 = 0
            r0 = 0
            r1 = 640(0x280, float:8.97E-43)
            if (r3 < r1) goto L17
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L11;
                case 4: goto L19;
                case 5: goto L14;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            if (r4 < r1) goto Lf
            r0 = 3
            goto L7
        Lf:
            r0 = 5
            goto L7
        L11:
            r2 = 1
            r0 = 4
            goto L7
        L14:
            r2 = 0
            r0 = 4
            goto L7
        L17:
            r0 = 5
            goto L7
        L19:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0487Jc.A04(int, int):boolean");
    }

    public static boolean A05(Context context) {
        boolean activityDeclared = true;
        boolean z = false;
        try {
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (A00(32, 38, 17).equals(activityInfo.name)) {
                        z = true;
                    }
                }
            }
            if (!z && !A03()) {
                activityDeclared = false;
            }
            if (BuildConfigApi.isDebug()) {
                String str = A00(70, 14, 125) + activityDeclared;
                return activityDeclared;
            }
            return activityDeclared;
        } catch (Throwable th) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A01, A00(84, 32, 12), th);
            }
            return false;
        }
    }
}
