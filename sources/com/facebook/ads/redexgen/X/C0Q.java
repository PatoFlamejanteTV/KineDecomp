package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.facebook.ads.redexgen.X.0Q, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0Q {
    public static byte[] A00;
    public static final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0Q.A00
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
            int r0 = r0 + (-56)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0Q.A00(int, int, int):java.lang.String");
    }

    public static void A04() {
        A00 = new byte[]{-8, -17, -32, -67, -22, -22, -25, -22, -104, -37, -28, -25, -21, -31, -26, -33, -104, -22, -35, -21, -25, -19, -22, -37, -35, -97, -86, -84, -14};
    }

    static {
        A04();
        A01 = C0Q.class.getSimpleName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:            return r3;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(java.lang.String r4) {
        /*
            r0 = 0
            r3 = 0
            r0 = 0
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r1 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L23
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L25;
                case 4: goto L19;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            r3 = 0
            r0 = 3
            goto L12
        L19:
            android.webkit.MimeTypeMap r2 = (android.webkit.MimeTypeMap) r2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r3 = r2.getMimeTypeFromExtension(r1)
            r0 = 3
            goto L12
        L23:
            r0 = 4
            goto L12
        L25:
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0Q.A01(java.lang.String):java.lang.String");
    }

    public static String A02(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(A00(0, 3, 115));
            return A03(messageDigest.digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:            return r7.toString();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(byte[] r9) {
        /*
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r8 = 0
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            r7.<init>()
            int r6 = r9.length
            r5 = r8
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L17;
                case 4: goto L3c;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            if (r5 >= r6) goto L15
            r0 = 3
            goto Ld
        L15:
            r0 = 4
            goto Ld
        L17:
            byte[] r9 = (byte[]) r9
            java.lang.StringBuffer r7 = (java.lang.StringBuffer) r7
            r4 = r9[r5]
            java.util.Locale r3 = java.util.Locale.US
            r2 = 25
            r1 = 4
            r0 = 66
            java.lang.String r2 = A00(r2, r1, r0)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Byte r0 = java.lang.Byte.valueOf(r4)
            r1[r8] = r0
            java.lang.String r0 = java.lang.String.format(r3, r2, r1)
            r7.append(r0)
            int r5 = r5 + 1
            r0 = 2
            goto Ld
        L3c:
            java.lang.StringBuffer r7 = (java.lang.StringBuffer) r7
            java.lang.String r0 = r7.toString()
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0Q.A03(byte[]):java.lang.String");
    }

    public static void A05(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e(A01, A00(3, 22, 64), e);
            }
        }
    }
}
