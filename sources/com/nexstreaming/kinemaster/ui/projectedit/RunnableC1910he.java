package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.he */
/* loaded from: classes2.dex */
final class RunnableC1910he implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ScaleAnimation f22367a;

    /* renamed from: b */
    final /* synthetic */ RelativeLayout f22368b;

    public RunnableC1910he(ScaleAnimation scaleAnimation, RelativeLayout relativeLayout) {
        this.f22367a = scaleAnimation;
        this.f22368b = relativeLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22367a.setFillAfter(true);
        this.f22368b.startAnimation(this.f22367a);
    }
}
