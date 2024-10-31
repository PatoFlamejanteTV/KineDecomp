package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.EffectLayer;

/* compiled from: EffectLayerEditFragment.java */
/* loaded from: classes.dex */
class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectLayer f4117a;
    final /* synthetic */ u b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, EffectLayer effectLayer) {
        this.b = uVar;
        this.f4117a = effectLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b.c(this.f4117a);
    }
}
