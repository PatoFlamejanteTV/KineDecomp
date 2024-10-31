package com.nexstreaming.kinemaster.mediastore.v2.scanner;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AllMediaScanner.java */
/* loaded from: classes.dex */
public class c extends AsyncTask<Void, Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f3611a;
    final /* synthetic */ boolean b;
    final /* synthetic */ Task c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, File file, boolean z, Task task) {
        this.d = aVar;
        this.f3611a = file;
        this.b = z;
        this.c = task;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        this.d.a(this.f3611a, false, (Date) null, this.b);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r5) {
        this.c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
