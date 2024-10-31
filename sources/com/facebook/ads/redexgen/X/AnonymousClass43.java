package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.43, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass43 {
    public static AnonymousClass43 A01;
    public static byte[] A02;
    public static final String[] A03;
    public final SharedPreferences A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass43.A02
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
            int r0 = r0 + (-121)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass43.A05(int, int, int):java.lang.String");
    }

    public static void A0N() {
        A02 = new byte[]{-6, -19, -8, -9, -6, -4, -25, -23, -20, -25, -9, -8, -4, -15, -9, -10, -5, 0, -13, -2, -3, 0, 2, -19, -17, -14, -19, -12, -3, -6, -6, -3, 5, -19, 3, -2, -19, -10, -13, -17, -14, -9, -4, -11, 30, 31, 35, 24, 30, 29, 14, 35, 20, 39, 35, 71, 60, 78, 79, 58, 80, 75, 63, 60, 79, 64, 63, 58, 79, 68, 72, 64, 78, 79, 60, 72, 75, 1, -11, 2, -11, -5, -7, -13, -11, -8, -13, 4, 6, -7, -6, -7, 6, -7, 2, -9, -7, 7, 19, 31, 29, -34, 22, 17, 19, 21, 18, 31, 31, 27, -34, 17, 20, 35, -34, -15, -12, 15, 2, -11, 0, -1, 2, 4, -7, -2, -9, 15, -13, -1, -2, -10, -7, -9, 74, 76, -18, -17, -22, -21, -27, -25, -22, -27, -22, -21, -7, -23, -8, -17, -10, -6, -17, -11, -12, 13, 0, 11, 10, 13, 15, 4, 9, 2, 35, 23, 36, 23, 29, 27, 21, 23, 26, 21, 38, 40, 27, 28, 27, 40, 27, 36, 25, 27, 41, 21, 43, 40, 31, 68, 71, 76, 71, 81, 70, 67, 66, 61, 80, 67, 78, 77, 80, 82, 61, 63, 66, -4, 1, 2, 5, -3, 11, -2, 7, -8, 1, -2, -6, -3, 2, 7, 0, -30, 3, -76, 6, -7, 4, 3, 6, 8, -76, -11, -8, -76, 3, 4, 8, -3, 3, 2, 7, 20, 5, 22, -4, -2, 10, -4, 6, -4, 16, 2, 2, 6, 11, 4, -4, 17, 5, 6, 16, 12, 17, 18, 21, 13, 27, 14, 23, 8, 24, 25, 29, 18, 24, 23, 28, 1, 8, -1, -1, 85, 88, 93, 88, 98, 87, 84, 83, 78, 83, 84, 98, 82, 97, 88, 95, 99, 88, 94, 93, 59, 62, 57, 61, 66, 73, 67, 61, 63, 77, 57, 79, 76, 67, 25, 44, 55, 54, 57, 59, -25, 8, 43, 42, 43, 38, 39, 33, 35, 38, 33, 40, 49, 46, 46, 49, 57, 33, 55, 50, 33, 42, 39, 35, 38, 43, 48, 41, -25, 10, -58, 24, 11, 22, 21, 24, 26, 11, 10, -44, 59, 92, 13, 85, 86, 81, 82, 13, 78, 81, 13, 92, 93, 97, 86, 92, 91, 96, -6, -5, -10, -9, -15, -13, -10, -15, 1, 2, 6, -5, 1, 0, 5, -7, -20, -9, -10, -7, -5, -26, -24, -21, 80, 67, 78, 77, 80, 82, 61, 63, 66, 61, 66, 67, 81, 65, 80, 71, 78, 82, 71, 77, 76, -14, 31, 51, 68, 61, -14, 51, 54, -14, 51, 69, -14, 65, 56, 56, 55, 64, 69, 59, 72, 55, -14, 65, 68, -14, 59, 64, 51, 66, 66, 68, 65, 66, 68, 59, 51, 70, 55, -29, -28, -33, -32, -38, -36, -33, 47, 64, 81, -8, 57, 69, -8, 33, -8, 75, 61, 61, 65, 70, 63, -8, 76, 64, 65, 75, 23, -56, -21, -89, -17, -16, -21, -21, -20, -11, -75, 90, 91, 95, 84, 90, 89, 74, 97, 76, 87, 96, 80, 25, 45, 58, 45, 51, 49, -20, 45, 48, -20, 60, 62, 49, 50, 49, 62, 49, 58, 47, 49, 63, -19, 10, 17, 21, -59, 26, 24, -59, 26, 19, 9, 10, 23, 24, 25, 6, 19, 9, -59, 28, 13, 6, 25, -59, 14, 24, -59, 13, 6, 21, 21, 10, 19, 14, 19, 12, -45, -59, -4, 13, 30, -59, 9, 20, 19, -52, 25, -59, 30, 20, 26, -59, 28, 6, 19, 25, -59, 25, 20, -59, 24, 10, 10, -59, 25, 13, 14, 24, -28, -15, 18, 13, 14, -55, -22, 13, -19, 3, 9, 6, -76, 7, 9, -10, 1, -3, 7, 7, -3, 3, 2, -76, -3, 7, -76, 2, 3, 11, -76, -10, -7, -3, 2, -5, -76, 6, -7, 10, -3, -7, 11, -7, -8, -62, -21, 8, 15, 19, -61, 24, 22, -61, 24, 17, 7, 8, 21, 22, 23, 4, 17, 7, -61, 26, 11, 4, 23, -61, 12, 22, -61, 11, 4, 19, 19, 8, 17, 12, 17, 10, -47, -61, -6, 11, 28, -61, 12, 22, -61, 23, 11, 12, 22, -61, 12, 17, 4, 19, 19, 21, 18, 19, 21, 12, 4, 23, 8, -30, -31, -28, -23, -28, -18, -29, -32, -33, -38, -29, -28, -33, -32, -38, -36, -33, 65, 83, 83, 14, 84, 83, 101, 83, 96, 14, 79, 82, 97, 14, 90, 87, 89, 83, 14, 98, 86, 87, 97};
    }

    static {
        A0N();
        A03 = new String[]{A05(464, 7, 2), A05(136, 19, 13), A05(326, 25, 73), A05(381, 15, 25), A05(396, 9, 14), A05(405, 21, 101), A05(17, 27, 21), A05(0, 17, 15), A05(77, 21, 27), A05(713, 16, 2), A05(189, 18, 101), A05(283, 20, 118), A05(243, 20, 36), A05(303, 14, 97), A05(164, 25, 61)};
    }

    public AnonymousClass43(C0365Ef c0365Ef) {
        this.A00 = c0365Ef.getSharedPreferences(ProcessUtils.getProcessSpecificName(A05(98, 36, 55), c0365Ef), 0);
    }

    public static long A00(C0365Ef c0365Ef) {
        return A02(c0365Ef).A01(A05(55, 22, 98), 0L);
    }

    private long A01(String str, long j) {
        return this.A00.getLong(str, j);
    }

    public static AnonymousClass43 A02(C0365Ef c0365Ef) {
        if (A01 == null) {
            synchronized (AnonymousClass43.class) {
                if (A01 == null) {
                    A01 = new AnonymousClass43(c0365Ef);
                }
            }
        }
        return A01;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.AnonymousClass46 A03(com.facebook.ads.redexgen.X.C0365Ef r7) {
        /*
            r0 = 0
            r5 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.46 r4 = new com.facebook.ads.redexgen.X.46
            java.lang.String r0 = A0H(r7)
            r4.<init>(r0)
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L1e;
                case 11: goto L12;
                case 15: goto L6d;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.util.Iterator r5 = (java.util.Iterator) r5     // Catch: org.json.JSONException -> L4e
            java.lang.Object r0 = r5.next()     // Catch: org.json.JSONException -> L4e
            com.facebook.ads.redexgen.X.46 r0 = (com.facebook.ads.redexgen.X.AnonymousClass46) r0     // Catch: org.json.JSONException -> L4e
            r4.A06(r0)     // Catch: org.json.JSONException -> L4e
            goto L42
        L1e:
            com.facebook.ads.redexgen.X.Ef r7 = (com.facebook.ads.redexgen.X.C0365Ef) r7     // Catch: org.json.JSONException -> L4e
            com.facebook.ads.redexgen.X.43 r6 = A02(r7)     // Catch: org.json.JSONException -> L4e
            r2 = 381(0x17d, float:5.34E-43)
            r1 = 15
            r0 = 25
            java.lang.String r3 = A05(r2, r1, r0)     // Catch: org.json.JSONException -> L4e
            r2 = 134(0x86, float:1.88E-43)
            r1 = 0
            r0 = 4
            java.lang.String r0 = A05(r2, r1, r0)     // Catch: org.json.JSONException -> L4e
            java.lang.String r0 = r6.A0J(r3, r0)     // Catch: org.json.JSONException -> L4e
            java.util.List r0 = A0K(r0)     // Catch: org.json.JSONException -> L4e
            java.util.Iterator r5 = r0.iterator()     // Catch: org.json.JSONException -> L4e
        L42:
            boolean r0 = r5.hasNext()     // Catch: org.json.JSONException -> L4e
            if (r0 == 0) goto L4b
            r0 = 11
            goto Le
        L4b:
            r0 = 15
            goto Le
        L4e:
            r3 = move-exception
            com.facebook.ads.redexgen.X.43 r0 = A02(r7)
            r0.A0M()
            r2 = 155(0x9b, float:2.17E-43)
            r1 = 9
            r0 = 34
            java.lang.String r2 = A05(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A1V
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r3)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r7, r2, r1, r0)
            r0 = 15
            goto Le
        L6d:
            com.facebook.ads.redexgen.X.46 r4 = (com.facebook.ads.redexgen.X.AnonymousClass46) r4
            com.facebook.ads.redexgen.X.46 r4 = (com.facebook.ads.redexgen.X.AnonymousClass46) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass43.A03(com.facebook.ads.redexgen.X.Ef):com.facebook.ads.redexgen.X.46");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.AnonymousClass46 A04(com.facebook.ads.redexgen.X.C0365Ef r7) {
        /*
            r0 = 0
            r5 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.46 r4 = new com.facebook.ads.redexgen.X.46
            java.lang.String r0 = A0I(r7)
            r4.<init>(r0)
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L1e;
                case 11: goto L12;
                case 15: goto L6c;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.util.Iterator r5 = (java.util.Iterator) r5     // Catch: org.json.JSONException -> L4d
            java.lang.Object r0 = r5.next()     // Catch: org.json.JSONException -> L4d
            com.facebook.ads.redexgen.X.46 r0 = (com.facebook.ads.redexgen.X.AnonymousClass46) r0     // Catch: org.json.JSONException -> L4d
            r4.A06(r0)     // Catch: org.json.JSONException -> L4d
            goto L41
        L1e:
            com.facebook.ads.redexgen.X.Ef r7 = (com.facebook.ads.redexgen.X.C0365Ef) r7     // Catch: org.json.JSONException -> L4d
            com.facebook.ads.redexgen.X.43 r6 = A02(r7)     // Catch: org.json.JSONException -> L4d
            r2 = 0
            r1 = 17
            r0 = 15
            java.lang.String r3 = A05(r2, r1, r0)     // Catch: org.json.JSONException -> L4d
            r2 = 134(0x86, float:1.88E-43)
            r1 = 0
            r0 = 4
            java.lang.String r0 = A05(r2, r1, r0)     // Catch: org.json.JSONException -> L4d
            java.lang.String r0 = r6.A0J(r3, r0)     // Catch: org.json.JSONException -> L4d
            java.util.List r0 = A0K(r0)     // Catch: org.json.JSONException -> L4d
            java.util.Iterator r5 = r0.iterator()     // Catch: org.json.JSONException -> L4d
        L41:
            boolean r0 = r5.hasNext()     // Catch: org.json.JSONException -> L4d
            if (r0 == 0) goto L4a
            r0 = 11
            goto Le
        L4a:
            r0 = 15
            goto Le
        L4d:
            r3 = move-exception
            com.facebook.ads.redexgen.X.43 r0 = A02(r7)
            r0.A0M()
            r2 = 155(0x9b, float:2.17E-43)
            r1 = 9
            r0 = 34
            java.lang.String r2 = A05(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A1Y
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r3)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r7, r2, r1, r0)
            r0 = 15
            goto Le
        L6c:
            com.facebook.ads.redexgen.X.46 r4 = (com.facebook.ads.redexgen.X.AnonymousClass46) r4
            com.facebook.ads.redexgen.X.46 r4 = (com.facebook.ads.redexgen.X.AnonymousClass46) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass43.A04(com.facebook.ads.redexgen.X.Ef):com.facebook.ads.redexgen.X.46");
    }

    public static String A06(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(303, 14, 97), A05(134, 0, 4));
    }

    public static String A07(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(283, 20, 118), A05(611, 38, 27));
    }

    public static String A08(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(713, 16, 2), A05(492, 10, 14));
    }

    public static String A09(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(189, 18, 101), A05(351, 12, 45));
    }

    public static String A0A(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(136, 19, 13), A05(729, 23, 117));
    }

    public static String A0B(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(464, 7, 2), A05(604, 7, 48));
    }

    public static String A0C(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(164, 25, 61), A05(134, 0, 4));
    }

    public static String A0D(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(77, 21, 27), A05(514, 21, 83));
    }

    public static String A0E(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(405, 21, 101), A05(426, 38, 89));
    }

    public static String A0F(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(396, 9, 14), A05(317, 9, 78));
    }

    public static String A0G(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(243, 20, 36), A05(471, 21, 95));
    }

    public static String A0H(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(326, 25, 73), A05(535, 69, 44));
    }

    public static String A0I(C0365Ef c0365Ef) {
        return A02(c0365Ef).A0J(A05(17, 27, 21), A05(649, 64, 42));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String A0J(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            android.content.SharedPreferences r0 = r4.A00
            java.lang.String r3 = r0.getString(r5, r6)
            if (r3 == 0) goto L28
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L23;
                case 4: goto L2a;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            java.lang.String r3 = (java.lang.String) r3
            r2 = 279(0x117, float:3.91E-43)
            r1 = 4
            r0 = 26
            java.lang.String r0 = A05(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L21
            r0 = 3
            goto La
        L21:
            r0 = 4
            goto La
        L23:
            java.lang.String r6 = (java.lang.String) r6
            r3 = r6
            r0 = 4
            goto La
        L28:
            r0 = 3
            goto La
        L2a:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass43.A0J(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cc, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.facebook.ads.redexgen.X.AnonymousClass46> A0K(java.lang.String r10) throws org.json.JSONException {
        /*
            r6 = 0
            r5 = 0
            r4 = 0
            r7 = 0
            r3 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto Lc5
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L2b;
                case 4: goto Lc8;
                case 5: goto L1c;
                case 6: goto L10;
                case 7: goto L47;
                case 8: goto L98;
                case 9: goto La8;
                case 10: goto Lb9;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            org.json.JSONArray r4 = (org.json.JSONArray) r4
            int r0 = r4.length()
            if (r5 >= r0) goto L1a
            r0 = 7
            goto Lc
        L1a:
            r0 = 4
            goto Lc
        L1c:
            java.lang.String r10 = (java.lang.String) r10
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>(r10)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r5 = 0
            r0 = 6
            goto Lc
        L2b:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r0 = 4
            goto Lc
        L32:
            java.lang.String r10 = (java.lang.String) r10
            r2 = 279(0x117, float:3.91E-43)
            r1 = 4
            r0 = 26
            java.lang.String r0 = A05(r2, r1, r0)
            boolean r0 = r10.equalsIgnoreCase(r0)
            if (r0 == 0) goto L45
            r0 = 3
            goto Lc
        L45:
            r0 = 5
            goto Lc
        L47:
            org.json.JSONArray r4 = (org.json.JSONArray) r4
            java.lang.Object r8 = r4.get(r5)
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            com.facebook.ads.redexgen.X.46 r6 = new com.facebook.ads.redexgen.X.46
            r2 = 502(0x1f6, float:7.03E-43)
            r1 = 12
            r0 = 114(0x72, float:1.6E-43)
            java.lang.String r0 = A05(r2, r1, r0)
            int r9 = r8.getInt(r0)
            r2 = 44
            r1 = 11
            r0 = 54
            java.lang.String r0 = A05(r2, r1, r0)
            java.lang.String r7 = r8.getString(r0)
            r2 = 207(0xcf, float:2.9E-43)
            r1 = 16
            r0 = 32
            java.lang.String r0 = A05(r2, r1, r0)
            java.lang.String r0 = r8.optString(r0)
            r6.<init>(r9, r7, r0)
            r2 = 263(0x107, float:3.69E-43)
            r1 = 16
            r0 = 48
            java.lang.String r0 = A05(r2, r1, r0)
            java.lang.String r0 = r8.optString(r0)
            java.util.List r0 = A0K(r0)
            java.util.Iterator r7 = r0.iterator()
            r0 = 8
            goto Lc
        L98:
            java.util.Iterator r7 = (java.util.Iterator) r7
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto La4
            r0 = 9
            goto Lc
        La4:
            r0 = 10
            goto Lc
        La8:
            com.facebook.ads.redexgen.X.46 r6 = (com.facebook.ads.redexgen.X.AnonymousClass46) r6
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r0 = r7.next()
            com.facebook.ads.redexgen.X.46 r0 = (com.facebook.ads.redexgen.X.AnonymousClass46) r0
            r6.A06(r0)
            r0 = 8
            goto Lc
        Lb9:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            com.facebook.ads.redexgen.X.46 r6 = (com.facebook.ads.redexgen.X.AnonymousClass46) r6
            r3.add(r6)
            int r5 = r5 + 1
            r0 = 6
            goto Lc
        Lc5:
            r0 = 3
            goto Lc
        Lc8:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.List r3 = (java.util.List) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass43.A0K(java.lang.String):java.util.List");
    }

    @Nullable
    public static Map<String, String> A0L(C0365Ef c0365Ef, @Nullable String str) {
        if (str == null || str.isEmpty() || str.equals(A05(134, 2, 118))) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (String str2 : A03) {
                if (!jSONObject.has(str2)) {
                    return null;
                }
                hashMap.put(str2, jSONObject.getString(str2));
            }
            if (A0K(jSONObject.getString(A05(0, 17, 15))).size() == 0) {
                C0511Kb.A06(c0365Ef, A05(155, 9, 34), C0512Kc.A1X, new C0514Ke(A05(223, 20, 27)));
                return null;
            }
            if (A0K(jSONObject.getString(A05(381, 15, 25))).size() != 0) {
                return hashMap;
            }
            C0511Kb.A06(c0365Ef, A05(155, 9, 34), C0512Kc.A1U, new C0514Ke(A05(363, 18, 116)));
            return null;
        } catch (JSONException e) {
            C0511Kb.A06(c0365Ef, A05(155, 9, 34), C0512Kc.A1W, new C0514Ke(e));
            return null;
        }
    }

    private void A0M() {
        SharedPreferences.Editor edit = this.A00.edit();
        edit.putLong(A05(55, 22, 98), 0L);
        edit.apply();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0O(com.facebook.ads.redexgen.X.C0365Ef r8, @android.support.annotation.Nullable java.lang.String r9) {
        /*
            r7 = 0
            r3 = 0
            r6 = 0
            r5 = 0
            r0 = 0
            java.util.Map r4 = A0L(r8, r9)
            if (r4 == 0) goto L64
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L3d;
                case 3: goto L66;
                case 4: goto L2b;
                case 5: goto L25;
                case 6: goto L10;
                case 7: goto L4c;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.util.Map r4 = (java.util.Map) r4
            android.content.SharedPreferences$Editor r7 = (android.content.SharedPreferences.Editor) r7
            java.lang.String[] r5 = (java.lang.String[]) r5
            r1 = r5[r3]
            java.lang.Object r0 = r4.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r7.putString(r1, r0)
            int r3 = r3 + 1
            r0 = 5
            goto Lc
        L25:
            if (r3 >= r6) goto L29
            r0 = 6
            goto Lc
        L29:
            r0 = 7
            goto Lc
        L2b:
            com.facebook.ads.redexgen.X.Ef r8 = (com.facebook.ads.redexgen.X.C0365Ef) r8
            com.facebook.ads.redexgen.X.43 r0 = A02(r8)
            android.content.SharedPreferences r0 = r0.A00
            android.content.SharedPreferences$Editor r7 = r0.edit()
            java.lang.String[] r5 = com.facebook.ads.redexgen.X.AnonymousClass43.A03
            int r6 = r5.length
            r3 = 0
            r0 = 5
            goto Lc
        L3d:
            java.util.Map r4 = (java.util.Map) r4
            int r1 = r4.size()
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.AnonymousClass43.A03
            int r0 = r0.length
            if (r1 == r0) goto L4a
            r0 = 3
            goto Lc
        L4a:
            r0 = 4
            goto Lc
        L4c:
            android.content.SharedPreferences$Editor r7 = (android.content.SharedPreferences.Editor) r7
            r2 = 55
            r1 = 22
            r0 = 98
            java.lang.String r2 = A05(r2, r1, r0)
            long r0 = java.lang.System.currentTimeMillis()
            r7.putLong(r2, r0)
            r7.apply()
            r0 = 3
            goto Lc
        L64:
            r0 = 3
            goto Lc
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass43.A0O(com.facebook.ads.redexgen.X.Ef, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x004c, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0P(com.facebook.ads.redexgen.X.C0365Ef r8, boolean r9) {
        /*
            r0 = 0
            r1 = 0
            r0 = 0
            r2 = 0
            r2 = 1
            r3 = 0
            if (r9 != 0) goto L4a
            r3 = 2
        L9:
            switch(r3) {
                case 2: goto L2b;
                case 3: goto L28;
                case 4: goto L17;
                case 5: goto L14;
                case 6: goto Ld;
                case 7: goto L38;
                case 8: goto L4c;
                case 9: goto L40;
                case 10: goto L44;
                case 11: goto L47;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            if (r0 == 0) goto L11
            r3 = 7
            goto L9
        L11:
            r3 = 9
            goto L9
        L14:
            r1 = r2
            r3 = 6
            goto L9
        L17:
            com.facebook.ads.redexgen.X.Ef r8 = (com.facebook.ads.redexgen.X.C0365Ef) r8
            long r6 = A00(r8)
            r4 = 0
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L25
            r3 = 5
            goto L9
        L25:
            r3 = 10
            goto L9
        L28:
            r0 = r2
            r3 = 4
            goto L9
        L2b:
            com.facebook.ads.redexgen.X.Ef r8 = (com.facebook.ads.redexgen.X.C0365Ef) r8
            boolean r3 = com.facebook.ads.redexgen.X.C0413Gc.A17(r8)
            if (r3 == 0) goto L35
            r3 = 3
            goto L9
        L35:
            r3 = 11
            goto L9
        L38:
            if (r1 == 0) goto L3d
            r3 = 8
            goto L9
        L3d:
            r3 = 9
            goto L9
        L40:
            r2 = 0
            r3 = 8
            goto L9
        L44:
            r1 = 0
            r3 = 6
            goto L9
        L47:
            r0 = 0
            r3 = 4
            goto L9
        L4a:
            r3 = 3
            goto L9
        L4c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass43.A0P(com.facebook.ads.redexgen.X.Ef, boolean):boolean");
    }
}
