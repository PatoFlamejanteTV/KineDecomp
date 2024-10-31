package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Kh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0517Kh {
    public static byte[] A00;

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0517Kh.A00
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
            r0 = r0 ^ 39
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0517Kh.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{125, 94, 86, 86, 88, 95, 86, 17, Byte.MAX_VALUE, 84, 69, 70, 94, 67, 90, 17, 116, 71, 84, 95, 69, 44, 43, 62, 45, 43, 0, 43, 54, 50, 58, 114, 99, 100, 119, 98, Byte.MAX_VALUE, 121, 120, 73, 94, 94, 67, 94, 6, 26, 26, 30, 49, 29, 26, 15, 26, 27, 29, 49, 13, 1, 10, 11, 121, 114, 99, 96, 120, 101, 124, 78, 75, 87, 84, 90, 95, 100, 72, 82, 65, 94, 33, 48, 40, 61, 62, 48, 53, 14, 34, 56, 43, 52};
    }

    public static JSONObject A01(long j, long j2, long j3, long j4, int i, @Nullable Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(21, 10, 120), j);
            jSONObject.put(A00(31, 8, 49), j2 / 1000.0d);
            jSONObject.put(A00(78, 12, 118), j3);
            jSONObject.put(A00(67, 11, 28), j4);
            jSONObject.put(A00(44, 16, 73), i);
            if (exc != null) {
                jSONObject.put(A00(39, 5, 11), exc.getMessage());
            }
        } catch (JSONException e) {
            C0511Kb.A0F(e);
        }
        return jSONObject;
    }

    public static void A03(C0361Eb c0361Eb, long j, long j2, long j3, long j4, int i, @Nullable Exception exc) {
        C0514Ke c0514Ke = new C0514Ke(A00(0, 21, 22));
        c0514Ke.A03(1);
        c0514Ke.A05(A01(j, j2, j3, j4, i, exc));
        C0511Kb.A08(c0361Eb, A00(60, 7, 48), C0512Kc.A1R, c0514Ke);
    }
}
