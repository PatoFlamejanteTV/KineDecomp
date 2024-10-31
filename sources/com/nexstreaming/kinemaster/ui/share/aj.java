package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
public class aj implements ResultTask.OnResultAvailableListener<com.nexstreaming.kinemaster.project.f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ad f4294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ad adVar) {
        this.f4294a = adVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.kinemaster.project.f> resultTask, Task.Event event, com.nexstreaming.kinemaster.project.f fVar) {
        this.f4294a.b(fVar.e());
        this.f4294a.a(com.nexstreaming.kinemaster.ui.projectgallery.x.a(fVar.e(), this.f4294a.getResources(), true));
        this.f4294a.c = fVar;
        this.f4294a.a();
    }
}
