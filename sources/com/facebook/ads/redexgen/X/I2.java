package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class I2 {
    public static byte[] A05;
    public final I1 A00;

    @Nullable
    public final Long A01;

    @Nullable
    public final String A02;

    @Nullable
    public final String A03;

    @Nullable
    public final String A04;

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
            byte[] r1 = com.facebook.ads.redexgen.X.I2.A05
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
            r0 = r0 ^ 126(0x7e, float:1.77E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.I2.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A05 = new byte[]{84, 89, 80, 69, 107, 64, 77, 9, 12, 77, 9, 79, 70, 91, 9, 93, 76, 68, 89, 69, 72, 93, 76, 9, 12, 90, 9, 75, 76, 64, 71, 78, 9, 92, 90, 76, 77, 9, 70, 71, 9, 93, 76, 68, 89, 69, 72, 93, 76, 9, 12, 90, 77, 124, 116, 105, 117, 120, 109, 124, 57, 60, 106, 57, 112, 106, 57, 119, 118, 109, 57, 111, 120, 117, 112, 125, 57, 123, 120, 119, 119, 124, 107, 57, 109, 124, 116, 105, 117, 120, 109, 124, 8, 25, 0, 112, 87, 79, 88, 85, 80, 93, 25, 123, 80, 93, 105, 88, 64, 85, 86, 88, 93, 102, 77, 64, 4, 1, 64, 4, 66, 75, 86, 4, 119, 96, 111, 4, 82, 65, 86, 87, 77, 75, 74, 4, 1, 87, 4, 70, 65, 77, 74, 67, 4, 81, 87, 65, 64, 4, 75, 74, 4, 119, 96, 111, 4, 82, 65, 86, 87, 77, 75, 74, 4, 1, 87, 27, 10, 2, 31, 3, 14, 27, 10, 10, 33, 44, 104, 109, 44, 104, 46, 39, 58, 104, 56, 36, 41, 43, 45, 37, 45, 38, 60, 104, 109, 59, 104, 42, 45, 33, 38, 47, 104, 61, 59, 45, 44, 104, 39, 38, 104, 56, 36, 41, 43, 45, 37, 45, 38, 60, 104, 109, 59, 86, 93, 80, 107, 93, 80, 116, 101, 125, 104, 107, 101, 96, 35, 8, 5, 65, 68, 5, 65, 7, 14, 19, 65, 40, 37, 39, 32, 65, 68, 18, 65, 3, 4, 8, 15, 6, 65, 20, 18, 4, 5, 65, 14, 15, 65, 40, 37, 39, 32, 65, 68, 18, 119, 76, 81, 87, 82, 82, 77, 80, 86, 71, 70, 2, 96, 75, 70, 114, 67, 91, 78, 77, 67, 70, 2, 86, 91, 82, 71, 2, 124, 119, 122, 65, 106, 119, 115, 123, 65, 106, 113, 117, 123, 112, 87, 64, 86, 74, 73, 83, 64, 65, 122, 85, 73, 68, 70, 64, 72, 64, 75, 81, 122, 76, 65, 21, 20, 7, 24, 18, 20, 46, 24, 21, 91, 76, 67, 119, 94, 77, 90, 91, 65, 71, 70};
    }

    public I2() {
        this.A00 = I1.A04;
        this.A01 = null;
        this.A03 = null;
        this.A04 = null;
        this.A02 = null;
    }

    public I2(C0362Ec c0362Ec, @Nullable String str, String str2, EnumC0458Hx enumC0458Hx) throws C0454Hs {
        if (TextUtils.isEmpty(str)) {
            this.A00 = I1.A04;
            this.A01 = null;
            this.A03 = null;
            this.A04 = null;
            this.A02 = null;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (I0.A00[I1.valueOf(jSONObject.getString(A01(0, 4, 94)).toUpperCase()).ordinal()]) {
                case 1:
                    this.A00 = I1.A03;
                    this.A01 = Long.valueOf(jSONObject.getString(A01(225, 6, 74)));
                    this.A02 = jSONObject.optString(A01(306, 14, 96), null);
                    this.A03 = jSONObject.getString(A01(341, 9, 15));
                    this.A04 = null;
                    break;
                case 2:
                    this.A00 = I1.A02;
                    this.A01 = Long.valueOf(jSONObject.getString(A01(225, 6, 74)));
                    this.A02 = jSONObject.optString(A01(306, 14, 96), null);
                    this.A03 = jSONObject.getString(A01(341, 9, 15));
                    this.A04 = new JSONObject(jSONObject.getString(A01(231, 7, 122))).toString();
                    break;
                default:
                    throw new C0454Hs(AdErrorType.BID_PAYLOAD_ERROR, A01(278, 28, 92) + jSONObject.getString(A01(0, 4, 94)));
            }
            if (!jSONObject.getString(A01(350, 11, 86)).equals(BuildConfigApi.getVersionName(c0362Ec))) {
                throw new C0454Hs(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(113, 54, 90), this.A01, jSONObject.getString(A01(350, 11, 86)), BuildConfigApi.getVersionName(c0362Ec)));
            }
            if (!jSONObject.getString(A01(320, 21, 91)).equals(str2)) {
                throw new C0454Hs(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(175, 50, 54), this.A01, jSONObject.getString(A01(320, 21, 91)), str2));
            }
            HashSet hashSet = new HashSet(Arrays.asList(Integer.valueOf(EnumC0458Hx.A0D.A03()), Integer.valueOf(EnumC0458Hx.A0G.A03()), Integer.valueOf(EnumC0458Hx.A0E.A03()), Integer.valueOf(EnumC0458Hx.A0F.A03())));
            if (jSONObject.getInt(A01(167, 8, 17)) == enumC0458Hx.A03()) {
                return;
            }
            if (hashSet.contains(Integer.valueOf(jSONObject.getInt(A01(167, 8, 17)))) && hashSet.contains(Integer.valueOf(enumC0458Hx.A03()))) {
            } else {
                throw new C0454Hs(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(4, 48, 87), this.A01, Integer.valueOf(jSONObject.getInt(A01(167, 8, 17))), enumC0458Hx));
            }
        } catch (JSONException e) {
            C0511Kb.A06(c0362Ec, A01(92, 3, 23), C0512Kc.A0E, new C0514Ke(e));
            throw new C0454Hs(AdErrorType.BID_PAYLOAD_ERROR, A01(95, 18, 71), e);
        }
    }

    @Nullable
    public static EnumC0458Hx A00(String str) throws C0454Hs {
        try {
            JSONObject json = new JSONObject(str);
            return EnumC0458Hx.A00(json.getInt(A01(167, 8, 17)));
        } catch (JSONException e) {
            throw new C0454Hs(AdErrorType.BID_PAYLOAD_ERROR, A01(95, 18, 71), e);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    public static void A03(EnumC0458Hx enumC0458Hx) throws C0454Hs {
        char c = !EnumC0458Hx.A0C.equals(enumC0458Hx) ? (char) 2 : (char) 6;
        while (true) {
            switch (c) {
                case 2:
                    enumC0458Hx = enumC0458Hx;
                    c = !EnumC0458Hx.A0A.equals(enumC0458Hx) ? (char) 3 : (char) 6;
                case 3:
                    enumC0458Hx = enumC0458Hx;
                    c = !EnumC0458Hx.A0B.equals(enumC0458Hx) ? (char) 4 : (char) 6;
                case 4:
                    enumC0458Hx = enumC0458Hx;
                    c = !EnumC0458Hx.A09.equals(enumC0458Hx) ? (char) 5 : (char) 6;
                case 5:
                    throw new C0454Hs(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(52, 40, 103), Integer.valueOf(enumC0458Hx.A03())));
                case 6:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A04() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            java.lang.Long r0 = r2.A01
            if (r0 != 0) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1a;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 0
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.I2 r2 = (com.facebook.ads.redexgen.X.I2) r2
            java.lang.Long r0 = r2.A01
            java.lang.String r1 = r0.toString()
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.I2.A04():java.lang.String");
    }

    @Nullable
    public final String A05() {
        return this.A02;
    }

    @Nullable
    public final String A06() {
        return this.A04;
    }

    public final void A07(String str) throws C0454Hs {
        if (!this.A03.equals(str)) {
            throw new C0454Hs(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(238, 40, 31), this.A01, this.A03, str));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A08() {
        /*
            r3 = this;
            r2 = 0
            com.facebook.ads.redexgen.X.I1 r1 = r3.A00
            com.facebook.ads.redexgen.X.I1 r0 = com.facebook.ads.redexgen.X.I1.A04
            if (r1 == r0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 1
            r0 = 3
            goto L8
        Lf:
            r2 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.I2.A08():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A09() {
        /*
            r3 = this;
            r2 = 0
            com.facebook.ads.redexgen.X.I1 r1 = r3.A00
            com.facebook.ads.redexgen.X.I1 r0 = com.facebook.ads.redexgen.X.I1.A02
            if (r1 != r0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 1
            r0 = 3
            goto L8
        Lf:
            r2 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.I2.A09():boolean");
    }
}
