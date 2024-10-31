package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ads.internal.api.BuildConfigApi;

/* loaded from: assets/audience_network.dex */
public final class K5 {
    public static byte[] A0I;
    public static final String A0J;

    @Nullable
    public View A0F;

    @Nullable
    public View A0G;
    public boolean A0H;
    public int A04 = -1;
    public int A05 = -1;
    public int A06 = -1;
    public int A03 = -1;
    public long A0C = -1;
    public int A09 = -1;
    public long A0E = -1;
    public long A0D = -1;
    public int A0A = -1;
    public int A0B = -1;
    public int A07 = -1;
    public int A08 = -1;
    public float A00 = -1.0f;
    public float A02 = -1.0f;
    public float A01 = -1.0f;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.K5.A0I
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
            r0 = r0 ^ 42
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K5.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A0I = new byte[]{81, 93, 126, 123, 79, 112, 108, 118, 107, 118, 112, 113, 71, 58, 36, 41, 57, 37, 81, 66, 71, 74, 86, 80, 122, 38, 41, 44, 38, 46, 28, 0, 9, 20, 5, 3, 94, 81, 84, 94, 86, 121, 88, 81, 92, 68, 105, 84, 80, 88, Byte.MAX_VALUE, 101, 85, 122, Byte.MAX_VALUE, 117, 125, 81, 99, 119, 100, 114, 83, 120, 119, 116, 122, 115, 114, 44, 54, 108, 107, 126, 109, 107, 70, 5, 22, 19, 30, 2, 4, 47, 26, 23, 27, 21, 26, 6, 35, 38, 18, 45, 49, 43, 54, 43, 45, 44, 27, 112, 103, 97, 109, 112, 102, 107, 108, 101, 34, 107, 111, 114, 112, 103, 113, 113, 107, 109, 108, 56, 34, 58, 49, 59, 11, 54, 50, 58, 114, 117, 96, 115, 117, 85, 104, 108, 100, 110, 97, 100, 110, 102, 104, 105, 91, 100, 104, 122, 89, 108, 106, 73, 70, 67, 73, 65, 114, 67, 72, 66, Byte.MAX_VALUE, 105, 101, 38, 41, 44, 38, 46, 34, 48, 36, 55, 33, 17, 44, 40, 32, Byte.MAX_VALUE, 101, 62, 53, 63, 3, 15, 8, 29, 14, 8, 36};
    }

    static {
        A02();
        A0J = K5.class.getSimpleName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x006c, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.EnumC0489Je A00() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            android.view.View r0 = r4.A0G
            if (r0 == 0) goto L66
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L45;
                case 3: goto L1c;
                case 4: goto L68;
                case 5: goto L10;
                case 6: goto Lc;
                case 7: goto L4f;
                case 8: goto L5a;
                case 9: goto L2c;
                case 10: goto L5e;
                case 11: goto L20;
                case 12: goto L62;
                case 13: goto L3e;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Je r2 = com.facebook.ads.redexgen.X.EnumC0489Je.A0G
            r0 = 4
            goto L8
        L10:
            com.facebook.ads.redexgen.X.K5 r4 = (com.facebook.ads.redexgen.X.K5) r4
            android.view.View r1 = r4.A0G
            android.view.View r0 = r4.A0F
            if (r1 == r0) goto L1a
            r0 = 6
            goto L8
        L1a:
            r0 = 7
            goto L8
        L1c:
            com.facebook.ads.redexgen.X.Je r2 = com.facebook.ads.redexgen.X.EnumC0489Je.A0I
            r0 = 4
            goto L8
        L20:
            java.lang.Object r3 = (java.lang.Object) r3
            boolean r0 = r3 instanceof com.facebook.ads.redexgen.X.EnumC0489Je
            if (r0 != 0) goto L29
            r0 = 12
            goto L8
        L29:
            r0 = 13
            goto L8
        L2c:
            com.facebook.ads.redexgen.X.K5 r4 = (com.facebook.ads.redexgen.X.K5) r4
            android.view.View r1 = r4.A0G
            int r0 = com.facebook.ads.redexgen.X.EnumC0489Je.A02
            java.lang.Object r3 = r1.getTag(r0)
            if (r3 != 0) goto L3b
            r0 = 10
            goto L8
        L3b:
            r0 = 11
            goto L8
        L3e:
            java.lang.Object r3 = (java.lang.Object) r3
            r2 = r3
            com.facebook.ads.redexgen.X.Je r2 = (com.facebook.ads.redexgen.X.EnumC0489Je) r2
            r0 = 4
            goto L8
        L45:
            com.facebook.ads.redexgen.X.K5 r4 = (com.facebook.ads.redexgen.X.K5) r4
            android.view.View r0 = r4.A0F
            if (r0 != 0) goto L4d
            r0 = 3
            goto L8
        L4d:
            r0 = 5
            goto L8
        L4f:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 4
            if (r1 >= r0) goto L57
            r0 = 8
            goto L8
        L57:
            r0 = 9
            goto L8
        L5a:
            com.facebook.ads.redexgen.X.Je r2 = com.facebook.ads.redexgen.X.EnumC0489Je.A0F
            r0 = 4
            goto L8
        L5e:
            com.facebook.ads.redexgen.X.Je r2 = com.facebook.ads.redexgen.X.EnumC0489Je.A0H
            r0 = 4
            goto L8
        L62:
            com.facebook.ads.redexgen.X.Je r2 = com.facebook.ads.redexgen.X.EnumC0489Je.A0J
            r0 = 4
            goto L8
        L66:
            r0 = 3
            goto L8
        L68:
            com.facebook.ads.redexgen.X.Je r2 = (com.facebook.ads.redexgen.X.EnumC0489Je) r2
            com.facebook.ads.redexgen.X.Je r2 = (com.facebook.ads.redexgen.X.EnumC0489Je) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K5.A00():com.facebook.ads.redexgen.X.Je");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long A03() {
        /*
            r5 = this;
            r4 = r5
            r2 = 0
            boolean r0 = r4.A07()
            if (r0 == 0) goto L1d
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1f;
                case 4: goto L19;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.K5 r4 = (com.facebook.ads.redexgen.X.K5) r4
            long r2 = java.lang.System.currentTimeMillis()
            long r0 = r4.A0C
            long r2 = r2 - r0
            r0 = 3
            goto La
        L19:
            r2 = -1
            r0 = 3
            goto La
        L1d:
            r0 = 4
            goto La
        L1f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K5.A03():long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0187, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, java.lang.String> A04() {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K5.A04():java.util.Map");
    }

    public final void A05() {
        if (BuildConfigApi.isDebug()) {
            String str = A01(101, 22, 40) + this.A0C;
        }
        this.A0C = System.currentTimeMillis();
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x01ac, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A06(android.view.MotionEvent r10, android.view.View r11, android.view.View r12) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K5.A06(android.view.MotionEvent, android.view.View, android.view.View):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A07() {
        /*
            r6 = this;
            r5 = 0
            long r3 = r6.A0C
            r1 = -1
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L14
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L16;
                case 4: goto L11;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r5 = 1
            r0 = 3
            goto La
        L11:
            r5 = 0
            r0 = 3
            goto La
        L14:
            r0 = 4
            goto La
        L16:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K5.A07():boolean");
    }

    public final boolean A08() {
        return this.A0H;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:            return r7;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A09(android.content.Context r9) {
        /*
            r8 = this;
            r7 = 0
            r0 = 0
            r0 = 0
            int r6 = com.facebook.ads.redexgen.X.C0413Gc.A04(r9)
            long r3 = r8.A03()
            if (r6 < 0) goto L6a
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L61;
                case 3: goto L5e;
                case 4: goto L13;
                case 5: goto L20;
                case 6: goto L6c;
                case 7: goto L1d;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L1b
            r0 = 5
            goto Lf
        L1b:
            r0 = 6
            goto Lf
        L1d:
            r7 = 0
            r0 = 4
            goto Lf
        L20:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r2 = 50
            r1 = 21
            r0 = 60
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.StringBuilder r5 = r0.append(r7)
            r2 = 163(0xa3, float:2.28E-43)
            r1 = 18
            r0 = 111(0x6f, float:1.56E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.StringBuilder r5 = r0.append(r6)
            r2 = 0
            r1 = 2
            r0 = 87
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.StringBuilder r0 = r0.append(r3)
            r0.toString()
            r0 = 6
            goto Lf
        L5e:
            r7 = 1
            r0 = 4
            goto Lf
        L61:
            long r1 = (long) r6
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L68
            r0 = 3
            goto Lf
        L68:
            r0 = 7
            goto Lf
        L6a:
            r0 = 7
            goto Lf
        L6c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K5.A09(android.content.Context):boolean");
    }
}
