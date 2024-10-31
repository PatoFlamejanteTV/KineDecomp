package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.EffectLayer;

/* compiled from: EffectLayerEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.xa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC2070xa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectLayer f22761a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2078ya f22762b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2070xa(C2078ya c2078ya, EffectLayer effectLayer) {
        this.f22762b = c2078ya;
        this.f22761a = effectLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22762b.f22787b.f(this.f22761a);
    }
}
