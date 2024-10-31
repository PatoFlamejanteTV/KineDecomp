package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.os.SystemClock;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class EJ {

    @Nullable
    public static String A00;
    public static byte[] A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EJ.A01
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
            r0 = r0 ^ 108(0x6c, float:1.51E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EJ.A06(int, int, int):java.lang.String");
    }

    public static void A0A() {
        A01 = new byte[]{34, 36, 18, 41, 36, 53, 112, 17, 34, 34, 49, 41, 112, 57, 35, 112, 62, 37, 60, 60, 80, 15, 9, 67, 86, 84, 30};
    }

    static {
        A0A();
        A00 = null;
    }

    public static float A00(float f) {
        return new BigDecimal(f).setScale(3, RoundingMode.HALF_UP).floatValue();
    }

    public static long A01() {
        return SystemClock.elapsedRealtime();
    }

    public static long A02(long j) {
        return j - (j % 1048576);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x000a, code lost:            r0 = com.facebook.ads.redexgen.X.EnumC0346Dm.A04;     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.EnumC0346Dm A03(@javax.annotation.Nullable java.lang.String r4) {
        /*
            if (r4 == 0) goto L8
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto Lb
        L8:
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.EnumC0346Dm.A04
        La:
            return r0
        Lb:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L40
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L40
            r2 = 21
            r1 = 2
            r0 = 1
            java.lang.String r0 = A06(r2, r1, r0)     // Catch: java.lang.Throwable -> L40
            org.json.JSONObject r3 = r3.getJSONObject(r0)     // Catch: java.lang.Throwable -> L40
            if (r3 != 0) goto L21
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.EnumC0346Dm.A04     // Catch: java.lang.Throwable -> L40
            goto La
        L21:
            r2 = 0
            r1 = 2
            r0 = 60
            java.lang.String r0 = A06(r2, r1, r0)     // Catch: java.lang.Throwable -> L40
            boolean r0 = r3.has(r0)     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L40
            r2 = 0
            r1 = 2
            r0 = 60
            java.lang.String r0 = A06(r2, r1, r0)     // Catch: java.lang.Throwable -> L40
            int r0 = r3.getInt(r0)     // Catch: java.lang.Throwable -> L40
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.EnumC0346Dm.A00(r0)     // Catch: java.lang.Throwable -> L40
            goto La
        L40:
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.EnumC0346Dm.A04
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EJ.A03(java.lang.String):com.facebook.ads.redexgen.X.Dm");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0097, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C0354Du A04(java.lang.String r6, java.lang.Throwable r7) {
        /*
            r5 = 0
            boolean r0 = r7 instanceof java.lang.NullPointerException
            if (r0 == 0) goto L90
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L51;
                case 3: goto L93;
                case 4: goto L2e;
                case 5: goto L15;
                case 6: goto La;
                case 7: goto L6a;
                case 8: goto L76;
                case 9: goto L38;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            boolean r0 = r7 instanceof java.lang.UnsupportedOperationException
            if (r0 != 0) goto L12
            r0 = 7
            goto L6
        L12:
            r0 = 8
            goto L6
        L15:
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.Du r5 = new com.facebook.ads.redexgen.X.Du
            long r1 = A01()
            com.facebook.ads.redexgen.X.E7 r4 = new com.facebook.ads.redexgen.X.E7
            r4.<init>(r6)
            com.facebook.ads.redexgen.X.E6 r3 = new com.facebook.ads.redexgen.X.E6
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A05
            r3.<init>(r0)
            r5.<init>(r1, r4, r3)
            r0 = 3
            goto L6
        L2e:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            boolean r0 = r7 instanceof java.lang.SecurityException
            if (r0 == 0) goto L36
            r0 = 5
            goto L6
        L36:
            r0 = 6
            goto L6
        L38:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            com.facebook.ads.redexgen.X.Du r5 = new com.facebook.ads.redexgen.X.Du
            long r1 = A01()
            com.facebook.ads.redexgen.X.E7 r3 = new com.facebook.ads.redexgen.X.E7
            r3.<init>(r6)
            com.facebook.ads.redexgen.X.E6 r0 = new com.facebook.ads.redexgen.X.E6
            r0.<init>(r7)
            r5.<init>(r1, r3, r0)
            r0 = 3
            goto L6
        L51:
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.Du r5 = new com.facebook.ads.redexgen.X.Du
            long r2 = A01()
            com.facebook.ads.redexgen.X.E7 r4 = new com.facebook.ads.redexgen.X.E7
            r4.<init>(r6)
            com.facebook.ads.redexgen.X.E6 r1 = new com.facebook.ads.redexgen.X.E6
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            r1.<init>(r0)
            r5.<init>(r2, r4, r1)
            r0 = 3
            goto L6
        L6a:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            boolean r0 = r7 instanceof java.security.NoSuchAlgorithmException
            if (r0 == 0) goto L73
            r0 = 8
            goto L6
        L73:
            r0 = 9
            goto L6
        L76:
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.Du r5 = new com.facebook.ads.redexgen.X.Du
            long r2 = A01()
            com.facebook.ads.redexgen.X.E7 r4 = new com.facebook.ads.redexgen.X.E7
            r4.<init>(r6)
            com.facebook.ads.redexgen.X.E6 r1 = new com.facebook.ads.redexgen.X.E6
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A04
            r1.<init>(r0)
            r5.<init>(r2, r4, r1)
            r0 = 3
            goto L6
        L90:
            r0 = 4
            goto L6
        L93:
            com.facebook.ads.redexgen.X.Du r5 = (com.facebook.ads.redexgen.X.C0354Du) r5
            com.facebook.ads.redexgen.X.Du r5 = (com.facebook.ads.redexgen.X.C0354Du) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EJ.A04(java.lang.String, java.lang.Throwable):com.facebook.ads.redexgen.X.Du");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0006. Please report as an issue. */
    @SuppressLint({"BadMethodUse-java.util.UUID.randomUUID"})
    public static String A05() {
        StrictMode.ThreadPolicy savedPolicy = null;
        char c = A00 == null ? (char) 2 : '\b';
        while (true) {
            switch (c) {
                case 2:
                    savedPolicy = StrictMode.allowThreadDiskReads();
                    c = 3;
                case 3:
                    try {
                        A00 = UUID.randomUUID().toString();
                        StrictMode.setThreadPolicy(savedPolicy);
                        c = '\b';
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(savedPolicy);
                        throw th;
                    }
                case '\b':
                    return A00;
            }
        }
    }

    @Nullable
    @SuppressLint({"EmptyCatchBlock"})
    public static String A07(String str) {
        String timestamp = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(A06(20, 1, 72))) {
                return null;
            }
            timestamp = Integer.toString(jSONObject.getInt(A06(20, 1, 72)));
            return timestamp;
        } catch (JSONException unused) {
            return timestamp;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0006. Please report as an issue. */
    public static String A08(byte[] bArr, EI ei) throws NoSuchAlgorithmException {
        int i = 0;
        byte[] bArr2 = null;
        StringBuffer stringBuffer = null;
        char c = bArr == null ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new NullPointerException(A06(2, 18, 60));
                case 3:
                    bArr = bArr;
                    ei = ei;
                    stringBuffer = new StringBuffer();
                    bArr2 = MessageDigest.getInstance(ei.A02()).digest(bArr);
                    i = 0;
                    c = 4;
                case 4:
                    bArr2 = bArr2;
                    c = i < bArr2.length ? (char) 5 : (char) 6;
                case 5:
                    stringBuffer = stringBuffer;
                    bArr2 = bArr2;
                    stringBuffer.append(String.format(A06(23, 4, 10), Integer.valueOf(bArr2[i] & 255)));
                    i++;
                    c = 4;
                case 6:
                    return stringBuffer.toString();
            }
        }
    }

    public static Map<String, String> A09(AA aa) {
        HashMap hashMap = new HashMap();
        hashMap.put(AJ.A03.A02(), A05());
        hashMap.put(AJ.A09.A02(), Long.toString(TimeUnit.SECONDS.toMillis(aa.A0T())));
        hashMap.put(AJ.A05.A02(), Long.toString(C0347Dn.A00()));
        hashMap.put(AJ.A06.A02(), Integer.toString(aa.A0S()));
        hashMap.put(AJ.A08.A02(), Integer.toString(aa.A0V()));
        hashMap.put(AJ.A04.A02(), Integer.toString(aa.A0R()));
        hashMap.put(AJ.A07.A02(), A07(aa.A0h()));
        return hashMap;
    }

    public static void A0B(AA aa, String str, @Nullable String str2) {
        A5 A0X = aa.A0X();
        if (A0X == null) {
            return;
        }
        A0X.A5f(AH.A04.A02(), str, A09(aa), str2, null, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0C() {
        /*
            r2 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 29
            if (r1 < r0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 1
            r0 = 3
            goto L8
        Lf:
            r2 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EJ.A0C():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0D() {
        /*
            r2 = 0
            android.app.ActivityManager$RunningAppProcessInfo r0 = new android.app.ActivityManager$RunningAppProcessInfo
            r0.<init>()
            android.app.ActivityManager.getMyMemoryState(r0)
            int r1 = r0.importance
            r0 = 100
            if (r1 == r0) goto L1a
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L1c;
                case 4: goto L17;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r2 = 1
            r0 = 3
            goto L10
        L17:
            r2 = 0
            r0 = 3
            goto L10
        L1a:
            r0 = 4
            goto L10
        L1c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EJ.A0D():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0033, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0E(com.facebook.ads.redexgen.X.EnumC0346Dm r3) {
        /*
            r2 = 0
            r0 = 0
            int r1 = r3.A03()
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.EnumC0346Dm.A05
            int r0 = r0.A03()
            if (r1 == r0) goto L31
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L22;
                case 4: goto L1f;
                case 5: goto L33;
                case 6: goto L2e;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.EnumC0346Dm.A07
            int r0 = r0.A03()
            if (r1 == r0) goto L1d
            r0 = 3
            goto Lf
        L1d:
            r0 = 4
            goto Lf
        L1f:
            r2 = 1
            r0 = 5
            goto Lf
        L22:
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.EnumC0346Dm.A06
            int r0 = r0.A03()
            if (r1 != r0) goto L2c
            r0 = 4
            goto Lf
        L2c:
            r0 = 6
            goto Lf
        L2e:
            r2 = 0
            r0 = 5
            goto Lf
        L31:
            r0 = 4
            goto Lf
        L33:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EJ.A0E(com.facebook.ads.redexgen.X.Dm):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0033, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0F(@javax.annotation.Nullable java.lang.String r2, @javax.annotation.Nullable java.lang.String r3) {
        /*
            r1 = 0
            if (r2 != 0) goto L31
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L19;
                case 4: goto L33;
                case 5: goto L11;
                case 6: goto L8;
                case 7: goto L24;
                case 8: goto L27;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto Le
            r0 = 7
            goto L4
        Le:
            r0 = 8
            goto L4
        L11:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L17
            r0 = 6
            goto L4
        L17:
            r0 = 7
            goto L4
        L19:
            r1 = 1
            r0 = 4
            goto L4
        L1c:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L22
            r0 = 3
            goto L4
        L22:
            r0 = 5
            goto L4
        L24:
            r1 = 0
            r0 = 4
            goto L4
        L27:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = (java.lang.String) r3
            boolean r1 = r2.equals(r3)
            r0 = 4
            goto L4
        L31:
            r0 = 5
            goto L4
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EJ.A0F(java.lang.String, java.lang.String):boolean");
    }
}
