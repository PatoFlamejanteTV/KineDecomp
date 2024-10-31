package com.facebook.ads.redexgen.X;

import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.lang.Thread;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class F4 implements Thread.UncaughtExceptionHandler {
    public static byte[] A05;
    public final C0365Ef A00;
    public final F3 A01;
    public final FA A02;
    public final Thread.UncaughtExceptionHandler A03;
    public final Map<String, String> A04;

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
            byte[] r1 = com.facebook.ads.redexgen.X.F4.A05
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
            int r0 = r0 + (-59)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.F4.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A05 = new byte[]{-33, 113, -35, -33, -52, -34, -29, -38, -49, 34, 36, 17, 35, 40, 31, 20, 14, 18, 30, 19, 20, -31, -16, -33, -15, -26, -18, -6, -8, -71, -15, -20, -18, -16, -19, -6, -6, -10, -71, -20, -17, -2, -116, -88, -78, -78, -88, -83, -90, 95, -126, -82, -83, -77, -92, -73, -77};
    }

    public F4(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C0365Ef c0365Ef, F3 f3) {
        this(uncaughtExceptionHandler, c0365Ef, f3, FC.A00());
    }

    public F4(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C0365Ef c0365Ef, F3 f3, FA fa) {
        this.A03 = uncaughtExceptionHandler;
        if (c0365Ef == null) {
            throw new IllegalArgumentException(A00(42, 15, 4));
        }
        this.A00 = c0365Ef;
        this.A04 = f3.A4w(c0365Ef);
        this.A01 = f3;
        this.A02 = fa;
    }

    public static void A02() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
        try {
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A03(java.lang.Thread r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            r1 = r2
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.A03
            if (r0 == 0) goto L1c
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1e;
                case 4: goto L17;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.F4 r1 = (com.facebook.ads.redexgen.X.F4) r1
            java.lang.Thread r3 = (java.lang.Thread) r3
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.A03
            r0.uncaughtException(r3, r4)
            r0 = 3
            goto L6
        L17:
            A02()
            r0 = 3
            goto L6
        L1c:
            r0 = 4
            goto L6
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.F4.A03(java.lang.Thread, java.lang.Throwable):void");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        F2 f2;
        try {
            String stackTraceString = C0504Ju.A03(this.A00, th);
            if (!TextUtils.isEmpty(stackTraceString) && stackTraceString.contains(A00(26, 16, 80))) {
                Map<String, String> A4O = this.A01.A4O();
                if (A4O != null) {
                    f2 = new F2(stackTraceString, A4O);
                } else {
                    f2 = new F2(stackTraceString, this.A04);
                }
                Map<String, String> A02 = f2.A02();
                A02.put(A00(2, 7, 47), A00(21, 5, 67));
                if (AbstractRunnableC00491u.A00() == th) {
                    A02.put(A00(9, 12, 116), A00(0, 1, 115));
                } else {
                    A02.put(A00(9, 12, 116), A00(1, 1, 6));
                }
                this.A02.A8n(new FD(this.A00.A04().A01(), this.A00.A04().A02(), A02), this.A00);
                if (C0413Gc.A0t(this.A00)) {
                    C0413Gc.A0R(this.A00);
                }
            }
        } catch (Exception unused) {
        }
        A03(thread, th);
    }
}
