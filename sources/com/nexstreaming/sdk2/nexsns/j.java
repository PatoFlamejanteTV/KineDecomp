package com.nexstreaming.sdk2.nexsns;

import android.app.Activity;
import android.os.AsyncTask;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.sdk2.nexsns.GoogleDriveMediaDownload;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class j extends AsyncTask<Void, Void, List<File>> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f4428a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.c = iVar;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<File> doInBackground(Void... voidArr) {
        Activity activity;
        SynchronousQueue synchronousQueue;
        aa aaVar;
        Drive drive;
        Activity activity2;
        SynchronousQueue synchronousQueue2;
        aa aaVar2;
        try {
            GoogleDriveMediaDownload googleDriveMediaDownload = this.c.c;
            aaVar2 = this.c.c.f;
            googleDriveMediaDownload.k = aaVar2.a();
        } catch (UserRecoverableAuthException e) {
            ab.a("GoogleDriveMediaDL", "recoverable error listing contents", e);
            activity = this.c.c.n;
            activity.startActivityForResult(e.getIntent(), R.id.rqcode_gdrive_resolve_auth_err);
            try {
                synchronousQueue = this.c.c.l;
                GoogleDriveMediaDownload.a aVar = (GoogleDriveMediaDownload.a) synchronousQueue.take();
                if (!aVar.b) {
                    this.f4428a = aVar.c;
                    if (this.f4428a == null) {
                        this.f4428a = Task.makeTaskError(e);
                    }
                    return null;
                }
                try {
                    GoogleDriveMediaDownload googleDriveMediaDownload2 = this.c.c;
                    aaVar = this.c.c.f;
                    googleDriveMediaDownload2.k = aaVar.a();
                } catch (GoogleAuthException e2) {
                    ab.b("GoogleDriveMediaDL", "error listing contents", e2);
                    this.f4428a = Task.makeTaskError(e);
                    return null;
                } catch (IOException e3) {
                    ab.b("GoogleDriveMediaDL", "error listing contents", e3);
                    this.f4428a = Task.makeTaskError(e);
                    return null;
                }
            } catch (InterruptedException e4) {
                this.f4428a = Task.makeTaskError("Interrupted while authorizing for: " + e.getMessage(), e);
                return null;
            }
        } catch (GoogleAuthException e5) {
            ab.a("GoogleDriveMediaDL", "auth error listing contents", e5);
            this.f4428a = Task.makeTaskError(e5);
            return null;
        } catch (IOException e6) {
            ab.a("GoogleDriveMediaDL", "io error listing contents", e6);
            this.f4428a = Task.makeTaskError(e6);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ab.a("GoogleDriveMediaDL", "Begin list doInBackground : " + this.b);
        try {
            drive = this.c.c.c;
            Drive.Files.List q = drive.files().list().setQ(this.b);
            q.setFields2("nextPageToken,kind,nextLink,etag,selfLink,items(title,mimeType,createdDate,id,thumbnailLink,webContentLink,fileSize,downloadUrl,version,imageMediaMetadata)");
            ab.a("GoogleDriveMediaDL", "Made request : " + this.c.f4427a);
            do {
                ab.a("GoogleDriveMediaDL", "Execute request : " + this.c.f4427a);
                try {
                    FileList execute = q.execute();
                    String pageToken = q.getPageToken();
                    String nextPageToken = execute.getNextPageToken();
                    ab.a("GoogleDriveMediaDL", "Request completed : " + this.c.f4427a + " : count=" + execute.getItems().size() + " nextPageToken=" + String.valueOf(nextPageToken) + " curPageToken=" + String.valueOf(pageToken));
                    arrayList.addAll(execute.getItems());
                    if (pageToken != null && pageToken.equals(nextPageToken)) {
                        q.setPageToken("");
                        ab.a("GoogleDriveMediaDL", "ABORT: duplicate page token (for " + this.c.f4427a + ")");
                    } else {
                        q.setPageToken(execute.getNextPageToken());
                    }
                } catch (UserRecoverableAuthIOException e7) {
                    ab.a("GoogleDriveMediaDL", "recoverable error listing contents", e7);
                    activity2 = this.c.c.n;
                    activity2.startActivityForResult(e7.getIntent(), R.id.rqcode_gdrive_resolve_auth_err);
                    try {
                        synchronousQueue2 = this.c.c.l;
                        GoogleDriveMediaDownload.a aVar2 = (GoogleDriveMediaDownload.a) synchronousQueue2.take();
                        if (!aVar2.b) {
                            this.f4428a = aVar2.c;
                            if (this.f4428a == null) {
                                this.f4428a = Task.makeTaskError(e7);
                            }
                            return null;
                        }
                    } catch (InterruptedException e8) {
                        this.f4428a = Task.makeTaskError("Interrupted while authorizing for: " + e7.getMessage(), e7);
                        return null;
                    }
                } catch (IOException e9) {
                    ab.a("GoogleDriveMediaDL", "io error listing contents", e9);
                    q.setPageToken(null);
                    this.f4428a = Task.makeTaskError(e9);
                    return null;
                }
                if (q.getPageToken() == null) {
                    break;
                }
            } while (q.getPageToken().length() > 0);
            ab.a("GoogleDriveMediaDL", "End list doInBackground : " + this.c.f4427a);
            return arrayList;
        } catch (IOException e10) {
            this.f4428a = Task.makeTaskError(e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<File> list) {
        if (list == null) {
            ab.a("GoogleDriveMediaDL", "List onPostExecute (FAIL) : " + this.c.f4427a);
            this.c.b.sendFailure(this.f4428a);
        } else {
            ab.a("GoogleDriveMediaDL", "List onPostExecute (SUCCESS) : " + this.c.f4427a);
            this.c.b.sendResult(list);
        }
        super.onPostExecute(list);
    }
}
