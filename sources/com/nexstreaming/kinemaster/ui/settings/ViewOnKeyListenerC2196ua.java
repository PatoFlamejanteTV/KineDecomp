package com.nexstreaming.kinemaster.ui.settings;

import android.view.KeyEvent;
import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.ua, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnKeyListenerC2196ua implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23210a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2202xa f23211b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnKeyListenerC2196ua(C2202xa c2202xa, Slider slider) {
        this.f23211b = c2202xa;
        this.f23210a = slider;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (keyEvent.getAction() == 0) {
            if (i == 69) {
                C2202xa c2202xa = this.f23211b;
                i2 = c2202xa.f23234h;
                c2202xa.f23234h = Math.max(0, i2 - 100);
                Slider slider = this.f23210a;
                i3 = this.f23211b.f23234h;
                slider.setValue(i3 / 1000.0f);
                return true;
            }
            if (i == 70 || i == 81) {
                C2202xa c2202xa2 = this.f23211b;
                int maxValue = (int) (this.f23210a.getMaxValue() * 1000.0f);
                i4 = this.f23211b.f23234h;
                c2202xa2.f23234h = Math.min(maxValue, i4 + 100);
                Slider slider2 = this.f23210a;
                i5 = this.f23211b.f23234h;
                slider2.setValue(i5 / 1000.0f);
                return true;
            }
        }
        return false;
    }
}
