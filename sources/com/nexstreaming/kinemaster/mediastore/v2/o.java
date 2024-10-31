package com.nexstreaming.kinemaster.mediastore.v2;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: RemoteMediaInfo.java */
/* loaded from: classes.dex */
final class o implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AsyncTask f3568a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AsyncTask asyncTask) {
        this.f3568a = asyncTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (taskError == Task.TIMEOUT) {
            this.f3568a.cancel(true);
        }
    }
}
