package com.nexstreaming.kinemaster.ui.settings;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.aa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2157aa implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23114a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwitchCompat f23115b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C2202xa f23116c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2157aa(C2202xa c2202xa, Slider slider, SwitchCompat switchCompat) {
        this.f23116c = c2202xa;
        this.f23114a = slider;
        this.f23115b = switchCompat;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f23116c.o = z;
        this.f23114a.setEnabled(z);
        this.f23115b.setChecked(z);
    }
}
