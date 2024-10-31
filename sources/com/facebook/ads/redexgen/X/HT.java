package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public class HT implements DialogInterface.OnClickListener {
    public final /* synthetic */ HU A00;

    public HT(HU hu) {
        this.A00 = hu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Map<String, String> A01;
        if (this.A00.A01.A0V != null) {
            C00371i c00371i = this.A00.A01.A0V;
            A01 = this.A00.A01();
            c00371i.A0a(A01);
        }
    }
}
