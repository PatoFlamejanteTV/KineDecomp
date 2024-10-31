package com.nexstreaming.sdk2.nexsns;

import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener;
import com.nexstreaming.sdk2.nexsns.GoogleDriveMediaDownload;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
public class q implements MediaHttpDownloaderProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f4435a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.f4435a = pVar;
    }

    @Override // com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener
    public void a(MediaHttpDownloader mediaHttpDownloader) throws IOException {
        if (this.f4435a.d.c.isCancelRequested()) {
            throw new GoogleDriveMediaDownload.DownloadCancelException();
        }
        switch (mediaHttpDownloader.a()) {
            case MEDIA_IN_PROGRESS:
                ab.a("GoogleDriveMediaDL", " Progess : " + mediaHttpDownloader.b());
                this.f4435a.publishProgress(Double.valueOf(mediaHttpDownloader.b()));
                return;
            case MEDIA_COMPLETE:
                ab.a("GoogleDriveMediaDL", "Download is complete!");
                this.f4435a.f4434a = null;
                return;
            case NOT_STARTED:
                ab.a("GoogleDriveMediaDL", "NOT_STARTED!");
                return;
            default:
                ab.a("GoogleDriveMediaDL", "default!");
                return;
        }
    }
}
