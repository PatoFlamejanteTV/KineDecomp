package com.nexstreaming.kinemaster.ui.projectedit;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.wf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2067wf implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22755a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2067wf(ProjectEditActivity projectEditActivity) {
        this.f22755a = projectEditActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.d("ProjectEditActivity", "onFail: " + taskError.getMessage());
        this.f22755a.f(R.id.action_play_pause);
        this.f22755a.c(R.id.action_play_pause);
    }
}
