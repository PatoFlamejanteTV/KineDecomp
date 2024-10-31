package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class cs implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4199a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(ProjectGalleryActivity projectGalleryActivity) {
        this.f4199a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        com.nexstreaming.kinemaster.ui.a.e eVar;
        com.nexstreaming.kinemaster.ui.a.e eVar2;
        com.nexstreaming.kinemaster.ui.a.e eVar3;
        com.nexstreaming.kinemaster.ui.a.e eVar4;
        eVar = this.f4199a.I;
        if (eVar != null) {
            eVar2 = this.f4199a.I;
            if (eVar2.isShowing()) {
                eVar3 = this.f4199a.I;
                eVar3.h(i);
                eVar4 = this.f4199a.I;
                eVar4.i(i2);
            }
        }
    }
}
