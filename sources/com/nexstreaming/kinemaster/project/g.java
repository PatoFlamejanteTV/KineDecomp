package com.nexstreaming.kinemaster.project;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import java.io.File;

/* compiled from: ProjectInfo.java */
/* loaded from: classes.dex */
public class g extends AsyncTask<File, Void, k> {

    /* renamed from: a */
    final /* synthetic */ ResultTask f21196a;

    public g(ResultTask resultTask) {
        this.f21196a = resultTask;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public k doInBackground(File... fileArr) {
        return new k(fileArr[0], null);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(k kVar) {
        this.f21196a.sendResult(kVar);
    }
}
