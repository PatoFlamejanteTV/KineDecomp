package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.net.Uri;

/* loaded from: classes2.dex */
final class Od implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ Nd f11731a;

    public Od(Nd nd) {
        this.f11731a = nd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzbv.e();
        zzayh.zza(this.f11731a.f11706a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
