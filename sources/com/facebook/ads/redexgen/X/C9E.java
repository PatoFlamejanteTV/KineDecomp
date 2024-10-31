package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

/* renamed from: com.facebook.ads.redexgen.X.9E, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C9E extends AsyncTask<C9F, Void, Drawable> {
    public static byte[] A03;
    public final C9B A00;
    public final C0362Ec A01;
    public final boolean A02;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C9E.A03
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
            r0 = r0 ^ 46
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9E.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A03 = new byte[]{107, 105, 98, 105, 126, 101, 111};
    }

    public C9E(C0362Ec c0362Ec, C9B c9b, boolean z) {
        this.A01 = c0362Ec;
        this.A00 = c9b;
        this.A02 = z;
    }

    @SuppressLint({"CatchGeneralException"})
    private final Drawable A00(C9F... c9fArr) {
        Drawable drawable = null;
        if (C0466Ig.A02(this) || c9fArr == null) {
            return null;
        }
        try {
            if (c9fArr.length < 1) {
                return null;
            }
            String str = c9fArr[0].A01;
            String str2 = c9fArr[0].A00;
            Bitmap bitmap = null;
            try {
                bitmap = new EV(this.A01).A0I(str, -1, -1);
            } catch (Throwable th) {
                C0511Kb.A0E(A01(0, 7, 34), C0512Kc.A17, new C0514Ke(th));
            }
            if (bitmap == null) {
                return null;
            }
            drawable = HX.A05(this.A01, bitmap, this.A02, str2);
            return drawable;
        } catch (Throwable th2) {
            C0466Ig.A00(th2, this);
            return drawable;
        }
    }

    private final void A03(Drawable drawable) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.A6i(drawable);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // android.os.AsyncTask
    @SuppressLint({"CatchGeneralException"})
    public final /* bridge */ /* synthetic */ Drawable doInBackground(C9F[] c9fArr) {
        Drawable drawable = null;
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            drawable = A00(c9fArr);
            return drawable;
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return drawable;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Drawable drawable) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A03(drawable);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
