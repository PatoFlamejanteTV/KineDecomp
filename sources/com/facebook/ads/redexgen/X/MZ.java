package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.widget.FrameLayout;

/* loaded from: assets/audience_network.dex */
public abstract class MZ extends FrameLayout {
    public int A00;
    public AnonymousClass44 A01;
    public AnonymousClass45 A02;

    @Nullable
    public AnonymousClass46 A03;
    public final C0362Ec A04;
    public final InterfaceC0422Gl A05;

    @Nullable
    public final AnonymousClass81 A06;

    @Nullable
    public final InterfaceC0524Ko A07;
    public final String A08;

    @Nullable
    public final C00572c A09;
    public final MX A0A;

    public abstract void A0K();

    public abstract void A0L();

    public abstract void A0M(AnonymousClass46 anonymousClass46, AnonymousClass44 anonymousClass44);

    public abstract void A0N(AnonymousClass46 anonymousClass46, AnonymousClass44 anonymousClass44);

    public abstract boolean A0O();

    public MZ(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, String str) {
        this(c0362Ec, interfaceC0422Gl, str, null, null, null);
    }

    public MZ(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, String str, @Nullable C00572c c00572c, @Nullable InterfaceC0524Ko interfaceC0524Ko, @Nullable AnonymousClass81 anonymousClass81) {
        super(c0362Ec);
        this.A00 = 0;
        this.A01 = AnonymousClass44.A04;
        this.A03 = null;
        this.A0A = new MY(this);
        this.A04 = c0362Ec;
        this.A05 = interfaceC0422Gl;
        this.A07 = interfaceC0524Ko;
        this.A06 = anonymousClass81;
        this.A08 = str;
        this.A09 = c00572c;
    }

    public static /* synthetic */ int A00(MZ mz) {
        int i = mz.A00;
        mz.A00 = i + 1;
        return i;
    }

    public static /* synthetic */ int A01(MZ mz) {
        int i = mz.A00;
        mz.A00 = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        if (this.A02.A0A()) {
            this.A05.A5P(this.A08, this.A02.A02());
            this.A02.A03();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        this.A03 = null;
        this.A02.A05();
        A0K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(AnonymousClass46 anonymousClass46) {
        this.A02.A08(this.A01);
        A0M(anonymousClass46, this.A01);
        if (A0O()) {
            A0A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(AnonymousClass46 anonymousClass46) {
        this.A03 = anonymousClass46;
        this.A02.A09(this.A01, this.A00);
        A0N(anonymousClass46, this.A01);
    }

    public final void A0I() {
        A0A();
    }

    public final void A0J() {
        this.A02 = new AnonymousClass45(new C0432Gv(this.A08, this.A05));
        if (this.A07 != null) {
            this.A07.A7F(true);
        }
        A0B();
    }
}
