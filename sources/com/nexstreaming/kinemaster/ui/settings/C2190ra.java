package com.nexstreaming.kinemaster.ui.settings;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.ra, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2190ra implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23186a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwitchCompat f23187b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C2202xa f23188c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2190ra(C2202xa c2202xa, Slider slider, SwitchCompat switchCompat) {
        this.f23188c = c2202xa;
        this.f23186a = slider;
        this.f23187b = switchCompat;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f23188c.l = z;
        this.f23186a.setEnabled(z);
        this.f23187b.setChecked(z);
    }
}
