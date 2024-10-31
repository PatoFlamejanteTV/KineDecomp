package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.TextLayer;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Td implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ud f22100a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ TextLayer f22101b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Td(Ud ud, TextLayer textLayer) {
        this.f22100a = ud;
        this.f22101b = textLayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22100a.f22142a.f(this.f22101b);
    }
}
