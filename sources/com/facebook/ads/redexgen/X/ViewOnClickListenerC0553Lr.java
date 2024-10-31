package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;

/* renamed from: com.facebook.ads.redexgen.X.Lr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0553Lr implements View.OnClickListener {
    public final /* synthetic */ C0539Ld A00;
    public final /* synthetic */ M3 A01;

    public ViewOnClickListenerC0553Lr(M3 m3, C0539Ld c0539Ld) {
        this.A01 = m3;
        this.A00 = c0539Ld;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RelativeLayout relativeLayout;
        FullScreenAdToolbar fullScreenAdToolbar;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            KE.A0L(this.A00);
            relativeLayout = this.A01.A0M;
            KE.A0O(relativeLayout);
            fullScreenAdToolbar = this.A01.A04;
            KE.A0O(fullScreenAdToolbar);
            this.A01.A0J();
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
