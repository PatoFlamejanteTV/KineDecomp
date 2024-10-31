package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.facebook.ads.redexgen.X.0T, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0T implements C0M {
    public static String A07;
    public static byte[] A08;
    public int A00;
    public InputStream A01;
    public HttpURLConnection A02;
    public final String A03;
    public volatile int A04;
    public volatile int A05;

    @Nullable
    public volatile String A06;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0T.A08
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
            int r0 = r0 + (-21)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0T.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A08 = new byte[]{120, -103, -114, -105, 73, -116, -104, -105, -105, -114, -116, -99, -110, -104, -105, 73, -69, -34, -46, -48, -29, -40, -34, -35, -63, -48, -35, -42, -44, -36, -43, -81, -107, -30, -34, -30, -38, -81, -107, -42, 2, 1, 7, -8, 1, 7, -77, -4, 1, -7, 2, -77, -7, 2, 5, -77, -13, -77, -32, -32, -35, -32, -114, -44, -45, -30, -47, -42, -41, -36, -43, -114, -41, -36, -44, -35, -114, -44, -32, -35, -37, -114, Byte.MIN_VALUE, -84, -84, -88, -115, -86, -92, -117, -89, -83, -86, -101, -99, -77, -83, -86, -92, 117, 95, -107, -34, -24, -107, -34, -29, -23, -38, -25, -25, -22, -27, -23, -38, -39, 111, -100, -100, -103, -100, 74, -103, -102, -113, -104, -109, -104, -111, 74, -115, -103, -104, -104, -113, -115, -98, -109, -103, -104, 74, -112, -103, -100, 74, 66, Byte.MIN_VALUE, 116, -73, -61, -62, -56, -71, -62, -56, -127, -64, -71, -62, -69, -56, -68, -114, 116, 113, -124, Byte.MIN_VALUE, -125, -120, -115, -122, 63, -110, -114, -108, -111, -126, -124, 63, 73, -96, -110, -99, -111, 73, -104, -113, -113, -100, -114, -99, 73, -62, -88, -21, -9, -10, -10, -19, -21, -4, -15, -9, -10, -88, -15, -5, -88, -23, -22, -5, -19, -10, -4, -87, -66, -21, -21, -24, -21, -103, -35, -30, -20, -36, -24, -25, -25, -34, -36, -19, -30, -25, -32, -103, -63, -19, -19, -23, -50, -21, -27, -68, -24, -25, -25, -34, -36, -19, -30, -24, -25, -71, -26, -26, -29, -26, -108, -26, -39, -43, -40, -35, -30, -37, -108, -40, -43, -24, -43, -108, -38, -26, -29, -31, -108, -82, -59, -64, -79, -65, -119, 53, -119, -124, 53, -77, -50, -50, Byte.MAX_VALUE, -52, -64, -51, -40, Byte.MAX_VALUE, -47, -60, -61, -56, -47, -60, -62, -45, -46, -103, Byte.MAX_VALUE, -87, -68, -72, -69, 119, -70, -58, -59, -53, -68, -59, -53, 119, -64, -59, -67, -58, 119, -67, -55, -58, -60, 119};
    }

    static {
        A04();
        A07 = C0T.class.getSimpleName();
    }

    public C0T(String str) {
        this(str, C0Q.A01(str));
    }

    public C0T(String str, int i) {
        this(str);
        this.A00 = i;
    }

    public C0T(String str, @Nullable String str2) {
        this.A05 = Integer.MIN_VALUE;
        this.A00 = -1;
        this.A03 = (String) C0V.A00(str);
        this.A06 = str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00(java.net.HttpURLConnection r4, int r5, int r6) throws java.io.IOException {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            int r1 = r4.getContentLength()
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 != r0) goto L20
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L22;
                case 3: goto Lf;
                case 4: goto L17;
                case 5: goto L1a;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r0 = 206(0xce, float:2.89E-43)
            if (r6 != r0) goto L15
            r0 = 4
            goto Lb
        L15:
            r0 = 5
            goto Lb
        L17:
            int r1 = r1 + r5
            r0 = 2
            goto Lb
        L1a:
            com.facebook.ads.redexgen.X.0T r2 = (com.facebook.ads.redexgen.X.C0T) r2
            int r1 = r2.A05
            r0 = 2
            goto Lb
        L20:
            r0 = 3
            goto Lb
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0T.A00(java.net.HttpURLConnection, int, int):int");
    }

    private HttpURLConnection A02(int i, int redirectCount) throws IOException, C0R {
        C0T c0t = this;
        boolean z = false;
        int i2 = 0;
        String str = null;
        StringBuilder sb = null;
        HttpURLConnection httpURLConnection = null;
        int i3 = 0;
        String str2 = c0t.A03;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    sb = new StringBuilder().append(A01(0, 16, 20));
                    if (i <= 0) {
                        c = 19;
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    str = A01(179, 13, 20) + i;
                    c = 4;
                    break;
                case 4:
                    str2 = str2;
                    sb = sb;
                    str = str;
                    sb.append(str).append(A01(282, 4, 0)).append(str2).toString();
                    httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                    if (i <= 0) {
                        c = 6;
                        break;
                    } else {
                        c = 5;
                        break;
                    }
                case 5:
                    httpURLConnection = httpURLConnection;
                    httpURLConnection.setRequestProperty(A01(24, 5, 90), A01(276, 6, 55) + i + A01(145, 1, 0));
                    c = 6;
                    break;
                case 6:
                    if (redirectCount <= 0) {
                        c = '\b';
                        break;
                    } else {
                        c = 7;
                        break;
                    }
                case 7:
                    httpURLConnection = httpURLConnection;
                    httpURLConnection.setConnectTimeout(redirectCount);
                    httpURLConnection.setReadTimeout(redirectCount);
                    c = '\b';
                    break;
                case '\b':
                    c0t = c0t;
                    httpURLConnection = httpURLConnection;
                    i2 = httpURLConnection.getResponseCode();
                    c0t.A04 = i2;
                    if (i2 == 301) {
                        c = 11;
                        break;
                    } else {
                        c = '\t';
                        break;
                    }
                case '\t':
                    if (i2 == 302) {
                        c = 11;
                        break;
                    } else {
                        c = '\n';
                        break;
                    }
                case '\n':
                    if (i2 != 303) {
                        c = 18;
                        break;
                    } else {
                        c = 11;
                        break;
                    }
                case 11:
                    z = true;
                    c = '\f';
                    break;
                case '\f':
                    if (!z) {
                        c = 14;
                        break;
                    } else {
                        c = '\r';
                        break;
                    }
                case '\r':
                    httpURLConnection = httpURLConnection;
                    str2 = httpURLConnection.getHeaderField(A01(16, 8, 90));
                    i3++;
                    httpURLConnection.disconnect();
                    c = 14;
                    break;
                case 14:
                    if (i3 <= 5) {
                        c = 16;
                        break;
                    } else {
                        c = 15;
                        break;
                    }
                case 15:
                    throw new C0R(A01(286, 20, 74) + i3);
                case 16:
                    if (!z) {
                        c = 17;
                        break;
                    } else {
                        c = 2;
                        break;
                    }
                case 17:
                    return httpURLConnection;
                case 18:
                    z = false;
                    c = '\f';
                    break;
                case 19:
                    str = A01(29, 0, 55);
                    c = 4;
                    break;
            }
        }
    }

    private void A03() throws C0R {
        String str = A01(306, 23, 66) + this.A03;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = A02(0, 10000);
                this.A05 = httpURLConnection.getContentLength();
                this.A06 = httpURLConnection.getContentType();
                inputStream = httpURLConnection.getInputStream();
                Log.i(A07, A01(39, 18, 126) + this.A03 + A01(30, 9, 96) + this.A06 + A01(146, 18, 63) + this.A05);
                C0Q.A05(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (IOException e) {
                Log.e(A07, A01(57, 25, 89) + this.A03, e);
                C0Q.A05(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        } catch (Throwable th) {
            C0Q.A05(inputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private final void A05(int i, int i2) throws C0R {
        try {
            this.A02 = A02(i, i2);
            this.A06 = this.A02.getContentType();
            this.A01 = new BufferedInputStream(this.A02.getInputStream(), 8192);
            this.A05 = A00(this.A02, i, this.A02.getResponseCode());
        } catch (IOException e) {
            throw new C0R(A01(116, 29, 21) + this.A03 + A01(179, 13, 20) + i, e);
        }
    }

    public final int A06() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.C0M
    public final void A7f(int i) throws C0R {
        A05(i, this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.C0M
    public final void close() throws C0R {
        if (this.A02 != null) {
            try {
                this.A02.disconnect();
            } catch (NullPointerException e) {
                throw new C0R(A01(215, 37, 100), e);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0M
    public final synchronized int length() throws C0R {
        if (this.A05 == Integer.MIN_VALUE) {
            A03();
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.C0M
    public final int read(byte[] bArr) throws C0R {
        if (this.A01 == null) {
            throw new C0R(A01(252, 24, 95) + this.A03 + A01(192, 23, 115));
        }
        try {
            return this.A01.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            final String str = A01(164, 15, 10) + this.A03 + A01(101, 15, 96);
            throw new C0R(str, e) { // from class: com.facebook.ads.redexgen.X.0U
            };
        } catch (IOException e2) {
            throw new C0R(A01(252, 24, 95) + this.A03, e2);
        }
    }

    public final String toString() {
        return A01(82, 19, 35) + this.A03 + A01(29, 1, 74);
    }
}
