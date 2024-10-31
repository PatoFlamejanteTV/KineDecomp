package com.nexstreaming.kinemaster.tracelog;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: APCManager.java */
/* loaded from: classes.dex */
public final class b implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f3642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ResultTask resultTask) {
        this.f3642a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3642a.sendFailure(new a.C0073a(false, "verifyFail", R.string.apc_err_verify_fail, null));
    }
}
