package com.facebook.ads.redexgen.X;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.1q, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00451q implements AnonymousClass14 {
    public static byte[] A07;
    public final AnonymousClass13 A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final String A04;
    public final Collection<String> A05;
    public final Map<String, String> A06;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C00451q.A07
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
            int r0 = r0 + (-119)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00451q.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A07 = new byte[]{63, 55, 70, 51, 54, 51, 70, 51, 11, 12, 27, 12, 10, 27, 16, 22, 21, 6, 26, 27, 25, 16, 21, 14, 26, -7, -2, 6, -15, -4, -7, -12, -15, 4, -7, -1, -2, -17, -14, -11, -8, -15, 6, -7, -1, 2, 6, -7, 5, 9, -7, 7, 8, -13, -3, -8, 17, 34, 20, 22, 39, 28, 41, 20, 39, 28, 34, 33, 18, 22, 34, 32, 32, 20, 33, 23, 82, 70, 87, 80, 90, 85};
    }

    public C00451q(String str, String str2, AnonymousClass13 anonymousClass13, Collection<String> mDetectionStrings, Map<String, String> mMetadata, String str3, String str4) {
        this.A03 = str;
        this.A01 = str2;
        this.A00 = anonymousClass13;
        this.A05 = mDetectionStrings;
        this.A06 = mMetadata;
        this.A04 = str3;
        this.A02 = str4;
    }

    public static C00451q A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String mRequestId = jSONObject.optString(A01(76, 6, 110));
        String key = jSONObject.optString(A01(58, 18, 60));
        String optString = jSONObject.optString(A01(46, 10, 29));
        String A02 = C0490Jf.A02(jSONObject, A01(56, 2, 55));
        AnonymousClass13 A00 = AnonymousClass13.A00(jSONObject.optString(A01(25, 21, 25)));
        JSONArray jSONArray = null;
        try {
            jSONArray = new JSONArray(jSONObject.optString(A01(8, 17, 48)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Collection<String> A01 = AnonymousClass15.A01(jSONArray);
        JSONObject optJSONObject = jSONObject.optJSONObject(A01(0, 8, 91));
        HashMap hashMap = new HashMap();
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
        }
        return new C00451q(mRequestId, key, A00, A01, hashMap, optString, A02);
    }

    public final String A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass14, com.facebook.ads.redexgen.X.C1F
    public final String A4V() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass14
    public final Collection<String> A4Z() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass14
    public final AnonymousClass13 A4l() {
        return this.A00;
    }
}
