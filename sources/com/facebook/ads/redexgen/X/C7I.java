package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.net.HttpURLConnection;

/* renamed from: com.facebook.ads.redexgen.X.7I, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C7I implements C7T {
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
            byte[] r1 = com.facebook.ads.redexgen.X.C7I.A00
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
            r0 = r0 ^ 66
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7I.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{106, 93, 91, 93, 81, 78, 93, 24, 77, 74, 84, 2, 24, 30, 10, 10, 10, 23, Byte.MAX_VALUE, 99, 99, 103, 23, 101, 82, 70, 66, 82, 68, 67, 23, 10, 10, 10, 18, 62, 63, 37, 52, 63, 37, 107, 113, 32, 12, 13, 23, 6, 13, 23, 89, 105, 74, 29, 29, 29, 0, 104, 116, 116, 112, 0, 114, 69, 83, 80, 79, 78, 83, 69, 0, 29, 29, 29, 115, 84, 65, 84, 85, 83, 26, 0};
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
            com.facebook.ads.redexgen.X.7I r6 = (com.facebook.ads.redexgen.X.C7I) r6
            java.lang.String r5 = (java.lang.String) r5
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r3 = r0.append(r5)
            r2 = 52
            r1 = 1
            r0 = 50
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7I.A02(java.util.Map):void");
    }

    @Override // com.facebook.ads.redexgen.X.C7T
    public final boolean A5E() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C7T
    public final void A5O(String str) {
        System.out.println(str);
    }

    @Override // com.facebook.ads.redexgen.X.C7T
    public final void A5i(HttpURLConnection httpURLConnection, Object obj) throws IOException {
        A5O(A00(14, 20, 117));
        A5O(httpURLConnection.getRequestMethod() + A00(13, 1, 124) + httpURLConnection.getURL().toString());
        if (obj instanceof String) {
            A5O(A00(34, 9, 19) + ((String) obj));
        }
        A02(httpURLConnection.getRequestProperties());
    }

    @Override // com.facebook.ads.redexgen.X.C7T
    public final void A5k(FN fn) {
        if (fn != null) {
            A5O(A00(53, 21, 98));
            A5O(A00(0, 13, 122) + fn.getUrl());
            A5O(A00(74, 8, 98) + fn.A50());
            A02(fn.A4i());
            A5O(A00(43, 9, 33) + fn.A4M());
        }
    }
}
