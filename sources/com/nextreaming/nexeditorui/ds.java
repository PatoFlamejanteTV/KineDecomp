package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectSettingsPopup.java */
/* loaded from: classes.dex */
public class ds implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectSettingsPopup f4608a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(ProjectSettingsPopup projectSettingsPopup) {
        this.f4608a = projectSettingsPopup;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        Slider slider;
        ProjectSettingsPopup projectSettingsPopup = this.f4608a;
        slider = this.f4608a.r;
        projectSettingsPopup.d = (int) (slider.getValue() * 1000.0f);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }
}
