package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.util.Deque;
import java.util.LinkedList;

/* renamed from: com.facebook.ads.redexgen.X.Jm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0496Jm {
    public final int A01;
    public final int A02;
    public final Deque<String> A04 = new LinkedList();
    public final Deque<String> A03 = new LinkedList();

    @Nullable
    public String A00 = null;

    public C0496Jm(int i, int i2) {
        this.A02 = i;
        this.A01 = i2;
    }

    public final Iterable<String> A00() {
        return this.A03;
    }

    public final Iterable<String> A01() {
        return this.A04;
    }

    @Nullable
    public final String A02() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03() {
        /*
            r3 = this;
            r2 = r3
            java.lang.String r0 = r2.A00
            if (r0 == 0) goto L4d
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L2f;
                case 3: goto La;
                case 4: goto L21;
                case 5: goto L13;
                case 6: goto L4f;
                case 7: goto L46;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.Jm r2 = (com.facebook.ads.redexgen.X.C0496Jm) r2
            java.util.Deque<java.lang.String> r0 = r2.A04
            r0.removeFirst()
            r0 = 4
            goto L6
        L13:
            com.facebook.ads.redexgen.X.Jm r2 = (com.facebook.ads.redexgen.X.C0496Jm) r2
            java.util.Deque<java.lang.String> r0 = r2.A03
            java.lang.Object r0 = r0.removeFirst()
            java.lang.String r0 = (java.lang.String) r0
            r2.A00 = r0
            r0 = 6
            goto L6
        L21:
            com.facebook.ads.redexgen.X.Jm r2 = (com.facebook.ads.redexgen.X.C0496Jm) r2
            java.util.Deque<java.lang.String> r0 = r2.A03
            int r0 = r0.size()
            if (r0 <= 0) goto L2d
            r0 = 5
            goto L6
        L2d:
            r0 = 7
            goto L6
        L2f:
            com.facebook.ads.redexgen.X.Jm r2 = (com.facebook.ads.redexgen.X.C0496Jm) r2
            java.util.Deque<java.lang.String> r1 = r2.A04
            java.lang.String r0 = r2.A00
            r1.addLast(r0)
            java.util.Deque<java.lang.String> r0 = r2.A04
            int r1 = r0.size()
            int r0 = r2.A02
            if (r1 <= r0) goto L44
            r0 = 3
            goto L6
        L44:
            r0 = 4
            goto L6
        L46:
            com.facebook.ads.redexgen.X.Jm r2 = (com.facebook.ads.redexgen.X.C0496Jm) r2
            r0 = 0
            r2.A00 = r0
            r0 = 6
            goto L6
        L4d:
            r0 = 4
            goto L6
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0496Jm.A03():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A04(java.lang.String r4) {
        /*
            r3 = this;
            r2 = r3
            java.util.Deque<java.lang.String> r0 = r2.A03
            r0.addLast(r4)
            java.util.Deque<java.lang.String> r0 = r2.A03
            int r1 = r0.size()
            int r0 = r2.A01
            if (r1 > r0) goto L4d
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L4f;
                case 3: goto L15;
                case 4: goto L39;
                case 5: goto L1f;
                case 6: goto L44;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            com.facebook.ads.redexgen.X.Jm r2 = (com.facebook.ads.redexgen.X.C0496Jm) r2
            java.lang.String r0 = r2.A00
            if (r0 == 0) goto L1d
            r0 = 4
            goto L11
        L1d:
            r0 = 5
            goto L11
        L1f:
            com.facebook.ads.redexgen.X.Jm r2 = (com.facebook.ads.redexgen.X.C0496Jm) r2
            java.util.Deque<java.lang.String> r0 = r2.A03
            java.lang.Object r0 = r0.removeFirst()
            java.lang.String r0 = (java.lang.String) r0
            r2.A00 = r0
            java.util.Deque<java.lang.String> r0 = r2.A04
            int r1 = r0.size()
            int r0 = r2.A02
            if (r1 <= r0) goto L37
            r0 = 6
            goto L11
        L37:
            r0 = 2
            goto L11
        L39:
            com.facebook.ads.redexgen.X.Jm r2 = (com.facebook.ads.redexgen.X.C0496Jm) r2
            java.util.Deque<java.lang.String> r1 = r2.A04
            java.lang.String r0 = r2.A00
            r1.addLast(r0)
            r0 = 5
            goto L11
        L44:
            com.facebook.ads.redexgen.X.Jm r2 = (com.facebook.ads.redexgen.X.C0496Jm) r2
            java.util.Deque<java.lang.String> r0 = r2.A04
            r0.removeFirst()
            r0 = 2
            goto L11
        L4d:
            r0 = 3
            goto L11
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0496Jm.A04(java.lang.String):void");
    }
}
