package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;

/* renamed from: com.facebook.ads.redexgen.X.Lq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0552Lq implements View.OnClickListener {
    public final /* synthetic */ C0539Ld A00;
    public final /* synthetic */ M3 A01;

    public ViewOnClickListenerC0552Lq(M3 m3, C0539Ld c0539Ld) {
        this.A01 = m3;
        this.A00 = c0539Ld;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RelativeLayout relativeLayout;
        FullScreenAdToolbar fullScreenAdToolbar;
        C0537Lb c0537Lb;
        C0537Lb c0537Lb2;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            KE.A0L(this.A00);
            relativeLayout = this.A01.A0M;
            KE.A0O(relativeLayout);
            fullScreenAdToolbar = this.A01.A04;
            KE.A0O(fullScreenAdToolbar);
            c0537Lb = this.A01.A08;
            if (c0537Lb == null) {
                return;
            }
            c0537Lb2 = this.A01.A08;
            c0537Lb2.A0Q(QH.A03);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
