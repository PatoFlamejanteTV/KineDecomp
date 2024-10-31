package com.facebook.ads.redexgen.X;

import java.util.Set;

/* loaded from: assets/audience_network.dex */
public class FI {
    public F9 A00;
    public Set<String> A01;
    public Set<String> A02;
    public boolean A03;
    public boolean A04 = true;

    public final FI A00(F9 f9) {
        this.A00 = f9;
        return this;
    }

    public final FI A01(Set<String> pinnedCertificates) {
        this.A01 = pinnedCertificates;
        return this;
    }

    public final FI A02(Set<String> pinnedPublicKeys) {
        this.A02 = pinnedPublicKeys;
        return this;
    }

    public final FI A03(boolean z) {
        this.A04 = z;
        return this;
    }

    public final FI A04(boolean z) {
        this.A03 = z;
        return this;
    }

    public final FH A05() {
        return new FH(this.A00, this.A04, this.A02, this.A01, this.A03);
    }
}
