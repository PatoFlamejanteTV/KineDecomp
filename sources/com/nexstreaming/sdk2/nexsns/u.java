package com.nexstreaming.sdk2.nexsns;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.services.drive.Drive;
import com.nexstreaming.app.general.task.Task;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
public class u extends AsyncTask<Void, Double, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f4439a = null;
    final /* synthetic */ ByteArrayOutputStream b;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ByteArrayOutputStream byteArrayOutputStream) {
        this.c = tVar;
        this.b = byteArrayOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        HttpTransport httpTransport;
        Drive drive;
        try {
            ab.a("GoogleDriveMediaDL", "getting thumbnail file");
            httpTransport = this.c.c.d;
            drive = this.c.c.c;
            MediaHttpDownloader mediaHttpDownloader = new MediaHttpDownloader(httpTransport, drive.getRequestFactory().b());
            mediaHttpDownloader.a(true);
            mediaHttpDownloader.a(new v(this));
            mediaHttpDownloader.a(new GenericUrl(this.c.f4438a), this.b);
        } catch (IOException e) {
            this.f4439a = new w(this, e);
        }
        if (this.f4439a == null) {
            byte[] byteArray = this.b.toByteArray();
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            ab.a("GoogleDriveMediaDL", "mFileThumbTask is sending result");
            this.c.b.sendResult(bitmap);
        } else {
            ab.a("GoogleDriveMediaDL", "mFileThumbTask is sending failure");
            this.c.b.sendFailure(this.f4439a);
        }
        super.onPostExecute(bitmap);
    }
}
