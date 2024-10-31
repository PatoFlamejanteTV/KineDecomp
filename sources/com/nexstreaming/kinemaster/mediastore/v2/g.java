package com.nexstreaming.kinemaster.mediastore.v2;

import android.os.AsyncTask;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaStore.java */
/* loaded from: classes.dex */
public class g extends AsyncTask<QueryParams, Void, List<MediaStoreItem>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f3562a;
    final /* synthetic */ MSID b;
    final /* synthetic */ ResultTask c;
    final /* synthetic */ MediaStore d;
    private Task.TaskError e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaStore mediaStore, l lVar, MSID msid, ResultTask resultTask) {
        this.d = mediaStore;
        this.f3562a = lVar;
        this.b = msid;
        this.c = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<MediaStoreItem> doInBackground(QueryParams... queryParamsArr) {
        try {
            return this.f3562a.a(queryParamsArr[0].e(), queryParamsArr[0]);
        } catch (Task.TaskErrorException e) {
            this.e = e.getTaskError();
            Log.w("MediaStore", "listContents failure : " + this.e.getMessage(), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<MediaStoreItem> list) {
        Map map;
        if (list != null) {
            map = this.d.g;
            List list2 = (List) map.get(this.b);
            if (list2 != null) {
                ArrayList arrayList = new ArrayList(list.size() + list2.size());
                arrayList.addAll(list2);
                arrayList.addAll(list);
                this.c.sendResult(arrayList);
            } else {
                this.c.sendResult(list);
            }
        } else {
            this.c.sendFailure(this.e);
        }
        super.onPostExecute(list);
    }
}
