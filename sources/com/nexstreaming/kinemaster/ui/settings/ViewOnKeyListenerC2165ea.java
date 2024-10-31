package com.nexstreaming.kinemaster.ui.settings;

import android.view.KeyEvent;
import android.view.View;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.ea, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnKeyListenerC2165ea implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DurationSpinner f23136a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2202xa f23137b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnKeyListenerC2165ea(C2202xa c2202xa, DurationSpinner durationSpinner) {
        this.f23137b = c2202xa;
        this.f23136a = durationSpinner;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (keyEvent.getAction() == 0) {
            if (i == 69) {
                C2202xa c2202xa = this.f23137b;
                i2 = c2202xa.p;
                c2202xa.p = Math.max(0, i2 - 100);
                DurationSpinner durationSpinner = this.f23136a;
                i3 = this.f23137b.p;
                durationSpinner.a(i3 / 1000.0f, false);
                return true;
            }
            if (i == 70 || i == 81) {
                C2202xa c2202xa2 = this.f23137b;
                int maxValue = (int) (this.f23136a.getMaxValue() * 1000.0f);
                i4 = this.f23137b.p;
                c2202xa2.p = Math.min(maxValue, i4 + 100);
                DurationSpinner durationSpinner2 = this.f23136a;
                i5 = this.f23137b.p;
                durationSpinner2.a(i5 / 1000.0f, false);
                return true;
            }
        }
        return false;
    }
}
