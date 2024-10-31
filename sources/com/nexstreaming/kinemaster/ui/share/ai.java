package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
public class ai implements ResultTask.OnResultAvailableListener<com.nexstreaming.kinemaster.project.f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ad f4293a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ad adVar) {
        this.f4293a = adVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<com.nexstreaming.kinemaster.project.f> resultTask, Task.Event event, com.nexstreaming.kinemaster.project.f fVar) {
        this.f4293a.b(fVar.e());
        this.f4293a.c = fVar;
        this.f4293a.a();
    }
}
