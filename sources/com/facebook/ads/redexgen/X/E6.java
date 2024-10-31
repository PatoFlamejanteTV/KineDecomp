package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Log;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class E6 {
    public static byte[] A05;
    public static final String A06;
    public final int A00;
    public final E5 A01;

    @Nullable
    public final String A02;

    @Nullable
    public final String A03;

    @Nullable
    public final String A04;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.E6.A05
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
            r0 = r0 ^ 34
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.E6.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A05 = new byte[]{74, 125, 125, 96, 125, 47, 76, 125, 106, 110, 123, 102, 97, 104, 47, 69, 92, 64, 65, 62, 53, 6, 16, 110, 104, 23, 31};
    }

    static {
        A01();
        A06 = E6.class.getSimpleName();
    }

    public E6(E5 e5) {
        this.A01 = e5;
        this.A00 = e5.A02();
        this.A03 = null;
        this.A02 = null;
        this.A04 = null;
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public E6(Throwable th) {
        String stackTraceElement;
        this.A01 = E5.A07;
        this.A00 = th.getClass().getName().hashCode();
        this.A03 = th.getClass().getName();
        this.A02 = th.getMessage();
        if (th.getStackTrace() != null && th.getStackTrace().length > 1 && th.getStackTrace().toString().length() > 500) {
            stackTraceElement = th.getStackTrace()[0].toString().substring(0, 500);
        } else {
            stackTraceElement = th.getStackTrace()[0].toString();
        }
        this.A04 = stackTraceElement;
    }

    public final int A02() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0056, code lost:            return r6 + r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A03() {
        /*
            r7 = this;
            r5 = r7
            r6 = 0
            r0 = 0
            r4 = 0
            r3 = 0
            r2 = 0
            r1 = 0
            java.lang.String r0 = r5.A03
            if (r0 == 0) goto L52
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L27;
                case 3: goto L3d;
                case 4: goto L32;
                case 5: goto L1b;
                case 6: goto L10;
                case 7: goto L55;
                case 8: goto L4a;
                case 9: goto L4e;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.E6 r5 = (com.facebook.ads.redexgen.X.E6) r5
            java.lang.String r0 = r5.A04
            byte[] r0 = r0.getBytes()
            int r1 = r0.length
            r0 = 7
            goto Lc
        L1b:
            com.facebook.ads.redexgen.X.E6 r5 = (com.facebook.ads.redexgen.X.E6) r5
            int r6 = r4 + r3
            java.lang.String r0 = r5.A04
            if (r0 == 0) goto L25
            r0 = 6
            goto Lc
        L25:
            r0 = 7
            goto Lc
        L27:
            com.facebook.ads.redexgen.X.E6 r5 = (com.facebook.ads.redexgen.X.E6) r5
            java.lang.String r0 = r5.A03
            byte[] r0 = r0.getBytes()
            int r2 = r0.length
            r0 = 3
            goto Lc
        L32:
            com.facebook.ads.redexgen.X.E6 r5 = (com.facebook.ads.redexgen.X.E6) r5
            java.lang.String r0 = r5.A02
            byte[] r0 = r0.getBytes()
            int r4 = r0.length
            r0 = 5
            goto Lc
        L3d:
            com.facebook.ads.redexgen.X.E6 r5 = (com.facebook.ads.redexgen.X.E6) r5
            int r3 = r2 + 4
            java.lang.String r0 = r5.A02
            if (r0 == 0) goto L47
            r0 = 4
            goto Lc
        L47:
            r0 = 8
            goto Lc
        L4a:
            r1 = 0
            r4 = r1
            r0 = 5
            goto Lc
        L4e:
            r1 = 0
            r2 = r1
            r0 = 3
            goto Lc
        L52:
            r0 = 9
            goto Lc
        L55:
            int r6 = r6 + r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.E6.A03():int");
    }

    public final E5 A04() {
        return this.A01;
    }

    @Nullable
    public final String A05() {
        return this.A02;
    }

    @Nullable
    public final String A06() {
        return this.A03;
    }

    @Nullable
    public final String A07() {
        return this.A04;
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public final JSONObject A08() {
        JSONObject jSONObject = new JSONObject();
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        switch (this.A01) {
                            case A07:
                                c = '\n';
                                break;
                            default:
                                c = 7;
                                break;
                        }
                    } catch (JSONException e) {
                        Log.e(A06, A00(0, 19, 45), e);
                        break;
                    }
                case 7:
                    jSONObject.put(A00(23, 2, 41), this.A00);
                    break;
                case '\n':
                    jSONObject.put(A00(23, 2, 41), this.A00);
                    jSONObject.put(A00(19, 2, 121), this.A03);
                    jSONObject.put(A00(25, 2, 80), this.A02);
                    jSONObject.put(A00(21, 2, 65), this.A04);
                    break;
            }
        }
        return jSONObject;
    }
}
