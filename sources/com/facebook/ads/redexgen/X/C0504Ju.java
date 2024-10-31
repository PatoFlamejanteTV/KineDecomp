package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.support.annotation.Nullable;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.facebook.ads.redexgen.X.Ju, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0504Ju {
    public static byte[] A00;
    public static final Pattern A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0504Ju.A00
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
            r0 = r0 ^ 98
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0504Ju.A02(int, int, int):java.lang.String");
    }

    public static void A07() {
        A00 = new byte[]{7, 49, 54, 54, 33, 42, 48, 100, 55, 48, 37, 39, 47, 100, 48, 54, 37, 39, 33, 113, 5, 42, 114, 56, 45, 5, 42, 114, 2, 56, 116, 35, 119, 4, 114, 112, 2, 24, 116, 3, 4, 119, 115, 125, 113, 115, 48, 120, Byte.MAX_VALUE, 125, 123, 124, 113, 113, 117, 48, Byte.MAX_VALUE, 122, 109};
    }

    static {
        A07();
        A01 = Pattern.compile(A02(19, 24, 59));
    }

    public static String A00() {
        return A06(new Exception(A02(0, 19, 38)), -1, -1, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0028, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r4) {
        /*
            r0 = 0
            r3 = 0
            if (r4 > 0) goto L24
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L26;
                case 3: goto L9;
                case 4: goto L1e;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            java.util.Random r0 = new java.util.Random
            r0.<init>()
            float r2 = r0.nextFloat()
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = (float) r4
            float r1 = r1 / r0
            int r0 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r0 >= 0) goto L1c
            r0 = 4
            goto L5
        L1c:
            r0 = 2
            goto L5
        L1e:
            java.lang.String r3 = A00()
            r0 = 2
            goto L5
        L24:
            r0 = 3
            goto L5
        L26:
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0504Ju.A01(int):java.lang.String");
    }

    public static String A03(Context context, @Nullable Throwable th) {
        int maxStacktraceLines = C0413Gc.A0D(context);
        return A06(th, maxStacktraceLines, C0413Gc.A01(context), C0413Gc.A0m(context));
    }

    public static String A04(String str) {
        Matcher matcher = A01.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return str;
    }

    public static String A06(@Nullable Throwable th, int i, int i2, boolean z) {
        InterfaceC0497Jn interfaceC0497Jn;
        if (th == null) {
            return A02(0, 0, 49);
        }
        try {
            C0499Jp c0499Jp = new C0499Jp();
            if (i2 >= 0) {
                interfaceC0497Jn = new C0501Jr(c0499Jp, i2);
            } else {
                interfaceC0497Jn = c0499Jp;
            }
            if (i >= 0) {
                interfaceC0497Jn = new C0503Jt(interfaceC0497Jn, i, i);
            }
            if (z) {
                interfaceC0497Jn = new C0500Jq(interfaceC0497Jn);
            }
            C0498Jo c0498Jo = new C0498Jo(c0499Jp, 1, interfaceC0497Jn);
            th.printStackTrace(new PrintWriter(new C0502Js(c0498Jo)));
            c0498Jo.flush();
            return c0499Jp.toString();
        } catch (Exception unused) {
            return A02(0, 0, 49);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0083, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A08(com.facebook.ads.redexgen.X.C0496Jm r6) {
        /*
            r5 = 0
            r4 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r3 = 0
            r2 = 1
            java.lang.String r1 = r6.A02()
            if (r1 != 0) goto L81
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L83;
                case 3: goto L41;
                case 4: goto L2b;
                case 5: goto L1f;
                case 6: goto L12;
                case 7: goto L2e;
                case 8: goto L4d;
                case 9: goto L64;
                case 10: goto L71;
                case 11: goto L50;
                case 12: goto L7e;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.util.Iterator r4 = (java.util.Iterator) r4
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L1c
            r0 = 7
            goto Le
        L1c:
            r0 = 9
            goto Le
        L1f:
            com.facebook.ads.redexgen.X.Jm r6 = (com.facebook.ads.redexgen.X.C0496Jm) r6
            java.lang.Iterable r0 = r6.A01()
            java.util.Iterator r4 = r0.iterator()
            r0 = 6
            goto Le
        L2b:
            r3 = r2
            r0 = 2
            goto Le
        L2e:
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r0 = r4.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = A0A(r0)
            if (r0 == 0) goto L3f
            r0 = 8
            goto Le
        L3f:
            r0 = 6
            goto Le
        L41:
            java.lang.String r1 = (java.lang.String) r1
            boolean r0 = A0A(r1)
            if (r0 == 0) goto L4b
            r0 = 4
            goto Le
        L4b:
            r0 = 5
            goto Le
        L4d:
            r3 = r2
            r0 = 2
            goto Le
        L50:
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = A0A(r0)
            if (r0 == 0) goto L61
            r0 = 12
            goto Le
        L61:
            r0 = 10
            goto Le
        L64:
            com.facebook.ads.redexgen.X.Jm r6 = (com.facebook.ads.redexgen.X.C0496Jm) r6
            java.lang.Iterable r0 = r6.A00()
            java.util.Iterator r5 = r0.iterator()
            r0 = 10
            goto Le
        L71:
            java.util.Iterator r5 = (java.util.Iterator) r5
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L7c
            r0 = 11
            goto Le
        L7c:
            r0 = 2
            goto Le
        L7e:
            r3 = r2
            r0 = 2
            goto Le
        L81:
            r0 = 3
            goto Le
        L83:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0504Ju.A08(com.facebook.ads.redexgen.X.Jm):boolean");
    }

    public static boolean A0A(String str) {
        return str.contains(A02(43, 16, 124));
    }
}
