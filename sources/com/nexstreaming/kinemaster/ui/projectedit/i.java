package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;

/* compiled from: AudioLevelMeterFragment.java */
/* loaded from: classes2.dex */
public class I implements ViewPropertyAnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ AudioLevelMeterFragment f21897a;

    public I(AudioLevelMeterFragment audioLevelMeterFragment) {
        this.f21897a = audioLevelMeterFragment;
    }

    @Override // android.support.v4.view.ViewPropertyAnimatorUpdateListener
    public void onAnimationUpdate(View view) {
        View view2;
        int i;
        View view3;
        view2 = this.f21897a.f21767c;
        i = this.f21897a.f21768d;
        view2.setTranslationX(i + view.getTranslationX());
        view3 = this.f21897a.f21767c;
        view3.setRotationY(view.getRotationY() + 90.0f);
    }
}
