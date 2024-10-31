package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Ae, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0260Ae {
    public final Context A00;
    public final AA A01;

    public AbstractC0260Ae(Context context, AA aa) {
        this.A00 = context;
        this.A01 = aa;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0061, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00(com.facebook.ads.redexgen.X.AA r4, com.facebook.ads.redexgen.X.C0343Dj r5) {
        /*
            r3 = this;
            r2 = 0
            int r0 = r5.A00()
            java.lang.Integer r0 = r4.A0e(r0)
            if (r0 == 0) goto L5f
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L18;
                case 3: goto L61;
                case 4: goto L3d;
                case 5: goto L10;
                case 6: goto L2a;
                case 7: goto L4f;
                case 8: goto L57;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.AA r4 = (com.facebook.ads.redexgen.X.AA) r4
            int r2 = r4.A0S()
            r0 = 3
            goto Lc
        L18:
            com.facebook.ads.redexgen.X.AA r4 = (com.facebook.ads.redexgen.X.AA) r4
            com.facebook.ads.redexgen.X.Dj r5 = (com.facebook.ads.redexgen.X.C0343Dj) r5
            int r0 = r5.A00()
            java.lang.Integer r0 = r4.A0e(r0)
            int r2 = r0.intValue()
            r0 = 3
            goto Lc
        L2a:
            com.facebook.ads.redexgen.X.Dj r5 = (com.facebook.ads.redexgen.X.C0343Dj) r5
            java.util.EnumSet r1 = r5.A03()
            com.facebook.ads.redexgen.X.Dp r0 = com.facebook.ads.redexgen.X.EnumC0349Dp.A07
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L3a
            r0 = 7
            goto Lc
        L3a:
            r0 = 8
            goto Lc
        L3d:
            com.facebook.ads.redexgen.X.Dj r5 = (com.facebook.ads.redexgen.X.C0343Dj) r5
            java.util.EnumSet r1 = r5.A03()
            com.facebook.ads.redexgen.X.Dp r0 = com.facebook.ads.redexgen.X.EnumC0349Dp.A0A
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L4d
            r0 = 5
            goto Lc
        L4d:
            r0 = 6
            goto Lc
        L4f:
            com.facebook.ads.redexgen.X.AA r4 = (com.facebook.ads.redexgen.X.AA) r4
            int r2 = r4.A0R()
            r0 = 3
            goto Lc
        L57:
            com.facebook.ads.redexgen.X.AA r4 = (com.facebook.ads.redexgen.X.AA) r4
            int r2 = r4.A0V()
            r0 = 3
            goto Lc
        L5f:
            r0 = 4
            goto Lc
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0260Ae.A00(com.facebook.ads.redexgen.X.AA, com.facebook.ads.redexgen.X.Dj):int");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AG != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    @SuppressLint({"CatchGeneralException"})
    public final synchronized void A01(EnumC0346Dm enumC0346Dm, List<C0343Dj> list) {
        AbstractC0351Dr A04;
        Map<Integer, AG<AbstractC0351Dr>> A03 = C0347Dn.A01().A03();
        for (C0343Dj c0343Dj : list) {
            InterfaceC0267Al A02 = c0343Dj.A02(enumC0346Dm);
            if (A02 != null) {
                try {
                    A04 = A02.A44();
                } catch (Throwable th) {
                    A04 = EJ.A04(this.A00.getPackageName(), th);
                }
                if (A04 != null && A04.A07() != null) {
                    if (c0343Dj.A03().contains(EnumC0349Dp.A0A) && A03.containsKey(Integer.valueOf(c0343Dj.A00()))) {
                        AG<AbstractC0351Dr> ag = A03.get(Integer.valueOf(c0343Dj.A00()));
                        AbstractC0351Dr A022 = ag != null ? ag.A02() : null;
                        if (ag == null) {
                            ag = new AG<>(A00(this.A01, c0343Dj));
                        }
                        if (A022 == null || !A04.A0B(A022, c0343Dj.A03())) {
                            ag.A04(A04);
                            C0347Dn.A01().A04(c0343Dj.A00(), ag, A04.A05());
                        }
                    } else {
                        AG<AbstractC0351Dr> ag2 = new AG<>(A00(this.A01, c0343Dj));
                        ag2.A04(A04);
                        C0347Dn.A01().A04(c0343Dj.A00(), ag2, A04.A05());
                    }
                }
            }
        }
    }
}
