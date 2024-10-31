package com.nexstreaming.kinemaster.ui.share;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;

/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2232p implements TencentAdListener.NativeExpressAdListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23373a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2232p(ExportAndShareActivity exportAndShareActivity) {
        this.f23373a = exportAndShareActivity;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.NativeExpressAdListener
    public void onNativeClosed(ViewGroup viewGroup) {
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.NativeExpressAdListener
    public void onNativeLoaded(ViewGroup viewGroup) {
        C2220ga c2220ga;
        if (viewGroup != null) {
            c2220ga = this.f23373a.W;
            c2220ga.a((FrameLayout) viewGroup);
        }
    }
}
