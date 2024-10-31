package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.ui.audiobrowser.s;
import java.util.List;

/* compiled from: MediaListerBase.java */
/* loaded from: classes.dex */
class k extends AsyncTask<Void, Void, List<s>> {

    /* renamed from: a */
    final /* synthetic */ Context f21428a;

    /* renamed from: b */
    final /* synthetic */ m f21429b;

    public k(m mVar, Context context) {
        this.f21429b = mVar;
        this.f21428a = context;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public List<s> doInBackground(Void... voidArr) {
        return this.f21429b.b(this.f21428a);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(List<s> list) {
        ResultTask resultTask;
        resultTask = this.f21429b.f21434b;
        resultTask.sendResult(list);
    }
}
