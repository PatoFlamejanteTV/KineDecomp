package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: assets/audience_network.dex */
public final class EV {
    public static AnonymousClass02 A09;
    public static byte[] A0A;
    public static final String A0B;
    public static final Map<String, AnonymousClass08> A0C;
    public long A00;
    public C0432Gv A01;
    public final EW A03;
    public final C0361Eb A04;
    public final boolean A08;
    public final Map<String, Bitmap> A07 = Collections.synchronizedMap(new HashMap());
    public final Handler A02 = new Handler(Looper.getMainLooper());
    public final List<Callable<Boolean>> A05 = new ArrayList();
    public final List<Callable<Boolean>> A06 = new ArrayList();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A08(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EV.A0A
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
            int r0 = r0 + (-111)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EV.A08(int, int, int):java.lang.String");
    }

    public static void A0D() {
        A0A = new byte[]{-41, -43, 9, -43, 5, -38, -35, -35, -76, -46, -44, -39, -42, -111, -28, -27, -46, -29, -27, -42, -43, -97, 41, 44, 30, 33, 28, 49, 38, 42, 34, 28, 42, 48, -17, 13, 15, 20, 21, 26, 19, -52, 18, 13, 21, 24, 17, 16, -5, -7, -5, 0, -3, -37, 7, 5, 8, 4, -3, 12, 1, 7, 6, -32, 7, 7, 3, -60, -9, -30, -28, -17, -13, -24, -18, -19, -97, -10, -25, -24, -21, -28, -97, -28, -9, -28, -30, -12, -13, -24, -19, -26, -97, -30, -32, -30, -25, -28, -97, -29, -18, -10, -19, -21, -18, -32, -29, -14, -83, -29, -26, 19, -25, 19, -30, 21, -27, 21, 10, 17, 25, 8, 6, 8, 13, 10, -21, 6, 14, 17, 26, 23, 10, -19, 20, 20, 16, -17, 13, 15, 20, 21, 26, 19, -52, 31, 32, 13, 30, 32, 17, 16, -38, -38, -38, 57, 76, 57, 55, 73, 72, 57, 5, 8, -6, -3, 17, 63, 13, 15, 65, 19, 19, 16, -72, -42, -40, -35, -34, -29, -36, -107, -40, -28, -30, -27, -31, -38, -23, -38};
    }

    static {
        A0D();
        A0B = EV.class.getSimpleName();
        A0C = Collections.synchronizedMap(new HashMap());
    }

