package com.nexstreaming.kinemaster.ui.settings;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.sa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2192sa implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23192a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwitchCompat f23193b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C2202xa f23194c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2192sa(C2202xa c2202xa, Slider slider, SwitchCompat switchCompat) {
        this.f23194c = c2202xa;
        this.f23192a = slider;
        this.f23193b = switchCompat;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f23194c.m = z;
        this.f23192a.setEnabled(z);
        this.f23193b.setChecked(z);
    }
}
