package com.facebook.ads.redexgen.X;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Dv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0355Dv extends AbstractC0351Dr<Float> {
    public static byte[] A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0355Dv.A00
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
            r0 = r0 ^ 32
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0355Dv.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{68};
    }

    public C0355Dv(long j, @Nullable E7 e7, float f) {
        super(j, e7, Float.valueOf(f), E8.A05);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    public final int A06() {
        return 4;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    public final JSONObject A08(JSONObject jSONObject) throws JSONException {
        jSONObject.put(A00(0, 1, 18), A07());
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:            return r2;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.lang.Float> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A(com.facebook.ads.redexgen.X.AbstractC0351Dr<java.lang.Float> r4) {
        /*
            r3 = this;
            r2 = 0
            java.lang.Object r0 = r3.A07()
            java.lang.Float r0 = (java.lang.Float) r0
            float r1 = r0.floatValue()
            java.lang.Object r0 = r4.A07()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            float r1 = r1 - r0
            float r1 = java.lang.Math.abs(r1)
            float r0 = com.facebook.ads.redexgen.X.AA.A01()
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L2d
            r0 = 2
        L23:
            switch(r0) {
                case 2: goto L27;
                case 3: goto L2f;
                case 4: goto L2a;
                default: goto L26;
            }
        L26:
            goto L23
        L27:
            r2 = 1
            r0 = 3
            goto L23
        L2a:
            r2 = 0
            r0 = 3
            goto L23
        L2d:
            r0 = 4
            goto L23
        L2f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0355Dv.A0A(com.facebook.ads.redexgen.X.Dr):boolean");
    }
}
