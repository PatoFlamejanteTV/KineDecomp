package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.facebook.ads.redexgen.X.Jd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0488Jd {
    public static byte[] A00;

    static {
        A05();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0488Jd.A00
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
            r0 = r0 ^ 47
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0488Jd.A00(int, int, int):java.lang.String");
    }

    public static void A05() {
        A00 = new byte[]{58, 51, 66, 9, 40, 103, 52, 50, 36, 47, 103, 38, 43, 32, 40, 53, 46, 51, 47, 42, 105, 11, 36, 33, 40, 109, 35, 34, 57, 109, 43, 34, 56, 35, 41, 109, 34, 63, 109, 35, 34, 57, 109, 44, 46, 46, 40, 62, 62, 36, 47, 33, 40, 99, 57, 63, 80, 21, 8, 19, 21, 0, 4, 25, 31, 30, 94};
    }

    @Nullable
    public static String A01(File file) throws Exception {
        FileInputStream fileInputStream;
        int read;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(A00(0, 3, 88));
                        byte[] bArr = new byte[1024];
                        do {
                            read = fileInputStream.read(bArr);
                            if (read > 0) {
                                messageDigest.update(bArr, 0, read);
                            }
                        } while (read != -1);
                        return A04(messageDigest.digest());
                    } catch (NoSuchAlgorithmException unused) {
                        throw new Exception(A00(3, 18, 104));
                    }
                } catch (IOException unused2) {
                    throw new Exception(A00(54, 13, 95));
                }
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
            }
        } catch (FileNotFoundException unused4) {
            throw new Exception(A00(21, 33, 98));
        }
    }

    @Nullable
    public static final String A02(String str) throws Exception {
        return A01(new File(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0063, code lost:            return r4.toString();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(byte[] r9) {
        /*
            r8 = 0
            r7 = 0
            r1 = 0
            r0 = 0
            r0 = 0
            r6 = 0
            r0 = 0
            r5 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r3 = r9.length
            r2 = 0
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L37;
                case 3: goto L24;
                case 4: goto L1d;
                case 5: goto L14;
                case 6: goto L32;
                case 7: goto L3e;
                case 8: goto L50;
                case 9: goto L2f;
                case 10: goto L54;
                case 11: goto L5b;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r0 = 9
            if (r6 > r0) goto L1a
            r0 = 6
            goto L10
        L1a:
            r0 = 10
            goto L10
        L1d:
            if (r6 < 0) goto L21
            r0 = 5
            goto L10
        L21:
            r0 = 10
            goto L10
        L24:
            byte[] r9 = (byte[]) r9
            r5 = r9[r2]
            int r0 = r5 >>> 4
            r6 = r0 & 15
            r1 = 0
            r0 = 4
            goto L10
        L2f:
            r1 = r8
            r0 = 4
            goto L10
        L32:
            int r0 = r6 + 48
            char r7 = (char) r0
            r0 = 7
            goto L10
        L37:
            if (r2 >= r3) goto L3b
            r0 = 3
            goto L10
        L3b:
            r0 = 11
            goto L10
        L3e:
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            r4.append(r7)
            r6 = r5 & 15
            int r8 = r1 + 1
            r0 = 1
            if (r1 < r0) goto L4d
            r0 = 8
            goto L10
        L4d:
            r0 = 9
            goto L10
        L50:
            int r2 = r2 + 1
            r0 = 2
            goto L10
        L54:
            int r0 = r6 + (-10)
            int r0 = r0 + 97
            char r7 = (char) r0
            r0 = 7
            goto L10
        L5b:
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            java.lang.String r0 = r4.toString()
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0488Jd.A03(byte[]):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:            return r4.toString();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(byte[] r5) {
        /*
            r0 = 0
            r0 = 0
            r0 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r3 = r5.length
            r2 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L31;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r2 >= r3) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 4
            goto Lb
        L15:
            byte[] r5 = (byte[]) r5
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            r0 = r5[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r0 + 256
            r0 = 16
            java.lang.String r1 = java.lang.Integer.toString(r1, r0)
            r0 = 1
            java.lang.String r0 = r1.substring(r0)
            r4.append(r0)
            int r2 = r2 + 1
            r0 = 2
            goto Lb
        L31:
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            java.lang.String r0 = r4.toString()
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0488Jd.A04(byte[]):java.lang.String");
    }
}
