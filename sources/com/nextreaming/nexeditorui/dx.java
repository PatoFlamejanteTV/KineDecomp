package com.nextreaming.nexeditorui;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectSettingsPopup.java */
/* loaded from: classes.dex */
public class dx implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectSettingsPopup f4613a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(ProjectSettingsPopup projectSettingsPopup) {
        this.f4613a = projectSettingsPopup;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Slider slider;
        SwitchCompat switchCompat;
        this.f4613a.f = z;
        slider = this.f4613a.n;
        slider.setEnabled(z);
        switchCompat = this.f4613a.l;
        switchCompat.setChecked(z);
    }
}
