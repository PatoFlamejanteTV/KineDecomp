package com.facebook.ads.redexgen.X;

import android.view.ViewTreeObserver;

/* renamed from: com.facebook.ads.redexgen.X.Pv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewTreeObserverOnWindowFocusChangeListenerC0659Pv implements ViewTreeObserver.OnWindowFocusChangeListener {
    public final /* synthetic */ C0537Lb A00;
    public final /* synthetic */ QH A01;

    public ViewTreeObserverOnWindowFocusChangeListenerC0659Pv(C0537Lb c0537Lb, QH qh) {
        this.A00 = c0537Lb;
        this.A01 = qh;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        if (z) {
            this.A00.A0Q(this.A01);
        }
    }
}
