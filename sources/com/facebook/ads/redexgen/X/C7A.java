package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.7A, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C7A {

    @Nullable
    public static G3 A00;
    public static byte[] A01;
    public static final Set<String> A02;
    public static final Set<String> A03;
    public static final AtomicBoolean A04;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A09(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C7A.A01
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
            r0 = r0 ^ 104(0x68, float:1.46E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7A.A09(int, int, int):java.lang.String");
    }

    public static void A0B() {
        A01 = new byte[]{15, 73, 73, 6, 123, 14, Byte.MAX_VALUE, 103, 77, 108, 12, 81, 102, 11, 82, 80, 90, 85, 12, 86, 73, 78, 12, 107, 81, 77, 85, 3, 52, 15, 20, 33, 73, 60, 41, 21, 41, 17, 56, 66, 43, 78, 45, 45, 46, 31, 56, 11, 52, 9, 61, 51, 67, 23, 29, 42, 70, 113, 20, 22, 20, 5, 122, 45, 34, 22, 46, 40, 7, 42, 103, 56, 45, 25, 30, 40, 34, 53, 25, 4, 121, 37, 60, 43, 1, 113, 70, 114, 121, 104, 107, 115, 110, 119, 11, 3, 24, 26, 6, 11, 4, 15, 53, 7, 5, 14, 15, 53, 5, 4, 109, 70, 87, 84, 76, 81, 72, 74, 77, 68, 3, 65, 70, 69, 76, 81, 70, 3, 74, 77, 74, 87, 2, 82, 32, 40, 65, 100, 85, 36, 105, 92, 83, 116, 124, 121, 36, 98, 96, 100, 105, 97, 81, 85, 115, 106, 72, 95, 117, 81, 45, 26, 44, 113, 96, 19, 76, 107, 86, 74, 110, 83, 70, 77, 82, 78, 11, 119, 77, 70, 100, 72, 86, 82, 18, 73, 118, 72, 15, 89, 114, 83, 29, 42};
    }

    static {
        A0B();
        A02 = new HashSet();
        A03 = new HashSet();
        A02.add(A09(0, 29, 86));
        A03.add(A09(29, 29, 19));
        A03.add(A09(165, 29, 72));
        A03.add(A09(133, 29, 120));
        A03.add(A09(58, 29, 36));
        A04 = new AtomicBoolean();
    }

    public static C0483Iy A00(C0361Eb c0361Eb) {
        return A03(c0361Eb, true);
    }

    public static C0483Iy A01(C0361Eb c0361Eb) {
        return A02(c0361Eb, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0073, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C0483Iy A02(com.facebook.ads.redexgen.X.C0361Eb r6, boolean r7) {
        /*
            r5 = 0
            r4 = 0
            r3 = 0
            r0 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.Iy r1 = new com.facebook.ads.redexgen.X.Iy
            r1.<init>(r7)
            A0D(r6, r1)
            boolean r0 = A0F()
            if (r0 != 0) goto L6d
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L54;
                case 3: goto L49;
                case 4: goto L3b;
                case 5: goto L2e;
                case 6: goto L18;
                case 7: goto L62;
                case 8: goto L6f;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            java.util.Map r3 = (java.util.Map) r3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r2.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r3.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L2c
            r0 = 7
            goto L14
        L2c:
            r0 = 5
            goto L14
        L2e:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L38
            r0 = 6
            goto L14
        L38:
            r0 = 8
            goto L14
        L3b:
            java.util.Map r3 = com.facebook.ads.redexgen.X.JN.A02()
            java.util.Set r0 = r3.keySet()
            java.util.Iterator r2 = r0.iterator()
            r0 = 5
            goto L14
        L49:
            boolean r0 = com.facebook.ads.redexgen.X.JN.A04()
            if (r0 == 0) goto L51
            r0 = 4
            goto L14
        L51:
            r0 = 8
            goto L14
        L54:
            com.facebook.ads.redexgen.X.Iy r1 = (com.facebook.ads.redexgen.X.C0483Iy) r1
            java.util.Set<java.lang.String> r0 = com.facebook.ads.redexgen.X.C7A.A03
            r1.A0T(r0)
            java.util.Set<java.lang.String> r0 = com.facebook.ads.redexgen.X.C7A.A02
            r1.A0S(r0)
            r0 = 3
            goto L14
        L62:
            com.facebook.ads.redexgen.X.Iy r1 = (com.facebook.ads.redexgen.X.C0483Iy) r1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r4 = (java.lang.String) r4
            r1.A0I(r5, r4)
            r0 = 5
            goto L14
        L6d:
            r0 = 3
            goto L14
        L6f:
            com.facebook.ads.redexgen.X.Iy r1 = (com.facebook.ads.redexgen.X.C0483Iy) r1
            com.facebook.ads.redexgen.X.Iy r1 = (com.facebook.ads.redexgen.X.C0483Iy) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7A.A02(com.facebook.ads.redexgen.X.Eb, boolean):com.facebook.ads.redexgen.X.Iy");
    }

    public static C0483Iy A03(C0361Eb c0361Eb, boolean z) {
        C0483Iy c0483Iy = new C0483Iy(z);
        A0D(c0361Eb, c0483Iy);
        return c0483Iy;
    }

    public static FM A04(C0361Eb c0361Eb) {
        return A07(true, c0361Eb);
    }

    public static FM A05(C0361Eb c0361Eb) {
        return A06(true, c0361Eb);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006b, code lost:            return com.facebook.ads.redexgen.X.FL.A00().A01(r2.A00(r1.A09()).A03(r4).A04(com.facebook.ads.internal.api.BuildConfigApi.isDebug()).A05(), r5.A06(), com.facebook.ads.redexgen.X.KJ.A01());     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.FM A06(boolean r4, com.facebook.ads.redexgen.X.C0361Eb r5) {
        /*
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.FI r2 = new com.facebook.ads.redexgen.X.FI
            r2.<init>()
            com.facebook.ads.redexgen.X.FF r1 = A08(r5)
            boolean r0 = A0F()
            if (r0 != 0) goto L39
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L24;
                case 4: goto L2e;
                case 5: goto L3b;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.FI r2 = (com.facebook.ads.redexgen.X.FI) r2
            java.util.Set<java.lang.String> r0 = com.facebook.ads.redexgen.X.C7A.A03
            r2.A02(r0)
            java.util.Set<java.lang.String> r0 = com.facebook.ads.redexgen.X.C7A.A02
            r2.A01(r0)
            r0 = 3
            goto L12
        L24:
            boolean r0 = com.facebook.ads.redexgen.X.JN.A04()
            if (r0 == 0) goto L2c
            r0 = 4
            goto L12
        L2c:
            r0 = 5
            goto L12
        L2e:
            com.facebook.ads.redexgen.X.FF r1 = (com.facebook.ads.redexgen.X.FF) r1
            java.util.Map r0 = com.facebook.ads.redexgen.X.JN.A02()
            r1.A08(r0)
            r0 = 5
            goto L12
        L39:
            r0 = 3
            goto L12
        L3b:
            com.facebook.ads.redexgen.X.Eb r5 = (com.facebook.ads.redexgen.X.C0361Eb) r5
            com.facebook.ads.redexgen.X.FI r2 = (com.facebook.ads.redexgen.X.FI) r2
            com.facebook.ads.redexgen.X.FF r1 = (com.facebook.ads.redexgen.X.FF) r1
            com.facebook.ads.redexgen.X.FL r3 = com.facebook.ads.redexgen.X.FL.A00()
            com.facebook.ads.redexgen.X.F9 r0 = r1.A09()
            com.facebook.ads.redexgen.X.FI r0 = r2.A00(r0)
            com.facebook.ads.redexgen.X.FI r1 = r0.A03(r4)
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            com.facebook.ads.redexgen.X.FI r0 = r1.A04(r0)
            com.facebook.ads.redexgen.X.FH r2 = r0.A05()
            com.facebook.ads.redexgen.X.Kf r1 = r5.A06()
            java.util.concurrent.Executor r0 = com.facebook.ads.redexgen.X.KJ.A01()
            com.facebook.ads.redexgen.X.FM r0 = r3.A01(r2, r1, r0)
            com.facebook.ads.redexgen.X.FM r0 = (com.facebook.ads.redexgen.X.FM) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7A.A06(boolean, com.facebook.ads.redexgen.X.Eb):com.facebook.ads.redexgen.X.FM");
    }

    public static FM A07(boolean z, C0361Eb c0361Eb) {
        return FL.A00().A01(new FI().A03(z).A00(A08(c0361Eb).A09()).A04(BuildConfigApi.isDebug()).A05(), c0361Eb.A06(), KJ.A01());
    }

    public static FF A08(C0361Eb c0361Eb) {
        A0C(c0361Eb);
        FF ff = new FF();
        if (A0F()) {
            ff.A02(360000).A04(120000);
        } else {
            ff.A02(C0413Gc.A05(c0361Eb));
        }
        ff.A03(C0413Gc.A06(c0361Eb)).A04(C0413Gc.A07(c0361Eb)).A05(C0413Gc.A08(c0361Eb)).A06(C0413Gc.A09(c0361Eb));
        synchronized (C7A.class) {
            if (A00 != null && (A00 instanceof G4)) {
                ff.A07((G4) A00);
            }
        }
        return ff;
    }

    public static void A0A() {
        A04.set(true);
    }

    public static void A0C(C0361Eb c0361Eb) {
        if (!A04.get()) {
            c0361Eb.A06().A5W(A09(87, 7, 116), C0512Kc.A1S, new C0514Ke(A09(110, 23, 75)));
        }
    }

    public static void A0D(C0361Eb c0361Eb, C0483Iy c0483Iy) {
        A0C(c0361Eb);
        if (A0F()) {
            c0483Iy.A0N(360000);
            c0483Iy.A0P(120000);
        } else {
            c0483Iy.A0N(30000);
        }
        c0483Iy.A0O(3);
        synchronized (C7A.class) {
            if (A00 != null) {
                c0483Iy.A0Q(A00);
            }
        }
    }

    public static synchronized void A0E(G3 g3) {
        synchronized (C7A.class) {
            A00 = g3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002e, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0F() {
        /*
            r4 = 0
            r0 = 0
            java.lang.String r3 = com.facebook.ads.internal.settings.AdInternalSettings.getUrlPrefix()
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L2c
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L29;
                case 4: goto L2e;
                case 5: goto L26;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            java.lang.String r3 = (java.lang.String) r3
            r2 = 162(0xa2, float:2.27E-43)
            r1 = 3
            r0 = 106(0x6a, float:1.49E-43)
            java.lang.String r0 = A09(r2, r1, r0)
            boolean r0 = r3.endsWith(r0)
            if (r0 == 0) goto L24
            r0 = 3
            goto Ld
        L24:
            r0 = 5
            goto Ld
        L26:
            r4 = 0
            r0 = 4
            goto Ld
        L29:
            r4 = 1
            r0 = 4
            goto Ld
        L2c:
            r0 = 5
            goto Ld
        L2e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7A.A0F():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0G(com.facebook.ads.redexgen.X.C0361Eb r6) {
        /*
            r0 = 0
            r0 = 0
            r5 = 1
            r4 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 17
            if (r1 >= r0) goto L49
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L4b;
                case 4: goto L29;
                case 5: goto L2c;
                case 6: goto L46;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.Eb r6 = (com.facebook.ads.redexgen.X.C0361Eb) r6
            r4 = 0
            android.content.ContentResolver r3 = r6.getContentResolver()
            r2 = 94
            r1 = 16
            r0 = 2
            java.lang.String r0 = A09(r2, r1, r0)
            int r0 = android.provider.Settings.System.getInt(r3, r0, r4)
            if (r0 == 0) goto L27
            r0 = 3
            goto Lb
        L27:
            r0 = 4
            goto Lb
        L29:
            r5 = r4
            r0 = 3
            goto Lb
        L2c:
            com.facebook.ads.redexgen.X.Eb r6 = (com.facebook.ads.redexgen.X.C0361Eb) r6
            r4 = 0
            android.content.ContentResolver r3 = r6.getContentResolver()
            r2 = 94
            r1 = 16
            r0 = 2
            java.lang.String r0 = A09(r2, r1, r0)
            int r0 = android.provider.Settings.Global.getInt(r3, r0, r4)
            if (r0 != 0) goto L44
            r0 = 6
            goto Lb
        L44:
            r0 = 3
            goto Lb
        L46:
            r5 = r4
            r0 = 3
            goto Lb
        L49:
            r0 = 5
            goto Lb
        L4b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7A.A0G(com.facebook.ads.redexgen.X.Eb):boolean");
    }
}
