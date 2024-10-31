package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.support.annotation.Nullable;

/* loaded from: assets/audience_network.dex */
public final class JH {
    public static byte[] A00;

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.JH.A00
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
            r0 = r0 ^ 71
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JH.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A00 = new byte[]{81, 94, 84, 66, 95, 89, 84, 30, 81, 64, 64, 30, 113, 83, 68, 89, 70, 89, 68, 73, 100, 88, 66, 85, 81, 84, 38, 55, 35, 37, 51, 50, 63, 41, 46, 46, 57, 50, 40, 29, 63, 40, 53, 42, 53, 40, 37, 8, 52, 46, 57, 61, 56, 61, 17, 51, 36, 57, 38, 57, 36, 57, 53, 35, 116, 118, 97, 124, 99, 124, 97, 108};
    }

    @Nullable
    public static Activity A00() {
        try {
            return A01();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.app.Activity A01() throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException, java.lang.NoSuchFieldException, java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        /*
            r8 = 0
            r7 = 0
            r0 = 0
            r6 = 0
            r0 = 0
            r0 = 0
            r4 = 0
            r3 = 0
            r5 = 1
            r2 = 0
            r1 = 26
            r0 = 119(0x77, float:1.67E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.Class r9 = java.lang.Class.forName(r0)
            r2 = 32
            r1 = 21
            r0 = 27
            java.lang.String r1 = A02(r2, r1, r0)
            java.lang.Class[] r0 = new java.lang.Class[r4]
            java.lang.reflect.Method r1 = r9.getMethod(r1, r0)
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.Object r4 = r1.invoke(r3, r0)
            r2 = 53
            r1 = 11
            r0 = 23
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.reflect.Field r0 = r9.getDeclaredField(r0)
            r0.setAccessible(r5)
            java.lang.Object r4 = r0.get(r4)
            java.util.Map r4 = (java.util.Map) r4
            if (r4 != 0) goto La3
            r0 = 2
        L46:
            switch(r0) {
                case 2: goto La5;
                case 3: goto L4a;
                case 4: goto L56;
                case 5: goto L7f;
                case 6: goto L62;
                default: goto L49;
            }
        L49:
            goto L46
        L4a:
            java.util.Map r4 = (java.util.Map) r4
            java.util.Collection r0 = r4.values()
            java.util.Iterator r6 = r0.iterator()
            r0 = 4
            goto L46
        L56:
            java.util.Iterator r6 = (java.util.Iterator) r6
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L60
            r0 = 5
            goto L46
        L60:
            r0 = 2
            goto L46
        L62:
            java.lang.Object r7 = (java.lang.Object) r7
            java.lang.Class r8 = (java.lang.Class) r8
            r2 = 64
            r1 = 8
            r0 = 82
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.reflect.Field r0 = r8.getDeclaredField(r0)
            r0.setAccessible(r5)
            java.lang.Object r3 = r0.get(r7)
            android.app.Activity r3 = (android.app.Activity) r3
            r0 = 2
            goto L46
        L7f:
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r6.next()
            java.lang.Class r8 = r7.getClass()
            r2 = 26
            r1 = 6
            r0 = 17
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.reflect.Field r0 = r8.getDeclaredField(r0)
            r0.setAccessible(r5)
            boolean r0 = r0.getBoolean(r7)
            if (r0 != 0) goto La1
            r0 = 6
            goto L46
        La1:
            r0 = 4
            goto L46
        La3:
            r0 = 3
            goto L46
        La5:
            android.app.Activity r3 = (android.app.Activity) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JH.A01():android.app.Activity");
    }
}
