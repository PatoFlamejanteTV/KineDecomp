package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.dto.AdCookieData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Fp, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0401Fp {
    public static byte[] A05;
    public String A00;
    public String A01;
    public String A02;
    public Date A03;
    public boolean A04;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0401Fp.A05
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
            r0 = r0 ^ 35
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0401Fp.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A05 = new byte[]{71, 80, 93, 68, 84, 25, 23, 11, 97, 102, 120, 103, 109, 116, 93, 93, 93, 52, 56, 124, 124, 53, 85, 85, 85, 53, 97, 97, 97, 97, 56, 80, 80, 34, 117, 117, 34, 107, 107, 56, 98, 98, 98, 18, 15, 7, 30, 5, 22, 3, 30, 24, 25};
    }

    public C0401Fp(String str, String str2, String str3, Date date) {
        this.A01 = str;
        this.A00 = str2;
        this.A02 = str3;
        this.A03 = date;
        this.A04 = (str2 == null || str3 == null) ? false : true;
    }

    public C0401Fp(JSONObject jSONObject) {
        this(jSONObject.optString(A00(8, 3, 55)), jSONObject.optString(A00(5, 3, 81)), jSONObject.optString(A00(0, 5, 18)), new Date(jSONObject.optLong(A00(43, 10, 84)) * 1000));
    }

    public static List<C0401Fp> A01(String str) {
        C0401Fp c0401Fp;
        List<AdCookieData> cookies = null;
        if (str != null) {
            JSONArray jSONArray = null;
            try {
                JSONArray jsonArray = new JSONArray(str);
                jSONArray = jsonArray;
            } catch (JSONException unused) {
            }
            if (jSONArray != null) {
                cookies = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = jSONArray.getJSONObject(i);
                    } catch (JSONException unused2) {
                    }
                    if (jSONObject != null && (c0401Fp = new C0401Fp(jSONObject)) != null) {
                        cookies.add(c0401Fp);
                    }
                }
            }
        }
        return cookies;
    }

    public final String A03() {
        Date expirationDate = this.A03;
        if (expirationDate == null) {
            expirationDate = new Date();
            expirationDate.setTime(expirationDate.getTime() + 3600000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(A00(14, 29, 59));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(A00(11, 3, 3)));
        return simpleDateFormat.format(expirationDate);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0027, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A04() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            java.lang.String r0 = r2.A00
            if (r0 == 0) goto L25
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L15;
                case 4: goto L1f;
                case 5: goto L27;
                case 6: goto L22;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Fp r2 = (com.facebook.ads.redexgen.X.C0401Fp) r2
            java.lang.String r0 = r2.A02
            if (r0 == 0) goto L13
            r0 = 3
            goto L7
        L13:
            r0 = 6
            goto L7
        L15:
            com.facebook.ads.redexgen.X.Fp r2 = (com.facebook.ads.redexgen.X.C0401Fp) r2
            java.lang.String r0 = r2.A01
            if (r0 == 0) goto L1d
            r0 = 4
            goto L7
        L1d:
            r0 = 6
            goto L7
        L1f:
            r1 = 1
            r0 = 5
            goto L7
        L22:
            r1 = 0
            r0 = 5
            goto L7
        L25:
            r0 = 6
            goto L7
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0401Fp.A04():boolean");
    }
}
