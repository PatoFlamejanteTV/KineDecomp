package com.nexstreaming.kinemaster.mediastore.scanner;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AllMediaScanner.java */
/* loaded from: classes.dex */
public class b extends AsyncTask<Void, Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f21056a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f21057b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Task f21058c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ e f21059d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e eVar, File file, boolean z, Task task) {
        this.f21059d = eVar;
        this.f21056a = file;
        this.f21057b = z;
        this.f21058c = task;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        this.f21059d.a(this.f21056a, false, (Date) null, this.f21057b);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        this.f21058c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
