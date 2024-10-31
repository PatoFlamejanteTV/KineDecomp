package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetsLister.java */
/* loaded from: classes.dex */
public class c extends AsyncTask<Void, Void, List<u>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f21415a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f21416b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g gVar, Context context) {
        this.f21416b = gVar;
        this.f21415a = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<u> doInBackground(Void... voidArr) {
        List<u> d2;
        d2 = this.f21416b.d(this.f21415a);
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<u> list) {
        this.f21416b.f21433a.sendResult(list);
    }
}
