package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Jr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0501Jr implements InterfaceC0497Jn {
    public int A00;
    public final InterfaceC0497Jn A01;

    public C0501Jr(InterfaceC0497Jn interfaceC0497Jn, int i) {
        this.A01 = interfaceC0497Jn;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0497Jn
    public final void A7r(String str) {
        if (this.A00 > 0) {
            this.A01.A7r(str);
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0497Jn
    public final void flush() {
        this.A01.flush();
    }
}