    public EV(C0361Eb c0361Eb) {
        this.A04 = c0361Eb;
        this.A03 = EW.A06(c0361Eb.A00());
        this.A08 = C0413Gc.A1E(c0361Eb);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.09] */
    public static AnonymousClass02 A02(C0365Ef c0365Ef) {
        if (A09 == null) {
            A09 = AnonymousClass03.A00(c0365Ef, new Object() { // from class: com.facebook.ads.redexgen.X.09
                public int A00;
                public int A01;
                public boolean A02;
                public boolean A03;
                public boolean A04;

                public final AnonymousClass09 A00(int i) {
                    this.A00 = i;
                    return this;
                }

                public final AnonymousClass09 A01(int i) {
                    this.A01 = i;
                    return this;
                }

                public final AnonymousClass09 A02(boolean z) {
                    this.A02 = z;
                    return this;
                }

                public final AnonymousClass09 A03(boolean z) {
                    this.A03 = z;
                    return this;
                }

                public final AnonymousClass09 A04(boolean z) {
                    this.A04 = z;
                    return this;
                }

                public final C0A A05() {
                    return new C0A(this.A00, this.A02, this.A01, this.A03, this.A04);
                }
            }.A00(C0414Gd.A0F(c0365Ef)).A02(c0365Ef.A03().A5A()).A01(-1).A03(C0413Gc.A0V(c0365Ef)).A04(C0413Gc.A1J(c0365Ef)).A05(), A05(c0365Ef));
        }
        return A09;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.AnonymousClass08 A04(com.facebook.ads.redexgen.X.C0361Eb r3, java.lang.String r4) {
        /*
            r0 = 0
            r2 = 0
            java.util.Map<java.lang.String, com.facebook.ads.redexgen.X.08> r0 = com.facebook.ads.redexgen.X.EV.A0C
            java.lang.Object r1 = r0.get(r4)
            com.facebook.ads.redexgen.X.08 r1 = (com.facebook.ads.redexgen.X.AnonymousClass08) r1
            boolean r0 = com.facebook.ads.redexgen.X.EY.A06(r3)
            if (r0 == 0) goto L2f
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L15;
                case 3: goto L1d;
                case 4: goto L31;
                case 5: goto L26;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            com.facebook.ads.redexgen.X.08 r1 = (com.facebook.ads.redexgen.X.AnonymousClass08) r1
            if (r1 == 0) goto L1b
            r0 = 3
            goto L11
        L1b:
            r0 = 5
            goto L11
        L1d:
            com.facebook.ads.redexgen.X.08 r1 = (com.facebook.ads.redexgen.X.AnonymousClass08) r1
            com.facebook.ads.redexgen.X.08 r2 = new com.facebook.ads.redexgen.X.08
            r2.<init>(r1)
            r0 = 4
            goto L11
        L26:
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.08 r2 = new com.facebook.ads.redexgen.X.08
            r2.<init>(r4)
            r0 = 4
            goto L11
        L2f:
            r0 = 5
            goto L11
        L31:
            com.facebook.ads.redexgen.X.08 r2 = (com.facebook.ads.redexgen.X.AnonymousClass08) r2
            com.facebook.ads.redexgen.X.08 r2 = (com.facebook.ads.redexgen.X.AnonymousClass08) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EV.A04(com.facebook.ads.redexgen.X.Eb, java.lang.String):com.facebook.ads.redexgen.X.08");
    }

    public static C0X A05(C0365Ef c0365Ef) {
        return new EO(c0365Ef);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0019. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0089 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.concurrent.atomic.AtomicBoolean A0B(java.util.ArrayList<java.util.concurrent.Callable<java.lang.Boolean>> r13) {
        /*
            r12 = 0
            r0 = 0
            r5 = 0
            r0 = 0
            r0 = 0
            r11 = 0
            r0 = 0
            r10 = 0
            r9 = 0
            r8 = 1
            r0 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            int r0 = r13.size()
            r7.<init>(r0)
            java.util.Iterator r6 = r13.iterator()
            r0 = 2
        L19:
            switch(r0) {
                case 2: goto L50;
                case 3: goto L63;
                case 4: goto L5c;
                case 5: goto L7a;
                case 6: goto L1c;
                case 7: goto L1c;
                case 8: goto L1c;
                case 9: goto L23;
                case 10: goto L1c;
                case 11: goto L1c;
                case 12: goto L1c;
                case 13: goto L38;
                case 14: goto L1c;
                case 15: goto L1c;
                case 16: goto L1c;
                case 17: goto L94;
                case 18: goto L4c;
                case 19: goto L1d;
                case 20: goto L1c;
                case 21: goto L1c;
                case 22: goto L98;
                case 23: goto Lb3;
                default: goto L1c;
            }
        L1c:
            goto L19
        L1d:
            java.util.concurrent.atomic.AtomicBoolean r9 = (java.util.concurrent.atomic.AtomicBoolean) r9     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            r9.set(r5)     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            goto L80
        L23:
            java.util.Iterator r11 = (java.util.Iterator) r11     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            java.lang.Object r0 = r11.next()     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            r10 = r0
            java.util.concurrent.Future r10 = (java.util.concurrent.Future) r10     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            boolean r0 = r9.get()     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            if (r0 == 0) goto L35
            r0 = 13
            goto L19
        L35:
            r0 = 18
            goto L19
        L38:
            java.util.concurrent.Future r10 = (java.util.concurrent.Future) r10     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            java.lang.Object r0 = r10.get()     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            boolean r0 = r0.booleanValue()     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            if (r0 == 0) goto L49
            r0 = 17
            goto L19
        L49:
            r0 = 18
            goto L19
        L4c:
            r5 = 0
            r0 = 19
            goto L19
        L50:
            java.util.Iterator r6 = (java.util.Iterator) r6
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L5a
            r0 = 3
            goto L19
        L5a:
            r0 = 4
            goto L19
        L5c:
            java.util.concurrent.atomic.AtomicBoolean r9 = new java.util.concurrent.atomic.AtomicBoolean
            r9.<init>(r8)
            r0 = 5
            goto L19
        L63:
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r1 = r6.next()
            java.util.concurrent.Callable r1 = (java.util.concurrent.Callable) r1
            java.util.concurrent.ExecutorService r0 = com.facebook.ads.redexgen.X.KJ.A02()
            java.util.concurrent.Future r0 = r0.submit(r1)
            r7.add(r0)
            r0 = 2
            goto L19
        L7a:
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            java.util.Iterator r11 = r7.iterator()     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
        L80:
            boolean r0 = r11.hasNext()     // Catch: java.util.concurrent.ExecutionException -> L8c java.lang.InterruptedException -> L90
            if (r0 == 0) goto L89
            r0 = 9
            goto L19
        L89:
            r0 = 23
            goto L19
        L8c:
            r12 = move-exception
            r0 = 22
            goto L19
        L90:
            r12 = move-exception
            r0 = 22
            goto L19
        L94:
            r5 = r8
            r0 = 19
            goto L19
        L98:
            java.util.concurrent.atomic.AtomicBoolean r9 = (java.util.concurrent.atomic.AtomicBoolean) r9
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            r4 = 0
            java.lang.String r3 = com.facebook.ads.redexgen.X.EV.A0B
            r2 = 67
            r1 = 42
            r0 = 16
            java.lang.String r0 = A08(r2, r1, r0)
            android.util.Log.e(r3, r0, r12)
            r9.set(r4)
            r0 = 23
            goto L19
        Lb3:
            java.util.concurrent.atomic.AtomicBoolean r9 = (java.util.concurrent.atomic.AtomicBoolean) r9
            java.util.concurrent.atomic.AtomicBoolean r9 = (java.util.concurrent.atomic.AtomicBoolean) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EV.A0B(java.util.ArrayList):java.util.concurrent.atomic.AtomicBoolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F(EnumC0431Gu enumC0431Gu) {
        if (this.A01 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(A08(22, 12, 78), K4.A04(this.A00));
        this.A01.A02(enumC0431Gu, hashMap);
    }

    @Nullable
    public final Bitmap A0H(String str) {
        return this.A07.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap A0I(java.lang.String r11, int r12, int r13) {
        /*
            r10 = this;
            r6 = r11
            r3 = r10
            r1 = 0
            boolean r0 = r3.A08
            if (r0 == 0) goto L55
            r0 = 2
        L8:
            r7 = r12
            r8 = r13
            switch(r0) {
                case 2: goto Le;
                case 3: goto L57;
                case 4: goto L3e;
                default: goto Ld;
            }
        Ld:
            goto L8
        Le:
            com.facebook.ads.redexgen.X.EV r3 = (com.facebook.ads.redexgen.X.EV) r3
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.Eb r0 = r3.A04
            com.facebook.ads.redexgen.X.08 r4 = A04(r0, r6)
            r2 = 117(0x75, float:1.64E-43)
            r1 = 4
            r0 = 51
            java.lang.String r0 = A08(r2, r1, r0)
            r4.A03 = r0
            r4.A01 = r8
            r4.A00 = r7
            com.facebook.ads.redexgen.X.Eb r0 = r3.A04
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            com.facebook.ads.redexgen.X.02 r1 = A02(r0)
            r0 = 1
            com.facebook.ads.redexgen.X.04 r0 = r1.A8B(r4, r0)
            java.lang.Object r1 = r0.A00()
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            r0 = 3
            goto L8
        L3e:
            com.facebook.ads.redexgen.X.EV r3 = (com.facebook.ads.redexgen.X.EV) r3
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.EW r4 = r3.A03
            com.facebook.ads.redexgen.X.Eb r5 = r3.A04
            r2 = 162(0xa2, float:2.27E-43)
            r1 = 4
            r0 = 42
            java.lang.String r9 = A08(r2, r1, r0)
            android.graphics.Bitmap r1 = r4.A0D(r5, r6, r7, r8, r9)
            r0 = 3
            goto L8
        L55:
            r0 = 4
            goto L8
        L57:
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EV.A0I(java.lang.String, int, int):android.graphics.Bitmap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A0J(java.lang.String r6) {
        /*
            r5 = this;
            r4 = r5
            r1 = 0
            boolean r0 = r4.A08
            if (r0 == 0) goto L45
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L47;
                case 4: goto L34;
                case 5: goto L39;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.EV r4 = (com.facebook.ads.redexgen.X.EV) r4
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.Eb r0 = r4.A04
            com.facebook.ads.redexgen.X.08 r3 = A04(r0, r6)
            r2 = 117(0x75, float:1.64E-43)
            r1 = 4
            r0 = 51
            java.lang.String r0 = A08(r2, r1, r0)
            r3.A03 = r0
            com.facebook.ads.redexgen.X.Eb r0 = r4.A04
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            com.facebook.ads.redexgen.X.02 r0 = A02(r0)
            java.lang.String r1 = r0.A8D(r3)
            if (r1 == 0) goto L32
            r0 = 3
            goto L7
        L32:
            r0 = 4
            goto L7
        L34:
            java.lang.String r6 = (java.lang.String) r6
            r1 = r6
            r0 = 3
            goto L7
        L39:
            com.facebook.ads.redexgen.X.EV r4 = (com.facebook.ads.redexgen.X.EV) r4
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.EW r0 = r4.A03
            java.lang.String r1 = r0.A0E(r6)
            r0 = 3
            goto L7
        L45:
            r0 = 5
            goto L7
        L47:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EV.A0J(java.lang.String):java.lang.String");
    }

    public final String A0K(String str) {
        AnonymousClass08 A04 = A04(this.A04, str);
        A04.A03 = A08(117, 4, 51);
        String A8D = A02(this.A04.A00()).A8D(A04);
        return A8D != null ? A8D : str;
    }

    public final String A0L(String str) {
        AnonymousClass08 A04 = A04(this.A04, str);
        A04.A03 = A08(117, 4, 51);
        String A8D = A02(this.A04.A00()).A8D(A04);
        return A8D != null ? A8D : str;
    }

    public final void A0M() {
        I5.A05(A08(48, 19, 41), A08(174, 16, 6), A08(0, 8, 53));
    }

    public final void A0N() {
        I5.A05(A08(121, 16, 54), A08(34, 14, 61), A08(109, 8, 65));
    }

    public final void A0O() {
        this.A07.clear();
    }

    public final void A0P(@Nullable C1Z c1z, EP ep) {
        I5.A05(A08(155, 7, 101), A08(137, 18, 61), A08(166, 8, 109));
        this.A00 = System.currentTimeMillis();
        EY.A02(this.A04, ep, EY.A07, A08(8, 14, 2), -1L);
        KJ.A03().execute(new EN(this, new ArrayList(this.A05), c1z, ep, new ArrayList(this.A06)));
        this.A05.clear();
        this.A06.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Q(com.facebook.ads.redexgen.X.ES r4) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            com.facebook.ads.redexgen.X.ET r1 = new com.facebook.ads.redexgen.X.ET
            r1.<init>(r2, r4)
            boolean r0 = r4.A02
            if (r0 != 0) goto L26
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L28;
                case 4: goto L1b;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.EV r2 = (com.facebook.ads.redexgen.X.EV) r2
            com.facebook.ads.redexgen.X.ET r1 = (com.facebook.ads.redexgen.X.ET) r1
            java.util.List<java.util.concurrent.Callable<java.lang.Boolean>> r0 = r2.A05
            r0.add(r1)
            r0 = 3
            goto Lc
        L1b:
            com.facebook.ads.redexgen.X.EV r2 = (com.facebook.ads.redexgen.X.EV) r2
            com.facebook.ads.redexgen.X.ET r1 = (com.facebook.ads.redexgen.X.ET) r1
            java.util.List<java.util.concurrent.Callable<java.lang.Boolean>> r0 = r2.A06
            r0.add(r1)
            r0 = 3
            goto Lc
        L26:
            r0 = 4
            goto Lc
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EV.A0Q(com.facebook.ads.redexgen.X.ES):void");
    }

    public final void A0R(ES es) {
        es.A02 = true;
        A0Q(es);
    }

    public final void A0S(EU eu) {
        this.A05.add(new ER(this, eu));
    }

    public final void A0T(EU eu) {
        eu.A04 = true;
        this.A06.add(new ER(this, eu));
    }

    public final void A0U(EU eu) {
        eu.A04 = true;
        this.A06.add(new ER(this, eu));
    }

    public final void A0V(EU eu) {
        this.A05.add(new ER(this, eu));
    }

    public final void A0W(C0432Gv c0432Gv) {
        this.A01 = c0432Gv;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0X(java.lang.String r6) {
        /*
            r5 = this;
            r4 = 0
            com.facebook.ads.redexgen.X.Eb r0 = r5.A04
            com.facebook.ads.redexgen.X.08 r3 = A04(r0, r6)
            r2 = 117(0x75, float:1.64E-43)
            r1 = 4
            r0 = 51
            java.lang.String r0 = A08(r2, r1, r0)
            r3.A03 = r0
            com.facebook.ads.redexgen.X.Eb r0 = r5.A04
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            com.facebook.ads.redexgen.X.02 r0 = A02(r0)
            java.lang.String r0 = r0.A8D(r3)
            if (r0 == 0) goto L2d
            r0 = 2
        L23:
            switch(r0) {
                case 2: goto L27;
                case 3: goto L2f;
                case 4: goto L2a;
                default: goto L26;
            }
        L26:
            goto L23
        L27:
            r4 = 1
            r0 = 3
            goto L23
        L2a:
            r4 = 0
            r0 = 3
            goto L23
        L2d:
            r0 = 4
            goto L23
        L2f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EV.A0X(java.lang.String):boolean");
    }
}
