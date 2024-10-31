package com.nexstreaming.kinemaster.ui.assetbrowser;

import com.nexstreaming.kinemaster.layer.AssetLayer;

/* compiled from: AssetBrowserBaseFragment.java */
/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AssetLayer f21379a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f21380b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, AssetLayer assetLayer) {
        this.f21380b = hVar;
        this.f21379a = assetLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21380b.f21381a.f(this.f21379a);
        this.f21380b.f21381a.D();
    }
}
