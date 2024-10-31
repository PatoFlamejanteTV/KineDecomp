package com.nexstreaming.kinemaster.ui.settings;

import android.view.KeyEvent;
import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.na, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnKeyListenerC2183na implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23169a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2202xa f23170b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnKeyListenerC2183na(C2202xa c2202xa, Slider slider) {
        this.f23170b = c2202xa;
        this.f23169a = slider;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (keyEvent.getAction() == 0) {
            if (i == 69) {
                C2202xa c2202xa = this.f23170b;
                i2 = c2202xa.t;
                c2202xa.t = Math.max(0, i2 - 1);
                Slider slider = this.f23169a;
                i3 = this.f23170b.t;
                slider.setValue(i3);
                return true;
            }
            if (i == 70 || i == 81) {
                C2202xa c2202xa2 = this.f23170b;
                i4 = c2202xa2.t;
                c2202xa2.t = Math.min(100, i4 + 1);
                Slider slider2 = this.f23169a;
                i5 = this.f23170b.t;
                slider2.setValue(i5);
                return true;
            }
        }
        return false;
    }
}
