package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.lang.reflect.Field;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public class CC implements InterfaceC0292Bk {
    public static byte[] A07;

    @Nullable
    public final Class A01;

    @Nullable
    public final String A03 = (String) A02(A03(21, 14, 30));

    @Nullable
    public final String A04 = (String) A02(A03(40, 10, 57));

    @Nullable
    public final Boolean A00 = A00();

    @Nullable
    public final String A05 = (String) A02(A03(0, 6, 82));

    @Nullable
    public final Integer A02 = A01();

    @Nullable
    public final String A06 = (String) A02(A03(9, 12, 110));

    static {
        A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.CC.A07
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
            int r0 = r0 + (-76)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CC.A03(int, int, int):java.lang.String");
    }

    public static void A04() {
        A07 = new byte[]{-28, -22, -33, -12, -19, -16, -83, -75, -80, 16, -1, 12, 13, 3, 9, 8, 25, 8, -5, 7, -1, -85, -70, -70, -74, -77, -83, -85, -66, -77, -71, -72, -55, -77, -82, -68, -51, -33, 48, 29, -57, -38, -50, -47, -55, -28, -39, -34, -43, -54, 4, -4, -2, -50, -49, -52, -33, -47, 2, -15, -2, -1, -11, -5, -6, 11, -17, -5, -16, -15};
    }

    public CC(@Nullable Class cls) {
        this.A01 = cls;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002e, code lost:            return r3;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Boolean A00() {
        /*
            r4 = this;
            r3 = 0
            r0 = 0
            r2 = 53
            r1 = 5
            r0 = 62
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.Object r1 = r4.A02(r0)
            if (r1 == 0) goto L2a
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L20;
                case 4: goto L2c;
                case 5: goto L27;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            java.lang.Object r1 = (java.lang.Object) r1
            boolean r0 = r1 instanceof java.lang.Boolean
            if (r0 == 0) goto L1e
            r0 = 3
            goto L12
        L1e:
            r0 = 5
            goto L12
        L20:
            java.lang.Object r1 = (java.lang.Object) r1
            r3 = r1
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r0 = 4
            goto L12
        L27:
            r3 = 0
            r0 = 4
            goto L12
        L2a:
            r0 = 5
            goto L12
        L2c:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CC.A00():java.lang.Boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002f, code lost:            return r3;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Integer A01() {
        /*
            r4 = this;
            r3 = 0
            r0 = 0
            r2 = 58
            r1 = 12
            r0 = 96
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.Object r1 = r4.A02(r0)
            if (r1 == 0) goto L2b
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L21;
                case 4: goto L2d;
                case 5: goto L28;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            java.lang.Object r1 = (java.lang.Object) r1
            boolean r0 = r1 instanceof java.lang.Integer
            if (r0 == 0) goto L1f
            r0 = 3
            goto L13
        L1f:
            r0 = 5
            goto L13
        L21:
            java.lang.Object r1 = (java.lang.Object) r1
            r3 = r1
            java.lang.Integer r3 = (java.lang.Integer) r3
            r0 = 4
            goto L13
        L28:
            r3 = 0
            r0 = 4
            goto L13
        L2b:
            r0 = 5
            goto L13
        L2d:
            java.lang.Integer r3 = (java.lang.Integer) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CC.A01():java.lang.Integer");
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    private Object A02(String str) {
        if (this.A01 == null) {
            return null;
        }
        try {
            Field declaredField = this.A01.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x00d1, code lost:            return r3;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0292Bk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A5B(java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CC.A5B(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c9, code lost:            return r11 + r5;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0292Bk
    @android.annotation.SuppressLint({"BadMethodUse-java.lang.String.length"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A8O() {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CC.A8O():int");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0292Bk
    public final JSONObject A8R() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(A03(6, 3, 0), this.A03);
        jSONObject.put(A03(36, 2, 31), this.A04);
        jSONObject.put(A03(35, 1, 12), this.A00);
        jSONObject.put(A03(52, 1, 76), this.A05);
        jSONObject.put(A03(38, 2, 110), this.A02);
        jSONObject.put(A03(50, 2, 66), this.A06);
        return jSONObject;
    }
}
