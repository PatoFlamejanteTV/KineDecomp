package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.HandwritingLayer;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class gf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingLayer f3923a;
    final /* synthetic */ ge b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gf(ge geVar, HandwritingLayer handwritingLayer) {
        this.b = geVar;
        this.f3923a = handwritingLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.f3922a.c(this.f3923a);
    }
}
