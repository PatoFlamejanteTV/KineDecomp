package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.facebook.ads.redexgen.X.Iy, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0483Iy {
    public static byte[] A0C;
    public static int[] A0D;
    public static final String A0E;
    public G3 A01;
    public Set<String> A03;
    public Set<String> A04;
    public boolean A05;
    public boolean A06;
    public final J0 A0A = new J1();
    public J2 A09 = new J3();
    public int A07 = 2000;
    public int A08 = 8000;
    public int A00 = 3;
    public Map<String, String> A02 = new TreeMap();
    public final InterfaceC0480Iv A0B = new C0482Ix(this);

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A07(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0483Iy.A0C
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
            r0 = r0 ^ 37
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0483Iy.A07(int, int, int):java.lang.String");
    }

    public static void A0B() {
        A0C = new byte[]{20, 29, 16, 1, 2, 20, 21, 113, 5, 24, 28, 20, 113, 108, 113, 51, 47, 47, 43, 117, 48, 62, 62, 43, 26, 55, 50, 45, 62, 47, 34, 71, 47, 45, 87, 80, 93, 66, 84, 69, 71, 90, 89, 85, 39, 33, 85, 72, 85, 56, 20, 13, 28, 24, 0, 24, 85, 7, 16, 1, 7, 28, 16, 6, 85, 24, 0, 6, 1, 85, 23, 16, 85, 23, 16, 1, 2, 16, 16, 27, 85, 68, 85, 20, 27, 17, 85, 68, 77, Byte.MAX_VALUE, 68, 75, 72, 70, 79, 10, 94, 69, 10, 92, 75, 70, 67, 78, 75, 94, 79, 10, 121, 121, 102, 10, 73, 79, 88, 94, 67, 76, 67, 73, 75, 94, 79, 89, 4, 108, 37, 63, 108, 34, 35, 56, 108, 45, 108, 58, 45, 32, 37, 40, 108, 25, 30, 0, 89, 45, 44, 62, 85, 64, 72, 65, 30, 18, 70, 64, 75, 91, 92, 85, 18, 24, 20, 119, 96, 20, 9, 20, 25, 20, 93, 25, 27, 107, 58, 121, 111, 104, 118, 58, 14, 24, 31, 1, 77, 64, 6, 77, 64, 4};
    }

    static {
        A0B();
        A0D = new int[20];
        A0E = C0483Iy.class.getSimpleName();
        A09();
        if (Build.VERSION.SDK_INT > 8) {
            A0A();
        }
    }

    public C0483Iy(boolean z) {
        this.A06 = z;
    }

    private final int A00(int i) {
        return A0D[i + 2] * 1000;
    }

    private final int A01(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStream = null;
        try {
            outputStream = this.A0B.A7i(httpURLConnection);
            if (outputStream != null) {
                this.A0B.A8o(outputStream, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:            return r4;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.JA A02(com.facebook.ads.redexgen.X.J5 r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L4c
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L43;
                case 3: goto L40;
                case 4: goto L10;
                case 12: goto L4e;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.J5 r7 = (com.facebook.ads.redexgen.X.J5) r7     // Catch: java.lang.Exception -> L29 com.facebook.ads.redexgen.X.J9 -> L37
            java.lang.String r3 = r7.A04()     // Catch: java.lang.Exception -> L29 com.facebook.ads.redexgen.X.J9 -> L37
            com.facebook.ads.redexgen.X.J7 r2 = r7.A02()     // Catch: java.lang.Exception -> L29 com.facebook.ads.redexgen.X.J9 -> L37
            java.lang.String r1 = r7.A03()     // Catch: java.lang.Exception -> L29 com.facebook.ads.redexgen.X.J9 -> L37
            byte[] r0 = r7.A05()     // Catch: java.lang.Exception -> L29 com.facebook.ads.redexgen.X.J9 -> L37
            com.facebook.ads.redexgen.X.JA r4 = r5.A03(r3, r2, r1, r0)     // Catch: java.lang.Exception -> L29 com.facebook.ads.redexgen.X.J9 -> L37
            r0 = 12
            goto Lc
        L29:
            r2 = move-exception
            com.facebook.ads.redexgen.X.Iv r1 = r5.A0B
            com.facebook.ads.redexgen.X.J9 r0 = new com.facebook.ads.redexgen.X.J9
            r0.<init>(r2, r4)
            r1.A6a(r0)
            r0 = 12
            goto Lc
        L37:
            r1 = move-exception
            com.facebook.ads.redexgen.X.Iv r0 = r5.A0B
            r0.A6a(r1)
            r0 = 12
            goto Lc
        L40:
            r4 = 0
            r0 = 4
            goto Lc
        L43:
            com.facebook.ads.redexgen.X.Iy r5 = (com.facebook.ads.redexgen.X.C0483Iy) r5
            com.facebook.ads.redexgen.X.J5 r7 = (com.facebook.ads.redexgen.X.J5) r7
            r5.A0C(r7)
            r0 = 3
            goto Lc
        L4c:
            r0 = 3
            goto Lc
        L4e:
            com.facebook.ads.redexgen.X.JA r4 = (com.facebook.ads.redexgen.X.JA) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0483Iy.A02(com.facebook.ads.redexgen.X.J5):com.facebook.ads.redexgen.X.JA");
    }

    private final JA A03(String str, J7 j7, String str2, byte[] bArr) throws J9 {
        JA ja;
        HttpURLConnection httpURLConnection = null;
        JA ja2 = null;
        try {
            try {
                this.A05 = false;
                HttpURLConnection A08 = A08(str);
                A0G(A08, j7, str2);
                A0F(A08);
                if (this.A09.A5E()) {
                    this.A09.A5i(A08, bArr);
                }
                A08.connect();
                this.A05 = true;
                boolean z = (this.A03 == null || this.A03.isEmpty()) ? false : true;
                boolean z2 = (this.A04 == null || this.A04.isEmpty()) ? false : true;
                if ((A08 instanceof HttpsURLConnection) && (z || z2)) {
                    try {
                        JB.A03((HttpsURLConnection) A08, this.A03, this.A04);
                    } catch (Exception e) {
                        Log.e(A0E, A07(89, 36, 15), e);
                    }
                }
                if (A08.getDoOutput() && bArr != null) {
                    A01(A08, bArr);
                }
                if (A08.getDoInput()) {
                    ja = A06(A08);
                } else {
                    ja = new JA(A08, null);
                }
                if (this.A09.A5E()) {
                    this.A09.A5j(ja);
                }
                if (A08 != null) {
                    A08.disconnect();
                    return ja;
                }
                return ja;
            } catch (Exception e2) {
                try {
                    try {
                        ja2 = A05(null);
                        if (ja2 != null && ja2.A00() > 0) {
                            if (this.A09.A5E()) {
                                this.A09.A5j(ja2);
                            }
                            if (0 != 0) {
                                httpURLConnection.disconnect();
                            }
                            return ja2;
                        }
                        throw new J9(e2, ja2);
                    } catch (Throwable unused) {
                        if (ja2 != null && ja2.A00() > 0) {
                            if (this.A09.A5E()) {
                                this.A09.A5j(ja2);
                            }
                            if (0 != 0) {
                                httpURLConnection.disconnect();
                            }
                            return ja2;
                        }
                        throw new J9(e2, ja2);
                    }
                } catch (Exception unused2) {
                    e2.printStackTrace();
                    if (ja2 != null && ja2.A00() > 0) {
                        if (this.A09.A5E()) {
                            this.A09.A5j(ja2);
                        }
                        if (0 != 0) {
                            httpURLConnection.disconnect();
                        }
                        return ja2;
                    }
                    throw new J9(e2, ja2);
                }
            }
        } catch (Throwable th) {
            if (this.A09.A5E()) {
                this.A09.A5j(ja2);
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    @Nullable
    private final JA A04(String str, String str2, byte[] bArr) {
        return A02(new J8(str, null, str2, bArr));
    }

    private final JA A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            inputStream = httpURLConnection.getErrorStream();
            if (inputStream != null) {
                bArr = this.A0B.A7x(inputStream);
            }
            JA ja = new JA(httpURLConnection, bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            return ja;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final JA A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            inputStream = this.A0B.A7h(httpURLConnection);
            if (inputStream != null) {
                bArr = this.A0B.A7x(inputStream);
            }
            JA ja = new JA(httpURLConnection, bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            return ja;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final HttpURLConnection A08(String str) throws IOException {
        try {
            new URL(str);
            return this.A0B.A7g(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(str + A07(125, 19, 105), e);
        }
    }

    public static void A09() {
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty(A07(15, 14, 126), A07(34, 5, 20));
        }
    }

    public static void A0A() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c8, code lost:            r4 = r4;        r4.append(A07(39, 2, 64));        r4.append(r9.A04());        r4.append(A07(41, 1, 93));        r2 = r4.toString();        r3.A0E(r2, 1, (r2.length() / 4000) + 1);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fd, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0C(com.facebook.ads.redexgen.X.J5 r9) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0483Iy.A0C(com.facebook.ads.redexgen.X.J5):void");
    }

    private final void A0D(J5 j5, IL il) {
        this.A0A.A4J(this, il).A42(j5);
        if (BuildConfigApi.isDebug()) {
            A0C(j5);
        }
    }

    private void A0E(String str, int i, int i2) {
        String str2 = A0E + A07(174, 6, 63) + i + A07(173, 1, 97) + i2;
        if (str.length() > 4000) {
            str.substring(0, 4000);
            A0E(str.substring(4000), i + 1, i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F(java.net.HttpURLConnection r7) {
        /*
            r6 = this;
            r3 = r6
            r5 = 0
            r0 = 0
            r4 = 0
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.A02
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r2 = r0.iterator()
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L58;
                case 3: goto L3f;
                case 4: goto L34;
                case 5: goto L20;
                case 6: goto L13;
                case 7: goto L64;
                case 8: goto L7b;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            java.util.Iterator r5 = (java.util.Iterator) r5
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L1d
            r0 = 7
            goto Lf
        L1d:
            r0 = 8
            goto Lf
        L20:
            com.facebook.ads.redexgen.X.Iy r3 = (com.facebook.ads.redexgen.X.C0483Iy) r3
            com.facebook.ads.redexgen.X.G3 r1 = r3.A01
            boolean r0 = r3.A06
            java.util.Map r4 = r1.A4C(r0)
            java.util.Set r0 = r4.keySet()
            java.util.Iterator r5 = r0.iterator()
            r0 = 6
            goto Lf
        L34:
            com.facebook.ads.redexgen.X.Iy r3 = (com.facebook.ads.redexgen.X.C0483Iy) r3
            com.facebook.ads.redexgen.X.G3 r0 = r3.A01
            if (r0 == 0) goto L3c
            r0 = 5
            goto Lf
        L3c:
            r0 = 8
            goto Lf
        L3f:
            com.facebook.ads.redexgen.X.Iy r3 = (com.facebook.ads.redexgen.X.C0483Iy) r3
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r1 = r2.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.A02
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r7.setRequestProperty(r1, r0)
            r0 = 2
            goto Lf
        L58:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L62
            r0 = 3
            goto Lf
        L62:
            r0 = 4
            goto Lf
        L64:
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7
            java.util.Map r4 = (java.util.Map) r4
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r4.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r7.setRequestProperty(r1, r0)
            r0 = 6
            goto Lf
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0483Iy.A0F(java.net.HttpURLConnection):void");
    }

    private final void A0G(HttpURLConnection httpURLConnection, J7 j7, String str) throws IOException {
        httpURLConnection.setConnectTimeout(this.A07);
        httpURLConnection.setReadTimeout(this.A08);
        this.A0B.A7p(httpURLConnection, j7, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0092, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0H(java.lang.Throwable r10, long r11) {
        /*
            r9 = this;
            r6 = r9
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 1
            r1 = 0
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r11
            r1 = 10
            long r4 = r4 + r1
            com.facebook.ads.redexgen.X.J2 r1 = r6.A09
            boolean r1 = r1.A5E()
            if (r1 == 0) goto L90
            r1 = 2
        L18:
            switch(r1) {
                case 2: goto L2c;
                case 3: goto L75;
                case 4: goto L1f;
                case 5: goto L92;
                case 6: goto L1c;
                case 7: goto L7f;
                case 8: goto L8d;
                default: goto L1b;
            }
        L1b:
            goto L18
        L1c:
            r0 = 0
            r1 = 5
            goto L18
        L1f:
            com.facebook.ads.redexgen.X.Iy r6 = (com.facebook.ads.redexgen.X.C0483Iy) r6
            int r1 = r6.A08
            long r2 = (long) r1
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 < 0) goto L2a
            r1 = 5
            goto L18
        L2a:
            r1 = 6
            goto L18
        L2c:
            com.facebook.ads.redexgen.X.Iy r6 = (com.facebook.ads.redexgen.X.C0483Iy) r6
            com.facebook.ads.redexgen.X.J2 r8 = r6.A09
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r3 = 0
            r2 = 15
            r1 = 116(0x74, float:1.63E-43)
            java.lang.String r1 = A07(r3, r2, r1)
            java.lang.StringBuilder r1 = r7.append(r1)
            java.lang.StringBuilder r7 = r1.append(r4)
            r3 = 161(0xa1, float:2.26E-43)
            r2 = 7
            r1 = 17
            java.lang.String r1 = A07(r3, r2, r1)
            java.lang.StringBuilder r2 = r7.append(r1)
            int r1 = r6.A07
            java.lang.StringBuilder r7 = r2.append(r1)
            r3 = 42
            r2 = 7
            r1 = 80
            java.lang.String r1 = A07(r3, r2, r1)
            java.lang.StringBuilder r2 = r7.append(r1)
            int r1 = r6.A08
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            r8.A5O(r1)
            r1 = 3
            goto L18
        L75:
            com.facebook.ads.redexgen.X.Iy r6 = (com.facebook.ads.redexgen.X.C0483Iy) r6
            boolean r1 = r6.A05
            if (r1 == 0) goto L7d
            r1 = 4
            goto L18
        L7d:
            r1 = 7
            goto L18
        L7f:
            com.facebook.ads.redexgen.X.Iy r6 = (com.facebook.ads.redexgen.X.C0483Iy) r6
            int r1 = r6.A07
            long r2 = (long) r1
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 >= 0) goto L8b
            r1 = 8
            goto L18
        L8b:
            r1 = 5
            goto L18
        L8d:
            r0 = 0
            r1 = 5
            goto L18
        L90:
            r1 = 3
            goto L18
        L92:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0483Iy.A0H(java.lang.Throwable, long):boolean");
    }

    public final C0483Iy A0I(String str, String str2) {
        this.A02.put(str, str2);
        return this;
    }

    public final JA A0J(J5 j5) throws J9 {
        JA A03;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < this.A00; i++) {
            try {
                A0N(A00(i));
                if (this.A09.A5E()) {
                    this.A09.A5O((i + 1) + A07(150, 2, 2) + this.A00 + A07(152, 9, 23) + j5.A04());
                }
                currentTimeMillis = System.currentTimeMillis();
                A03 = A03(j5.A04(), j5.A02(), j5.A03(), j5.A05());
            } catch (J9 e) {
                if (A0H(e, currentTimeMillis) && i < this.A00 - 1) {
                    continue;
                } else if (this.A0B.A6a(e) && i < this.A00 - 1) {
                    try {
                        Thread.sleep(this.A07);
                    } catch (InterruptedException unused) {
                        throw e;
                    }
                } else {
                    throw e;
                }
            }
            if (A03 != null) {
                return A03;
            }
        }
        return null;
    }

    @Nullable
    public final JA A0K(String str, @Nullable JC jc) {
        return A02(new J6(str, jc));
    }

    @Nullable
    public final JA A0L(String str, JC jc) {
        return A02(new J8(str, jc));
    }

    public final JC A0M() {
        return new JC();
    }

    public final void A0N(int i) {
        this.A07 = i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0004. Please report as an issue. */
    public final void A0O(int i) {
        char c = i >= 1 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    c = i > 18 ? (char) 3 : (char) 4;
                case 3:
                    throw new IllegalArgumentException(A07(49, 40, 80));
                case 4:
                    this.A00 = i;
                    return;
            }
        }
    }

    public final void A0P(int i) {
        this.A08 = i;
    }

    public final void A0Q(G3 g3) {
        this.A01 = g3;
    }

    public final void A0R(String str, JC jc, IL il) {
        A0D(new J8(str, jc), il);
    }

    public final void A0S(Set<String> pinnedCertificates) {
        this.A03 = pinnedCertificates;
    }

    public final void A0T(Set<String> pinnedPublicKeys) {
        this.A04 = pinnedPublicKeys;
    }
}
