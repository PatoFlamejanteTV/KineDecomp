package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.facebook.ads.redexgen.X.Gd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0414Gd {
    public static byte[] A00;

    static {
        A0M();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0K(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0414Gd.A00
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0414Gd.A0K(int, int, int):java.lang.String");
    }

    public static void A0M() {
        A00 = new byte[]{86, 89, 99, 108, 84, 97, 100, 92, 84, 86, 89, 89, 94, 105, 94, 100, 99, 86, 97, 84, 97, 100, 92, 92, 94, 99, 92, 84, 104, 90, 104, 104, 94, 100, 99, 84, 90, 107, 90, 99, 105, 104, 84, 86, 97, 108, 86, 110, 104, 50, 53, 63, 72, 48, 70, 68, 54, 48, 68, 57, 64, 67, 69, 48, 54, 63, 71, 48, 53, 50, 69, 50, 48, 55, 64, 67, 48, 50, 53, 53, 58, 69, 58, 64, 63, 50, 61, 48, 61, 64, 56, 56, 58, 63, 56, 56, 59, 69, 78, 54, 56, 69, 59, 73, 70, 64, 59, 54, 59, 64, 74, 71, 56, 75, 58, 63, 60, 73, 54, 68, 56, 79, 54, 73, 60, 75, 73, 80, 54, 58, 70, 76, 69, 75, -9, -6, -6, -1, 10, -1, 5, 4, -9, 2, -11, -6, -5, -8, 11, -3, -11, 2, 5, -3, -3, -1, 4, -3, -11, -8, 2, -9, -7, 1, -11, 2, -1, 9, 10, 26, 29, 39, 48, 24, 26, 39, 29, 43, 40, 34, 29, 24, 39, 26, 45, 34, 47, 30, 24, 47, 34, 30, 48, 26, 27, 34, 37, 34, 45, 50, 24, 33, 34, 44, 45, 40, 43, 50, 24, 44, 26, 38, 41, 37, 34, 39, 32, 24, 43, 26, 45, 30, 16, 19, 29, 38, 14, 27, 30, 22, 14, 16, 19, 19, 24, 35, 24, 30, 29, 16, 27, 14, 27, 30, 22, 22, 24, 29, 22, 14, 20, 37, 20, 29, 35, 34, 14, 27, 24, 28, 24, 35, 63, 65, 60, 65, 62, 81, 62, 60, 73, 76, 68, 68, 70, 75, 68, 60, 73, 70, 74, 70, 81, 36, 39, 49, 58, 34, 36, 49, 39, 53, 50, 44, 39, 34, 56, 54, 40, 34, 47, 50, 38, 36, 47, 34, 38, 50, 56, 49, 55, 40, 53, 54, 33, 60, 53, 48, 45, 48, 44, 43, 38, 51, 54, 46, 46, 48, 53, 46, 38, 44, 61, 44, 53, 59, 38, 51, 48, 52, 48, 59, -5, -2, 8, 17, -7, -5, 8, -2, 12, 9, 3, -2, -7, 6, 9, -3, -5, 6, -7, -3, 9, 15, 8, 14, -1, 12, 13, -7, 13, -5, 7, 10, 6, 3, 8, 1, -7, 12, -5, 14, -1, 0, 2, 27, 30, 40, 49, 25, 30, 31, 28, 47, 33, 25, 38, 41, 33, 25, 32, 35, 38, 31, 25, 45, 35, 52, 31, 25, 38, 35, 39, 35, 46, 25, 28, 51, 46, 31, 45, 12, 15, 15, 20, 31, 20, 26, 25, 12, 23, 10, 15, 16, 13, 32, 18, 10, 23, 26, 18, 18, 20, 25, 18, 10, 30, 12, 24, 27, 23, 20, 25, 18, 10, 27, 16, 29, 14, 16, 25, 31, 12, 18, 16, 10, 3, -2, -5, -2, -6, -7, -12, 1, 4, -4, -4, -2, 3, -4, -12, -7, -2, 8, 5, -10, 9, -8, -3, -12, -2, 3, 9, -6, 7, 11, -10, 1, -12, 8, -6, -8, 4, 3, -7, 8, -12, -9, -9, -4, 7, -4, 2, 1, -12, -1, -14, -9, -8, -11, 8, -6, -14, -1, 2, -6, -6, -4, 1, -6, -14, -11, -1, -12, -10, -2, -14, -1, -4, 6, 7, -14, 3, -8, 5, -10, -8, 1, 7, -12, -6, -8, 2, 5, 15, 24, 0, 5, 6, 3, 22, 8, 0, 13, 16, 8, 8, 10, 15, 8, 54, 57, 67, 76, 52, 54, 57, 57, 62, 73, 62, 68, 67, 54, 65, 52, 65, 68, 60, 60, 62, 67, 60, 52, 74, 72, 58, 52, 73, 58, 66, 69, 52, 59, 62, 65, 58, 52, 59, 68, 71, 52, 71, 58, 76, 71, 62, 73, 58, -34, -31, -21, -12, -36, -16, -30, -21, -31, -36, -34, -31, -31, -26, -15, -26, -20, -21, -34, -23, -36, -31, -30, -33, -14, -28, -36, -23, -20, -28, -28, -26, -21, -28, -36, -16, -15, -34, -32, -24, -15, -17, -34, -32, -30, -25, -22, -12, -3, -27, -25, -12, -22, -8, -11, -17, -22, -27, -12, -21, -6, -3, -11, -8, -15, -27, -22, -21, -24, -5, -19, -27, -21, -4, -21, -12, -6, -7, -27, -7, -25, -13, -10, -14, -17, -12, -19, -27, -8, -25, -6, -21, -17, -14, -4, 5, -19, -17, -4, -14, 0, -3, -9, -14, -19, -12, 3, -4, -4, -13, -6, -19, -14, -13, -16, 3, -11, -19, -13, 4, -13, -4, 2, 1, -19, 1, -17, -5, -2, -6, -9, -4, -11, -19, 0, -17, 2, -13, 76, 69, 64, 61, 64, 60, 59, 54, 67, 70, 62, 62, 64, 69, 62, 54, 73, 60, 75, 73, 80, 54, 67, 64, 68, 64, 75, 23, 26, 36, 45, 21, 23, 26, 26, 31, 42, 31, 37, 36, 23, 34, 21, 34, 37, 29, 29, 31, 36, 29, 21, 40, 27, 42, 40, 47, 21, 34, 31, 35, 31, 42, 19, 22, 32, 41, 17, 22, 23, 20, 39, 25, 17, 30, 33, 25, 25, 27, 32, 25, 17, 23, 40, 23, 32, 38, 17, 30, 27, 31, 27, 38, -27, -24, -14, -5, -29, -27, -14, -24, -10, -13, -19, -24, -29, -24, -19, -9, -12, -27, -8, -25, -20, -23, -10, -29, -19, -14, -19, -8, -19, -27, -16, -29, -10, -23, -8, -10, -3, -29, -24, -23, -16, -27, -3, -29, -15, -9, 73, 76, 86, 95, 71, 73, 86, 76, 90, 87, 81, 76, 71, 75, 73, 75, 80, 77, 71, 76, 77, 74, 93, 79, 71, 77, 94, 77, 86, 92, 91, 71, 91, 73, 85, 88, 84, 81, 86, 79, 71, 90, 73, 92, 77, 42, 35, 30, 27, 30, 26, 25, 20, 33, 36, 28, 28, 30, 35, 28, 20, 30, 34, 34, 26, 25, 30, 22, 41, 26, 20, 25, 26, 33, 22, 46, 20, 34, 40, -35, -32, -22, -13, -37, -24, -21, -29, -37, -35, -32, -32, -27, -16, -27, -21, -22, -35, -24, -37, -24, -21, -29, -29, -27, -22, 
        -29, -37, -27, -22, -37, -23, -31, -23, -21, -18, -11, -37, -31, -14, -31, -22, -16, -17, -37, -24, -27, -23, -27, -16, -1, 29, 42, -29, 48, -36, 44, 29, 46, 47, 33, -36, 47, 29, 41, 44, 40, 37, 42, 35, -22};
    }

    public static int A00(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(222, 40, 54), 10);
    }

    public static int A01(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(974, 50, 3), 50);
    }

    public static int A02(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(784, 35, 61), 1);
    }

    public static int A03(Context context) {
        return A0G(context, A0K(506, 46, 26), 0);
    }

    public static int A04(Context context) {
        return A0G(context, A0K(421, 44, 50), 0);
    }

    public static int A05(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(262, 21, 100), 10);
    }

    public static int A06(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(895, 45, 111), 0);
    }

    public static int A07(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(385, 36, 65), 10485760);
    }

    public static int A08(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(819, 30, 57), 30);
    }

    public static int A09(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(95, 39, 94), 5);
    }

    public static int A0A(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(711, 46, 21), 0);
    }

    public static int A0B(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(342, 41, 33), 0);
    }

    public static int A0C(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(169, 53, 64), 0);
    }

    public static int A0D(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(664, 47, 13), 0);
    }

    public static int A0E(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(315, 27, 78), 30);
    }

    public static int A0F(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(757, 27, 94), 20);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x001d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A0G(android.content.Context r1, java.lang.String r2, int r3) {
        /*
            r0 = 0
            com.facebook.ads.redexgen.X.Gc r0 = com.facebook.ads.redexgen.X.C0413Gc.A0I(r1)
            int r1 = r0.A1M(r2, r3)
            if (r1 < 0) goto L1b
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L1d;
                case 4: goto L18;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r0 = 101(0x65, float:1.42E-43)
            if (r1 >= r0) goto L16
            r0 = 3
            goto Lc
        L16:
            r0 = 4
            goto Lc
        L18:
            r1 = r3
            r0 = 3
            goto Lc
        L1b:
            r0 = 4
            goto Lc
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0414Gd.A0G(android.content.Context, java.lang.String, int):int");
    }

    public static long A0H(Context context) {
        return C0413Gc.A0I(context).A1N(A0K(849, 46, 11), 2000L);
    }

    public static long A0I(Context context) {
        return C0413Gc.A0I(context).A1M(A0K(465, 41, 28), 300) * 1000;
    }

    public static long A0J(Context context) {
        return C0413Gc.A0I(context).A1N(A0K(940, 34, 60), 500L);
    }

    public static HashMap<String, Integer> A0L(Context context) throws JSONException {
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String A1O = C0413Gc.A0I(context).A1O(A0K(134, 35, 29), A0K(383, 2, 44));
        HashMap<String, Integer> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray(A1O);
        int i = 0;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    jSONArray = jSONArray;
                    if (i >= jSONArray.length()) {
                        c = 11;
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    jSONArray = jSONArray;
                    str2 = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(str2)) {
                        c = 4;
                        break;
                    } else {
                        c = '\t';
                        break;
                    }
                case 4:
                    str2 = str2;
                    if (!str2.contains(A0K(314, 1, 106))) {
                        c = '\b';
                        break;
                    } else {
                        c = 5;
                        break;
                    }
                case 5:
                    str2 = str2;
                    strArr = str2.split(A0K(314, 1, 106));
                    str = strArr[1];
                    c = 6;
                    break;
                case 6:
                    try {
                        str = str;
                        hashMap.put(strArr[0], Integer.valueOf(Integer.parseInt(str)));
                        c = '\t';
                        break;
                    } catch (NumberFormatException unused) {
                        throw new JSONException(A0K(1024, 21, 67));
                    }
                case '\b':
                    hashMap = hashMap;
                    str2 = str2;
                    hashMap.put(str2, -1);
                    c = '\t';
                    break;
                case '\t':
                    i++;
                    c = 2;
                    break;
                case 11:
                    return hashMap;
            }
        }
    }

    public static boolean A0N(Context context) {
        return C0413Gc.A0I(context).A1Q(A0K(570, 49, 92), true);
    }

    public static boolean A0O(Context context) {
        return C0413Gc.A0I(context).A1Q(A0K(552, 18, 40), false);
    }

    public static boolean A0P(Context context) {
        return C0413Gc.A0I(context).A1Q(A0K(0, 49, 124), true);
    }

    public static boolean A0Q(Context context) {
        return C0413Gc.A0I(context).A1Q(A0K(619, 45, 4), false);
    }

    public static boolean A0R(Context context) {
        return C0413Gc.A0I(context).A1Q(A0K(283, 31, 74), false);
    }

    public static boolean A0S(Context context) {
        return C0413Gc.A0I(context).A1Q(A0K(49, 46, 88), true);
    }
}
