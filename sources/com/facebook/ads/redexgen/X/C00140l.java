package com.facebook.ads.redexgen.X;

import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.0l, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00140l implements InterfaceC00110i {
    public final InterfaceC00090g A00;

    public C00140l(InterfaceC00090g interfaceC00090g) {
        this.A00 = interfaceC00090g;
    }

    public final void A00(EnumC00100h enumC00100h, JSONObject jSONObject) {
        this.A00.A4B(enumC00100h, jSONObject);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00110i
    public final InterfaceC00060d A5u() {
        return new C00080f(this);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00110i
    public final InterfaceC00050c A5v() {
        return new C00070e(this);
    }
}
