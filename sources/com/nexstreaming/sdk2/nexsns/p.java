package com.nexstreaming.sdk2.nexsns;

import android.os.AsyncTask;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.services.drive.Drive;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.sdk2.nexsns.GoogleDriveMediaDownload;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class p extends AsyncTask<Void, Double, Task.TaskError> {

    /* renamed from: a */
    Task.TaskError f4434a;
    boolean b = false;
    final /* synthetic */ OutputStream c;
    final /* synthetic */ o d;

    public p(o oVar, OutputStream outputStream) {
        this.d = oVar;
        this.c = outputStream;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Task.TaskError doInBackground(Void... voidArr) {
        Drive drive;
        HttpTransport httpTransport;
        Drive drive2;
        try {
            drive = this.d.g.c;
            MediaHttpDownloader mediaHttpDownloader = drive.files().get(this.d.b).getMediaHttpDownloader();
            if (mediaHttpDownloader == null) {
                httpTransport = this.d.g.d;
                drive2 = this.d.g.c;
                mediaHttpDownloader = new MediaHttpDownloader(httpTransport, drive2.getRequestFactory().b());
                mediaHttpDownloader.a(false);
            } else {
                ab.a("GoogleDriveMediaDL", "downloader is not NULL - FileID Worked!!! ");
                mediaHttpDownloader.a(false);
            }
            mediaHttpDownloader.a(new q(this));
            mediaHttpDownloader.a(800000);
            mediaHttpDownloader.a(new GenericUrl(this.d.d), this.c);
        } catch (GoogleDriveMediaDownload.DownloadCancelException e) {
            this.b = true;
        } catch (IOException e2) {
            this.f4434a = Task.makeTaskError(e2);
        }
        if (this.f4434a == null && !this.b) {
            this.d.c.setProgress(10000, 10000);
        }
        return this.f4434a;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Double... dArr) {
        this.d.c.setProgress((int) (dArr[0].doubleValue() * 10000.0d), 10000);
        super.onProgressUpdate(dArr);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Task.TaskError taskError) {
        if (this.b) {
            this.d.c.signalEvent(Task.Event.CANCEL);
        } else if (taskError == null) {
            this.d.e.renameTo(this.d.f);
            this.d.c.sendResult(this.d.f);
        } else {
            this.d.c.sendFailure(taskError);
        }
        super.onPostExecute(taskError);
    }
}
