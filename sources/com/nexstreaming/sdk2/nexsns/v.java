package com.nexstreaming.sdk2.nexsns;

import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
public class v implements MediaHttpDownloaderProgressListener {

    /* renamed from: a */
    final /* synthetic */ u f4440a;

    public v(u uVar) {
        this.f4440a = uVar;
    }

    @Override // com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener
    public void a(MediaHttpDownloader mediaHttpDownloader) throws IOException {
        switch (mediaHttpDownloader.a()) {
            case MEDIA_IN_PROGRESS:
                ab.a("GoogleDriveMediaDL", " Progess : " + mediaHttpDownloader.b());
                return;
            case MEDIA_COMPLETE:
                ab.a("GoogleDriveMediaDL", "Download is complete!");
                ab.a("GoogleDriveMediaDL", "getting Thumbnail : Complete");
                this.f4440a.f4439a = null;
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
