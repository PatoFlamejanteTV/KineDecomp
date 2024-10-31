package com.nexstreaming.kinemaster.ui.settings;

import android.view.KeyEvent;
import android.view.View;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.ga, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnKeyListenerC2169ga implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DurationSpinner f23143a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2202xa f23144b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnKeyListenerC2169ga(C2202xa c2202xa, DurationSpinner durationSpinner) {
        this.f23144b = c2202xa;
        this.f23143a = durationSpinner;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (keyEvent.getAction() == 0) {
            if (i == 69) {
                C2202xa c2202xa = this.f23144b;
                i2 = c2202xa.q;
                c2202xa.q = Math.max(0, i2 - 100);
                DurationSpinner durationSpinner = this.f23143a;
                i3 = this.f23144b.q;
                durationSpinner.a(i3 / 1000.0f, false);
                return true;
            }
            if (i == 70 || i == 81) {
                C2202xa c2202xa2 = this.f23144b;
                int maxValue = (int) (this.f23143a.getMaxValue() * 1000.0f);
                i4 = this.f23144b.q;
                c2202xa2.q = Math.min(maxValue, i4 + 100);
                DurationSpinner durationSpinner2 = this.f23143a;
                i5 = this.f23144b.q;
                durationSpinner2.a(i5 / 1000.0f, false);
                return true;
            }
        }
        return false;
    }
}
