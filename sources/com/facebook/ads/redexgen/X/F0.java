package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: assets/audience_network.dex */
public abstract class F0 implements F5 {
    public static byte[] A01;
    public final C7T A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.F0.A01
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
            int r0 = r0 + (-8)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.F0.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-115, -71, -72, -66, -81, -72, -66, 119, -98, -61, -70, -81, -111, -77, -77, -75, -64, -60, 125, -109, -72, -79, -62, -61, -75, -60, -91, -60, -42, -52, -58, -75, -56, -44, -40, -56, -42, -41, -85, -60, -47, -57, -49, -56, -43, -111, -46, -47, -88, -43, -43, -46, -43, -125, -54, -46, -41, 125, 124, 110, 85, 96};
    }

    public F0() {
        this(new C7I());
    }

    public F0(C7T c7t) {
        this.A00 = c7t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0048, code lost:            return r5;     */
    @Override // com.facebook.ads.redexgen.X.F5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A6b(com.facebook.ads.redexgen.X.EQ r8) {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.FN r4 = r8.A00()
            com.facebook.ads.redexgen.X.7T r0 = r6.A00
            boolean r0 = r0.A5E()
            if (r0 == 0) goto L46
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L2b;
                case 3: goto L23;
                case 4: goto L17;
                case 5: goto L14;
                case 6: goto L48;
                case 7: goto L43;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r5 = 1
            r0 = 6
            goto L10
        L17:
            com.facebook.ads.redexgen.X.FN r4 = (com.facebook.ads.redexgen.X.FN) r4
            int r0 = r4.A50()
            if (r0 <= 0) goto L21
            r0 = 5
            goto L10
        L21:
            r0 = 7
            goto L10
        L23:
            com.facebook.ads.redexgen.X.FN r4 = (com.facebook.ads.redexgen.X.FN) r4
            if (r4 == 0) goto L29
            r0 = 4
            goto L10
        L29:
            r0 = 7
            goto L10
        L2b:
            com.facebook.ads.redexgen.X.F0 r6 = (com.facebook.ads.redexgen.X.F0) r6
            com.facebook.ads.redexgen.X.EQ r8 = (com.facebook.ads.redexgen.X.EQ) r8
            com.facebook.ads.redexgen.X.7T r3 = r6.A00
            r2 = 26
            r1 = 31
            r0 = 91
            java.lang.String r0 = A00(r2, r1, r0)
            r3.A5O(r0)
            r8.printStackTrace()
            r0 = 3
            goto L10
        L43:
            r5 = 0
            r0 = 6
            goto L10
        L46:
            r0 = 3
            goto L10
        L48:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.F0.A6b(com.facebook.ads.redexgen.X.EQ):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.F5
    public final HttpURLConnection A7g(String str) throws IOException {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    @Override // com.facebook.ads.redexgen.X.F5
    public final InputStream A7h(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getInputStream();
    }

    @Override // com.facebook.ads.redexgen.X.F5
    public final OutputStream A7i(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    @Override // com.facebook.ads.redexgen.X.F5
    public final void A7q(HttpURLConnection httpURLConnection, EnumC0371El enumC0371El, String str) throws IOException {
        httpURLConnection.setRequestMethod(enumC0371El.A02());
        httpURLConnection.setDoOutput(enumC0371El.A04());
        httpURLConnection.setDoInput(enumC0371El.A03());
        if (str != null) {
            httpURLConnection.setRequestProperty(A00(0, 12, 66), str);
        }
        httpURLConnection.setRequestProperty(A00(12, 14, 72), A00(57, 5, 32));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:            r1 = r1;        r1.flush();     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:            return r1.toByteArray();     */
    @Override // com.facebook.ads.redexgen.X.F5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] A7x(java.io.InputStream r5) throws java.io.IOException {
        /*
            r4 = this;
            r3 = 0
            r0 = 0
            r0 = 0
            r0 = 16384(0x4000, float:2.2959E-41)
            byte[] r2 = new byte[r0]
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L20;
                case 4: goto L2a;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            java.io.InputStream r5 = (java.io.InputStream) r5
            byte[] r2 = (byte[]) r2
            int r3 = r5.read(r2)
            r0 = -1
            if (r3 == r0) goto L1e
            r0 = 3
            goto Ld
        L1e:
            r0 = 4
            goto Ld
        L20:
            byte[] r2 = (byte[]) r2
            java.io.ByteArrayOutputStream r1 = (java.io.ByteArrayOutputStream) r1
            r0 = 0
            r1.write(r2, r0, r3)
            r0 = 2
            goto Ld
        L2a:
            java.io.ByteArrayOutputStream r1 = (java.io.ByteArrayOutputStream) r1
            r1.flush()
            byte[] r0 = r1.toByteArray()
            byte[] r0 = (byte[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.F0.A7x(java.io.InputStream):byte[]");
    }

    @Override // com.facebook.ads.redexgen.X.F5
    public final void A8o(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }
}
