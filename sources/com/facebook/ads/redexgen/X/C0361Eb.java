package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.ContextWrapper;

/* renamed from: com.facebook.ads.redexgen.X.Eb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0361Eb extends ContextWrapper {
    public final InterfaceC0367Eh A00;

    public C0361Eb(Context context, InterfaceC0367Eh interfaceC0367Eh) {
        super(context.getApplicationContext());
        this.A00 = interfaceC0367Eh;
    }

    public final C0365Ef A00() {
        return new C0365Ef(this, this.A00);
    }

    public final InterfaceC0366Eg A01() {
        return this.A00.A4N(this);
    }

    public final InterfaceC0368Ei A02() {
        return this.A00.A4b(this);
    }

    public final InterfaceC0369Ej A03() {
        return this.A00.A4s(this);
    }

    public final GJ A04() {
        return this.A00.A4v();
    }

    public final InterfaceC0422Gl A05() {
        return this.A00.A4F(A00());
    }

    public final InterfaceC0515Kf A06() {
        return this.A00.A4Y(this);
    }
}
