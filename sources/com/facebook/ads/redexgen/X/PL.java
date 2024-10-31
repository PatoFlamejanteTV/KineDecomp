package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class PL extends FrameLayout {
    public static final int A07 = (int) (16.0f * KE.A01);
    public MC A00;

    @Nullable
    public QA A01;
    public M9 A02;
    public M6 A03;
    public ID A04;
    public final C0362Ec A05;
    public final C0432Gv A06;

    public PL(C0362Ec c0362Ec, C0432Gv c0432Gv) {
        super(c0362Ec);
        this.A06 = c0432Gv;
        this.A05 = c0362Ec;
        setUpView(c0362Ec);
    }

    public final void A01() {
        this.A00.A0U(true);
    }

    public final void A02() {
        if (this.A01 != null) {
            this.A01.A0R();
            this.A01 = null;
        }
    }

    public final void A03(C1S c1s) {
        this.A00.getEventBus().A05(c1s);
    }

    public final void A04(InterfaceC0422Gl interfaceC0422Gl, String str, Map<String, String> extraParams) {
        A02();
        this.A01 = new QA(this.A05, interfaceC0422Gl, this.A00, str, extraParams);
    }

    public final void A05(QH qh) {
        this.A00.A0Q(qh);
    }

    public final boolean A06() {
        return this.A00.A0a();
    }

    @VisibleForTesting
    public C0537Lb getSimpleVideoView() {
        return this.A00;
    }

    public float getVolume() {
        return this.A00.getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.A03.setImage(str);
    }

    private void setUpPlugins(C0362Ec c0362Ec) {
        this.A00.A0M();
        this.A03 = new M6(c0362Ec);
        this.A00.A0S(this.A03);
        this.A02 = new M9(c0362Ec, this.A06);
        this.A00.A0S(new C0688Qy(c0362Ec));
        this.A00.A0S(this.A02);
        this.A04 = new ID(c0362Ec, true, this.A06);
        this.A00.A0S(this.A04);
        this.A00.A0S(new C0563Mb(this.A04, NA.A02, true, true));
        if (!this.A00.A0W()) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(A07, A07, A07, A07);
        this.A02.setLayoutParams(layoutParams);
        this.A00.addView(this.A02);
    }

    private void setUpVideo(C0362Ec c0362Ec) {
        this.A00 = new MC(c0362Ec);
        this.A00.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        KE.A0N(this.A00);
        addView(this.A00);
        setOnClickListener(new PK(this));
    }

    private void setUpView(C0362Ec c0362Ec) {
        setUpVideo(c0362Ec);
        setUpPlugins(c0362Ec);
    }

    public void setVideoURI(String str) {
        this.A00.setVideoURI(str);
    }

    public void setVolume(float f) {
        this.A00.setVolume(f);
        this.A02.A09();
    }
}
