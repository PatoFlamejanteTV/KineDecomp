package com.facebook.ads.redexgen.X;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class A4 implements A3 {
    public static byte[] A01;
    public static final String A02;
    public final C0365Ef A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.A4.A01
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
            int r0 = r0 + (-122)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.A4.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-9, -2, -7, 15, 6, 0, 85, 103, 93, 88, -17, -31, -16, 25, 27, -4, 47, 26, 28, 39, 43, 32, 38, 37, -41, 25, 44, 32, 35, 27, 32, 37, 30, -41, -3, -8, 5, -41, 35, 38, 30, 30, 32, 37, 30, -41, 1, 10, 6, 5, -18, -1, 51, 53, 48, 53, 50, 69, 50, 48, 61, 64, 56, 56, 58, 63, 56};
    }

    static {
        A01();
        A02 = A4.class.getSimpleName();
    }

    public A4(C0365Ef c0365Ef) {
        this.A00 = c0365Ef;
    }

    @Override // com.facebook.ads.redexgen.X.A3
    public final void A5n(String str, String str2, int i, int i2, int i3, JSONObject jSONObject, EnumC0350Dq enumC0350Dq) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(A00(6, 4, 122), str);
            jSONObject2.put(A00(0, 3, 27), str2);
            jSONObject2.put(A00(50, 2, 17), i);
            jSONObject2.put(A00(13, 2, 45), i2);
            jSONObject2.put(A00(10, 3, 2), i3);
            jSONObject2.put(A00(3, 3, 34), EH.A01(jSONObject.toString(), str2));
            C0514Ke c0514Ke = new C0514Ke(jSONObject2.toString());
            c0514Ke.A03(1);
            C0511Kb.A06(this.A00, A00(52, 15, 87), 3201, c0514Ke);
        } catch (JSONException e) {
            Log.e(A02, A00(15, 35, 61), e);
        }
    }
}
