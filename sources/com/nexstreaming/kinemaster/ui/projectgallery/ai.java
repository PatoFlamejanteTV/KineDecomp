package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.DialogInterface;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class ai implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ah f4135a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.f4135a = ahVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Activity D;
        KMUsage.ProjectList_DeleteProject.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "cancel");
        D = this.f4135a.f4134a.D();
        KMAppUsage.a(D).a(KMAppUsage.KMMetric.ProjectMangagerTapDeleteCancel);
        dialogInterface.dismiss();
        this.f4135a.f4134a.C = false;
    }
}
