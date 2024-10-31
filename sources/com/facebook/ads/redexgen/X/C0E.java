package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.io.File;

/* renamed from: com.facebook.ads.redexgen.X.0E, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0E {
    public static byte[] A00;
    public static final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0E.A00
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
            r0 = r0 ^ 97
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0E.A03(int, int, int):java.lang.String");
    }

    public static void A04() {
        A00 = new byte[]{88, 90, 88, 83, 94, 88, 119, 125, 107, 118, 112, 125, 83, 5, 81, 86, 1, 31, 26, 26, 86, 20, 19, 86, 3, 5, 19, 18, 88, 45, 40, 61, 40, 63, 115, 113, 115, 120, 117, 63, 113, 83, 92, 21, 70, 18, 86, 87, 84, 91, 92, 87, 18, 65, 75, 65, 70, 87, 95, 18, 81, 83, 81, 90, 87, 18, 86, 91, 64, 87, 81, 70, 93, 64, 75, 19, 18, 21, 93, 22, 19, 6, 19, 93, 22, 19, 6, 19, 93, 87, 82, 88, 65, 27, 80, 95, 90, 83, 27, 85, 87, 85, 94, 83, 61, 63, 37, 62, 36, 53, 52, 5, 62, 49, 50, 60, 53, 112, 36, 63, 112, 51, 34, 53, 49, 36, 53, 112, 53, 40, 36, 53, 34, 62, 49, 60, 112, 51, 49, 51, 56, 53, 112, 52, 57, 34, 53, 51, 36, 63, 34, 41};
    }

    static {
        A04();
        A01 = C0E.class.getSimpleName();
    }

    public static File A00(Context context) {
        File cacheDir = A02(context, true);
        return new File(cacheDir, A03(89, 15, 87));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:            return r4;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File A01(android.content.Context r6) {
        /*
            r0 = 0
            java.io.File r5 = new java.io.File
            java.io.File r4 = new java.io.File
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            r2 = 5
            r1 = 7
            r0 = 120(0x78, float:1.68E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            r4.<init>(r3, r0)
            r2 = 29
            r1 = 4
            r0 = 40
            java.lang.String r0 = A03(r2, r1, r0)
            r5.<init>(r4, r0)
            java.io.File r4 = new java.io.File
            java.io.File r3 = new java.io.File
            java.lang.String r0 = r6.getPackageName()
            r3.<init>(r5, r0)
            r2 = 0
            r1 = 5
            r0 = 90
            java.lang.String r0 = A03(r2, r1, r0)
            r4.<init>(r3, r0)
            boolean r0 = r4.exists()
            if (r0 != 0) goto L5f
            r0 = 2
        L3d:
            switch(r0) {
                case 2: goto L41;
                case 3: goto L4d;
                case 4: goto L61;
                default: goto L40;
            }
        L40:
            goto L3d
        L41:
            java.io.File r4 = (java.io.File) r4
            boolean r0 = r4.mkdirs()
            if (r0 != 0) goto L4b
            r0 = 3
            goto L3d
        L4b:
            r0 = 4
            goto L3d
        L4d:
            java.lang.String r3 = com.facebook.ads.redexgen.X.C0E.A01
            r2 = 111(0x6f, float:1.56E-43)
            r1 = 41
            r0 = 49
            java.lang.String r0 = A03(r2, r1, r0)
            android.util.Log.w(r3, r0)
            r4 = 0
            r0 = 4
            goto L3d
        L5f:
            r0 = 4
            goto L3d
        L61:
            java.io.File r4 = (java.io.File) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0E.A01(android.content.Context):java.io.File");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00bf, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File A02(android.content.Context r7, boolean r8) {
        /*
            r0 = 0
            r6 = 0
            r3 = 0
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L25;
                case 3: goto L7;
                case 4: goto L7;
                case 5: goto L1e;
                case 6: goto L8;
                case 7: goto L36;
                case 8: goto L3f;
                case 9: goto L47;
                case 10: goto L50;
                case 11: goto L58;
                case 12: goto Lbd;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            java.lang.String r6 = (java.lang.String) r6
            r2 = 104(0x68, float:1.46E-43)
            r1 = 7
            r0 = 49
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L1b
            r0 = 7
            goto L4
        L1b:
            r0 = 8
            goto L4
        L1e:
            if (r8 == 0) goto L22
            r0 = 6
            goto L4
        L22:
            r0 = 8
            goto L4
        L25:
            java.lang.String r6 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.NullPointerException -> L2b
            r0 = 5
            goto L4
        L2b:
            r2 = 12
            r1 = 0
            r0 = 30
            java.lang.String r6 = A03(r2, r1, r0)
            r0 = 5
            goto L4
        L36:
            android.content.Context r7 = (android.content.Context) r7
            java.io.File r3 = A01(r7)
            r0 = 8
            goto L4
        L3f:
            if (r3 != 0) goto L44
            r0 = 9
            goto L4
        L44:
            r0 = 10
            goto L4
        L47:
            android.content.Context r7 = (android.content.Context) r7
            java.io.File r3 = r7.getCacheDir()
            r0 = 10
            goto L4
        L50:
            if (r3 != 0) goto L55
            r0 = 11
            goto L4
        L55:
            r0 = 12
            goto L4
        L58:
            android.content.Context r7 = (android.content.Context) r7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 78
            r1 = 11
            r0 = 19
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.String r0 = r7.getPackageName()
            java.lang.StringBuilder r3 = r1.append(r0)
            r2 = 33
            r1 = 7
            r0 = 113(0x71, float:1.58E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r5 = r0.toString()
            java.lang.String r4 = com.facebook.ads.redexgen.X.C0E.A01
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 40
            r1 = 38
            r0 = 83
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r3 = r0.append(r5)
            r2 = 12
            r1 = 17
            r0 = 23
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r4, r0)
            java.io.File r3 = new java.io.File
            r3.<init>(r5)
            r0 = 12
            goto L4
        Lbd:
            java.io.File r3 = (java.io.File) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0E.A02(android.content.Context, boolean):java.io.File");
    }
}
