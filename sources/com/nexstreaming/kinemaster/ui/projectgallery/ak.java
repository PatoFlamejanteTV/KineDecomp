package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.DialogInterface;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class ak implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ah f4137a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.f4137a = ahVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.nexstreaming.kinemaster.project.f fVar;
        Activity D;
        com.nexstreaming.kinemaster.project.f fVar2;
        ProjectGalleryActivity.SortingMode sortingMode;
        fVar = this.f4137a.f4134a.q;
        if (fVar != null) {
            KMUsage.ProjectList_DeleteProject.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "delete");
            D = this.f4137a.f4134a.D();
            KMAppUsage.a(D).a(KMAppUsage.KMMetric.ProjectMangagerTapDeleteOK);
            fVar2 = this.f4137a.f4134a.q;
            fVar2.a().delete();
            this.f4137a.f4134a.q = null;
            sortingMode = this.f4137a.f4134a.E;
            com.nexstreaming.kinemaster.project.f.a(sortingMode).onResultAvailable(new al(this));
        }
        dialogInterface.dismiss();
        this.f4137a.f4134a.C = false;
    }
}
