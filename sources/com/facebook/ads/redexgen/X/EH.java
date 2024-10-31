package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.io.File;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: assets/audience_network.dex */
public final class EH {
    public static byte[] A00;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.EH.A00
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
            int r0 = r0 + (-29)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EH.A00(int, int, int):java.lang.String");
    }

    public static void A03() {
        A00 = new byte[]{-127, -88, -97, -97, 83, 117, 119, 83, -122, -104, -90, -90, -100, -94, -95, 83, 124, -105, 112, -107, -99, -120, -109, -112, -117, 71, 115, -116, -107, -114, -101, -113, -82, -83, -82, -71, -76, -84, -68, -98, -71, -54, -51, -51, -46, -41, -48, -88, -51, -43, -64, -53, -56, -61, Byte.MAX_VALUE, -88, -51, -49, -44, -45, -113, -71, -68, -60, -77, -74, -64, -75, -50, -18, -57, -55, -86, -49, -41, -62, -51, -54, -59, -127, -86, -73};
    }

    @SuppressLint({"CatchGeneralException", "BadMethodUse-java.lang.String.length"})
    public static String A01(String str, String str2) {
        try {
            String[] split = str2.split(A00(68, 2, 85));
            if (split == null || split.length == 0) {
                throw new IllegalArgumentException(A00(0, 18, 22));
            }
            String str3 = split[split.length - 1];
            if (str3.length() != 16) {
                throw new InvalidParameterSpecException(A00(18, 14, 10));
            }
            return A02(str, str3);
        } catch (Throwable th) {
            AK.A03(th);
            return A00(70, 2, 47);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0005. Please report as an issue. */
    @SuppressLint({"TrulyRandom", "BadMethodUse-java.lang.String.length"})
    public static String A02(String str, String str2) throws Throwable {
        char c = str != null ? (char) 2 : (char) 5;
        while (true) {
            switch (c) {
                case 2:
                    str2 = str2;
                    c = str2 != null ? (char) 3 : (char) 5;
                case 3:
                    str = str;
                    c = !str.isEmpty() ? (char) 4 : (char) 5;
                case 4:
                    str2 = str2;
                    c = str2.isEmpty() ? (char) 5 : (char) 6;
                case 5:
                    throw new IllegalArgumentException(A00(47, 13, 66));
                case 6:
                    String str3 = str2;
                    int length = str3.length();
                    Cipher cipher = Cipher.getInstance(A00(60, 8, 48) + File.separatorChar + A00(32, 3, 78) + File.separatorChar + A00(35, 12, 76));
                    int saltLength = length / 2;
                    cipher.init(1, new SecretKeySpec(str3.getBytes(), A00(60, 8, 48)), new IvParameterSpec(A04(str3.substring(0, saltLength).getBytes(), str3.substring(length / 2, length).getBytes())));
                    byte[] raw = cipher.doFinal(str.getBytes());
                    return Base64.encodeToString(raw, 0);
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0005. Please report as an issue. */
    public static byte[] A04(byte[] bArr, byte[] result) throws NullPointerException {
        byte[] bArr2 = null;
        int i = 0;
        char c = bArr != null ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    result = result;
                    c = result != null ? (char) 3 : (char) 4;
                case 3:
                    bArr = bArr;
                    result = result;
                    c = bArr.length != result.length ? (char) 4 : (char) 5;
                case 4:
                    throw new NullPointerException(A00(72, 10, 68));
                case 5:
                    bArr = bArr;
                    bArr2 = new byte[bArr.length];
                    i = 0;
                    c = 6;
                case 6:
                    bArr = bArr;
                    c = i < bArr.length ? (char) 7 : '\b';
                case 7:
                    bArr = bArr;
                    result = result;
                    bArr2 = bArr2;
                    bArr2[i] = (byte) (bArr[i] ^ result[i]);
                    i++;
                    c = 6;
                case '\b':
                    return bArr2;
            }
        }
    }
}
