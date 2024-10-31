package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.ads.wf */
/* loaded from: classes2.dex */
final class DialogInterfaceOnCancelListenerC1137wf implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    private final /* synthetic */ JsResult f12625a;

    public DialogInterfaceOnCancelListenerC1137wf(JsResult jsResult) {
        this.f12625a = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f12625a.cancel();
    }
}
