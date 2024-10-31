package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;

/* compiled from: AudioLevelMeterFragment.java */
/* loaded from: classes2.dex */
public class G implements ViewPropertyAnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ AudioLevelMeterFragment f21869a;

    public G(AudioLevelMeterFragment audioLevelMeterFragment) {
        this.f21869a = audioLevelMeterFragment;
    }

    @Override // android.support.v4.view.ViewPropertyAnimatorUpdateListener
    public void onAnimationUpdate(View view) {
        int i;
        View view2;
        View view3;
        float abs = Math.abs(view.getTranslationX()) * 0.3f;
        i = this.f21869a.f21768d;
        float f2 = (abs / i) + 0.7f;
        view2 = this.f21869a.f21767c;
        view2.setScaleX(f2);
        view3 = this.f21869a.f21767c;
        view3.setScaleY(f2);
    }
}
