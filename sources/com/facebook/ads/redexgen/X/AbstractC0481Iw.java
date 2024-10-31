package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.facebook.ads.redexgen.X.Iw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0481Iw implements InterfaceC0480Iv {
    public static byte[] A01;
    public final J2 A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AbstractC0481Iw.A01
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
            r0 = r0 ^ 74
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0481Iw.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{82, 126, Byte.MAX_VALUE, 101, 116, Byte.MAX_VALUE, 101, 60, 69, 104, 97, 116, 12, 46, 46, 40, 61, 57, 96, 14, 37, 44, 63, 62, 40, 57, 15, 44, 62, 36, 46, 31, 40, 60, 56, 40, 62, 57, 5, 44, 35, 41, 33, 40, 63, 99, 34, 35, 8, 63, 63, 34, 63, 109, 42, 34, 57, 35, 34, 48, 91, 78};
    }

    public AbstractC0481Iw() {
        this(new J3());
    }

    public AbstractC0481Iw(J2 j2) {
        this.A00 = j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0047, code lost:            return r5;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0480Iv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A6a(com.facebook.ads.redexgen.X.J9 r8) {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.JA r4 = r8.A00()
            com.facebook.ads.redexgen.X.J2 r0 = r6.A00
            boolean r0 = r0.A5E()
            if (r0 == 0) goto L45
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L2b;
                case 3: goto L23;
                case 4: goto L17;
                case 5: goto L14;
                case 6: goto L47;
                case 7: goto L42;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r5 = 1
            r0 = 6
            goto L10
        L17:
            com.facebook.ads.redexgen.X.JA r4 = (com.facebook.ads.redexgen.X.JA) r4
            int r0 = r4.A00()
            if (r0 <= 0) goto L21
            r0 = 5
            goto L10
        L21:
            r0 = 7
            goto L10
        L23:
            com.facebook.ads.redexgen.X.JA r4 = (com.facebook.ads.redexgen.X.JA) r4
            if (r4 == 0) goto L29
            r0 = 4
            goto L10
        L29:
            r0 = 7
            goto L10
        L2b:
            com.facebook.ads.redexgen.X.Iw r6 = (com.facebook.ads.redexgen.X.AbstractC0481Iw) r6
            com.facebook.ads.redexgen.X.J9 r8 = (com.facebook.ads.redexgen.X.J9) r8
            com.facebook.ads.redexgen.X.J2 r3 = r6.A00
            r2 = 26
            r1 = 31
            r0 = 7
            java.lang.String r0 = A00(r2, r1, r0)
            r3.A5O(r0)
            r8.printStackTrace()
            r0 = 3
            goto L10
        L42:
            r5 = 0
            r0 = 6
            goto L10
        L45:
            r0 = 3
            goto L10
        L47:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0481Iw.A6a(com.facebook.ads.redexgen.X.J9):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0480Iv
    public final HttpURLConnection A7g(String str) throws IOException {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0480Iv
    public final InputStream A7h(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getInputStream();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0480Iv
    public final OutputStream A7i(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0480Iv
    public final void A7p(HttpURLConnection httpURLConnection, J7 j7, String str) throws IOException {
        httpURLConnection.setRequestMethod(j7.A02());
        httpURLConnection.setDoOutput(j7.A04());
        httpURLConnection.setDoInput(j7.A03());
        if (str != null) {
            httpURLConnection.setRequestProperty(A00(0, 12, 91), str);
        }
        httpURLConnection.setRequestProperty(A00(12, 14, 7), A00(57, 5, 60));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:            r1 = r1;        r1.flush();     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:            return r1.toByteArray();     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0480Iv
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0481Iw.A7x(java.io.InputStream):byte[]");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0480Iv
    public final void A8o(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }
}
