package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.StickerLayer;

/* compiled from: StickerEditFragment.java */
/* loaded from: classes2.dex */
class Rg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StickerLayer f22070a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Sg f22071b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rg(Sg sg, StickerLayer stickerLayer) {
        this.f22071b = sg;
        this.f22070a = stickerLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22071b.f22084b.f(this.f22070a);
        this.f22071b.f22084b.da().J();
    }
}
