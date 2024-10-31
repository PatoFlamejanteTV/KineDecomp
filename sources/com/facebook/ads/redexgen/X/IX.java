package com.facebook.ads.redexgen.X;

import android.view.View;

/* loaded from: assets/audience_network.dex */
public class IX implements View.OnClickListener {
    public final /* synthetic */ ID A00;

    public IX(ID id) {
        this.A00 = id;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0537Lb videoView;
        C0432Gv c0432Gv;
        C0362Ec c0362Ec;
        C0537Lb videoView2;
        C0537Lb videoView3;
        C0537Lb videoView4;
        C0432Gv c0432Gv2;
        if (!C0466Ig.A02(this)) {
            try {
                videoView = this.A00.getVideoView();
                if (videoView != null) {
                    c0432Gv = this.A00.A02;
                    if (c0432Gv != null) {
                        c0432Gv2 = this.A00.A02;
                        c0432Gv2.A02(EnumC0431Gu.A0k, null);
                    }
                    c0362Ec = this.A00.A01;
                    c0362Ec.A08().A2s();
                    int[] iArr = IE.A00;
                    videoView2 = this.A00.getVideoView();
                    switch (iArr[videoView2.getState().ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            videoView3 = this.A00.getVideoView();
                            videoView3.A0Q(QH.A05);
                            return;
                        case 5:
                            videoView4 = this.A00.getVideoView();
                            videoView4.A0U(true);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable th) {
                C0466Ig.A00(th, this);
            }
        }
    }
}
