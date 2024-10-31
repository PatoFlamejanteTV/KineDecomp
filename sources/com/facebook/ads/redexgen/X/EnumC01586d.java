package com.facebook.ads.redexgen.X;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'A02' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: com.facebook.ads.redexgen.X.6d, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class EnumC01586d {
    public static byte[] A00;
    public static final /* synthetic */ EnumC01586d[] A01;
    public static final EnumC01586d A02;
    public static final EnumC01586d A03;
    public static final EnumC01586d A04;
    public static final EnumC01586d A05;
    public static final EnumC01586d A06;
    public static final EnumC01586d A07;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC01586d.A00
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
            int r0 = r0 + (-72)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC01586d.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A00 = new byte[]{-14, 19, 17, 8, 13, 6, -4, 33, 39, -38, 7, 7, 4, -3, -7, 6, -21, 28, 28, 11, 35, -66, -23, -17, -36, -26, -33, -31, -12, -4, -9, -11, 6, -46, -21, -24, -21, -20, -12, -21, -99, -15, -10, -19, -30, -99, -20, -29, -99, -25, -16, -20, -21, -99, -20, -33, -25, -30, -32, -15, -99, -24, -30, -10};
    }

    public abstract boolean A04(JSONArray jSONArray, int i);

    public abstract boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i);

    public abstract boolean A06(JSONObject jSONObject, String str);

    public abstract boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str);

    static {
        A03();
        final int i = 4;
        final int i2 = 3;
        final int i3 = 2;
        final int i4 = 1;
        final int i5 = 0;
        final String A022 = A02(16, 5, 98);
        A02 = new EnumC01586d(A022, i5) { // from class: com.facebook.ads.redexgen.X.6c
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A04(org.json.JSONArray r3, int r4) {
                /*
                    r2 = this;
                    r1 = 0
                    org.json.JSONArray r0 = r3.optJSONArray(r4)
                    if (r0 == 0) goto L12
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
                    r1 = 1
                    r0 = 3
                    goto L8
                Lf:
                    r1 = 0
                    r0 = 3
                    goto L8
                L12:
                    r0 = 4
                    goto L8
                L14:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01576c.A04(org.json.JSONArray, int):boolean");
            }

            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i6) {
                return AnonymousClass64.A01(jSONArray.optJSONArray(i6), jSONArray2.optJSONArray(i6));
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A06(org.json.JSONObject r3, java.lang.String r4) {
                /*
                    r2 = this;
                    r1 = 0
                    org.json.JSONArray r0 = r3.optJSONArray(r4)
                    if (r0 == 0) goto L12
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
                    r1 = 1
                    r0 = 3
                    goto L8
                Lf:
                    r1 = 0
                    r0 = 3
                    goto L8
                L12:
                    r0 = 4
                    goto L8
                L14:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01576c.A06(org.json.JSONObject, java.lang.String):boolean");
            }

            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return AnonymousClass64.A01(jSONObject.optJSONArray(str), jSONObject2.optJSONArray(str));
            }
        };
        final String A023 = A02(9, 7, 80);
        A03 = new EnumC01586d(A023, i4) { // from class: com.facebook.ads.redexgen.X.6C
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            public final boolean A04(JSONArray jSONArray, int i6) {
                return jSONArray.optBoolean(i6, true) == jSONArray.optBoolean(i6, false);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return r2;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A05(org.json.JSONArray r4, org.json.JSONArray r5, int r6) {
                /*
                    r3 = this;
                    r2 = 0
                    boolean r1 = r4.optBoolean(r6)
                    boolean r0 = r5.optBoolean(r6)
                    if (r1 != r0) goto L16
                    r0 = 2
                Lc:
                    switch(r0) {
                        case 2: goto L10;
                        case 3: goto L18;
                        case 4: goto L13;
                        default: goto Lf;
                    }
                Lf:
                    goto Lc
                L10:
                    r2 = 1
                    r0 = 3
                    goto Lc
                L13:
                    r2 = 0
                    r0 = 3
                    goto Lc
                L16:
                    r0 = 4
                    goto Lc
                L18:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6C.A05(org.json.JSONArray, org.json.JSONArray, int):boolean");
            }

            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optBoolean(str, true) == jSONObject.optBoolean(str, false);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return r2;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A07(org.json.JSONObject r4, org.json.JSONObject r5, java.lang.String r6) {
                /*
                    r3 = this;
                    r2 = 0
                    boolean r1 = r4.optBoolean(r6)
                    boolean r0 = r5.optBoolean(r6)
                    if (r1 != r0) goto L16
                    r0 = 2
                Lc:
                    switch(r0) {
                        case 2: goto L10;
                        case 3: goto L18;
                        case 4: goto L13;
                        default: goto Lf;
                    }
                Lf:
                    goto Lc
                L10:
                    r2 = 1
                    r0 = 3
                    goto Lc
                L13:
                    r2 = 0
                    r0 = 3
                    goto Lc
                L16:
                    r0 = 4
                    goto Lc
                L18:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6C.A07(org.json.JSONObject, org.json.JSONObject, java.lang.String):boolean");
            }
        };
        final String A024 = A02(21, 6, 50);
        A04 = new EnumC01586d(A024, i3) { // from class: com.facebook.ads.redexgen.X.6B
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:            return r8;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A04(org.json.JSONArray r10, int r11) {
                /*
                    r9 = this;
                    r0 = 0
                    r0 = 0
                    r0 = 0
                    r8 = 1
                    r3 = 0
                    r7 = 0
                    int r1 = r10.optInt(r11, r7)
                    int r0 = r10.optInt(r11, r8)
                    if (r1 != r0) goto L41
                    r0 = 2
                L13:
                    switch(r0) {
                        case 2: goto L17;
                        case 3: goto L2e;
                        case 4: goto L43;
                        case 5: goto L2b;
                        default: goto L16;
                    }
                L16:
                    goto L13
                L17:
                    org.json.JSONArray r10 = (org.json.JSONArray) r10
                    double r5 = r10.optDouble(r11, r3)
                    r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                    double r1 = r10.optDouble(r11, r0)
                    int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                    if (r0 != 0) goto L29
                    r0 = 3
                    goto L13
                L29:
                    r0 = 5
                    goto L13
                L2b:
                    r8 = r7
                    r0 = 4
                    goto L13
                L2e:
                    org.json.JSONArray r10 = (org.json.JSONArray) r10
                    int r0 = r10.optInt(r11, r7)
                    double r5 = (double) r0
                    double r1 = r10.optDouble(r11, r3)
                    int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                    if (r0 == 0) goto L3f
                    r0 = 4
                    goto L13
                L3f:
                    r0 = 5
                    goto L13
                L41:
                    r0 = 5
                    goto L13
                L43:
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6B.A04(org.json.JSONArray, int):boolean");
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r5;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A05(org.json.JSONArray r7, org.json.JSONArray r8, int r9) {
                /*
                    r6 = this;
                    r5 = 0
                    double r3 = r7.optDouble(r9)
                    double r1 = r8.optDouble(r9)
                    int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                    if (r0 != 0) goto L18
                    r0 = 2
                Le:
                    switch(r0) {
                        case 2: goto L12;
                        case 3: goto L1a;
                        case 4: goto L15;
                        default: goto L11;
                    }
                L11:
                    goto Le
                L12:
                    r5 = 1
                    r0 = 3
                    goto Le
                L15:
                    r5 = 0
                    r0 = 3
                    goto Le
                L18:
                    r0 = 4
                    goto Le
                L1a:
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6B.A05(org.json.JSONArray, org.json.JSONArray, int):boolean");
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:            return r8;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A06(org.json.JSONObject r10, java.lang.String r11) {
                /*
                    r9 = this;
                    r0 = 0
                    r0 = 0
                    r0 = 0
                    r8 = 1
                    r3 = 0
                    r7 = 0
                    int r1 = r10.optInt(r11, r7)
                    int r0 = r10.optInt(r11, r8)
                    if (r1 != r0) goto L45
                    r0 = 2
                L13:
                    switch(r0) {
                        case 2: goto L17;
                        case 3: goto L30;
                        case 4: goto L47;
                        case 5: goto L2d;
                        default: goto L16;
                    }
                L16:
                    goto L13
                L17:
                    org.json.JSONObject r10 = (org.json.JSONObject) r10
                    java.lang.String r11 = (java.lang.String) r11
                    double r5 = r10.optDouble(r11, r3)
                    r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                    double r1 = r10.optDouble(r11, r0)
                    int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                    if (r0 != 0) goto L2b
                    r0 = 3
                    goto L13
                L2b:
                    r0 = 5
                    goto L13
                L2d:
                    r8 = r7
                    r0 = 4
                    goto L13
                L30:
                    org.json.JSONObject r10 = (org.json.JSONObject) r10
                    java.lang.String r11 = (java.lang.String) r11
                    int r0 = r10.optInt(r11, r7)
                    double r5 = (double) r0
                    double r1 = r10.optDouble(r11, r3)
                    int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                    if (r0 == 0) goto L43
                    r0 = 4
                    goto L13
                L43:
                    r0 = 5
                    goto L13
                L45:
                    r0 = 5
                    goto L13
                L47:
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6B.A06(org.json.JSONObject, java.lang.String):boolean");
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r5;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A07(org.json.JSONObject r7, org.json.JSONObject r8, java.lang.String r9) {
                /*
                    r6 = this;
                    r5 = 0
                    double r3 = r7.optDouble(r9)
                    double r1 = r8.optDouble(r9)
                    int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                    if (r0 != 0) goto L18
                    r0 = 2
                Le:
                    switch(r0) {
                        case 2: goto L12;
                        case 3: goto L1a;
                        case 4: goto L15;
                        default: goto L11;
                    }
                L11:
                    goto Le
                L12:
                    r5 = 1
                    r0 = 3
                    goto Le
                L15:
                    r5 = 0
                    r0 = 3
                    goto Le
                L18:
                    r0 = 4
                    goto Le
                L1a:
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6B.A07(org.json.JSONObject, org.json.JSONObject, java.lang.String):boolean");
            }
        };
        final String A025 = A02(6, 3, 107);
        A05 = new EnumC01586d(A025, i2) { // from class: com.facebook.ads.redexgen.X.6A
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:            return r8;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A04(org.json.JSONArray r10, int r11) {
                /*
                    r9 = this;
                    r0 = 0
                    r0 = 0
                    r0 = 0
                    r8 = 1
                    r3 = 0
                    r7 = 0
                    int r1 = r10.optInt(r11, r7)
                    int r0 = r10.optInt(r11, r8)
                    if (r1 != r0) goto L41
                    r0 = 2
                L13:
                    switch(r0) {
                        case 2: goto L17;
                        case 3: goto L2b;
                        case 4: goto L43;
                        case 5: goto L3e;
                        default: goto L16;
                    }
                L16:
                    goto L13
                L17:
                    org.json.JSONArray r10 = (org.json.JSONArray) r10
                    double r5 = r10.optDouble(r11, r3)
                    r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                    double r1 = r10.optDouble(r11, r0)
                    int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                    if (r0 != 0) goto L29
                    r0 = 3
                    goto L13
                L29:
                    r0 = 5
                    goto L13
                L2b:
                    org.json.JSONArray r10 = (org.json.JSONArray) r10
                    int r0 = r10.optInt(r11, r7)
                    double r5 = (double) r0
                    double r1 = r10.optDouble(r11, r3)
                    int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                    if (r0 != 0) goto L3c
                    r0 = 4
                    goto L13
                L3c:
                    r0 = 5
                    goto L13
                L3e:
                    r8 = r7
                    r0 = 4
                    goto L13
                L41:
                    r0 = 5
                    goto L13
                L43:
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6A.A04(org.json.JSONArray, int):boolean");
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return r2;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A05(org.json.JSONArray r4, org.json.JSONArray r5, int r6) {
                /*
                    r3 = this;
                    r2 = 0
                    int r1 = r4.optInt(r6)
                    int r0 = r5.optInt(r6)
                    if (r1 != r0) goto L16
                    r0 = 2
                Lc:
                    switch(r0) {
                        case 2: goto L10;
                        case 3: goto L18;
                        case 4: goto L13;
                        default: goto Lf;
                    }
                Lf:
                    goto Lc
                L10:
                    r2 = 1
                    r0 = 3
                    goto Lc
                L13:
                    r2 = 0
                    r0 = 3
                    goto Lc
                L16:
                    r0 = 4
                    goto Lc
                L18:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6A.A05(org.json.JSONArray, org.json.JSONArray, int):boolean");
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:            return r8;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A06(org.json.JSONObject r10, java.lang.String r11) {
                /*
                    r9 = this;
                    r0 = 0
                    r0 = 0
                    r0 = 0
                    r8 = 1
                    r3 = 0
                    r7 = 0
                    int r1 = r10.optInt(r11, r7)
                    int r0 = r10.optInt(r11, r8)
                    if (r1 != r0) goto L45
                    r0 = 2
                L13:
                    switch(r0) {
                        case 2: goto L17;
                        case 3: goto L2d;
                        case 4: goto L47;
                        case 5: goto L42;
                        default: goto L16;
                    }
                L16:
                    goto L13
                L17:
                    org.json.JSONObject r10 = (org.json.JSONObject) r10
                    java.lang.String r11 = (java.lang.String) r11
                    double r5 = r10.optDouble(r11, r3)
                    r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                    double r1 = r10.optDouble(r11, r0)
                    int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                    if (r0 != 0) goto L2b
                    r0 = 3
                    goto L13
                L2b:
                    r0 = 5
                    goto L13
                L2d:
                    org.json.JSONObject r10 = (org.json.JSONObject) r10
                    java.lang.String r11 = (java.lang.String) r11
                    int r0 = r10.optInt(r11, r7)
                    double r5 = (double) r0
                    double r1 = r10.optDouble(r11, r3)
                    int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                    if (r0 != 0) goto L40
                    r0 = 4
                    goto L13
                L40:
                    r0 = 5
                    goto L13
                L42:
                    r8 = r7
                    r0 = 4
                    goto L13
                L45:
                    r0 = 5
                    goto L13
                L47:
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6A.A06(org.json.JSONObject, java.lang.String):boolean");
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return r2;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A07(org.json.JSONObject r4, org.json.JSONObject r5, java.lang.String r6) {
                /*
                    r3 = this;
                    r2 = 0
                    int r1 = r4.optInt(r6)
                    int r0 = r5.optInt(r6)
                    if (r1 != r0) goto L16
                    r0 = 2
                Lc:
                    switch(r0) {
                        case 2: goto L10;
                        case 3: goto L18;
                        case 4: goto L13;
                        default: goto Lf;
                    }
                Lf:
                    goto Lc
                L10:
                    r2 = 1
                    r0 = 3
                    goto Lc
                L13:
                    r2 = 0
                    r0 = 3
                    goto Lc
                L16:
                    r0 = 4
                    goto Lc
                L18:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6A.A07(org.json.JSONObject, org.json.JSONObject, java.lang.String):boolean");
            }
        };
        final String A026 = A02(27, 6, 74);
        A06 = new EnumC01586d(A026, i) { // from class: com.facebook.ads.redexgen.X.69
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A04(org.json.JSONArray r3, int r4) {
                /*
                    r2 = this;
                    r1 = 0
                    org.json.JSONObject r0 = r3.optJSONObject(r4)
                    if (r0 == 0) goto L12
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
                    r1 = 1
                    r0 = 3
                    goto L8
                Lf:
                    r1 = 0
                    r0 = 3
                    goto L8
                L12:
                    r0 = 4
                    goto L8
                L14:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass69.A04(org.json.JSONArray, int):boolean");
            }

            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i6) {
                return AnonymousClass64.A02(jSONArray.optJSONObject(i6), jSONArray2.optJSONObject(i6));
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A06(org.json.JSONObject r3, java.lang.String r4) {
                /*
                    r2 = this;
                    r1 = 0
                    org.json.JSONObject r0 = r3.optJSONObject(r4)
                    if (r0 == 0) goto L12
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
                    r1 = 1
                    r0 = 3
                    goto L8
                Lf:
                    r1 = 0
                    r0 = 3
                    goto L8
                L12:
                    r0 = 4
                    goto L8
                L14:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass69.A06(org.json.JSONObject, java.lang.String):boolean");
            }

            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return AnonymousClass64.A02(jSONObject.optJSONObject(str), jSONObject2.optJSONObject(str));
            }
        };
        final String A027 = A02(0, 6, 87);
        final int i6 = 5;
        A07 = new EnumC01586d(A027, i6) { // from class: com.facebook.ads.redexgen.X.65
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A04(org.json.JSONArray r3, int r4) {
                /*
                    r2 = this;
                    r1 = 0
                    java.lang.String r0 = r3.optString(r4)
                    if (r0 == 0) goto L12
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
                    r1 = 1
                    r0 = 3
                    goto L8
                Lf:
                    r1 = 0
                    r0 = 3
                    goto L8
                L12:
                    r0 = 4
                    goto L8
                L14:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass65.A04(org.json.JSONArray, int):boolean");
            }

            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i7) {
                return jSONArray.optString(i7).equals(jSONArray2.optString(i7));
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A06(org.json.JSONObject r3, java.lang.String r4) {
                /*
                    r2 = this;
                    r1 = 0
                    java.lang.String r0 = r3.optString(r4)
                    if (r0 == 0) goto L12
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
                    r1 = 1
                    r0 = 3
                    goto L8
                Lf:
                    r1 = 0
                    r0 = 3
                    goto L8
                L12:
                    r0 = 4
                    goto L8
                L14:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass65.A06(org.json.JSONObject, java.lang.String):boolean");
            }

            @Override // com.facebook.ads.redexgen.X.EnumC01586d
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optString(str).equals(jSONObject2.optString(str));
            }
        };
        A01 = new EnumC01586d[]{A02, A03, A04, A05, A06, A07};
    }

    public EnumC01586d(String str, int i) {
    }

    public static EnumC01586d A00(JSONArray jSONArray, int i) {
        EnumC01586d enumC01586d = null;
        EnumC01586d[] values = values();
        int length = values.length;
        int i2 = 0;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    if (i2 >= length) {
                        c = 6;
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    jSONArray = jSONArray;
                    values = values;
                    enumC01586d = values[i2];
                    if (!enumC01586d.A04(jSONArray, i)) {
                        c = 5;
                        break;
                    } else {
                        c = 4;
                        break;
                    }
                case 4:
                    return enumC01586d;
                case 5:
                    i2++;
                    c = 2;
                    break;
                case 6:
                    throw new AssertionError(A02(33, 31, 53));
            }
        }
    }

    public static EnumC01586d A01(JSONObject jSONObject, String str) {
        EnumC01586d enumC01586d = null;
        EnumC01586d[] values = values();
        int length = values.length;
        int i = 0;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    if (i >= length) {
                        c = 6;
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    jSONObject = jSONObject;
                    str = str;
                    values = values;
                    enumC01586d = values[i];
                    if (!enumC01586d.A06(jSONObject, str)) {
                        c = 5;
                        break;
                    } else {
                        c = 4;
                        break;
                    }
                case 4:
                    return enumC01586d;
                case 5:
                    i++;
                    c = 2;
                    break;
                case 6:
                    throw new AssertionError(A02(33, 31, 53));
            }
        }
    }

    public static EnumC01586d valueOf(String str) {
        return (EnumC01586d) Enum.valueOf(EnumC01586d.class, str);
    }

    public static EnumC01586d[] values() {
        return (EnumC01586d[]) A01.clone();
    }
}
