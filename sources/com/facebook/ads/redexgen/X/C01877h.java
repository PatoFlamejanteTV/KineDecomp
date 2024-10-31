package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;

/* renamed from: com.facebook.ads.redexgen.X.7h, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C01877h implements FM {
    public static byte[] A07;
    public static final String A08;
    public InterfaceC0515Kf A00;
    public Executor A01;
    public boolean A02;
    public FH A03;
    public final F5 A06;
    public final F7 A05 = new F6();
    public C7T A04 = new C7I();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A07(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C01877h.A07
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
            int r0 = r0 + (-89)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01877h.A07(int, int, int):java.lang.String");
    }

    public static void A09() {
        A07 = new byte[]{-41, -34, -45, -30, -27, -41, -42, -78, -26, -37, -33, -41, -78, -49, -78, -101, -88, -61, -101, -99, -83, -81, -75, 26, 56, 71, 71, 60, 65, 58, -13, 71, 59, 56, -13, 59, 71, 71, 67, -13, 69, 56, 70, 67, 66, 65, 70, 56, -13, 71, 60, 64, 56, 55, -13, 66, 72, 71, 52, 67, 67, 63, 60, 54, 52, 71, 60, 66, 65, 2, 75, 0, 74, 74, 74, 0, 57, 66, 69, 64, 0, 72, 69, 63, 56, 65, 54, 66, 55, 56, 55, 14, 54, 59, 52, 69, 70, 56, 71, 16, 40, 39, 25, 0, 11, -62, -74, -24, -22, -74, -45, -74, -60, -35, -48, -47, -37, -44, -113, -29, -34, -113, -27, -48, -37, -40, -45, -48, -29, -44, -113, -62, -62, -69, -113, -46, -44, -31, -29, -40, -43, -40, -46, -48, -29, -44, -30, -99, -48, 25, 35, -48, 30, 31, 36, -48, 17, -48, 38, 17, 28, 25, 20, -48, 5, 2, -4, -43, 34, 33, 19, -6, 5, -59, 20, 11, -59, -72, -84, 0, -2, 5, -11, -6, -13, -84, -28, -40, -5, 12, -40, -11, -40, -10, 3, 58, -10, -8, -76, -87, -20, -2, -5, -11, -87, 55, 73, 70, 64, -12, 1, 63, -12, 1, 61};
    }

    static {
        A09();
        A08 = FM.class.getSimpleName();
    }

    public C01877h(FH fh, InterfaceC0515Kf interfaceC0515Kf, Executor executor) {
        A0A();
        this.A03 = fh;
        this.A06 = new F0() { // from class: com.facebook.ads.redexgen.X.9t
        };
        this.A01 = executor;
        this.A00 = interfaceC0515Kf;
    }

    private final int A00(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStream = null;
        try {
            outputStream = this.A06.A7i(httpURLConnection);
            if (outputStream != null) {
                this.A06.A8o(outputStream, bArr);
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

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:            if (r0 == false) goto L17;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.FN A01(com.facebook.ads.redexgen.X.AbstractC0373En r9) throws com.facebook.ads.redexgen.X.EQ {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01877h.A01(com.facebook.ads.redexgen.X.En):com.facebook.ads.redexgen.X.FN");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:            return r3;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.FN A02(com.facebook.ads.redexgen.X.AbstractC0373En r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            com.facebook.ads.redexgen.X.FH r0 = r4.A03
            boolean r0 = r0.A04()
            if (r0 == 0) goto L3d
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L34;
                case 3: goto L31;
                case 4: goto Lf;
                case 5: goto Le;
                case 6: goto Le;
                case 7: goto Le;
                case 8: goto L3f;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.7h r4 = (com.facebook.ads.redexgen.X.C01877h) r4     // Catch: java.lang.Exception -> L1a com.facebook.ads.redexgen.X.EQ -> L28
            com.facebook.ads.redexgen.X.En r6 = (com.facebook.ads.redexgen.X.AbstractC0373En) r6     // Catch: java.lang.Exception -> L1a com.facebook.ads.redexgen.X.EQ -> L28
            com.facebook.ads.redexgen.X.FN r3 = r4.A01(r6)     // Catch: java.lang.Exception -> L1a com.facebook.ads.redexgen.X.EQ -> L28
            r0 = 8
            goto Lb
        L1a:
            r2 = move-exception
            com.facebook.ads.redexgen.X.F5 r1 = r4.A06
            com.facebook.ads.redexgen.X.EQ r0 = new com.facebook.ads.redexgen.X.EQ
            r0.<init>(r2, r3)
            r1.A6b(r0)
            r0 = 8
            goto Lb
        L28:
            r1 = move-exception
            com.facebook.ads.redexgen.X.F5 r0 = r4.A06
            r0.A6b(r1)
            r0 = 8
            goto Lb
        L31:
            r3 = 0
            r0 = 4
            goto Lb
        L34:
            com.facebook.ads.redexgen.X.7h r4 = (com.facebook.ads.redexgen.X.C01877h) r4
            com.facebook.ads.redexgen.X.En r6 = (com.facebook.ads.redexgen.X.AbstractC0373En) r6
            r4.A0B(r6)
            r0 = 3
            goto Lb
        L3d:
            r0 = 3
            goto Lb
        L3f:
            com.facebook.ads.redexgen.X.FN r3 = (com.facebook.ads.redexgen.X.FN) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01877h.A02(com.facebook.ads.redexgen.X.En):com.facebook.ads.redexgen.X.FN");
    }

    @Nullable
    private final FN A03(String str, C7V c7v, F9 f9) {
        return A02(new C0372Em(str, c7v, f9));
    }

    @Nullable
    private final FN A04(String str, String str2, byte[] bArr, F9 f9) {
        return A02(new C0370Ek(str, null, str2, bArr, f9));
    }

    private final FN A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            inputStream = httpURLConnection.getErrorStream();
            if (inputStream != null) {
                bArr = this.A06.A7x(inputStream);
            }
            C0313Cf c0313Cf = new C0313Cf(httpURLConnection, bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            return c0313Cf;
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

    private final FN A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            inputStream = this.A06.A7h(httpURLConnection);
            if (inputStream != null) {
                bArr = this.A06.A7x(inputStream);
            }
            C0313Cf c0313Cf = new C0313Cf(httpURLConnection, bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            return c0313Cf;
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
            TrafficStats.setThreadStatsTag(61453);
            return this.A06.A7g(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(str + A07(148, 19, 87), e);
        }
    }

    public static synchronized void A0A() {
        synchronized (C01877h.class) {
            if (CookieHandler.getDefault() == null) {
                CookieHandler.setDefault(new CookieManager());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cd, code lost:            r4 = r4;        r4.append(A07(20, 2, 52));        r4.append(r8.A05());        r4.append(A07(22, 1, 58));        r2 = r4.toString();        A0D(r2, 1, (r2.length() / 4000) + 1);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0103, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0B(com.facebook.ads.redexgen.X.AbstractC0373En r8) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01877h.A0B(com.facebook.ads.redexgen.X.En):void");
    }

    private void A0C(AbstractC0373En abstractC0373En, InterfaceC0436Gz interfaceC0436Gz) {
        this.A05.A4K(this, interfaceC0436Gz, this.A01).A43(abstractC0373En);
        if (this.A03.A04()) {
            A0B(abstractC0373En);
        }
    }

    private void A0D(String str, int i, int i2) {
        String str2 = A08 + A07(199, 6, 48) + i + A07(198, 1, 44) + i2;
        if (str.length() > 4000) {
            str.substring(0, 4000);
            A0D(str.substring(4000), i + 1, i2);
        }
    }

    private void A0E(String str, String str2, byte[] bArr, InterfaceC0436Gz interfaceC0436Gz, F9 f9) {
        A0C(new C0370Ek(str, null, str2, bArr, f9), interfaceC0436Gz);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x008b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F(java.net.HttpURLConnection r9, com.facebook.ads.redexgen.X.AbstractC0373En r10) {
        /*
            r8 = this;
            r5 = r8
            r6 = 0
            r0 = 0
            r0 = 0
            r7 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.F9 r0 = r10.A02()
            java.util.Map r4 = r0.A06()
            com.facebook.ads.redexgen.X.F9 r0 = r10.A02()
            com.facebook.ads.redexgen.X.G4 r3 = r0.A05()
            java.util.Set r0 = r4.keySet()
            java.util.Iterator r2 = r0.iterator()
            r0 = 2
        L1f:
            switch(r0) {
                case 2: goto L68;
                case 3: goto L51;
                case 4: goto L48;
                case 5: goto L30;
                case 6: goto L23;
                case 7: goto L74;
                case 8: goto L8b;
                default: goto L22;
            }
        L22:
            goto L1f
        L23:
            java.util.Iterator r7 = (java.util.Iterator) r7
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L2d
            r0 = 7
            goto L1f
        L2d:
            r0 = 8
            goto L1f
        L30:
            com.facebook.ads.redexgen.X.7h r5 = (com.facebook.ads.redexgen.X.C01877h) r5
            com.facebook.ads.redexgen.X.G4 r3 = (com.facebook.ads.redexgen.X.G4) r3
            com.facebook.ads.redexgen.X.FH r0 = r5.A03
            boolean r0 = r0.A03()
            java.util.Map r6 = r3.A4C(r0)
            java.util.Set r0 = r6.keySet()
            java.util.Iterator r7 = r0.iterator()
            r0 = 6
            goto L1f
        L48:
            com.facebook.ads.redexgen.X.G4 r3 = (com.facebook.ads.redexgen.X.G4) r3
            if (r3 == 0) goto L4e
            r0 = 5
            goto L1f
        L4e:
            r0 = 8
            goto L1f
        L51:
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9
            java.util.Map r4 = (java.util.Map) r4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r1 = r2.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r4.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r9.setRequestProperty(r1, r0)
            r0 = 2
            goto L1f
        L68:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L72
            r0 = 3
            goto L1f
        L72:
            r0 = 4
            goto L1f
        L74:
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9
            java.util.Map r6 = (java.util.Map) r6
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r6.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r9.setRequestProperty(r1, r0)
            r0 = 6
            goto L1f
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01877h.A0F(java.net.HttpURLConnection, com.facebook.ads.redexgen.X.En):void");
    }

    private final void A0G(HttpURLConnection httpURLConnection, AbstractC0373En abstractC0373En) throws IOException {
        F9 A02 = abstractC0373En.A02();
        httpURLConnection.setConnectTimeout(A02.A00());
        httpURLConnection.setReadTimeout(A02.A02());
        this.A06.A7q(httpURLConnection, abstractC0373En.A03(), abstractC0373En.A04());
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0H(java.lang.Throwable r11, long r12, com.facebook.ads.redexgen.X.AbstractC0373En r14) {
        /*
            r10 = this;
            r7 = r10
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 1
            r1 = 0
            com.facebook.ads.redexgen.X.F9 r6 = r14.A02()
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r12
            r1 = 10
            long r4 = r4 + r1
            com.facebook.ads.redexgen.X.7T r1 = r7.A04
            boolean r1 = r1.A5E()
            if (r1 == 0) goto La0
            r1 = 2
        L1d:
            switch(r1) {
                case 2: goto L3d;
                case 3: goto L33;
                case 4: goto L24;
                case 5: goto La3;
                case 6: goto L21;
                case 7: goto L8c;
                case 8: goto L9c;
                default: goto L20;
            }
        L20:
            goto L1d
        L21:
            r0 = 0
            r1 = 5
            goto L1d
        L24:
            com.facebook.ads.redexgen.X.F9 r6 = (com.facebook.ads.redexgen.X.F9) r6
            int r1 = r6.A02()
            long r2 = (long) r1
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 < 0) goto L31
            r1 = 5
            goto L1d
        L31:
            r1 = 6
            goto L1d
        L33:
            com.facebook.ads.redexgen.X.7h r7 = (com.facebook.ads.redexgen.X.C01877h) r7
            boolean r1 = r7.A02
            if (r1 == 0) goto L3b
            r1 = 4
            goto L1d
        L3b:
            r1 = 7
            goto L1d
        L3d:
            com.facebook.ads.redexgen.X.7h r7 = (com.facebook.ads.redexgen.X.C01877h) r7
            com.facebook.ads.redexgen.X.F9 r6 = (com.facebook.ads.redexgen.X.F9) r6
            com.facebook.ads.redexgen.X.7T r9 = r7.A04
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r3 = 0
            r2 = 15
            r1 = 57
            java.lang.String r1 = A07(r3, r2, r1)
            java.lang.StringBuilder r1 = r8.append(r1)
            java.lang.StringBuilder r8 = r1.append(r4)
            r3 = 186(0xba, float:2.6E-43)
            r2 = 7
            r1 = 95
            java.lang.String r1 = A07(r3, r2, r1)
            java.lang.StringBuilder r2 = r8.append(r1)
            int r1 = r6.A00()
            java.lang.StringBuilder r8 = r2.append(r1)
            r3 = 105(0x69, float:1.47E-43)
            r2 = 7
            r1 = 61
            java.lang.String r1 = A07(r3, r2, r1)
            java.lang.StringBuilder r2 = r8.append(r1)
            int r1 = r6.A02()
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            r9.A5O(r1)
            r1 = 3
            goto L1d
        L8c:
            com.facebook.ads.redexgen.X.F9 r6 = (com.facebook.ads.redexgen.X.F9) r6
            int r1 = r6.A00()
            long r2 = (long) r1
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 >= 0) goto L9a
            r1 = 8
            goto L1d
        L9a:
            r1 = 5
            goto L1d
        L9c:
            r0 = 0
            r1 = 5
            goto L1d
        La0:
            r1 = 3
            goto L1d
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01877h.A0H(java.lang.Throwable, long, com.facebook.ads.redexgen.X.En):boolean");
    }

    public final FN A0I(AbstractC0373En abstractC0373En) throws EQ {
        FN A01;
        long currentTimeMillis = System.currentTimeMillis();
        int A012 = abstractC0373En.A02().A01();
        int maxRetries = abstractC0373En.A02().A03();
        long j = maxRetries;
        long currentTimeMillis2 = System.currentTimeMillis();
        long throttleTimeMs = abstractC0373En.A02().A04();
        long j2 = currentTimeMillis2 + throttleTimeMs;
        for (int i = 0; i < A012 && j2 > System.currentTimeMillis(); i++) {
            try {
                if (this.A04.A5E()) {
                    this.A04.A5O((i + 1) + A07(173, 4, 76) + A012 + A07(177, 9, 51) + abstractC0373En.A05());
                }
                currentTimeMillis = System.currentTimeMillis();
                A01 = A01(abstractC0373En);
            } catch (EQ e) {
                if (A0H(e, currentTimeMillis, abstractC0373En) && i < A012 - 1) {
                    continue;
                } else {
                    if (!this.A06.A6b(e) || i >= A012 - 1) {
                        FN A00 = e.A00();
                        InterfaceC0515Kf interfaceC0515Kf = this.A00;
                        long endTimeMillis = System.currentTimeMillis();
                        interfaceC0515Kf.A5d(currentTimeMillis, endTimeMillis - currentTimeMillis, (A00 == null || A00.A4L() == null) ? 0L : A00.A4L().length, abstractC0373En.A04 == null ? 0L : abstractC0373En.A04.length, A00 == null ? 0 : A00.A50(), e);
                        throw e;
                    }
                    if (j > 0) {
                        try {
                            Thread.sleep(j);
                        } catch (InterruptedException e2) {
                            this.A00.A5d(currentTimeMillis, System.currentTimeMillis() - currentTimeMillis, 0L, abstractC0373En.A04 == null ? 0L : abstractC0373En.A04.length, 0, e2);
                            throw e;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (A01 != null) {
                InterfaceC0515Kf interfaceC0515Kf2 = this.A00;
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                long length = A01.A4L().length;
                long throttleTimeMs2 = abstractC0373En.A04 == null ? 0L : abstractC0373En.A04.length;
                interfaceC0515Kf2.A5d(currentTimeMillis, currentTimeMillis3, length, throttleTimeMs2, A01.A50(), null);
                return A01;
            }
            continue;
        }
        this.A00.A5d(currentTimeMillis, System.currentTimeMillis() - currentTimeMillis, 0L, abstractC0373En.A04 == null ? 0L : abstractC0373En.A04.length, 0, new TimeoutException(A07(23, 35, 122)));
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.FM
    @Nullable
    @Deprecated
    public final FN A7l(String str, Map<String, String> map) {
        return A03(str, new C7V(map), this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.X.FM
    @Nullable
    @Deprecated
    public final FN A7m(String str, byte[] bArr) {
        return A04(str, A07(58, 47, 122), bArr, this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.X.FM
    public final void A7n(String str, byte[] bArr, InterfaceC0436Gz interfaceC0436Gz) {
        A0E(str, A07(58, 47, 122), bArr, interfaceC0436Gz, this.A03.A00());
    }
}
