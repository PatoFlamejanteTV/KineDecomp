package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.settings.AdInternalSettings;
import java.io.IOException;
import java.net.HttpURLConnection;

/* loaded from: assets/audience_network.dex */
public final class J3 implements J2 {
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
            byte[] r1 = com.facebook.ads.redexgen.X.J3.A00
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
            int r0 = r0 + (-88)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.J3.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{-25, -6, -8, -6, -2, 11, -6, -75, 10, 7, 1, -49, -75, -9, -84, -84, -84, -113, -73, -61, -61, -65, -113, -63, -44, -32, -28, -44, -30, -29, -113, -84, -84, -84, -19, 25, 24, 30, 15, 24, 30, -28, -54, 10, 54, 53, 59, 44, 53, 59, 1, -47, -45, -97, -97, -97, -126, -86, -74, -74, -78, -126, -76, -57, -43, -46, -47, -48, -43, -57, -126, -97, -97, -97, -29, 4, -15, 4, 5, 3, -54, -80};
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10) {
        /*
            r9 = this;
            r6 = r9
            r5 = 0
            r7 = 0
            r4 = 0
            if (r10 == 0) goto L74
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L68;
                case 3: goto L5c;
                case 4: goto L46;
                case 5: goto L3a;
                case 6: goto Lb;
                case 7: goto L76;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.J3 r6 = (com.facebook.ads.redexgen.X.J3) r6
            java.lang.String r5 = (java.lang.String) r5
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r3 = r0.append(r5)
            r2 = 52
            r1 = 1
            r0 = 65
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            r6.A5O(r0)
            r0 = 5
            goto L7
        L3a:
            java.util.Iterator r7 = (java.util.Iterator) r7
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L44
            r0 = 6
            goto L7
        L44:
            r0 = 3
            goto L7
        L46:
            java.util.Map r10 = (java.util.Map) r10
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r10.get(r5)
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r7 = r0.iterator()
            r0 = 5
            goto L7
        L5c:
            java.util.Iterator r4 = (java.util.Iterator) r4
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L66
            r0 = 4
            goto L7
        L66:
            r0 = 7
            goto L7
        L68:
            java.util.Map r10 = (java.util.Map) r10
            java.util.Set r0 = r10.keySet()
            java.util.Iterator r4 = r0.iterator()
            r0 = 3
            goto L7
        L74:
            r0 = 7
            goto L7
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.J3.A02(java.util.Map):void");
    }

    @Override // com.facebook.ads.redexgen.X.J2
    public final boolean A5E() {
        return AdInternalSettings.isDebugBuild();
    }

    @Override // com.facebook.ads.redexgen.X.J2
    public final void A5O(String str) {
        System.out.println(str);
    }

    @Override // com.facebook.ads.redexgen.X.J2
    public final void A5i(HttpURLConnection httpURLConnection, Object obj) throws IOException {
        A5O(A00(14, 20, 23));
        A5O(httpURLConnection.getRequestMethod() + A00(13, 1, 127) + httpURLConnection.getURL().toString());
        if (obj instanceof String) {
            A5O(A00(34, 9, 82) + ((String) obj));
        }
        A02(httpURLConnection.getRequestProperties());
    }

    @Override // com.facebook.ads.redexgen.X.J2
    public final void A5j(JA ja) {
        if (ja != null) {
            A5O(A00(53, 21, 10));
            A5O(A00(0, 13, 61) + ja.A02());
            A5O(A00(74, 8, 56) + ja.A00());
            A02(ja.A03());
            A5O(A00(43, 9, 111) + ja.A01());
        }
    }
}
