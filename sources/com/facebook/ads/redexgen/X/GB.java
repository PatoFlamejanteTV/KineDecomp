package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.io.File;
import java.lang.reflect.Field;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class GB {
    public static byte[] A00;
    public static final String A01;
    public static final AtomicBoolean A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.GB.A00
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
            int r0 = r0 + (-90)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GB.A02(int, int, int):java.lang.String");
    }

    public static void A06() {
        A00 = new byte[]{-36, 8, 14, 5, -3, -71, 7, 8, 13, -71, -6, -3, -3, -71, 9, -6, 11, -6, 6, -2, 13, -2, 11, -45, 38, 39, 36, 55, 41, 33, 56, 35, 46, 55, 39, 7, 15, 15, 7, 12, 5, -1, 19, 4, 11, 41, 60, 48, 51, 43, 38, 59, 64, 55, 44, 35, 28, 25, 28, 29, 37, 28, -50, -20, -11, 0, -12, -10, -5, -16, -10, -11, 27, 37, 17, 23, 31, 39, -62, -47, -52, -64, -44, -54, -37, -58, -51, -36, -36, -53, -33, -32, -51, -34, -32, -47, -48, -53, -34, -47, -51, -33, -37, -38, -43, -24, -36, -33, -41, -14, -25, -20, -29, -40, -6, -8, 1, -8, 5, -4, -10, -29, 11, 19, 10, -1, 18, 13, 16, -12, -43, -25, 13, 23, 3, 8, 9, 6, 25, 11, 11, 5, 6, 16, 9, -57, -37, 14, 2, 5, -3, -36, 8, 7, -1, 2, 0, -11, -22, -18, -26, -5, -16, -17, -26, -32, -16, -25, -25, -12, -26, -11, 28, 29, 26, 45, 31, -51, -6, -16, -2, -5, -11, -16, -84, -33, -48, -41, -84, -18, 1, -11, -8, 0, -84, -14, -5, -2, -84, 4, -60, -62};
    }

    static {
        A06();
        A01 = GB.class.getSimpleName();
        A02 = new AtomicBoolean();
    }

    public static int A00() {
        return TimeZone.getDefault().getRawOffset();
    }

    public static long A01(C0361Eb c0361Eb) {
        try {
            return new File(c0361Eb.getPackageManager().getApplicationInfo(c0361Eb.getPackageName(), 0).publicSourceDir).length();
        } catch (Exception e) {
            if (A02.compareAndSet(false, true)) {
                C0511Kb.A06(c0361Eb, A02(114, 7, 57), C0512Kc.A0t, new C0514Ke(e));
            }
            return -1L;
        }
    }

    public static String A03(Context context) {
        try {
            Class buildConfigClass = Class.forName(context.getPackageName() + A02(145, 12, 63));
            Field buildType = buildConfigClass.getDeclaredField(A02(104, 10, 57));
            return (String) buildType.get(null);
        } catch (Exception unused) {
            return A02(129, 3, 76);
        }
    }

    public static String A04(Context context) {
        try {
            Class buildConfigClass = Class.forName(context.getPackageName() + A02(145, 12, 63));
            Field buildType = buildConfigClass.getDeclaredField(A02(172, 5, 126));
            return String.valueOf(buildType.getBoolean(null));
        } catch (Exception unused) {
            return A02(129, 3, 76);
        }
    }

    public static String A05(C0361Eb c0361Eb) {
        JSONObject jSONObject = new JSONObject();
        A07(jSONObject, A02(72, 6, 88), String.valueOf(A08()));
        A07(jSONObject, A02(78, 8, 7), String.valueOf(A01(c0361Eb)));
        A07(jSONObject, A02(157, 15, 39), String.valueOf(A00()));
        A07(jSONObject, A02(86, 18, 18), String.valueOf(JF.A01(c0361Eb)));
        A07(jSONObject, A02(132, 13, 74), String.valueOf(A09(c0361Eb)));
        A07(jSONObject, A02(24, 11, 104), A04(c0361Eb));
        A07(jSONObject, A02(45, 10, 109), A03(c0361Eb));
        return jSONObject.toString();
    }

    public static void A07(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A01, A02(0, 24, 63), e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x00e3, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A08() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GB.A08():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A09(android.content.Context r2) {
        /*
            r1 = 0
            android.content.pm.ApplicationInfo r0 = r2.getApplicationInfo()
            int r0 = r0.flags
            r0 = r0 & 2
            if (r0 == 0) goto L16
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L18;
                case 4: goto L13;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r1 = 1
            r0 = 3
            goto Lc
        L13:
            r1 = 0
            r0 = 3
            goto Lc
        L16:
            r0 = 4
            goto Lc
        L18:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GB.A09(android.content.Context):boolean");
    }
}
