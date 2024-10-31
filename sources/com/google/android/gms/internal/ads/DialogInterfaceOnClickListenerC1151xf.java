package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.ads.xf */
/* loaded from: classes2.dex */
final class DialogInterfaceOnClickListenerC1151xf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ JsResult f12658a;

    public DialogInterfaceOnClickListenerC1151xf(JsResult jsResult) {
        this.f12658a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f12658a.cancel();
    }
}
