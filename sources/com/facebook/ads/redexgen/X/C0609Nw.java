package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ads.internal.view.FullScreenAdToolbar;

/* renamed from: com.facebook.ads.redexgen.X.Nw */
/* loaded from: assets/audience_network.dex */
public class C0609Nw {

    @Nullable
    public View A02;

    @Nullable
    public FullScreenAdToolbar A03;

    @Nullable
    public I6 A04;
    public final View A05;
    public final C2I A06;
    public final C0362Ec A07;
    public final InterfaceC0422Gl A08;
    public final K5 A09;
    public final AnonymousClass81 A0A;
    public final FP A0B;
    public int A01 = 0;
    public int A00 = 1;

    public C0609Nw(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81, C2I c2i, View view, FP fp, K5 k5) {
        this.A07 = c0362Ec;
        this.A08 = interfaceC0422Gl;
        this.A0A = anonymousClass81;
        this.A06 = c2i;
        this.A05 = view;
        this.A0B = fp;
        this.A09 = k5;
    }

    public final C0609Nw A0C(int i) {
        this.A00 = i;
        return this;
    }

    public final C0609Nw A0D(int i) {
        this.A01 = i;
        return this;
    }

    public final C0609Nw A0E(View view) {
        this.A02 = view;
        return this;
    }

    public final C0609Nw A0F(FullScreenAdToolbar fullScreenAdToolbar) {
        this.A03 = fullScreenAdToolbar;
        return this;
    }

    public final C0609Nw A0G(I6 i6) {
        this.A04 = i6;
        return this;
    }

    public final C0610Nx A0H() {
        return new C0610Nx(this);
    }
}
