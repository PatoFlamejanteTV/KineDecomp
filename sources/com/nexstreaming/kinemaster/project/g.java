package com.nexstreaming.kinemaster.project;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectInfo.java */
/* loaded from: classes.dex */
public final class g extends AsyncTask<File, Void, f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f3623a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ResultTask resultTask) {
        this.f3623a = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public f doInBackground(File... fileArr) {
        return new f(fileArr[0], null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(f fVar) {
        this.f3623a.sendResult(fVar);
    }
}
