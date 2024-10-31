package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class _f implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f22204a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22205b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _f(ProjectEditActivity projectEditActivity, Intent intent) {
        this.f22205b = projectEditActivity;
        this.f22204a = intent;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        com.nexstreaming.kinemaster.ui.a.r rVar2;
        Task b2;
        rVar = this.f22205b.Xa;
        if (rVar == null) {
            ProjectEditActivity projectEditActivity = this.f22205b;
            projectEditActivity.Xa = new com.nexstreaming.kinemaster.ui.a.r(projectEditActivity);
        }
        ProjectEditActivity projectEditActivity2 = this.f22205b;
        Intent intent = this.f22204a;
        rVar2 = projectEditActivity2.Xa;
        b2 = projectEditActivity2.b(intent, rVar2);
        b2.onComplete(new Of(this));
    }
}
