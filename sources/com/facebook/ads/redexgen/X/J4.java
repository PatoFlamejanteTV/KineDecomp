package com.facebook.ads.redexgen.X;

import android.os.AsyncTask;

/* loaded from: assets/audience_network.dex */
public final class J4 extends AsyncTask<J5, Void, JA> implements InterfaceC0484Iz {
    public static byte[] A03;
    public C0483Iy A00;
    public IL A01;
    public Exception A02;

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.J4.A03
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
            int r0 = r0 + (-58)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.J4.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A03 = new byte[]{-100, -57, -96, -52, -52, -56, -86, -67, -55, -51, -67, -53, -52, -84, -71, -53, -61, 120, -52, -71, -61, -67, -53, 120, -67, -48, -71, -69, -52, -60, -47, 120, -57, -58, -67, 120, -71, -54, -65, -51, -59, -67, -58, -52, 120, -57, -66, 120, -52, -47, -56, -67, 120, -96, -52, -52, -56, -86, -67, -55, -51, -67, -53, -52};
    }

    public J4(C0483Iy c0483Iy, IL il) {
        this.A00 = c0483Iy;
        this.A01 = il;
    }

    private final JA A00(J5... j5Arr) {
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            if (j5Arr != null) {
                try {
                    if (j5Arr.length > 0) {
                        return this.A00.A0J(j5Arr[0]);
                    }
                } catch (Exception e) {
                    this.A02 = e;
                    cancel(true);
                    return null;
                }
            }
            throw new IllegalArgumentException(A01(0, 64, 30));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return null;
        }
    }

    private final void A03(JA ja) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A01.A03(ja);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0484Iz
    public final void A42(J5 j5) {
        super.executeOnExecutor(KJ.A01(), j5);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ JA doInBackground(J5[] j5Arr) {
        JA ja = null;
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            ja = A00(j5Arr);
            return ja;
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return ja;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        this.A01.A04(this.A02);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(JA ja) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A03(ja);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
