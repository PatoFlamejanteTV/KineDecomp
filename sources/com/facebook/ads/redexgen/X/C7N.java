package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.7N, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C7N {
    public SparseArray<C7M> A00 = new SparseArray<>();
    public int A01 = 0;

    private final long A00(long j, long j2) {
        if (j == 0) {
            return j2;
        }
        return (j2 / 4) + ((j / 4) * 3);
    }

    private C7M A01(int i) {
        C7M c7m = this.A00.get(i);
        if (c7m == null) {
            C7M c7m2 = new C7M();
            this.A00.put(i, c7m2);
            return c7m2;
        }
        return c7m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A02() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L16;
                case 4: goto L29;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.7N r2 = (com.facebook.ads.redexgen.X.C7N) r2
            android.util.SparseArray<com.facebook.ads.redexgen.X.7M> r0 = r2.A00
            int r0 = r0.size()
            if (r1 >= r0) goto L14
            r0 = 3
            goto L4
        L14:
            r0 = 4
            goto L4
        L16:
            com.facebook.ads.redexgen.X.7N r2 = (com.facebook.ads.redexgen.X.C7N) r2
            android.util.SparseArray<com.facebook.ads.redexgen.X.7M> r0 = r2.A00
            java.lang.Object r0 = r0.valueAt(r1)
            com.facebook.ads.redexgen.X.7M r0 = (com.facebook.ads.redexgen.X.C7M) r0
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r0.A03
            r0.clear()
            int r1 = r1 + 1
            r0 = 2
            goto L4
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7N.A02():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.C7Z A03(int r4) {
        /*
            r3 = this;
            r1 = 0
            r0 = 0
            android.util.SparseArray<com.facebook.ads.redexgen.X.7M> r0 = r3.A00
            java.lang.Object r2 = r0.get(r4)
            com.facebook.ads.redexgen.X.7M r2 = (com.facebook.ads.redexgen.X.C7M) r2
            if (r2 == 0) goto L34
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1f;
                case 4: goto L36;
                case 5: goto L31;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.7M r2 = (com.facebook.ads.redexgen.X.C7M) r2
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r2.A03
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L1d
            r0 = 3
            goto Ld
        L1d:
            r0 = 5
            goto Ld
        L1f:
            com.facebook.ads.redexgen.X.7M r2 = (com.facebook.ads.redexgen.X.C7M) r2
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r1 = r2.A03
            int r0 = r1.size()
            int r0 = r0 + (-1)
            java.lang.Object r1 = r1.remove(r0)
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            r0 = 4
            goto Ld
        L31:
            r1 = 0
            r0 = 4
            goto Ld
        L34:
            r0 = 5
            goto Ld
        L36:
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7N.A03(int):com.facebook.ads.redexgen.X.7Z");
    }

    public final void A04() {
        this.A01--;
    }

    public final void A05(int i, long j) {
        C7M A01 = A01(i);
        A01.A01 = A00(A01.A01, j);
    }

    public final void A06(int i, long j) {
        C7M A01 = A01(i);
        A01.A02 = A00(A01.A02, j);
    }

    public final void A07(C2E c2e) {
        this.A01++;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x003b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A08(com.facebook.ads.redexgen.X.C2E r3, com.facebook.ads.redexgen.X.C2E r4, boolean r5) {
        /*
            r2 = this;
            r1 = r2
            if (r3 == 0) goto L39
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L28;
                case 3: goto L22;
                case 4: goto L18;
                case 5: goto L11;
                case 6: goto L8;
                case 7: goto L2f;
                case 8: goto L3b;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.2E r4 = (com.facebook.ads.redexgen.X.C2E) r4
            if (r4 == 0) goto Le
            r0 = 7
            goto L4
        Le:
            r0 = 8
            goto L4
        L11:
            com.facebook.ads.redexgen.X.7N r1 = (com.facebook.ads.redexgen.X.C7N) r1
            r1.A02()
            r0 = 6
            goto L4
        L18:
            com.facebook.ads.redexgen.X.7N r1 = (com.facebook.ads.redexgen.X.C7N) r1
            int r0 = r1.A01
            if (r0 != 0) goto L20
            r0 = 5
            goto L4
        L20:
            r0 = 6
            goto L4
        L22:
            if (r5 != 0) goto L26
            r0 = 4
            goto L4
        L26:
            r0 = 6
            goto L4
        L28:
            com.facebook.ads.redexgen.X.7N r1 = (com.facebook.ads.redexgen.X.C7N) r1
            r1.A04()
            r0 = 3
            goto L4
        L2f:
            com.facebook.ads.redexgen.X.7N r1 = (com.facebook.ads.redexgen.X.C7N) r1
            com.facebook.ads.redexgen.X.2E r4 = (com.facebook.ads.redexgen.X.C2E) r4
            r1.A07(r4)
            r0 = 8
            goto L4
        L39:
            r0 = 3
            goto L4
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7N.A08(com.facebook.ads.redexgen.X.2E, com.facebook.ads.redexgen.X.2E, boolean):void");
    }

    public final void A09(C7Z c7z) {
        int A0H = c7z.A0H();
        ArrayList<C7Z> arrayList = A01(A0H).A03;
        if (this.A00.get(A0H).A00 <= arrayList.size()) {
            return;
        }
        c7z.A0Q();
        arrayList.add(c7z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0026, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A(int r7, long r8, long r10) {
        /*
            r6 = this;
            r5 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.7M r0 = r6.A01(r7)
            long r3 = r0.A01
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L24
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L1e;
                case 4: goto L26;
                case 5: goto L21;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            long r1 = r8 + r3
            int r0 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r0 >= 0) goto L1c
            r0 = 3
            goto L10
        L1c:
            r0 = 5
            goto L10
        L1e:
            r5 = 1
            r0 = 4
            goto L10
        L21:
            r5 = 0
            r0 = 4
            goto L10
        L24:
            r0 = 3
            goto L10
        L26:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7N.A0A(int, long, long):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0026, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0B(int r7, long r8, long r10) {
        /*
            r6 = this;
            r5 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.7M r0 = r6.A01(r7)
            long r3 = r0.A02
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L24
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L1e;
                case 4: goto L26;
                case 5: goto L21;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            long r1 = r8 + r3
            int r0 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r0 >= 0) goto L1c
            r0 = 3
            goto L10
        L1c:
            r0 = 5
            goto L10
        L1e:
            r5 = 1
            r0 = 4
            goto L10
        L21:
            r5 = 0
            r0 = 4
            goto L10
        L24:
            r0 = 3
            goto L10
        L26:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7N.A0B(int, long, long):boolean");
    }
}
