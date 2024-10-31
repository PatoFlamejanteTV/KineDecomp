package com.facebook.ads.redexgen.X;

import android.view.View;
import com.facebook.ads.internal.view.FullScreenAdToolbar;

/* renamed from: com.facebook.ads.redexgen.X.Kz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0535Kz implements View.OnClickListener {
    public final /* synthetic */ FullScreenAdToolbar A00;

    public ViewOnClickListenerC0535Kz(FullScreenAdToolbar fullScreenAdToolbar) {
        this.A00 = fullScreenAdToolbar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        L0 l0;
        ME me;
        L0 l02;
        if (!C0466Ig.A02(this)) {
            try {
                l0 = this.A00.A00;
                if (l0 != null) {
                    me = this.A00.A05;
                    if (me.A02()) {
                        l02 = this.A00.A00;
                        l02.A6L();
                    }
                }
            } catch (Throwable th) {
                C0466Ig.A00(th, this);
            }
        }
    }
}
