package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* loaded from: assets/audience_network.dex */
public abstract class NW extends LinearLayout {
    public static final LinearLayout.LayoutParams A05 = new LinearLayout.LayoutParams(-2, -2);
    public final int A00;
    public final RelativeLayout A01;
    public final C0362Ec A02;
    public final ViewOnClickListenerC0589Nc A03;
    public final M4 A04;

    public abstract void A08(int i);

    public abstract void A09(boolean z);

    public NW(C0362Ec c0362Ec, int i, C2T c2t, String str, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81, FP fp, K5 k5) {
        super(c0362Ec);
        this.A02 = c0362Ec;
        this.A00 = i;
        this.A04 = new M4(c0362Ec);
        KE.A0P(this.A04, 0);
        KE.A0N(this.A04);
        this.A03 = new ViewOnClickListenerC0589Nc(c0362Ec, str, c2t, interfaceC0422Gl, anonymousClass81, fp, k5);
        KE.A0I(1001, this.A03);
        this.A01 = new RelativeLayout(c0362Ec);
        this.A01.setLayoutParams(A05);
        KE.A0N(this.A01);
    }

    public final ViewOnClickListenerC0589Nc getCTAButton() {
        return this.A03;
    }

    @VisibleForTesting
    public final ImageView getIconView() {
        return this.A04;
    }

    public void setInfo(C2S c2s, C2U c2u, String str, String str2, @Nullable NZ nz) {
        this.A03.setCta(c2u, str, new HashMap(), nz);
        new NR(this.A04, this.A02).A05(this.A00, this.A00).A07(str2);
    }
}
