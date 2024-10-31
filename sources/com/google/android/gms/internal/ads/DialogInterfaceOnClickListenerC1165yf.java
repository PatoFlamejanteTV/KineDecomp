package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.ads.yf */
/* loaded from: classes2.dex */
final class DialogInterfaceOnClickListenerC1165yf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ JsResult f12685a;

    public DialogInterfaceOnClickListenerC1165yf(JsResult jsResult) {
        this.f12685a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f12685a.confirm();
    }
}
