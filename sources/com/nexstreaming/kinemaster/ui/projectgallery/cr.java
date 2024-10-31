package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class cr implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f4198a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(ProjectGalleryActivity projectGalleryActivity, long j) {
        this.b = projectGalleryActivity;
        this.f4198a = j;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        com.nexstreaming.kinemaster.ui.a.e eVar;
        com.nexstreaming.kinemaster.ui.a.e eVar2;
        com.nexstreaming.kinemaster.ui.a.e eVar3;
        com.nexstreaming.kinemaster.ui.a.e eVar4;
        eVar = this.b.I;
        if (eVar != null) {
            eVar2 = this.b.I;
            if (eVar2.getWindow().getDecorView().getParent() != null) {
                eVar3 = this.b.I;
                if (eVar3.isShowing()) {
                    eVar4 = this.b.I;
                    eVar4.dismiss();
                    KMUsage.Media_Indexing_End.logEvent("Activity", "ProjectGalleryActivity", "Duration", KMUsage.bucketParamProjectTime((int) (System.currentTimeMillis() - this.f4198a)));
                    this.b.a(this.b.getIntent());
                }
            }
        }
        this.b.I = null;
        KMUsage.Media_Indexing_End.logEvent("Activity", "ProjectGalleryActivity", "Duration", KMUsage.bucketParamProjectTime((int) (System.currentTimeMillis() - this.f4198a)));
        this.b.a(this.b.getIntent());
    }
}
