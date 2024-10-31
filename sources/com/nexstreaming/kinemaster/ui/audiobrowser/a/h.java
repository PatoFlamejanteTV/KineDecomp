package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.ui.audiobrowser.n;
import java.util.List;

/* compiled from: MediaListerBase.java */
/* loaded from: classes.dex */
class h extends AsyncTask<Void, Void, List<n>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3664a;
    final /* synthetic */ long b;
    final /* synthetic */ f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, Context context, long j) {
        this.c = fVar;
        this.f3664a = context;
        this.b = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<n> doInBackground(Void... voidArr) {
        return this.c.b(this.f3664a, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<n> list) {
        ResultTask resultTask;
        resultTask = this.c.f3662a;
        resultTask.sendResult(list);
    }
}
