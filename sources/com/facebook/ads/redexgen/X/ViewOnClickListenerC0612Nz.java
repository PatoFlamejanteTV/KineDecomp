package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.FrameLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;

/* renamed from: com.facebook.ads.redexgen.X.Nz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0612Nz implements View.OnClickListener {
    public final /* synthetic */ O3 A00;

    public ViewOnClickListenerC0612Nz(O3 o3) {
        this.A00 = o3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FullScreenAdToolbar fullScreenAdToolbar;
        C0537Lb c0537Lb;
        I6 i6;
        FrameLayout frameLayout;
        C0537Lb c0537Lb2;
        FullScreenAdToolbar fullScreenAdToolbar2;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.A05 = false;
            fullScreenAdToolbar = this.A00.A02;
            if (fullScreenAdToolbar != null) {
                fullScreenAdToolbar2 = this.A00.A02;
                KE.A0O(fullScreenAdToolbar2);
            }
            c0537Lb = this.A00.A0A;
            KE.A0Q(c0537Lb, 0);
            i6 = this.A00.A0B;
            KE.A0Q(i6, 0);
            KE.A0Q(this.A00.getAdDetailsView(), 0);
            frameLayout = this.A00.A07;
            KE.A0L(frameLayout);
            c0537Lb2 = this.A00.A0A;
            c0537Lb2.A0Q(QH.A03);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
