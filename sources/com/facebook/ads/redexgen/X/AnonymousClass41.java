package com.facebook.ads.redexgen.X;

import java.io.Serializable;

/* renamed from: com.facebook.ads.redexgen.X.41, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass41 implements Serializable {
    public AnonymousClass40 A00;
    public AnonymousClass40 A01;

    public AnonymousClass41() {
        this(0.5d, 0.5d);
    }

    public AnonymousClass41(double d) {
        this(d, 0.5d);
    }

    public AnonymousClass41(double d, double d2) {
        this.A00 = new AnonymousClass40(d);
        this.A01 = new AnonymousClass40(d2);
        A02();
    }

    public final AnonymousClass40 A00() {
        return this.A00;
    }

    public final AnonymousClass40 A01() {
        return this.A01;
    }

    public final void A02() {
        this.A00.A06();
        this.A01.A06();
    }

    public final void A03() {
        this.A00.A07();
        this.A01.A07();
    }

    public final void A04(double d, double d2) {
        this.A00.A08(d, d2);
    }

    public final void A05(double d, double d2) {
        this.A01.A08(d, d2);
    }
}
