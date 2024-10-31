package com.nextreaming.nexeditorui;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectSettingsPopup.java */
/* loaded from: classes.dex */
public class dr implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectSettingsPopup f4607a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(ProjectSettingsPopup projectSettingsPopup) {
        this.f4607a = projectSettingsPopup;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Slider slider;
        SwitchCompat switchCompat;
        this.f4607a.i = z;
        slider = this.f4607a.s;
        slider.setEnabled(z);
        switchCompat = this.f4607a.q;
        switchCompat.setChecked(z);
    }
}
