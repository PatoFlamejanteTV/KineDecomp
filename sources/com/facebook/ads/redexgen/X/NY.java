package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public class NY implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0587Na A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ Map A02;

    public NY(C0587Na c0587Na, String str, Map map) {
        this.A00 = c0587Na;
        this.A01 = str;
        this.A02 = map;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        InterfaceC0422Gl interfaceC0422Gl;
        interfaceC0422Gl = this.A00.A04;
        interfaceC0422Gl.A5q(this.A01, this.A02);
    }
}
