package com.nexstreaming.kinemaster.mediainfo;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class AsyncTaskC1801t extends AsyncTask<Void, Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f20754a = null;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaInfo.c f20755b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C1802u f20756c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncTaskC1801t(C1802u c1802u, MediaInfo.c cVar) {
        this.f20756c = c1802u;
        this.f20755b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        C1802u c1802u = this.f20756c;
        int i = c1802u.f20758b;
        if (i == 0) {
            this.f20754a = S.a(c1802u.f20757a, 50, c1802u.f20759c);
        } else {
            this.f20754a = S.a(c1802u.f20757a, i, c1802u.f20759c);
        }
        this.f20756c.f20757a.delete();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        Task.TaskError taskError = this.f20754a;
        if (taskError != null) {
            this.f20755b.sendFailure(taskError);
        } else {
            this.f20755b.sendResult(K.a());
            this.f20755b.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
        }
    }
}
