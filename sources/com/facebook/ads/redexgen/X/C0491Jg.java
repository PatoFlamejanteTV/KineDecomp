package com.facebook.ads.redexgen.X;

import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.Jg, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0491Jg {
    public static byte[] A02;
    public long A00;
    public long A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0491Jg.A02
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
            int r0 = r0 + (-23)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0491Jg.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{-49, -12, -4, -25, -14, -17, -22, -90, -12, -5, -13, -24, -21, -8, -90, -11, -20, -90, -12, -25, -12, -11, -7, -21, -23, -11, -12, -22, -7, -90, -20, -11, -8, -90, -6, -18, -21, -90, -6, -17, -13, -21, -8, -64, -90, -85, -22};
    }

    public C0491Jg(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(0, 47, 111), Long.valueOf(j)));
        }
        this.A00 = System.nanoTime() + j;
        this.A01 = j;
    }

    public final synchronized void A02() {
        this.A00 = System.nanoTime();
        notifyAll();
    }

    public final synchronized void A03() {
        this.A00 = System.nanoTime() + this.A01;
    }

    public final synchronized void A04() throws InterruptedException {
        while (!A05()) {
            long min = Math.min(this.A00 - System.nanoTime(), 1L);
            wait(min / 1000000000, (int) (min % 1000000000));
        }
    }

    public final synchronized boolean A05() {
        return System.nanoTime() >= this.A00;
    }
}
