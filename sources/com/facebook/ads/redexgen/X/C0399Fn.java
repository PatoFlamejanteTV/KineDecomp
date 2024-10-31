package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Fn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0399Fn {
    public static byte[] A01;
    public static final String A02;
    public final C0361Eb A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0399Fn.A01
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
            r0 = r0 ^ 50
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0399Fn.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{87, 79, 72, 73, 66, 48, 63, 53, 35, 62, 56, 53, Byte.MAX_VALUE, 33, 52, 35, 60, 56, 34, 34, 56, 62, 63, Byte.MAX_VALUE, 19, 24, 31, 21, 14, 16, 18, 18, 20, 2, 2, 24, 19, 24, 29, 24, 5, 8, 14, 2, 20, 3, 7, 24, 18, 20, 124, 126, 117, 126, 105, 114, 120};
    }

    static {
        A01();
        A02 = Build.VERSION.RELEASE;
    }

    public C0399Fn(C0361Eb c0361Eb) {
        this.A00 = c0361Eb;
    }

    public final int A02() {
        return JS.A01(this.A00);
    }

    @SuppressLint({"CatchGeneralException"})
    public final int A03() {
        int i = 0;
        try {
            i = this.A00.getPackageManager().getPackageInfo(A06(), 0).versionCode;
            return i;
        } catch (Throwable th) {
            this.A00.A06().A5W(A00(50, 7, 41), C0512Kc.A0y, new C0514Ke(th));
            return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:            return (java.lang.String) r7;     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A04() {
        /*
            r8 = this;
            r6 = r8
            r7 = 0
            r5 = 0
            r0 = 0
            r0 = 0
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L18;
                case 10: goto La;
                case 12: goto L3b;
                case 15: goto L61;
                case 16: goto L6c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch: java.lang.Throwable -> L44
            int r0 = r5.length()     // Catch: java.lang.Throwable -> L44
            if (r0 <= 0) goto L15
            r0 = 12
            goto L6
        L15:
            r0 = 15
            goto L6
        L18:
            com.facebook.ads.redexgen.X.Fn r6 = (com.facebook.ads.redexgen.X.C0399Fn) r6     // Catch: java.lang.Throwable -> L44
            com.facebook.ads.redexgen.X.Eb r0 = r6.A00     // Catch: java.lang.Throwable -> L44
            android.content.pm.PackageManager r2 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = r6.A06()     // Catch: java.lang.Throwable -> L44
            r0 = 0
            android.content.pm.ApplicationInfo r1 = r2.getApplicationInfo(r1, r0)     // Catch: java.lang.Throwable -> L44
            com.facebook.ads.redexgen.X.Eb r0 = r6.A00     // Catch: java.lang.Throwable -> L44
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L44
            java.lang.CharSequence r5 = r0.getApplicationLabel(r1)     // Catch: java.lang.Throwable -> L44
            if (r5 == 0) goto L38
            r0 = 10
            goto L6
        L38:
            r0 = 15
            goto L6
        L3b:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch: java.lang.Throwable -> L44
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L44
            r0 = 16
            goto L6
        L44:
            r4 = move-exception
            com.facebook.ads.redexgen.X.Eb r0 = r6.A00
            com.facebook.ads.redexgen.X.Kf r3 = r0.A06()
            r2 = 50
            r1 = 7
            r0 = 41
            java.lang.String r2 = A00(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A0y
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r4)
            r3.A5W(r2, r1, r0)
            r0 = 15
            goto L6
        L61:
            r2 = 5
            r1 = 0
            r0 = 98
            java.lang.String r7 = A00(r2, r1, r0)
            r0 = 16
            goto L6
        L6c:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = (java.lang.String) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0399Fn.A04():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:            return r5;     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A05() {
        /*
            r7 = this;
            r6 = r7
            r0 = 0
            r0 = 0
            r5 = 0
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L14;
                case 9: goto L47;
                case 10: goto L53;
                case 11: goto L9;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            r2 = 5
            r1 = 0
            r0 = 98
            java.lang.String r5 = A00(r2, r1, r0)
            r0 = 10
            goto L5
        L14:
            com.facebook.ads.redexgen.X.Fn r6 = (com.facebook.ads.redexgen.X.C0399Fn) r6     // Catch: java.lang.Throwable -> L2a
            com.facebook.ads.redexgen.X.Eb r0 = r6.A00     // Catch: java.lang.Throwable -> L2a
            android.content.pm.PackageManager r2 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r1 = r6.A06()     // Catch: java.lang.Throwable -> L2a
            r0 = 0
            android.content.pm.PackageInfo r0 = r2.getPackageInfo(r1, r0)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r5 = r0.versionName     // Catch: java.lang.Throwable -> L2a
            r0 = 9
            goto L5
        L2a:
            r4 = move-exception
            com.facebook.ads.redexgen.X.Eb r0 = r6.A00
            com.facebook.ads.redexgen.X.Kf r3 = r0.A06()
            r2 = 50
            r1 = 7
            r0 = 41
            java.lang.String r2 = A00(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A0y
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r4)
            r3.A5l(r2, r1, r0)
            r0 = 9
            goto L5
        L47:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L50
            r0 = 10
            goto L5
        L50:
            r0 = 11
            goto L5
        L53:
            java.lang.String r5 = (java.lang.String) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0399Fn.A05():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A06() {
        /*
            r5 = this;
            r0 = 0
            r4 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.Eb r1 = r5.A00
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            android.app.PendingIntent r3 = android.app.PendingIntent.getActivity(r1, r2, r0, r2)
            if (r3 != 0) goto L39
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L15;
                case 3: goto L3b;
                case 4: goto L1f;
                case 5: goto L29;
                case 6: goto L31;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            r2 = 5
            r1 = 0
            r0 = 98
            java.lang.String r4 = A00(r2, r1, r0)
            r0 = 3
            goto L11
        L1f:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 17
            if (r1 < r0) goto L27
            r0 = 5
            goto L11
        L27:
            r0 = 6
            goto L11
        L29:
            android.app.PendingIntent r3 = (android.app.PendingIntent) r3
            java.lang.String r4 = r3.getCreatorPackage()
            r0 = 3
            goto L11
        L31:
            android.app.PendingIntent r3 = (android.app.PendingIntent) r3
            java.lang.String r4 = r3.getTargetPackage()
            r0 = 3
            goto L11
        L39:
            r0 = 4
            goto L11
        L3b:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = (java.lang.String) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0399Fn.A06():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A07() {
        /*
            r5 = this;
            r4 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Eb r3 = r5.A00
            r2 = 0
            r1 = 5
            r0 = 21
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r3 = r3.getSystemService(r0)
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3
            if (r3 == 0) goto L3b
            r0 = 2
        L15:
            switch(r0) {
                case 2: goto L19;
                case 3: goto L25;
                case 4: goto L3d;
                case 5: goto L31;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3
            java.lang.String r4 = r3.getNetworkOperatorName()
            if (r4 == 0) goto L23
            r0 = 3
            goto L15
        L23:
            r0 = 5
            goto L15
        L25:
            java.lang.String r4 = (java.lang.String) r4
            int r0 = r4.length()
            if (r0 <= 0) goto L2f
            r0 = 4
            goto L15
        L2f:
            r0 = 5
            goto L15
        L31:
            r2 = 5
            r1 = 0
            r0 = 98
            java.lang.String r4 = A00(r2, r1, r0)
            r0 = 4
            goto L15
        L3b:
            r0 = 5
            goto L15
        L3d:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = (java.lang.String) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0399Fn.A07():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A08() {
        /*
            r3 = this;
            r1 = 0
            java.lang.String r0 = android.os.Build.MANUFACTURER
            if (r0 == 0) goto L24
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L16;
                case 4: goto L26;
                case 5: goto L1a;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            java.lang.String r0 = android.os.Build.MANUFACTURER
            int r0 = r0.length()
            if (r0 <= 0) goto L14
            r0 = 3
            goto L6
        L14:
            r0 = 5
            goto L6
        L16:
            java.lang.String r1 = android.os.Build.MANUFACTURER
            r0 = 4
            goto L6
        L1a:
            r2 = 5
            r1 = 0
            r0 = 98
            java.lang.String r1 = A00(r2, r1, r0)
            r0 = 4
            goto L6
        L24:
            r0 = 5
            goto L6
        L26:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0399Fn.A08():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A09() {
        /*
            r3 = this;
            r1 = 0
            java.lang.String r0 = android.os.Build.MODEL
            if (r0 == 0) goto L24
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L16;
                case 4: goto L26;
                case 5: goto L1a;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            java.lang.String r0 = android.os.Build.MODEL
            int r0 = r0.length()
            if (r0 <= 0) goto L14
            r0 = 3
            goto L6
        L14:
            r0 = 5
            goto L6
        L16:
            java.lang.String r1 = android.os.Build.MODEL
            r0 = 4
            goto L6
        L1a:
            r2 = 5
            r1 = 0
            r0 = 98
            java.lang.String r1 = A00(r2, r1, r0)
            r0 = 4
            goto L6
        L24:
            r0 = 5
            goto L6
        L26:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0399Fn.A09():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0070, code lost:            return r7;     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A0A() {
        /*
            r8 = this;
            r6 = r8
            r7 = 0
            r5 = 0
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L7;
                case 4: goto L29;
                case 5: goto L7;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L7;
                case 9: goto L7;
                case 10: goto L36;
                case 11: goto L7;
                case 12: goto L7;
                case 13: goto L61;
                case 14: goto L6c;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.Fn r6 = (com.facebook.ads.redexgen.X.C0399Fn) r6     // Catch: java.lang.Throwable -> L44
            com.facebook.ads.redexgen.X.Eb r0 = r6.A00     // Catch: java.lang.Throwable -> L44
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L44
            java.lang.String r7 = r0.getInstallerPackageName(r5)     // Catch: java.lang.Throwable -> L44
            if (r7 == 0) goto L19
            r0 = 10
            goto L4
        L19:
            r0 = 13
            goto L4
        L1c:
            com.facebook.ads.redexgen.X.Fn r6 = (com.facebook.ads.redexgen.X.C0399Fn) r6     // Catch: java.lang.Throwable -> L44
            java.lang.String r5 = r6.A06()     // Catch: java.lang.Throwable -> L44
            if (r5 == 0) goto L26
            r0 = 4
            goto L4
        L26:
            r0 = 13
            goto L4
        L29:
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L44
            int r0 = r5.length()     // Catch: java.lang.Throwable -> L44
            if (r0 < 0) goto L33
            r0 = 6
            goto L4
        L33:
            r0 = 13
            goto L4
        L36:
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L44
            int r0 = r7.length()     // Catch: java.lang.Throwable -> L44
            if (r0 <= 0) goto L41
            r0 = 14
            goto L4
        L41:
            r0 = 13
            goto L4
        L44:
            r4 = move-exception
            com.facebook.ads.redexgen.X.Eb r0 = r6.A00
            com.facebook.ads.redexgen.X.Kf r3 = r0.A06()
            r2 = 50
            r1 = 7
            r0 = 41
            java.lang.String r2 = A00(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A0y
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r4)
            r3.A5l(r2, r1, r0)
            r0 = 13
            goto L4
        L61:
            r2 = 5
            r1 = 0
            r0 = 98
            java.lang.String r7 = A00(r2, r1, r0)
            r0 = 14
            goto L4
        L6c:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = (java.lang.String) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0399Fn.A0A():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0B() {
        /*
            r5 = this;
            r4 = 0
            com.facebook.ads.redexgen.X.Eb r3 = r5.A00
            r2 = 5
            r1 = 45
            r0 = 99
            java.lang.String r0 = A00(r2, r1, r0)
            int r0 = r3.checkCallingOrSelfPermission(r0)
            if (r0 != 0) goto L1d
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L1f;
                case 4: goto L1a;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r4 = 1
            r0 = 3
            goto L13
        L1a:
            r4 = 0
            r0 = 3
            goto L13
        L1d:
            r0 = 4
            goto L13
        L1f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0399Fn.A0B():boolean");
    }
}
