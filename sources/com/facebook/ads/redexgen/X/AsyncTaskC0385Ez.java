package com.facebook.ads.redexgen.X;

import android.os.AsyncTask;
import java.util.Locale;
import java.util.concurrent.Executor;

/* renamed from: com.facebook.ads.redexgen.X.Ez, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class AsyncTaskC0385Ez extends AsyncTask<AbstractC0373En, Void, FN> implements F8 {
    public static byte[] A04;
    public InterfaceC0436Gz A00;
    public C01877h A01;
    public Exception A02;
    public Executor A03;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AsyncTaskC0385Ez.A04
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
            r0 = r0 ^ 87
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AsyncTaskC0385Ez.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A04 = new byte[]{16, 12, 12, 8, 120, 42, 61, 41, 45, 61, 43, 44, 120, 62, 57, 49, 52, 61, 60, 98, 120, 125, 43, 22, 42, 42, 46, 126, 44, 59, 45, 46, 49, 48, 45, 59, 126, 55, 45, 126, 48, 43, 50, 50, 64, 119, 97, 98, 125, 124, 97, 119, 40, 50, 55, 118, 50, 58, 55, 97, 59, 40, 24, 55, 97, 49, 26, 61, 1, 1, 5, 39, 16, 4, 0, 16, 6, 1, 33, 20, 6, 30, 85, 1, 20, 30, 16, 6, 85, 16, 13, 20, 22, 1, 25, 12, 85, 26, 27, 16, 85, 20, 7, 18, 0, 24, 16, 27, 1, 85, 26, 19, 85, 1, 12, 5, 16, 85, 61, 1, 1, 5, 39, 16, 4, 0, 16, 6, 1};
    }

    public AsyncTaskC0385Ez(C01877h c01877h, InterfaceC0436Gz interfaceC0436Gz, Executor executor) {
        this.A01 = c01877h;
        this.A00 = interfaceC0436Gz;
        this.A03 = executor;
    }

    private final FN A00(AbstractC0373En... abstractC0373EnArr) {
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            if (abstractC0373EnArr != null) {
                try {
                    if (abstractC0373EnArr.length > 0) {
                        FN A0I = this.A01.A0I(abstractC0373EnArr[0]);
                        if (A0I != null) {
                            String.format(Locale.US, A01(44, 21, 69), Integer.valueOf(A0I.A50()), A0I.getUrl(), A0I.A4M());
                        }
                        if (A0I != null) {
                            return A0I;
                        }
                        throw new IllegalStateException(A01(23, 21, 9));
                    }
                } catch (Exception e) {
                    this.A02 = e;
                    String.format(Locale.US, A01(0, 23, 15), e.getMessage());
                    cancel(true);
                    return null;
                }
            }
            throw new IllegalArgumentException(A01(65, 64, 34));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return null;
        }
    }

    private final void A03(FN fn) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.A6N(fn);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.F8
    public final void A43(AbstractC0373En abstractC0373En) {
        super.executeOnExecutor(this.A03, abstractC0373En);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ FN doInBackground(AbstractC0373En[] abstractC0373EnArr) {
        FN fn = null;
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            fn = A00(abstractC0373EnArr);
            return fn;
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return fn;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        this.A00.A6Z(this.A02);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(FN fn) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A03(fn);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
