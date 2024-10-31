package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import com.facebook.ads.redexgen.X.C7Z;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.2E, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C2E<VH extends C7Z> {
    public static byte[] A02;
    public final AnonymousClass76 A01 = new AnonymousClass76();
    public boolean A00 = false;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C2E.A02
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
            int r0 = r0 + (-14)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2E.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{-74, -70, -124, -77, -46, -90, -51, -46, -56, -70, -51, -55, -37, -66, -62, -116, -81, -34, -47, -51, -32, -47, -62, -43, -47, -29};
    }

    public abstract int A0C();

    public abstract VH A0D(ViewGroup viewGroup, int i);

    public abstract void A0E(VH vh, int i);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2E != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.7Z> */
    private final void A02(VH holder, int i, List<Object> payloads) {
        A0E(holder, i);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2E != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.7Z> */
    public final int A03(int i) {
        return 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2E != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.7Z> */
    public final long A04(int i) {
        return -1L;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2E != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.7Z> */
    public final VH A05(ViewGroup viewGroup, int i) {
        C4H.A01(A00(13, 13, 94));
        VH A0D = A0D(viewGroup, i);
        A0D.A00 = i;
        C4H.A00();
        return A0D;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2E != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.7Z> */
    public final void A06() {
        this.A01.A00();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2E != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.7Z> */
    public final void A07(AnonymousClass77 anonymousClass77) {
        this.A01.registerObserver(anonymousClass77);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2E != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.7Z> */
    public final void A08(AnonymousClass77 anonymousClass77) {
        this.A01.unregisterObserver(anonymousClass77);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:            com.facebook.ads.redexgen.X.C4H.A00();     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:            return;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2E != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.7Z> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A09(VH r6, int r7) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r2 = 0
            r3 = 1
            r6.A03 = r7
            boolean r0 = r4.A0A()
            if (r0 == 0) goto L53
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1d;
                case 4: goto L4a;
                case 5: goto L55;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.2E r4 = (com.facebook.ads.redexgen.X.C2E) r4
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            long r0 = r4.A04(r7)
            r6.A05 = r0
            r0 = 3
            goto Ld
        L1d:
            com.facebook.ads.redexgen.X.2E r4 = (com.facebook.ads.redexgen.X.C2E) r4
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            r0 = 519(0x207, float:7.27E-43)
            r6.A0U(r3, r0)
            r2 = 0
            r1 = 13
            r0 = 86
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.C4H.A01(r0)
            java.util.List r0 = r6.A0L()
            r4.A02(r6, r7, r0)
            r6.A0N()
            android.view.View r0 = r6.A0H
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            boolean r0 = r2 instanceof com.facebook.ads.redexgen.X.C01596e
            if (r0 == 0) goto L48
            r0 = 4
            goto Ld
        L48:
            r0 = 5
            goto Ld
        L4a:
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r0 = r2
            com.facebook.ads.redexgen.X.6e r0 = (com.facebook.ads.redexgen.X.C01596e) r0
            r0.A01 = r3
            r0 = 5
            goto Ld
        L53:
            r0 = 3
            goto Ld
        L55:
            com.facebook.ads.redexgen.X.C4H.A00()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2E.A09(com.facebook.ads.redexgen.X.7Z, int):void");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2E != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.7Z> */
    public final boolean A0A() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2E != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.7Z> */
    public final boolean A0B(VH vh) {
        return false;
    }
}
