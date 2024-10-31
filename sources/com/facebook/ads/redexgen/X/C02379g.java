package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.9g, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02379g {
    public static byte[] A00;
    public static final AtomicReference<C02359e> A01;
    public static final AtomicReference<String> A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C02379g.A00
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
            r0 = r0 ^ 19
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02379g.A04(int, int, int):java.lang.String");
    }

    public static void A05() {
        A00 = new byte[]{89, 84, 86, 81, 111, 95, 70, 85, 66, 66, 89, 84, 85, 101, 103, 108, 103, 112, 107, 97, 119, Byte.MAX_VALUE, 114, 73, 121, 96, 115, 100, 100, Byte.MAX_VALUE, 114, 115};
    }

    static {
        A05();
        A01 = new AtomicReference<>();
        A02 = new AtomicReference<>(A04(0, 0, 125));
    }

    public static C02359e A00() {
        C02359e advertisingIdInfo = A01.get();
        if (advertisingIdInfo == null) {
            return C02359e.A00();
        }
        return advertisingIdInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:            return r5;     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C02359e A01(com.facebook.ads.redexgen.X.C0361Eb r4, com.facebook.ads.redexgen.X.C02359e r5) {
        /*
            if (r5 == 0) goto L38
            r0 = 2
        L3:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L6;
                case 8: goto L3a;
                default: goto L6;
            }
        L6:
            goto L3
        L7:
            com.facebook.ads.redexgen.X.Eb r4 = (com.facebook.ads.redexgen.X.C0361Eb) r4     // Catch: java.lang.Throwable -> L21
            com.facebook.ads.redexgen.X.9e r5 = com.facebook.ads.redexgen.X.C02429m.A00(r4)     // Catch: java.lang.Throwable -> L21
            r0 = 8
            goto L3
        L10:
            com.facebook.ads.redexgen.X.9e r5 = (com.facebook.ads.redexgen.X.C02359e) r5     // Catch: java.lang.Throwable -> L21
            java.lang.String r0 = r5.A03()     // Catch: java.lang.Throwable -> L21
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L1e
            r0 = 5
            goto L3
        L1e:
            r0 = 8
            goto L3
        L21:
            r3 = move-exception
            r2 = 13
            r1 = 7
            r0 = 17
            java.lang.String r2 = A04(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A12
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r3)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r4, r2, r1, r0)
            r0 = 8
            goto L3
        L38:
            r0 = 5
            goto L3
        L3a:
            com.facebook.ads.redexgen.X.9e r5 = (com.facebook.ads.redexgen.X.C02359e) r5
            com.facebook.ads.redexgen.X.9e r5 = (com.facebook.ads.redexgen.X.C02359e) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02379g.A01(com.facebook.ads.redexgen.X.Eb, com.facebook.ads.redexgen.X.9e):com.facebook.ads.redexgen.X.9e");
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x00ab, code lost:            return r6;     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C02359e A02(com.facebook.ads.redexgen.X.C0361Eb r5, com.facebook.ads.redexgen.X.C02359e r6, com.facebook.ads.redexgen.X.C02369f r7) {
        /*
            r0 = 0
            r4 = 0
            r0 = 2
        L3:
            switch(r0) {
                case 2: goto L20;
                case 3: goto L6;
                case 4: goto L72;
                case 5: goto L7b;
                case 6: goto L6;
                case 7: goto L6;
                case 8: goto L57;
                case 9: goto L6;
                case 10: goto L6;
                case 11: goto L6;
                case 12: goto L41;
                case 13: goto L37;
                case 14: goto Lf;
                case 15: goto L2d;
                case 16: goto L7;
                case 17: goto L49;
                case 18: goto L64;
                case 19: goto La7;
                default: goto L6;
            }
        L6:
            goto L3
        L7:
            if (r4 == 0) goto Lc
            r0 = 17
            goto L3
        Lc:
            r0 = 19
            goto L3
        Lf:
            com.facebook.ads.redexgen.X.9f r7 = (com.facebook.ads.redexgen.X.C02369f) r7
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r1 = com.facebook.ads.redexgen.X.C02379g.A02
            java.lang.String r0 = r4.A01
            r1.set(r0)
            java.lang.String r0 = r4.A01
            r7.A05(r0)
            r0 = 15
            goto L3
        L20:
            com.facebook.ads.redexgen.X.Eb r5 = (com.facebook.ads.redexgen.X.C0361Eb) r5     // Catch: java.lang.Throwable -> L8f
            boolean r0 = com.facebook.ads.redexgen.X.C0412Gb.A06(r5)     // Catch: java.lang.Throwable -> L8f
            if (r0 == 0) goto L2a
            r0 = 4
            goto L3
        L2a:
            r0 = 12
            goto L3
        L2d:
            com.facebook.ads.redexgen.X.9e r6 = (com.facebook.ads.redexgen.X.C02359e) r6
            if (r6 != 0) goto L34
            r0 = 16
            goto L3
        L34:
            r0 = 19
            goto L3
        L37:
            java.lang.String r0 = r4.A01
            if (r0 == 0) goto L3e
            r0 = 14
            goto L3
        L3e:
            r0 = 15
            goto L3
        L41:
            if (r4 == 0) goto L46
            r0 = 13
            goto L3
        L46:
            r0 = 15
            goto L3
        L49:
            java.lang.String r0 = r4.A00
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L54
            r0 = 18
            goto L3
        L54:
            r0 = 19
            goto L3
        L57:
            com.facebook.ads.redexgen.X.Eb r5 = (com.facebook.ads.redexgen.X.C0361Eb) r5     // Catch: java.lang.Throwable -> L8f
            android.content.ContentResolver r0 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L8f
            com.facebook.ads.redexgen.X.9h r4 = com.facebook.ads.redexgen.X.C02399i.A00(r0)     // Catch: java.lang.Throwable -> L8f
            r0 = 12
            goto L3
        L64:
            com.facebook.ads.redexgen.X.9e r6 = new com.facebook.ads.redexgen.X.9e
            java.lang.String r2 = r4.A00
            boolean r1 = r4.A02
            com.facebook.ads.redexgen.X.9d r0 = com.facebook.ads.redexgen.X.EnumC02349d.A04
            r6.<init>(r2, r1, r0)
            r0 = 19
            goto L3
        L72:
            com.facebook.ads.redexgen.X.9e r6 = (com.facebook.ads.redexgen.X.C02359e) r6
            if (r6 == 0) goto L78
            r0 = 5
            goto L3
        L78:
            r0 = 8
            goto L3
        L7b:
            com.facebook.ads.redexgen.X.9e r6 = (com.facebook.ads.redexgen.X.C02359e) r6     // Catch: java.lang.Throwable -> L8f
            java.lang.String r0 = r6.A03()     // Catch: java.lang.Throwable -> L8f
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L8f
            if (r0 == 0) goto L8b
            r0 = 8
            goto L3
        L8b:
            r0 = 12
            goto L3
        L8f:
            r3 = move-exception
            r2 = 13
            r1 = 7
            r0 = 17
            java.lang.String r2 = A04(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A14
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r3)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r5, r2, r1, r0)
            r0 = 12
            goto L3
        La7:
            com.facebook.ads.redexgen.X.9e r6 = (com.facebook.ads.redexgen.X.C02359e) r6
            com.facebook.ads.redexgen.X.9e r6 = (com.facebook.ads.redexgen.X.C02359e) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02379g.A02(com.facebook.ads.redexgen.X.Eb, com.facebook.ads.redexgen.X.9e, com.facebook.ads.redexgen.X.9f):com.facebook.ads.redexgen.X.9e");
    }

    public static String A03() {
        String attributionId = A02.get();
        if (attributionId == null) {
            return A04(0, 0, 125);
        }
        return attributionId;
    }

    public static void A06(C02369f c02369f) {
        A01.set(c02369f.A02());
        A02.set(c02369f.A03());
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A07(C0361Eb c0361Eb) {
        long j;
        C02359e upToDateAdInfo;
        try {
            C02369f attributionStorage = new C02369f(c0361Eb);
            A06(attributionStorage);
            if (!A08()) {
                C02359e c02359e = A01.get();
                if (c02359e != null && !TextUtils.isEmpty(c02359e.A03())) {
                    j = c02359e.A01();
                } else {
                    j = -1;
                }
                if (j <= 0 || System.currentTimeMillis() - j >= C0412Gb.A00(c0361Eb)) {
                    if (C0412Gb.A07(c0361Eb)) {
                        upToDateAdInfo = A01(c0361Eb, A02(c0361Eb, null, attributionStorage));
                    } else {
                        upToDateAdInfo = A02(c0361Eb, A01(c0361Eb, null), attributionStorage);
                    }
                    if (upToDateAdInfo != null && !TextUtils.isEmpty(upToDateAdInfo.A03())) {
                        A01.set(upToDateAdInfo);
                        attributionStorage.A04(upToDateAdInfo);
                    }
                }
            }
        } catch (Throwable th) {
            C0511Kb.A06(c0361Eb, A04(13, 7, 17), C0512Kc.A13, new C0514Ke(th));
        }
    }

    public static boolean A08() {
        boolean z = false;
        boolean updated = JN.A04();
        if (updated) {
            boolean updated2 = JN.A05(A04(20, 12, 5));
            if (updated2) {
                A02.set(JN.A01(A04(20, 12, 5)));
                z = true;
            }
        }
        boolean updated3 = JN.A04();
        if (!updated3) {
            return z;
        }
        boolean updated4 = JN.A05(A04(0, 13, 35));
        if (updated4) {
            String A012 = JN.A01(A04(0, 13, 35));
            AtomicReference<C02359e> atomicReference = A01;
            if (A012 == null) {
                A012 = A04(0, 0, 125);
            }
            atomicReference.set(new C02359e(A012, false, EnumC02349d.A03));
            return true;
        }
        return z;
    }
}
