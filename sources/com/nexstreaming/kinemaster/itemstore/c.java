package com.nexstreaming.kinemaster.itemstore;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

/* compiled from: KMAssetStore.java */
/* loaded from: classes.dex */
class c extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KMAssetStore f3410a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(KMAssetStore kMAssetStore) {
        this.f3410a = kMAssetStore;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        ProgressBar progressBar;
        progressBar = this.f3410a.c;
        progressBar.setProgress(i);
    }
}
