package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.io.File;

/* loaded from: assets/audience_network.dex */
public class B7 implements InterfaceC0267Al {
    public final /* synthetic */ BK A00;

    public B7(BK bk) {
        this.A00 = bk;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    public final AbstractC0351Dr A44() {
        Context context;
        context = this.A00.A00;
        return this.A00.A06(new File(context.getApplicationInfo().publicSourceDir).length());
    }
}
