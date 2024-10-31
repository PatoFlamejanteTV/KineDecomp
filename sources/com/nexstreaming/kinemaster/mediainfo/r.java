package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.util.Deque;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class r implements MediaInfo.d<aq, MediaInfo.f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f3511a;
    final /* synthetic */ int b;
    final /* synthetic */ ak c;
    final /* synthetic */ MediaInfo d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MediaInfo mediaInfo, File file, int i, ak akVar) {
        this.d = mediaInfo;
        this.f3511a = file;
        this.b = i;
        this.c = akVar;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.MediaInfo.d
    public void a(MediaInfo.c<aq, MediaInfo.f> cVar, NexEditor.b bVar) {
        Executor executor;
        Deque deque;
        Deque deque2;
        if (bVar == NexEditor.b.f4793a) {
            MediaInfo.aa();
            s sVar = new s(this, cVar);
            executor = MediaInfo.u;
            sVar.executeOnExecutor(executor, new Void[0]);
            return;
        }
        cVar.f3485a--;
        if (cVar.f3485a > 0) {
            deque = MediaInfo.z;
            deque.add(cVar);
            deque2 = MediaInfo.z;
            if (deque2.size() <= 1 && bVar != NexEditor.b.C) {
                MediaInfo.aa();
                return;
            }
            return;
        }
        this.f3511a.delete();
        cVar.sendFailure(bVar);
    }
}
