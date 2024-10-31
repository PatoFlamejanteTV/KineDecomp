package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.ads.RewardData;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.2I, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C2I implements Serializable {
    public static JSONObject A0I = null;
    public static byte[] A0J = null;
    public static final long serialVersionUID = -5352540727250859603L;
    public int A00;
    public int A02;
    public RewardData A03;
    public C2J A04;
    public C2Z A05;
    public C00572c A06;
    public C00652k A07;
    public String A08;
    public String A09;

    @Nullable
    public String A0A;
    public String A0B;
    public String A0D;
    public String A0E;
    public boolean A0F;
    public final int A0G;
    public final List<C2L> A0H;
    public String A0C = A00(49, 0, 101);
    public int A01 = 200;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C2I.A0J
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
            r0 = r0 ^ 110(0x6e, float:1.54E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2I.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A0J = new byte[]{74, 87, 74, 82, 91, 76, 75, 85, 108, 115, Byte.MAX_VALUE, 109, 123, 120, 115, 118, 115, 110, 99, 69, 121, 114, Byte.MAX_VALUE, 121, 113, 69, 115, 116, 110, Byte.MAX_VALUE, 104, 108, 123, 118, 44, 33, 57, 47, 53, 52, 111, 98, 109, 103, 112, 96, 98, 115, 102, 40, 55, 42, 44, 42, 57, 49, 44, 17, 14, 2, 16, 6, 5, 14, 11, 14, 19, 30, 56, 4, 15, 2, 4, 12, 56, 14, 9, 14, 19, 14, 6, 11, 56, 3, 2, 11, 6, 30, 53, 40, 63, 48, 60, 56, 50, 14, 34, 53, 58, 14, 61, 48, 40, 52, 35, 14, 57, 37, 60, 61, 14, 36, 35, 61, 33, 54, 34, 38, 54, 32, 39, 12, 58, 55, 54, 51, 8, 52, 63, 56, 62, 52, 50, 36, 8, 59, 62, 57, 60, 8, 34, 37, 59, 36, 34, 52, 14, 63, 52, 38, 14, 61, 48, 40, 62, 36, 37, 14, 50, 62, 63, 37, 35, 62, 61, 61, 52, 35, 83, 68, 122, 120, 122, 113, 124, 70, 120, 106, 106, 124, 109, 106, 33, 43, 39, 38, 29, 18, 35, 16, 19, 27, 19, 35, 8, 5, 12, 25};
    }

    public abstract int A0H();

    public abstract int A0I();

    public C2I(List<C2L> list) {
        this.A0H = list;
    }

    private void A02(int i) {
        this.A00 = i;
    }

    private void A03(int i) {
        this.A02 = i;
    }

    private void A04(C2J c2j) {
        this.A04 = c2j;
    }

    private void A05(C2Z c2z) {
        this.A05 = c2z;
    }

    private final void A06(C00572c c00572c) {
        this.A06 = c00572c;
    }

    private void A07(C00652k c00652k) {
        this.A07 = c00652k;
    }

    private void A08(String str) {
        this.A09 = str;
    }

    private void A09(String str) {
        this.A0D = str;
    }

    private final void A0A(String str) {
        this.A08 = str;
    }

    private void A0B(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.A09)) {
            this.A0C = jSONObject.toString();
        }
    }

    private void A0C(boolean z) {
        this.A0F = z;
    }

    public final int A0D() {
        return this.A00;
    }

    public final int A0E() {
        return this.A01;
    }

    public final int A0F() {
        return this.A02;
    }

    public final int A0G() {
        return this.A0G;
    }

    @Nullable
    public final RewardData A0J() {
        return this.A03;
    }

    public final C2J A0K() {
        return this.A04;
    }

    public final C2L A0L() {
        return this.A0H.get(0);
    }

    public final C2Z A0M() {
        return this.A05;
    }

    public final C00572c A0N() {
        return this.A06;
    }

    public final C00652k A0O() {
        return this.A07;
    }

    public final String A0P() {
        return this.A08;
    }

    public final String A0Q() {
        return this.A09;
    }

    @Nullable
    public final String A0R() {
        return this.A0A;
    }

    public final String A0S() {
        return this.A0B;
    }

    public final String A0T() {
        return this.A0D;
    }

    public final String A0U() {
        return this.A0E;
    }

    public final List<C2L> A0V() {
        return Collections.unmodifiableList(this.A0H);
    }

    public final JSONObject A0W() {
        return A0I;
    }

    public final JSONObject A0X() {
        try {
            return new JSONObject(this.A0C);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public final void A0Y(int i) {
        this.A01 = i;
    }

    public final void A0Z(RewardData rewardData) {
        this.A03 = rewardData;
    }

    public final void A0a(@Nullable String str) {
        this.A0A = str;
    }

    public final void A0b(String str) {
        this.A0B = str;
    }

    public final void A0c(String str) {
        this.A0E = str;
    }

    public final void A0d(JSONObject jSONObject) {
        String A00;
        JSONObject jSONObject2;
        A0I = jSONObject.optJSONObject(A00(170, 12, 119));
        C00562b A06 = new C00562b().A06(jSONObject.optString(A00(0, 5, 80)));
        if (jSONObject.optJSONObject(A00(182, 4, 38)) != null) {
            A00 = jSONObject.optJSONObject(A00(182, 4, 38)).optString(A00(5, 3, 87));
        } else {
            A00 = A00(49, 0, 101);
        }
        A06(A06.A05(A00).A04(jSONObject.optString(A00(124, 19, 57))).A07(C00582d.A03(jSONObject)).A08());
        JSONObject optJSONObject = jSONObject.optJSONObject(A00(34, 6, 46));
        if (optJSONObject != null) {
            jSONObject2 = optJSONObject.optJSONObject(A00(49, 8, 54));
        } else {
            jSONObject2 = null;
        }
        A04(new C2J(C2T.A01(jSONObject2), C2T.A01(optJSONObject != null ? optJSONObject.optJSONObject(A00(40, 9, 109)) : null)));
        A07(C00582d.A01(jSONObject));
        A05(C00582d.A00(jSONObject));
        A0A(jSONObject.optString(A00(168, 2, 94)));
        A09(jSONObject.optString(A00(114, 10, 61), A00(49, 0, 101)));
        A08(jSONObject.optString(A00(88, 26, 63), A00(49, 0, 101)));
        A02(jSONObject.optInt(A00(186, 12, 18), 0));
        A0B(jSONObject);
        A03(jSONObject.optInt(A00(57, 31, 9), 0));
        A0Y(jSONObject.optInt(A00(8, 26, 116), 1000));
        A0C(jSONObject.optBoolean(A00(143, 25, 63)));
    }

    public final boolean A0e() {
        return this.A0F;
    }
}
