package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.adapters.util.CacheAssets;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.2r, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00722r {
    public static byte[] A00;
    public static final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C00722r.A00
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
            r0 = r0 ^ 26
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00722r.A00(int, int, int):java.lang.String");
    }

    public static void A0A() {
        A00 = new byte[]{70, 68, 70, 77, 64, 122, 72, 68, 75, 65, 68, 81, 74, 87, 92, 122, 76, 72, 68, 66, 64, 86, 7, 0, 30, 43, 41, 43, 32, 45, 23, 39, 56, 60, 33, 39, 38, 41, 36, 23, 46, 33, 36, 45, 59, 125, 76, 95, 94, 68, 67, 74, 13, 72, 95, 95, 66, 95, 3, 84, 86, 84, 95, 82, 104, 88, 71, 67, 94, 88, 89, 86, 91, 104, 94, 90, 86, 80, 82, 68, 65, 95, 82, 66, 94, 86, 91, 87, 89, 86, 74, 12, 14, 12, 7, 10, 48, 2, 14, 1, 11, 14, 27, 0, 29, 22, 48, 25, 6, 11, 10, 0, 28, 47, 50, 62, 47, 36, 57, 35, 37, 36, 38, 36, 38, 45, 32, 26, 42, 53, 49, 44, 42, 43, 36, 41, 26, 51, 44, 33, 32, 42, 54, 109, 111, 109, 102, 107, 81, 99, 111, 96, 106, 111, 122, 97, 124, 119, 81, 104, 103, 98, 107, 125};
    }

    static {
        A0A();
        A01 = C00722r.class.getName();
    }

    public static List<C00692o> A01(JSONArray jSONArray, boolean z) throws IllegalStateException {
        List<CacheAssets.FileCacheData> fileCacheDataList = new ArrayList<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    fileCacheDataList.add(new C00692o(jSONObject.getString(A00(22, 3, 104)), jSONObject.optString(A00(113, 9, 80))));
                } catch (JSONException e) {
                    if (z) {
                        throw new IllegalStateException();
                    }
                    if (BuildConfigApi.isDebug()) {
                        Log.e(A01, A00(45, 14, 55), e);
                    }
                }
            }
        }
        return fileCacheDataList;
    }

    public static List<C00702p> A02(JSONArray jSONArray, boolean z) throws IllegalStateException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(new C00702p(jSONObject.getString(A00(22, 3, 104)), jSONObject.optInt(A00(80, 5, 44)), jSONObject.optInt(A00(85, 6, 36))));
                } catch (JSONException e) {
                    if (z) {
                        throw new IllegalStateException();
                    }
                    if (BuildConfigApi.isDebug()) {
                        Log.e(A01, A00(45, 14, 55), e);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<C00712q> A03(JSONArray jSONArray, boolean z) throws IllegalStateException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(new C00712q(jSONArray.getJSONObject(i).getString(A00(22, 3, 104))));
                } catch (JSONException e) {
                    if (z) {
                        throw new IllegalStateException();
                    }
                    if (BuildConfigApi.isDebug()) {
                        Log.e(A01, A00(45, 14, 55), e);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<C00692o> A04(JSONObject jSONObject) throws IllegalStateException {
        return A01(jSONObject.optJSONArray(A00(143, 21, 20)), true);
    }

    public static List<C00702p> A05(JSONObject jSONObject) throws IllegalStateException {
        return A02(jSONObject.optJSONArray(A00(0, 22, 63)), true);
    }

    public static List<C00712q> A06(JSONObject jSONObject) throws IllegalStateException {
        return A03(jSONObject.optJSONArray(A00(91, 22, 117)), true);
    }

    public static List<C00692o> A07(JSONObject jSONObject) throws IllegalStateException {
        return A01(jSONObject.optJSONArray(A00(25, 20, 82)), false);
    }

    public static List<C00702p> A08(JSONObject jSONObject) throws IllegalStateException {
        return A02(jSONObject.optJSONArray(A00(59, 21, 45)), false);
    }

    public static List<C00712q> A09(JSONObject jSONObject) throws IllegalStateException {
        return A03(jSONObject.optJSONArray(A00(122, 21, 95)), false);
    }
}
