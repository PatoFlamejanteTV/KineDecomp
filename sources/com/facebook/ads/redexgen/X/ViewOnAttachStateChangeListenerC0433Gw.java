package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Gw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnAttachStateChangeListenerC0433Gw implements View.OnAttachStateChangeListener {
    public final /* synthetic */ EnumC0431Gu A00;
    public final /* synthetic */ C0432Gv A01;

    public ViewOnAttachStateChangeListenerC0433Gw(C0432Gv c0432Gv, EnumC0431Gu enumC0431Gu) {
        this.A01 = c0432Gv;
        this.A00 = enumC0431Gu;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.A01.A02(this.A00, null);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
