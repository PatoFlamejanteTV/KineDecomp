package com.facebook.ads.redexgen.X;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.Qe, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0668Qe extends Animation {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C0673Qj A02;

    public C0668Qe(C0673Qj c0673Qj, int i, int i2) {
        this.A02 = c0673Qj;
        this.A00 = i;
        this.A01 = i2;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        TextView textView;
        TextView textView2;
        int i = (int) (this.A00 + ((this.A01 - this.A00) * f));
        this.A02.getLayoutParams().width = i;
        this.A02.requestLayout();
        textView = this.A02.A01;
        textView.getLayoutParams().width = i - this.A00;
        textView2 = this.A02.A01;
        textView2.requestLayout();
    }

    @Override // android.view.animation.Animation
    public final boolean willChangeBounds() {
        return true;
    }
}
