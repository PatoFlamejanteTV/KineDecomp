package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;

/* loaded from: assets/audience_network.dex */
public final class KG {
    public static byte[] A00;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.KG.A00
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
            int r0 = r0 + (-84)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KG.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A00 = new byte[]{-13, 0, -10, 4, 1, -5, -10, -64, 1, 5, -64, -45, 5, 11, 0, -11, -26, -13, 5, -3};
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:            return (android.os.AsyncTask) r3;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.os.AsyncTask<P, PR, R>] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.os.AsyncTask] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.os.AsyncTask] */
    /* JADX WARN: Type inference failed for: r4v0, types: [P[]] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <P, PR, R> android.os.AsyncTask<P, PR, R> A00(java.util.concurrent.Executor r2, android.os.AsyncTask<P, PR, R> r3, P... r4) {
        /*
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 11
            if (r1 < r0) goto L1f
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L21;
                case 4: goto L16;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            android.os.AsyncTask r3 = (android.os.AsyncTask) r3
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            r3.executeOnExecutor(r2, r4)
            r0 = 3
            goto L7
        L16:
            android.os.AsyncTask r3 = (android.os.AsyncTask) r3
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            r3.execute(r4)
            r0 = 3
            goto L7
        L1f:
            r0 = 4
            goto L7
        L21:
            android.os.AsyncTask r3 = (android.os.AsyncTask) r3
            android.os.AsyncTask r3 = (android.os.AsyncTask) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KG.A00(java.util.concurrent.Executor, android.os.AsyncTask, java.lang.Object[]):android.os.AsyncTask");
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A02() {
        try {
            Class.forName(A01(0, 20, 62));
        } catch (Throwable unused) {
        }
    }
}
