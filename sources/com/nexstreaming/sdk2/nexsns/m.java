package com.nexstreaming.sdk2.nexsns;

import android.os.AsyncTask;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.nexstreaming.app.general.task.Task;
import java.io.IOException;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class m extends AsyncTask<Void, Void, File> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f4431a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.b = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File doInBackground(Void... voidArr) {
        Drive drive;
        try {
            drive = this.b.c.c;
            return drive.files().get(this.b.f4430a).execute();
        } catch (IOException e) {
            this.f4431a = Task.makeTaskError(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(File file) {
        if (file != null) {
            this.b.b.sendResult(file);
        } else {
            this.b.b.sendFailure(this.f4431a);
        }
        super.onPostExecute(file);
    }
}
