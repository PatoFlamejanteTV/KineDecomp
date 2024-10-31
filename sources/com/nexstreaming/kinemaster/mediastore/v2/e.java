package com.nexstreaming.kinemaster.mediastore.v2;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaStore.java */
/* loaded from: classes.dex */
public class e extends AsyncTask<QueryParams, Void, List<MediaStoreItem>> {

    /* renamed from: a */
    final /* synthetic */ l f3560a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ MediaStore c;
    private Task.TaskError d = null;

    public e(MediaStore mediaStore, l lVar, ResultTask resultTask) {
        this.c = mediaStore;
        this.f3560a = lVar;
        this.b = resultTask;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public List<MediaStoreItem> doInBackground(QueryParams... queryParamsArr) {
        try {
            return this.f3560a.a(queryParamsArr[0]);
        } catch (Task.TaskErrorException e) {
            this.d = e.getTaskError();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(List<MediaStoreItem> list) {
        if (list != null) {
            this.b.sendResult(list);
        } else {
            this.b.sendFailure(this.d);
        }
        super.onPostExecute(list);
    }
}
