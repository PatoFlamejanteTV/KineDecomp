package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network.dex */
public final class ID extends QJ {
    public final Paint A00;
    public final C0362Ec A01;

    @Nullable
    public final C0432Gv A02;
    public final AbstractC02238s A03;
    public final AbstractC02198o A04;
    public final AbstractC02178m A05;
    public final IB A06;

    public ID(C0362Ec c0362Ec, @Nullable C0432Gv c0432Gv) {
        this(c0362Ec, false, c0432Gv);
    }

    public ID(C0362Ec c0362Ec, boolean z, @Nullable C0432Gv c0432Gv) {
        super(c0362Ec);
        this.A04 = new C0462Ic(this);
        this.A05 = new C0461Ib(this);
        this.A03 = new IZ(this);
        this.A02 = c0432Gv;
        this.A01 = c0362Ec;
        this.A06 = new IB(c0362Ec, z);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 23.76d), (int) (displayMetrics.density * 23.76d));
        layoutParams.addRule(13);
        this.A06.setLayoutParams(layoutParams);
        this.A06.setChecked(true);
        this.A06.setClickable(false);
        this.A00 = new Paint();
        this.A00.setStyle(Paint.Style.FILL);
        if (z) {
            this.A00.setColor(-1728053248);
        } else {
            this.A00.setColor(-1);
            this.A00.setAlpha(204);
        }
        KE.A0P(this, 0);
        addView(this.A06);
        setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 72.0d), (int) (displayMetrics.density * 72.0d));
        layoutParams2.addRule(13);
        setLayoutParams(layoutParams2);
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A09() {
        super.A09();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A03(this.A04, this.A05, this.A03);
        }
        setOnClickListener(new IX(this));
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A0A() {
        setOnClickListener(null);
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A03, this.A05, this.A04);
        }
        super.A0A();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = Math.min(width, (getHeight() - getPaddingTop()) - getPaddingBottom());
        canvas.drawCircle(getPaddingLeft() + r4, getPaddingTop() + (height / 2), height / 2, this.A00);
        super.onDraw(canvas);
    }
}
