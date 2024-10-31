package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.Animation;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Wf implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wf(ProjectEditActivity projectEditActivity) {
        this.f22167a = projectEditActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        InterfaceC2025f interfaceC2025f;
        boolean z;
        InterfaceC2025f interfaceC2025f2;
        interfaceC2025f = this.f22167a.T;
        interfaceC2025f.setExpandingAnimation(false);
        z = this.f22167a.da;
        if (!z) {
            interfaceC2025f2 = this.f22167a.T;
            interfaceC2025f2.b();
        }
        this.f22167a.gb = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
