package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectSettingsPopup.java */
/* loaded from: classes.dex */
public class ea implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectSettingsPopup f4617a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(ProjectSettingsPopup projectSettingsPopup) {
        this.f4617a = projectSettingsPopup;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        Slider slider;
        ProjectSettingsPopup projectSettingsPopup = this.f4617a;
        slider = this.f4617a.o;
        projectSettingsPopup.c = (int) (slider.getValue() * 1000.0f);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }
}
