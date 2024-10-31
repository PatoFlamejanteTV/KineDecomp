package com.nexstreaming.kinemaster.mediastore;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: RemoteMediaInfo.java */
/* loaded from: classes.dex */
class j implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTask f20919a;

    public j(AsyncTask asyncTask) {
        this.f20919a = asyncTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (taskError == Task.TIMEOUT) {
            this.f20919a.cancel(true);
        }
    }
}
