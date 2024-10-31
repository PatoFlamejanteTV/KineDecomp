package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: assets/audience_network.dex */
public final class AF implements AC {
    public EnumC0346Dm A00;
    public EK A01;
    public EL A02;
    public final AA A03;
    public final C0259Ad A04;
    public final AtomicBoolean A05 = new AtomicBoolean();

    public AF(AA aa, C0259Ad c0259Ad) {
        this.A03 = aa;
        this.A04 = c0259Ad;
    }

    private final synchronized void A04() {
        if (this.A02 != null && this.A05.get()) {
            this.A01.A01(this.A02);
            EG.A00().A04();
            this.A04.A02();
            this.A05.compareAndSet(true, false);
        }
    }

    public final synchronized void A05(EnumC0346Dm enumC0346Dm) {
        if (!this.A05.get() && enumC0346Dm != null && this.A03.A0k() && EJ.A0E(enumC0346Dm)) {
            this.A01 = new EK(EG.A00().A03().getLooper());
            this.A00 = enumC0346Dm;
            this.A02 = new EL(new AE(this, enumC0346Dm));
            this.A04.A03(enumC0346Dm);
            this.A01.A00(this.A02);
            this.A05.compareAndSet(false, true);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AC
    public final synchronized void A8Y(EnumC0346Dm enumC0346Dm) {
        if (this.A00 != enumC0346Dm) {
            this.A00 = enumC0346Dm;
            if (enumC0346Dm == EnumC0346Dm.A04) {
                A04();
            } else {
                A05(enumC0346Dm);
            }
        }
    }
}
