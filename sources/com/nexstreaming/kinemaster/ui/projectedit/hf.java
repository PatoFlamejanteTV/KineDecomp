package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Hf implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f21893a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hf(ProjectEditActivity projectEditActivity) {
        this.f21893a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Activity u;
        Activity u2;
        u = this.f21893a.u();
        u2 = this.f21893a.u();
        Toast.makeText(u, taskError.getLocalizedMessage(u2), 1).show();
        this.f21893a.Da();
    }
}
