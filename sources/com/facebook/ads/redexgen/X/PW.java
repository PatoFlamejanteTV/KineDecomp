package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: assets/audience_network.dex */
public class PW implements View.OnTouchListener {
    public final /* synthetic */ PX A00;

    public PW(PX px) {
        this.A00 = px;
    }

    public /* synthetic */ PW(PX px, PV pv) {
        this(px);
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        InterfaceC0422Gl interfaceC0422Gl;
        C2I c2i;
        if (motionEvent.getAction() != 1) {
            return false;
        }
        interfaceC0422Gl = this.A00.A04;
        c2i = this.A00.A01;
        interfaceC0422Gl.A5e(c2i.A0P(), new NS().A03(this.A00.getViewabilityChecker()).A02(this.A00.getTouchDataRecorder()).A05());
        return false;
    }
}
