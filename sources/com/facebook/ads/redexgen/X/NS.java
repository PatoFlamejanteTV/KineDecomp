package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class NS {
    public static byte[] A01;
    public final Map<String, String> A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.NS.A01
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
            int r0 = r0 + (-115)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NS.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-9, 10, 6, 4, -13, -15, -6, -5, 0, 6, 5, 21, 16, 22, 4, 9};
    }

    public NS() {
        this.A00 = new HashMap();
    }

    public NS(Map<String, String> extraData) {
        this.A00 = extraData;
    }

    public final NS A02(@Nullable K5 k5) {
        if (k5 != null) {
            this.A00.put(A00(11, 5, 46), C0490Jf.A01(k5.A04()));
        }
        return this;
    }

    public final NS A03(@Nullable FP fp) {
        if (fp != null) {
            this.A00.putAll(fp.A0T());
        }
        return this;
    }

    public final NS A04(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.A00.put(A00(0, 11, 31), str);
        }
        return this;
    }

    public final Map<String, String> A05() {
        return this.A00;
    }
}
