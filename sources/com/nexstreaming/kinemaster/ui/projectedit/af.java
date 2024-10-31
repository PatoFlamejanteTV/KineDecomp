package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Af implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f21741a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Af(ProjectEditActivity projectEditActivity) {
        this.f21741a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Activity u;
        Activity u2;
        Log.w("ProjectEditActivity", "action_capture_add_layer : fail" + taskError.getMessage(), taskError.getException());
        u = this.f21741a.u();
        u2 = this.f21741a.u();
        Toast.makeText(u, taskError.getLocalizedMessage(u2), 1).show();
        this.f21741a.Da();
    }
}
