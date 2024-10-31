package com.nexstreaming.kinemaster.ui.store.controller;

import android.support.v7.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioPageAssetListFragment.java */
/* loaded from: classes2.dex */
public class Ka implements io.reactivex.q<com.nexstreaming.kinemaster.ui.f.a.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ La f23459a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ka(La la) {
        this.f23459a = la;
    }

    @Override // io.reactivex.q
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(com.nexstreaming.kinemaster.ui.f.a.a aVar) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        if (aVar.f21581a.equals("RX_EVENT_STOP_PLAYER")) {
            recyclerView3 = this.f23459a.f23462b;
            ((Ja) recyclerView3.getAdapter()).i();
        }
        if (aVar.f21581a.equals("RX_EVENT_DOWNLOAD_ASSET")) {
            recyclerView2 = this.f23459a.f23462b;
            ((Ja) recyclerView2.getAdapter()).f();
        }
        if (aVar.f21581a.equals("RX_EVENT_PLAY_PLAYER")) {
            recyclerView = this.f23459a.f23462b;
            ((Ja) recyclerView.getAdapter()).j();
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
        this.f23459a.f23463c = bVar;
    }
}
