package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Pu, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC0658Pu implements View.OnTouchListener {
    public final /* synthetic */ C0537Lb A00;

    public ViewOnTouchListenerC0658Pu(C0537Lb c0537Lb) {
        this.A00 = c0537Lb;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        GY gy;
        gy = this.A00.A0B;
        gy.A02(new QX(view, motionEvent));
        return false;
    }
}
