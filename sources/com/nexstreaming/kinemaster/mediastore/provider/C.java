package com.nexstreaming.kinemaster.mediastore.provider;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
public class C extends AsyncTask<Void, Double, Task.TaskError> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f20951a;

    /* renamed from: b, reason: collision with root package name */
    boolean f20952b = false;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f20953c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f20954d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ OutputStream f20955e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ResultTask f20956f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ File f20957g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ File f20958h;
    final /* synthetic */ GoogleDriveProvider i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(GoogleDriveProvider googleDriveProvider, String str, String str2, OutputStream outputStream, ResultTask resultTask, File file, File file2) {
        this.i = googleDriveProvider;
        this.f20953c = str;
        this.f20954d = str2;
        this.f20955e = outputStream;
        this.f20956f = resultTask;
        this.f20957g = file;
        this.f20958h = file2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Task.TaskError doInBackground(Void... voidArr) {
        this.i.a(this.f20953c, this.f20954d, this.f20955e, this.f20956f, new B(this));
        return this.f20951a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Double... dArr) {
        this.f20956f.setProgress((int) (dArr[0].doubleValue() * 10000.0d), io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT);
        super.onProgressUpdate(dArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Task.TaskError taskError) {
        if (this.f20952b) {
            this.f20956f.signalEvent(Task.Event.CANCEL);
        } else if (taskError == null) {
            this.f20957g.renameTo(this.f20958h);
            this.f20956f.sendResult(this.f20958h);
        } else {
            this.f20956f.sendFailure(taskError);
        }
        super.onPostExecute(taskError);
    }
}
