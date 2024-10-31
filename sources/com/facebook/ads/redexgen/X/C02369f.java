package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;

/* renamed from: com.facebook.ads.redexgen.X.9f, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02369f {
    public static byte[] A01;
    public SharedPreferences A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C02369f.A01
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
            r0 = r0 ^ 30
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02369f.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{124, 105, 105, 111, 116, Byte.MAX_VALUE, 104, 105, 116, 114, 115, 84, 121, 90, 86, 84, 23, 95, 88, 90, 92, 91, 86, 86, 82, 23, 88, 93, 74, 23, 80, 93, 95, 88, 73, 76, 72, 76, 81, 100, 65, 113, 87, 68, 70, 78, 76, 75, 66, 6, 4, 6, 13, 0, 49, 54, 74, 79, 93, 78, 89, 95, 66, 88, 66, 69, 76, 98, 79};
    }

    public C02369f(C0361Eb c0361Eb) {
        this.A00 = c0361Eb.getSharedPreferences(ProcessUtils.getProcessSpecificName(A00(13, 21, 39), c0361Eb), 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.C02359e A02() {
        /*
            r11 = this;
            r4 = r11
            r5 = 0
            android.content.SharedPreferences r3 = r4.A00
            r2 = 56
            r1 = 13
            r0 = 53
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L64
            r0 = 2
        L15:
            switch(r0) {
                case 2: goto L19;
                case 3: goto L66;
                case 4: goto L5e;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            com.facebook.ads.redexgen.X.9f r4 = (com.facebook.ads.redexgen.X.C02369f) r4
            android.content.SharedPreferences r5 = r4.A00
            r2 = 56
            r1 = 13
            r0 = 53
            java.lang.String r3 = A00(r2, r1, r0)
            r2 = 0
            r1 = 0
            r0 = 98
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.String r6 = r5.getString(r3, r0)
            android.content.SharedPreferences r3 = r4.A00
            r2 = 34
            r1 = 15
            r0 = 59
            java.lang.String r1 = A00(r2, r1, r0)
            r0 = 0
            boolean r7 = r3.getBoolean(r1, r0)
            android.content.SharedPreferences r3 = r4.A00
            r2 = 49
            r1 = 7
            r0 = 123(0x7b, float:1.72E-43)
            java.lang.String r2 = A00(r2, r1, r0)
            r0 = -1
            long r9 = r3.getLong(r2, r0)
            com.facebook.ads.redexgen.X.9e r5 = new com.facebook.ads.redexgen.X.9e
            com.facebook.ads.redexgen.X.9d r8 = com.facebook.ads.redexgen.X.EnumC02349d.A08
            r5.<init>(r6, r7, r8, r9)
            r0 = 3
            goto L15
        L5e:
            com.facebook.ads.redexgen.X.9e r5 = com.facebook.ads.redexgen.X.C02359e.A00()
            r0 = 3
            goto L15
        L64:
            r0 = 4
            goto L15
        L66:
            com.facebook.ads.redexgen.X.9e r5 = (com.facebook.ads.redexgen.X.C02359e) r5
            com.facebook.ads.redexgen.X.9e r5 = (com.facebook.ads.redexgen.X.C02359e) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02369f.A02():com.facebook.ads.redexgen.X.9e");
    }

    public final String A03() {
        return this.A00.getString(A00(0, 13, 3), A00(0, 0, 98));
    }

    public final void A04(C02359e c02359e) {
        SharedPreferences.Editor edit = this.A00.edit();
        edit.putString(A00(56, 13, 53), c02359e.A03());
        edit.putBoolean(A00(34, 15, 59), c02359e.A04());
        edit.putLong(A00(49, 7, 123), c02359e.A01());
        edit.apply();
    }

    public final void A05(String str) {
        SharedPreferences.Editor edit = this.A00.edit();
        edit.putString(A00(0, 13, 3), str);
        edit.apply();
    }
}
