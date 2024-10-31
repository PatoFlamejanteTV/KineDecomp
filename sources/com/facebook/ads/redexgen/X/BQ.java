package com.facebook.ads.redexgen.X;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public class BQ implements BI<Integer> {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final int A02;

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
            byte[] r1 = com.facebook.ads.redexgen.X.BQ.A03
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
            r0 = r0 ^ 25
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.BQ.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A03 = new byte[]{63, 41, 94, 90, 6, 10};
    }

    public BQ(int i, int i2, int i3) {
        this.A02 = i;
        this.A00 = i2;
        this.A01 = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.BI
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final JSONObject A8S(Integer num, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A00(2, 2, 42), this.A02);
        jSONObject2.put(A00(0, 2, 69), this.A00);
        jSONObject2.put(A00(4, 2, 114), this.A01);
        jSONObject.put(num.toString(), jSONObject2);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0034, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.BI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A5B(java.lang.Object r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.BQ r5 = (com.facebook.ads.redexgen.X.BQ) r5
            int r1 = r3.A01
            int r0 = r5.A01
            if (r1 != r0) goto L32
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L1e;
                case 4: goto L2c;
                case 5: goto L34;
                case 6: goto L2f;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.BQ r3 = (com.facebook.ads.redexgen.X.BQ) r3
            com.facebook.ads.redexgen.X.BQ r5 = (com.facebook.ads.redexgen.X.BQ) r5
            int r1 = r3.A00
            int r0 = r5.A00
            if (r1 != r0) goto L1c
            r0 = 3
            goto Lc
        L1c:
            r0 = 6
            goto Lc
        L1e:
            com.facebook.ads.redexgen.X.BQ r3 = (com.facebook.ads.redexgen.X.BQ) r3
            com.facebook.ads.redexgen.X.BQ r5 = (com.facebook.ads.redexgen.X.BQ) r5
            int r1 = r3.A02
            int r0 = r5.A02
            if (r1 != r0) goto L2a
            r0 = 4
            goto Lc
        L2a:
            r0 = 6
            goto Lc
        L2c:
            r2 = 1
            r0 = 5
            goto Lc
        L2f:
            r2 = 0
            r0 = 5
            goto Lc
        L32:
            r0 = 6
            goto Lc
        L34:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.BQ.A5B(java.lang.Object):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.BI
    public final int A8O() {
        return A00(2, 2, 42).getBytes().length + A00(0, 2, 69).getBytes().length + A00(4, 2, 114).getBytes().length + 12;
    }
}
