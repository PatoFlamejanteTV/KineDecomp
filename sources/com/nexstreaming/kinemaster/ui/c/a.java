package com.nexstreaming.kinemaster.ui.c;

import android.os.AsyncTask;
import android.util.LruCache;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FaceInfo.java */
/* loaded from: classes.dex */
public class a extends AsyncTask<String, Void, b> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f21519a = null;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f21520b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ResultTask f21521c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, ResultTask resultTask) {
        this.f21520b = str;
        this.f21521c = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b doInBackground(String... strArr) {
        return new b(new File(strArr[0]), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(b bVar) {
        Map map;
        LruCache lruCache;
        map = b.f21524c;
        map.remove(this.f21520b);
        if (bVar != null) {
            lruCache = b.f21522a;
            lruCache.put(this.f21520b, bVar);
            this.f21521c.sendResult(bVar);
            this.f21521c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            return;
        }
        this.f21521c.sendFailure(this.f21519a);
    }
}
