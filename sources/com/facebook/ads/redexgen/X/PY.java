package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import java.util.HashMap;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class PY {
    public static byte[] A09;
    public String A00;
    public String A01;
    public final C0361Eb A02;
    public final InterfaceC0422Gl A03;
    public final C0432Gv A04;
    public final PX A05;
    public final String A06;
    public final Map<String, String> A07;
    public final boolean A08;

    static {
        A04();
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
            byte[] r1 = com.facebook.ads.redexgen.X.PY.A09
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
            int r0 = r0 + (-73)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PY.A00(int, int, int):java.lang.String");
    }

    public static void A04() {
        A09 = new byte[]{25, 44, 43, 43, 38, 37, 22, 26, 35, 32, 26, 34, -38, -14, 3, -14, -5, 1, -20, -14, 5, 1, -1, -18, -15, 33, 52, 51, 51, 46, 45, 30, 45, 32, 44, 36, -13, -4, -14, -19, -15, -17, 0, -14, -19, 1, -10, -3, 5, -19, 3, -2, -13, -19, -7, -15, -21, -8, -5, -19, -16, 39, 32, 49, 32, 39, 26, 30, 42, 40, 43, 39, 32, 47, 32, -41, -48, -31, -48, -41, -54, -39, -52, -40, -48, 43, 60, 43, 52, 58, 37, 58, 63, 54, 43};
    }

    public PY(C0361Eb c0361Eb, PX px, InterfaceC0422Gl interfaceC0422Gl, Map<String, String> map, String str) {
        this.A02 = c0361Eb;
        this.A05 = px;
        this.A03 = interfaceC0422Gl;
        this.A07 = map;
        this.A06 = str;
        this.A04 = new C0432Gv(this.A06, this.A03);
        this.A08 = C0413Gc.A0v(px.getContext());
    }

    private void A01() {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(85, 10, 125), A00(52, 9, 67));
        A07(hashMap);
    }

    private void A02() {
        this.A04.A02(EnumC0431Gu.A0W, null);
    }

    private void A03() {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(85, 10, 125), A00(36, 16, 69));
        A07(hashMap);
    }

    private void A05(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(75, 10, 34), String.valueOf(str));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A00(85, 10, 125), A00(61, 14, 114));
        hashMap2.put(A00(13, 11, 68), C0490Jf.A01(hashMap));
        A07(hashMap2);
    }

    private void A06(String str, float f, float f2) {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(25, 11, 118), str);
        hashMap.put(A00(24, 1, 48), String.valueOf(f));
        hashMap.put(A00(12, 1, 24), String.valueOf(f2));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A00(85, 10, 125), A00(0, 12, 110));
        hashMap2.put(A00(13, 11, 68), C0490Jf.A01(hashMap));
        A07(hashMap2);
    }

    private void A07(Map<String, String> map) {
        if (TextUtils.isEmpty(this.A06)) {
            return;
        }
        Map<String, String> data = this.A07;
        map.putAll(data);
        Map<String, String> data2 = PZ.A01(this.A02, this.A00, this.A01);
        map.putAll(data2);
        this.A03.A5h(this.A06, map);
    }

    @JavascriptInterface
    public void initializeLogging(String str, String str2) {
        if (!this.A08) {
            return;
        }
        this.A00 = str;
        this.A01 = str2;
    }

    @JavascriptInterface
    public void logButtonClick(String str, float f, float f2) {
        if (!this.A08) {
            return;
        }
        A06(str, f, f2);
    }

    @JavascriptInterface
    public void logEndCardShowUp() {
        if (!this.A08) {
            return;
        }
        A03();
    }

    @JavascriptInterface
    public void logGameLoad() {
        if (!this.A08) {
            return;
        }
        A01();
    }

    @JavascriptInterface
    public void logLevelComplete(String str) {
        if (!this.A08) {
            return;
        }
        A05(str);
    }

    @JavascriptInterface
    public void onCTAClick() {
        A02();
        this.A05.A08();
    }
}
