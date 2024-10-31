package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* renamed from: com.google.android.gms.internal.ads.zf */
/* loaded from: classes2.dex */
final class DialogInterfaceOnCancelListenerC1179zf implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f12702a;

    public DialogInterfaceOnCancelListenerC1179zf(JsPromptResult jsPromptResult) {
        this.f12702a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f12702a.cancel();
    }
}
