package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class QA extends Q9 {
    public int A00;
    public boolean A01;
    public final C1S<QM> A02;
    public final C1S<QQ> A03;
    public final C1S<QR> A04;
    public final C1S<QT> A05;
    public final C1S<QU> A06;
    public final C1S<QV> A07;
    public final C1S<QW> A08;
    public final C1S<C0664Qa> A09;
    public final C1S<C0665Qb> A0A;
    public final C0537Lb A0B;
    public final AbstractC02158k A0C;
    public final AbstractC02258u A0D;

    public QA(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, C0537Lb c0537Lb, String str) {
        this(c0362Ec, interfaceC0422Gl, c0537Lb, new ArrayList(), str);
    }

    public QA(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, C0537Lb c0537Lb, String str, @Nullable Bundle bundle) {
        this(c0362Ec, interfaceC0422Gl, c0537Lb, new ArrayList(), str, bundle, null);
    }

    public QA(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, C0537Lb c0537Lb, String str, @Nullable Map<String, String> extraParams) {
        this(c0362Ec, interfaceC0422Gl, c0537Lb, new ArrayList(), str, null, extraParams);
    }

    public QA(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, C0537Lb c0537Lb, List<C1X> list, String str) {
        super(c0362Ec, interfaceC0422Gl, c0537Lb, list, str);
        this.A0D = new Q0(this);
        this.A07 = new Q1(this);
        this.A03 = new Q2(this);
        this.A04 = new Q3(this);
        this.A05 = new Q4(this);
        this.A02 = new Q5(this);
        this.A06 = new Q6(this);
        this.A09 = new Q7(this);
        this.A0A = new Q8(this);
        this.A08 = new C0661Px(this);
        this.A0C = new C0662Py(this);
        this.A01 = false;
        this.A0B = c0537Lb;
        this.A0B.getEventBus().A03(this.A0D, this.A05, this.A07, this.A04, this.A03, this.A02, this.A06, this.A09, this.A0A, this.A0C, this.A08);
    }

    public QA(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, C0537Lb c0537Lb, List<C1X> list, String str, @Nullable Bundle bundle, @Nullable Map<String, String> map) {
        super(c0362Ec, interfaceC0422Gl, c0537Lb, list, str, bundle, map);
        this.A0D = new Q0(this);
        this.A07 = new Q1(this);
        this.A03 = new Q2(this);
        this.A04 = new Q3(this);
        this.A05 = new Q4(this);
        this.A02 = new Q5(this);
        this.A06 = new Q6(this);
        this.A09 = new Q7(this);
        this.A0A = new Q8(this);
        this.A08 = new C0661Px(this);
        this.A0C = new C0662Py(this);
        this.A01 = false;
        this.A0B = c0537Lb;
        this.A0B.getEventBus().A03(this.A0D, this.A05, this.A07, this.A04, this.A03, this.A02, this.A06, this.A09, this.A0A, this.A08);
    }

    public final void A0R() {
        this.A0B.getStateHandler().post(new C0663Pz(this));
    }
}
