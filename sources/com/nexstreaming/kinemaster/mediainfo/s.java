package com.nexstreaming.kinemaster.mediainfo;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class s extends AsyncTask<Void, Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f3512a = null;
    final /* synthetic */ MediaInfo.c b;
    final /* synthetic */ r c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, MediaInfo.c cVar) {
        this.c = rVar;
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        this.f3512a = ap.a(this.c.f3511a, this.c.b, this.c.c);
        this.c.f3511a.delete();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r5) {
        if (this.f3512a != null) {
            this.b.sendFailure(this.f3512a);
        } else {
            this.b.sendResult(ai.a());
            this.b.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
        }
    }
}
