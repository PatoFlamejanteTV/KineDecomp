package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.StickerLayer;

/* compiled from: StickerEditFragment.java */
/* loaded from: classes.dex */
class lb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StickerLayer f4055a;
    final /* synthetic */ la b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lb(la laVar, StickerLayer stickerLayer) {
        this.b = laVar;
        this.f4055a = stickerLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b.c(this.f4055a);
    }
}
