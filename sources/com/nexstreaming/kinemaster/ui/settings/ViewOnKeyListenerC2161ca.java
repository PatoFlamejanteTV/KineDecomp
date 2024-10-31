package com.nexstreaming.kinemaster.ui.settings;

import android.view.KeyEvent;
import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.ca, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnKeyListenerC2161ca implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23127a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2202xa f23128b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnKeyListenerC2161ca(C2202xa c2202xa, Slider slider) {
        this.f23128b = c2202xa;
        this.f23127a = slider;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (keyEvent.getAction() == 0) {
            if (i == 69) {
                C2202xa c2202xa = this.f23128b;
                i2 = c2202xa.k;
                c2202xa.k = Math.max(0, i2 - 100);
                Slider slider = this.f23127a;
                i3 = this.f23128b.k;
                slider.setValue(i3 / 1000.0f);
                return true;
            }
            if (i == 70 || i == 81) {
                C2202xa c2202xa2 = this.f23128b;
                int maxValue = (int) (this.f23127a.getMaxValue() * 1000.0f);
                i4 = this.f23128b.k;
                c2202xa2.k = Math.min(maxValue, i4 + 100);
                Slider slider2 = this.f23127a;
                i5 = this.f23128b.k;
                slider2.setValue(i5 / 1000.0f);
                return true;
            }
        }
        return false;
    }
}
