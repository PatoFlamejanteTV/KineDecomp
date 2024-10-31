package com.facebook.ads.redexgen.X;

import android.os.AsyncTask;

/* renamed from: com.facebook.ads.redexgen.X.Ev, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class AsyncTaskC0381Ev<T> extends AsyncTask<Void, Void, T> {
    public static byte[] A04;
    public EnumC0384Ey A00;
    public final C0365Ef A01;
    public final AbstractC0374Eo<T> A02;
    public final AbstractC0378Es<T> A03;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AsyncTaskC0381Ev.A04
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
            int r0 = r0 + (-1)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AsyncTaskC0381Ev.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A04 = new byte[]{-33, -36, -17, -36, -35, -36, -18, -32};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Eo != com.facebook.ads.internal.database.AdDatabaseCallback<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Es != com.facebook.ads.internal.database.AdDatabaseQuery<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ev != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
    public AsyncTaskC0381Ev(C0365Ef c0365Ef, AbstractC0378Es<T> abstractC0378Es, AbstractC0374Eo<T> abstractC0374Eo) {
        this.A03 = abstractC0378Es;
        this.A02 = abstractC0374Eo;
        this.A01 = c0365Ef;
    }

    private final T A00(Void... voidArr) {
        if (C0466Ig.A02(this)) {
            return null;
        }
        T t = null;
        try {
            try {
                t = this.A03.A03();
                this.A00 = this.A03.A00();
                return t;
            } catch (Exception e) {
                this.A01.A06().A5W(A01(0, 8, 122), C0512Kc.A0j, new C0514Ke(e));
                this.A00 = EnumC0384Ey.A08;
                return t;
            }
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) {
        T t = null;
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            t = A00(voidArr);
            return t;
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return t;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(T t) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            if (this.A00 == null) {
                this.A02.A02(t);
            } else {
                this.A02.A01(this.A00.A02(), this.A00.A03());
            }
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
