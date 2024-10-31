package com.nexstreaming.kinemaster.kmpackage;

import android.os.AsyncTask;
import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class j extends AsyncTask<Integer, Integer, Integer> {

    /* renamed from: a, reason: collision with root package name */
    Set<File> f3454a = new HashSet();
    Set<String> b = new HashSet();
    Set<String> c = new HashSet();
    Set<String> d = new HashSet();
    final /* synthetic */ ai e;
    final /* synthetic */ Task f;
    final /* synthetic */ EffectLibrary g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(EffectLibrary effectLibrary, ai aiVar, Task task) {
        this.g = effectLibrary;
        this.e = aiVar;
        this.f = task;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Integer... numArr) {
        this.g.a(this.e, this.f3454a, this.b, this.c, this.d);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        com.nexstreaming.kinemaster.b.a aVar = new com.nexstreaming.kinemaster.b.a();
        if (!this.e.c()) {
            this.f.sendFailure(EffectLibrary.EffectLibraryTaskError.DeleteCanceled);
            return;
        }
        if (this.e.f()) {
            this.g.b(this.e, this.f3454a, this.b, this.c, this.d);
            this.g.l();
            this.f.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
            aVar.a();
            return;
        }
        Log.w("EffectLibrary", "Package deletion failed");
        this.f.sendFailure(EffectLibrary.EffectLibraryTaskError.PackageDeletionFailure);
    }
}
