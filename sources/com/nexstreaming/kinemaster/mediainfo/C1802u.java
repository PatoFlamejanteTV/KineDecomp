package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1802u implements MediaInfo.d<T, MediaInfo.f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f20757a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f20758b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ M f20759c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20760d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1802u(MediaInfo mediaInfo, File file, int i, M m) {
        this.f20760d = mediaInfo;
        this.f20757a = file;
        this.f20758b = i;
        this.f20759c = m;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.MediaInfo.d
    public void a(MediaInfo.c<T, MediaInfo.f> cVar, NexEditor.b bVar) {
        Executor executor;
        if (bVar != NexEditor.b.f24591b) {
            this.f20757a.delete();
            cVar.sendFailure(bVar);
        } else {
            MediaInfo.ha();
            AsyncTaskC1801t asyncTaskC1801t = new AsyncTaskC1801t(this, cVar);
            executor = MediaInfo.f20674d;
            asyncTaskC1801t.executeOnExecutor(executor, new Void[0]);
        }
    }
}
