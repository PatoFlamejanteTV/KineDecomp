package com.facebook.ads.redexgen.X;

import java.util.LinkedList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ho, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0451Ho {
    public final HW A0B;
    public final boolean A0F;
    public final String A0C = C0451Ho.class.getSimpleName();
    public final int A07 = 101;
    public final int A0A = 102;
    public final int A08 = 103;
    public final int A03 = 104;
    public final int A09 = 105;
    public final int A02 = 106;
    public final int A04 = 107;
    public final int A05 = 108;
    public final int A06 = 109;
    public final int A01 = 110;
    public final boolean A0E = false;
    public long A00 = -1;
    public final List<C0450Hn> A0D = new LinkedList();

    public C0451Ho(C0361Eb c0361Eb, HW hw) {
        int A0C = C0414Gd.A0C(c0361Eb);
        if (A0C < 1) {
            this.A0F = false;
        } else {
            this.A0F = c0361Eb.A04().A00() < 1.0d / ((double) A0C);
        }
        this.A0B = hw;
    }

    private int A00() {
        return this.A0B.A4W();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A01() {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            long r3 = r6.A00
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L1e
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L20;
                case 4: goto L1b;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.Ho r6 = (com.facebook.ads.redexgen.X.C0451Ho) r6
            long r2 = java.lang.System.currentTimeMillis()
            long r0 = r6.A00
            long r2 = r2 - r0
            int r5 = (int) r2
            r0 = 3
            goto Lb
        L1b:
            r5 = -1
            r0 = 3
            goto Lb
        L1e:
            r0 = 4
            goto Lb
        L20:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0451Ho.A01():int");
    }

    private void A03(C0450Hn c0450Hn) {
        synchronized (this.A0D) {
            this.A0D.add(c0450Hn);
        }
    }

    public final void A04() {
        if (!this.A0F) {
            return;
        }
        A03(new C0450Hn(A01(), 110, A00(), null));
    }

    public final void A05() {
        if (!this.A0F) {
            return;
        }
        A03(new C0450Hn(A01(), 106, A00(), null));
    }

    public final void A06() {
        if (!this.A0F) {
            return;
        }
        A03(new C0450Hn(A01(), 104, A00(), null));
    }

    public final void A07() {
        if (!this.A0F) {
            return;
        }
        A03(new C0450Hn(A01(), 109, -1, null));
    }

    public final void A08() {
        if (!this.A0F) {
            return;
        }
        A03(new C0450Hn(A01(), 107, A00(), null));
    }

    public final void A09() {
        if (!this.A0F) {
            return;
        }
        A03(new C0450Hn(A01(), 108, A00(), null));
    }

    public final void A0A() {
        if (!this.A0F) {
            return;
        }
        this.A00 = System.currentTimeMillis();
        A03(new C0450Hn(0, 101, -1, null));
    }

    public final void A0B() {
        if (!this.A0F) {
            return;
        }
        A03(new C0450Hn(A01(), 105, A00(), null));
    }

    public final void A0C() {
        if (!this.A0F) {
            return;
        }
        A03(new C0450Hn(A01(), 102, A00(), null));
    }

    public final void A0D(C0361Eb c0361Eb, String str) {
        if (!this.A0F) {
            return;
        }
        A03(new C0450Hn(A01(), 103, A00(), null));
        KJ.A05.execute(new RunnableC0449Hm(this, str, c0361Eb));
    }
}
