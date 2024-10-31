package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ha, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0437Ha extends AbstractRunnableC00491u {
    public final /* synthetic */ C0442Hf A00;
    public final /* synthetic */ C0453Hr A01;

    public C0437Ha(C0442Hf c0442Hf, C0453Hr c0453Hr) {
        this.A00 = c0442Hf;
        this.A01 = c0453Hr;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
    public final void A01() {
        this.A00.A01.onError(this.A00.A00, C0453Hr.A00(this.A01));
    }
}
