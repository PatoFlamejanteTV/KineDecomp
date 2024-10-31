package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectSettingsPopup.java */
/* loaded from: classes.dex */
public class du implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectSettingsPopup f4610a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(ProjectSettingsPopup projectSettingsPopup) {
        this.f4610a = projectSettingsPopup;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4610a.dismiss();
    }
}
