package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public final class JF {
    public static byte[] A00;

    static {
        A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.JF.A00
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
            int r0 = r0 + (-30)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JF.A03(int, int, int):java.lang.String");
    }

    public static void A04() {
        A00 = new byte[]{-60, -47, -57, -43, -46, -52, -57, -111, -60, -45, -45, -111, -92, -58, -41, -52, -39, -52, -41, -36, -73, -53, -43, -56, -60, -57, -74, -56, -59, -59, -72, -63, -57, -108, -74, -57, -68, -55, -68, -57, -52, -89, -69, -59, -72, -76, -73, -4, 9, -1, 13, 10, 4, -1, -55, 4, 9, 15, 0, 9, 15, -55, -2, -4, 15, 0, 2, 10, 13, 20, -55, -25, -36, -16, -23, -34, -29, -32, -19, 2, -42, -8, 9, -2, 11, -2, 9, -2, -6, 8, -27, -25, -8, -19, -6, -19, -8, -3};
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00be, code lost:            return (com.facebook.ads.redexgen.X.JE) r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.JE A00() throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException, java.lang.NoSuchFieldException, java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        /*
            r8 = 0
            r0 = 0
            r7 = 0
            r6 = 0
            r0 = 0
            r5 = 1
            r3 = 0
            r2 = 0
            r1 = 26
            r0 = 69
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.Class r4 = java.lang.Class.forName(r0)
            r2 = 26
            r1 = 21
            r0 = 53
            java.lang.String r1 = A03(r2, r1, r0)
            java.lang.Class[] r0 = new java.lang.Class[r3]
            java.lang.reflect.Method r2 = r4.getMethod(r1, r0)
            r1 = 0
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.Object r3 = r2.invoke(r1, r0)
            r2 = 79
            r1 = 11
            r0 = 119(0x77, float:1.67E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.reflect.Field r0 = r4.getDeclaredField(r0)
            r0.setAccessible(r5)
            java.lang.Object r4 = r0.get(r3)
            java.util.Map r4 = (java.util.Map) r4
            if (r4 != 0) goto Lb8
            r0 = 2
        L45:
            switch(r0) {
                case 2: goto L8d;
                case 3: goto Lba;
                case 4: goto L81;
                case 5: goto L74;
                case 6: goto L49;
                case 7: goto L91;
                case 8: goto Lb0;
                case 9: goto Lb4;
                default: goto L48;
            }
        L48:
            goto L45
        L49:
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r7.next()
            java.lang.Class r3 = r8.getClass()
            r2 = 90
            r1 = 8
            r0 = 102(0x66, float:1.43E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.reflect.Field r0 = r3.getDeclaredField(r0)
            r0.setAccessible(r5)
            java.lang.Object r8 = r0.get(r8)
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r0 = r8.isTaskRoot()
            if (r0 == 0) goto L72
            r0 = 7
            goto L45
        L72:
            r0 = 5
            goto L45
        L74:
            java.util.Iterator r7 = (java.util.Iterator) r7
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L7e
            r0 = 6
            goto L45
        L7e:
            r0 = 9
            goto L45
        L81:
            java.util.Map r4 = (java.util.Map) r4
            java.util.Collection r0 = r4.values()
            java.util.Iterator r7 = r0.iterator()
            r0 = 5
            goto L45
        L8d:
            com.facebook.ads.redexgen.X.JE r6 = com.facebook.ads.redexgen.X.JE.A0B
            r0 = 3
            goto L45
        L91:
            android.app.Activity r8 = (android.app.Activity) r8
            android.content.Intent r0 = r8.getIntent()
            java.util.Set r3 = r0.getCategories()
            r2 = 47
            r1 = 32
            r0 = 125(0x7d, float:1.75E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto Lae
            r0 = 8
            goto L45
        Lae:
            r0 = 5
            goto L45
        Lb0:
            com.facebook.ads.redexgen.X.JE r6 = com.facebook.ads.redexgen.X.JE.A06
            r0 = 3
            goto L45
        Lb4:
            com.facebook.ads.redexgen.X.JE r6 = com.facebook.ads.redexgen.X.JE.A09
            r0 = 3
            goto L45
        Lb8:
            r0 = 4
            goto L45
        Lba:
            com.facebook.ads.redexgen.X.JE r6 = (com.facebook.ads.redexgen.X.JE) r6
            com.facebook.ads.redexgen.X.JE r6 = (com.facebook.ads.redexgen.X.JE) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JF.A00():com.facebook.ads.redexgen.X.JE");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0029, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.JE A01(android.content.Context r3) {
        /*
            r2 = 0
            r0 = 2
        L2:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L5;
                case 4: goto Ld;
                case 5: goto L5;
                case 6: goto L6;
                case 7: goto L5;
                case 8: goto L5;
                case 9: goto L25;
                default: goto L5;
            }
        L5:
            goto L2
        L6:
            com.facebook.ads.redexgen.X.JE r2 = A00()     // Catch: java.lang.Exception -> L20
            r0 = 9
            goto L2
        Ld:
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Exception -> L20
            com.facebook.ads.redexgen.X.JE r2 = A02(r3)     // Catch: java.lang.Exception -> L20
            r0 = 9
            goto L2
        L16:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L20
            r0 = 21
            if (r1 < r0) goto L1e
            r0 = 4
            goto L2
        L1e:
            r0 = 6
            goto L2
        L20:
            com.facebook.ads.redexgen.X.JE r2 = com.facebook.ads.redexgen.X.JE.A04
            r0 = 9
            goto L2
        L25:
            com.facebook.ads.redexgen.X.JE r2 = (com.facebook.ads.redexgen.X.JE) r2
            com.facebook.ads.redexgen.X.JE r2 = (com.facebook.ads.redexgen.X.JE) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JF.A01(android.content.Context):com.facebook.ads.redexgen.X.JE");
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x00b9, code lost:            return r5;     */
    @android.support.annotation.RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.JE A02(android.content.Context r9) {
        /*
            r7 = 0
            r6 = 0
            r5 = 0
            r8 = 0
            r4 = 0
            if (r9 != 0) goto Lb2
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L50;
                case 3: goto Lb5;
                case 4: goto L21;
                case 5: goto L1d;
                case 6: goto Lc;
                case 7: goto L54;
                case 8: goto L47;
                case 9: goto L39;
                case 10: goto L58;
                case 11: goto L6c;
                case 12: goto L7c;
                case 13: goto L8d;
                case 14: goto Lad;
                case 15: goto L78;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4
            java.util.List r6 = r4.getAppTasks()
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L1a
            r0 = 7
            goto L8
        L1a:
            r0 = 8
            goto L8
        L1d:
            com.facebook.ads.redexgen.X.JE r5 = com.facebook.ads.redexgen.X.JE.A07
            r0 = 3
            goto L8
        L21:
            android.content.Context r9 = (android.content.Context) r9
            r2 = 90
            r1 = 8
            r0 = 102(0x66, float:1.43E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.Object r4 = r9.getSystemService(r0)
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4
            if (r4 != 0) goto L37
            r0 = 5
            goto L8
        L37:
            r0 = 6
            goto L8
        L39:
            java.util.Iterator r7 = (java.util.Iterator) r7
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L44
            r0 = 10
            goto L8
        L44:
            r0 = 15
            goto L8
        L47:
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r7 = r6.iterator()
            r0 = 9
            goto L8
        L50:
            com.facebook.ads.redexgen.X.JE r5 = com.facebook.ads.redexgen.X.JE.A0C
            r0 = 3
            goto L8
        L54:
            com.facebook.ads.redexgen.X.JE r5 = com.facebook.ads.redexgen.X.JE.A0A
            r0 = 3
            goto L8
        L58:
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r0 = r7.next()
            android.app.ActivityManager$AppTask r0 = (android.app.ActivityManager.AppTask) r0
            android.app.ActivityManager$RecentTaskInfo r8 = r0.getTaskInfo()
            if (r8 == 0) goto L69
            r0 = 11
            goto L8
        L69:
            r0 = 9
            goto L8
        L6c:
            android.app.ActivityManager$RecentTaskInfo r8 = (android.app.ActivityManager.RecentTaskInfo) r8
            android.content.Intent r0 = r8.baseIntent
            if (r0 == 0) goto L75
            r0 = 12
            goto L8
        L75:
            r0 = 9
            goto L8
        L78:
            com.facebook.ads.redexgen.X.JE r5 = com.facebook.ads.redexgen.X.JE.A08
            r0 = 3
            goto L8
        L7c:
            android.app.ActivityManager$RecentTaskInfo r8 = (android.app.ActivityManager.RecentTaskInfo) r8
            android.content.Intent r0 = r8.baseIntent
            java.util.Set r0 = r0.getCategories()
            if (r0 == 0) goto L89
            r0 = 13
            goto L8
        L89:
            r0 = 9
            goto L8
        L8d:
            android.app.ActivityManager$RecentTaskInfo r8 = (android.app.ActivityManager.RecentTaskInfo) r8
            android.content.Intent r0 = r8.baseIntent
            java.util.Set r3 = r0.getCategories()
            r2 = 47
            r1 = 32
            r0 = 125(0x7d, float:1.75E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto La9
            r0 = 14
            goto L8
        La9:
            r0 = 9
            goto L8
        Lad:
            com.facebook.ads.redexgen.X.JE r5 = com.facebook.ads.redexgen.X.JE.A05
            r0 = 3
            goto L8
        Lb2:
            r0 = 4
            goto L8
        Lb5:
            com.facebook.ads.redexgen.X.JE r5 = (com.facebook.ads.redexgen.X.JE) r5
            com.facebook.ads.redexgen.X.JE r5 = (com.facebook.ads.redexgen.X.JE) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JF.A02(android.content.Context):com.facebook.ads.redexgen.X.JE");
    }
}
