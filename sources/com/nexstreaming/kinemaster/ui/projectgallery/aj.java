package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.DialogInterface;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class aj implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ah f4136a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.f4136a = ahVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Activity D;
        KMUsage.ProjectList_DeleteProject.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "cancel");
        D = this.f4136a.f4134a.D();
        KMAppUsage.a(D).a(KMAppUsage.KMMetric.ProjectMangagerTapDeleteCancel);
        this.f4136a.f4134a.C = false;
    }
}
