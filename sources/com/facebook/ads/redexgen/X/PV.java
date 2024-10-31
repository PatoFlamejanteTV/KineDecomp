package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public class PV extends C1O {
    public final /* synthetic */ PX A00;

    public PV(PX px) {
        this.A00 = px;
    }

    @Override // com.facebook.ads.redexgen.X.C1N
    public final void A6C() {
    }

    @Override // com.facebook.ads.redexgen.X.C1O, com.facebook.ads.redexgen.X.C1N
    public final void A6d(int i, @Nullable String str) {
        AtomicBoolean atomicBoolean;
        InterfaceC0547Ll interfaceC0547Ll;
        atomicBoolean = this.A00.A09;
        atomicBoolean.set(true);
        interfaceC0547Ll = this.A00.A07;
        interfaceC0547Ll.A71();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1O, com.facebook.ads.redexgen.X.C1N
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A6j() {
        /*
            r4 = this;
            r3 = r4
            com.facebook.ads.redexgen.X.PX r0 = r3.A00
            java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.ads.redexgen.X.PX.A05(r0)
            boolean r0 = r0.get()
            if (r0 != 0) goto L33
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L26;
                case 4: goto L35;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.PV r3 = (com.facebook.ads.redexgen.X.PV) r3
            com.facebook.ads.redexgen.X.PX r0 = r3.A00
            java.util.concurrent.atomic.AtomicBoolean r2 = com.facebook.ads.redexgen.X.PX.A06(r0)
            r1 = 0
            r0 = 1
            boolean r0 = r2.compareAndSet(r1, r0)
            if (r0 == 0) goto L24
            r0 = 3
            goto Le
        L24:
            r0 = 4
            goto Le
        L26:
            com.facebook.ads.redexgen.X.PV r3 = (com.facebook.ads.redexgen.X.PV) r3
            com.facebook.ads.redexgen.X.PX r0 = r3.A00
            com.facebook.ads.redexgen.X.Ll r0 = com.facebook.ads.redexgen.X.PX.A03(r0)
            r0.A6j()
            r0 = 4
            goto Le
        L33:
            r0 = 4
            goto Le
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PV.A6j():void");
    }
}
