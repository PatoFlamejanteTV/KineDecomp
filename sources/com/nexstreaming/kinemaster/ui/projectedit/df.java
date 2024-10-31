package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
class Df implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ff f21819a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Df(Ff ff) {
        this.f21819a = ff;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Activity u;
        Activity u2;
        u = this.f21819a.f21850c.f21879b.u();
        u2 = this.f21819a.f21850c.f21879b.u();
        Toast.makeText(u, taskError.getLocalizedMessage(u2), 1).show();
        this.f21819a.f21850c.f21879b.Da();
    }
}
