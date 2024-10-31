package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class ko implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ko(ProjectEditActivity projectEditActivity) {
        this.f4039a = projectEditActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        KMUsage.EditScreen_Theme_Confirm.logEvent("confirm", "cancel", "theme", "(cancel)");
        dialogInterface.dismiss();
    }
}
