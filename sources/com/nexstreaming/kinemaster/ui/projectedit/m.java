package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;

/* compiled from: AudioLevelMeterFragment.java */
/* loaded from: classes2.dex */
public class M implements ViewPropertyAnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ AudioLevelMeterFragment f21954a;

    public M(AudioLevelMeterFragment audioLevelMeterFragment) {
        this.f21954a = audioLevelMeterFragment;
    }

    @Override // android.support.v4.view.ViewPropertyAnimatorUpdateListener
    public void onAnimationUpdate(View view) {
        View view2;
        int i;
        view2 = this.f21954a.f21767c;
        i = this.f21954a.f21768d;
        view2.setTranslationX(i + view.getTranslationX());
    }
}
