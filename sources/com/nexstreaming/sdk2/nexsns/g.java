package com.nexstreaming.sdk2.nexsns;

import android.app.Activity;
import android.os.AsyncTask;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.IOException;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class g extends AsyncTask<Void, Void, Task.TaskError> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleDriveMediaDownload f4425a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GoogleDriveMediaDownload googleDriveMediaDownload) {
        this.f4425a = googleDriveMediaDownload;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Task.TaskError doInBackground(Void... voidArr) {
        Activity activity;
        Task.TaskError taskError;
        aa aaVar;
        try {
            GoogleDriveMediaDownload googleDriveMediaDownload = this.f4425a;
            aaVar = this.f4425a.f;
            googleDriveMediaDownload.k = aaVar.a();
        } catch (UserRecoverableAuthException e) {
            ab.a("GoogleDriveMediaDL", "recoverable error authenticating", e);
            activity = this.f4425a.n;
            activity.startActivityForResult(e.getIntent(), R.id.rqcode_gdrive_resolve_auth_err);
            taskError = GoogleDriveMediaDownload.o;
            return taskError;
        } catch (GoogleAuthException e2) {
            ab.b("GoogleDriveMediaDL", "error authenticating", e2);
            return Task.makeTaskError(e2);
        } catch (IOException e3) {
            ab.b("GoogleDriveMediaDL", "error authenticating", e3);
            Task.makeTaskError(e3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Task.TaskError taskError) {
        Task task;
        Task.TaskError taskError2;
        Task task2;
        Task task3;
        task = this.f4425a.h;
        if (task == null) {
            this.f4425a.h = new Task();
        }
        taskError2 = GoogleDriveMediaDownload.o;
        if (taskError != taskError2) {
            if (taskError != null) {
                task3 = this.f4425a.h;
                task3.sendFailure(taskError);
            } else {
                task2 = this.f4425a.h;
                task2.signalEvent(Task.Event.SUCCESS);
            }
        }
    }
}
