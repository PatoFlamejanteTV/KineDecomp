package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.4N, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C4N<E> implements Cloneable {
    public static byte[] A04;
    public static final Object A05;
    public int A00;
    public boolean A01;
    public long[] A02;
    public Object[] A03;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C4N.A04
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
            r0 = r0 ^ 10
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4N.A03(int, int, int):java.lang.String");
    }

    public static void A05() {
        A04 = new byte[]{18, 30, 70, 26, 6, 7, 29, 78, 35, 15, 30, 71, 45, 43};
    }

    static {
        A05();
        A05 = new Object();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public C4N() {
        this(10);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public C4N(int i) {
        this.A01 = false;
        if (i == 0) {
            this.A02 = C4M.A01;
            this.A03 = C4M.A02;
        } else {
            int A00 = C4M.A00(i);
            this.A02 = new long[A00];
            this.A03 = new Object[A00];
        }
        this.A00 = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    private final long A00(int i) {
        if (this.A01) {
            A04();
        }
        return this.A02[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C4N<E> clone() {
        C4N<E> c4n = null;
        try {
            c4n = (C4N) super.clone();
            c4n.A02 = (long[]) this.A02.clone();
            c4n.A03 = (Object[]) this.A03.clone();
            return c4n;
        } catch (CloneNotSupportedException unused) {
            return c4n;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:            return (E) ((java.lang.Object) r7);     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v0, types: [E] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final E A02(long r5, E r7) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            long[] r1 = r3.A02
            int r0 = r3.A00
            int r2 = com.facebook.ads.redexgen.X.C4M.A03(r1, r0, r5)
            if (r2 < 0) goto L27
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L29;
                case 4: goto L1f;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.4N r3 = (com.facebook.ads.redexgen.X.C4N) r3
            java.lang.Object[] r0 = r3.A03
            r1 = r0[r2]
            java.lang.Object r0 = com.facebook.ads.redexgen.X.C4N.A05
            if (r1 != r0) goto L1d
            r0 = 3
            goto Ld
        L1d:
            r0 = 4
            goto Ld
        L1f:
            com.facebook.ads.redexgen.X.4N r3 = (com.facebook.ads.redexgen.X.C4N) r3
            java.lang.Object[] r0 = r3.A03
            r7 = r0[r2]
            r0 = 3
            goto Ld
        L27:
            r0 = 3
            goto Ld
        L29:
            java.lang.Object r7 = (java.lang.Object) r7
            java.lang.Object r7 = (java.lang.Object) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4N.A02(long, java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0045, code lost:            r1 = r8;        r1.A01 = false;        r1.A00 = r5;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x004d, code lost:            return;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04() {
        /*
            r8 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r7 = 0
            int r6 = r8.A00
            r5 = 0
            long[] r4 = r8.A02
            java.lang.Object[] r3 = r8.A03
            r2 = 0
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L3a;
                case 3: goto L2e;
                case 4: goto L13;
                case 5: goto L19;
                case 6: goto L2a;
                case 7: goto L41;
                case 8: goto L45;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            if (r2 == r5) goto L17
            r0 = 5
            goto Lf
        L17:
            r0 = 6
            goto Lf
        L19:
            long[] r4 = (long[]) r4
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            java.lang.Object r7 = (java.lang.Object) r7
            r0 = r4[r2]
            r4[r5] = r0
            r3[r5] = r7
            r0 = 0
            r3[r2] = r0
            r0 = 6
            goto Lf
        L2a:
            int r5 = r5 + 1
            r0 = 7
            goto Lf
        L2e:
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r7 = r3[r2]
            java.lang.Object r0 = com.facebook.ads.redexgen.X.C4N.A05
            if (r7 == r0) goto L38
            r0 = 4
            goto Lf
        L38:
            r0 = 7
            goto Lf
        L3a:
            if (r2 >= r6) goto L3e
            r0 = 3
            goto Lf
        L3e:
            r0 = 8
            goto Lf
        L41:
            int r2 = r2 + 1
            r0 = 2
            goto Lf
        L45:
            r1 = r8
            com.facebook.ads.redexgen.X.4N r1 = (com.facebook.ads.redexgen.X.C4N) r1
            r0 = 0
            r1.A01 = r0
            r1.A00 = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4N.A04():void");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final int A06() {
        if (this.A01) {
            A04();
        }
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final E A07(int i) {
        if (this.A01) {
            A04();
        }
        return (E) this.A03[i];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final E A08(long j) {
        return A02(j, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:            r1 = r4;        r1.A00 = 0;        r1.A01 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:            return;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A09() {
        /*
            r4 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            int r3 = r4.A00
            java.lang.Object[] r2 = r4.A03
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L1e;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r1 >= r3) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 4
            goto Lb
        L15:
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r0 = 0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L1e:
            r1 = r4
            com.facebook.ads.redexgen.X.4N r1 = (com.facebook.ads.redexgen.X.C4N) r1
            r0 = 0
            r1.A00 = r0
            r1.A01 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4N.A09():void");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final void A0A(int i) {
        if (this.A03[i] != A05) {
            this.A03[i] = A05;
            this.A01 = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f1, code lost:            return;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0B(long r9, E r11) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4N.A0B(long, java.lang.Object):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:            return r7;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4N != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            r8 = this;
            r5 = r8
            r4 = 0
            r3 = 0
            r6 = 0
            r7 = 0
            int r0 = r5.A06()
            if (r0 > 0) goto L9a
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L53;
                case 3: goto L9d;
                case 4: goto L17;
                case 5: goto L3b;
                case 6: goto L10;
                case 7: goto L5e;
                case 8: goto L72;
                case 9: goto L8f;
                case 10: goto L6e;
                case 11: goto L2a;
                case 12: goto L46;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            if (r3 <= 0) goto L14
            r0 = 7
            goto Lc
        L14:
            r0 = 8
            goto Lc
        L17:
            com.facebook.ads.redexgen.X.4N r5 = (com.facebook.ads.redexgen.X.C4N) r5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r0 = r5.A00
            int r0 = r0 * 28
            r4.<init>(r0)
            r0 = 123(0x7b, float:1.72E-43)
            r4.append(r0)
            r3 = 0
            r0 = 5
            goto Lc
        L2a:
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            r2 = 2
            r1 = 10
            r0 = 100
            java.lang.String r0 = A03(r2, r1, r0)
            r4.append(r0)
            r0 = 10
            goto Lc
        L3b:
            com.facebook.ads.redexgen.X.4N r5 = (com.facebook.ads.redexgen.X.C4N) r5
            int r0 = r5.A00
            if (r3 >= r0) goto L43
            r0 = 6
            goto Lc
        L43:
            r0 = 12
            goto Lc
        L46:
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            r0 = 125(0x7d, float:1.75E-43)
            r4.append(r0)
            java.lang.String r7 = r4.toString()
            r0 = 3
            goto Lc
        L53:
            r2 = 12
            r1 = 2
            r0 = 92
            java.lang.String r7 = A03(r2, r1, r0)
            r0 = 3
            goto Lc
        L5e:
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            r2 = 0
            r1 = 2
            r0 = 52
            java.lang.String r0 = A03(r2, r1, r0)
            r4.append(r0)
            r0 = 8
            goto Lc
        L6e:
            int r3 = r3 + 1
            r0 = 5
            goto Lc
        L72:
            com.facebook.ads.redexgen.X.4N r5 = (com.facebook.ads.redexgen.X.C4N) r5
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            long r0 = r5.A00(r3)
            r4.append(r0)
            r0 = 61
            r4.append(r0)
            java.lang.Object r6 = r5.A07(r3)
            if (r6 == r5) goto L8b
            r0 = 9
            goto Lc
        L8b:
            r0 = 11
            goto Lc
        L8f:
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            java.lang.Object r6 = (java.lang.Object) r6
            r4.append(r6)
            r0 = 10
            goto Lc
        L9a:
            r0 = 4
            goto Lc
        L9d:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = (java.lang.String) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4N.toString():java.lang.String");
    }
}
