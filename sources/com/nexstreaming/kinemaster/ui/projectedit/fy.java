package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.TextLayer;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextLayer f3915a;
    final /* synthetic */ fx b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fy(fx fxVar, TextLayer textLayer) {
        this.b = fxVar;
        this.f3915a = textLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b.c(this.f3915a);
    }
}
