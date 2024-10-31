package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: assets/audience_network.dex */
public final class DJ extends C0279Ax {

    @Nullable
    public static Class A01;

    @Nullable
    public static Method A02;
    public static byte[] A03;
    public static final String A04;
    public final Context A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.DJ.A03
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
            r0 = r0 ^ 103(0x67, float:1.44E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DJ.A05(int, int, int):java.lang.String");
    }

    public static void A08() {
        A03 = new byte[]{23, 24, 18, 4, 25, 31, 18, 88, 25, 5, 88, 37, 15, 5, 2, 19, 27, 38, 4, 25, 6, 19, 4, 2, 31, 19, 5, 84, 99, 99, 126, 99, 49, 119, 116, 101, 114, 121, 120, Byte.MAX_VALUE, 118, 49, 66, 104, 98, 101, 116, 124, 49, 82, 125, 112, 98, 98, 18, 37, 37, 56, 37, 119, 49, 50, 35, 52, 63, 62, 57, 48, 119, 4, 46, 36, 35, 50, 58, 119, 26, 50, 35, 63, 56, 51, 93, 95, 78};
    }

    static {
        A08();
        A04 = DJ.class.getSimpleName();
    }

    public DJ(Context context, AA aa) {
        super(context, aa);
        this.A00 = context;
        A01 = A04(this.A00);
        A02 = A06();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC0351Dr A02(HashMap<String, DI> hashMap) {
        return new E2(SystemClock.elapsedRealtime(), A02(), hashMap, E8.A0C);
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public static Class A04(Context context) {
        try {
            return context.getClassLoader().loadClass(A05(0, 27, 17));
        } catch (ClassNotFoundException e) {
            Log.e(A04, A05(27, 27, 118), e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:            return r6;     */
    @javax.annotation.Nullable
    @android.annotation.SuppressLint({"BadMethodUse-android.util.Log.e"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Method A06() {
        /*
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r7 = 0
            r6 = 0
            r5 = 1
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 7: goto L1c;
                case 12: goto L41;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.NoSuchMethodException -> L2e
            r1 = 0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r7[r1] = r0     // Catch: java.lang.NoSuchMethodException -> L2e
            java.lang.Class r0 = com.facebook.ads.redexgen.X.DJ.A01     // Catch: java.lang.NoSuchMethodException -> L2e
            if (r0 != 0) goto L1a
            r0 = 12
            goto L8
        L1a:
            r0 = 7
            goto L8
        L1c:
            java.lang.Class r3 = com.facebook.ads.redexgen.X.DJ.A01     // Catch: java.lang.NoSuchMethodException -> L2e
            r2 = 82
            r1 = 3
            r0 = 93
            java.lang.String r0 = A05(r2, r1, r0)     // Catch: java.lang.NoSuchMethodException -> L2e
            java.lang.reflect.Method r6 = r3.getMethod(r0, r7)     // Catch: java.lang.NoSuchMethodException -> L2e
            r0 = 12
            goto L8
        L2e:
            r4 = move-exception
            java.lang.String r3 = com.facebook.ads.redexgen.X.DJ.A04
            r2 = 54
            r1 = 28
            r0 = 48
            java.lang.String r0 = A05(r2, r1, r0)
            android.util.Log.e(r3, r0, r4)
            r0 = 12
            goto L8
        L41:
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DJ.A06():java.lang.reflect.Method");
    }

    public final InterfaceC0267Al A0G(List<C0345Dl> list) {
        return new DH(this, list);
    }
}
