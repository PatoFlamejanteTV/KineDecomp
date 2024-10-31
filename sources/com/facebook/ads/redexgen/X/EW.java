package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class EW {
    public static byte[] A02;
    public static final String A03;
    public static volatile EW A04;
    public final C0365Ef A00;
    public final Map<String, ES> A01 = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A07(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EW.A02
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
            int r0 = r0 + (-51)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EW.A07(int, int, int):java.lang.String");
    }

    public static void A08() {
        A02 = new byte[]{-72, -68, -80, -74, -76, -111, -106, -25, -32, -35, -32, -31, -23, -32, 110, -80, -82, -89, -25, 0, -13, -12, -2, -9, -78, 6, 1, -78, 9, 4, -5, 6, -9, -78, -12, -5, 6, -1, -13, 2, -78, 6, 1, -78, -8, -5, -2, -9, -78, -70, 7, 4, -2, -49, -83, -52, -49, -117, -38, -32, -33, -37, -32, -33, -117, -49, -48, -34, -33, -44, -39, -52, -33, -44, -38, -39, -117, -109, -47, -44, -41, -48, -88, -2, 23, 10, 11, 21, 14, -55, 29, 24, -55, 32, 27, 18, 29, 14, -55, 11, 18, 29, 22, 10, 25, -55, 29, 24, -55, 24, 30, 29, 25, 30, 29, -55, 28, 29, 27, 14, 10, 22, -35, -8, 0, 3, -4, -5, -73, 11, 6, -73, -6, 6, 7, 16, -73, 3, 6, -6, -8, 3, -73, 0, 4, -8, -2, -4, -73, 0, 5, 11, 6, -73, -6, -8, -6, -1, -4, -73, -65, 12, 9, 3, -44, -93, -75, -75, -89, -74, 124, 113, 113, 113, 2, 5, -9, -6, -33, -3, -1, 4, 1, -68, 1, 14, 14, 11, 14, -54, -68, -34, 5, 16, 9, -3, 12, -68, 5, 15, -68, 10, 17, 8, 8, -54, -97, -94, -91, -98, 115, 104, 104};
    }

    static {
        A08();
        A03 = EW.class.getSimpleName();
    }

    public EW(C0365Ef c0365Ef) {
        this.A00 = c0365Ef;
    }

    private int A00(String str, @Nullable Bitmap bitmap) {
        int i;
        if (bitmap == null) {
            A0A(null);
            return 0;
        }
        File file = new File(this.A00.getCacheDir(), str.hashCode() + A07(14, 4, 13));
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                    i = byteArrayOutputStream2.size();
                    if (i >= C0413Gc.A0B(this.A00)) {
                        A09(byteArrayOutputStream2);
                        A09(null);
                        i = 0;
                    } else {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byteArrayOutputStream2.writeTo(fileOutputStream2);
                            fileOutputStream2.flush();
                            A09(byteArrayOutputStream2);
                            A09(fileOutputStream2);
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            Log.e(A03, A07(54, 29, 56) + file.getPath() + A07(5, 2, 53), e);
                            A0A(e);
                            A09(byteArrayOutputStream);
                            A09(fileOutputStream);
                            i = 0;
                            return i;
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            A0A(e);
                            Log.e(A03, A07(18, 36, 95) + str + A07(5, 2, 53), e);
                            A09(byteArrayOutputStream);
                            A09(fileOutputStream);
                            i = 0;
                            return i;
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            fileOutputStream = fileOutputStream2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            A0A(e);
                            Log.e(A03, A07(83, 39, 118), e);
                            A09(byteArrayOutputStream);
                            A09(fileOutputStream);
                            i = 0;
                            return i;
                        } catch (Throwable th) {
                            oome = th;
                            fileOutputStream = fileOutputStream2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            A09(byteArrayOutputStream);
                            A09(fileOutputStream);
                            throw oome;
                        }
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    byteArrayOutputStream = byteArrayOutputStream2;
                } catch (IOException e5) {
                    e = e5;
                    byteArrayOutputStream = byteArrayOutputStream2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    byteArrayOutputStream = byteArrayOutputStream2;
                } catch (Throwable th2) {
                    oome = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
            } catch (IOException e8) {
                e = e8;
            } catch (OutOfMemoryError e9) {
                e = e9;
            }
            return i;
        } catch (Throwable th3) {
            oome = th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0104, code lost:            return r3;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.graphics.Bitmap A01(com.facebook.ads.redexgen.X.C0361Eb r17, com.facebook.ads.redexgen.X.ES r18, int r19, int r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EW.A01(com.facebook.ads.redexgen.X.Eb, com.facebook.ads.redexgen.X.ES, int, int, java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0036. Please report as an issue. */
    @Nullable
    private Bitmap A02(C0361Eb c0361Eb, ES es, String str) {
        String str2 = str;
        C0361Eb c0361Eb2 = c0361Eb;
        ES es2 = es;
        EW ew = this;
        long j = 0;
        int i = 0;
        InputStream inputStream = null;
        Throwable e = null;
        String str3 = null;
        Throwable storedThrowable = null;
        Throwable th = null;
        Bitmap bitmap = null;
        String failureReason = es2.A07;
        int i2 = es2.A03;
        int i3 = es2.A04;
        long currentTimeMillis = System.currentTimeMillis();
        IOException e2 = null;
        char c = failureReason.startsWith(A07(165, 9, 15)) ? (char) 2 : (char) 24;
        while (true) {
            switch (c) {
                case 2:
                    inputStream = null;
                    c = 3;
                case 3:
                    ew = ew;
                    inputStream = ew.A00.getAssets().open(failureReason.substring(9));
                    c = ew.A0B(i2, i3) ? '\t' : (char) 11;
                case '\t':
                    inputStream = inputStream;
                    bitmap = EZ.A01(inputStream, i2, i3);
                    c = 29;
                case 11:
                    try {
                        inputStream = inputStream;
                        bitmap = BitmapFactory.decodeStream(inputStream);
                        c = 29;
                    } catch (IOException e3) {
                        storedThrowable = e3;
                        c = 18;
                    } catch (OutOfMemoryError e4) {
                        e = e4;
                        c = 14;
                    }
                case 14:
                    ew = ew;
                    e = e;
                    ew.A0A(e);
                    bitmap = null;
                    c = inputStream != null ? (char) 16 : '$';
                case 16:
                    A09(inputStream);
                    c = '$';
                case 18:
                    try {
                        ew = ew;
                        storedThrowable = storedThrowable;
                        ew.A0A(storedThrowable);
                        bitmap = null;
                        c = inputStream != null ? (char) 20 : '$';
                    } catch (Throwable th2) {
                        th = th2;
                        c = inputStream != null ? (char) 22 : (char) 23;
                    }
                case 20:
                    A09(inputStream);
                    c = '$';
                case 22:
                    A09(inputStream);
                    c = 23;
                case 23:
                    throw th;
                case 24:
                    ew = ew;
                    c = ew.A0B(i2, i3) ? (char) 25 : (char) 28;
                case 25:
                    try {
                        ew = ew;
                        failureReason = failureReason;
                        bitmap = ew.A05(failureReason, i2, i3);
                        c = 31;
                    } catch (IOException e5) {
                        e2 = e5;
                        ew.A0A(e2);
                        bitmap = ew.A03(failureReason);
                        c = 31;
                    }
                case 28:
                    ew = ew;
                    failureReason = failureReason;
                    bitmap = ew.A03(failureReason);
                    c = 31;
                case 29:
                    inputStream = inputStream;
                    c = inputStream != null ? (char) 30 : (char) 31;
                case 30:
                    inputStream = inputStream;
                    A09(inputStream);
                    c = 31;
                case 31:
                    c = e2 != null ? ' ' : '\'';
                case ' ':
                    str3 = e2.toString();
                    c = '!';
                case '!':
                    bitmap = bitmap;
                    c = bitmap != null ? '\"' : '&';
                case '\"':
                    ew = ew;
                    failureReason = failureReason;
                    bitmap = bitmap;
                    i = ew.A00(failureReason, bitmap);
                    j = System.currentTimeMillis() - currentTimeMillis;
                    c = i > 0 ? '#' : '%';
                case '#':
                    c0361Eb2 = c0361Eb2;
                    es2 = es2;
                    str2 = str2;
                    EY.A03(c0361Eb2, es2, str2, EY.A02, str3, Integer.valueOf(i), Long.valueOf(j));
                    c = '$';
                case '$':
                    return bitmap;
                case '%':
                    c0361Eb2 = c0361Eb2;
                    es2 = es2;
                    str2 = str2;
                    EY.A03(c0361Eb2, es2, str2, EY.A01, str3, null, null);
                    c = '$';
                case '&':
                    c0361Eb2 = c0361Eb2;
                    es2 = es2;
                    str2 = str2;
                    EY.A03(c0361Eb2, es2, str2, EY.A03, str3, null, null);
                    c = '$';
                case '\'':
                    str3 = null;
                    c = '!';
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0075, code lost:            return r7;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap A03(java.lang.String r9) {
        /*
            r8 = this;
            r4 = r8
            r3 = 0
            r5 = 0
            r6 = 0
            r0 = 0
            r0 = 0
            r2 = 0
            r7 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ef r0 = r4.A00
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0h(r0)
            if (r0 == 0) goto L71
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L41;
                case 3: goto L35;
                case 4: goto L2b;
                case 5: goto L73;
                case 6: goto L16;
                case 7: goto L5a;
                case 8: goto L67;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.EW r4 = (com.facebook.ads.redexgen.X.EW) r4
            java.lang.String r9 = (java.lang.String) r9
            r7 = 0
            com.facebook.ads.redexgen.X.Ef r0 = r4.A00
            com.facebook.ads.redexgen.X.Iy r0 = com.facebook.ads.redexgen.X.C7A.A00(r0)
            com.facebook.ads.redexgen.X.JA r5 = r0.A0K(r9, r7)
            if (r5 == 0) goto L29
            r0 = 7
            goto L12
        L29:
            r0 = 5
            goto L12
        L2b:
            byte[] r2 = (byte[]) r2
            r1 = 0
            int r0 = r2.length
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeByteArray(r2, r1, r0)
            r0 = 5
            goto L12
        L35:
            com.facebook.ads.redexgen.X.FN r6 = (com.facebook.ads.redexgen.X.FN) r6
            byte[] r2 = r6.A4L()
            if (r2 == 0) goto L3f
            r0 = 4
            goto L12
        L3f:
            r0 = 5
            goto L12
        L41:
            com.facebook.ads.redexgen.X.EW r4 = (com.facebook.ads.redexgen.X.EW) r4
            java.lang.String r9 = (java.lang.String) r9
            com.facebook.ads.redexgen.X.Ef r0 = r4.A00
            com.facebook.ads.redexgen.X.FM r1 = com.facebook.ads.redexgen.X.C7A.A04(r0)
            com.facebook.ads.redexgen.X.7V r0 = new com.facebook.ads.redexgen.X.7V
            r0.<init>()
            com.facebook.ads.redexgen.X.FN r6 = r1.A7l(r9, r0)
            if (r6 == 0) goto L58
            r0 = 3
            goto L12
        L58:
            r0 = 5
            goto L12
        L5a:
            com.facebook.ads.redexgen.X.JA r5 = (com.facebook.ads.redexgen.X.JA) r5
            byte[] r3 = r5.A04()
            if (r3 == 0) goto L65
            r0 = 8
            goto L12
        L65:
            r0 = 5
            goto L12
        L67:
            byte[] r3 = (byte[]) r3
            r1 = 0
            int r0 = r3.length
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeByteArray(r3, r1, r0)
            r0 = 5
            goto L12
        L71:
            r0 = 6
            goto L12
        L73:
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EW.A03(java.lang.String):android.graphics.Bitmap");
    }

    @Nullable
    private Bitmap A04(String str, int i, int i2) {
        Bitmap decodeStream;
        try {
            if (A0B(i, i2)) {
                decodeStream = EZ.A02(str.substring(A07(206, 7, 6).length()), i, i2, this.A00);
            } else {
                decodeStream = BitmapFactory.decodeStream(new FileInputStream(str.substring(A07(206, 7, 6).length())), null, null);
            }
            A00(str, decodeStream);
            return decodeStream;
        } catch (IOException e) {
            Log.e(A03, A07(122, 43, 100) + str + A07(5, 2, 53), e);
            return null;
        }
    }

    @Nullable
    private Bitmap A05(String str, int i, int i2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        Bitmap A01 = EZ.A01(inputStream, i, i2);
        A09(inputStream);
        return A01;
    }

    public static EW A06(C0365Ef c0365Ef) {
        if (A04 == null) {
            synchronized (EW.class) {
                if (A04 == null) {
                    A04 = new EW(c0365Ef);
                }
            }
        }
        return A04;
    }

    public static void A09(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0A(@android.support.annotation.Nullable java.lang.Throwable r9) {
        /*
            r8 = this;
            r7 = r8
            if (r9 == 0) goto L4c
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L4e;
                case 4: goto L26;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.EW r7 = (com.facebook.ads.redexgen.X.EW) r7
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            com.facebook.ads.redexgen.X.Ef r0 = r7.A00
            com.facebook.ads.redexgen.X.Kf r3 = r0.A06()
            r2 = 0
            r1 = 5
            r0 = 28
            java.lang.String r2 = A07(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A1F
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r9)
            r3.A5W(r2, r1, r0)
            r0 = 3
            goto L4
        L26:
            com.facebook.ads.redexgen.X.EW r7 = (com.facebook.ads.redexgen.X.EW) r7
            com.facebook.ads.redexgen.X.Ef r0 = r7.A00
            com.facebook.ads.redexgen.X.Kf r6 = r0.A06()
            r2 = 0
            r1 = 5
            r0 = 28
            java.lang.String r5 = A07(r2, r1, r0)
            int r4 = com.facebook.ads.redexgen.X.C0512Kc.A1F
            com.facebook.ads.redexgen.X.Ke r3 = new com.facebook.ads.redexgen.X.Ke
            r2 = 178(0xb2, float:2.5E-43)
            r1 = 28
            r0 = 105(0x69, float:1.47E-43)
            java.lang.String r0 = A07(r2, r1, r0)
            r3.<init>(r0)
            r6.A5W(r5, r4, r3)
            r0 = 3
            goto L4
        L4c:
            r0 = 4
            goto L4
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EW.A0A(java.lang.Throwable):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0025, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0B(int r4, int r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r4 <= 0) goto L23
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto Lf;
                case 4: goto L1d;
                case 5: goto L25;
                case 6: goto L20;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            if (r5 <= 0) goto Ld
            r0 = 3
            goto L5
        Ld:
            r0 = 6
            goto L5
        Lf:
            com.facebook.ads.redexgen.X.EW r2 = (com.facebook.ads.redexgen.X.EW) r2
            com.facebook.ads.redexgen.X.Ef r0 = r2.A00
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0f(r0)
            if (r0 == 0) goto L1b
            r0 = 4
            goto L5
        L1b:
            r0 = 6
            goto L5
        L1d:
            r1 = 1
            r0 = 5
            goto L5
        L20:
            r1 = 0
            r0 = 5
            goto L5
        L23:
            r0 = 6
            goto L5
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EW.A0B(int, int):boolean");
    }

    @Nullable
    public final Bitmap A0C(ES es) {
        return A01(this.A00, es, es.A04, es.A03, es.A01);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap A0D(com.facebook.ads.redexgen.X.C0361Eb r17, java.lang.String r18, int r19, int r20, java.lang.String r21) {
        /*
            r16 = this;
            r15 = r21
            r11 = r17
            r5 = r18
            r10 = r16
            r1 = 0
            r0 = 0
            java.util.Map<java.lang.String, com.facebook.ads.redexgen.X.ES> r0 = r10.A01
            java.lang.Object r3 = r0.get(r5)
            com.facebook.ads.redexgen.X.ES r3 = (com.facebook.ads.redexgen.X.ES) r3
            boolean r0 = com.facebook.ads.redexgen.X.EY.A06(r11)
            if (r0 == 0) goto L63
            r0 = 2
        L19:
            r6 = r19
            r7 = r20
            switch(r0) {
                case 2: goto L21;
                case 3: goto L29;
                case 4: goto L65;
                case 5: goto L3d;
                default: goto L20;
            }
        L20:
            goto L19
        L21:
            com.facebook.ads.redexgen.X.ES r3 = (com.facebook.ads.redexgen.X.ES) r3
            if (r3 == 0) goto L27
            r0 = 3
            goto L19
        L27:
            r0 = 5
            goto L19
        L29:
            com.facebook.ads.redexgen.X.EW r10 = (com.facebook.ads.redexgen.X.EW) r10
            com.facebook.ads.redexgen.X.Eb r11 = (com.facebook.ads.redexgen.X.C0361Eb) r11
            java.lang.String r15 = (java.lang.String) r15
            com.facebook.ads.redexgen.X.ES r3 = (com.facebook.ads.redexgen.X.ES) r3
            r13 = r7
            r14 = r6
            r10 = r10
            r11 = r11
            r12 = r3
            r15 = r15
            android.graphics.Bitmap r1 = r10.A01(r11, r12, r13, r14, r15)
            r0 = 4
            goto L19
        L3d:
            com.facebook.ads.redexgen.X.EW r10 = (com.facebook.ads.redexgen.X.EW) r10
            com.facebook.ads.redexgen.X.Eb r11 = (com.facebook.ads.redexgen.X.C0361Eb) r11
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r15 = (java.lang.String) r15
            com.facebook.ads.redexgen.X.ES r4 = new com.facebook.ads.redexgen.X.ES
            r2 = 7
            r1 = 7
            r0 = 63
            java.lang.String r8 = A07(r2, r1, r0)
            r2 = 7
            r1 = 7
            r0 = 63
            java.lang.String r9 = A07(r2, r1, r0)
            r4.<init>(r5, r6, r7, r8, r9)
            r12 = r4
            r13 = r7
            r14 = r6
            android.graphics.Bitmap r1 = r10.A01(r11, r12, r13, r14, r15)
            r0 = 4
            goto L19
        L63:
            r0 = 5
            goto L19
        L65:
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EW.A0D(com.facebook.ads.redexgen.X.Eb, java.lang.String, int, int, java.lang.String):android.graphics.Bitmap");
    }

    public final String A0E(String str) {
        File file = new File(this.A00.getCacheDir(), str.hashCode() + A07(14, 4, 13));
        return file.exists() ? file.getPath() : str;
    }
}
