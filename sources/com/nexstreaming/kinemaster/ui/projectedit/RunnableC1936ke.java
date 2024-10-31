package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.HandwritingLayer;

/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ke, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1936ke implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1945le f22426a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ HandwritingLayer f22427b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1936ke(C1945le c1945le, HandwritingLayer handwritingLayer) {
        this.f22426a = c1945le;
        this.f22427b = handwritingLayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22426a.f22435a.f(this.f22427b);
    }
}
