package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;

/* loaded from: assets/audience_network.dex */
public class KR implements DialogInterface.OnClickListener {
    public final /* synthetic */ KV A00;

    public KR(KV kv) {
        this.A00 = kv;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
