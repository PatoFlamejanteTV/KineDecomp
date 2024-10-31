package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.1i, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C00371i implements AnonymousClass14, C1F {
    public static byte[] A0Z;
    public static final String A0a;
    public int A00;
    public int A01;
    public int A03;
    public int A04;
    public int A06;
    public int A07;
    public Uri A08;
    public AnonymousClass13 A09;
    public AnonymousClass25 A0A;
    public C0362Ec A0B;

    @Nullable
    public InterfaceC0422Gl A0C;
    public HQ A0D;
    public HY A0E;
    public HY A0F;
    public HY A0G;
    public C0443Hg A0H;
    public EnumC0447Hk A0I;
    public String A0J;
    public String A0K;
    public String A0L;
    public String A0M;
    public String A0N;
    public String A0O;
    public Collection<String> A0P;
    public List<HX> A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public HashMap<String, String> A0Q = new HashMap<>();
    public int A05 = 200;
    public int A02 = -1;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C00371i.A0Z
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
            r0 = r0 ^ 58
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A01(int, int, int):java.lang.String");
    }

    public static void A05() {
        A0Z = new byte[]{84, 80, 92, 90, 88, 44, 33, 37, 32, 40, 45, 42, 33, 11, 22, 11, 19, 26, 89, 91, 86, 86, 101, 78, 85, 101, 91, 89, 78, 83, 85, 84, 51, 50, 35, 50, 52, 35, 62, 56, 57, 8, 36, 35, 37, 62, 57, 48, 36, 122, 85, 80, 90, 82, 25, 85, 86, 94, 94, 92, 93, 102, 99, 100, 97, 85, 110, 111, 121, 105, 120, 99, 122, 126, 99, 101, 100, 96, 97, 98, 109, 106, 109, 112, 109, 107, 106, 5, 26, 22, 4, 18, 17, 26, 31, 26, 7, 10, 44, 16, 27, 22, 16, 24, 44, 26, 29, 7, 22, 1, 5, 18, 31, 20, 8, 5, 29, 59, 16, 22, 5, 10, 23, 8, 5, 16, 13, 11, 10, 31, 2, 13, 28, 31, 4, 3, 24, 51, 15, 3, 1, 28, 30, 9, 31, 31, 51, 29, 25, 13, 0, 5, 24, 21, 8, 23, 26, 27, 17, 33, 11, 12, 18, 93, 95, 76, 90, 87, 80, 90, 112, 71, 71, 90, 71, 21, 80, 77, 80, 86, 64, 65, 92, 91, 82, 21, 84, 86, 65, 92, 90, 91, 53, 40, 39, 54, 53, 46, 41, 50, 99, 70, 97, 74, 77, 75, 65, 71, 81, 102, 119, 99, 101, 115, 73, 98, 100, 119, 120, 101, 122, 119, 98, Byte.MAX_VALUE, 121, 120, 21, 16, 2, 17, 6, 0, 29, 7, 17, 6, 43, 26, 21, 25, 17, 20, 22, 5, 19, 20, 25, 3, 105, 70, 67, 73, 65, 10, 66, 75, 90, 90, 79, 68, 79, 78, 10, 69, 68, 10, 70, 69, 73, 65, 89, 73, 88, 79, 79, 68, 10, 75, 78, 10, 21, 24, 25, 19, 35, 17, 12, 24, 21, 46, 33, 34, 44, 37, 96, 52, 47, 96, 48, 33, 50, 51, 37, 96, 35, 33, 50, 47, 53, 51, 37, 44, 96, 36, 33, 52, 33, 110, 97, 126, 114, 96, 118, 117, 126, 123, 126, 99, 110, 72, 116, Byte.MAX_VALUE, 114, 116, 124, 72, 126, 121, 126, 99, 126, 118, 123, 72, 115, 114, 123, 118, 110, 51, 62, 53, 40, 51, 53, 35, 34, 25, 52, 35, 54, 41, 52, 50, 25, 51, 52, 42, 104, 116, 120, 114, 122, 119, 68, 120, 116, 117, 111, 126, 99, 111, 105, 106, 117, 116, 105, 117, 104, Byte.MAX_VALUE, 126, 69, 110, 104, 123, 116, 105, 118, 123, 110, 115, 117, 116, 101, 98, 122, 109, 96, 101, 104, 109, 120, 101, 99, 98, 83, 110, 105, 100, 109, 122, 101, 99, 126, 32, 55, 35, 39, 55, 33, 38, 13, 59, 54, 41, 44, 23, 43, 32, 39, 33, 43, 45, 59, 23, 36, 33, 38, 35, 23, 61, 58, 36, 86, 80, 71, 81, 76, 81, 73, 64, 56, 47, 44, 13, 66, 36, 11, 14, 14, 98, 103, 92, 119, 113, 98, 109, 112, 111, 98, 119, 106, 108, 109, 104, 111, 122, 105, 68, 105, 122, 111, 114, 117, 124, 10, 1, 14, 13, 3, 10, 48, 25, 6, 10, 24, 48, 3, 0, 8, 117, 80, 85, 68, 64, 81, 70, 20, 85, 88, 70, 81, 85, 80, 77, 20, 88, 91, 85, 80, 81, 80, 20, 80, 85, 64, 85, 68, 65, 84, 65, 82, 86, 85, 80, 107, 87, 91, 89, 89, 85, 90, 80, 10, 21, 24, 25, 19, 35, 29, 9, 8, 19, 12, 16, 29, 5, 35, 25, 18, 29, 30, 16, 25, 24, 89, 91, 72, 85, 79, 73, 95, 86, 90, 69, 73, 91, 6, 4, 25, 27, 25, 2, 19, 18, 41, 2, 4, 23, 24, 5, 26, 23, 2, 31, 25, 24, 108, 105, 82, 110, 101, 98, 100, 110, 104, 126, 82, 100, 110, 98, 99, 85, 94, 81, 82, 92, 85, 111, 67, 94, 81, 64, 67, 88, 95, 68, 111, 92, 95, 87, 4, 14, 2, 3, 121, 100, 107, 122, 121, 98, 101, 126, 85, 102, 101, 109, 85, 110, 111, 102, 107, 115, 85, 121, 111, 105, 101, 100, 110, 16, 36, 53, 56, 52, 63, 50, 52, 113, 31, 52, 37, 38, 62, 35, 58, 113, 29, 62, 48, 53, 52, 53, 84, 91, 106, 89, 90, 82, 90, 106, 65, 76, 69, 80};
    }

    static {
        A05();
        A0a = C00371i.class.getSimpleName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:            return (java.util.HashMap) r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.String> A03(java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r5 = this;
            r0 = 0
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r2 = 583(0x247, float:8.17E-43)
            r1 = 4
            r0 = 22
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r6.containsKey(r0)
            if (r0 == 0) goto L70
            r0 = 2
        L16:
            switch(r0) {
                case 2: goto L1a;
                case 3: goto L39;
                case 4: goto L4f;
                case 5: goto L72;
                default: goto L19;
            }
        L19:
            goto L16
        L1a:
            java.util.Map r6 = (java.util.Map) r6
            java.util.HashMap r4 = (java.util.HashMap) r4
            r2 = 583(0x247, float:8.17E-43)
            r1 = 4
            r0 = 22
            java.lang.String r3 = A01(r2, r1, r0)
            r2 = 583(0x247, float:8.17E-43)
            r1 = 4
            r0 = 22
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.Object r0 = r6.get(r0)
            r4.put(r3, r0)
            r0 = 3
            goto L16
        L39:
            java.util.Map r6 = (java.util.Map) r6
            r2 = 192(0xc0, float:2.69E-43)
            r1 = 8
            r0 = 124(0x7c, float:1.74E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r6.containsKey(r0)
            if (r0 == 0) goto L4d
            r0 = 4
            goto L16
        L4d:
            r0 = 5
            goto L16
        L4f:
            java.util.Map r6 = (java.util.Map) r6
            java.util.HashMap r4 = (java.util.HashMap) r4
            r2 = 192(0xc0, float:2.69E-43)
            r1 = 8
            r0 = 124(0x7c, float:1.74E-43)
            java.lang.String r3 = A01(r2, r1, r0)
            r2 = 192(0xc0, float:2.69E-43)
            r1 = 8
            r0 = 124(0x7c, float:1.74E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.Object r0 = r6.get(r0)
            r4.put(r3, r0)
            r0 = 5
            goto L16
        L70:
            r0 = 3
            goto L16
        L72:
            java.util.HashMap r4 = (java.util.HashMap) r4
            java.util.Map r4 = (java.util.Map) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A03(java.util.Map):java.util.Map");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0028, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04() {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = r2.A0W
            if (r0 != 0) goto L26
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L14;
                case 4: goto L1f;
                case 5: goto L28;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            com.facebook.ads.redexgen.X.Gl r0 = r2.A0C
            if (r0 == 0) goto L12
            r0 = 3
            goto L6
        L12:
            r0 = 4
            goto L6
        L14:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            com.facebook.ads.redexgen.X.Gl r1 = r2.A0C
            java.lang.String r0 = r2.A0M
            r1.A7o(r0)
            r0 = 4
            goto L6
        L1f:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            r0 = 1
            r2.A0W = r0
            r0 = 5
            goto L6
        L26:
            r0 = 5
            goto L6
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A04():void");
    }

    private void A06(C0362Ec c0362Ec, JSONObject jSONObject, InterfaceC0422Gl interfaceC0422Gl, String str, int i, int i2) {
        this.A0V = true;
        this.A0B = c0362Ec;
        this.A0C = interfaceC0422Gl;
        this.A02 = i;
        this.A01 = i2;
        A08(jSONObject, str);
    }

    private void A07(Map<String, String> map, final Map<String, String> map2) {
        try {
            final Map<String, String> urlParams = A03(map);
            new Handler().postDelayed(new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.1h
                /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:            return;     */
                @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void A05() {
                    /*
                        r4 = this;
                        r3 = r4
                        r2 = 0
                        com.facebook.ads.redexgen.X.1i r0 = com.facebook.ads.redexgen.X.C00371i.this
                        java.lang.String r0 = com.facebook.ads.redexgen.X.C00371i.A02(r0)
                        boolean r0 = android.text.TextUtils.isEmpty(r0)
                        if (r0 != 0) goto L45
                        r0 = 2
                    Lf:
                        switch(r0) {
                            case 2: goto L13;
                            case 3: goto L30;
                            case 4: goto L47;
                            default: goto L12;
                        }
                    L12:
                        goto Lf
                    L13:
                        com.facebook.ads.redexgen.X.1h r3 = (com.facebook.ads.redexgen.X.C00361h) r3
                        java.util.HashMap r2 = new java.util.HashMap
                        r2.<init>()
                        java.util.Map r0 = r2
                        r2.putAll(r0)
                        java.util.Map r0 = r3
                        r2.putAll(r0)
                        com.facebook.ads.redexgen.X.1i r0 = com.facebook.ads.redexgen.X.C00371i.this
                        com.facebook.ads.redexgen.X.Gl r0 = com.facebook.ads.redexgen.X.C00371i.A00(r0)
                        if (r0 == 0) goto L2e
                        r0 = 3
                        goto Lf
                    L2e:
                        r0 = 4
                        goto Lf
                    L30:
                        com.facebook.ads.redexgen.X.1h r3 = (com.facebook.ads.redexgen.X.C00361h) r3
                        java.util.HashMap r2 = (java.util.HashMap) r2
                        com.facebook.ads.redexgen.X.1i r0 = com.facebook.ads.redexgen.X.C00371i.this
                        com.facebook.ads.redexgen.X.Gl r1 = com.facebook.ads.redexgen.X.C00371i.A00(r0)
                        com.facebook.ads.redexgen.X.1i r0 = com.facebook.ads.redexgen.X.C00371i.this
                        java.lang.String r0 = com.facebook.ads.redexgen.X.C00371i.A02(r0)
                        r1.A5o(r0, r2)
                        r0 = 4
                        goto Lf
                    L45:
                        r0 = 4
                        goto Lf
                    L47:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00361h.A05():void");
                }
            }, this.A04 * 1000);
        } catch (Exception unused) {
        }
    }

    private void A08(JSONObject jSONObject, String str) {
        if (this.A0S) {
            throw new IllegalStateException(A01(510, 27, 14));
        }
        if (jSONObject == null) {
            return;
        }
        JP.A02(this.A0B, A01(670, 23, 107));
        this.A0K = str;
        this.A0L = jSONObject.optString(A01(424, 10, 104));
        this.A00 = jSONObject.optInt(A01(693, 12, 15), 0);
        String A02 = C0490Jf.A02(jSONObject, A01(541, 12, 14));
        this.A08 = TextUtils.isEmpty(A02) ? null : Uri.parse(A02);
        for (String key : new String[]{A01(226, 15, 78), A01(13, 5, 69), A01(453, 8, 31), A01(5, 8, 126), A01(349, 4, 107), A01(368, 14, 33), A01(61, 16, 48), A01(382, 21, 32), A01(470, 14, 57), A01(587, 20, 76), A01(113, 16, 94), A01(209, 17, 44)}) {
            this.A0Q.put(key, C0490Jf.A02(jSONObject, key));
        }
        String A022 = C0490Jf.A02(jSONObject, A01(18, 14, 0));
        if (!TextUtils.isEmpty(A022)) {
            HashMap<String, String> hashMap = this.A0Q;
            String callToAction = A01(18, 14, 0);
            hashMap.put(callToAction, A022);
        }
        String callToAction2 = A01(641, 4, 87);
        this.A0F = HY.A00(jSONObject.optJSONObject(callToAction2));
        String callToAction3 = A01(0, 5, 7);
        this.A0G = HY.A00(jSONObject.optJSONObject(callToAction3));
        String callToAction4 = A01(484, 11, 33);
        this.A0H = C0443Hg.A00(jSONObject.optJSONObject(callToAction4));
        String callToAction5 = A01(353, 15, 124);
        this.A0M = C0490Jf.A02(jSONObject, callToAction5);
        String callToAction6 = A01(495, 15, 85);
        this.A0X = jSONObject.optBoolean(callToAction6);
        String callToAction7 = A01(622, 19, 10);
        this.A0Y = jSONObject.optBoolean(callToAction7);
        this.A04 = jSONObject.optInt(A01(645, 25, 48), 4);
        this.A03 = jSONObject.optInt(A01(129, 25, 86), 0);
        this.A06 = jSONObject.optInt(A01(318, 31, 45), 0);
        this.A07 = jSONObject.optInt(A01(87, 26, 73), 1000);
        String callToAction8 = A01(607, 15, 55);
        JSONObject adChoicesIconObject = jSONObject.optJSONObject(callToAction8);
        if (adChoicesIconObject != null) {
            this.A0E = HY.A00(adChoicesIconObject);
        }
        this.A0J = C0490Jf.A02(jSONObject, A01(434, 19, 114));
        this.A09 = AnonymousClass13.A00(jSONObject.optString(A01(403, 21, 54)));
        JSONArray jSONArray = null;
        try {
            jSONArray = new JSONArray(jSONObject.optString(A01(32, 17, 109)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.A0P = AnonymousClass15.A01(jSONArray);
        this.A0O = C0490Jf.A02(jSONObject, A01(154, 9, 68));
        this.A0N = C0490Jf.A02(jSONObject, A01(279, 9, 70));
        if (!jSONObject.has(A01(553, 22, 70))) {
            this.A0I = EnumC0447Hk.A02;
        } else {
            this.A0I = jSONObject.optBoolean(A01(553, 22, 70)) ? EnumC0447Hk.A04 : EnumC0447Hk.A03;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(A01(575, 8, 0));
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    C00371i c00371i = new C00371i();
                    c00371i.A06(this.A0B, optJSONArray.getJSONObject(i), this.A0C, this.A0K, i, length);
                    arrayList.add(new HX(this.A0B, c00371i, (C0403Fr) null, this.A0D));
                }
                this.A0R = arrayList;
            }
        } catch (JSONException e2) {
            Log.e(A0a, A01(288, 30, 122), e2);
        }
        this.A0S = true;
        this.A0T = A09();
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x008f, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A09() {
        /*
            r6 = this;
            r4 = r6
            r5 = 0
            boolean r0 = r4.A0V
            if (r0 != 0) goto L8c
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L49;
                case 3: goto L2b;
                case 4: goto L20;
                case 5: goto L16;
                case 6: goto Lb;
                case 7: goto L67;
                case 8: goto L73;
                case 9: goto L83;
                case 10: goto L8f;
                case 11: goto L87;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            boolean r0 = r4.A0V
            if (r0 == 0) goto L13
            r0 = 7
            goto L7
        L13:
            r0 = 11
            goto L7
        L16:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            com.facebook.ads.redexgen.X.HY r0 = r4.A0F
            if (r0 != 0) goto L1e
            r0 = 6
            goto L7
        L1e:
            r0 = 7
            goto L7
        L20:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            boolean r0 = r4.A0V
            if (r0 == 0) goto L28
            r0 = 5
            goto L7
        L28:
            r0 = 11
            goto L7
        L2b:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r4.A0Q
            r2 = 13
            r1 = 5
            r0 = 69
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.Object r0 = r3.get(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L46
            r0 = 4
            goto L7
        L46:
            r0 = 11
            goto L7
        L49:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r4.A0Q
            r2 = 226(0xe2, float:3.17E-43)
            r1 = 15
            r0 = 78
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.Object r0 = r3.get(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L65
            r0 = 3
            goto L7
        L65:
            r0 = 5
            goto L7
        L67:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            com.facebook.ads.redexgen.X.HY r0 = r4.A0G
            if (r0 != 0) goto L70
            r0 = 8
            goto L7
        L70:
            r0 = 9
            goto L7
        L73:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            com.facebook.ads.internal.protocol.AdPlacementType r1 = r4.A4p()
            com.facebook.ads.internal.protocol.AdPlacementType r0 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE_BANNER
            if (r1 != r0) goto L80
            r0 = 9
            goto L7
        L80:
            r0 = 11
            goto L7
        L83:
            r5 = 1
            r0 = 10
            goto L7
        L87:
            r5 = 0
            r0 = 10
            goto L7
        L8c:
            r0 = 3
            goto L7
        L8f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A09():boolean");
    }

    public final int A0A() {
        return this.A00;
    }

    public final int A0B() {
        return this.A01;
    }

    public final int A0C() {
        return this.A02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0D() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            int r0 = r3.A03
            if (r0 < 0) goto L20
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L17;
                case 4: goto L22;
                case 5: goto L1a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.1i r3 = (com.facebook.ads.redexgen.X.C00371i) r3
            int r1 = r3.A03
            r0 = 100
            if (r1 <= r0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 5
            goto L7
        L17:
            r2 = 0
            r0 = 4
            goto L7
        L1a:
            com.facebook.ads.redexgen.X.1i r3 = (com.facebook.ads.redexgen.X.C00371i) r3
            int r2 = r3.A03
            r0 = 4
            goto L7
        L20:
            r0 = 3
            goto L7
        L22:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0D():int");
    }

    public final int A0E() {
        return this.A05;
    }

    public final int A0F() {
        return this.A06;
    }

    public final int A0G() {
        return this.A07;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.HY A0H() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 != 0) goto L16
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L18;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            com.facebook.ads.redexgen.X.HY r1 = r2.A0E
            r0 = 3
            goto L9
        L16:
            r0 = 4
            goto L9
        L18:
            com.facebook.ads.redexgen.X.HY r1 = (com.facebook.ads.redexgen.X.HY) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0H():com.facebook.ads.redexgen.X.HY");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.HY A0I() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 != 0) goto L16
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L18;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            com.facebook.ads.redexgen.X.HY r1 = r2.A0G
            r0 = 3
            goto L9
        L16:
            r0 = 4
            goto L9
        L18:
            com.facebook.ads.redexgen.X.HY r1 = (com.facebook.ads.redexgen.X.HY) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0I():com.facebook.ads.redexgen.X.HY");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.HY A0J() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 != 0) goto L16
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L18;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            com.facebook.ads.redexgen.X.HY r1 = r2.A0F
            r0 = 3
            goto L9
        L16:
            r0 = 4
            goto L9
        L18:
            com.facebook.ads.redexgen.X.HY r1 = (com.facebook.ads.redexgen.X.HY) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0J():com.facebook.ads.redexgen.X.HY");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.C0443Hg A0K() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 != 0) goto L19
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1b;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            r2.A04()
            com.facebook.ads.redexgen.X.Hg r1 = r2.A0H
            r0 = 3
            goto L9
        L19:
            r0 = 4
            goto L9
        L1b:
            com.facebook.ads.redexgen.X.Hg r1 = (com.facebook.ads.redexgen.X.C0443Hg) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0K():com.facebook.ads.redexgen.X.Hg");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.EnumC0447Hk A0L() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 != 0) goto L17
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L19;
                case 4: goto L11;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.Hk r1 = com.facebook.ads.redexgen.X.EnumC0447Hk.A02
            r0 = 3
            goto L9
        L11:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            com.facebook.ads.redexgen.X.Hk r1 = r2.A0I
            r0 = 3
            goto L9
        L17:
            r0 = 4
            goto L9
        L19:
            com.facebook.ads.redexgen.X.Hk r1 = (com.facebook.ads.redexgen.X.EnumC0447Hk) r1
            com.facebook.ads.redexgen.X.Hk r1 = (com.facebook.ads.redexgen.X.EnumC0447Hk) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0L():com.facebook.ads.redexgen.X.Hk");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A0M() {
        /*
            r5 = this;
            r4 = r5
            r1 = 0
            boolean r0 = r4.A0e()
            if (r0 != 0) goto L2c
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L2e;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            r4.A04()
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r4.A0Q
            r2 = 349(0x15d, float:4.89E-43)
            r1 = 4
            r0 = 107(0x6b, float:1.5E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = com.facebook.ads.redexgen.X.C0505Jv.A01(r0)
            r0 = 3
            goto L9
        L2c:
            r0 = 4
            goto L9
        L2e:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0M():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A0N() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 != 0) goto L16
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L18;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            java.lang.String r1 = r2.A0J
            r0 = 3
            goto L9
        L16:
            r0 = 4
            goto L9
        L18:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0N():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A0O() {
        /*
            r3 = this;
            r1 = 0
            boolean r0 = r3.A0e()
            if (r0 != 0) goto L1b
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1d;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 0
            r0 = 3
            goto L8
        Lf:
            r2 = 200(0xc8, float:2.8E-43)
            r1 = 9
            r0 = 24
            java.lang.String r1 = A01(r2, r1, r0)
            r0 = 3
            goto L8
        L1b:
            r0 = 4
            goto L8
        L1d:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0O():java.lang.String");
    }

    public final String A0P() {
        return this.A0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A0Q() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 != 0) goto L16
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L18;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            java.lang.String r1 = r2.A0N
            r0 = 3
            goto L9
        L16:
            r0 = 4
            goto L9
        L18:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0Q():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A0R() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 != 0) goto L16
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L18;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            java.lang.String r1 = r2.A0O
            r0 = 3
            goto L9
        L16:
            r0 = 4
            goto L9
        L18:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0R():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A0S(java.lang.String r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 != 0) goto L21
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L23;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            java.lang.String r4 = (java.lang.String) r4
            r2.A04()
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r2.A0Q
            java.lang.Object r1 = r0.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r0 = 3
            goto L9
        L21:
            r0 = 4
            goto L9
        L23:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0S(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.facebook.ads.redexgen.X.HX> A0T() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 != 0) goto L16
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L18;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            java.util.List<com.facebook.ads.redexgen.X.HX> r1 = r2.A0R
            r0 = 3
            goto L9
        L16:
            r0 = 4
            goto L9
        L18:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0T():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0U() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            java.util.List<com.facebook.ads.redexgen.X.HX> r0 = r2.A0R
            if (r0 == 0) goto L3c
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L19;
                case 4: goto L23;
                case 5: goto L2f;
                case 6: goto L3e;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            java.util.List<com.facebook.ads.redexgen.X.HX> r0 = r2.A0R
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L17
            r0 = 3
            goto L7
        L17:
            r0 = 6
            goto L7
        L19:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            java.util.List<com.facebook.ads.redexgen.X.HX> r0 = r2.A0R
            java.util.Iterator r1 = r0.iterator()
            r0 = 4
            goto L7
        L23:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L2d
            r0 = 5
            goto L7
        L2d:
            r0 = 6
            goto L7
        L2f:
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            com.facebook.ads.redexgen.X.HX r0 = (com.facebook.ads.redexgen.X.HX) r0
            r0.unregisterView()
            r0 = 4
            goto L7
        L3c:
            r0 = 6
            goto L7
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0U():void");
    }

    public final void A0V(AnonymousClass25 anonymousClass25) {
        this.A0A = anonymousClass25;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0W(com.facebook.ads.redexgen.X.C0362Ec r10, com.facebook.ads.redexgen.X.AnonymousClass25 r11, com.facebook.ads.redexgen.X.InterfaceC0422Gl r12, java.util.Map<java.lang.String, java.lang.Object> r13, com.facebook.ads.redexgen.X.HQ r14) {
        /*
            r9 = this;
            r4 = r9
            r0 = 0
            r0 = 0
            r3 = 0
            r4.A0B = r10
            r4.A0A = r11
            r4.A0C = r12
            r4.A0D = r14
            r2 = 537(0x219, float:7.52E-43)
            r1 = 4
            r0 = 26
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.Object r5 = r13.get(r0)
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            r2 = 77
            r1 = 10
            r0 = 62
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.Object r6 = r13.get(r0)
            com.facebook.ads.redexgen.X.Fr r6 = (com.facebook.ads.redexgen.X.C0403Fr) r6
            if (r6 == 0) goto L8c
            r0 = 2
        L2e:
            switch(r0) {
                case 2: goto L3a;
                case 3: goto L5b;
                case 4: goto L42;
                case 5: goto L8f;
                case 6: goto L32;
                case 7: goto L7f;
                case 8: goto L88;
                default: goto L31;
            }
        L31:
            goto L2e
        L32:
            com.facebook.ads.redexgen.X.25 r11 = (com.facebook.ads.redexgen.X.AnonymousClass25) r11
            if (r11 == 0) goto L38
            r0 = 7
            goto L2e
        L38:
            r0 = 5
            goto L2e
        L3a:
            com.facebook.ads.redexgen.X.Fr r6 = (com.facebook.ads.redexgen.X.C0403Fr) r6
            int r3 = r6.A06()
            r0 = 3
            goto L2e
        L42:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            com.facebook.ads.redexgen.X.25 r11 = (com.facebook.ads.redexgen.X.AnonymousClass25) r11
            com.facebook.ads.redexgen.X.Hr r8 = new com.facebook.ads.redexgen.X.Hr
            com.facebook.ads.internal.protocol.AdErrorType r7 = com.facebook.ads.internal.protocol.AdErrorType.NO_FILL
            r2 = 463(0x1cf, float:6.49E-43)
            r1 = 7
            r0 = 88
            java.lang.String r0 = A01(r2, r1, r0)
            r8.<init>(r7, r0)
            r11.A7A(r4, r8)
            r0 = 5
            goto L2e
        L5b:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            com.facebook.ads.redexgen.X.Ec r10 = (com.facebook.ads.redexgen.X.C0362Ec) r10
            com.facebook.ads.redexgen.X.Gl r12 = (com.facebook.ads.redexgen.X.InterfaceC0422Gl) r12
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            r4.A05 = r3
            r2 = 461(0x1cd, float:6.46E-43)
            r1 = 2
            r0 = 97
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r0 = com.facebook.ads.redexgen.X.C0490Jf.A02(r5, r0)
            r4.A08(r5, r0)
            boolean r0 = com.facebook.ads.redexgen.X.AnonymousClass15.A03(r10, r4, r12)
            if (r0 == 0) goto L7d
            r0 = 4
            goto L2e
        L7d:
            r0 = 6
            goto L2e
        L7f:
            com.facebook.ads.redexgen.X.1i r4 = (com.facebook.ads.redexgen.X.C00371i) r4
            com.facebook.ads.redexgen.X.25 r11 = (com.facebook.ads.redexgen.X.AnonymousClass25) r11
            r11.A77(r4)
            r0 = 5
            goto L2e
        L88:
            r3 = 200(0xc8, float:2.8E-43)
            r0 = 3
            goto L2e
        L8c:
            r0 = 8
            goto L2e
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0W(com.facebook.ads.redexgen.X.Ec, com.facebook.ads.redexgen.X.25, com.facebook.ads.redexgen.X.Gl, java.util.Map, com.facebook.ads.redexgen.X.HQ):void");
    }

    public final void A0X(Map<String, String> map) {
        C00371i c00371i = this;
        Map<String, String> urlParams = null;
        if (!c00371i.A0e()) {
            return;
        }
        char c = C0413Gc.A0s(c00371i.A0B) ? (char) 4 : (char) 6;
        while (true) {
            switch (c) {
                case 4:
                    map = map;
                    if (!KF.A03(map)) {
                        c = 6;
                        break;
                    } else {
                        c = 5;
                        break;
                    }
                case 5:
                    Log.e(A0a, A01(248, 31, 16));
                    return;
                case 6:
                    map = map;
                    urlParams = new HashMap<>();
                    if (map == null) {
                        c = '\b';
                        break;
                    } else {
                        c = 7;
                        break;
                    }
                case 7:
                    map = map;
                    urlParams = (HashMap) urlParams;
                    urlParams.putAll(map);
                    c = '\b';
                    break;
                case '\b':
                    c00371i = c00371i;
                    JP.A02(c00371i.A0B, A01(49, 12, 3));
                    if (c00371i.A0A == null) {
                        c = '\n';
                        break;
                    } else {
                        c = '\t';
                        break;
                    }
                case '\t':
                    c00371i = c00371i;
                    c00371i.A0A.A76(c00371i);
                    c = '\n';
                    break;
                case '\n':
                    c00371i = c00371i;
                    if (!c00371i.A0V) {
                        c = '\f';
                        break;
                    } else {
                        c = 11;
                        break;
                    }
                case 11:
                    c00371i = c00371i;
                    urlParams = (HashMap) urlParams;
                    urlParams.put(A01(163, 7, 4), String.valueOf(c00371i.A02));
                    urlParams.put(A01(241, 7, 77), String.valueOf(c00371i.A01));
                    c = '\f';
                    break;
                case '\f':
                    C00371i c00371i2 = c00371i;
                    AnonymousClass11 A00 = AnonymousClass12.A00(c00371i2.A0B, c00371i2.A0C, c00371i2.A0K, c00371i2.A08, (HashMap) urlParams);
                    if (A00 == null) {
                        return;
                    }
                    try {
                        A00.A03();
                        return;
                    } catch (Exception e) {
                        Log.e(A0a, A01(170, 22, 15), e);
                        return;
                    }
            }
        }
    }

    public final void A0Y(Map<String, String> map) {
        if (this.A0C != null) {
            this.A0C.A5T(this.A0K, map);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x00fd, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Z(java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0Z(java.util.Map):void");
    }

    public final void A0a(Map<String, String> map) {
        if (this.A0C != null) {
            this.A0C.A5q(this.A0K, map);
        }
    }

    public final void A0b(Map<String, String> map) {
        if (this.A0C != null) {
            this.A0C.A5r(this.A0K, map);
        }
    }

    public final boolean A0c() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x001f, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0d() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0e()
            if (r0 == 0) goto L1d
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L17;
                case 4: goto L1f;
                case 5: goto L1a;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            android.net.Uri r0 = r2.A08
            if (r0 == 0) goto L15
            r0 = 3
            goto L9
        L15:
            r0 = 5
            goto L9
        L17:
            r1 = 1
            r0 = 4
            goto L9
        L1a:
            r1 = 0
            r0 = 4
            goto L9
        L1d:
            r0 = 5
            goto L9
        L1f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0d():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x001d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0e() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0S
            if (r0 == 0) goto L1b
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L15;
                case 4: goto L1d;
                case 5: goto L18;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            boolean r0 = r2.A0T
            if (r0 == 0) goto L13
            r0 = 3
            goto L7
        L13:
            r0 = 5
            goto L7
        L15:
            r1 = 1
            r0 = 4
            goto L7
        L18:
            r1 = 0
            r0 = 4
            goto L7
        L1b:
            r0 = 5
            goto L7
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0e():boolean");
    }

    public final boolean A0f() {
        return this.A0V;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x002d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0g() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Ec r0 = r2.A0B
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0i(r0)
            if (r0 == 0) goto L2b
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1b;
                case 4: goto L25;
                case 5: goto L2d;
                case 6: goto L28;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            boolean r0 = r2.A0e()
            if (r0 == 0) goto L19
            r0 = 3
            goto Lb
        L19:
            r0 = 6
            goto Lb
        L1b:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            boolean r0 = r2.A0X
            if (r0 == 0) goto L23
            r0 = 4
            goto Lb
        L23:
            r0 = 6
            goto Lb
        L25:
            r1 = 1
            r0 = 5
            goto Lb
        L28:
            r1 = 0
            r0 = 5
            goto Lb
        L2b:
            r0 = 6
            goto Lb
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0g():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x002d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0h() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Ec r0 = r2.A0B
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0i(r0)
            if (r0 == 0) goto L2b
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1b;
                case 4: goto L25;
                case 5: goto L2d;
                case 6: goto L28;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            boolean r0 = r2.A0e()
            if (r0 == 0) goto L19
            r0 = 3
            goto Lb
        L19:
            r0 = 6
            goto Lb
        L1b:
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            boolean r0 = r2.A0Y
            if (r0 == 0) goto L23
            r0 = 4
            goto Lb
        L23:
            r0 = 6
            goto Lb
        L25:
            r1 = 1
            r0 = 5
            goto Lb
        L28:
            r1 = 0
            r0 = 5
            goto Lb
        L2b:
            r0 = 6
            goto Lb
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00371i.A0h():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass14, com.facebook.ads.redexgen.X.C1F
    public final String A4V() {
        return this.A0K;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass14
    public final Collection<String> A4Z() {
        return this.A0P;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass14
    public final AnonymousClass13 A4l() {
        return this.A09;
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public AdPlacementType A4p() {
        return AdPlacementType.NATIVE;
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final void onDestroy() {
    }
}
