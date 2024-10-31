package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Aj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0265Aj {
    public static byte[] A07;
    public int A00;
    public final AA A01;
    public final C0261Af A02;
    public final C0262Ag A03;
    public final C0263Ah A04;
    public final C0266Ak A05;
    public final EE A06;

    static {
        A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0265Aj.A07
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
            r0 = r0 ^ 82
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0265Aj.A02(int, int, int):java.lang.String");
    }

    public static void A04() {
        A07 = new byte[]{36, 40};
    }

    public C0265Aj(Context context, C0266Ak c0266Ak, AA aa) {
        this.A03 = new C0262Ag(context, aa);
        this.A04 = new C0263Ah(context, aa);
        this.A02 = new C0261Af(context, aa);
        this.A06 = new EE(context, aa);
        this.A05 = c0266Ak;
        this.A01 = aa;
        A05();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return r1;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C0345Dl A00(int r2, java.lang.String r3, int r4, int r5) {
        /*
            r1 = 0
            switch(r2) {
                case 10300: goto L22;
                case 10920: goto L20;
                case 10940: goto L24;
                case 10941: goto L26;
                case 10943: goto L28;
                case 10944: goto L2a;
                case 10945: goto L2c;
                default: goto L4;
            }
        L4:
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L2e;
                case 4: goto Lc;
                case 5: goto L16;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            r1 = 0
            r0 = 3
            goto L5
        Lc:
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.Dk r0 = com.facebook.ads.redexgen.X.EnumC0344Dk.A03
            com.facebook.ads.redexgen.X.Dl r1 = A01(r3, r4, r5, r0)
            r0 = 3
            goto L5
        L16:
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.Dk r0 = com.facebook.ads.redexgen.X.EnumC0344Dk.A02
            com.facebook.ads.redexgen.X.Dl r1 = A01(r3, r4, r5, r0)
            r0 = 3
            goto L5
        L20:
            r0 = 5
            goto L5
        L22:
            r0 = 4
            goto L5
        L24:
            r0 = 4
            goto L5
        L26:
            r0 = 4
            goto L5
        L28:
            r0 = 4
            goto L5
        L2a:
            r0 = 4
            goto L5
        L2c:
            r0 = 4
            goto L5
        L2e:
            com.facebook.ads.redexgen.X.Dl r1 = (com.facebook.ads.redexgen.X.C0345Dl) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0265Aj.A00(int, java.lang.String, int, int):com.facebook.ads.redexgen.X.Dl");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:            return r2;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C0345Dl A01(java.lang.String r3, int r4, int r5, com.facebook.ads.redexgen.X.EnumC0344Dk r6) {
        /*
            r0 = 0
            r2 = 0
            int[] r1 = com.facebook.ads.redexgen.X.C0264Ai.A00
            int r0 = r6.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L2c;
                case 2: goto L2e;
                default: goto Ld;
            }
        Ld:
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L30;
                case 3: goto L23;
                case 4: goto L12;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.Dl r2 = new com.facebook.ads.redexgen.X.Dl
            int r0 = java.lang.Integer.parseInt(r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.<init>(r0, r4, r5)
            r0 = 2
            goto Le
        L23:
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.Dl r2 = new com.facebook.ads.redexgen.X.Dl
            r2.<init>(r3, r4, r5)
            r0 = 2
            goto Le
        L2c:
            r0 = 4
            goto Le
        L2e:
            r0 = 3
            goto Le
        L30:
            com.facebook.ads.redexgen.X.Dl r2 = (com.facebook.ads.redexgen.X.C0345Dl) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0265Aj.A01(java.lang.String, int, int, com.facebook.ads.redexgen.X.Dk):com.facebook.ads.redexgen.X.Dl");
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0099, code lost:            return r3;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.facebook.ads.redexgen.X.C0345Dl> A03(int r9) throws org.json.JSONException {
        /*
            r8 = this;
            r6 = 0
            r5 = 0
            r0 = 0
            r0 = 0
            r4 = 0
            r7 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.facebook.ads.redexgen.X.AA r0 = r8.A01
            java.util.Map r2 = r0.A0i()
            if (r2 == 0) goto L93
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L4b;
                case 3: goto L24;
                case 4: goto L95;
                case 5: goto L34;
                case 6: goto L18;
                case 7: goto L57;
                case 8: goto L6c;
                case 9: goto L7a;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            java.util.Iterator r7 = (java.util.Iterator) r7
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L22
            r0 = 7
            goto L14
        L22:
            r0 = 4
            goto L14
        L24:
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            boolean r0 = r2.containsKey(r0)
            if (r0 != 0) goto L32
            r0 = 4
            goto L14
        L32:
            r0 = 5
            goto L14
        L34:
            java.util.Map r2 = (java.util.Map) r2
            org.json.JSONObject r5 = new org.json.JSONObject
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r5.<init>(r0)
            java.util.Iterator r7 = r5.keys()
            r0 = 6
            goto L14
        L4b:
            java.util.Map r2 = (java.util.Map) r2
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L55
            r0 = 3
            goto L14
        L55:
            r0 = 4
            goto L14
        L57:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r6 = r7.next()
            java.lang.String r6 = (java.lang.String) r6
            org.json.JSONArray r4 = r5.getJSONArray(r6)
            if (r4 == 0) goto L6a
            r0 = 8
            goto L14
        L6a:
            r0 = 6
            goto L14
        L6c:
            org.json.JSONArray r4 = (org.json.JSONArray) r4
            int r1 = r4.length()
            r0 = 2
            if (r1 != r0) goto L78
            r0 = 9
            goto L14
        L78:
            r0 = 6
            goto L14
        L7a:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.lang.String r6 = (java.lang.String) r6
            org.json.JSONArray r4 = (org.json.JSONArray) r4
            r0 = 0
            int r1 = r4.getInt(r0)
            r0 = 1
            int r0 = r4.getInt(r0)
            com.facebook.ads.redexgen.X.Dl r0 = A00(r9, r6, r1, r0)
            r3.add(r0)
            r0 = 6
            goto L14
        L93:
            r0 = 4
            goto L14
        L95:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.List r3 = (java.util.List) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0265Aj.A03(int):java.util.List");
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    private final void A05() {
        try {
            JSONObject jsonObject = new JSONObject(this.A01.A0h());
            Integer timestamp = jsonObject.has(A02(1, 1, 14)) ? Integer.valueOf(jsonObject.getInt(A02(1, 1, 14))) : null;
            if (timestamp == null) {
                return;
            }
            this.A00 = timestamp.intValue();
            this.A06.A04(this.A00);
            A06(jsonObject.getJSONArray(A02(0, 1, 21)));
        } catch (Throwable t) {
            AK.A03(t);
        }
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private void A06(JSONArray jSONArray) throws Exception {
        JSONArray jSONArray2;
        InterfaceC0267Al interfaceC0267Al;
        Map<Integer, InterfaceC0267Al> A02 = this.A05.A02();
        if (A02 == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length() && (jSONArray2 = jSONArray.getJSONArray(i)) != null && jSONArray2.length() == 2; i++) {
            if ((jSONArray2.get(0) instanceof Integer) && (jSONArray2.get(1) instanceof Integer)) {
                int i2 = jSONArray2.getInt(0);
                int signalFlagsEncoded = jSONArray2.getInt(1);
                EnumSet<EnumC0349Dp> A022 = EnumC0349Dp.A02(signalFlagsEncoded);
                if (!A07(A022)) {
                    if (A022.contains(EnumC0349Dp.A07)) {
                        this.A02.A02(new C0343Dj(i2, A022, A02.get(Integer.valueOf(i2))));
                    } else {
                        List<C0345Dl> list = null;
                        boolean z = false;
                        if (A022.contains(EnumC0349Dp.A08)) {
                            list = A03(i2);
                            z = true;
                        }
                        if (A02.containsKey(Integer.valueOf(i2)) || z) {
                            if (z) {
                                interfaceC0267Al = this.A05.A01(i2, list);
                            } else {
                                interfaceC0267Al = A02.get(Integer.valueOf(i2));
                            }
                            C0343Dj c0343Dj = new C0343Dj(i2, A022, interfaceC0267Al);
                            if (A022.contains(EnumC0349Dp.A06)) {
                                this.A06.A05(c0343Dj);
                            }
                            if (A022.contains(EnumC0349Dp.A0A)) {
                                this.A03.A03(c0343Dj);
                            } else {
                                this.A04.A02(c0343Dj);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0044, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A07(java.util.EnumSet<com.facebook.ads.redexgen.X.EnumC0349Dp> r3) {
        /*
            r2 = this;
            r1 = 0
            com.facebook.ads.redexgen.X.AA r0 = r2.A01
            com.facebook.ads.redexgen.X.Dp r0 = r0.A0a()
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L42
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L34;
                case 3: goto L26;
                case 4: goto L15;
                case 5: goto L12;
                case 6: goto L44;
                case 7: goto L23;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            r1 = 1
            r0 = 6
            goto Le
        L15:
            java.util.EnumSet r3 = (java.util.EnumSet) r3
            com.facebook.ads.redexgen.X.Dp r0 = com.facebook.ads.redexgen.X.EnumC0349Dp.A09
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L21
            r0 = 5
            goto Le
        L21:
            r0 = 7
            goto Le
        L23:
            r1 = 0
            r0 = 6
            goto Le
        L26:
            java.util.EnumSet r3 = (java.util.EnumSet) r3
            com.facebook.ads.redexgen.X.Dp r0 = com.facebook.ads.redexgen.X.EnumC0349Dp.A05
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L32
            r0 = 4
            goto Le
        L32:
            r0 = 5
            goto Le
        L34:
            java.util.EnumSet r3 = (java.util.EnumSet) r3
            com.facebook.ads.redexgen.X.Dp r0 = com.facebook.ads.redexgen.X.EnumC0349Dp.A04
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L40
            r0 = 3
            goto Le
        L40:
            r0 = 5
            goto Le
        L42:
            r0 = 5
            goto Le
        L44:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0265Aj.A07(java.util.EnumSet):boolean");
    }

    public final int A08() {
        return this.A00;
    }

    public final C0261Af A09() {
        return this.A02;
    }

    public final C0262Ag A0A() {
        return this.A03;
    }

    public final C0263Ah A0B() {
        return this.A04;
    }

    public final EE A0C() {
        return this.A06;
    }
}
