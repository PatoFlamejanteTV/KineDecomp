package com.nexstreaming.kinemaster.ui.store.controller;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FeaturedPageFragment.java */
/* loaded from: classes2.dex */
public class Qa implements TencentAdListener.NativeExpressAdListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sa f23481a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qa(Sa sa) {
        this.f23481a = sa;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.NativeExpressAdListener
    public void onNativeClosed(ViewGroup viewGroup) {
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.NativeExpressAdListener
    public void onNativeLoaded(ViewGroup viewGroup) {
        nb nbVar;
        if (viewGroup != null) {
            nbVar = this.f23481a.f23489c;
            nbVar.a((FrameLayout) viewGroup);
        }
    }
}
