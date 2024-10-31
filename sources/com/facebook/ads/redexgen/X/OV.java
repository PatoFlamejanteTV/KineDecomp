package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class OV {
    public static byte[] A03;
    public final int A00;
    public final String A01;
    public final String A02;

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
            byte[] r1 = com.facebook.ads.redexgen.X.OV.A03
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
            int r0 = r0 + (-2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OV.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A03 = new byte[]{-99, -95, -107, -101, -103, -53, -50, -55, -51, -36, -49, -53, -34, -45, -32, -49, -55, -34, -29, -38, -49, -85, -70, -77, -124, 119, 114, 115, 125, -126, -101, -114, -113, -103, -110, 77, -95, -100, 77, -112, -97, -110, -114, -95, -110, 77, -114, -111, -111, -106, -95, -106, -100, -101, -114, -103, 118, -101, -109, -100, 95, 110, 103, 103, -118, -126, -126, Byte.MIN_VALUE, -115, -38, -35, -40, -21, -34, -22, -18, -34, -20, -19, -40, -30, -35, -114, -111, -116, -109, -100, -97, -102, -114, -95, -116, -95, -90, -99, -110};
    }

    public OV(String str, String str2, int i) {
        this.A02 = str;
        this.A00 = i;
        this.A01 = !TextUtils.isEmpty(str2) ? A01(24, 5, 12) : A01(0, 5, 50);
    }

    private C0514Ke A00(String str) {
        C0514Ke c0514Ke = new C0514Ke(str);
        c0514Ke.A05(A02());
        c0514Ke.A03(1);
        return c0514Ke;
    }

    private JSONObject A02() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A01(82, 14, 43), this.A00);
            jSONObject.put(A01(69, 13, 119), this.A02);
            jSONObject.put(A01(5, 16, 104), this.A01);
        } catch (JSONException e) {
            Log.w(A01(60, 9, 25), A01(29, 31, 43), e);
        }
        return jSONObject;
    }

    public final void A04(int i, String str) {
        C0511Kb.A06(C0363Ed.A00(), A01(21, 3, 69), i, A00(str));
    }
}
