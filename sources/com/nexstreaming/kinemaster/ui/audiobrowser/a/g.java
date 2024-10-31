package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import java.util.List;

/* compiled from: MediaListerBase.java */
/* loaded from: classes.dex */
class g extends AsyncTask<Void, Void, List<com.nexstreaming.kinemaster.ui.audiobrowser.l>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3663a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Context context) {
        this.b = fVar;
        this.f3663a = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<com.nexstreaming.kinemaster.ui.audiobrowser.l> doInBackground(Void... voidArr) {
        return this.b.b(this.f3663a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<com.nexstreaming.kinemaster.ui.audiobrowser.l> list) {
        ResultTask resultTask;
        resultTask = this.b.b;
        resultTask.sendResult(list);
    }
}
