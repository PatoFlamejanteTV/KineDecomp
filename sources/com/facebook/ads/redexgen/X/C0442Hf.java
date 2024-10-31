package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;

/* renamed from: com.facebook.ads.redexgen.X.Hf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0442Hf implements HZ {
    public NativeAdBase A00;
    public NativeAdListener A01;

    public C0442Hf(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        this.A01 = nativeAdListener;
        this.A00 = nativeAdBase;
    }

    @Override // com.facebook.ads.redexgen.X.H5
    public final void A65() {
        C0465If.A00(new C0440Hd(this));
    }

    @Override // com.facebook.ads.redexgen.X.H5
    public final void A68() {
        C0465If.A00(new C0439Hc(this));
    }

    @Override // com.facebook.ads.redexgen.X.H5
    public final void A6Y(C0453Hr c0453Hr) {
        C0465If.A00(new C0437Ha(this, c0453Hr));
    }

    @Override // com.facebook.ads.redexgen.X.H5
    public final void A72() {
        C0465If.A00(new C0441He(this));
    }

    @Override // com.facebook.ads.redexgen.X.HZ
    public final void A73() {
        C0465If.A00(new C0438Hb(this));
    }
}
