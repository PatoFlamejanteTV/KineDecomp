package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ProjectSettingsPopup;

/* compiled from: ProjectSettingsPopup.java */
/* loaded from: classes.dex */
class dv implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectSettingsPopup f4611a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(ProjectSettingsPopup projectSettingsPopup) {
        this.f4611a = projectSettingsPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProjectSettingsPopup.SELECT_TAB select_tab;
        select_tab = ProjectSettingsPopup.f4501a;
        if (select_tab != ProjectSettingsPopup.SELECT_TAB.AUDIO) {
            ProjectSettingsPopup.SELECT_TAB unused = ProjectSettingsPopup.f4501a = ProjectSettingsPopup.SELECT_TAB.AUDIO;
            this.f4611a.e();
        }
    }
}
