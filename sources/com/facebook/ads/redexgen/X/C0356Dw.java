package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Dw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0356Dw extends AbstractC0351Dr<HashMap<String, Integer>> {
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0356Dw.A00
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
            int r0 = r0 + (-15)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0356Dw.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{-10};
    }

    public C0356Dw(long j, @Nullable E7 e7, HashMap<String, Integer> hashMap) {
        super(j, e7, hashMap, E8.A07);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:            r0 = A07().size();     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:            return (r0 * 4) + r2;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A06() {
        /*
            r3 = this;
            r0 = 0
            r0 = 0
            java.lang.Object r0 = r3.A07()
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.util.Set r0 = r0.keySet()
            r2 = 0
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L22;
                case 4: goto L32;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L20
            r0 = 3
            goto L12
        L20:
            r0 = 4
            goto L12
        L22:
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            java.lang.String r0 = (java.lang.String) r0
            byte[] r0 = r0.getBytes()
            int r0 = r0.length
            int r2 = r2 + r0
            r0 = 2
            goto L12
        L32:
            r0 = r3
            com.facebook.ads.redexgen.X.Dw r0 = (com.facebook.ads.redexgen.X.C0356Dw) r0
            java.lang.Object r0 = r0.A07()
            java.util.HashMap r0 = (java.util.HashMap) r0
            int r0 = r0.size()
            int r0 = r0 * 4
            int r0 = r0 + r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0356Dw.A06():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:            r6 = r6;        r6.put(A00(0, 1, 113), r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:            return r6;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject A08(org.json.JSONObject r6) throws org.json.JSONException {
        /*
            r5 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            java.lang.Object r4 = r5.A07()
            java.util.HashMap r4 = (java.util.HashMap) r4
            java.util.Set r0 = r4.keySet()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.util.Iterator r2 = r0.iterator()
            r0 = 2
        L17:
            switch(r0) {
                case 2: goto L1b;
                case 3: goto L27;
                case 4: goto L3c;
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
            java.util.HashMap r4 = (java.util.HashMap) r4
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r1 = r2.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r4.get(r1)
            r3.put(r1, r0)
            r0 = 2
            goto L17
        L3c:
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            r2 = 0
            r1 = 1
            r0 = 113(0x71, float:1.58E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            r6.put(r0, r3)
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0356Dw.A08(org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x010e, code lost:            return r9;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.util.HashMap<java.lang.String, java.lang.Integer>> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    @android.annotation.SuppressLint({"Nullable Dereference"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A(com.facebook.ads.redexgen.X.AbstractC0351Dr<java.util.HashMap<java.lang.String, java.lang.Integer>> r13) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0356Dw.A0A(com.facebook.ads.redexgen.X.Dr):boolean");
    }
}
