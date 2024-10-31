package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* loaded from: assets/audience_network.dex */
public final class PJ extends C2E<PS> {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    @Nullable
    public AnonymousClass81 A04;
    public String A05;
    public List<PH> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final C2T A08;
    public final EV A09;
    public final C0362Ec A0A;
    public final InterfaceC0422Gl A0B;
    public final K5 A0C;
    public final PG A0D;
    public final FP A0E;

    public PJ(C0362Ec c0362Ec, List<PH> list, InterfaceC0422Gl interfaceC0422Gl, EV ev, FP fp, K5 k5, AnonymousClass81 anonymousClass81, C2T c2t, String str, int i, int i2, int i3, int i4, PG pg) {
        this.A0A = c0362Ec;
        this.A0B = interfaceC0422Gl;
        this.A09 = ev;
        this.A0E = fp;
        this.A0C = k5;
        this.A04 = anonymousClass81;
        this.A06 = list;
        this.A00 = i;
        this.A08 = c2t;
        this.A03 = i4;
        this.A05 = str;
        this.A01 = i3;
        this.A02 = i2;
        this.A0D = pg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C2E
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final PS A0D(ViewGroup viewGroup, int i) {
        return new PS(OT.A00(new C0609Nw(this.A0A, this.A0B, this.A04, null, null, this.A0E, this.A0C).A0H(), this.A03, this.A08, this.A05, this.A0D), this.A07, this.A0E, this.A00, this.A01, this.A02, this.A06.size(), this.A0A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C2E
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0E(PS ps, int i) {
        ps.A0l(this.A06.get(i), this.A0B, this.A09, this.A0C, this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.C2E
    public final int A0C() {
        return this.A06.size();
    }
}
