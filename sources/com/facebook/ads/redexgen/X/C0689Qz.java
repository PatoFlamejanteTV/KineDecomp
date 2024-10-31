package com.facebook.ads.redexgen.X;

import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.Qz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0689Qz extends C1S<QT> {
    public final /* synthetic */ R0 A00;

    public C0689Qz(R0 r0) {
        this.A00 = r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C1S
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(QT qt) {
        C0537Lb videoView;
        TextView textView;
        C0537Lb videoView2;
        C0537Lb videoView3;
        String A05;
        videoView = this.A00.getVideoView();
        if (videoView == null) {
            return;
        }
        textView = this.A00.A00;
        R0 r0 = this.A00;
        videoView2 = this.A00.getVideoView();
        int duration = videoView2.getDuration();
        videoView3 = this.A00.getVideoView();
        A05 = r0.A05(duration - videoView3.getCurrentPositionInMillis());
        textView.setText(A05);
    }

    @Override // com.facebook.ads.redexgen.X.C1S
    public final Class<QT> A01() {
        return QT.class;
    }
}
