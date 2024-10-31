package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class A6 implements A5 {
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
            byte[] r1 = com.facebook.ads.redexgen.X.A6.A01
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
            r0 = r0 ^ 67
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.A6.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{115, 120, 117, 67, 104, Byte.MAX_VALUE, 104, Byte.MAX_VALUE, 121, 107, 42, 23, 12, 10, 31, 27, 6, 0, 1, 79, 13, 26, 6, 3, 11, 6, 1, 8, 79, 41, 46, 33, 79, 3, 0, 8, 8, 6, 1, 8, 79, 37, 60, 32, 33, 85, 86, 64, 71, 47, 62, 57, 76, 74, 113, 74, 79, 90, 79, 113, 66, 65, 73, 73, 71, 64, 73, 27, 19};
    }

    static {
        A01();
        A02 = A6.class.getSimpleName();
    }

    public A6(C0365Ef c0365Ef) {
        this.A00 = c0365Ef;
    }

    @Override // com.facebook.ads.redexgen.X.A5
    public final void A5f(String str, String str2, Map<String, String> map, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(9, 1, 68), str);
            jSONObject.put(A00(51, 1, 21), str2);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put(A00(7, 2, 83), jSONObject2.toString());
            jSONObject.put(A00(0, 3, 82), str3);
            jSONObject.put(A00(67, 2, 61), str4);
            jSONObject.put(A00(46, 3, 112), str5);
            jSONObject.put(A00(49, 2, 9), str6);
            jSONObject.put(A00(45, 1, 117), A00(3, 4, 74));
            C0514Ke c0514Ke = new C0514Ke(jSONObject.toString());
            c0514Ke.A03(1);
            C0511Kb.A06(this.A00, A00(52, 15, 109), 3202, c0514Ke);
        } catch (JSONException e) {
            Log.e(A02, A00(10, 35, 44), e);
        }
    }
}
