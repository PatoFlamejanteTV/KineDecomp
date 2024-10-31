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
public final class b extends AsyncTask<String, Void, a> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f3710a = null;
    final /* synthetic */ String b;
    final /* synthetic */ ResultTask c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, ResultTask resultTask) {
        this.b = str;
        this.c = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a doInBackground(String... strArr) {
        return new a(new File(strArr[0]), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(a aVar) {
        Map map;
        LruCache lruCache;
        map = a.c;
        map.remove(this.b);
        if (aVar != null) {
            lruCache = a.f3709a;
            lruCache.put(this.b, aVar);
            this.c.sendResult(aVar);
            this.c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            return;
        }
        this.c.sendFailure(this.f3710a);
    }
}
