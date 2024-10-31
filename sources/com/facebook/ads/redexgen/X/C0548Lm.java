package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* renamed from: com.facebook.ads.redexgen.X.Lm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0548Lm implements InterfaceC0547Ll {
    public final /* synthetic */ C0549Ln A00;

    public C0548Lm(C0549Ln c0549Ln) {
        this.A00 = c0549Ln;
    }

    public /* synthetic */ C0548Lm(C0549Ln c0549Ln, C0541Lf c0541Lf) {
        this(c0549Ln);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0547Ll
    public final void A6Q() {
        this.A00.A0Q(true);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0547Ll
    public final void A6j() {
        C2I c2i;
        AnonymousClass81 anonymousClass81;
        MQ mq;
        InterfaceC0422Gl interfaceC0422Gl;
        C2I c2i2;
        PX px;
        PX px2;
        C0362Ec c0362Ec;
        c2i = this.A00.A06;
        if (!TextUtils.isEmpty(c2i.A0P())) {
            interfaceC0422Gl = this.A00.A0A;
            c2i2 = this.A00.A06;
            String A0P = c2i2.A0P();
            NS ns = new NS();
            px = this.A00.A03;
            NS A03 = ns.A03(px.getViewabilityChecker());
            px2 = this.A00.A03;
            interfaceC0422Gl.A5a(A0P, A03.A02(px2.getTouchDataRecorder()).A05());
            c0362Ec = this.A00.A09;
            c0362Ec.A08().A2X();
        }
        anonymousClass81 = this.A00.A0E;
        mq = this.A00.A0F;
        anonymousClass81.A3b(mq.A4k());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0547Ll
    public final void A71() {
        AnonymousClass81 anonymousClass81;
        MQ mq;
        anonymousClass81 = this.A00.A0E;
        mq = this.A00.A0F;
        anonymousClass81.A3b(mq.A4e());
    }
}
