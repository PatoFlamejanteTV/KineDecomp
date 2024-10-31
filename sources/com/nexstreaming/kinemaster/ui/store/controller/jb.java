package com.nexstreaming.kinemaster.ui.store.controller;

import android.R;
import com.nexstreaming.kinemaster.ui.settings.tb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StoreActivity.java */
/* loaded from: classes2.dex */
public class jb implements io.reactivex.q<com.nexstreaming.kinemaster.ui.f.a.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StoreActivity f23571a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jb(StoreActivity storeActivity) {
        this.f23571a = storeActivity;
    }

    @Override // io.reactivex.q
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(com.nexstreaming.kinemaster.ui.f.a.a aVar) {
        if (aVar.f21581a.equals("RX_EVENT_SHOW_SUBSCRIPTION")) {
            this.f23571a.getSupportFragmentManager().beginTransaction().replace(R.id.content, tb.a(this.f23571a.y(), 0, "assetStorePremium", "Asset Store"), tb.f23200a).addToBackStack(tb.f23200a).commitAllowingStateLoss();
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
        this.f23571a.O = bVar;
    }
}
