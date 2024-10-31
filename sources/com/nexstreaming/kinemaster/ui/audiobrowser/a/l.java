package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import java.util.List;

/* compiled from: MediaListerBase.java */
/* loaded from: classes.dex */
class l extends AsyncTask<Void, Void, List<u>> {

    /* renamed from: a */
    final /* synthetic */ Context f21430a;

    /* renamed from: b */
    final /* synthetic */ long f21431b;

    /* renamed from: c */
    final /* synthetic */ m f21432c;

    public l(m mVar, Context context, long j) {
        this.f21432c = mVar;
        this.f21430a = context;
        this.f21431b = j;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public List<u> doInBackground(Void... voidArr) {
        return this.f21432c.b(this.f21430a, this.f21431b);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(List<u> list) {
        this.f21432c.f21433a.sendResult(list);
    }
}
