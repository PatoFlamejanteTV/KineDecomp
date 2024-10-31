package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.view.View;
import java.util.HashMap;

/* loaded from: assets/audience_network.dex */
public class MO implements View.OnClickListener {
    public final /* synthetic */ MN A00;

    public MO(MN mn) {
        this.A00 = mn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0537Lb videoView;
        String str;
        C0537Lb videoView2;
        C0362Ec c0362Ec;
        InterfaceC0422Gl interfaceC0422Gl;
        String str2;
        if (!C0466Ig.A02(this)) {
            try {
                videoView = this.A00.getVideoView();
                if (videoView != null) {
                    str = this.A00.A06;
                    Uri parse = Uri.parse(str);
                    videoView2 = this.A00.getVideoView();
                    videoView2.getEventBus().A02(new QL(parse));
                    c0362Ec = this.A00.A03;
                    interfaceC0422Gl = this.A00.A04;
                    str2 = this.A00.A05;
                    AnonymousClass11 A00 = AnonymousClass12.A00(c0362Ec, interfaceC0422Gl, str2, parse, new HashMap());
                    if (A00 == null) {
                        return;
                    }
                    A00.A03();
                }
            } catch (Throwable th) {
                C0466Ig.A00(th, this);
            }
        }
    }
}
