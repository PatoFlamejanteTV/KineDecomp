package com.facebook.ads.redexgen.X;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class GT {
    public static byte[] A00;
    public static final SparseIntArray A01;
    public static final Map<String, Integer> A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.GT.A00
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
            int r0 = r0 + (-91)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GT.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{-71, -75, -86, -84, -82, -74, -82, -73, -67, -68, -56, -76, -82, -62, -43, -19, -21, -14, -14, -21, -16, -23, -94, -21, -16, -21, -10, -94, -26, -9, -25, -94, -10, -15, -94, -18, -29, -27, -19, -94, -15, -24, -94, -27, -15, -16, -16, -25, -27, -10, -21, -8, -21, -10, -5, -80, -54, -58, -59, -7, -24, -19, -23, -14, -25, -23, -46, -23, -8, -5, -13, -10, -17, -27, -24, -21, -21, 1, -3, -14, -12, -10, -2, -10, -1, 5, -16, -9, 0, 3, -2, -14, 5, 4, 41, 53, 52, 52, 43, 41, 58, 47, 60, 47, 58, 63, 22, 9, 21, 25, 9, 23, 24, -50, -54, -65, -63, -61, -53, -61, -52, -46, -67, -57, -62, -47, 34, 19, 43, 30, 33, 19, 22, -57, -50, -55, -55, -54, -41, -60, -39, -44, -48, -54, -45, 25, 44, 37, 27, 35, 28, 42, -25, -26, -30, -11, -10, -13, -26, -32, -28, -16, -17, -25, -22, -24, -11, 1, 0, 6, -9, 10, 6};
    }

    static {
        A02();
        A02 = new HashMap();
        A01 = new SparseIntArray();
        A01.put(19, 1);
        A01.put(18, 2);
        A01.put(20, 4);
        A01.put(36, 6);
        A01.put(40, 3);
        A01.put(61, 5);
    }

    public static synchronized Integer A00(String str) {
        int i;
        synchronized (GT.class) {
            Integer num = A02.get(str);
            if (num != null) {
                i = Integer.valueOf(A01.get(num.intValue()));
            } else {
                i = 0;
            }
        }
        return i;
    }

    public static void A03(C0365Ef c0365Ef, MultithreadedBundleWrapper multithreadedBundleWrapper) throws JSONException {
        ArrayList<String> placementIds;
        NetworkInfo activeNetwork;
        String bidderToken = DynamicLoaderFactory.makeLoader(c0365Ef).createBidderTokenProviderApi().getBidderToken(c0365Ef);
        String bidderToken2 = A01(94, 12, 107);
        ConnectivityManager connectivityManager = (ConnectivityManager) c0365Ef.getSystemService(bidderToken2);
        if (connectivityManager != null && ((activeNetwork = connectivityManager.getActiveNetworkInfo()) == null || !activeNetwork.isConnectedOrConnecting())) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A01(56, 17, 41), A01(14, 42, 39));
                return;
            }
            return;
        }
        C0483Iy A022 = C7A.A02(c0365Ef, false);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A01(133, 12, 10), bidderToken);
        if (multithreadedBundleWrapper != null && (placementIds = multithreadedBundleWrapper.getStringArrayList(A01(0, 14, 14))) != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = placementIds.iterator();
            while (it.hasNext()) {
                String placement = it.next();
                jSONArray.put(placement);
            }
            jSONObject2.put(A01(113, 13, 3), jSONArray);
        }
        A04(c0365Ef, jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(A01(77, 17, 54), A01(73, 4, 36));
        jSONObject3.put(A01(152, 14, 38), A01(73, 4, 36));
        jSONObject.put(A01(166, 7, 55), jSONObject2);
        jSONObject.put(A01(106, 7, 73), jSONObject3);
        JC jc = new JC();
        jc.put(A01(126, 7, 87), jSONObject.toString());
        JA A0L = A022.A0L(IW.A04(c0365Ef), jc);
        if (A0L == null || A0L.A00() != 200) {
            return;
        }
        String A012 = A0L.A01();
        if (TextUtils.isEmpty(A012)) {
            return;
        }
        JSONObject optJSONObject = new JSONObject(A012).optJSONObject(A01(145, 7, 92));
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(A01(77, 17, 54));
        String optString = optJSONObject.optString(A01(152, 14, 38));
        if (!TextUtils.isEmpty(optString)) {
            C0413Gc.A0I(c0365Ef).A1P(optString);
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = optJSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String key = optJSONObject2.getString(next);
            hashMap.put(next, Integer.valueOf(Integer.parseInt(key)));
        }
        synchronized (A02) {
            A02.putAll(hashMap);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A04(com.facebook.ads.redexgen.X.C0365Ef r2, org.json.JSONObject r3) throws org.json.JSONException {
        /*
            r0 = 0
            com.facebook.ads.redexgen.X.GQ r1 = com.facebook.ads.redexgen.X.GQ.A00()
            r0 = 1
            com.facebook.ads.redexgen.X.GP r0 = r1.A02(r2, r0)
            java.util.Map r0 = r0.A4c()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r2 = r0.iterator()
            r0 = 2
        L17:
            switch(r0) {
                case 2: goto L1b;
                case 3: goto L27;
                case 4: goto L40;
                default: goto L1a;
            }
        L1a:
            goto L17
        L1b:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L25
            r0 = 3
            goto L17
        L25:
            r0 = 4
            goto L17
        L27:
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r0 = r2.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            r3.put(r1, r0)
            r0 = 2
            goto L17
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GT.A04(com.facebook.ads.redexgen.X.Ef, org.json.JSONObject):void");
    }
}
