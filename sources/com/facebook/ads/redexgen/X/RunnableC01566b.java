package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.ads.redexgen.X.6b, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class RunnableC01566b implements Runnable {
    public static Comparator<C01556a> A04;
    public static byte[] A05;
    public static final ThreadLocal<RunnableC01566b> A06;
    public long A00;
    public long A01;
    public ArrayList<C01807a> A02 = new ArrayList<>();
    public ArrayList<C01556a> A03 = new ArrayList<>();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.RunnableC01566b.A05
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
            r0 = r0 ^ 59
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RunnableC01566b.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A05 = new byte[]{52, 48, 70, 54, 20, 3, 0, 3, 18, 5, 14, 124, 120, 14, 96, 75, 93, 90, 75, 74, 14, 126, 92, 75, 72, 75, 90, 77, 70};
    }

    static {
        A03();
        A06 = new ThreadLocal<>();
        A04 = new Comparator<C01556a>() { // from class: com.facebook.ads.redexgen.X.6X
            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Code restructure failed: missing block: B:100:0x0090, code lost:            return r2;     */
            @Override // java.util.Comparator
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final int compare(com.facebook.ads.redexgen.X.C01556a r9, com.facebook.ads.redexgen.X.C01556a r10) {
                /*
                    Method dump skipped, instructions count: 186
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6X.compare(com.facebook.ads.redexgen.X.6a, com.facebook.ads.redexgen.X.6a):int");
            }
        };
    }

    private C7Z A00(C01807a c01807a, int i, long j) {
        C7Z c7z = null;
        C7O c7o = null;
        char c = A08(c01807a, i) ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    c7z = null;
                    c = 3;
                    continue;
                case 3:
                    return c7z;
                case 4:
                    c01807a = c01807a;
                    c7o = c01807a.A0r;
                    c = 5;
                    continue;
                case 5:
                    c01807a = c01807a;
                    c01807a.A1A();
                    c7z = c7o.A0I(i, false, j);
                    if (c7z == null) {
                        break;
                    } else {
                        c = c7z.A0a() ? '\n' : (char) 14;
                    }
                case '\n':
                    c7z = c7z;
                    if (c7z.A0b()) {
                        c = 14;
                        continue;
                    } else {
                        c = '\f';
                    }
                case '\f':
                    c7z = c7z;
                    c7o.A0X(c7z.A0H);
                    break;
                case 14:
                    try {
                        c7z = c7z;
                        c7o = c7o;
                        c7o.A0d(c7z, false);
                        break;
                    } catch (Throwable th) {
                        c01807a.A1f(false);
                        throw th;
                    }
            }
            c01807a.A1f(false);
            c = 3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x0105, code lost:            java.util.Collections.sort(r15.A03, com.facebook.ads.redexgen.X.RunnableC01566b.A04);     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x010e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02() {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RunnableC01566b.A02():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04(long r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            r1 = 0
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L17;
                case 4: goto L37;
                case 5: goto L29;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.6b r3 = (com.facebook.ads.redexgen.X.RunnableC01566b) r3
            java.util.ArrayList<com.facebook.ads.redexgen.X.6a> r0 = r3.A03
            int r0 = r0.size()
            if (r1 >= r0) goto L15
            r0 = 3
            goto L5
        L15:
            r0 = 4
            goto L5
        L17:
            com.facebook.ads.redexgen.X.6b r3 = (com.facebook.ads.redexgen.X.RunnableC01566b) r3
            java.util.ArrayList<com.facebook.ads.redexgen.X.6a> r0 = r3.A03
            java.lang.Object r2 = r0.get(r1)
            com.facebook.ads.redexgen.X.6a r2 = (com.facebook.ads.redexgen.X.C01556a) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            if (r0 != 0) goto L27
            r0 = 4
            goto L5
        L27:
            r0 = 5
            goto L5
        L29:
            com.facebook.ads.redexgen.X.6b r3 = (com.facebook.ads.redexgen.X.RunnableC01566b) r3
            com.facebook.ads.redexgen.X.6a r2 = (com.facebook.ads.redexgen.X.C01556a) r2
            r3.A06(r2, r5)
            r2.A00()
            int r1 = r1 + 1
            r0 = 2
            goto L5
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RunnableC01566b.A04(long):void");
    }

    private final void A05(long j) {
        A02();
        A04(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0064, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(com.facebook.ads.redexgen.X.C01556a r6, long r7) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r1 = 0
            boolean r0 = r6.A04
            if (r0 == 0) goto L61
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L39;
                case 4: goto L27;
                case 5: goto L1a;
                case 6: goto Ld;
                case 7: goto L4f;
                case 8: goto L64;
                case 9: goto L4c;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            boolean r0 = r3.A0b()
            if (r0 != 0) goto L17
            r0 = 7
            goto L9
        L17:
            r0 = 8
            goto L9
        L1a:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            boolean r0 = r3.A0a()
            if (r0 == 0) goto L24
            r0 = 6
            goto L9
        L24:
            r0 = 8
            goto L9
        L27:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.7a> r0 = r3.A09
            if (r0 == 0) goto L2f
            r0 = 5
            goto L9
        L2f:
            r0 = 8
            goto L9
        L32:
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r0 = 3
            goto L9
        L39:
            com.facebook.ads.redexgen.X.6b r4 = (com.facebook.ads.redexgen.X.RunnableC01566b) r4
            com.facebook.ads.redexgen.X.6a r6 = (com.facebook.ads.redexgen.X.C01556a) r6
            com.facebook.ads.redexgen.X.7a r3 = r6.A03
            int r0 = r6.A01
            com.facebook.ads.redexgen.X.7Z r3 = r4.A00(r3, r0, r1)
            if (r3 == 0) goto L49
            r0 = 4
            goto L9
        L49:
            r0 = 8
            goto L9
        L4c:
            r1 = r7
            r0 = 3
            goto L9
        L4f:
            com.facebook.ads.redexgen.X.6b r4 = (com.facebook.ads.redexgen.X.RunnableC01566b) r4
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.7a> r0 = r3.A09
            java.lang.Object r0 = r0.get()
            com.facebook.ads.redexgen.X.7a r0 = (com.facebook.ads.redexgen.X.C01807a) r0
            r4.A07(r0, r7)
            r0 = 8
            goto L9
        L61:
            r0 = 9
            goto L9
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RunnableC01566b.A06(com.facebook.ads.redexgen.X.6a, long):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0006. Please report as an issue. */
    private void A07(@Nullable C01807a c01807a, long j) {
        int i = 0;
        C6Z c6z = null;
        char c = c01807a == null ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    return;
                case 3:
                    c01807a = c01807a;
                    c = c01807a.A0C ? (char) 4 : (char) 6;
                case 4:
                    c01807a = c01807a;
                    c = c01807a.A01.A06() != 0 ? (char) 5 : (char) 6;
                case 5:
                    c01807a = c01807a;
                    c01807a.A1D();
                    c = 6;
                case 6:
                    c01807a = c01807a;
                    c6z = c01807a.A02;
                    c6z.A04(c01807a, true);
                    c = c6z.A00 != 0 ? (char) 7 : (char) 2;
                case 7:
                    C4H.A01(A01(11, 18, 21));
                    c01807a.A0s.A05(c01807a.A04);
                    i = 0;
                    c = '\r';
                case '\r':
                    try {
                        c6z = c6z;
                        c = i < c6z.A00 * 2 ? (char) 15 : (char) 19;
                    } catch (Throwable th) {
                        C4H.A00();
                        throw th;
                    }
                case 15:
                    c6z = c6z;
                    A00(c01807a, c6z.A03[i], j);
                    i += 2;
                    c = '\r';
                case 19:
                    C4H.A00();
                    c = 2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0041, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A08(com.facebook.ads.redexgen.X.C01807a r5, int r6) {
        /*
            r4 = 0
            r3 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6J r0 = r5.A01
            int r2 = r0.A06()
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L33;
                case 3: goto L1f;
                case 4: goto L13;
                case 5: goto L10;
                case 6: goto L41;
                case 7: goto L3a;
                case 8: goto L3e;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r3 = 1
            r0 = 6
            goto Lc
        L13:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            boolean r0 = r4.A0b()
            if (r0 != 0) goto L1d
            r0 = 5
            goto Lc
        L1d:
            r0 = 7
            goto Lc
        L1f:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            com.facebook.ads.redexgen.X.6J r0 = r5.A01
            android.view.View r0 = r0.A0A(r1)
            com.facebook.ads.redexgen.X.7Z r4 = com.facebook.ads.redexgen.X.C01807a.A05(r0)
            int r0 = r4.A03
            if (r0 != r6) goto L31
            r0 = 4
            goto Lc
        L31:
            r0 = 7
            goto Lc
        L33:
            if (r1 >= r2) goto L37
            r0 = 3
            goto Lc
        L37:
            r0 = 8
            goto Lc
        L3a:
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L3e:
            r3 = 0
            r0 = 6
            goto Lc
        L41:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RunnableC01566b.A08(com.facebook.ads.redexgen.X.7a, int):boolean");
    }

    public final void A09(C01807a c01807a) {
        this.A02.add(c01807a);
    }

    public final void A0A(C01807a c01807a) {
        this.A02.remove(c01807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:            r7.A02.A03(r8, r9);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0B(com.facebook.ads.redexgen.X.C01807a r7, int r8, int r9) {
        /*
            r6 = this;
            r5 = r6
            boolean r0 = r7.isAttachedToWindow()
            if (r0 == 0) goto L29
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1a;
                case 4: goto L2b;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.6b r5 = (com.facebook.ads.redexgen.X.RunnableC01566b) r5
            long r3 = r5.A01
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L18
            r0 = 3
            goto L8
        L18:
            r0 = 4
            goto L8
        L1a:
            com.facebook.ads.redexgen.X.6b r5 = (com.facebook.ads.redexgen.X.RunnableC01566b) r5
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            long r0 = r7.getNanoTime()
            r5.A01 = r0
            r7.post(r5)
            r0 = 4
            goto L8
        L29:
            r0 = 4
            goto L8
        L2b:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            com.facebook.ads.redexgen.X.6Z r0 = r7.A02
            r0.A03(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RunnableC01566b.A0B(com.facebook.ads.redexgen.X.7a, int, int):void");
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        RunnableC01566b runnableC01566b = this;
        int i = 0;
        int i2 = 0;
        C01807a view = null;
        long j = 0;
        int size = 2;
        while (true) {
            switch (size) {
                case 2:
                    C4H.A01(A01(0, 11, 93));
                    if (!runnableC01566b.A02.isEmpty()) {
                        size = 7;
                        break;
                    } else {
                        size = 27;
                        break;
                    }
                case 7:
                    runnableC01566b = runnableC01566b;
                    i = runnableC01566b.A02.size();
                    j = 0;
                    i2 = 0;
                    size = 10;
                    break;
                case 10:
                    if (i2 >= i) {
                        size = 20;
                        break;
                    } else {
                        size = 11;
                        break;
                    }
                case 11:
                    runnableC01566b = runnableC01566b;
                    view = runnableC01566b.A02.get(i2);
                    int size2 = view.getWindowVisibility();
                    if (size2 != 0) {
                        size = 19;
                        break;
                    } else {
                        size = 16;
                        break;
                    }
                case 16:
                    try {
                        view = view;
                        j = Math.max(view.getDrawingTime(), j);
                        size = 19;
                        break;
                    } catch (Throwable th) {
                        runnableC01566b.A01 = 0L;
                        C4H.A00();
                        throw th;
                    }
                case 19:
                    i2++;
                    size = 10;
                    break;
                case 20:
                    if (j != 0) {
                        size = 22;
                        break;
                    } else {
                        size = 21;
                        break;
                    }
                case 21:
                    runnableC01566b = runnableC01566b;
                    runnableC01566b.A01 = 0L;
                    C4H.A00();
                    size = 28;
                    break;
                case 22:
                    long latestFrameVsyncMs = TimeUnit.MILLISECONDS.toNanos(j);
                    runnableC01566b.A05(latestFrameVsyncMs + runnableC01566b.A00);
                    runnableC01566b.A01 = 0L;
                    C4H.A00();
                    size = 28;
                    break;
                case 27:
                    runnableC01566b = runnableC01566b;
                    runnableC01566b.A01 = 0L;
                    C4H.A00();
                    size = 28;
                    break;
                case 28:
                    return;
            }
        }
    }
}
