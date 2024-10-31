package com.google.android.gms.internal;

import android.view.View;
import android.webkit.WebChromeClient;

@zzgr
/* loaded from: classes.dex */
public final class zzjh extends zzjf {
    public zzjh(zziz zzizVar) {
        super(zzizVar);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zza(view, i, customViewCallback);
    }
}
