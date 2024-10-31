package com.nexstreaming.kinemaster.ui.settings;

import android.view.KeyEvent;
import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.wa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnKeyListenerC2200wa implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23217a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2202xa f23218b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnKeyListenerC2200wa(C2202xa c2202xa, Slider slider) {
        this.f23218b = c2202xa;
        this.f23217a = slider;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (keyEvent.getAction() == 0) {
            if (i == 69) {
                C2202xa c2202xa = this.f23218b;
                i2 = c2202xa.i;
                c2202xa.i = Math.max(0, i2 - 100);
                Slider slider = this.f23217a;
                i3 = this.f23218b.i;
                slider.setValue(i3 / 1000.0f);
                return true;
            }
            if (i == 70 || i == 81) {
                C2202xa c2202xa2 = this.f23218b;
                int maxValue = (int) (this.f23217a.getMaxValue() * 1000.0f);
                i4 = this.f23218b.i;
                c2202xa2.i = Math.min(maxValue, i4 + 100);
                Slider slider2 = this.f23217a;
                i5 = this.f23218b.i;
                slider2.setValue(i5 / 1000.0f);
                return true;
            }
        }
        return false;
    }
}
