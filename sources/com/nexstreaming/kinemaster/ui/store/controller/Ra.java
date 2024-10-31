package com.nexstreaming.kinemaster.ui.store.controller;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FeaturedPageFragment.java */
/* loaded from: classes2.dex */
public class Ra implements io.reactivex.q<com.nexstreaming.kinemaster.ui.f.a.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sa f23482a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ra(Sa sa) {
        this.f23482a = sa;
    }

    @Override // io.reactivex.q
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(com.nexstreaming.kinemaster.ui.f.a.a aVar) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        UnifiedNativeAdView unifiedNativeAdView;
        nb nbVar;
        nb nbVar2;
        if (aVar.f21581a.equals("RX_EVENT_SHOW_AD") && (unifiedNativeAdView = (UnifiedNativeAdView) View.inflate(this.f23482a.getActivity(), R.layout.layout_admob_in_store, null)) != null) {
            nbVar = this.f23482a.f23489c;
            if (nbVar != null) {
                nbVar2 = this.f23482a.f23489c;
                nbVar2.a(unifiedNativeAdView, (UnifiedNativeAd) aVar.f21582b);
            }
        }
        if (aVar.f21581a.equals("RX_EVENT_HIDE_AD")) {
            recyclerView = this.f23482a.f23491e;
            if (recyclerView.getAdapter() instanceof nb) {
                recyclerView2 = this.f23482a.f23491e;
                ((nb) recyclerView2.getAdapter()).g();
            }
        }
    }

    @Override // io.reactivex.q
    public void onComplete() {
    }

    @Override // io.reactivex.q
    public void onError(Throwable th) {
    }

    @Override // io.reactivex.q
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        this.f23482a.i = bVar;
    }
}
