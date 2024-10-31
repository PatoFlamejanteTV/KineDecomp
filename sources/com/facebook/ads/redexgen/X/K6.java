package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network.dex */
public final class K6 extends QJ implements View.OnClickListener {
    public final AbstractC02238s A00;
    public final AbstractC02198o A01;
    public final AbstractC02178m A02;
    public final AbstractC02158k A03;
    public final IB A04;

    public K6(C0362Ec c0362Ec) {
        this(c0362Ec, null);
    }

    public K6(C0362Ec c0362Ec, AttributeSet attributeSet) {
        this(c0362Ec, attributeSet, 0);
    }

    public K6(C0362Ec c0362Ec, AttributeSet attributeSet, int i) {
        super(c0362Ec, attributeSet, i);
        this.A03 = new C0518Ki(this);
        this.A01 = new KB(this);
        this.A02 = new KA(this);
        this.A00 = new K9(this);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.A04 = new IB(c0362Ec);
        this.A04.setChecked(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 25.0f), (int) (displayMetrics.density * 25.0f));
        setVisibility(8);
        addView(this.A04, layoutParams);
        setClickable(true);
        setFocusable(true);
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A09() {
        super.A09();
        setOnClickListener(this);
        this.A04.setOnClickListener(this);
        if (getVideoView() != null) {
            getVideoView().getEventBus().A03(this.A03, this.A00, this.A01, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A0A() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A02, this.A01, this.A00, this.A03);
        }
        setOnClickListener(null);
        this.A04.setOnClickListener(null);
        super.A0A();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            C0537Lb videoView = getVideoView();
            if (videoView == null) {
                return;
            }
            char c = videoView.getState() != FR.A07 ? '\b' : (char) 14;
            while (true) {
                switch (c) {
                    case '\b':
                        videoView = videoView;
                        if (videoView.getState() == FR.A05) {
                            c = 14;
                            break;
                        } else {
                            c = 11;
                            break;
                        }
                    case 11:
                        videoView = videoView;
                        if (videoView.getState() != FR.A06) {
                            c = 16;
                            break;
                        } else {
                            c = 14;
                            break;
                        }
                    case 14:
                        videoView.A0Q(QH.A05);
                        return;
                    case 16:
                        C0537Lb c0537Lb = videoView;
                        if (c0537Lb.getState() != FR.A0A) {
                            return;
                        }
                        c0537Lb.A0U(true);
                        return;
                }
            }
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    public void setPauseAccessibilityLabel(@Nullable String str) {
        this.A04.setPauseAccessibilityLabel(str);
    }

    public void setPlayAccessibilityLabel(@Nullable String str) {
        this.A04.setPlayAccessibilityLabel(str);
    }
}
