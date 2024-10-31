package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class ab implements MediaInfo.d<aj, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f3490a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MediaInfo mediaInfo) {
        this.f3490a = mediaInfo;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.MediaInfo.d
    public void a(MediaInfo.c<aj, Void> cVar, NexEditor.b bVar) {
        ResultTask W;
        Deque deque;
        if (bVar == NexEditor.b.f) {
            deque = MediaInfo.B;
            deque.add(cVar);
        } else {
            MediaInfo.Z();
            W = ((MediaInfo.c) cVar).b.W();
            W.onResultAvailable(new ac(this, cVar));
        }
    }
}
