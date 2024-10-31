package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class fi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ScaleAnimation f3899a;
    final /* synthetic */ RelativeLayout b;
    final /* synthetic */ ez c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi(ez ezVar, ScaleAnimation scaleAnimation, RelativeLayout relativeLayout) {
        this.c = ezVar;
        this.f3899a = scaleAnimation;
        this.b = relativeLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3899a.setFillAfter(true);
        this.b.startAnimation(this.f3899a);
    }
}
