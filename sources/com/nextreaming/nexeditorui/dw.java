package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ProjectSettingsPopup;

/* compiled from: ProjectSettingsPopup.java */
/* loaded from: classes.dex */
class dw implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectSettingsPopup f4612a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(ProjectSettingsPopup projectSettingsPopup) {
        this.f4612a = projectSettingsPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProjectSettingsPopup.SELECT_TAB select_tab;
        select_tab = ProjectSettingsPopup.f4501a;
        if (select_tab != ProjectSettingsPopup.SELECT_TAB.VIDEO) {
            ProjectSettingsPopup.SELECT_TAB unused = ProjectSettingsPopup.f4501a = ProjectSettingsPopup.SELECT_TAB.VIDEO;
            this.f4612a.e();
        }
    }
}
