package com.facebook.ads.redexgen.X;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Scroller;

/* renamed from: com.facebook.ads.redexgen.X.6x, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC01776x extends AbstractC01766w {
    public static byte[] A03;
    public C01807a A00;
    public Scroller A01;
    public final C7L A02 = new C7L() { // from class: com.facebook.ads.redexgen.X.7e
        public boolean A00 = false;

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0023, code lost:            return;     */
        @Override // com.facebook.ads.redexgen.X.C7L
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void A0U(com.facebook.ads.redexgen.X.C01807a r3, int r4) {
            /*
                r2 = this;
                r1 = r2
                super.A0U(r3, r4)
                if (r4 != 0) goto L21
                r0 = 2
            L7:
                switch(r0) {
                    case 2: goto Lb;
                    case 3: goto L15;
                    case 4: goto L23;
                    default: goto La;
                }
            La:
                goto L7
            Lb:
                com.facebook.ads.redexgen.X.7e r1 = (com.facebook.ads.redexgen.X.C01847e) r1
                boolean r0 = r1.A00
                if (r0 == 0) goto L13
                r0 = 3
                goto L7
            L13:
                r0 = 4
                goto L7
            L15:
                com.facebook.ads.redexgen.X.7e r1 = (com.facebook.ads.redexgen.X.C01847e) r1
                r0 = 0
                r1.A00 = r0
                com.facebook.ads.redexgen.X.6x r0 = com.facebook.ads.redexgen.X.AbstractC01776x.this
                r0.A0A()
                r0 = 4
                goto L7
            L21:
                r0 = 4
                goto L7
            L23:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01847e.A0U(com.facebook.ads.redexgen.X.7a, int):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0017, code lost:            return;     */
        @Override // com.facebook.ads.redexgen.X.C7L
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void A0V(com.facebook.ads.redexgen.X.C01807a r3, int r4, int r5) {
            /*
                r2 = this;
                r1 = r2
                if (r4 != 0) goto L15
                r0 = 2
            L4:
                switch(r0) {
                    case 2: goto L8;
                    case 3: goto Le;
                    case 4: goto L17;
                    default: goto L7;
                }
            L7:
                goto L4
            L8:
                if (r5 == 0) goto Lc
                r0 = 3
                goto L4
            Lc:
                r0 = 4
                goto L4
            Le:
                com.facebook.ads.redexgen.X.7e r1 = (com.facebook.ads.redexgen.X.C01847e) r1
                r0 = 1
                r1.A00 = r0
                r0 = 4
                goto L4
            L15:
                r0 = 3
                goto L4
            L17:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01847e.A0V(com.facebook.ads.redexgen.X.7a, int, int):void");
        }
    };

    static {
        A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AbstractC01776x.A03
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
            r0 = r0 ^ 114(0x72, float:1.6E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01776x.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A03 = new byte[]{40, 7, 73, 0, 7, 26, 29, 8, 7, 10, 12, 73, 6, 15, 73, 38, 7, 47, 5, 0, 7, 14, 37, 0, 26, 29, 12, 7, 12, 27, 73, 8, 5, 27, 12, 8, 13, 16, 73, 26, 12, 29, 71};
    }

    public abstract int A07(AbstractC01616g abstractC01616g, int i, int i2);

    @Nullable
    public abstract View A08(AbstractC01616g abstractC01616g);

    @Nullable
    public abstract int[] A0C(@NonNull AbstractC01616g abstractC01616g, @NonNull View view);

    @Nullable
    private final AbstractC01696p A00(AbstractC01616g abstractC01616g) {
        return A09(abstractC01616g);
    }

    private void A02() {
        this.A00.A1Z(this.A02);
        this.A00.setOnFlingListener(null);
    }

    private void A03() throws IllegalStateException {
        if (this.A00.getOnFlingListener() != null) {
            throw new IllegalStateException(A01(0, 43, 27));
        }
        this.A00.A1Y(this.A02);
        this.A00.setOnFlingListener(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A05(@android.support.annotation.NonNull com.facebook.ads.redexgen.X.AbstractC01616g r6, int r7, int r8) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r2 = 0
            r1 = 0
            boolean r0 = r6 instanceof com.facebook.ads.redexgen.X.InterfaceC01626h
            if (r0 != 0) goto L38
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L3a;
                case 3: goto Le;
                case 4: goto L1c;
                case 5: goto L2b;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.6x r4 = (com.facebook.ads.redexgen.X.AbstractC01776x) r4
            com.facebook.ads.redexgen.X.6g r6 = (com.facebook.ads.redexgen.X.AbstractC01616g) r6
            com.facebook.ads.redexgen.X.6p r2 = r4.A00(r6)
            if (r2 == 0) goto L1a
            r0 = 4
            goto La
        L1a:
            r0 = 2
            goto La
        L1c:
            com.facebook.ads.redexgen.X.6x r4 = (com.facebook.ads.redexgen.X.AbstractC01776x) r4
            com.facebook.ads.redexgen.X.6g r6 = (com.facebook.ads.redexgen.X.AbstractC01616g) r6
            int r3 = r4.A07(r6, r7, r8)
            r0 = -1
            if (r3 == r0) goto L29
            r0 = 5
            goto La
        L29:
            r0 = 2
            goto La
        L2b:
            com.facebook.ads.redexgen.X.6g r6 = (com.facebook.ads.redexgen.X.AbstractC01616g) r6
            com.facebook.ads.redexgen.X.6p r2 = (com.facebook.ads.redexgen.X.AbstractC01696p) r2
            r2.A0A(r3)
            r6.A1L(r2)
            r1 = 1
            r0 = 2
            goto La
        L38:
            r0 = 3
            goto La
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01776x.A05(com.facebook.ads.redexgen.X.6g, int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x004f, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01766w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A06(int r6, int r7) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = 0
            r0 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.7a r0 = r4.A00
            com.facebook.ads.redexgen.X.6g r1 = r0.getLayoutManager()
            if (r1 != 0) goto L4d
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L4f;
                case 3: goto L3c;
                case 4: goto L2a;
                case 5: goto L20;
                case 6: goto L12;
                case 7: goto L4a;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.6x r4 = (com.facebook.ads.redexgen.X.AbstractC01776x) r4
            com.facebook.ads.redexgen.X.6g r1 = (com.facebook.ads.redexgen.X.AbstractC01616g) r1
            boolean r0 = r4.A05(r1, r6, r7)
            if (r0 == 0) goto L1e
            r0 = 7
            goto Le
        L1e:
            r0 = 2
            goto Le
        L20:
            int r0 = java.lang.Math.abs(r6)
            if (r0 <= r3) goto L28
            r0 = 6
            goto Le
        L28:
            r0 = 2
            goto Le
        L2a:
            com.facebook.ads.redexgen.X.6x r4 = (com.facebook.ads.redexgen.X.AbstractC01776x) r4
            com.facebook.ads.redexgen.X.7a r0 = r4.A00
            int r3 = r0.getMinFlingVelocity()
            int r0 = java.lang.Math.abs(r7)
            if (r0 > r3) goto L3a
            r0 = 5
            goto Le
        L3a:
            r0 = 6
            goto Le
        L3c:
            com.facebook.ads.redexgen.X.6x r4 = (com.facebook.ads.redexgen.X.AbstractC01776x) r4
            com.facebook.ads.redexgen.X.7a r0 = r4.A00
            com.facebook.ads.redexgen.X.2E r0 = r0.getAdapter()
            if (r0 == 0) goto L48
            r0 = 4
            goto Le
        L48:
            r0 = 2
            goto Le
        L4a:
            r2 = 1
            r0 = 2
            goto Le
        L4d:
            r0 = 3
            goto Le
        L4f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01776x.A06(int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:            return r1;     */
    @android.support.annotation.Nullable
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.facebook.ads.redexgen.X.C01706q A09(com.facebook.ads.redexgen.X.AbstractC01616g r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r4 instanceof com.facebook.ads.redexgen.X.InterfaceC01626h
            if (r0 != 0) goto L1d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1f;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 0
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.6x r2 = (com.facebook.ads.redexgen.X.AbstractC01776x) r2
            com.facebook.ads.redexgen.X.7f r1 = new com.facebook.ads.redexgen.X.7f
            com.facebook.ads.redexgen.X.7a r0 = r2.A00
            android.content.Context r0 = r0.getContext()
            r1.<init>(r0)
            r0 = 3
            goto L7
        L1d:
            r0 = 4
            goto L7
        L1f:
            com.facebook.ads.redexgen.X.6q r1 = (com.facebook.ads.redexgen.X.C01706q) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01776x.A09(com.facebook.ads.redexgen.X.6g):com.facebook.ads.redexgen.X.6q");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x005b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0A() {
        /*
            r9 = this;
            r8 = r9
            r0 = 0
            r7 = 0
            r0 = 0
            r6 = 0
            r5 = 0
            r4 = 1
            r3 = 0
            com.facebook.ads.redexgen.X.7a r0 = r8.A00
            if (r0 != 0) goto L59
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L5b;
                case 3: goto L4b;
                case 4: goto L2e;
                case 5: goto L1b;
                case 6: goto L11;
                case 7: goto L3c;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            int[] r6 = (int[]) r6
            r0 = r6[r4]
            if (r0 == 0) goto L19
            r0 = 7
            goto Ld
        L19:
            r0 = 2
            goto Ld
        L1b:
            com.facebook.ads.redexgen.X.6x r8 = (com.facebook.ads.redexgen.X.AbstractC01776x) r8
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            android.view.View r7 = (android.view.View) r7
            r3 = 0
            int[] r6 = r8.A0C(r5, r7)
            r0 = r6[r3]
            if (r0 != 0) goto L2c
            r0 = 6
            goto Ld
        L2c:
            r0 = 7
            goto Ld
        L2e:
            com.facebook.ads.redexgen.X.6x r8 = (com.facebook.ads.redexgen.X.AbstractC01776x) r8
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            android.view.View r7 = r8.A08(r5)
            if (r7 == 0) goto L3a
            r0 = 5
            goto Ld
        L3a:
            r0 = 2
            goto Ld
        L3c:
            com.facebook.ads.redexgen.X.6x r8 = (com.facebook.ads.redexgen.X.AbstractC01776x) r8
            int[] r6 = (int[]) r6
            com.facebook.ads.redexgen.X.7a r2 = r8.A00
            r1 = r6[r3]
            r0 = r6[r4]
            r2.A1T(r1, r0)
            r0 = 2
            goto Ld
        L4b:
            com.facebook.ads.redexgen.X.6x r8 = (com.facebook.ads.redexgen.X.AbstractC01776x) r8
            com.facebook.ads.redexgen.X.7a r0 = r8.A00
            com.facebook.ads.redexgen.X.6g r5 = r0.getLayoutManager()
            if (r5 == 0) goto L57
            r0 = 4
            goto Ld
        L57:
            r0 = 2
            goto Ld
        L59:
            r0 = 3
            goto Ld
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01776x.A0A():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0047, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0B(@android.support.annotation.Nullable com.facebook.ads.redexgen.X.C01807a r5) throws java.lang.IllegalStateException {
        /*
            r4 = this;
            r3 = r4
            com.facebook.ads.redexgen.X.7a r0 = r3.A00
            if (r0 != r5) goto L45
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L47;
                case 3: goto La;
                case 4: goto L14;
                case 5: goto L1b;
                case 6: goto L29;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.6x r3 = (com.facebook.ads.redexgen.X.AbstractC01776x) r3
            com.facebook.ads.redexgen.X.7a r0 = r3.A00
            if (r0 == 0) goto L12
            r0 = 4
            goto L6
        L12:
            r0 = 5
            goto L6
        L14:
            com.facebook.ads.redexgen.X.6x r3 = (com.facebook.ads.redexgen.X.AbstractC01776x) r3
            r3.A02()
            r0 = 5
            goto L6
        L1b:
            com.facebook.ads.redexgen.X.6x r3 = (com.facebook.ads.redexgen.X.AbstractC01776x) r3
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            r3.A00 = r5
            com.facebook.ads.redexgen.X.7a r0 = r3.A00
            if (r0 == 0) goto L27
            r0 = 6
            goto L6
        L27:
            r0 = 2
            goto L6
        L29:
            com.facebook.ads.redexgen.X.6x r3 = (com.facebook.ads.redexgen.X.AbstractC01776x) r3
            r3.A03()
            android.widget.Scroller r2 = new android.widget.Scroller
            com.facebook.ads.redexgen.X.7a r0 = r3.A00
            android.content.Context r1 = r0.getContext()
            android.view.animation.DecelerateInterpolator r0 = new android.view.animation.DecelerateInterpolator
            r0.<init>()
            r2.<init>(r1, r0)
            r3.A01 = r2
            r3.A0A()
            r0 = 2
            goto L6
        L45:
            r0 = 3
            goto L6
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01776x.A0B(com.facebook.ads.redexgen.X.7a):void");
    }
}
