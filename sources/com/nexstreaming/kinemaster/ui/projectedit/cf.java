package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Cf implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f21802a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cf(ProjectEditActivity projectEditActivity) {
        this.f21802a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Activity u;
        Activity u2;
        u = this.f21802a.u();
        u2 = this.f21802a.u();
        Toast.makeText(u, taskError.getLocalizedMessage(u2), 1).show();
        this.f21802a.Da();
    }
}